
class Solution {
    public String decodeString(String s) {
        Stack<Integer> c = new Stack<>();
        Stack<String> st = new Stack<>();
        String res = "";
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) num = num * 10 + ch - '0';
            else if (ch == '[') { c.push(num); st.push(res); num = 0; res = ""; }
            else if (ch == ']') {
                String temp = st.pop();
                for (int i = c.pop(); i > 0; i--) temp += res;
                res = temp;
            } else res += ch;
        }
        return res;
    }
}
 
