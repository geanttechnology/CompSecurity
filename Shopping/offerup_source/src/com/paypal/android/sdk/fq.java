// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.net.ProtocolException;

// Referenced classes of package com.paypal.android.sdk:
//            gn, kc, ke, gq, 
//            gs, gm, gr, ju, 
//            fs, gd, gu, ft

public final class fq
{

    volatile boolean a;
    gq b;
    ju c;
    private final gn d;
    private boolean e;

    protected fq(gn gn1, gq gq1)
    {
        d = gn1.w();
        b = gq1;
    }

    static gn a(fq fq1)
    {
        return fq1.d;
    }

    final gu a(gq gq1, boolean flag)
    {
        gs gs1 = gq1.f();
        int i;
        if (gs1 != null)
        {
            gq1 = gq1.h();
            gm gm1 = gs1.a();
            if (gm1 != null)
            {
                gq1.a("Content-Type", gm1.toString());
            }
            long l = gs1.b();
            if (l != -1L)
            {
                gq1.a("Content-Length", Long.toString(l));
                gq1.b("Transfer-Encoding");
            } else
            {
                gq1.a("Transfer-Encoding", "chunked");
                gq1.b("Content-Length");
            }
            gq1 = gq1.a();
        }
        c = new ju(d, gq1, false, false, flag, null, null, null, null);
        i = 0;
        do
        {
            if (a)
            {
                c.g();
                throw new IOException("Canceled");
            }
            Object obj;
            try
            {
                c.a();
                c.j();
            }
            // Misplaced declaration of an exception variable
            catch (gq gq1)
            {
                throw gq1.a();
            }
            // Misplaced declaration of an exception variable
            catch (gq gq1)
            {
                obj = c.a(gq1);
                if (obj != null)
                {
                    c = ((ju) (obj));
                } else
                {
                    throw gq1.a();
                }
                continue;
            }
            // Misplaced declaration of an exception variable
            catch (gq gq1)
            {
                obj = c.a(gq1);
                if (obj != null)
                {
                    c = ((ju) (obj));
                } else
                {
                    throw gq1;
                }
                continue;
            }
            gq1 = c.e();
            obj = c.k();
            if (obj == null)
            {
                if (!flag)
                {
                    c.g();
                }
                return gq1;
            }
            i++;
            if (i > 20)
            {
                throw new ProtocolException((new StringBuilder("Too many follow-up requests: ")).append(i).toString());
            }
            if (!c.a(((gq) (obj)).a()))
            {
                c.g();
            }
            fy fy = c.i();
            c = new ju(d, ((gq) (obj)), false, false, flag, fy, null, null, gq1);
        } while (true);
    }

    public final void a()
    {
        a = true;
        if (c != null)
        {
            c.h();
        }
    }

    public final void a(ft ft)
    {
        this;
        JVM INSTR monitorenter ;
        if (e)
        {
            throw new IllegalStateException("Already Executed");
        }
        break MISSING_BLOCK_LABEL_24;
        ft;
        this;
        JVM INSTR monitorexit ;
        throw ft;
        e = true;
        this;
        JVM INSTR monitorexit ;
        d.r().a(new fs(this, ft, false, (byte)0));
        return;
    }
}
