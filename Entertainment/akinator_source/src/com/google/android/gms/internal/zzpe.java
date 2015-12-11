// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.measurement.zze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzpe extends zze
{

    private ProductAction zzLI;
    private final Map zzLJ = new HashMap();
    private final List zzLK = new ArrayList();
    private final List zzLL = new ArrayList();

    public zzpe()
    {
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        if (!zzLL.isEmpty())
        {
            hashmap.put("products", zzLL);
        }
        if (!zzLK.isEmpty())
        {
            hashmap.put("promotions", zzLK);
        }
        if (!zzLJ.isEmpty())
        {
            hashmap.put("impressions", zzLJ);
        }
        hashmap.put("productAction", zzLI);
        return zzB(hashmap);
    }

    public void zza(Product product, String s)
    {
        if (product == null)
        {
            return;
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        if (!zzLJ.containsKey(s1))
        {
            zzLJ.put(s1, new ArrayList());
        }
        ((List)zzLJ.get(s1)).add(product);
    }

    public void zza(zzpe zzpe1)
    {
        zzpe1.zzLL.addAll(zzLL);
        zzpe1.zzLK.addAll(zzLK);
        for (Iterator iterator = zzLJ.entrySet().iterator(); iterator.hasNext();)
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                zzpe1.zza((Product)((Iterator) (obj)).next(), s);
            }
        }

        if (zzLI != null)
        {
            zzpe1.zzLI = zzLI;
        }
    }

    public volatile void zza(zze zze1)
    {
        zza((zzpe)zze1);
    }

    public ProductAction zzyF()
    {
        return zzLI;
    }

    public List zzyG()
    {
        return Collections.unmodifiableList(zzLL);
    }

    public Map zzyH()
    {
        return zzLJ;
    }

    public List zzyI()
    {
        return Collections.unmodifiableList(zzLK);
    }
}
