// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.Serializable;
import u.aly.s;
import u.aly.u;

public class b
{
    static class a
        implements Serializable
    {

        private static final long a = 0x1335127L;
        private String b;
        private long c;
        private long d;

        public void a()
        {
            d = System.currentTimeMillis();
        }

        public boolean a(String s1)
        {
            return b.equals(s1);
        }

        public void b()
        {
            c = c + (System.currentTimeMillis() - d);
            d = 0L;
        }

        public void c()
        {
            a();
        }

        public void d()
        {
            b();
        }

        public long e()
        {
            return c;
        }

        public String f()
        {
            return b;
        }

        public a(String s1)
        {
            b = s1;
        }
    }


    public String a;
    public String b;
    private Context c;
    private final String d = "um_g_cache";
    private final String e = "single_level";
    private final String f = "stat_player_level";
    private final String g = "stat_game_level";
    private a h;

    public b(Context context)
    {
        h = null;
        c = context;
    }

    public a a(String s1)
    {
        h = new a(s1);
        h.a();
        return h;
    }

    public void a()
    {
        if (h != null)
        {
            h.b();
            android.content.SharedPreferences.Editor editor = c.getSharedPreferences("um_g_cache", 0).edit();
            editor.putString("single_level", s.a(h));
            editor.putString("stat_player_level", b);
            editor.putString("stat_game_level", a);
            editor.commit();
        }
    }

    public a b(String s1)
    {
        if (h != null)
        {
            h.d();
            if (h.a(s1))
            {
                s1 = h;
                h = null;
                return s1;
            }
        }
        return null;
    }

    public void b()
    {
        SharedPreferences sharedpreferences = u.a(c, "um_g_cache");
        String s1 = sharedpreferences.getString("single_level", null);
        if (s1 != null)
        {
            h = (a)s.a(s1);
            if (h != null)
            {
                h.c();
            }
        }
        if (b == null)
        {
            b = sharedpreferences.getString("stat_player_level", null);
        }
        if (a == null)
        {
            a = sharedpreferences.getString("stat_game_level", null);
        }
    }
}
