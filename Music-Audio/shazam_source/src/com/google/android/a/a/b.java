// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    public static final b h;
    public static final b i;
    public static final b j;
    public static final b k;
    public static final b l;
    private static final b m[];

    private b(String s, int i1)
    {
        super(s, i1);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/google/android/a/a/b, s);
    }

    public static b[] values()
    {
        return (b[])m.clone();
    }

    static 
    {
        a = new b("SUCCESS", 0);
        b = new b("INTERNAL_ERROR", 1);
        c = new b("UNKNOWN_ERROR", 2);
        d = new b("SERVICE_MISSING", 3);
        e = new b("SERVICE_VERSION_UPDATE_REQUIRED", 4);
        f = new b("SERVICE_DISABLED", 5);
        g = new b("SERVICE_INVALID", 6);
        h = new b("ERROR_CONNECTING_TO_SERVICE", 7);
        i = new b("CLIENT_LIBRARY_UPDATE_REQUIRED", 8);
        j = new b("NETWORK_ERROR", 9);
        k = new b("DEVELOPER_KEY_INVALID", 10);
        l = new b("INVALID_APPLICATION_SIGNATURE", 11);
        m = (new b[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
    }
}
