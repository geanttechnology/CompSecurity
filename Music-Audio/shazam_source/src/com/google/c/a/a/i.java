// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;


public class i extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    public static final i j;
    public static final i k;
    private static final i l[];

    i(String s)
    {
        this(s, 2);
    }

    private i(String s, int i1)
    {
        super(s, i1);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/google/c/a/a/i, s);
    }

    public static i[] values()
    {
        return (i[])l.clone();
    }

    public String a()
    {
        return toString();
    }

    static 
    {
        a = new i("ADDRESSBOOK", 0);
        b = new i("EMAIL_ADDRESS", 1);
        c = new i("URI") {

            public final String a()
            {
                return "WEB";
            }

        };
        d = new i("TEXT", 3);
        e = new i("GEO", 4);
        f = new i("TEL", 5);
        g = new i("SMS", 6);
        h = new i("CALENDAR", 7);
        i = new i("WIFI", 8);
        j = new i("BOOKMARK_DOCOMO", 9);
        k = new i("URL_TO", 10);
        l = (new i[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
