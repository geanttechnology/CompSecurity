// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.model;

import com.amazon.gallery.framework.data.dao.sqlite.GalleryDBConnectionManager;
import com.amazon.gallery.framework.model.TimelineQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.data.model:
//            TimelineQueryImpl

public class TimelineModel
{
    public static interface ChangeListener
    {

        public abstract void onTimelineChanged(List list);
    }

    public class QueryRequest
        implements Runnable
    {

        private ChangeListener listenerList[];
        private final TimelineQuery query;
        private volatile boolean run;
        final TimelineModel this$0;

        public void run()
        {
            List list;
            Object obj;
            list = null;
            obj = null;
            Map map = cache;
            map;
            JVM INSTR monitorenter ;
            List list1;
            List list2;
            if (!run)
            {
                break MISSING_BLOCK_LABEL_85;
            }
            list2 = (List)cache.get(query);
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
                ChangeListener achangelistener[] = listenerList;
                int j = achangelistener.length;
                for (int i = 0; i < j; i++)
                {
                    achangelistener[i].onTimelineChanged(list);
                }

            }
            break MISSING_BLOCK_LABEL_136;
            Exception exception;
            exception;
            map;
            JVM INSTR monitorexit ;
            throw exception;
            listenerList = new ChangeListener[0];
            return;
        }

        private transient QueryRequest(TimelineQuery timelinequery, ChangeListener achangelistener[])
        {
            this$0 = TimelineModel.this;
            super();
            run = true;
            query = timelinequery;
            listenerList = achangelistener;
        }

    }


    private final Map cache = new HashMap();
    private final GalleryDBConnectionManager connectionManager;
    private volatile QueryRequest lastUpdateRequest;

    public TimelineModel(GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        lastUpdateRequest = new QueryRequest(null, new ChangeListener[0]);
        connectionManager = gallerydbconnectionmanager;
    }

    public void clearCached(TimelineQuery timelinequery)
    {
        synchronized (cache)
        {
            cache.remove(timelinequery);
        }
        return;
        timelinequery;
        map;
        JVM INSTR monitorexit ;
        throw timelinequery;
    }

    public List get(TimelineQuery timelinequery)
    {
        List list;
        synchronized (cache)
        {
            list = ((TimelineQueryImpl)timelinequery).get(connectionManager);
            if (!list.isEmpty())
            {
                cache.put(timelinequery, list);
            }
        }
        return list;
        timelinequery;
        map;
        JVM INSTR monitorexit ;
        throw timelinequery;
    }

}
