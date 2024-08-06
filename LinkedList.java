//import java.util.*;
public class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    //To create linkedlist
    public static Node head;
    public static void printLL(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");    
    }
    public static Node sortColors(){
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead;
        Node one = oneHead;
        Node two=twoHead;
        Node temp = head;
        while(temp != null){
            if(temp.data == 0){
                zero.next = temp;
                zero = zero.next;
            }
            else if(temp.data == 1){
                one.next = temp;
                one = one.next;
            }
            else{
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        two.next = null;
        if(oneHead.next == null){
            zero.next = twoHead.next;
        }
        else{
            zero.next = oneHead.next;
        }
        one.next = twoHead.next;
        return zeroHead.next;
    }
    public static Node evenOddSegregate() {
        Node evenHead = new Node(-1);
        Node oddHead = new Node(-1);
        Node even = evenHead;
        Node odd = oddHead;
        Node temp = head;
        int index = 0;
        while (temp != null) {
            if (index % 2 == 0) {
                even.next = temp;
                even = even.next;
            } else {
                odd.next = temp;
                odd = odd.next;
            }
            index++;
            temp = temp.next;
        }
        even.next = oddHead.next;
        return evenHead.next;
    }
    public static boolean Palindrom(){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node prev=null;
        Node curr=slow;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node temp=head;
        while(temp!=null && prev!=null){
            if(temp.data!=prev.data) return false;
            temp=temp.next;
            prev=prev.next;
        }
        return true;
    }
    public static Node rotate(int k){
        Node temp = head;
        int count = 0;
        while(temp.next!=null){
            count++;
            temp = temp.next;
        }
        count++;
        if(k%count==0) return head;
        k = k%count;
        temp.next = head;
        Node prev = null;
        for(int i=0;i<count-k;i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        head = temp;
        return head;
    }
    public static void main(String[] args) {
        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        //head.next.next.next.next.next=new Node(2);
        //head.next.next.next.next.next.next=new Node(1);
        //printLL(head);
        // addFirst(100);
        // printLL(head);
        // countNodes();
        // addMiddle(50,head);
        // printLL(head);
        // addLast(200);
        // printLL(head);
        // // deleteFirst();
        // // deleteMiddle(head);
        // // deleteLast();
        // // printLL(head);
        // addAtGivenPosition(400,5,head);
        // printLL(head);
        // // deleteAtGivenPosition(head,3);
        // // printLL(head);
        // // int K=1;
        // // deleteKFromLast(head, K);
        // // printLL(head);
        // head = reverseLinkedList(head);
        // printLL(head);
        //head=sortColors();
        //printLL(head);
        //evenOddSegregate();
        //printLL(head);
        //System.out.println(Palindrom());
        //printLL(head);
        rotate(2);
        printLL(head);
    }    

}


