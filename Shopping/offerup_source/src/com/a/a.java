// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.design.widget.al;
import android.util.Log;
import java.util.EnumSet;

public abstract class a extends AsyncTask
{

    protected al a;
    protected Activity b;
    protected boolean c;
    protected EnumSet d;
    private long e;
    private boolean f;

    public a(Activity activity, al al, EnumSet enumset)
    {
        c = true;
        e = 10000L;
        f = false;
        a = al;
        b = activity;
        d = enumset;
        c = false;
    }

    public final long a()
    {
        return e;
    }

    protected transient abstract Void a(String as[]);

    public final void a(long l)
    {
        if (l > 5000L)
        {
            e = l;
            f = true;
        }
    }

    final transient void a(String s, Object aobj[])
    {
        String s1 = getClass().getSimpleName();
        Log.v(s1, (new StringBuilder("[")).append(s1).append("]").append(String.format(s, aobj)).toString());
    }

    public final boolean b()
    {
        return f;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPreExecute()
    {
        c = false;
    }
}
