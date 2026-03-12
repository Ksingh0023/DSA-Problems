class Solution {
    public int thirdMax(int[] nums) {

        Long a=null,b=null,c=null;

        for(int n:nums){
            if((a!=null&&n==a)||(b!=null&&n==b)||(c!=null&&n==c)) continue;

            if(a==null||n>a){ c=b; b=a; a=(long)n; }
            else if(b==null||n>b){ c=b; b=(long)n; }
            else if(c==null||n>c){ c=(long)n; }
        }

        return c==null ? a.intValue() : c.intValue();
    }
}
