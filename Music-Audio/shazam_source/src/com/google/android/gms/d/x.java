// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

// Referenced classes of package com.google.android.gms.d:
//            aa, y, gb, he, 
//            ct

public final class x
    implements aa
{

    public final Object a = new Object();
    public final WeakHashMap b = new WeakHashMap();
    private final ArrayList c = new ArrayList();
    private final Context d;
    private final VersionInfoParcel e;
    private final ct f;

    public x(Context context, VersionInfoParcel versioninfoparcel, ct ct)
    {
        d = context.getApplicationContext();
        e = versioninfoparcel;
        f = ct;
    }

    private boolean b(gb gb1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        gb1 = (y)b.get(gb1);
        if (gb1 == null) goto _L2; else goto _L1
_L1:
        if (!gb1.d()) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L5:
        obj;
        JVM INSTR monitorexit ;
        return flag;
        gb1;
        obj;
        JVM INSTR monitorexit ;
        throw gb1;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final y a(AdSizeParcel adsizeparcel, gb gb1)
    {
        return a(adsizeparcel, gb1, ((View) (gb1.b.getWebView())));
    }

    public final y a(AdSizeParcel adsizeparcel, gb gb1, View view)
    {
label0:
        {
            synchronized (a)
            {
                if (!b(gb1))
                {
                    break label0;
                }
                adsizeparcel = (y)b.get(gb1);
            }
            return adsizeparcel;
        }
        view = new y(adsizeparcel, gb1, e, view, f);
        synchronized (((y) (view)).a)
        {
            view.c = this;
        }
        b.put(gb1, view);
        c.add(view);
        obj;
        JVM INSTR monitorexit ;
        return view;
        adsizeparcel;
        obj;
        JVM INSTR monitorexit ;
        throw adsizeparcel;
        gb1;
        adsizeparcel;
        JVM INSTR monitorexit ;
        throw gb1;
    }

    public final void a(gb gb1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        gb1 = (y)b.get(gb1);
        if (gb1 == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        gb1.b();
        obj;
        JVM INSTR monitorexit ;
        return;
        gb1;
        obj;
        JVM INSTR monitorexit ;
        throw gb1;
    }

    public final void a(y y1)
    {
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (!y1.d())
        {
            c.remove(y1);
            Iterator iterator = b.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if (((java.util.Map.Entry)iterator.next()).getValue() == y1)
                {
                    iterator.remove();
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_77;
        y1;
        obj;
        JVM INSTR monitorexit ;
        throw y1;
        obj;
        JVM INSTR monitorexit ;
    }
}
