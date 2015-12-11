// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert;


// Referenced classes of package com.shazam.android.advert:
//            b

public final class m extends Enum
    implements b
{

    public static final m a;
    public static final m b;
    public static final m c;
    private static final m e[];
    public final String d;

    private m(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/shazam/android/advert/m, s);
    }

    public static m[] values()
    {
        return (m[])e.clone();
    }

    public final String a()
    {
        return d;
    }

    static 
    {
        a = new m("APP_NEXUS", 0, "appnexus");
        b = new m("FACEBOOK", 1, "facebook");
        c = new m("AD_COLONY", 2, "adcolony");
        e = (new m[] {
            a, b, c
        });
    }
}
