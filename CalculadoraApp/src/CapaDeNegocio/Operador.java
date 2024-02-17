package CapaDeNegocio;

public class Operador {

    PilaOperador pila;
    String operador;
    int i;
    int j;

    public Operador() {
        pila = new PilaOperador();
        operador = "";
        i = 0;
        j = 0;
    }

    public int evaluarPrioridad(char topePila, char operador) {
        int temp = 1;
        if (null != Character.toString(topePila)) {
            switch (Character.toString(topePila)) {
                case "+":
                case "-":
                    if (null != Character.toString(operador)) {
                        switch (Character.toString(operador)) {
                            case "+":
                            case "-":
                            case ")":
                                temp = 1;
                                break;
                            case "*":
                            case "/":
                            case "c":
                            case "^":
                            case "(":
                                temp = 0;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case "*":
                case "/":
                    if (null != Character.toString(operador)) {
                        switch (Character.toString(operador)) {
                            case "+":
                            case "-":
                            case "*":
                            case "/":
                            case ")":
                                temp = 1;
                                break;
                            case "c":
                            case "^":
                            case "(":
                                temp = 0;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case "c":
                case "^":
                    if (null != Character.toString(operador)) {
                        switch (Character.toString(operador)) {
                            case "+":
                            case "-":
                            case "*":
                            case "/":
                            case "c":
                            case "^":
                            case ")":
                                temp = 1;
                                break;
                            case "(":
                                temp = 0;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case "(":
                    if (null != Character.toString(operador)) {
                        switch (Character.toString(operador)) {
                            case "+":
                            case "-":
                            case "*":
                            case "/":
                            case "c":
                            case "^":
                            case "(":
                                temp = 0;
                                break;
                            case ")":
                                temp = 2;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        return temp;
    }

    //Evalua si es u operador
    public static boolean esOperador(String letra) {
        return "=".equals(letra) || "^".equals(letra) || "/".equals(letra)
                || "*".equals(letra) || "+".equals(letra) || "-".equals(letra)
                || "(".equals(letra) || ")".equals(letra) || "c".equals(letra);
    }
}
