// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.gcm;


public final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final a f;
    public static final a g;
    public static final a h;
    public static final a i;
    public static final a j;
    public static final a k;
    private static final a m[];
    public final String l;

    private a(String s, int i1, String s1)
    {
        super(s, i1);
        l = s1;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/shazam/android/service/gcm/a, s);
    }

    public static a[] values()
    {
        return (a[])m.clone();
    }

    static 
    {
        a = new a("IntentUri", 0, "uri");
        b = new a("ContentTitle", 1, "ct");
        c = new a("ContentText", 2, "cx");
        d = new a("ContentInfo", 3, "ci");
        e = new a("Number", 4, "num");
        f = new a("Time", 5, "tme");
        g = new a("Ticker", 6, "ti");
        h = new a("Type", 7, "typ");
        i = new a("UnreadNewsCount", 8, "unc");
        j = new a("Id", 9, "id");
        k = new a("AnnouncementId", 10, "aid");
        m = (new a[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
