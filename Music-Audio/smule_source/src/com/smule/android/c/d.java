// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class d extends Enum
    implements b
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    public static final d e;
    public static final d f;
    public static final d g;
    private static final d i[];
    private String h;

    private d(String s, int j, String s1)
    {
        super(s, j);
        h = s1;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/smule/android/c/d, s);
    }

    public static d[] values()
    {
        return (d[])i.clone();
    }

    public String a()
    {
        return h;
    }

    static 
    {
        a = new d("WATCHING_VIDEO", 0, "videoads");
        b = new d("OFFER_WALL", 1, "offerwall");
        c = new d("LOGIN", 2, "login");
        d = new d("ACHIEVEMENT", 3, "achievement");
        e = new d("FB_CONNECT", 4, "fbconnect");
        f = new d("FB_LIKE", 5, "fblike");
        g = new d("SMS", 6, "sms");
        i = (new d[] {
            a, b, c, d, e, f, g
        });
    }
}
