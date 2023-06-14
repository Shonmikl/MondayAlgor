function getIntRadix(number, radix) {
	const digits = getDigitTable();

	if(radix < 2 || radix >= digits.length || number <=0) {
		throw new Error('Invalid arguments');
	}

	let valueStr = '';

	while(number > 0) {
		valueStr = digits[number % radix] + valueStr;
		number = Math.floor(number / radix);
	}

	return valueStr;
}


function getDigitTable() {
	const digits = [];

	for (let i = '0'.charCodeAt(0); i <= '9'.charCodeAt(0); i++) {
		digits.push(String.fromCharCode(i)); //10
	}

	for (let i = 'a'.charCodeAt(0); i <= 'z'.charCodeAt(0); i++) {
		digits.push(String.fromCharCode(i)); //25
	}
	return digits;
}