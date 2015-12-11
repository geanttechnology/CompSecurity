// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            gk, gl, gq, gg, 
//            gu

public class bv
    implements gk
{

    public bv()
    {
    }

    public final gu a(gl gl1)
    {
        gq gq1 = gl1.a();
        gg gg1 = gq1.e();
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        int j = gg1.a();
        for (int i = 0; i < j; i++)
        {
            String s1 = gg1.a(i);
            List list = (List)linkedhashmap.get(s1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList(2);
                linkedhashmap.put(s1, obj);
            }
            ((List) (obj)).add(gg1.b(i));
        }

        for (Iterator iterator = linkedhashmap.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Iterator iterator1 = ((List)entry.getValue()).iterator();
            while (iterator1.hasNext()) 
            {
                String s = (String)iterator1.next();
                (new StringBuilder()).append((String)entry.getKey()).append("=").append(s);
            }
        }

        return gl1.a(gq1);
    }

    static 
    {
        com/paypal/android/sdk/bv.getSimpleName();
    }
}
