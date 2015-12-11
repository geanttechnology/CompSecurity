// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.support.v7.jo;

public final class g extends Enum
    implements jo
{

    public static final g a;
    public static final g b;
    public static final g c;
    private static final g e[];
    private int d;

    private g(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/facebook/share/internal/g, s);
    }

    public static g[] values()
    {
        return (g[])e.clone();
    }

    public String a()
    {
        return "com.facebook.platform.action.request.FEED_DIALOG";
    }

    public int b()
    {
        return d;
    }

    static 
    {
        a = new g("SHARE_DIALOG", 0, 0x1332b3a);
        b = new g("PHOTOS", 1, 0x13350ac);
        c = new g("VIDEO", 2, 0x13353e4);
        e = (new g[] {
            a, b, c
        });
    }
}
