// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package commonlib.manager:
//            SyncManager

protected static class queue
    implements Iterable
{

    private ArrayList queue;

    public void add(Runnable runnable)
    {
        queue.add(runnable);
    }

    public void clear()
    {
        queue.clear();
    }

    public Iterator iterator()
    {
        return queue.iterator();
    }

    public int size()
    {
        return queue.size();
    }

    protected ()
    {
        queue = new ArrayList();
    }
}
