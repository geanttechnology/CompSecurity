// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            co, cl, cd, cn

class u
{

    public static final String a = com/amazon/device/ads/u.getSimpleName();
    final ck.b b;
    cl c;
    final cn d;
    final dy.d e = new dy.d();

    public u(ck.b b1)
    {
        new co();
        d = co.a(a);
        b = b1;
    }

    static void a(JSONObject jsonobject, cl cl1)
    {
        if (cl1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        HashMap hashmap = new HashMap();
        Object obj = new HashMap();
        String s = cl1.b;
        if (s != null)
        {
            s = (new StringBuilder()).append(s).append("_").toString();
        }
        cl.b ab[] = (cl.b[])cl1.a().toArray(new cl.b[cl1.a().size()]);
        int k = ab.length;
        int i = 0;
        while (i < k) 
        {
            Object obj1 = ab[i];
            cl1 = ((cl.b) (obj1)).a.ag;
            if (s != null && ((cl.b) (obj1)).a.ah)
            {
                cl1 = (new StringBuilder()).append(s).append(cl1).toString();
            }
            if (obj1 instanceof cl.d)
            {
                cl1 = (cl.d)obj1;
                hashmap.put(((cl.b) (obj1)).a, Long.valueOf(((cl.d) (cl1)).b));
            } else
            if (obj1 instanceof cl.e)
            {
                cl.e e1 = (cl.e)obj1;
                obj1 = (Long)hashmap.remove(((cl.b) (obj1)).a);
                if (obj1 != null)
                {
                    cd.b(jsonobject, cl1, (cd.a(jsonobject, cl1, 0L) + e1.b) - ((Long) (obj1)).longValue());
                }
            } else
            if (obj1 instanceof cl.g)
            {
                cd.b(jsonobject, cl1, ((cl.g)obj1).b);
            } else
            if (obj1 instanceof cl.c)
            {
                cl1 = (cl.c)obj1;
                Integer integer = (Integer)((HashMap) (obj)).get(((cl.b) (obj1)).a);
                int j;
                if (integer == null)
                {
                    j = ((cl.c) (cl1)).b;
                } else
                {
                    j = integer.intValue();
                    j = ((cl.c) (cl1)).b + j;
                }
                ((HashMap) (obj)).put(((cl.b) (obj1)).a, Integer.valueOf(j));
            } else
            if (obj1 instanceof cl.f)
            {
                cd.b(jsonobject, cl1, ((cl.f)obj1).b);
            }
            i++;
        }
        obj = ((HashMap) (obj)).entrySet().iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            String s1 = ((ck.a)entry.getKey()).ag;
            cl1 = s1;
            if (s != null)
            {
                cl1 = s1;
                if (((ck.a)entry.getKey()).ah)
                {
                    cl1 = (new StringBuilder()).append(s).append(s1).toString();
                }
            }
            cd.b(jsonobject, cl1, ((Integer)entry.getValue()).intValue());
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

}
