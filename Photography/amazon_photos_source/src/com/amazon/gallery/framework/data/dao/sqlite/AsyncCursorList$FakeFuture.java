// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            AsyncCursorList

protected class result
    implements Future
{

    private List result;
    final AsyncCursorList this$0;

    public boolean cancel(boolean flag)
    {
        return false;
    }

    public volatile Object get()
        throws InterruptedException, ExecutionException
    {
        return get();
    }

    public volatile Object get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return get(l, timeunit);
    }

    public List get()
        throws InterruptedException, ExecutionException
    {
        return result;
    }

    public List get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return get();
    }

    public boolean isCancelled()
    {
        return false;
    }

    public boolean isDone()
    {
        return true;
    }

    protected (List list)
    {
        this$0 = AsyncCursorList.this;
        super();
        result = list;
    }
}
