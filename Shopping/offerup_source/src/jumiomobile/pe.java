// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            ox, pu, or, pz, 
//            py

public class pe
    implements ox
{

    public pe()
    {
    }

    public Class a()
    {
        return jumiomobile/pu;
    }

    public pz a(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        Iterator iterator = concurrentlinkedqueue.iterator();
        double d;
        or or1;
        for (d = 0.0D; iterator.hasNext(); d = (double)((pu)or1).d() + d)
        {
            or1 = (or)iterator.next();
            if (!(or1 instanceof pu))
            {
                throw new IllegalArgumentException("Only ImageRotateMeasurements allowed!");
            }
        }

        if (d == 0.0D)
        {
            return new pz("Image rotation duration", Integer.valueOf(0));
        } else
        {
            return new py(d, concurrentlinkedqueue.size(), "Image rotation duration");
        }
    }
}
