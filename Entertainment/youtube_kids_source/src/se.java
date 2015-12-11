// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

public final class se extends cvi
{

    private final qs c;
    private final qw d;
    private final SharedPreferences e;

    public se(Context context, qs qs1, qw qw1, SharedPreferences sharedpreferences)
    {
        super(context);
        c = (qs)b.a(qs1);
        d = (qw)b.a(qw1);
        e = (SharedPreferences)b.a(sharedpreferences);
        a();
    }

    private String a(String s)
    {
        cpj cpj1 = c.b();
        String s1 = a(s, cpj1.c);
        if (!e.contains(s1))
        {
            s = a(s, qt.a(cpj1));
            bnh.a(e, s, s1, false);
        }
        return s1;
    }

    private static String a(String s, String s1)
    {
        return (new StringBuilder(String.valueOf(s).length() + 1 + String.valueOf(s1).length())).append(s).append(":").append(s1).toString();
    }

    private void a()
    {
        a = b("playability_adult_confirmations");
        b = b("playability_content_confirmations");
    }

    private boolean b(String s)
    {
        boolean flag = false;
        if (c.a())
        {
            s = a(s);
            flag = e.getBoolean(s, false);
        }
        return flag;
    }

    public final void onSignIn$5efadcfb(a a1)
    {
        a();
    }

    public final void onSignOut$75e9c194(a a1)
    {
        a();
    }
}
