function eratosfenPrimes(max) {
    let isPrime = new Array(max).fill(true);
    let primes = [];

    for (let i = 2; i * i < max; i++) {
        if (isPrime[i]) {
            for (let j = 2 * i; j < max; j += i) {
                isPrime[j] = false;
            }
        }
    }

    for (let i = 2; i < max; i++) {
        if (isPrime[i]) {
            primes.push(i);
        }
    }

    return primes;
}

console.log(eratosfenPrimes(1000));