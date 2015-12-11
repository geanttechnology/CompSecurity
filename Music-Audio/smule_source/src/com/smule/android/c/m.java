// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class m extends Enum
    implements b
{

    public static final m a;
    public static final m b;
    public static final m c;
    private static final m e[];
    private String d;

    private m(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/smule/android/c/m, s);
    }

    public static m[] values()
    {
        return (m[])e.clone();
    }

    public String a()
    {
        return d;
    }

    static 
    {
        a = new m("SONG", 0, "song");
        b = new m("PERFORMANCE", 1, "perf");
        c = new m("USER", 2, "acct");
        e = (new m[] {
            a, b, c
        });
    }
}
