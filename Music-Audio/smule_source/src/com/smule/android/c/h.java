// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class h extends Enum
    implements b
{

    public static final h a;
    public static final h b;
    public static final h c;
    private static final h e[];
    private String d;

    private h(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/smule/android/c/h, s);
    }

    public static h[] values()
    {
        return (h[])e.clone();
    }

    public String a()
    {
        return d;
    }

    static 
    {
        a = new h("SPLASH", 0, "splash");
        b = new h("CREATE", 1, "create");
        c = new h("SIGN_IN", 2, "signin");
        e = (new h[] {
            a, b, c
        });
    }
}
