            function limite1(valor) {
                quant = 140;
                total = valor.length;
                if (total <= quant) {
                    resto = quant - total;
                    document.getElementById('cont1').innerHTML = resto;
                } else {
                    document.getElementById('texto1').value = valor.substr(0, quant);
                }
            }

    function limite2(valor) {
                quant = 140;
                total = valor.length;
                if (total <= quant) {
                    resto = quant - total;
                    document.getElementById('cont2').innerHTML = resto;
                } else {
                    document.getElementById('texto2').value = valor.substr(0, quant);
                }
            }

    function limite3(valor) {
                quant = 140;
                total = valor.length;
                if (total <= quant) {
                    resto = quant - total;
                    document.getElementById('cont3').innerHTML = resto;
                } else {
                    document.getElementById('texto3').value = valor.substr(0, quant);
                }
            }

    function limite4(valor) {
                quant = 140;
                total = valor.length;
                if (total <= quant) {
                    resto = quant - total;
                    document.getElementById('cont4').innerHTML = resto;
                } else {
                    document.getElementById('texto4').value = valor.substr(0, quant);
                }
            }