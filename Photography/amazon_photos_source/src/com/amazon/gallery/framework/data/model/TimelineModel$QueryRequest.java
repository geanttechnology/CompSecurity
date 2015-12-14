// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.framework.model.TimelineQuery;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.data.model:
//            TimelineModel

public class r
    implements Runnable
{

    private r listenerList[];
    private final TimelineQuery query;
    private volatile boolean run;
    final TimelineModel this$0;

    public void run()
    {
        List list;
        Object obj;
        list = null;
        obj = null;
        Map map = TimelineModel.access$100(TimelineModel.this);
        map;
        JVM INSTR monitorenter ;
        List list1;
        List list2;
        if (!run)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        list2 = (List)TimelineModel.access$100(TimelineModel.this).get(query);
        list1 = get(query);
        list = obj;
        if (!run)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        list = obj;
        if (!list1.equals(list2))
        {
            list = list1;
        }
        run = false;
        map;
        JVM INSTR monitorexit ;
        if (list != null)
        {
            r ar[] = listenerList;
            int j = ar.length;
            for (int i = 0; i < j; i++)
            {
                ar[i].onTimelineChanged(list);
            }

        }
        break MISSING_BLOCK_LABEL_136;
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
        listenerList = new r[0];
        return;
    }

    private transient r(TimelineQuery timelinequery, r ar[])
    {
        this$0 = TimelineModel.this;
        super();
        run = true;
        query = timelinequery;
        listenerList = ar;
    }

    r(TimelineQuery timelinequery, r ar[], r r)
    {
        this(timelinequery, ar);
    }
}
