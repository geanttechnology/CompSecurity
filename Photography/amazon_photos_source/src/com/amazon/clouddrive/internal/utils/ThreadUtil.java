// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal.utils;


public class ThreadUtil
{

    public static void checkIfInterrupted()
        throws InterruptedException
    {
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        } else
        {
            return;
        }
    }
}
