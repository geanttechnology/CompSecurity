// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            ox, pm, or, py, 
//            pz

public class ov
    implements ox
{

    public ov()
    {
    }

    public Class a()
    {
        return jumiomobile/pm;
    }

    public pz a(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        Iterator iterator = concurrentlinkedqueue.iterator();
        double d = 0.0D;
        while (iterator.hasNext()) 
        {
            or or1 = (or)iterator.next();
            if (or1 instanceof pm)
            {
                d = ((pm)or1).b() + d;
            } else
            {
                throw new IllegalStateException((new StringBuilder("List may only contain AngleMeasurements, but contained ")).append(or1.getClass().getSimpleName()).toString());
            }
        }
        return new py(d, concurrentlinkedqueue.size(), "Average Angle");
    }
}
