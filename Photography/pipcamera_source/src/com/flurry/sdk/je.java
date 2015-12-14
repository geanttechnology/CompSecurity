// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            kj, js, jr, lf, 
//            lh, kc, lo, lk, 
//            ju, jl, jf, jm, 
//            jj, jo, ji, jq

public class je
    implements kj
{

    private static final String a = com/flurry/sdk/je.getSimpleName();

    public je()
    {
    }

    public static je a()
    {
        com/flurry/sdk/je;
        JVM INSTR monitorenter ;
        je je1 = (je)js.a().a(com/flurry/sdk/je);
        com/flurry/sdk/je;
        JVM INSTR monitorexit ;
        return je1;
        Exception exception;
        exception;
        throw exception;
    }

    private jr a(lf lf1)
    {
        if (lf1 == null)
        {
            return null;
        } else
        {
            return (jr)lf1.c(com/flurry/sdk/jr);
        }
    }

    private jr m()
    {
        return a(lh.a().e());
    }

    public void a(Context context)
    {
        lf.a(com/flurry/sdk/jr);
        kc.a();
        lo.a();
        lk.a();
        ju.a();
        jl.a();
        jf.a();
        jm.a();
        jj.a();
        jf.a();
        jo.a();
        ji.a();
        jq.a();
    }

    public void a(String s)
    {
        jr jr1 = m();
        if (jr1 != null)
        {
            jr1.a(s);
        }
    }

    public void a(String s, String s1)
    {
        jr jr1 = m();
        if (jr1 != null)
        {
            jr1.a(s, s1);
        }
    }

    public void b()
    {
        jq.b();
        ji.b();
        jo.b();
        jf.b();
        jj.b();
        jm.b();
        jf.b();
        jl.b();
        ju.b();
        lk.b();
        lo.b();
        kc.b();
        lf.b(com/flurry/sdk/jr);
    }

    public void b(String s)
    {
        jr jr1 = m();
        if (jr1 != null)
        {
            jr1.b(s);
        }
    }

    public String c()
    {
        String s = null;
        jr jr1 = m();
        if (jr1 != null)
        {
            s = jr1.b();
        }
        return s;
    }

    public long d()
    {
        long l1 = 0L;
        jr jr1 = m();
        if (jr1 != null)
        {
            l1 = jr1.c();
        }
        return l1;
    }

    public long e()
    {
        long l1 = 0L;
        jr jr1 = m();
        if (jr1 != null)
        {
            l1 = jr1.d();
        }
        return l1;
    }

    public long f()
    {
        long l1 = -1L;
        jr jr1 = m();
        if (jr1 != null)
        {
            l1 = jr1.e();
        }
        return l1;
    }

    public long g()
    {
        long l1 = 0L;
        jr jr1 = m();
        if (jr1 != null)
        {
            l1 = jr1.g();
        }
        return l1;
    }

    public long h()
    {
        long l1 = 0L;
        jr jr1 = m();
        if (jr1 != null)
        {
            l1 = jr1.f();
        }
        return l1;
    }

    public String i()
    {
        jr jr1 = m();
        if (jr1 != null)
        {
            return jr1.h();
        } else
        {
            return null;
        }
    }

    public String j()
    {
        jr jr1 = m();
        if (jr1 != null)
        {
            return jr1.i();
        } else
        {
            return null;
        }
    }

    public Map k()
    {
        jr jr1 = m();
        if (jr1 != null)
        {
            return jr1.j();
        } else
        {
            return null;
        }
    }

    public jl.a l()
    {
        return jl.a().d();
    }

}
