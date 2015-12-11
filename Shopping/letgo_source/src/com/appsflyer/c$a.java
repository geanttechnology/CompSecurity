// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;


// Referenced classes of package com.appsflyer:
//            c

public static final class d extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c e[];
    private final int d;

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/appsflyer/c$a, s);
    }

    public static ueOf[] values()
    {
        return (ueOf[])e.clone();
    }

    public int a()
    {
        return d;
    }

    static 
    {
        a = new <init>("NONE", 0, 0);
        b = new <init>("SHA1", 1, 1);
        c = new <init>("MD5", 2, 2);
        e = (new e[] {
            a, b, c
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        d = j;
    }
}
