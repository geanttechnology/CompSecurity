// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.internal;

import android.support.v7.jo;

public final class c extends Enum
    implements jo
{

    public static final c a;
    private static final c c[];
    private int b;

    private c(String s, int i, int j)
    {
        super(s, i);
        b = j;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/facebook/share/internal/c, s);
    }

    public static c[] values()
    {
        return (c[])c.clone();
    }

    public String a()
    {
        return "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    }

    public int b()
    {
        return b;
    }

    static 
    {
        a = new c("OG_ACTION_DIALOG", 0, 0x1332b3a);
        c = (new c[] {
            a
        });
    }
}
