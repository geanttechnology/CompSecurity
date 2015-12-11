// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import org.json.JSONException;

// Referenced classes of package com.google.android.gms.internal:
//            cm, cb, bz, x, 
//            as, ay, au, cs, 
//            ct, h, d, bw, 
//            cj, cw, co, bb, 
//            cx

public final class bv extends cm
    implements bw.a, cx.a
{
    private static final class a extends Exception
    {

        private final int hm;

        public int getErrorCode()
        {
            return hm;
        }

        public a(String s, int i)
        {
            super(s);
            hm = i;
        }
    }


    private final bb ed;
    private final Object fx = new Object();
    private au fy;
    private final cw gv;
    private final bu.a hb;
    private final Object hc = new Object();
    private final bz.a hd;
    private final h he;
    private cm hf;
    private cb hg;
    private boolean hh;
    private as hi;
    private ay hj;
    private final Context mContext;

    public bv(Context context, bz.a a1, h h1, cw cw1, bb bb, bu.a a2)
    {
        hh = false;
        ed = bb;
        hb = a2;
        gv = cw1;
        mContext = context;
        hd = a1;
        he = h1;
    }

    private x a(bz bz1)
        throws a
    {
        if (hg.hB == null)
        {
            throw new a("The ad response must specify one of the supported ad sizes.", 0);
        }
        Object aobj[] = hg.hB.split("x");
        if (aobj.length != 2)
        {
            throw new a((new StringBuilder()).append("Could not parse the ad size from the ad response: ").append(hg.hB).toString(), 0);
        }
        int l;
        int i1;
        int j1;
        try
        {
            l = Integer.parseInt(aobj[0]);
            i1 = Integer.parseInt(aobj[1]);
        }
        // Misplaced declaration of an exception variable
        catch (bz bz1)
        {
            throw new a((new StringBuilder()).append("Could not parse the ad size from the ad response: ").append(hg.hB).toString(), 0);
        }
        aobj = bz1.em.eH;
        j1 = aobj.length;
        x x1;
        int j;
        int k;
        for (int i = 0; i < j1; i++)
        {
            x1 = aobj[i];
            float f = mContext.getResources().getDisplayMetrics().density;
            if (x1.width == -1)
            {
                j = (int)((float)x1.widthPixels / f);
            } else
            {
                j = x1.width;
            }
            if (x1.height == -2)
            {
                k = (int)((float)x1.heightPixels / f);
            } else
            {
                k = x1.height;
            }
            if (l == j && i1 == k)
            {
                return new x(x1, bz1.em.eH);
            }
        }

        throw new a((new StringBuilder()).append("The ad size from the ad response was not one of the requested sizes: ").append(hg.hB).toString(), 0);
    }

    static Object a(bv bv1)
    {
        return bv1.fx;
    }

    private void a(bz bz1, long l)
        throws a
    {
        synchronized (hc)
        {
            hi = new as(mContext, bz1, ed, fy);
        }
        hj = hi.a(l, 60000L);
        switch (hj.ga)
        {
        default:
            throw new a((new StringBuilder()).append("Unexpected mediation result: ").append(hj.ga).toString(), 0);

        case 1: // '\001'
            throw new a("No fill from any mediation ad networks.", 3);

        case 0: // '\0'
            return;
        }
        bz1;
        obj;
        JVM INSTR monitorexit ;
        throw bz1;
    }

    private void aj()
        throws a
    {
        if (hg.errorCode != -3)
        {
            if (TextUtils.isEmpty(hg.hw))
            {
                throw new a("No fill from ad server.", 3);
            }
            if (hg.hy)
            {
                try
                {
                    fy = new au(hg.hw);
                    return;
                }
                catch (JSONException jsonexception)
                {
                    throw new a((new StringBuilder()).append("Could not parse mediation config: ").append(hg.hw).toString(), 0);
                }
            }
        }
    }

    static bu.a b(bv bv1)
    {
        return bv1.hb;
    }

    private void b(long l)
        throws a
    {
        cs.iI.post(new Runnable() {

            final bv hk;

            public void run()
            {
label0:
                {
                    synchronized (bv.a(hk))
                    {
                        if (bv.c(hk).errorCode == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                bv.d(hk).aC().a(hk);
                if (bv.c(hk).errorCode != -3)
                {
                    break MISSING_BLOCK_LABEL_119;
                }
                ct.u((new StringBuilder()).append("Loading URL in WebView: ").append(bv.c(hk).gL).toString());
                bv.d(hk).loadUrl(bv.c(hk).gL);
_L1:
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
                ct.u("Loading HTML in WebView.");
                bv.d(hk).loadDataWithBaseURL(co.o(bv.c(hk).gL), bv.c(hk).hw, "text/html", "UTF-8", null);
                  goto _L1
            }

            
            {
                hk = bv.this;
                super();
            }
        });
        d(l);
    }

    static cb c(bv bv1)
    {
        return bv1.hg;
    }

    private void c(long l)
        throws a
    {
        do
        {
            if (!e(l))
            {
                throw new a("Timed out waiting for ad response.", 2);
            }
        } while (hg == null);
        synchronized (hc)
        {
            hf = null;
        }
        if (hg.errorCode != -2 && hg.errorCode != -3)
        {
            throw new a((new StringBuilder()).append("There was a problem getting an ad response. ErrorCode: ").append(hg.errorCode).toString(), hg.errorCode);
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static cw d(bv bv1)
    {
        return bv1.gv;
    }

    private void d(long l)
        throws a
    {
        do
        {
            if (!e(l))
            {
                throw new a("Timed out waiting for WebView to finish loading.", 2);
            }
        } while (!hh);
    }

    private boolean e(long l)
        throws a
    {
        l = 60000L - (SystemClock.elapsedRealtime() - l);
        if (l <= 0L)
        {
            return false;
        }
        try
        {
            fx.wait(l);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new a("Ad request cancelled.", -1);
        }
        return true;
    }

    public void a(cb cb1)
    {
        synchronized (fx)
        {
            ct.r("Received ad response.");
            hg = cb1;
            fx.notify();
        }
        return;
        cb1;
        obj;
        JVM INSTR monitorexit ;
        throw cb1;
    }

    public void a(cw cw1)
    {
        synchronized (fx)
        {
            ct.r("WebView finished loading.");
            hh = true;
            fx.notify();
        }
        return;
        exception;
        cw1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void ai()
    {
        Object obj4 = fx;
        obj4;
        JVM INSTR monitorenter ;
        Object obj2;
        ct.r("AdLoaderBackgroundTask started.");
        String s = he.g().a(mContext);
        obj2 = new bz(hd, s);
        Object obj;
        Object obj1;
        bc bc;
        int i;
        obj = null;
        bc = null;
        i = -2;
        obj1 = bc;
        long l = SystemClock.elapsedRealtime();
        obj1 = bc;
        cm cm1 = bw.a(mContext, ((bz) (obj2)), this);
        obj1 = bc;
        Object obj3 = hc;
        obj1 = bc;
        obj3;
        JVM INSTR monitorenter ;
        hf = cm1;
        if (hf == null)
        {
            throw new a("Could not start the ad request service.", 0);
        }
          goto _L1
        obj;
        obj3;
        JVM INSTR monitorexit ;
        Exception exception;
        obj1 = bc;
        v v;
        cw cw1;
        java.util.List list;
        java.util.List list1;
        java.util.List list2;
        String s1;
        au au1;
        int j;
        boolean flag;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        i = ((a) (obj)).getErrorCode();
        if (i != 3 && i != -1) goto _L3; else goto _L2
_L2:
        ct.t(((a) (obj)).getMessage());
_L11:
        hg = new cb(i);
        cs.iI.post(new Runnable() {

            final bv hk;

            public void run()
            {
                hk.onStop();
            }

            
            {
                hk = bv.this;
                super();
            }
        });
        obj = obj1;
_L10:
        v = ((bz) (obj2)).hr;
        cw1 = gv;
        list = hg.fK;
        list1 = hg.fL;
        list2 = hg.hA;
        j = hg.orientation;
        l = hg.fO;
        s1 = ((bz) (obj2)).hu;
        flag = hg.hy;
        if (hj == null) goto _L5; else goto _L4
_L4:
        obj1 = hj.gb;
_L12:
        if (hj == null) goto _L7; else goto _L6
_L6:
        bc = hj.gc;
_L13:
        if (hj == null) goto _L9; else goto _L8
_L8:
        obj2 = hj.gd;
_L14:
        au1 = fy;
        if (hj == null)
        {
            break MISSING_BLOCK_LABEL_497;
        }
        obj3 = hj.ge;
_L15:
        obj = new cj(v, cw1, list, i, list1, list2, j, l, s1, flag, ((at) (obj1)), bc, ((String) (obj2)), au1, ((aw) (obj3)), hg.hz, ((x) (obj)), hg.hx);
        cs.iI.post(new Runnable(((cj) (obj))) {

            final bv hk;
            final cj hl;

            public void run()
            {
                synchronized (bv.a(hk))
                {
                    bv.b(hk).a(hl);
                }
                return;
                exception1;
                obj5;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                hk = bv.this;
                hl = cj1;
                super();
            }
        });
        obj4;
        JVM INSTR monitorexit ;
        return;
_L1:
        obj3;
        JVM INSTR monitorexit ;
        obj1 = bc;
        c(l);
        obj1 = bc;
        aj();
        obj1 = bc;
        if (((bz) (obj2)).em.eH == null)
        {
            break MISSING_BLOCK_LABEL_429;
        }
        obj1 = bc;
        obj = a(((bz) (obj2)));
        obj1 = obj;
        if (!hg.hy)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        obj1 = obj;
        a(((bz) (obj2)), l);
          goto _L10
        obj1 = obj;
        b(l);
          goto _L10
        obj4;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        ct.v(exception.getMessage());
          goto _L11
_L5:
        obj1 = null;
          goto _L12
_L7:
        bc = null;
          goto _L13
_L9:
        obj2 = null;
          goto _L14
        obj3 = null;
          goto _L15
    }

    public void onStop()
    {
        synchronized (hc)
        {
            if (hf != null)
            {
                hf.cancel();
            }
            gv.stopLoading();
            co.a(gv);
            if (hi != null)
            {
                hi.cancel();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
