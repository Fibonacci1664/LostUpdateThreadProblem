/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davegreen.lostupdatethreadproblem;

/**
 *
 * @author Dave
 */
public class TestSync implements Runnable
{
    private int balance;
    
    public void createThreads()
    {
        TestSync syncJob = new TestSync();
        Thread a = new Thread(syncJob);
        Thread b = new Thread(syncJob);
        a.setName("Thread A");
        b.setName("Thread B");
        a.start();
        b.start();
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 50; i++)
        {
            increment();
            System.out.println("balance on " + Thread.currentThread().getName() + " is " + balance);
        }
    }
    
    public synchronized void increment()
    {
        int i = balance;
        balance = i + 1;
    }
}
