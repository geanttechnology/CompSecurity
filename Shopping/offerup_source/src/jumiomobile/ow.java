// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            oz, ox, or, pq, 
//            pz

public class ow extends oz
    implements ox
{

    public ow()
    {
    }

    private float b(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        if (concurrentlinkedqueue == null || concurrentlinkedqueue.size() <= 1)
        {
            return 0.0F;
        }
        ArrayList arraylist = new ArrayList();
        concurrentlinkedqueue = concurrentlinkedqueue.iterator();
        do
        {
            if (!concurrentlinkedqueue.hasNext())
            {
                break;
            }
            or or1 = (or)concurrentlinkedqueue.next();
            if (or1 instanceof pq)
            {
                arraylist.add(Long.valueOf(((pq)or1).a()));
            }
        } while (true);
        float f = ((Long)arraylist.get(arraylist.size() - 1)).longValue() - ((Long)arraylist.get(0)).longValue();
        return (float)arraylist.size() / (f / 1000F);
    }

    public pz a(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        return new pz("Average Frames/sec", Double.valueOf(b(concurrentlinkedqueue)));
    }
}
