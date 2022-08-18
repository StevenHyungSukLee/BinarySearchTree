/*
THIS CODE WAS MY OWN WORK , IT WAS WRITTEN WITHOUT CONSULTING
CODE WRITTEN BY OTHER STUDENTS. HyungSuk Lee
*/
public class BSTIndex {
    
    private Node root;
    public class Node{
        String key;
        MovieInfo data;
        Node left;
        Node right;

        public Node(String key, MovieInfo info){
            this.key = key;
            this.data = info;
        }
    }
    public BSTIndex(){
        root = null;
    }
    public MovieInfo findExact(String key){
        Node x = root;
        while(x!= null){

            //chage key and x.key to upper case so that the search would be case insensitive.
            key = key.toUpperCase();
            x.key = x.key.toUpperCase();

            if(key.compareTo(x.key)<0){

                x = x.left; //if the input key is smaller than current key, move to the left which is smaller

            }else if(key.compareTo(x.key)>0){

                x = x.right; //if the input key is larger than current key, move to the right which is larger
            }else{

                return x.data; //if the input key is matched to the current key, return the stored data
            }
        }
        return null; //if there is no key that match to input key, return null.
    }

    public MovieInfo findPrefix(String prefix){

        prefix = prefix.substring(0,prefix.indexOf("*")); //the input would be end with "*" so make a substring and use it as the prefix for searching
        Node x = root;

        while(x!=null){
            //chage prefix and x.key to upper case so that the search would be case insensitive.
            prefix = prefix.toUpperCase();
            x.key = x.key.toUpperCase();

            if(x.key.startsWith(prefix)){//By using a startWith method in String class, check if the current node's key start with the given prefix
                                            //If the current node x's key start with the given prefix, return the data
                return x.data;
                
            }else{
                if(prefix.compareTo(x.key)<0){
                    x = x.left;
                }else if(prefix.compareTo(x.key)>0){
                    x = x.right;
                }else{
                    return x.data;
                }
            }
        }
        return null;
    }

    public void insert (MovieInfo data){
        root = insert(root, data);
    }

    public Node insert(Node x, MovieInfo data){
        if(x == null){
            return new Node(data.shortName, data); //if the node hit the bottome of the tree, create a new node and place it
        }
        if(data.shortName.compareTo(x.key) < 0){
            x.left = insert(x.left, data);
        }else if(data.shortName.compareTo(x.key) > 0){
            x.right = insert(x.right, data);
        }else{
            x.data = data;
        }
        return x;
    }
}
