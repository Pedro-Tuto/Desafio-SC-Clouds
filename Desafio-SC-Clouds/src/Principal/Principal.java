package Principal;

import javax.swing.*;
import java.util.*;

public class Principal {

    public static long linear(int n){
    
        if (n < 2) {
            return n;
        }
        
        long primeiro = 0;
        long segundo = 1;
        long resultado = 1;
        
        for (int i = 2; i <= n; i++) {
            resultado = primeiro + segundo;
            primeiro = segundo;
            segundo = resultado;
        }
        return resultado;

    }
    
   public static long recursiva(int n, long[] lista){       
       if (n < 2){
           lista[n] = n;
       }else {
           lista[n] = recursiva(n-1, lista) + lista[n-2];
       }
       
       return lista[n];

   }
    
   public static void fibonacci(){
        Object[] selectionValues = {"Linear", "Recursiva", "Sair"};
        Object question = JOptionPane.showInputDialog(null, "Selecione o tipo de função: ", "Sequência de Fibonacci", JOptionPane.QUESTION_MESSAGE, null, selectionValues, "Recursiva");
        String variable = JOptionPane.showInputDialog("Digite um número inteiro positivo: ");

        System.out.println(question.toString());
        System.out.println("Validando o número");

        try {
            int N = Integer.parseInt(variable);
            if (N <= 0) {
                JOptionPane.showMessageDialog(null, "Número não positivo.");
            } else {
                long resultado;
                switch (question.toString()) {
                    case "Linear":
                        resultado = linear(N);
                        JOptionPane.showMessageDialog(null, resultado);
                        break;
                    case "Recursiva":
                        long[] lista = new long[N + 1];
                        lista[0] = 0;
                        resultado = recursiva(N, lista);
                        JOptionPane.showMessageDialog(null, resultado);
                    case "Sair":
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Número não inteiro.");
        }
    }
    

    public static ArrayList<Integer> linearPrimos(int n){
        int[] lista = new int[n+1];       
        for(int i = 0; i <= n; i++){
            lista[n] = 0;
        }
        lista[0] = 1;
        lista[1] = 1;
        for(int i = 2; i <= n; i++){
            if (i*i > n) {
                break;
            }
            if(lista[i]==0){
                for(int j = i*i; j<= n; j += i){
                    lista[j] = 1;
                }
            }           
        }
        
        ArrayList<Integer> resultado = new ArrayList<Integer>();  
        for(int i = 2; i <= n; i++){
            if(lista[i] == 0){
                resultado.add(i);
            }
        }
         return resultado;   
    }
    
    public static boolean checkPrimo(int n, int i){
        if (n == 2){
            return true;
        } else if (n < 2) {
            return false;
        }
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;
        return checkPrimo(n, i + 1);
        
        //13, 2
        //13, 3
        //13, 4
        
    }
   
    
    public static ArrayList<Integer> recursivaPrimos(int n){
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        for(int i=0; i<=n; i++){
            if(checkPrimo(i, 2)){
                resultado.add(i);
            }
        }
        return resultado;        
    }
   
    public static void primos(){
        
        Object[] selectionValues = {"Linear", "Recursiva", "Sair"};
        Object question = JOptionPane.showInputDialog(null, "Selecione o tipo de função: ", "Números Primos", JOptionPane.QUESTION_MESSAGE, null, selectionValues, "Recursiva");
        String variable = JOptionPane.showInputDialog("Digite um número inteiro positivo: ");
        
        System.out.println("Validando o número");
        
        try {
            int N = Integer.parseInt(variable);
            if (N <= 0) {
                JOptionPane.showMessageDialog(null, "Número não positivo.");
            } else {
                ArrayList<Integer> resultado = new ArrayList<Integer>();
                String stringResult = "";
                switch (question.toString()) {
                    case "Linear":
                        resultado = linearPrimos(N);
                    case "Recursiva":
                        resultado = recursivaPrimos(N);
                    case "Sair":
                        break;
                }
                for(Integer s : resultado) {
                    stringResult += s + ", ";
                }
                JOptionPane.showMessageDialog(null,"Números primos até " + N + " são: " + stringResult);    
            }
        }catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Número não inteiro.");
        }
}
        
    public static void main(String[] args) {        
        boolean isActive = true;
        
        while(isActive){
            Object[] selectionValues = {"Calcular Primos", "Calcular Fibonacci", "Sair"};
            Object question = JOptionPane.showInputDialog(null, "Selecione o tipo de função: ", "Opções", JOptionPane.QUESTION_MESSAGE, null, selectionValues, "Calcular Fibonacci");        
        
           if(question == "Calcular Fibonacci"){
               fibonacci();
           }else if(question == "Calcular Primos"){
               primos();    
           }else{
               isActive = false;
           }
        }
    }
}
