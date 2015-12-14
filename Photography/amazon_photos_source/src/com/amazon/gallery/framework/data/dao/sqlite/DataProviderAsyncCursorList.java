// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            AsyncCursorList, CursorListDataProvider, GalleryDBConnectionManager, ReadOnlySQLiteDatabase

public class DataProviderAsyncCursorList extends AsyncCursorList
{

    private static ThreadPoolExecutor executor;
    private final GalleryDBConnectionManager connectionManager;
    private final CursorListDataProvider dataProvider;

    public DataProviderAsyncCursorList(CursorListDataProvider cursorlistdataprovider, GalleryDBConnectionManager gallerydbconnectionmanager, int i)
    {
        super(cursorlistdataprovider.size(), i);
        dataProvider = cursorlistdataprovider;
        connectionManager = gallerydbconnectionmanager;
    }

    protected List backQuery(int i, int j)
    {
        return dataProvider.query(i, j);
    }

    protected Future enqueueRequest(AsyncCursorList.AsyncLoader asyncloader)
    {
        if (connectionManager != null && connectionManager.getReadableConnection().inTransaction())
        {
            return executeSynchronously(asyncloader);
        } else
        {
            return executor.submit(asyncloader);
        }
    }

    protected Future executeSynchronously(AsyncCursorList.AsyncLoader asyncloader)
    {
        try
        {
            GLogger.v(TAG, "Run async request synchronously", new Object[0]);
            asyncloader = new AsyncCursorList.FakeFuture(this, asyncloader.call());
        }
        // Misplaced declaration of an exception variable
        catch (AsyncCursorList.AsyncLoader asyncloader)
        {
            GLogger.e(TAG, "Failed to do synchronous cursor list query", new Object[] {
                asyncloader
            });
            return null;
        }
        return asyncloader;
    }

    public List subList(int i, int j)
    {
        return dataProvider.query(i, j - i);
    }

    static 
    {
        executor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory(com/amazon/gallery/framework/data/dao/sqlite/DataProviderAsyncCursorList.getSimpleName()));
    }
}
