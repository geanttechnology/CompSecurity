// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.amazon.device.ads:
//            dn, cn

final class a
    implements Runnable
{

    final Context a;
    final dn b;

    public final void run()
    {
        dn dn1 = b;
        Object obj = a;
        if (!dn1.b())
        {
            obj = ((Context) (obj)).getSharedPreferences("AmazonMobileAds", 0);
            Iterator iterator1 = ((SharedPreferences) (obj)).getAll().entrySet().iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                Object obj1 = (java.util.ntry)iterator1.next();
                String s = (String)((java.util.ntry) (obj1)).getKey();
                if (s != null && !dn1.c.containsKey(s))
                {
                    obj1 = ((java.util.ntry) (obj1)).getValue();
                    if (obj1 != null)
                    {
                        dn1.c.put(s, new <init>(dn1, obj1.getClass(), obj1));
                    } else
                    {
                        dn1.f.c("Could not cache null value for SharedPreferences setting: %s", new Object[] {
                            s
                        });
                    }
                }
            } while (true);
            dn1.d = ((SharedPreferences) (obj));
            dn1.a(((SharedPreferences) (obj)));
        }
        dn1.e.countDown();
        dn1.b.lock();
        for (Iterator iterator = dn1.a.iterator(); iterator.hasNext(); ((r)iterator.next()).e()) { }
        dn1.a.clear();
        dn1.a = null;
        dn1.b.unlock();
    }

    ReentrantLock(dn dn1, Context context)
    {
        b = dn1;
        a = context;
        super();
    }
}
