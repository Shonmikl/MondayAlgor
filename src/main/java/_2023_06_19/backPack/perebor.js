function findOptimalBP() {
    //2-5 предмет или 1-4 по индексам
    const weights = {3,4,5,8,9};
    const prices = {1,6,4,7,6};
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
        }
    }

    //Запустить рекурсивно функцию для поиска оптимальной комбинации

    //Вывести на экран оптимальное содержимое рюкзака
}