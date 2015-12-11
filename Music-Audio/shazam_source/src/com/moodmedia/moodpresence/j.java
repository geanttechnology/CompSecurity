// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import java.lang.reflect.Array;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.moodmedia.moodpresence:
//            g, MoodPresence, h

class j
    implements Runnable
{

    private BlockingQueue a;
    private h b;
    private g c[][];
    private int d[];

    j(BlockingQueue blockingqueue, h h1)
    {
        c = (g[][])Array.newInstance(com/moodmedia/moodpresence/g, new int[] {
            2, 12
        });
        d = new int[2];
        a = blockingqueue;
        b = h1;
    }

    public void run()
    {
_L2:
        Object obj;
        g ag[];
        int i;
        int k;
        int i1;
        int j1;
        try
        {
            if (Thread.currentThread().isInterrupted())
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Thread.currentThread().interrupt();
            return;
        }
        obj = (g)a.take();
        i1 = ((g) (obj)).b().a();
        c[i1][d[i1]] = ((g) (obj));
        ag = c[i1];
        j1 = ag.length;
        i = 0;
        k = 0;
_L3:
        if (i < j1)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        if (k >= MoodPresence.INSTANCE.getMinHits())
        {
            ((g) (obj)).a(k);
            b.handleDetection(((g) (obj)));
        }
        obj = d;
        obj[i1] = obj[i1] + 1;
        if (d[i1] != 12) goto _L2; else goto _L1
_L1:
        d[i1] = 0;
          goto _L2
        boolean flag = ((g) (obj)).a(ag[i]);
        int l = k;
        if (flag)
        {
            l = k + 1;
        }
        i++;
        k = l;
          goto _L3
    }
}
