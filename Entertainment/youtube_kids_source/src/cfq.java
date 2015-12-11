// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class cfq
    implements Runnable
{

    private cfm a;

    cfq(cfm cfm1)
    {
        a = cfm1;
        super();
    }

    public final void run()
    {
        Iterator iterator;
        long l;
        iterator = cfm.a(a).iterator();
        l = 9400L;
_L2:
        Object obj1;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (Future)iterator.next();
        long l1;
        l1 = System.currentTimeMillis();
        ((Future) (obj1)).get(l, TimeUnit.MILLISECONDS);
        l1 = Math.max(0L, l - (System.currentTimeMillis() - l1));
        l = l1;
        continue; /* Loop/switch isn't completed */
        obj1;
        Log.w(cfm.b(), "Error waiting for reading device response task to complete", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        obj1;
        Log.w(cfm.b(), "Error waiting for reading device response task to complete", ((Throwable) (obj1)));
        continue; /* Loop/switch isn't completed */
        TimeoutException timeoutexception;
        timeoutexception;
        Log.w(cfm.b(), "Timed out waiting for device response");
        ((Future) (obj1)).cancel(true);
        if (true) goto _L2; else goto _L1
_L1:
        Object obj = new ArrayList();
        Iterator iterator1 = cfm.b(a).keySet().iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            String s1 = (String)iterator1.next();
            cgw cgw1 = (cgw)cfm.b(a).get(s1);
            if (!cfm.c(a).containsKey(cgw1))
            {
                ((List) (obj)).add(s1);
            }
        } while (true);
        String s;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); cfm.b(a).remove(s))
        {
            s = (String)((Iterator) (obj)).next();
        }

        cfm.d(a).clear();
        cfm.c(a).clear();
        cfm.e(a).clear();
        cfm.a(a, false);
        return;
    }
}
