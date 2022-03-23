import java.io.*;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class BST {
    Node root;
    BufferedWriter out;

    BST() throws IOException {
        root = null;
    }

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //initialize binary search tree
        Assign3 searchTree = new Assign3();

        //read input file
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            if (str.charAt(0) == 'I') {
                searchTree.InsertNode(str.substring(1));
            }
            if (str.charAt(0) == 'D') {
                searchTree.DeleteNode(str.substring(1));
            }
        }
        searchTree.BFSprintorder();
        searchTree.DFSprintInorder();


    }

    boolean Compare(String stu1, String stu2) {
        try {
            if (stu1.toLowerCase().charAt(7) < stu2.toLowerCase().charAt(7)) {
                return true;
            } else if (stu1.toLowerCase(Locale.ROOT).charAt(7) > stu2.toLowerCase(Locale.ROOT).charAt(7)) {
                return false;
            } else if (stu1.toLowerCase(Locale.ROOT).charAt(7) == stu2.toLowerCase(Locale.ROOT).charAt(7)) {
                Compare(stu1.substring(1), stu2.substring(1));
            }

        } catch (Exception e) {
            System.out.println("Something wrong with students' name!");
        }
        return false;
    }

    Node Recursion_Inserstion(Node root, String student) {
        if (root == null) {
            root = new Node(student);
            return root;
        }

        if (Compare(root.data, student)) {
            if (root.left != null) {
                root.left = Recursion_Inserstion(root.left, student);
            } else {
                Node newnode = new Node(student);
                root.left = newnode;
            }
        } else {
            if (root.right != null) {
                root.right = Recursion_Inserstion(root.right, student);
            } else {
                Node newnode = new Node(student);
                root.right = newnode;
            }
        }
        return root;

    }

    String Maxval(Node root) {
        String minival = root.data;

        if (root.left != null) {
            minival = root.left.data;
            root = root.left;
        }
        return minival;
    }

    Node Recursion_Delete(Node root, String student) {
        if (root == null) {
            return root;
        }
        if (root.data.equals(student)) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = Maxval(root.right);
            root.right = Recursion_Delete(root.right, root.data);

        }
        if (Compare(root.data, student)) {

            if (root.left != null) {
                root.left = Recursion_Delete(root.left, student);
            }
        } else {

            if (root.right != null) {
                root.right = Recursion_Delete(root.right, student);
            }

        }

        return root;
    }

    void InsertNode(String student) {
        root = Recursion_Inserstion(root, student);
    }

    void DeleteNode(String student) {
        root = Recursion_Delete(root, student);
    }

    void DFSprint(Node node) throws IOException {

        if (node != null) {
            System.out.println(node.data);
            out.write(node.data + "\n");

            DFSprint(node.left);
            DFSprint(node.right);
        }

    }

    void DFSprintInorder() throws IOException {
        out = new BufferedWriter(new FileWriter("output1.txt"));
        DFSprint(root);
        out.close();
    }

    void BFSprintorder() throws IOException {
        BFSprint(root);
    }

    void BFSprint(Node root) throws IOException {
        BufferedWriter out1 = new BufferedWriter(new FileWriter("output2.txt"));
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            out1.write(node.data + "\n");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        out1.close();
    }

    static class Node {
        Node left, right;
        String data;

        Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}



