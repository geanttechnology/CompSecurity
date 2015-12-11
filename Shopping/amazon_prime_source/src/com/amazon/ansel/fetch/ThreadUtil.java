// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;


public class ThreadUtil
{

    public ThreadUtil()
    {
    }

    public static String infoString()
    {
        Thread thread = Thread.currentThread();
        return (new StringBuilder()).append("ID: ").append(thread.getId()).append(", name: ").append(thread.getName()).append(", priority: ").append(thread.getPriority()).append(", group: ").append(thread.getThreadGroup().getName()).toString();
    }
}
