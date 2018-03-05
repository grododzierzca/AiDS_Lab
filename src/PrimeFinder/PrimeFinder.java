package PrimeFinder;

public class PrimeFinder {

    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }else if(n==2){
            return true;
        }else if(n%2!=0){
            for(int i = 3; i <= Math.floor(Math.sqrt((double)n)); i+=2){
                if(n%i==0){
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }

    }

}
