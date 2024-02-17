package CapaDeNegocio;

public class Calculadora {

    private Float x;
    private PilaNumeros pilaN;
    private PilaOperador pilaOp;
    private Operador operador;
    private String[] posfijo;
    private char[] cadena;

    public Calculadora() {
        pilaN = new PilaNumeros();
        pilaOp = new PilaOperador();
        operador = new Operador();
    }

    //Cambia la cadena por un arreglo de caracteres
    public char[] expresionToCharArr(String operacion) {
        cadena = operacion.toCharArray();
        return cadena;
    }

    // Convertir infijo a posfijo
    public String[] infijoAPosfijo(char[] cadena) {
        int i = 0;
        int j = 0;

        posfijo = new String[cadena.length];
        while (i < cadena.length) {
            // cuando es operando, números
            if (!operador.esOperador(Character.toString(cadena[i]))) {
                posfijo[j] = "";
                while (!operador.esOperador(Character.toString(cadena[i]))) {
                    posfijo[j] = posfijo[j] + cadena[i] + "";
                    i++;
                    if (i == cadena.length) {
                        break;
                    }
                }
                j++;
                // cuando es operador, +-*/
            } else if (operador.esOperador(Character.toString(cadena[i]))) {
                if (pilaOp.estaVacia()) {
                    pilaOp.push(cadena[i]);
                    i++;
                } else if (operador.evaluarPrioridad(pilaOp.topePila(), cadena[i]) == 0) {
                    pilaOp.push(cadena[i]);
                    i++;
                } else if (operador.evaluarPrioridad(pilaOp.topePila(), cadena[i]) == 1) {
                    posfijo[j] = Character.toString(pilaOp.pop());
                    j++;
                } else if (operador.evaluarPrioridad(pilaOp.topePila(), cadena[i]) == 2) {
                    pilaOp.pop();
                    i++;
                }
            }
        }
        if (i == cadena.length) {
            while (!pilaOp.estaVacia()) {
                posfijo[j] = Character.toString(pilaOp.pop());
                j++;
            }
        }
        return posfijo;
    }

    public String calcular(String[] posfijo) {
        int i = 0;
        String salida;
        while (i < posfijo.length) {
            if (posfijo[i] == null) {
                break;
            } else if (!operador.esOperador(posfijo[i])) {
                pilaN.push(Float.parseFloat(posfijo[i]));
            } else if (operador.esOperador(posfijo[i])) {
                float a = pilaN.pop();
                if (!"c".equals(posfijo[i])) {
                    float b = pilaN.pop();
                    switch (posfijo[i]) {
                        case "+":
                            x = a + b;
                            break;
                        case "-":
                            x = b - a;
                            break;
                        case "/":
                            x = b / a;
                            break;
                        case "*":
                            x = b * a;
                            break;
                        case "^":
                            x = (float) Math.pow(b, a);
                            break;
                    }
                } else {
                    a = (float) Math.toRadians(a);
                    x = (float) Math.cos(a);//devuelve en radianes
                }
                pilaN.push(x);
            }
            i++;
        }
        if (Float.isInfinite(pilaN.topePila())) {
            salida = "No hay division por 0";
        } else {
            salida = "" + pilaN.topePila();
        }
        return salida;
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        char[] infijo = calc.expresionToCharArr("c2");
        String[] posfijo = calc.infijoAPosfijo(infijo);
        System.out.println("Resultado: " + calc.calcular(posfijo));
    }
}
