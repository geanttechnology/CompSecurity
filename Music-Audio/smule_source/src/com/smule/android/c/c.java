// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class c extends Enum
    implements b
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    private static final c g[];
    private String f;

    private c(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/smule/android/c/c, s);
    }

    public static c[] values()
    {
        return (c[])g.clone();
    }

    public String a()
    {
        return f;
    }

    static 
    {
        a = new c("FREE", 0, "free");
        b = new c("OWNED", 1, "owned");
        c = new c("CREDITS", 2, "credits");
        d = new c("VIP", 3, "vip");
        e = new c("GIFT", 4, "gift");
        g = (new c[] {
            a, b, c, d, e
        });
    }
}
