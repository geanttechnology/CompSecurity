// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package jumiomobile:
//            oz, or, pw, pv, 
//            po, pz

public class pf extends oz
{

    public pf()
    {
    }

    public pz a(ConcurrentLinkedQueue concurrentlinkedqueue)
    {
        StringBuilder stringbuilder = new StringBuilder();
        concurrentlinkedqueue = concurrentlinkedqueue.iterator();
        do
        {
            if (!concurrentlinkedqueue.hasNext())
            {
                break;
            }
            or or1 = (or)concurrentlinkedqueue.next();
            if (or1 instanceof pw)
            {
                stringbuilder.append("n");
            } else
            if (or1 instanceof pv)
            {
                stringbuilder.append("i");
            } else
            if (or1 instanceof po)
            {
                stringbuilder.append("f");
            }
        } while (true);
        return new pz("NIF Sequence", stringbuilder.toString());
    }
}
