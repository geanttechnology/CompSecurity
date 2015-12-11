// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.Gender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package u.aly:
//            ai, bi, bc, ak, 
//            ba, ag, ax, bg, 
//            u, bf, p, h, 
//            f, d, w, aj, 
//            ah, at, as

public class q
{

    private List a;
    private ah b;
    private ai c;
    private ak d;
    private ax e;
    private Context f;

    public q(Context context)
    {
        a = new ArrayList();
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
        f = context;
    }

    private void a(Context context)
    {
        try
        {
            c.a(AnalyticsConfig.getAppkey(context));
            c.e(AnalyticsConfig.getChannel(context));
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null)
            {
                c.f(AnalyticsConfig.mWrapperType);
                c.g(AnalyticsConfig.mWrapperVersion);
            }
            c.c(bi.u(context));
            c.a(bc.a);
            c.d("5.2.4");
            c.b(bi.d(context));
            c.a(Integer.parseInt(bi.c(context)));
            if (AnalyticsConfig.mVerticalType == 1)
            {
                c.c(AnalyticsConfig.mVerticalType);
                c.d("5.2.4.1");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
    }

    private void b(Context context)
    {
        try
        {
            d.f(bi.a());
            d.a(bi.f(context));
            d.b(bi.g(context));
            d.c(bi.p(context));
            d.e(Build.MODEL);
            d.g("Android");
            d.h(android.os.Build.VERSION.RELEASE);
            context = bi.r(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        d.a(new ba(context[1], context[0]));
        if (AnalyticsConfig.GPU_RENDERER != null)
        {
            context = AnalyticsConfig.GPU_VENDER;
        }
        d.i(Build.BOARD);
        d.j(Build.BRAND);
        d.a(Build.TIME);
        d.k(Build.MANUFACTURER);
        d.l(Build.ID);
        d.m(Build.DEVICE);
        return;
    }

    private void c(Context context)
    {
        String as[] = bi.j(context);
        if (!"Wi-Fi".equals(as[0])) goto _L2; else goto _L1
_L1:
        e.a(ag.c);
_L3:
        if (!"".equals(as[1]))
        {
            e.e(as[1]);
        }
        e.c(bi.s(context));
        as = bi.n(context);
        e.b(as[0]);
        e.a(as[1]);
        e.a(bi.m(context));
        if (AnalyticsConfig.sAge != 0 || AnalyticsConfig.sGender != null || AnalyticsConfig.sId != null || AnalyticsConfig.sSource != null)
        {
            context = new bg();
            context.a(AnalyticsConfig.sAge);
            context.a(Gender.transGender(AnalyticsConfig.sGender));
            context.a(AnalyticsConfig.sId);
            context.b(AnalyticsConfig.sSource);
            e.a(context);
            return;
        }
        break MISSING_BLOCK_LABEL_223;
_L2:
label0:
        {
            if (!"2G/3G".equals(as[0]))
            {
                break label0;
            }
            e.a(ag.b);
        }
          goto _L3
        try
        {
            e.a(ag.a);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return;
        }
          goto _L3
    }

    private String i()
    {
        return u.a(f).getString("session_id", null);
    }

    public Context a()
    {
        return f;
    }

    public void a(ah ah)
    {
        this;
        JVM INSTR monitorenter ;
        b = ah;
        this;
        JVM INSTR monitorexit ;
        return;
        ah;
        throw ah;
    }

    public void a(bf bf1)
    {
        String s;
        s = i();
        if (s == null)
        {
            return;
        }
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = a.iterator();
_L1:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_118;
        }
        a.clear();
        if (b != null)
        {
            bf1.a(b);
            b = null;
        }
        this;
        JVM INSTR monitorexit ;
        bf1.a(c());
        bf1.a(d());
        bf1.a(e());
        bf1.a(h());
        bf1.a(f());
        bf1.a(g());
        return;
        ((p)iterator.next()).a(bf1, s);
          goto _L1
        bf1;
        this;
        JVM INSTR monitorexit ;
        throw bf1;
    }

    public void a(p p1)
    {
        this;
        JVM INSTR monitorenter ;
        a.add(p1);
        this;
        JVM INSTR monitorexit ;
        return;
        p1;
        throw p1;
    }

    protected boolean a(int j)
    {
        return true;
    }

    public int b()
    {
        this;
        JVM INSTR monitorenter ;
        ah ah;
        int k;
        k = a.size();
        ah = b;
        int j;
        j = k;
        if (ah != null)
        {
            j = k + 1;
        }
        this;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        throw exception;
    }

    public ai c()
    {
        this;
        JVM INSTR monitorenter ;
        ai ai1;
        if (c == null)
        {
            c = new ai();
            a(f);
        }
        ai1 = c;
        this;
        JVM INSTR monitorexit ;
        return ai1;
        Exception exception;
        exception;
        throw exception;
    }

    public ak d()
    {
        this;
        JVM INSTR monitorenter ;
        ak ak1;
        if (d == null)
        {
            d = new ak();
            b(f);
        }
        ak1 = d;
        this;
        JVM INSTR monitorexit ;
        return ak1;
        Exception exception;
        exception;
        throw exception;
    }

    public ax e()
    {
        this;
        JVM INSTR monitorenter ;
        ax ax1;
        if (e == null)
        {
            e = new ax();
            c(f);
        }
        ax1 = e;
        this;
        JVM INSTR monitorexit ;
        return ax1;
        Exception exception;
        exception;
        throw exception;
    }

    public at f()
    {
        at at;
        try
        {
            at = u.aly.h.b(f).a();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return at;
    }

    public as g()
    {
        as as;
        try
        {
            as = u.aly.h.a(f).b();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return as;
    }

    public aj h()
    {
        aj aj1;
        try
        {
            aj1 = w.a(f);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return new aj();
        }
        return aj1;
    }
}
