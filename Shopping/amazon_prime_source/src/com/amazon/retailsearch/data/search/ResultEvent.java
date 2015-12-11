// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.search;

import java.util.Iterator;

// Referenced classes of package com.amazon.retailsearch.data.search:
//            ResultStreamListener

public abstract class ResultEvent
{

    public ResultEvent()
    {
    }

    public abstract void send(ResultStreamListener resultstreamlistener);

    public void send(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext(); send((ResultStreamListener)iterable.next())) { }
    }
}
