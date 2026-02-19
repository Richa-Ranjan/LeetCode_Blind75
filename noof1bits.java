public class noof1bits {
    public static int Noof1bits(int n){
        int ones=0;
        while(n!=0){
            ones=ones+(n&1);
            n=n>>>1;
        }
        return ones;
    }
    public static void main(String[] args) {

        int n = 11; // 1011
        System.out.println(Noof1bits(n)); // Output: 3

    }
}