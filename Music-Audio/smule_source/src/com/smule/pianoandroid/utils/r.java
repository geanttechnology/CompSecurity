// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import com.smule.android.c.b;
import java.util.HashMap;
import java.util.Map;

public final class r extends Enum
    implements b
{

    public static final r a;
    public static final r b;
    public static final r c;
    public static final r d;
    public static final r e;
    public static final r f;
    public static final r g;
    public static final r h;
    public static final r i;
    public static final r j;
    public static final r k;
    public static final r l;
    private static final Map m;
    private static final r o[];
    private String n;

    private r(String s, int i1, String s1)
    {
        super(s, i1);
        n = s1;
    }

    public static r valueOf(String s)
    {
        return (r)Enum.valueOf(com/smule/pianoandroid/utils/r, s);
    }

    public static r[] values()
    {
        return (r[])o.clone();
    }

    public String a()
    {
        return n;
    }

    static 
    {
        int i1 = 0;
        a = new r("SONGBOOK", 0, "pg_songbook");
        b = new r("INFO_BAR", 1, "wg_infobar");
        c = new r("GLOBE", 2, "pg_globe");
        d = new r("SETTINGS", 3, "pg_settings");
        e = new r("PROFILE", 4, "pg_profile");
        f = new r("POSTSONG", 5, "pg_postsong");
        g = new r("DAILY_CHALLENGE", 6, "pg_dailychallenge");
        h = new r("TUTORIAL", 7, "pg_tutorial");
        i = new r("URL", 8, "wg_urlopen");
        j = new r("MENU", 9, "wg_menu");
        k = new r("ACHIEVEMENTS", 10, "pg_achievements");
        l = new r("INSTRUMENTS", 11, "pg_instruments");
        o = (new r[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
        m = new HashMap(12);
        r ar[] = values();
        for (int j1 = ar.length; i1 < j1; i1++)
        {
            r r1 = ar[i1];
            m.put(r1.a(), r1);
        }

    }
}
