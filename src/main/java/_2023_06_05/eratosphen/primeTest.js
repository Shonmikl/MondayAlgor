function isPrime(number) {
  if (number < 2) {
    return false;
  }

  for (let i = 2; i * i <= number; i++) {
    if (number % i === 0) {
      return false;
    }
  }

  return true;
}

function isPrimeOptimized(number) {
  if (number < 2) {
    return false;
  }
  if (number % 2 === 0) {
    return number === 2;
  }
  if (number % 3 === 0) {
    return number === 3;
  }

  for (let i = 5; i * i <= number; i += 6) {
    if (number % i === 0 || number % (i + 2) === 0) {
      return false;
    }
  }

  return true;
}

for (let i = 1; i < 1000; i++) {
  if (isPrime(i)) {
    console.log(i);
  }
}

for (let i = 1; i < 1000; i++) {
  if (isPrimeOptimized(i)) {
    console.log(i);
  }
}