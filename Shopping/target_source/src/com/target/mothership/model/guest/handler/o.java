// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.text.Html;
import com.target.mothership.common.product.Tcin;
import com.target.mothership.model.guest.interfaces.OrderSummaryProduct;
import com.target.mothership.services.aa;
import com.target.mothership.services.apigee.i.b.a;
import com.target.mothership.services.apigee.i.b.b;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTOrderSummaryProduct, TGTOrderHistoryYearGroup, TGTOrderSummary

class o
    implements aa
{

    private static final String DATE_FORMAT = "MMM d,yyyy";
    private static final int INVALID_YEAR = -1;
    private static final String TRUE = "true";
    private static final int ZERO_QUANTITY = 0;

    o()
    {
    }

    private int a(Date date)
    {
        if (date == null)
        {
            return -1;
        } else
        {
            Calendar calendar = Calendar.getInstance(Locale.US);
            calendar.setTime(date);
            return calendar.get(1);
        }
    }

    private OrderSummaryProduct a(com.target.mothership.services.apigee.i.b.b.a a1)
    {
        TGTOrderSummaryProduct tgtordersummaryproduct = new TGTOrderSummaryProduct();
        tgtordersummaryproduct.l(Html.fromHtml(a1.b()).toString());
        tgtordersummaryproduct.a(new Tcin(a1.c()));
        tgtordersummaryproduct.b(a1.d());
        tgtordersummaryproduct.a(a1.e());
        a1 = a1.a();
        int i;
        if (com.target.mothership.util.o.g(a1))
        {
            i = Double.valueOf(a1).intValue();
        } else
        {
            i = 0;
        }
        tgtordersummaryproduct.b(i);
        return tgtordersummaryproduct;
    }

    private Date a(String s)
    {
        if (!com.target.mothership.util.o.g(s))
        {
            return null;
        } else
        {
            return (new SimpleDateFormat("MMM d,yyyy", Locale.US)).parse(s, new ParsePosition(0));
        }
    }

    private List a(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList(hashmap.size());
        TGTOrderHistoryYearGroup tgtorderhistoryyeargroup;
        for (hashmap = hashmap.entrySet().iterator(); hashmap.hasNext(); arraylist.add(tgtorderhistoryyeargroup))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)hashmap.next();
            tgtorderhistoryyeargroup = new TGTOrderHistoryYearGroup();
            tgtorderhistoryyeargroup.a(((Integer)entry.getKey()).intValue());
            tgtorderhistoryyeargroup.a((List)entry.getValue());
        }

        return arraylist;
    }

    private boolean b(String s)
    {
        return com.target.mothership.util.o.g(s) && "true".equalsIgnoreCase(s);
    }

    public volatile Object a(Object obj)
    {
        return a((a)obj);
    }

    public List a(a a1)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        Iterator iterator = a1.a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a1 = (b)iterator.next();
            TGTOrderSummary tgtordersummary = new TGTOrderSummary();
            tgtordersummary.a(a1.a());
            tgtordersummary.b(a1.h());
            tgtordersummary.a(a(a1.i()));
            tgtordersummary.a(b(a1.c()));
            tgtordersummary.c(b(a1.g()));
            tgtordersummary.b(b(a1.f()));
            tgtordersummary.d(b(a1.b()));
            tgtordersummary.e(b(a1.d()));
            tgtordersummary.f(b(a1.e()));
            int i;
            if (a1.j() != null)
            {
                Object obj = a1.j();
                a1 = new ArrayList(((List) (obj)).size());
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); a1.add(a((com.target.mothership.services.apigee.i.b.b.a)((Iterator) (obj)).next()))) { }
                tgtordersummary.a(a1);
            } else
            {
                tgtordersummary.a(Collections.emptyList());
            }
            i = a(tgtordersummary.b());
            if (i != -1)
            {
                a1 = new ArrayList();
                if (linkedhashmap.containsKey(Integer.valueOf(i)))
                {
                    a1 = (List)linkedhashmap.get(Integer.valueOf(i));
                }
                a1.add(tgtordersummary);
                linkedhashmap.put(Integer.valueOf(i), a1);
            }
        } while (true);
        return a(((HashMap) (linkedhashmap)));
    }
}
