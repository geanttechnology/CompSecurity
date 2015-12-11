// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            bf, dd

public class dx
{

    private static final Map a;
    private static final Set b;

    public dx()
    {
    }

    public static bf a(bf bf1)
    {
        Map map = bf1.b;
        HashMap hashmap = new HashMap();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            if (!dd.b(s))
            {
                if (b.contains(s))
                {
                    (new StringBuilder("SC key ")).append(s).append(" not used in FPTI, skipping");
                } else
                if (!a.containsKey(s))
                {
                    (new StringBuilder("No mapping for SC key ")).append(s).append(", skipping");
                } else
                {
                    String s1 = (String)a.get(s);
                    if (s1 != null)
                    {
                        hashmap.put(s1, map.get(s));
                    }
                }
            }
        } while (true);
        return new bf(bf1.a, hashmap);
    }

    static 
    {
        com/paypal/android/sdk/dx.getSimpleName();
        Object obj = new HashMap();
        a = ((Map) (obj));
        ((Map) (obj)).put("c14", "erpg");
        a.put("c25", "page");
        a.put("c26", "link");
        a.put("c27", "pgln");
        a.put("c29", "eccd");
        a.put("c35", "lgin");
        a.put("vers", "vers");
        a.put("c50", "rsta");
        a.put("gn", "pgrp");
        a.put("v49", "mapv");
        a.put("v51", "mcar");
        a.put("v52", "mosv");
        a.put("v53", "mdvs");
        a.put("clid", "clid");
        a.put("apid", "apid");
        a.put("calc", "calc");
        a.put("e", "e");
        a.put("t", "t");
        a.put("g", "g");
        a.put("srce", "srce");
        a.put("vid", "vid");
        a.put("bchn", "bchn");
        a.put("adte", "adte");
        a.put("sv", "sv");
        a.put("dsid", "dsid");
        a.put("bzsr", "bzsr");
        a.put("prid", "prid");
        obj = new HashSet();
        b = ((Set) (obj));
        ((Set) (obj)).add("v25");
        b.add("v31");
        b.add("c37");
    }
}
