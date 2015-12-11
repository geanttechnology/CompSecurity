// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.store.handler;

import com.target.mothership.common.store.b;
import com.target.mothership.model.store.interfaces.StoreDetail;
import com.target.mothership.services.aa;
import com.target.mothership.services.e.h.b.a;
import com.target.mothership.services.e.h.b.d;
import com.target.mothership.services.e.h.b.e;
import com.target.mothership.services.e.h.b.g;
import com.target.mothership.services.e.h.b.h;
import com.target.mothership.services.e.h.b.k;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.target.mothership.model.store.handler:
//            c, TGTStoreDetail, TGTStoreAddress, TGTAddress, 
//            TGTStorePhoneNumber, TGTStoreOperatingHours, TGTAlternateStoreOperatingHours, TGTStoreCapability

class this._cls0
    implements aa
{

    final c this$0;

    public StoreDetail a(List list)
    {
        list = (h)list.get(0);
        TGTStoreDetail tgtstoredetail = new TGTStoreDetail(list.a());
        tgtstoredetail.a(b.a(list.h()));
        tgtstoredetail.a(list.b());
        tgtstoredetail.a(new TGTStoreAddress(new TGTAddress(list.c().a(), list.c().b(), list.c().g(), list.c().f(), list.c().c(), list.c().e())));
        Object obj = new ArrayList();
        e e1;
        for (Iterator iterator = list.d().iterator(); iterator.hasNext(); ((List) (obj)).add(new TGTStorePhoneNumber(e1.b(), e1.a())))
        {
            e1 = (e)iterator.next();
        }

        tgtstoredetail.a(((List) (obj)));
        obj = new ArrayList();
        d d1;
        for (Iterator iterator1 = list.e().iterator(); iterator1.hasNext(); ((List) (obj)).add(new TGTStoreOperatingHours(d1.b(), d1.a(), d1.c().a(), d1.c().b())))
        {
            d1 = (d)iterator1.next();
        }

        tgtstoredetail.b(((List) (obj)));
        obj = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
        ((SimpleDateFormat) (obj)).setTimeZone(TimeZone.getDefault());
        ArrayList arraylist = new ArrayList();
        if (list.f() != null)
        {
            TGTAlternateStoreOperatingHours tgtalternatestoreoperatinghours;
            for (Iterator iterator2 = list.f().iterator(); iterator2.hasNext(); arraylist.add(tgtalternatestoreoperatinghours))
            {
                Object obj2 = (com.target.mothership.services.e.h.b.b)iterator2.next();
                tgtalternatestoreoperatinghours = new TGTAlternateStoreOperatingHours();
                ((SimpleDateFormat) (obj)).setTimeZone(TimeZone.getDefault());
                tgtalternatestoreoperatinghours.a(((SimpleDateFormat) (obj)).parse(((com.target.mothership.services.e.h.b.b) (obj2)).a(), new ParsePosition(0)));
                tgtalternatestoreoperatinghours.b(((SimpleDateFormat) (obj)).parse(((com.target.mothership.services.e.h.b.b) (obj2)).b(), new ParsePosition(0)));
                ArrayList arraylist1 = new ArrayList();
                if (((com.target.mothership.services.e.h.b.b) (obj2)).c() != null)
                {
                    d d3;
                    for (obj2 = ((com.target.mothership.services.e.h.b.b) (obj2)).c().iterator(); ((Iterator) (obj2)).hasNext(); arraylist1.add(new TGTStoreOperatingHours(d3.b(), d3.a(), d3.c().a(), d3.c().b())))
                    {
                        d3 = (d)((Iterator) (obj2)).next();
                    }

                }
                tgtalternatestoreoperatinghours.a(arraylist1);
            }

        }
        tgtstoredetail.c(arraylist);
        arraylist = new ArrayList();
        TGTStoreCapability tgtstorecapability;
        for (Iterator iterator3 = list.g().iterator(); iterator3.hasNext(); arraylist.add(tgtstorecapability))
        {
            Object obj1 = (g)iterator3.next();
            tgtstorecapability = new TGTStoreCapability();
            tgtstorecapability.a(((g) (obj1)).a());
            tgtstorecapability.a(com.target.mothership.common.store.a.a(((g) (obj1)).a()));
            tgtstorecapability.a(((SimpleDateFormat) (obj)).parse(((g) (obj1)).b(), new ParsePosition(0)));
            if (((g) (obj1)).c() != null)
            {
                list = ((SimpleDateFormat) (obj)).parse(((g) (obj1)).c(), new ParsePosition(0));
            } else
            {
                list = null;
            }
            tgtstorecapability.b(list);
            list = new ArrayList();
            if (((g) (obj1)).e() != null)
            {
                e e2;
                for (Iterator iterator4 = ((g) (obj1)).e().iterator(); iterator4.hasNext(); list.add(new TGTStorePhoneNumber(e2.b(), e2.a())))
                {
                    e2 = (e)iterator4.next();
                }

            }
            tgtstorecapability.b(list);
            list = new ArrayList();
            if (((g) (obj1)).d() != null)
            {
                d d2;
                for (obj1 = ((g) (obj1)).d().iterator(); ((Iterator) (obj1)).hasNext(); list.add(new TGTStoreOperatingHours(d2.b(), d2.a(), d2.c().a(), d2.c().b())))
                {
                    d2 = (d)((Iterator) (obj1)).next();
                }

            }
            tgtstorecapability.a(list);
        }

        tgtstoredetail.d(arraylist);
        return tgtstoredetail;
    }

    public volatile Object a(Object obj)
    {
        return a((List)obj);
    }

    toreDetail()
    {
        this$0 = c.this;
        super();
    }
}
