// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class o extends Enum
    implements b
{

    public static final o a;
    public static final o b;
    public static final o c;
    public static final o d;
    public static final o e;
    public static final o f;
    public static final o g;
    public static final o h;
    public static final o i;
    public static final o j;
    private static final o l[];
    private String k;

    private o(String s, int i1, String s1)
    {
        super(s, i1);
        k = s1;
    }

    public static o valueOf(String s)
    {
        return (o)Enum.valueOf(com/smule/android/c/o, s);
    }

    public static o[] values()
    {
        return (o[])l.clone();
    }

    public String a()
    {
        return k;
    }

    static 
    {
        a = new o("SNP", 0, "snp");
        b = new o("FACEBOOK", 1, "facebook");
        c = new o("TWITTER", 2, "twitter");
        d = new o("LINE", 3, "line");
        e = new o("MESSENGER", 4, "messenger");
        f = new o("SMS", 5, "sms");
        g = new o("EMAIL", 6, "email");
        h = new o("SINGAGRAM", 7, "singagram");
        i = new o("COPY_LINK", 8, "copy_link");
        j = new o("GENERIC", 9, "more");
        l = (new o[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
