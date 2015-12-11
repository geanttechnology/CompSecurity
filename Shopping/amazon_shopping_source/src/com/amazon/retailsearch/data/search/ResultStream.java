// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultEvent, ResultStreamListener

public class ResultStream
{
    public static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status Done;
        public static final Status Error;
        public static final Status None;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/amazon/retailsearch/data/search/ResultStream$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            None = new Status("None", 0);
            Done = new Status("Done", 1);
            Error = new Status("Error", 2);
            $VALUES = (new Status[] {
                None, Done, Error
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    private final List content = new ArrayList(32);
    private final Set listeners = new LinkedHashSet(5);
    private int pageCount;
    private Status status;

    public ResultStream()
    {
        status = Status.None;
        pageCount = 0;
    }

    public void addRecord(ResultEvent resultevent)
    {
        content.add(resultevent);
        resultevent.send(getListeners());
    }

    public void attach(ResultStreamListener resultstreamlistener)
    {
        listeners.add(resultstreamlistener);
    }

    public void close()
    {
        status = Status.None;
        content.clear();
        listeners.clear();
        pageCount = 0;
    }

    public void detach(ResultStreamListener resultstreamlistener)
    {
        listeners.remove(resultstreamlistener);
    }

    protected List getContent()
    {
        return content;
    }

    protected Iterable getListeners()
    {
        return Arrays.asList(listeners.toArray(new ResultStreamListener[0]));
    }

    public int getPageCount()
    {
        return pageCount;
    }

    public Status getStatus()
    {
        return status;
    }

    public void read(ResultStreamListener resultstreamlistener)
    {
        if (listeners.contains(resultstreamlistener))
        {
            return;
        }
        for (Iterator iterator = content.iterator(); iterator.hasNext(); ((ResultEvent)iterator.next()).send(resultstreamlistener)) { }
        attach(resultstreamlistener);
    }

    protected void setPageCount(int i)
    {
        pageCount = i;
    }

    protected void setStatus(Status status1)
    {
        status = status1;
    }
}
