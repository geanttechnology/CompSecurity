// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.os.Handler;
import java.util.Collections;

public final class ts extends ue
{

    bzi m;
    bhx n;
    private final crb u;
    private final Handler v;
    private final tt w;
    private final String x;

    public ts(rh rh, rg rg, bje bje1, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            ctx ctx1, bzg bzg1, cwd cwd1)
    {
        super(rh, rg, bje1, ctw, blx, cvi, bmw, ctx1, cwd1.c);
        b.a(bzg1);
        u = bzg1.b();
        m = cwd1.b;
        x = cwd1.a;
        v = new Handler();
        w = new tt(this);
        i();
    }

    public ts(rh rh, rg rg, bje bje1, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            ctx ctx1, bzg bzg1, String s, int i, boolean flag, int j)
    {
        super(rh, rg, bje1, ctw, blx, cvi, bmw, ctx1, Collections.emptyList(), i, ctx.a, "", flag, j);
        b.a(bzg1);
        x = b.a(s);
        u = bzg1.b();
        rh = bzg1.a();
        i = ((bzl) (rh)).b;
        b.a(s);
        rh = ((bzl) (rh)).a.a().buildUpon().appendPath("playlists").appendEncodedPath(s);
        bzl.a(rh, 1, i);
        m = bzi.a(rh.build());
        v = new Handler();
        w = new tt(this);
        a(cts.a);
        i();
    }

    static void a(ts ts1)
    {
        ts1.w();
    }

    private void w()
    {
        boolean flag;
        if (t >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        if (t < o.length)
        {
            r = bhx.a(new uf(this));
            a.a(o[t], ctx.a, "", x, t, -1, r);
            return;
        } else
        {
            a(cts.f);
            return;
        }
    }

    public final void a()
    {
        super.a();
        if (n != null)
        {
            n.a = true;
            n = null;
        }
    }

    protected final int b(int i)
    {
        if (u != null)
        {
            int j;
            if (m == null)
            {
                j = o.length - 1;
            } else
            {
                j = 0x7fffffff;
            }
            return Math.max(0, Math.min(i, j));
        } else
        {
            return Math.max(0, i);
        }
    }

    protected final int c()
    {
        if (g.a(cts.d))
        {
            return s;
        } else
        {
            return t;
        }
    }

    protected final void c(int i)
    {
        t = b(i);
        if (i < 0)
        {
            return;
        }
        a(cts.b);
        if (i < o.length)
        {
            w();
            return;
        }
        if (m != null)
        {
            v();
            return;
        }
        if (o.length == 0)
        {
            s = t;
            a(cts.f);
            return;
        } else
        {
            d.c(new csw(true));
            return;
        }
    }

    protected final byte[] d()
    {
        return ctx.a;
    }

    public final cwh f()
    {
        return new cwd(m, x, (cwi)super.f());
    }

    protected final boolean g_()
    {
        return s >= o.length - 1 && m == null;
    }

    public final String t()
    {
        return x;
    }

    void v()
    {
        n = bhx.a(w);
        u.a(m, bhy.a(v, n));
    }
}
