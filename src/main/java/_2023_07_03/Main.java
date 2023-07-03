package _2023_07_03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String text = "The technique works by creating a binary tree of nodes. " +
                "These can be stored in a regular array, the size of which " +
                "depends on the number of symbols," +
                "A node can be either a leaf node or an internal node. " +
                "Initially, all nodes are leaf nodes, which contain the symbol " +
                "itself, the weight (frequency of appearance) of the symbol " +
                "and optionally, a link to a parent node which makes it easy " +
                "to read the code (in reverse) starting from a leaf node. " +
                "Internal nodes contain a weight, links to two child nodes " +
                "and an optional link to a parent node. As a common convention, " +
                "bit '0' represents following the left child and bit '1' " +
                "represents following the right child. A finished tree has up to " +
                "n leaf nodes and −1 n-1 internal nodes. " +
                "A Huffman tree that omits unused symbols " +
                "produces the most optimal code lengths.";

        String test = "AAAAAASSSSSDDDDFFFGGH";

        //Вычислим количество символов в тексте
        TreeMap<Character, Integer> frequencies = countFrequency(test);

        //Генерируем список узлов нашего дерева
        List<CodeTreeNode> codeTreeNodes = new ArrayList<>();
        for (Character c : frequencies.keySet()) {
            codeTreeNodes.add(new CodeTreeNode(c, frequencies.get(c)));
        }

        //Строим кодовое дерево с помощью Хаффмана
        CodeTreeNode tree = huffman(codeTreeNodes);
        TreeMap<Character, String> codes = new TreeMap<>();
        for (Character c : frequencies.keySet()) {
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }

        System.out.println("Codes table: " + codes);

        //Кодируем текст
        StringBuilder encoded = new StringBuilder();
        for (int i = 0; i < test.length(); i++) {
            encoded.append(codes.get(test.charAt(i)));
        }

        System.out.println("Original text size: " + test.getBytes().length * 8 + " bit");
        System.out.println("Compressed text: " + encoded.length() + " bit");
        System.out.println("Compressed text bit's: " + encoded);

        //Раскодируем
        String decoded = huffmanDecode(encoded.toString(), tree);
        System.out.println("Decoded string: " + decoded);

    }

    //1. Считаем, сколько раз каждый символ встречается в тексте
    private static TreeMap<Character, Integer> countFrequency(String text) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            Character c = text.charAt(i);
            Integer count = freqMap.get(c);
            freqMap.put(c, count != null ? count + 1 : 1);
        }
        return freqMap;
    }

    //2. Класс для предоставления кодового дерева
    private static class CodeTreeNode implements Comparable<CodeTreeNode> {
        //Хранить символ
        Character content;

        int weight;
        CodeTreeNode left;
        CodeTreeNode right;

        public CodeTreeNode(Character content, int weight) {
            this.content = content;
            this.weight = weight;
        }

        public CodeTreeNode(Character content, int weight, CodeTreeNode left, CodeTreeNode right) {
            this.content = content;
            this.weight = weight;
            this.left = left;
            this.right = right;
        }


        //a.compareTo(o)
        @Override
        public int compareTo(CodeTreeNode o) {
            return o.weight - this.weight;
        }

        //5. Функция, которая делает проход по кодовому дереву
        private String getCodeForCharacter(Character ch, String parentPath) {
            if (content == ch) {
                return parentPath;
            } else {
                if (left != null) {
                    String path = left.getCodeForCharacter(ch, parentPath + 0);
                    if (path != null) {
                        return path;
                    }
                }
                if (right != null) {
                    return right.getCodeForCharacter(ch, parentPath + 1);
                }
            }
            return null;
        }
    }

    //3. Алгоритм шифрования
    private static CodeTreeNode huffman(List<CodeTreeNode> codeTreeNodes) {
        while (codeTreeNodes.size() > 1) {
            Collections.sort(codeTreeNodes); //[] D5 [5]
            CodeTreeNode right = codeTreeNodes.remove(codeTreeNodes.size() - 1);
            CodeTreeNode left = codeTreeNodes.remove(codeTreeNodes.size() - 1);

            CodeTreeNode parent = new CodeTreeNode(null, left.weight + right.weight, left, right);
            codeTreeNodes.add(parent);
        }
        return codeTreeNodes.get(0);
    }

    //4. Декодируем
    private static String huffmanDecode(String encoded, CodeTreeNode tree) {
        StringBuilder decoded = new StringBuilder();
        CodeTreeNode node = tree;
        for (int i = 0; i < encoded.length(); i++) {
            node = encoded.charAt(i) == '0' ? node.left : node.right;
            if (node.content != null) {
                decoded.append(node.content);
                node = tree;
            }
        }
        return decoded.toString();
    }
}