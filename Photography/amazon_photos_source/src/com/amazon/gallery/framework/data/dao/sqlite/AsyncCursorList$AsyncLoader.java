// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            AsyncCursorList

protected class limit
    implements Callable
{

    private int limit;
    private int startToken;
    final AsyncCursorList this$0;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public List call()
        throws Exception
    {
        return backQuery(startToken, limit);
    }

    public (int i, int j)
    {
        this$0 = AsyncCursorList.this;
        super();
        startToken = i;
        limit = j;
    }
}
