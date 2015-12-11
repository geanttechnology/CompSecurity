// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class n extends Enum
    implements b
{

    public static final n a;
    public static final n b;
    private static final n d[];
    private String c;

    private n(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static n valueOf(String s)
    {
        return (n)Enum.valueOf(com/smule/android/c/n, s);
    }

    public static n[] values()
    {
        return (n[])d.clone();
    }

    public String a()
    {
        return c;
    }

    static 
    {
        a = new n("BASIC", 0, "basic");
        b = new n("CARD", 1, "card");
        d = (new n[] {
            a, b
        });
    }
}
