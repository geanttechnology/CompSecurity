// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public abstract class hb
    implements Runnable
{

    private String a;

    public transient hb(String s, Object aobj[])
    {
        a = String.format(s, aobj);
    }

    protected abstract void c();

    public final void run()
    {
        String s;
        s = Thread.currentThread().getName();
        Thread.currentThread().setName(a);
        c();
        Thread.currentThread().setName(s);
        return;
        Exception exception;
        exception;
        Thread.currentThread().setName(s);
        throw exception;
    }
}
