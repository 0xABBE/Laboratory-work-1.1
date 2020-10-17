package com.company;
/** This class is the main class of List*/
class LinearList<Type1>{
    /**
     * Link on the first element of List.
     */
    private Node<Type1> firstMember;

    /**
     * Size of list
     */
    private int Size;

    /**
     * Constructor of List. Input first object of class.
     */
    LinearList(Type1 value)
    {
        this.firstMember=new Node<>(value);
        this.Size=1;
    }

    /**
     * This method adds new element in the end of List.
     */
    public void add(Type1 value) {
        Node<Type1> newData =new Node<>(value);
        Node<Type1> curNode =this.firstMember;
        while(curNode.nextNode!=null)
        {
            curNode=curNode.nextNode;
        }
        curNode.nextNode=newData;
        this.Size++;
    }

    /**
     * This method shows all elements of List.
     */
    public void show()
    {
        Node<Type1> curNode =this.firstMember;
        while(curNode.nextNode!=null)
        {
            System.out.println(curNode.data);
            curNode=curNode.nextNode;
        }
        System.out.print(curNode.data);
    }

    /**
     * This method remove objects by index.
     */
    public void remove(int index)
    {
        Node<Type1> prevNode=this.firstMember;
        Node<Type1> toDelete;
        if(index==0 && Size!=0)
        {
            this.firstMember=this.firstMember.nextNode;
        }
        else if(index<=Size-1)
        {
            for(int i=0;i<index-1;i++) {
                prevNode = prevNode.nextNode;
            }
            toDelete=prevNode.nextNode;
            prevNode.nextNode=toDelete.nextNode;
        }
        else {throw new RuntimeException("Index out of range");}
        this.Size--;
    }

    /**
     * This method returns element.
     * @param index some index in diapason of 0 to size of list minus 1
     * @return the element by index.
     * @throws RuntimeException if index more then List.
     */
    public Type1 getByIndex(int index)  {
        Node<Type1> curNode = this.firstMember;
        if (index<=Size-1 && index>=0) {
            if (index != 0) {
                for (int i = 0; i < index; i++) {
                    curNode = curNode.nextNode;
                }
            }
            return curNode.data;
        }
        throw new RuntimeException("Index out of range");
    }
}

/**
 * This class a part of class list
 */
class Node<Type1> {
    public Type1 data;
    public Node<Type1> nextNode;
    Node(Type1 value)
    {
        data=value;
        nextNode=null;
    }
}

public class Main {
    public static void main(String[] args) {
        LinearList<Integer> lst=new LinearList<>(5);
        lst.add(7);
        System.out.println(lst.getByIndex(0));
        lst.remove(1);
        lst.show();
    }
}

