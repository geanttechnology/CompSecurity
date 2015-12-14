// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;


public final class value extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];
    private final int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/cyberlink/beautycircle/model/network/NetworkManager$NetworkErrorCode, s);
    }

    public static value[] values()
    {
        return (value[])f.clone();
    }

    public int a()
    {
        return value;
    }

    static 
    {
        a = new <init>("E_CONNECT_FAIL", 0, -1);
        b = new <init>("E_BAD_REQUEST", 1, -2);
        c = new <init>("E_NOT_INITIALIZED", 2, -3);
        d = new <init>("E_EMPTY_RESPONSE", 3, -4);
        e = new <init>("E_CONNECT_CANCELLED", 4, -5);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
