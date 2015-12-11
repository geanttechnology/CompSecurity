// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.c;

import android.content.SharedPreferences;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.a.z;
import java.util.Observable;
import java.util.Observer;

public class a
{

    private static a f = null;
    private static final String g = com/smule/pianoandroid/magicpiano/c/a.getSimpleName();
    public boolean a;
    public String b;
    public boolean c;
    public boolean d;
    Observer e;
    private boolean h;
    private int i;

    private a()
    {
        h = false;
        b = null;
        c = false;
        i = 0;
        d = false;
        e = new Observer() {

            final a a;

            public void update(Observable observable, Object obj)
            {
                if (((String)obj).compareTo("LOGIN_TYPE_EXISTING") == 0)
                {
                    a.a(a);
                    com.smule.android.f.h.a().b("USER_LOGGED_IN_EVENT", this);
                }
            }

            
            {
                a = a.this;
                super();
            }
        };
    }

    public static a a()
    {
        if (f == null)
        {
            f = new a();
        }
        return f;
    }

    static void a(a a1)
    {
        a1.l();
    }

    private void a(String s, boolean flag)
    {
        p.a(z.a().b().edit().putBoolean(s, flag));
    }

    private void l()
    {
        if (UserManager.n().l() > 2)
        {
            k();
        }
    }

    public void a(String s)
    {
        b = s;
        p.a(z.a().b().edit().putString("SONG_SELECTED", s));
    }

    public void a(boolean flag)
    {
        h = flag;
        a("SONG_COMPLETE", true);
    }

    public void b()
    {
        j();
        if (!UserManager.n().h())
        {
            com.smule.android.f.h.a().a("USER_LOGGED_IN_EVENT", e);
        }
    }

    public void b(boolean flag)
    {
        c = flag;
        a("SONG_REWARDED", flag);
    }

    public boolean c()
    {
        return h;
    }

    public boolean d()
    {
        return b != null;
    }

    public boolean e()
    {
        return c;
    }

    public int f()
    {
        return i;
    }

    public void g()
    {
        i = i + 1;
        p.a(z.a().b().edit().putInt("play_counter", i));
    }

    public boolean h()
    {
        return d;
    }

    public void i()
    {
        d = true;
        a("JOIN_TUTORIAL_COMPLETE", true);
    }

    public void j()
    {
        h = z.a().b().getBoolean("SONG_COMPLETE", false);
        b = z.a().b().getString("SONG_SELECTED", null);
        c = z.a().b().getBoolean("SONG_REWARDED", false);
        i = z.a().b().getInt("play_counter", 0);
        d = z.a().b().getBoolean("JOIN_TUTORIAL_COMPLETE", false);
    }

    public void k()
    {
        a("SONG_COMPLETE", true);
        h = true;
        p.a(z.a().b().edit().putString("SONG_SELECTED", ""));
        b = "";
        a("SONG_REWARDED", true);
        c = true;
    }

}
