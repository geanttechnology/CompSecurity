// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.a;

import com.facebook.b.g;

public final class a extends Enum
    implements g
{

    public static final a a;
    private static final a c[];
    private int b;

    private a(String s)
    {
        super(s, 0);
        b = 0x133529d;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/facebook/share/a/a, s);
    }

    public static a[] values()
    {
        return (a[])c.clone();
    }

    public final String a()
    {
        return "com.facebook.platform.action.request.APPINVITES_DIALOG";
    }

    public final int b()
    {
        return b;
    }

    static 
    {
        a = new a("APP_INVITES_DIALOG");
        c = (new a[] {
            a
        });
    }
}
