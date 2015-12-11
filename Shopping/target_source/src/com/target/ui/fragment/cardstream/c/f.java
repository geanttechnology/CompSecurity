// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cardstream.c;

import android.net.Uri;
import com.google.a.a.e;
import com.google.a.b.k;
import com.target.a.a.b;
import com.target.mothership.model.coupons.c;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.CouponOffer;
import com.target.mothership.model.d;
import com.target.ui.fragment.cardstream.a.a;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.cardstream.c:
//            a, e

public class f extends com.target.ui.fragment.cardstream.c.a
{

    private static final String LOG_TAG = "MobileCouponsDataSource";
    private final a mBarcodeFactory;
    private final c mCouponsManager;

    public f(j.c c1, a.a a1, c c2, a a2)
    {
        super(c1, a1, "MobileCouponsSource");
        mCouponsManager = c2;
        mBarcodeFactory = a2;
    }

    static List a(f f1, List list)
    {
        return f1.b(list);
    }

    private List b(List list)
    {
        java.util.ArrayList arraylist = k.a();
        for (list = list.iterator(); list.hasNext();)
        {
            CouponOffer couponoffer = (CouponOffer)list.next();
            String s = couponoffer.b();
            if (s == null)
            {
                com.target.a.a.b.b("MobileCouponsDataSource", (new StringBuilder()).append("Got null barcode for offer: ").append(couponoffer.d()).toString());
            } else
            {
                e e1 = mBarcodeFactory.a(s);
                if (!e1.b())
                {
                    com.target.a.a.b.b("MobileCouponsDataSource", (new StringBuilder()).append("Got back absent barcode from barcode factory for value: ").append(couponoffer.b()).toString());
                } else
                {
                    arraylist.add(new com.target.ui.fragment.cardstream.c.e(couponoffer.d(), Uri.fromFile((File)e1.c()), s, Uri.parse(couponoffer.a())));
                }
            }
        }

        return arraylist;
    }

    protected void a(final a.a onLoadedCallback)
    {
        final e absent = e.e();
        CompletedSignUp completedsignup = (CompletedSignUp)mCouponsManager.a().d();
        if (completedsignup == null)
        {
            onLoadedCallback.a(absent);
        }
        mCouponsManager.b(completedsignup, new d() {

            final f this$0;
            final e val$absent;
            final a.a val$onLoadedCallback;

            public void a(com.target.mothership.model.coupons.interfaces.a.c c1)
            {
                com.target.a.a.b.b("MobileCouponsDataSource", (new StringBuilder()).append("Error loading assigned mobile coupon offers: ").append(c1).toString());
                onLoadedCallback.a(absent);
            }

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                list = com.target.ui.fragment.cardstream.c.f.a(f.this, list);
                onLoadedCallback.a(e.b(list));
            }

            public void b(Object obj)
            {
                a((com.target.mothership.model.coupons.interfaces.a.c)obj);
            }

            
            {
                this$0 = f.this;
                onLoadedCallback = a1;
                absent = e1;
                super();
            }
        });
    }

    protected volatile boolean a(Object obj)
    {
        return a((List)obj);
    }

    protected boolean a(List list)
    {
        return list != null && !list.isEmpty();
    }
}
