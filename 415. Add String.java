class Solution {
    public String addStrings(String a, String b) {
        StringBuilder s = new StringBuilder();
        int i = a.length() -1, j = b.length()-1, c=0;

        while (i>=0 || j>=0 || c>0){
            int sum = c;
            if(i>=0) sum += a.charAt(i--) - '0';
            if(j>=0) sum += b.charAt(j--) - '0';
            s.append(sum % 10);
            c= sum/10;
        }
        return s.reverse().toString();
    }
}
