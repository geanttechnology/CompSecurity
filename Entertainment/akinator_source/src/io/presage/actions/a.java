// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import android.os.AsyncTask;
import io.presage.Presage;
import io.presage.do.e;
import io.presage.utils.i;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package io.presage.actions:
//            g, c, b

public abstract class io.presage.actions.a
    implements g
{
    final class a extends AsyncTask
    {

        final io.presage.actions.a a;
        private io.presage.actions.a b;

        protected final Object doInBackground(Object aobj[])
        {
            return b.k();
        }

        protected final void onPostExecute(Object obj)
        {
            b.l();
        }

        public a(io.presage.actions.a a2)
        {
            a = io.presage.actions.a.this;
            super();
            b = a2;
        }
    }


    private String a;
    private String b;
    private e c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private Context i;
    private c j;
    private io.presage.utils.do.a k;
    private Timer l;
    private TimerTask m;

    public io.presage.actions.a(String s, String s1, e e1)
    {
        a = s;
        b = s1;
        c = e1;
        i = Presage.getInstance().getContext();
        k = Presage.getInstance().getWS();
    }

    public final String a()
    {
        return a;
    }

    public final void a(c c1)
    {
        j = c1;
    }

    public void a(String s)
    {
    }

    public final void a(String s, String s1)
    {
        h = s1;
        g = s;
    }

    public final void a(String s, String s1, String s2)
    {
        d = s;
        e = s1;
        f = s2;
    }

    public final e b()
    {
        return c;
    }

    public final String c()
    {
        return d;
    }

    public final String d()
    {
        return e;
    }

    public final String e()
    {
        return f;
    }

    public final String f()
    {
        return h;
    }

    public final String g()
    {
        return g;
    }

    public final Context h()
    {
        if (i == null)
        {
            i = Presage.getInstance().getContext();
        }
        return i;
    }

    public final io.presage.utils.do.a i()
    {
        if (k == null)
        {
            k = Presage.getInstance().getWS();
        }
        return k;
    }

    public final void j()
    {
        (new a(this)).executeOnExecutor(io.presage.utils.i.a(), new String[0]);
    }

    public abstract String k();

    public void l()
    {
    }

    public final c m()
    {
        return j;
    }

    public final void n()
    {
        if (j != null)
        {
            j.b(this);
        }
    }

    public final void o()
    {
        if (j != null)
        {
            l = new Timer();
            m = new b(this);
            l.schedule(m, 500L);
        }
    }

    public int p()
    {
        return 0;
    }
}
