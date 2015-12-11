// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


final class e extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    private static final e e[];

    private e(String s, int i)
    {
        super(s, i);
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/a/a/e, s);
    }

    public static e[] values()
    {
        return (e[])e.clone();
    }

    static 
    {
        a = new e("ANDROID_ID", 0);
        b = new e("ANDROID_SERIAL", 1);
        c = new e("MAC_HASH", 2);
        d = new e("UID", 3);
        e = (new e[] {
            a, b, c, d
        });
    }
}
