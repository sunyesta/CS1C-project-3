package stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackList <T> implements Iterable<T>{

    private String name;
    private Node top = null;
    private int size = 0;

    public StackList(String name){
        this.name = name;
    }

    @Override
    public Iterator<T> iterator(){
        return new StackIterator();
    }

        // takes a generic item as the argument and adds the item to the top of the stack.
    public void push(T item){
        Node newNode = new Node(item);
        top = newNode;
        size++;
    }

    // receives no arguments and removes the item from the top of the stack. This method should return the generic item popped.
    public T pop(){
        //TODO: does this remove the garbage node?
        Node removedNode = top;
        top = top.nextNode;
        size--;
        return removedNode.getData();
    }

    // looks at the top of the stack and returns a generic type for the data seen at the top of the stack. The item should not be removed from the top of the stack.
    //NOTE: If the stack is empty, returns null.
    public T peek(){
        return top.getData();
    }

    //discards all object references from the linked-list to "empty" this StackList instance.
    public void clear(){
        top = null;
        size = 0;
    }

    // include the name of the stack passed in by the Navigator class in addition to the number of links in the stack.
    public String toString(){
        return  name + ":\n\tNode Count = " + size()+"\n\tNodes: "+getNodeList();
    }

    // checks if the top of the stack is pointing to anything.
    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    //returns the number of elements in the stack.
    public int size(){
        return size;
    }

    public String getNodeList(){
        String nodeList = "[";
        Iterator iterator = this.iterator();
        if(iterator.hasNext()){
            while (iterator.hasNext()){
                nodeList += iterator.next()+", ";
            }
            //if nodes are added the last comma gets erased
            nodeList = nodeList.substring(0,nodeList.length()-2);
        }

        nodeList += "]";

        return nodeList;
    }

    class Node{
        private T data;
        private Node nextNode;

        public Node(T data){
            this.data = data;
            this.nextNode = top;
        }

        public Node getNextNode(){
            return nextNode;
        }

        public T getData(){
            return data;
        }
    }


    class StackIterator implements Iterator{

        Node currentNode = null;
        @Override
        public boolean hasNext() {


            if(currentNode==null && top!=null){
                //return true the current node doesn't equal anything but the head does
                return true;
            }else if(currentNode!=null){
                //return true if there is a node connected to current node
                //return false if there is no node connected to current node
                return currentNode.getNextNode()!=null;
            }else{
                // return false if both current and head are equal to null
                return false;
            }


        }

        @Override
        public T next(){
            if(currentNode==null && top!=null){
                //return true the current node doesn't equal anything but the head does
                currentNode = top;
                return top.getData();
            }else if(currentNode!=null){
                //return true if there is a node connected to current node
                //return false if there is no node connected to current node
                currentNode = currentNode.getNextNode();
                return  currentNode.getData();
            }else{
                // return false if both current and head are equal to null
                throw new NoSuchElementException();
            }
        }

    }

}

