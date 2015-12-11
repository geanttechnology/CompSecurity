// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class uq extends ue
{

    final Executor m;
    crf n;
    private final cud u;

    public uq(rh rh, rg rg, bje bje1, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            Executor executor, ctx ctx1, cud cud1, cwm cwm1)
    {
        super(rh, rg, bje1, ctw, blx, cvi, bmw, ctx1, cwm1.b);
        i = cwm1.a;
        u = (cud)b.a(cud1);
        m = (Executor)b.a(executor);
        if (i != null)
        {
            a(cts.e);
        }
        i();
    }

    public uq(rh rh, rg rg, bje bje1, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            Executor executor, ctx ctx1, cud cud1, List list, int i, byte abyte0[], String s, 
            boolean flag, int j)
    {
        super(rh, rg, bje1, ctw, blx, cvi, bmw, ctx1, list, i, abyte0, s, flag, j);
        u = (cud)b.a(cud1);
        m = (Executor)b.a(executor);
        i();
    }

    static void a(uq uq1, Handler handler, crf crf1)
    {
        try
        {
            handler.post(new us(uq1, (bum)crf1.get()));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (crf crf1)
        {
            handler.post(new uv(uq1, crf1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (crf crf1)
        {
            handler.post(new uv(uq1, crf1));
        }
    }

    public final void a()
    {
        if (r != null)
        {
            r.a = true;
            r = null;
        }
        if (n != null)
        {
            n.cancel(false);
        }
        if (i != null)
        {
            g = cts.e;
        } else
        {
            if (h != null)
            {
                g = cts.d;
                return;
            }
            if (g != cts.a)
            {
                a(cts.a);
                return;
            }
        }
    }

    protected final void c(int i)
    {
        t = Math.min(o.length - 1, i);
        t = Math.max(0, i);
        if (i < o.length && i >= 0)
        {
            d.c(new csv());
            r = bhx.a(new ut(this));
            a.a(o[i], p, q, "", -1, -1, r);
            n = crf.a();
            u.a(o[i], "", -1, "", p, n);
            a(cts.b);
        } else
        if (o.length == 0)
        {
            s = t;
            a(cts.f);
            return;
        }
    }

    public final boolean c_()
    {
        boolean flag = false;
        if (g == cts.d)
        {
            d.c(new csv());
            if (n != null)
            {
                n.cancel(false);
            }
            n = crf.a();
            u.a(o[s], "", -1, "", p, n);
            Handler handler = new Handler();
            m.execute(new ur(this, handler));
            flag = true;
        }
        return flag;
    }

    public final cwh f()
    {
        return new cwm(i, (cwi)super.f());
    }

    protected final boolean n()
    {
        return true;
    }
}
