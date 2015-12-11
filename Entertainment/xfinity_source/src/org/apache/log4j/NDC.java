// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

public class NDC
{
    private static class DiagnosticContext
    {

        String fullMessage;
    }


    static Hashtable ht = new Hashtable();
    static int pushCounter = 0;

    public static String get()
    {
        Stack stack = getCurrentStack();
        if (stack != null && !stack.isEmpty())
        {
            return ((DiagnosticContext)stack.peek()).fullMessage;
        } else
        {
            return null;
        }
    }

    private static Stack getCurrentStack()
    {
        if (ht != null)
        {
            return (Stack)ht.get(Thread.currentThread());
        } else
        {
            return null;
        }
    }

}
