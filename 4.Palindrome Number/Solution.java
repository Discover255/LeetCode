class Solution {
    
    private class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
    
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        x = Math.abs(x);
        int unit = Math.abs(x % 10);
        int ready = Math.abs(x / 10);
        int cnt = 1;
        Node root = null;
        for (; ready > 0; unit = ready % 10, ready = ready / 10, cnt++) {
            Node tmp = new Node(unit);
            tmp.next = root;
            root     = tmp;
        }
        System.out.println("分割");


        Node tmp = new Node(unit);
        tmp.next = root;
        root     = tmp;//是否可以不重复？



        unit  = Math.abs(x % 10);//重新提取
        ready = Math.abs(x / 10);
        int halflength = (int)((cnt + 1) / 2);
        System.out.println(halflength);
        for (int i = 1; i <= halflength; i++) {
            int rootval = root.val;
            root = root.next;
            if (rootval != unit) return false;
            unit = ready % 10;
            ready = ready / 10;
        }
        return true;
    }
}