function fibStream(fibIndex) {
    let arr = [0, 1];
    for(let i = 2; i <= fibIndex; i++) {
        arr.push(arr[i-1] + arr[i-2]);
    }
    return arr[fibIndex];
}
// 0 1 1 2 3 5 8 13 21 34 55
function fibRec(fibIndex) {//8
    if(fibIndex < 0) {
        throw new Error("Invalid index");
    }

    if(fibIndex === 0) {
        return 0;
    }

    if(fibIndex === 1 || fibIndex === 2) {
        return 1;
    }

    return fibRec(fibIndex - 2) + fibRec(fibIndex -1);
}