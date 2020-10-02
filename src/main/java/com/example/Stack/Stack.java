package com.example.Stack;

import org.aspectj.lang.annotation.Before;

import java.util.EmptyStackException;

class Node{
    Object obj;
    Node  next ;
}

public class Stack {
    Node  head ;
//    public boolean isEmpty(){
//        if(this.obj!=null){
//            return false;
//        }
//        return true ;
//    }
      public boolean isEmpty(){
      if(this.head!=null){
        return false;
       }
       return true ;
    }


//    public void push(Object obj){
//        this.obj = obj;
//    }

    public void push(Object obj){
          Node newNode = new Node();
          newNode.obj = obj;
          newNode.next = head;
          head = newNode;
    }

//    public Object peek(){
//        return this.obj;
//    }
    public Object peek(){
          if(isEmpty()){
              return null;
          }
        return this.head.obj;
    }

//    public Object pop(){
//        if(this.obj != null){
//            Object temp = this.obj;
//            this.obj = null;
//            return temp;
//        }
//        throw new EmptyStackException();
//    }

    public Object pop(){
          if(isEmpty()){
              throw new EmptyStackException();
          }
            Node temp = this.head;
            head =temp.next;
            return temp.obj;
        }

    }
