class Solution {
    public int ladderLength(String begin, String end, List<String> list) {
        Set<String> set = new HashSet<>(list);
        if (!set.contains(end)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int level = 1;

        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                String w = q.poll();
                if (w.equals(end)) return level;

                char[] arr = w.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String next = new String(arr);
                        if (set.contains(next)) {
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    arr[i] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
