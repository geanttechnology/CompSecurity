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
//            ct, cf, cd, ab, 
//            aw, bc, ay, cz, 
//            da, l, h, ca, 
//            cn, dd, cv, bf, 
//            de

public final class bz extends ct
    implements ca.a, de.a
{
    private static final class a extends Exception
    {

        private final int nX;

        public int getErrorCode()
        {
            return nX;
        }

        public a(String s, int i)
        {
            super(s);
            nX = i;
        }
    }


    private final bf kH;
    private final Context mContext;
    private final Object mg = new Object();
    private ay mh;
    private final by.a nM;
    private final Object nN = new Object();
    private final cd.a nO;
    private final l nP;
    private ct nQ;
    private cf nR;
    private boolean nS;
    private aw nT;
    private bc nU;
    private final dd ng;

    public bz(Context context, cd.a a1, l l1, dd dd1, bf bf, by.a a2)
    {
        nS = false;
        kH = bf;
        nM = a2;
        ng = dd1;
        mContext = context;
        nO = a1;
        nP = l1;
    }

    private ab a(cd cd1)
        throws a
    {
        if (nR.on == null)
        {
            throw new a("The ad response must specify one of the supported ad sizes.", 0);
        }
        Object aobj[] = nR.on.split("x");
        if (aobj.length != 2)
        {
            throw new a((new StringBuilder()).append("Could not parse the ad size from the ad response: ").append(nR.on).toString(), 0);
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
        catch (cd cd1)
        {
            throw new a((new StringBuilder()).append("Could not parse the ad size from the ad response: ").append(nR.on).toString(), 0);
        }
        aobj = cd1.kQ.lp;
        k1 = aobj.length;
        ab ab1;
        int j;
        int k;
        for (int i = 0; i < k1; i++)
        {
            ab1 = aobj[i];
            float f = mContext.getResources().getDisplayMetrics().density;
            if (ab1.width == -1)
            {
                j = (int)((float)ab1.widthPixels / f);
            } else
            {
                j = ab1.width;
            }
            if (ab1.height == -2)
            {
                k = (int)((float)ab1.heightPixels / f);
            } else
            {
                k = ab1.height;
            }
            if (i1 == j && j1 == k)
            {
                return new ab(ab1, cd1.kQ.lp);
            }
        }

        throw new a((new StringBuilder()).append("The ad size from the ad response was not one of the requested sizes: ").append(nR.on).toString(), 0);
    }

    static Object a(bz bz1)
    {
        return bz1.mg;
    }

    private void a(cd cd1, long l1)
        throws a
    {
        synchronized (nN)
        {
            nT = new aw(mContext, cd1, kH, mh);
        }
        nU = nT.a(l1, 60000L);
        switch (nU.mL)
        {
        default:
            throw new a((new StringBuilder()).append("Unexpected mediation result: ").append(nU.mL).toString(), 0);

        case 1: // '\001'
            throw new a("No fill from any mediation ad networks.", 3);

        case 0: // '\0'
            return;
        }
        cd1;
        obj;
        JVM INSTR monitorexit ;
        throw cd1;
    }

    private void aC()
        throws a
    {
        if (nR.errorCode != -3)
        {
            if (TextUtils.isEmpty(nR.oi))
            {
                throw new a("No fill from ad server.", 3);
            }
            if (nR.ok)
            {
                try
                {
                    mh = new ay(nR.oi);
                    return;
                }
                catch (JSONException jsonexception)
                {
                    throw new a((new StringBuilder()).append("Could not parse mediation config: ").append(nR.oi).toString(), 0);
                }
            }
        }
    }

    static by.a b(bz bz1)
    {
        return bz1.nM;
    }

    private void b(long l1)
        throws a
    {
        cz.pT.post(new Runnable() {

            final bz nV;

            public void run()
            {
label0:
                {
                    synchronized (bz.a(nV))
                    {
                        if (bz.c(nV).errorCode == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                bz.d(nV).bb().a(nV);
                if (bz.c(nV).errorCode != -3)
                {
                    break MISSING_BLOCK_LABEL_119;
                }
                da.v((new StringBuilder()).append("Loading URL in WebView: ").append(bz.c(nV).nw).toString());
                bz.d(nV).loadUrl(bz.c(nV).nw);
_L1:
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
                da.v("Loading HTML in WebView.");
                bz.d(nV).loadDataWithBaseURL(cv.p(bz.c(nV).nw), bz.c(nV).oi, "text/html", "UTF-8", null);
                  goto _L1
            }

            
            {
                nV = bz.this;
                super();
            }
        });
        d(l1);
    }

    static cf c(bz bz1)
    {
        return bz1.nR;
    }

    private void c(long l1)
        throws a
    {
        do
        {
            if (!e(l1))
            {
                throw new a("Timed out waiting for ad response.", 2);
            }
        } while (nR == null);
        synchronized (nN)
        {
            nQ = null;
        }
        if (nR.errorCode != -2 && nR.errorCode != -3)
        {
            throw new a((new StringBuilder()).append("There was a problem getting an ad response. ErrorCode: ").append(nR.errorCode).toString(), nR.errorCode);
        } else
        {
            return;
        }
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static dd d(bz bz1)
    {
        return bz1.ng;
    }

    private void d(long l1)
        throws a
    {
        do
        {
            if (!e(l1))
            {
                throw new a("Timed out waiting for WebView to finish loading.", 2);
            }
        } while (!nS);
    }

    private boolean e(long l1)
        throws a
    {
        l1 = 60000L - (SystemClock.elapsedRealtime() - l1);
        if (l1 <= 0L)
        {
            return false;
        }
        try
        {
            mg.wait(l1);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new a("Ad request cancelled.", -1);
        }
        return true;
    }

    public void a(cf cf1)
    {
        synchronized (mg)
        {
            da.s("Received ad response.");
            nR = cf1;
            mg.notify();
        }
        return;
        cf1;
        obj;
        JVM INSTR monitorexit ;
        throw cf1;
    }

    public void a(dd dd1)
    {
        synchronized (mg)
        {
            da.s("WebView finished loading.");
            nS = true;
            mg.notify();
        }
        return;
        exception;
        dd1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void aB()
    {
        Object obj4 = mg;
        obj4;
        JVM INSTR monitorenter ;
        Object obj2;
        da.s("AdLoaderBackgroundTask started.");
        String s = nP.y().a(mContext);
        obj2 = new cd(nO, s);
        Object obj;
        Object obj1;
        bg bg;
        int i;
        long l1;
        long l2;
        obj = null;
        bg = null;
        i = -2;
        l2 = -1L;
        obj1 = bg;
        l1 = l2;
        long l3 = SystemClock.elapsedRealtime();
        obj1 = bg;
        l1 = l2;
        ct ct1 = ca.a(mContext, ((cd) (obj2)), this);
        obj1 = bg;
        l1 = l2;
        Object obj3 = nN;
        obj1 = bg;
        l1 = l2;
        obj3;
        JVM INSTR monitorenter ;
        nQ = ct1;
        if (nQ == null)
        {
            throw new a("Could not start the ad request service.", 0);
        }
          goto _L1
        obj;
        obj3;
        JVM INSTR monitorexit ;
        Exception exception;
        obj1 = bg;
        l1 = l2;
        z z;
        dd dd1;
        java.util.List list;
        java.util.List list1;
        java.util.List list2;
        String s1;
        ay ay1;
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
        da.u(((a) (obj)).getMessage());
_L12:
        nR = new cf(i);
        cz.pT.post(new Runnable() {

            final bz nV;

            public void run()
            {
                nV.onStop();
            }

            
            {
                nV = bz.this;
                super();
            }
        });
        obj = obj1;
_L17:
        z = ((cd) (obj2)).oc;
        dd1 = ng;
        list = nR.mt;
        list1 = nR.mu;
        list2 = nR.om;
        j = nR.orientation;
        l2 = nR.mx;
        s1 = ((cd) (obj2)).of;
        flag = nR.ok;
        if (nU == null) goto _L5; else goto _L4
_L4:
        obj1 = nU.mM;
_L13:
        if (nU == null) goto _L7; else goto _L6
_L6:
        bg = nU.mN;
_L14:
        if (nU == null) goto _L9; else goto _L8
_L8:
        obj2 = nU.mO;
_L15:
        ay1 = mh;
        if (nU == null) goto _L11; else goto _L10
_L10:
        obj3 = nU.mP;
_L16:
        obj = new cn(z, dd1, list, i, list1, list2, j, l2, s1, flag, ((ax) (obj1)), bg, ((String) (obj2)), ay1, ((ba) (obj3)), nR.ol, ((ab) (obj)), nR.oj, l1, nR.oo);
        cz.pT.post(new Runnable(((cn) (obj))) {

            final bz nV;
            final cn nW;

            public void run()
            {
                synchronized (bz.a(nV))
                {
                    bz.b(nV).a(nW);
                }
                return;
                exception1;
                obj5;
                JVM INSTR monitorexit ;
                throw exception1;
            }

            
            {
                nV = bz.this;
                nW = cn1;
                super();
            }
        });
        obj4;
        JVM INSTR monitorexit ;
        return;
_L1:
        obj3;
        JVM INSTR monitorexit ;
        obj1 = bg;
        l1 = l2;
        c(l3);
        obj1 = bg;
        l1 = l2;
        l2 = SystemClock.elapsedRealtime();
        obj1 = bg;
        l1 = l2;
        aC();
        obj1 = bg;
        l1 = l2;
        if (((cd) (obj2)).kQ.lp == null)
        {
            break MISSING_BLOCK_LABEL_490;
        }
        obj1 = bg;
        l1 = l2;
        obj = a(((cd) (obj2)));
        obj1 = obj;
        l1 = l2;
        if (!nR.ok)
        {
            break MISSING_BLOCK_LABEL_523;
        }
        obj1 = obj;
        l1 = l2;
        a(((cd) (obj2)), l3);
        break MISSING_BLOCK_LABEL_576;
        obj1 = obj;
        l1 = l2;
        b(l3);
        break MISSING_BLOCK_LABEL_576;
        obj4;
        JVM INSTR monitorexit ;
        throw exception;
_L3:
        da.w(exception.getMessage());
          goto _L12
_L5:
        obj1 = null;
          goto _L13
_L7:
        bg = null;
          goto _L14
_L9:
        obj2 = null;
          goto _L15
_L11:
        obj3 = null;
          goto _L16
        l1 = l2;
          goto _L17
    }

    public void onStop()
    {
        synchronized (nN)
        {
            if (nQ != null)
            {
                nQ.cancel();
            }
            ng.stopLoading();
            cv.a(ng);
            if (nT != null)
            {
                nT.cancel();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
