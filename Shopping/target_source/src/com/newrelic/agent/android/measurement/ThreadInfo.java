// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.measurement;


public class ThreadInfo
{

    private long id;
    private String name;

    public ThreadInfo()
    {
        this(Thread.currentThread());
    }

    public ThreadInfo(long l, String s)
    {
        id = l;
        name = s;
    }

    public ThreadInfo(Thread thread)
    {
        this(thread.getId(), thread.getName());
    }

    public static ThreadInfo fromThread(Thread thread)
    {
        return new ThreadInfo(thread);
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setId(long l)
    {
        id = l;
    }

    public void setName(String s)
    {
        name = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ThreadInfo{id=").append(id).append(", name='").append(name).append('\'').append('}').toString();
    }
}
