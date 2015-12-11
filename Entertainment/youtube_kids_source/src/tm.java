// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public abstract class tm extends to
{

    public final ctx a;
    bhx b;

    public tm(rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            ctx ctx1, cwb cwb)
    {
        super(rh, rg, bje, ctw, blx, cvi, bmw, cwb);
        a = (ctx)b.a(ctx1);
    }

    public tm(rh rh, rg rg, bje bje, ctw ctw, blx blx, cvi cvi, bmw bmw, 
            ctx ctx1, boolean flag, int i)
    {
        super(rh, rg, bje, ctw, blx, cvi, bmw, flag, i);
        a = (ctx)b.a(ctx1);
    }

    public void a()
    {
        if (b != null)
        {
            b.a = true;
            b = null;
        }
    }

    final void a(int i)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        b.a(h);
        if (b != null)
        {
            return;
        }
        obj = obj1;
        if (h.f() == null) goto _L2; else goto _L1
_L1:
        obj = h.f();
        if (((bss) (obj)).d == null && ((bss) (obj)).a.c != null && ((bss) (obj)).a.c.a != null)
        {
            dtu dtu1 = ((bss) (obj)).a.c.a;
            if (dtu1.a != null && !dtu1.a.isEmpty() && dtu1.c != null && dtu1.b != null)
            {
                obj.d = new bqk(dtu1);
            }
        }
        obj = ((bss) (obj)).d;
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        if (n() && !g.a(cts.e) && obj == null)
        {
            a();
            r();
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        String s = ((bqk) (obj)).a;
        obj = obj1;
        if (!TextUtils.isEmpty(s))
        {
            obj = s;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (obj == null)
        {
            obj = e();
        }
        b = bhx.a(new tn(this));
        a.a(b(), d(), ((String) (obj)), t(), c(), i, b);
        return;
    }

    protected abstract String b();

    protected abstract int c();

    protected abstract byte[] d();

    protected abstract String e();
}
