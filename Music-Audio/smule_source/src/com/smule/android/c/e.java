// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class e extends Enum
    implements b
{

    public static final e a;
    public static final e b;
    public static final e c;
    private static final e e[];
    private String d;

    private e(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/smule/android/c/e, s);
    }

    public static e[] values()
    {
        return (e[])e.clone();
    }

    public String a()
    {
        return d;
    }

    static 
    {
        a = new e("TAPJOY", 0, "tapjoy");
        b = new e("ADCOLONY", 1, "adcolony");
        c = new e("FYBER", 2, "sponsorpay");
        e = (new e[] {
            a, b, c
        });
    }
}
