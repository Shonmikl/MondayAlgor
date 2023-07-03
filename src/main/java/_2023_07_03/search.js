const fs = require('fs');
const path = require('path');

function getFiles(rootPath, fileList) {
    if(fs.statSync(rootPath).isDirectory()) {
        console.log('searching...... ' + rootPath);
        const directoryFiles = fs.readdirSync(rootPath);
        for(const file of directoryFiles) {
            const filePath = path.join(rootPath, file);
            if(fs.statSync(filePath).isDirectory()) {
                getFiles(filePath, fileList);
            } else {
                if(file.toLowerCase().endWith('.pdf')) {
                    fileList.push(filePath);
                }
            }
        }
    }
}

function main() {
    const rootPath = " ? ";
    const fileList = [];
    getFiles(rootPath, fileList);
    console.log(fileList);
}

main();
