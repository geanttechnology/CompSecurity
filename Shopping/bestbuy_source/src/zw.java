// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import org.json.JSONException;
import org.json.JSONObject;

public class zw extends abn
    implements aaf
{

    private final zh a;
    private final Object b = new Object();
    private final Context c;
    private final Object d = new Object();
    private final aak e;
    private final aea f;
    private abn g;
    private fj h;
    private vv i;

    public zw(Context context, aak aak, aea aea1, zh zh)
    {
        a = zh;
        c = context;
        e = aak;
        f = aea1;
    }

    private ay a(fh fh1)
    {
        if (h.m == null)
        {
            throw new zx("The ad response must specify one of the supported ad sizes.", 0);
        }
        Object aobj[] = h.m.split("x");
        if (aobj.length != 2)
        {
            throw new zx((new StringBuilder()).append("Could not parse the ad size from the ad response: ").append(h.m).toString(), 0);
        }
        int i1;
        int j1;
        int k1;
        try
        {
            i1 = Integer.parseInt(aobj[0]);
            j1 = Integer.parseInt(aobj[1]);
        }
        // Misplaced declaration of an exception variable
        catch (fh fh1)
        {
            throw new zx((new StringBuilder()).append("Could not parse the ad size from the ad response: ").append(h.m).toString(), 0);
        }
        aobj = fh1.d.h;
        k1 = aobj.length;
        ay ay1;
        int k;
        int l;
        for (int j = 0; j < k1; j++)
        {
            ay1 = aobj[j];
            float f1 = c.getResources().getDisplayMetrics().density;
            if (ay1.f == -1)
            {
                k = (int)((float)ay1.g / f1);
            } else
            {
                k = ay1.f;
            }
            if (ay1.c == -2)
            {
                l = (int)((float)ay1.d / f1);
            } else
            {
                l = ay1.c;
            }
            if (i1 == k && j1 == l)
            {
                return new ay(ay1, fh1.d.h);
            }
        }

        throw new zx((new StringBuilder()).append("The ad size from the ad response was not one of the requested sizes: ").append(h.m).toString(), 0);
    }

    static Object a(zw zw1)
    {
        return zw1.d;
    }

    private void a(long l)
    {
        do
        {
            if (!b(l))
            {
                throw new zx("Timed out waiting for ad response.", 2);
            }
        } while (h == null);
        synchronized (b)
        {
            g = null;
        }
        if (h.e != -2 && h.e != -3)
        {
            throw new zx((new StringBuilder()).append("There was a problem getting an ad response. ErrorCode: ").append(h.e).toString(), h.e);
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(boolean flag)
    {
        abi.a().a(flag);
        sy sy1 = abi.a().a(c);
        if (sy1 != null && !sy1.isAlive())
        {
            acb.a("start fetching content...");
            sy1.a();
        }
    }

    static zh b(zw zw1)
    {
        return zw1.a;
    }

    private boolean b(long l)
    {
        l = 60000L - (SystemClock.elapsedRealtime() - l);
        if (l <= 0L)
        {
            return false;
        }
        try
        {
            d.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new zx("Ad request cancelled.", -1);
        }
        return true;
    }

    private void c()
    {
        if (h.e != -3)
        {
            if (TextUtils.isEmpty(h.c))
            {
                throw new zx("No fill from ad server.", 3);
            }
            abi.a(c, h.u);
            if (h.h)
            {
                try
                {
                    i = new vv(h.c);
                    return;
                }
                catch (JSONException jsonexception)
                {
                    throw new zx((new StringBuilder()).append("Could not parse mediation config: ").append(h.c).toString(), 0);
                }
            }
        }
    }

    public void a()
    {
        Object obj2 = d;
        obj2;
        JVM INSTR monitorenter ;
        fh fh1;
        acb.a("AdLoaderBackgroundTask started.");
        String s = f.a().a(c);
        fh1 = new fh(e, s);
        int j;
        long l;
        long l1;
        j = -2;
        l1 = -1L;
        l = l1;
        long l2 = SystemClock.elapsedRealtime();
        l = l1;
        Object obj1 = aae.a(c, fh1, this);
        l = l1;
        Object obj = b;
        l = l1;
        obj;
        JVM INSTR monitorenter ;
        g = ((abn) (obj1));
        if (g == null)
        {
            throw new zx("Could not start the ad request service.", 0);
        }
          goto _L1
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        l = l1;
        throw exception;
        exception;
        obj = null;
_L12:
        j = exception.a();
        if (j != 3 && j != -1) goto _L3; else goto _L2
_L2:
        acb.c(exception.getMessage());
_L9:
        if (h != null) goto _L5; else goto _L4
_L4:
        h = new fj(j);
_L10:
        aca.a.post(new Runnable() {

            final zw a;

            public void run()
            {
                a.b();
            }

            
            {
                a = zw.this;
                super();
            }
        });
_L8:
        boolean flag = TextUtils.isEmpty(h.r);
        if (flag) goto _L7; else goto _L6
_L6:
        exception = new JSONObject(h.r);
_L11:
        obj = new abe(fh1, h, i, ((ay) (obj)), j, l, h.n, exception);
        aca.a.post(new Runnable(((abe) (obj))) {

            final abe a;
            final zw b;

            public void run()
            {
                synchronized (zw.a(b))
                {
                    zw.b(b).a(a);
                }
                return;
                exception1;
                obj3;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                b = zw.this;
                a = abe1;
                super();
            }
        });
        obj2;
        JVM INSTR monitorexit ;
        return;
_L1:
        obj;
        JVM INSTR monitorexit ;
        l = l1;
        a(l2);
        l = l1;
        l1 = SystemClock.elapsedRealtime();
        l = l1;
        c();
        l = l1;
        if (fh1.d.h == null)
        {
            break MISSING_BLOCK_LABEL_400;
        }
        l = l1;
        obj = a(fh1);
_L13:
        a(h.v);
        l = l1;
          goto _L8
_L3:
        acb.e(exception.getMessage());
          goto _L9
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
_L5:
        h = new fj(j, h.k);
          goto _L10
        exception;
        acb.b("Error parsing the JSON for Active View.", exception);
_L7:
        exception = null;
          goto _L11
        exception;
        l = l1;
          goto _L12
        obj = null;
          goto _L13
    }

    public void a(fj fj1)
    {
        synchronized (d)
        {
            acb.a("Received ad response.");
            h = fj1;
            d.notify();
        }
        return;
        fj1;
        obj;
        JVM INSTR monitorexit ;
        throw fj1;
    }

    public void b()
    {
        synchronized (b)
        {
            if (g != null)
            {
                g.f();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
