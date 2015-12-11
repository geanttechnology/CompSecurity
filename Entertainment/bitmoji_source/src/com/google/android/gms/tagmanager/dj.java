// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            dg, df, bh, DataLayer, 
//            di

class dj extends dg
{

    private static final String ID;
    private static final String XR;
    private static final String XS;
    private static final String XT;
    private static final String XU;
    private static final String XV;
    private static final String XW;
    private static Map XX;
    private static Map XY;
    private final DataLayer TN;
    private final Set XZ;
    private final df Ya;

    public dj(Context context, DataLayer datalayer)
    {
        this(context, datalayer, new df(context));
    }

    dj(Context context, DataLayer datalayer, df df1)
    {
        super(ID, new String[0]);
        TN = datalayer;
        Ya = df1;
        XZ = new HashSet();
        XZ.add("");
        XZ.add("0");
        XZ.add("false");
    }

    private Map E(Map map)
    {
        map = (com.google.android.gms.internal.d.a)map.get(XV);
        if (map != null)
        {
            return c(map);
        }
        if (XX == null)
        {
            map = new HashMap();
            map.put("transactionId", "&ti");
            map.put("transactionAffiliation", "&ta");
            map.put("transactionTax", "&tt");
            map.put("transactionShipping", "&ts");
            map.put("transactionTotal", "&tr");
            map.put("transactionCurrency", "&cu");
            XX = map;
        }
        return XX;
    }

    private Map F(Map map)
    {
        map = (com.google.android.gms.internal.d.a)map.get(XW);
        if (map != null)
        {
            return c(map);
        }
        if (XY == null)
        {
            map = new HashMap();
            map.put("name", "&in");
            map.put("sku", "&ic");
            map.put("category", "&iv");
            map.put("price", "&ip");
            map.put("quantity", "&iq");
            map.put("currency", "&cu");
            XY = map;
        }
        return XY;
    }

    private void a(Tracker tracker, Map map)
    {
        String s = bN("transactionId");
        if (s != null) goto _L2; else goto _L1
_L1:
        bh.t("Cannot find transactionId in data layer.");
_L4:
        return;
_L2:
        LinkedList linkedlist;
        Object obj;
        linkedlist = new LinkedList();
        try
        {
            obj = p((com.google.android.gms.internal.d.a)map.get(XT));
            ((Map) (obj)).put("&t", "transaction");
            java.util.Map.Entry entry;
            for (Iterator iterator = E(map).entrySet().iterator(); iterator.hasNext(); b(((Map) (obj)), (String)entry.getValue(), bN((String)entry.getKey())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (Tracker tracker)
        {
            bh.c("Unable to send transaction", tracker);
            return;
        }
        linkedlist.add(obj);
        obj = kv();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_337;
        }
        obj = ((List) (obj)).iterator();
_L3:
        Map map1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_337;
        }
        map1 = (Map)((Iterator) (obj)).next();
        if (map1.get("name") == null)
        {
            bh.t("Unable to send transaction item hit due to missing 'name' field.");
            return;
        }
        Map map2;
        map2 = p((com.google.android.gms.internal.d.a)map.get(XT));
        map2.put("&t", "item");
        map2.put("&ti", s);
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = F(map).entrySet().iterator(); iterator1.hasNext(); b(map2, (String)entry1.getValue(), (String)map1.get(entry1.getKey())))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        linkedlist.add(map2);
          goto _L3
        map = linkedlist.iterator();
        while (map.hasNext()) 
        {
            tracker.send((Map)map.next());
        }
          goto _L4
    }

    private void b(Map map, String s, String s1)
    {
        if (s1 != null)
        {
            map.put(s, s1);
        }
    }

    private String bN(String s)
    {
        s = ((String) (TN.get(s)));
        if (s == null)
        {
            return null;
        } else
        {
            return s.toString();
        }
    }

    private Map c(com.google.android.gms.internal.d.a a1)
    {
        a1 = ((com.google.android.gms.internal.d.a) (di.o(a1)));
        if (!(a1 instanceof Map))
        {
            return null;
        }
        Object obj = (Map)a1;
        a1 = new LinkedHashMap();
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); a1.put(entry.getKey().toString(), entry.getValue().toString()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        return a1;
    }

    private boolean d(Map map, String s)
    {
        map = (com.google.android.gms.internal.d.a)map.get(s);
        if (map == null)
        {
            return false;
        } else
        {
            return di.n(map).booleanValue();
        }
    }

    private List kv()
    {
        Object obj = TN.get("transactionProducts");
        if (obj == null)
        {
            return null;
        }
        if (!(obj instanceof List))
        {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        for (Iterator iterator = ((List)obj).iterator(); iterator.hasNext();)
        {
            if (!(iterator.next() instanceof Map))
            {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }

        return (List)obj;
    }

    private Map p(com.google.android.gms.internal.d.a a1)
    {
        if (a1 == null)
        {
            return new HashMap();
        }
        a1 = c(a1);
        if (a1 == null)
        {
            return new HashMap();
        }
        String s = (String)a1.get("&aip");
        if (s != null && XZ.contains(s.toLowerCase()))
        {
            a1.remove("&aip");
        }
        return a1;
    }

    public void w(Map map)
    {
        Tracker tracker = Ya.bF("_GTM_DEFAULT_TRACKER_");
        if (d(map, XS))
        {
            tracker.send(p((com.google.android.gms.internal.d.a)map.get(XT)));
            return;
        }
        if (d(map, XU))
        {
            a(tracker, map);
            return;
        } else
        {
            bh.w("Ignoring unknown tag.");
            return;
        }
    }

    static 
    {
        ID = a.aQ.toString();
        XR = b.bg.toString();
        XS = b.bp.toString();
        XT = b.bo.toString();
        XU = b.er.toString();
        XV = b.et.toString();
        XW = b.ev.toString();
    }
}
