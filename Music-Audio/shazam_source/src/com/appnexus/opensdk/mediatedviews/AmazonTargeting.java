// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.util.Pair;
import com.amazon.device.ads.af;
import com.amazon.device.ads.c;
import com.amazon.device.ads.cn;
import com.amazon.device.ads.dq;
import com.appnexus.opensdk.at;
import com.appnexus.opensdk.b.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            AmazonParameters

class AmazonTargeting
{

    AmazonTargeting()
    {
    }

    static af a(c c1, at at1, String s)
    {
        af af1 = new af();
        s = new AmazonParameters(s);
        if (at1 != null)
        {
            Iterator iterator;
            boolean flag;
            if (!k.a(at1.a))
            {
                try
                {
                    Integer.parseInt(at1.a);
                    af1.h.b("setAge API has been deprecated.", null);
                }
                catch (NumberFormatException numberformatexception) { }
            }
            for (iterator = at1.b.iterator(); iterator.hasNext();)
            {
                Object obj = (Pair)iterator.next();
                String s1 = (String)((Pair) (obj)).first;
                obj = (String)((Pair) (obj)).second;
                if (dq.b(s1))
                {
                    throw new IllegalArgumentException("Option Key must not be null or empty string");
                }
                if (obj != null)
                {
                    af1.a.put(s1, obj);
                } else
                {
                    af1.a.remove(s1);
                }
            }

            if (at1.d != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            af1.e = flag;
            if (((AmazonParameters) (s)).c)
            {
                af1.d = ((AmazonParameters) (s)).d;
            }
        }
        if (((AmazonParameters) (s)).a)
        {
            c1.setTimeout(((AmazonParameters) (s)).b);
        }
        return af1;
    }
}
