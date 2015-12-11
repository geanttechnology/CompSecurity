// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;


// Referenced classes of package com.amazon.retailsearch.data:
//            SearchTask

public class EmptySearchTask
    implements SearchTask
{

    public EmptySearchTask()
    {
    }

    public void addListener(SearchTask.SearchTaskListener searchtasklistener)
    {
    }

    public void close()
    {
    }

    public com.amazon.retailsearch.data.search.ResultStream.Status getStatus()
    {
        return com.amazon.retailsearch.data.search.ResultStream.Status.None;
    }

    public boolean isLoading()
    {
        return false;
    }

    public void loadNext()
    {
    }

    public void loadNext(int i)
    {
    }

    public boolean removeListener(SearchTask.SearchTaskListener searchtasklistener)
    {
        return true;
    }

    public void retry()
    {
    }
}
