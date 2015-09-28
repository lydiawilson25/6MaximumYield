

public class MaximumYield {

    public static void main(String[] args){
        String str = " 206, 140, 300, 52, 107";
        inputFormat(str);
    }

    public static void inputFormat(String s){

        String[] parts = s.replaceAll(" ","").split(",");
        int[] mines = new int[parts.length];
        int len = parts.length;
        for(int i=0;i<parts.length;i++){
            mines[i]=Integer.parseInt(parts[i]);
        }
        int maxsum = findOptimal(mines, len);
        System.out.println(maxsum);
    }

    public static int findOptimal(int[] a, int n){
        int include = a[0], exclude = 0;
        for (int i = 1; i < n; i++) {
            int oldinclude = include;
            include = Math.max(include, exclude + a[i]);
            exclude = oldinclude;
        }
        return Math.max(include, exclude);
    }
}
