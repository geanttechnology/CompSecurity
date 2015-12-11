// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.b;


public abstract class v extends Enum
{

    public static final v a;
    public static final v b;
    private static final v c[];

    private v(String s, int i)
    {
        super(s, i);
    }

    v(String s, int i, byte byte0)
    {
        this(s, i);
    }

    public static v valueOf(String s)
    {
        return (v)Enum.valueOf(com/google/b/v, s);
    }

    public static v[] values()
    {
        return (v[])c.clone();
    }

    static 
    {
        a = new v("DEFAULT") {

        };
        b = new v("STRING") {

        };
        c = (new v[] {
            a, b
        });
    }
}
