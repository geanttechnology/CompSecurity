// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui;

import android.support.v4.app.Fragment;
import java.util.Stack;

public class TabStackManager
{

    static TabStackManager g_tabStackManager = null;
    Stack feedTabStack;
    Stack partyTabStack;

    TabStackManager()
    {
        feedTabStack = null;
        partyTabStack = null;
        feedTabStack = new Stack();
        partyTabStack = new Stack();
    }

    public static TabStackManager GetTabStackManager()
    {
        com/poshmark/ui/TabStackManager;
        JVM INSTR monitorenter ;
        TabStackManager tabstackmanager;
        if (g_tabStackManager == null)
        {
            g_tabStackManager = new TabStackManager();
        }
        tabstackmanager = g_tabStackManager;
        com/poshmark/ui/TabStackManager;
        JVM INSTR monitorexit ;
        return tabstackmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public void poshFragmentFromFeedStack()
    {
        feedTabStack.pop();
    }

    public void poshFragmentFromPartyStack()
    {
        partyTabStack.pop();
    }

    public void pushFragmentToFeedStack(Fragment fragment)
    {
        feedTabStack.push(fragment);
    }

    public void pushFragmentToPartyStack(Fragment fragment)
    {
        partyTabStack.push(fragment);
    }

}
