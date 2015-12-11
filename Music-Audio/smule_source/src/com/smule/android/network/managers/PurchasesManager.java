// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import com.smule.android.network.a.o;
import com.smule.android.network.models.ListingV2;
import com.smule.android.network.models.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.smule.android.network.managers:
//            d, v, w

public class PurchasesManager
{

    private static final String a = com/smule/android/network/managers/PurchasesManager.getName();
    private static PurchasesManager b;
    private o c;
    private List d;
    private long e;
    private long f;

    private PurchasesManager()
    {
        d = new ArrayList();
        e = 0x36ee80L;
        f = 0L;
    }

    public static PurchasesManager a()
    {
        com/smule/android/network/managers/PurchasesManager;
        JVM INSTR monitorenter ;
        PurchasesManager purchasesmanager;
        if (b == null)
        {
            b = new PurchasesManager();
        }
        purchasesmanager = b;
        com/smule/android/network/managers/PurchasesManager;
        JVM INSTR monitorexit ;
        return purchasesmanager;
        Exception exception;
        exception;
        throw exception;
    }

    static List a(PurchasesManager purchasesmanager)
    {
        return purchasesmanager.d;
    }

    static void a(PurchasesManager purchasesmanager, List list)
    {
        purchasesmanager.a(list);
    }

    private void a(List list)
    {
        this;
        JVM INSTR monitorenter ;
        Collections.sort(list, new Comparator() {

            final PurchasesManager a;

            public int a(a a1, a a2)
            {
                return a1.position - a2.position;
            }

            public int compare(Object obj, Object obj1)
            {
                return a((a)obj, (a)obj1);
            }

            
            {
                a = PurchasesManager.this;
                super();
            }
        });
        d = list;
        f = System.currentTimeMillis();
        this;
        JVM INSTR monitorexit ;
        return;
        list;
        throw list;
    }

    public int a(ListingV2 listingv2)
    {
        int i = c.a(listingv2.isFree, listingv2.productId, listingv2.listingId);
        if (!listingv2.isFree)
        {
            com.smule.android.network.managers.d.a().a(11);
        }
        return i;
    }

    public Boolean a(String s)
    {
        for (Iterator iterator = d.iterator(); iterator.hasNext();)
        {
            if (((a)iterator.next()).productUid.compareTo(s) == 0)
            {
                return Boolean.valueOf(true);
            }
        }

        return Boolean.valueOf(false);
    }

    public void a(Context context)
    {
        c = o.a();
    }

    public boolean a(String s, String s1, long l, String s2, String s3)
    {
        boolean flag = c.a(s, s1, l, s2, s3);
        if (flag)
        {
            com.smule.android.network.managers.d.a().a(10);
        }
        return flag;
    }

    public boolean b(String s)
    {
        o o1 = c;
        s = o.a(s);
        return s != null && s.a();
    }


    // Unreferenced inner class com/smule/android/network/managers/PurchasesManager$2

/* anonymous class */
    class _cls2
        implements CoinPacksListener
    {

        final w a;
        final Runnable b;
        final PurchasesManager c;

        public void handleResponse(v v1)
        {
            if (v1.a())
            {
                com.smule.android.network.managers.PurchasesManager.a(c, v1.mCoinPacks);
                a.a(com.smule.android.network.managers.PurchasesManager.a(c));
                return;
            } else
            {
                b.run();
                return;
            }
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((v)obj);
        }
    }

}
