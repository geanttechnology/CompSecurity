// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;


public final class f extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    public static final f e;
    public static final f f;
    public static final f g;
    public static final f h;
    public static final f i;
    private static final f j[];

    private f(String s, int k)
    {
        super(s, k);
    }

    public static f a(int k)
    {
        f af[] = values();
        if (-1005 == k)
        {
            return b;
        }
        if (k < 0 || k >= af.length)
        {
            return g;
        } else
        {
            return af[k];
        }
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/smule/android/d/f, s);
    }

    public static f[] values()
    {
        return (f[])j.clone();
    }

    static 
    {
        a = new f("RESULT_OK", 0);
        b = new f("RESULT_USER_CANCELED", 1);
        c = new f("RESULT_SERVICE_UNAVAILABLE", 2);
        d = new f("RESULT_BILLING_UNAVAILABLE", 3);
        e = new f("RESULT_ITEM_UNAVAILABLE", 4);
        f = new f("RESULT_DEVELOPER_ERROR", 5);
        g = new f("RESULT_ERROR", 6);
        h = new f("BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED", 7);
        i = new f("BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED", 8);
        j = (new f[] {
            a, b, c, d, e, f, g, h, i
        });
    }
}
