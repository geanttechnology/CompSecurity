// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            ox, pv, or, py, 
//            pz

public class pa
    implements ox
{

    public pa()
    {
    }

    public Class a()
    {
        return jumiomobile/pv;
    }

    public pz a(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        long l = 0L;
        concurrentlinkedqueue = new ArrayList(concurrentlinkedqueue);
        for (int i = 1; i < concurrentlinkedqueue.size(); i++)
        {
            l += ((or)concurrentlinkedqueue.get(i)).a() - ((or)concurrentlinkedqueue.get(i - 1)).a();
        }

        return new py(l, concurrentlinkedqueue.size(), "Frame processing time");
    }
}
