package com.example.Stack;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class Stacktest {

    private Stack stack ;

    @Before
    public void runBeforeEverytest(){
        stack = new Stack();
    }

    @Test
    public void isEmpty_return_True_ifEmpty(){
        Assert.assertEquals(true,stack.isEmpty());
    }
    @Test
    public void isEmpty_return_False_afterpush(){
        stack.push("cognizant");
        Assert.assertEquals(false,stack.isEmpty());
    }

    // Peek returns null if stack is empty
    @Test
    public void peek_return_Null_ifEmpty(){
        Assert.assertNull(stack.peek());
    }

    // peek returns latest pushed element
    @Test
    public void peek_return_latestPushedElementy(){
        stack.push("cognizant");
        Assert.assertEquals("cognizant",stack.peek());
    }
    //Pop throws exception if stack is empty
    @Test(expected = EmptyStackException.class)
    public void Pop_throws(){
        stack.pop();
    }

    //Pop returns latest Pushed value
    @Test
    public void Pop_returnslatestPushedvalue(){
        stack.push("cognizant");
        Assert.assertEquals("cognizant", stack.pop());
    }

    // peek returns null after pop
    @Test
    public void peek_returnsNull_afterPop(){
        stack.push("cognizant");
        stack.pop();
        Assert.assertNull(stack.peek());
    }

    // IsEmptty returns true after Pop
    @Test
    public void Isempty_returns_true_afterPop(){
        stack.push("cognizant");
        stack.pop();
        Assert.assertEquals(true,stack.isEmpty());
    }

    // push twice and pop returns returns second value pushed,peek returns 1st value
    @Test
    public  void PushTwice_popReturnsSecondvalue_peekReturnsFirstValue(){
        stack.push("cognizant");
        stack.push("cognizant2");
        Assert.assertEquals("cognizant2",stack.pop());
        Assert.assertEquals("cognizant",stack.peek());
    }
}

