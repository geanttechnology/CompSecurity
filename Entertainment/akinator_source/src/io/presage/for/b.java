// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import io.presage.Presage;
import io.presage.formats.multiwebviews.do.a;
import io.presage.try.d;
import io.presage.try.h;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.for:
//            i, g, d, e, 
//            f, c, k, h, 
//            j

public final class b
{

    private h a;

    public b(h h1)
    {
        a = h1;
    }

    static h a(b b1)
    {
        return b1.a;
    }

    public final void addManagedView(String s)
    {
        Presage.getInstance().runOnUiThread(new i(this, s));
    }

    public final boolean canGoBack(String s)
    {
        return true;
    }

    public final boolean canGoForward(String s)
    {
        return true;
    }

    public final void execute(String s, String s1)
    {
        s = a.a(s);
        if (s != null && (s instanceof d))
        {
            Presage.getInstance().runOnUiThread(new g(this, s, s1));
        }
    }

    public final String getManagedViewNames()
    {
        return (new Gson()).toJson(a.b());
    }

    public final String getManagedWebViewNames()
    {
        return (new Gson()).toJson(a.a());
    }

    public final void goBack(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof d))
        {
            Presage.getInstance().runOnUiThread(new io.presage.for.d(this, s));
        }
    }

    public final void goForward(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof d))
        {
            Presage.getInstance().runOnUiThread(new e(this, s));
        }
    }

    public final void loadUrl(String s, String s1)
    {
        s = a.a(s);
        if (s != null && (s instanceof d))
        {
            Presage.getInstance().runOnUiThread(new f(this, s, s1));
        }
    }

    public final void mute(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof io.presage.try.b))
        {
            ((io.presage.try.b)s).b().d();
        }
    }

    public final void pause(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof io.presage.try.b))
        {
            ((io.presage.try.b)s).b().b();
        }
    }

    public final void play(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof io.presage.try.b))
        {
            ((io.presage.try.b)s).b().a();
        }
    }

    public final void playPause(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof io.presage.try.b))
        {
            ((io.presage.try.b)s).b().c();
        }
    }

    public final void reload(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof d))
        {
            Presage.getInstance().runOnUiThread(new c(this, s));
        }
    }

    public final void removeManagedView(String s)
    {
        Presage.getInstance().runOnUiThread(new k(this, s));
    }

    public final void send(String s, String s1)
    {
        send(s, s1, null);
    }

    public final void send(String s, String s1, String s2)
    {
        s = a.a(s);
        if (s != null && (s instanceof d))
        {
            Presage.getInstance().runOnUiThread(new io.presage.for.h(this, s, s1, s2));
        }
    }

    public final void stop(String s)
    {
        s = a.a(s);
        if (s != null && (s instanceof io.presage.try.b))
        {
            ((io.presage.try.b)s).b().e();
        }
    }

    public final void updateManagedView(String s, String s1)
    {
        Presage.getInstance().runOnUiThread(new j(this, s, s1));
    }
}
