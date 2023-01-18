public class BinarySearchTree{
    class Node{
        String value/*, password, situs*/;
        Node left, right;

        public Node(String value/*, String password, String situs*/){
            this.value=value;
            /*this.password=password;
            this.situs=situs;*/
            left=right=null;
        }
    }
    
    Node root;
    public BinarySearchTree(){
        root=null;
    }

    public Node insert(Node root, String value/*, String password, String situs*/){
        if(root==null){
            root=new Node(value/*,password,situs*/);
            return root;
        }
        int leftCheck=value.compareTo(root.value);
        if(leftCheck<0){
            root.left=insert(root.left, value/*, password, situs*/);
            
        } 
        else{
            root.right=insert(root.right, value/*, password, situs*/);
        }
        return root;
    }

    public void insert(String value/*, String password, String situs*/){
        root=insert(root,value/*,password,situs*/);
    }

    //traversal tree (baca tree) -> inorder
    //kiri -> root-> kanan
    int c;
    public void inorder(Node root/*, String password, String situs*/){
        if(root!=null){
            inorder(root.left);
            System.out.println("Username ke-"+(c++)+": "+root.value);
            inorder(root.right);
        }
    }

    public void inorder(){
        c=1;
        if(root==null){
            System.out.print("Belum ada akun yang ditambahkan\n\n");
        }
        else{
            inorder(root);
        }
    }

    //delete (cari nilai terkecil di subtree kanan)
    public Node delete(Node root, String value){
        if (root==null){
            return root;
        }
        int smallerCheck=value.compareTo(root.value);
        if (smallerCheck<0){
            root.left=delete(root.left, value);
        } 
        else if (smallerCheck>0){
            root.right=delete(root.right, value);
        }
        else{
            // 1 anak
            if (root.left==null) {
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }
            //2 anak
            root.value=findMinimum(root.right);
            root.right=delete(root.right, root.value);
        }
        return root;
    }

    public void delete(String value){
        root=delete(root,value);
    }

    public String findMinimum(Node root){
        String min=root.value;
        while(root.left!=null){
            min=root.left.value;
            root=root.left;
        }
        return min;
    }
  
    boolean search(String value)  { 
        root=search(root, value); 
        if (root!=null)
            return true;
        else
            return false;
    } 
   
    Node search(Node root, String value)  { 
        if (root==null) 
            return root; 
        int smallerCheck=value.compareTo(root.value);
        if (smallerCheck<0) 
            return search(root.left, value); 
        if (smallerCheck>0){
            return search(root.right, value); 
        }
        return root;
    }
}