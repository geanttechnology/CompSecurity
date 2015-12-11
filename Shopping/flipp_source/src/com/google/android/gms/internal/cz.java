// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.android.gms.common.g;
import org.json.JSONException;

// Referenced classes of package com.google.android.gms.internal:
//            ee, df, fb, cb, 
//            dd, bz, x, et, 
//            jg, fl, cu, dh, 
//            eg, er, da, at, 
//            eb, db, di, ao, 
//            al, dc, ew, ej, 
//            ar, bq, cy, bn, 
//            dk

public final class cz extends ee
    implements df, fb
{

    final cy a;
    final ew b;
    final Object c = new Object();
    cb d;
    private final bn g;
    private final Object h = new Object();
    private final Context i;
    private final dk j;
    private final jg k;
    private ee l;
    private boolean m;
    private al n;
    private ao o;
    private at p;

    public cz(Context context, dk dk, jg jg1, ew ew1, bn bn, cy cy)
    {
        m = false;
        g = bn;
        a = cy;
        b = ew1;
        i = context;
        j = dk;
        k = jg1;
    }

    private x a(bz bz1)
    {
        if (d.m == null)
        {
            throw new dd("The ad response must specify one of the supported ad sizes.", 0);
        }
        Object aobj[] = d.m.split("x");
        if (aobj.length != 2)
        {
            throw new dd((new StringBuilder("Could not parse the ad size from the ad response: ")).append(d.m).toString(), 0);
        }
        int l1;
        int i2;
        int j2;
        try
        {
            l1 = Integer.parseInt(aobj[0]);
            i2 = Integer.parseInt(aobj[1]);
        }
        // Misplaced declaration of an exception variable
        catch (bz bz1)
        {
            throw new dd((new StringBuilder("Could not parse the ad size from the ad response: ")).append(d.m).toString(), 0);
        }
        aobj = bz1.d.h;
        j2 = aobj.length;
        x x1;
        int j1;
        int k1;
        for (int i1 = 0; i1 < j2; i1++)
        {
            x1 = aobj[i1];
            float f = i.getResources().getDisplayMetrics().density;
            if (x1.f == -1)
            {
                j1 = (int)((float)x1.g / f);
            } else
            {
                j1 = x1.f;
            }
            if (x1.c == -2)
            {
                k1 = (int)((float)x1.d / f);
            } else
            {
                k1 = x1.c;
            }
            if (l1 == j1 && i2 == k1)
            {
                return new x(x1, bz1.d.h);
            }
        }

        throw new dd((new StringBuilder("The ad size from the ad response was not one of the requested sizes: ")).append(d.m).toString(), 0);
    }

    private void a(long l1)
    {
        do
        {
            if (!b(l1))
            {
                throw new dd("Timed out waiting for WebView to finish loading.", 2);
            }
        } while (!m);
    }

    private boolean b(long l1)
    {
        l1 = 60000L - (SystemClock.elapsedRealtime() - l1);
        if (l1 <= 0L)
        {
            return false;
        }
        try
        {
            c.wait(l1);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new dd("Ad request cancelled.", -1);
        }
        return true;
    }

    public final void a()
    {
        Object obj5 = c;
        obj5;
        JVM INSTR monitorenter ;
        Object obj4;
        et.a("AdLoaderBackgroundTask started.");
        String s = k.a().a(i);
        obj4 = new bz(j, s);
        Object obj1;
        Object obj2;
        Object obj3;
        int i1;
        obj3 = null;
        obj2 = null;
        i1 = -2;
        obj1 = obj2;
        long l1 = SystemClock.elapsedRealtime();
        obj1 = obj2;
        Object obj = i;
        obj1 = obj2;
        if (!((bz) (obj4)).k.e) goto _L2; else goto _L1
_L1:
        obj1 = obj2;
        et.a("Fetching ad response from local ad request service.");
        obj1 = obj2;
        obj = new dh(((Context) (obj)), ((bz) (obj4)), this);
        obj1 = obj2;
        eg.a(((ee) (obj)).e);
_L14:
        obj1 = obj2;
        Object obj6 = h;
        obj1 = obj2;
        obj6;
        JVM INSTR monitorenter ;
        l = ((ee) (obj));
        if (l == null)
        {
            throw new dd("Could not start the ad request service.", 0);
        }
          goto _L3
        obj;
        obj6;
        JVM INSTR monitorexit ;
        obj1 = obj2;
        ew ew1;
        java.util.List list;
        java.util.List list1;
        java.util.List list2;
        String s1;
        ao ao1;
        int j1;
        boolean flag;
        try
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        finally { }
        i1 = ((dd) (obj)).a;
        if (i1 != 3 && i1 != -1) goto _L5; else goto _L4
_L4:
        et.b(((dd) (obj)).getMessage());
_L22:
        d = new cb(i1);
        er.a.post(new da(this));
        obj = obj1;
_L20:
        obj6 = ((bz) (obj4)).c;
        ew1 = b;
        list = d.d;
        list1 = d.f;
        list2 = d.j;
        j1 = d.l;
        l1 = d.k;
        s1 = ((bz) (obj4)).i;
        flag = d.h;
        if (p == null) goto _L7; else goto _L6
_L6:
        obj1 = p.b;
_L23:
        if (p == null) goto _L9; else goto _L8
_L8:
        obj2 = p.c;
_L24:
        if (p == null) goto _L11; else goto _L10
_L10:
        obj3 = p.d;
_L25:
        ao1 = o;
        if (p == null) goto _L13; else goto _L12
_L12:
        obj4 = p.e;
_L26:
        obj = new eb(((v) (obj6)), ew1, list, i1, list1, list2, j1, l1, s1, flag, ((an) (obj1)), ((bq) (obj2)), ((String) (obj3)), ao1, ((aq) (obj4)), d.i, ((x) (obj)), d.g);
        er.a.post(new db(this, ((eb) (obj))));
        obj5;
        JVM INSTR monitorexit ;
        return;
_L2:
        obj1 = obj2;
        et.a("Fetching ad response from remote ad request service.");
        obj1 = obj2;
        if (com.google.android.gms.common.g.a(((Context) (obj))) == 0)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        obj1 = obj2;
        et.d("Failed to connect to remote ad request service.");
        obj = null;
          goto _L14
        obj1 = obj2;
        obj = new di(((Context) (obj)), ((bz) (obj4)), this);
          goto _L14
        obj5;
        JVM INSTR monitorexit ;
        throw obj;
_L3:
        obj6;
        JVM INSTR monitorexit ;
_L16:
        obj1 = obj2;
        if (b(l1))
        {
            break MISSING_BLOCK_LABEL_505;
        }
        obj1 = obj2;
        throw new dd("Timed out waiting for ad response.", 2);
        obj1 = obj2;
        if (d == null) goto _L16; else goto _L15
_L15:
        obj1 = obj2;
        obj = h;
        obj1 = obj2;
        obj;
        JVM INSTR monitorenter ;
        l = null;
        obj;
        JVM INSTR monitorexit ;
        obj1 = obj2;
        if (d.e == -2)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        obj1 = obj2;
        if (d.e == -3)
        {
            break MISSING_BLOCK_LABEL_609;
        }
        obj1 = obj2;
        throw new dd((new StringBuilder("There was a problem getting an ad response. ErrorCode: ")).append(d.e).toString(), d.e);
        obj3;
        obj;
        JVM INSTR monitorexit ;
        obj1 = obj2;
        throw obj3;
        obj1 = obj2;
        if (d.e == -3)
        {
            break MISSING_BLOCK_LABEL_688;
        }
        obj1 = obj2;
        if (!TextUtils.isEmpty(d.c))
        {
            break MISSING_BLOCK_LABEL_652;
        }
        obj1 = obj2;
        throw new dd("No fill from ad server.", 3);
        obj1 = obj2;
        boolean flag1 = d.h;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_688;
        }
        obj1 = obj2;
        o = new ao(d.c);
        obj1 = obj2;
        obj = obj3;
        if (((bz) (obj4)).d.h == null)
        {
            break MISSING_BLOCK_LABEL_713;
        }
        obj1 = obj2;
        obj = a(((bz) (obj4)));
        obj1 = obj;
        if (!d.h) goto _L18; else goto _L17
_L17:
        obj1 = obj;
        obj2 = h;
        obj1 = obj;
        obj2;
        JVM INSTR monitorenter ;
        n = new al(i, ((bz) (obj4)), g, o);
        obj2;
        JVM INSTR monitorexit ;
        obj1 = obj;
        p = n.a(l1);
        obj1 = obj;
        p.a;
        JVM INSTR tableswitch 0 1: default 960
    //                   0 963
    //                   1 886;
           goto _L19 _L20 _L21
_L19:
        obj1 = obj;
        throw new dd((new StringBuilder("Unexpected mediation result: ")).append(p.a).toString(), 0);
        obj;
        obj1 = obj2;
        throw new dd((new StringBuilder("Could not parse mediation config: ")).append(d.c).toString(), 0);
        obj3;
        obj2;
        JVM INSTR monitorexit ;
        obj1 = obj;
        throw obj3;
_L21:
        obj1 = obj;
        throw new dd("No fill from any mediation ad networks.", 3);
_L18:
        obj1 = obj;
        er.a.post(new dc(this));
        obj1 = obj;
        a(l1);
          goto _L20
_L5:
        et.d(((dd) (obj)).getMessage());
          goto _L22
_L7:
        obj1 = null;
          goto _L23
_L9:
        obj2 = null;
          goto _L24
_L11:
        obj3 = null;
          goto _L25
_L13:
        obj4 = null;
          goto _L26
    }

    public final void a(cb cb1)
    {
        synchronized (c)
        {
            et.a("Received ad response.");
            d = cb1;
            c.notify();
        }
        return;
        cb1;
        obj;
        JVM INSTR monitorexit ;
        throw cb1;
    }

    public final void a(ew ew1)
    {
        synchronized (c)
        {
            et.a("WebView finished loading.");
            m = true;
            c.notify();
        }
        return;
        exception;
        ew1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void b_()
    {
        Object obj = h;
        obj;
        JVM INSTR monitorenter ;
        if (l != null)
        {
            l.e();
        }
        b.stopLoading();
        ej.a(b);
        if (n == null) goto _L2; else goto _L1
_L1:
        Object obj2 = n;
        Object obj1 = ((al) (obj2)).a;
        obj1;
        JVM INSTR monitorenter ;
        obj2.b = true;
        if (((al) (obj2)).c == null) goto _L4; else goto _L3
_L3:
        ar ar1 = ((al) (obj2)).c;
        obj2 = ar1.e;
        obj2;
        JVM INSTR monitorenter ;
        if (ar1.g != null)
        {
            ar1.g.c();
        }
_L5:
        ar1.h = -1;
        ar1.e.notify();
_L4:
        obj1;
        JVM INSTR monitorexit ;
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        RemoteException remoteexception;
        remoteexception;
        et.a("Could not destroy mediation adapter.", remoteexception);
          goto _L5
        Exception exception2;
        exception2;
        obj2;
        JVM INSTR monitorexit ;
        throw exception2;
        Exception exception1;
        exception1;
        obj1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
