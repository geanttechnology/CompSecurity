// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v7:
//            mp, te, ul, mn, 
//            pm

public class mm
    implements mp
{

    private final Object a = new Object();
    private final WeakHashMap b = new WeakHashMap();
    private final ArrayList c = new ArrayList();
    private final Context d;
    private final VersionInfoParcel e;
    private final pm f;

    public mm(Context context, VersionInfoParcel versioninfoparcel, pm pm)
    {
        d = context.getApplicationContext();
        e = versioninfoparcel;
        f = pm;
    }

    public mn a(AdSizeParcel adsizeparcel, te te1)
    {
        return a(adsizeparcel, te1, ((View) (te1.b.getWebView())));
    }

    public mn a(AdSizeParcel adsizeparcel, te te1, View view)
    {
label0:
        {
            synchronized (a)
            {
                if (!a(te1))
                {
                    break label0;
                }
                adsizeparcel = (mn)b.get(te1);
            }
            return adsizeparcel;
        }
        adsizeparcel = new mn(adsizeparcel, te1, e, view, f);
        adsizeparcel.a(this);
        b.put(te1, adsizeparcel);
        c.add(adsizeparcel);
        obj;
        JVM INSTR monitorexit ;
        return adsizeparcel;
        adsizeparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adsizeparcel;
    }

    public void a(mn mn1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (!mn1.f())
        {
            c.remove(mn1);
            Iterator iterator = b.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((java.util.Map.Entry)iterator.next()).getValue() == mn1)
                {
                    iterator.remove();
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_77;
        mn1;
        obj;
        JVM INSTR monitorexit ;
        throw mn1;
        obj;
        JVM INSTR monitorexit ;
    }

    public boolean a(te te1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        te1 = (mn)b.get(te1);
        if (te1 == null) goto _L2; else goto _L1
_L1:
        if (!te1.f()) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        te1;
        obj;
        JVM INSTR monitorexit ;
        throw te1;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void b(te te1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        te1 = (mn)b.get(te1);
        if (te1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        te1.d();
        obj;
        JVM INSTR monitorexit ;
        return;
        te1;
        obj;
        JVM INSTR monitorexit ;
        throw te1;
    }

    public void c(te te1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        te1 = (mn)b.get(te1);
        if (te1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        te1.l();
        obj;
        JVM INSTR monitorexit ;
        return;
        te1;
        obj;
        JVM INSTR monitorexit ;
        throw te1;
    }

    public void d(te te1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        te1 = (mn)b.get(te1);
        if (te1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        te1.m();
        obj;
        JVM INSTR monitorexit ;
        return;
        te1;
        obj;
        JVM INSTR monitorexit ;
        throw te1;
    }

    public void e(te te1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        te1 = (mn)b.get(te1);
        if (te1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        te1.n();
        obj;
        JVM INSTR monitorexit ;
        return;
        te1;
        obj;
        JVM INSTR monitorexit ;
        throw te1;
    }
}
