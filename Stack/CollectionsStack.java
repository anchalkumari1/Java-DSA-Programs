import java.util.Stack;

class CollectionsStack{
    public static void main(String[] args) {
        Stack<Integer> nums = new Stack<Integer>();

        nums.push(54);
        nums.push(44);
        nums.push(34);
        nums.push(12);
        nums.push(23);
        System.out.println("Initial Stack: " + nums);

        int element = nums.pop();
        System.out.println("Removed Element: " + element);
        System.out.println("Top Element: " + nums.peek());
        System.out.println("Size of Stack: " + nums.size());
    }
}