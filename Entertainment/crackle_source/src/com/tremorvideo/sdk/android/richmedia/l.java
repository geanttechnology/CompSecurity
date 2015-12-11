// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import com.tremorvideo.sdk.android.videoad.aw;

public class l
{

    public com.tremorvideo.sdk.android.videoad.s.a a;
    private String b;
    private String c;
    private int d;
    private int e;
    private aw f[];
    private boolean g;

    public l(String s, String s1, int i, int j, aw aaw[], boolean flag, com.tremorvideo.sdk.android.videoad.s.a a1)
    {
        d = i;
        e = j;
        b = s;
        c = s1;
        f = aaw;
        g = flag;
        a = a1;
    }

    public int a()
    {
        return d;
    }

    public void a(String s)
    {
        c = s;
    }

    public int b()
    {
        return e;
    }

    public String c()
    {
        return b;
    }

    public int d()
    {
        if (b != null && b.startsWith("video-"))
        {
            return Integer.parseInt(b.substring(b.length() - 1)) - 1;
        } else
        {
            return -1;
        }
    }

    public String e()
    {
        return c;
    }

    public boolean f()
    {
        return g;
    }

    public aw[] g()
    {
        return f;
    }

    public com.tremorvideo.sdk.android.videoad.s.a h()
    {
        return a;
    }
}
