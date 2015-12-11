// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.c;

import android.os.AsyncTask;

public abstract class a extends AsyncTask
{

    private final String a;
    private final String b;

    public a(Class class1, String s)
    {
        this(class1.getName(), s);
    }

    private a(String s, String s1)
    {
        a = s;
        b = s1;
    }

    public transient abstract Object a(Object aobj[]);

    protected final transient Object doInBackground(Object aobj[])
    {
        Thread.currentThread().setName((new StringBuilder("AsyncTask: ")).append(a).append(" - ").append(b).toString());
        aobj = ((Object []) (a(aobj)));
        Thread.currentThread().setName((new StringBuilder("In thread pool: was ")).append(a).append(" - ").append(b).toString());
        return ((Object) (aobj));
    }
}
