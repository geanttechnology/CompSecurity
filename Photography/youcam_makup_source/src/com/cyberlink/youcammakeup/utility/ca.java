// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            cb

public class ca
{

    private Map a;

    private ca()
    {
        a = new HashMap();
    }


    public static ca b()
    {
        return cb.a;
    }

    public long a(int i, TimeUnit timeunit)
    {
        List list = (List)a.get(Integer.valueOf(i));
        long l;
        if (list == null)
        {
            l = -1L;
        } else
        {
            i = list.size() - 1;
            if (i < 0)
            {
                return -1L;
            }
            long l1 = System.nanoTime() - ((Long)list.remove(i)).longValue();
            l = l1;
            if (timeunit != TimeUnit.NANOSECONDS)
            {
                return timeunit.convert(l1, TimeUnit.NANOSECONDS);
            }
        }
        return l;
    }

    public String a(String s)
    {
        return a(s, 0, TimeUnit.MILLISECONDS);
    }

    public String a(String s, int i, TimeUnit timeunit)
    {
        return String.format(Locale.US, s, new Object[] {
            Long.valueOf(a(i, timeunit))
        });
    }

    public void a()
    {
        a(0);
    }

    public void a(int i)
    {
        long l = System.nanoTime();
        List list = (List)a.get(Integer.valueOf(i));
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            a.put(Integer.valueOf(i), obj);
        }
        ((List) (obj)).add(Long.valueOf(l));
    }
}
