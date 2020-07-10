var readline = require('readline');

var userInput = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

userInput.question("Digite um número para obter uma lista de todos os números primos menores ou igual ao número informado e a soma de todos eles.\n", function(answer) {
    var numb1 = parseInt(answer);
    var arrayOfNumber = [];
    var arrayOfPrimeNumbers = [];
    for (let i = 0; i <= numb1; i++) {
        arrayOfNumber.push(i);
    }

    for (let i = 0; i < arrayOfNumber.length; i++) {
        const numb2 = arrayOfNumber[i];
        var counter = 0;
        for (let j = 0; j <= numb2; j++) {
            if (numb2 % j == 0) { counter++ }
        }
        if ((counter == 2)) {
            arrayOfPrimeNumbers.push(arrayOfNumber[i])
        }
    }

    console.log("\nA lista de números primos menores que '" + numb1 + "' é  ");
    console.log(arrayOfPrimeNumbers);
    console.log("\nA soma doos números primos menores ou igual a '" + numb1 + "' é '" + arrayOfPrimeNumbers.reduce(function(previusValue, arrayValue) { return previusValue + arrayValue; }, 0) + "' ")
    userInput.close();
});