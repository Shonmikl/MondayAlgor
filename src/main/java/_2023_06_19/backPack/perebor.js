function findOptimalBP() {
    //2-5 предмет или 1-4 по индексам
    const weights = {3,4,5,8,9};//2^n
    const prices =  {1,6,4,7,6};
    const maxWeight = 13;

    let maxPrice = 0;
    let optimalItems = [];

    function findCombination(currentIndex, currentWeight, currentPrice, selectedItems) {
        if(currentIndex === weights.length) {
            if(currentWeight <= maxWeight && currentPrice > maxPrice) {
                maxPrice = currentPrice;
                optimalItems = selectedItems.slice();
            }
            return;
        }

        if(currentWeight + weights[currentIndex] <= maxWeight) {
            selectedItems.push(currentIndex);
            findCombination(currentIndex+1, currentWeight+weights[currentIndex], currentPrice + prices[currentIndex], selectedItems);
            //удаляем последний выбранный предмет для исследования других комбинаций
        }

        //Пропустить текущий предмет в комбинации
        findCombination(currentIndex + 1, currentWeight, currentPrice, selectedItems);
        }
    }

    //Запустить рекурсивно функцию для поиска оптимальной комбинации
    findCombination(0, 0, 0, []);

    //Вывести на экран оптимальное содержимое рюкзака
    console.log("Оптимальное содержимое рюкзака:");
    optimalItems.forEach((itemIndex) => {
    console.log(itemIndex);
}