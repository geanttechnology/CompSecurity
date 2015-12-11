// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;


final class ax extends Enum
{

    public static final ax a;
    public static final ax b;
    public static final ax c;
    public static final ax d;
    public static final ax e;
    private static final ax f[];

    private ax(String s, int i)
    {
        super(s, i);
    }

    public static ax valueOf(String s)
    {
        return (ax)Enum.valueOf(com/smule/android/network/managers/ax, s);
    }

    public static ax[] values()
    {
        return (ax[])f.clone();
    }

    static 
    {
        a = new ax("HANDLE", 0);
        b = new ax("EMAIL", 1);
        c = new ax("FB", 2);
        d = new ax("DEVICE", 3);
        e = new ax("GPLUS", 4);
        f = (new ax[] {
            a, b, c, d, e
        });
    }
}
