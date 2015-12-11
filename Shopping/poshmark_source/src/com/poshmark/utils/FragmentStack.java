// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.poshmark.ui.fragments.PMFragment;
import java.util.Stack;

public class FragmentStack
{

    public static Stack FragmentStack = new Stack();

    public FragmentStack()
    {
    }

    public static PMFragment peek()
    {
        return (PMFragment)FragmentStack.peek();
    }

    public static PMFragment pop()
    {
        return (PMFragment)FragmentStack.pop();
    }

    public static void push(PMFragment pmfragment)
    {
        FragmentStack.add(pmfragment);
    }

}
