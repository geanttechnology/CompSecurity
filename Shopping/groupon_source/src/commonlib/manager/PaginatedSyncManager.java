// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package commonlib.manager;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

// Referenced classes of package commonlib.manager:
//            SyncManager

public abstract class PaginatedSyncManager extends SyncManager
{
    protected static class PaginatedAutomaticSyncRunnable extends SyncManager.AutomaticSyncRunnable
    {

        protected void performSync()
            throws Exception
        {
            PaginatedSyncManager paginatedsyncmanager = (PaginatedSyncManager)syncManagerRef.get();
            if (paginatedsyncmanager != null)
            {
                paginatedsyncmanager.doSync(info, 0, Math.max(paginatedsyncmanager.firstPageSize, paginatedsyncmanager.getNextOffset()));
            }
        }

        public PaginatedAutomaticSyncRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj, SyncManager syncmanager)
        {
            super(syncuicallbacks, obj, syncmanager);
        }
    }

    protected static class PaginatedNextPageRunnable extends SyncManager.UpdateRunnable
    {

        protected void performSync()
            throws Exception
        {
            PaginatedSyncManager paginatedsyncmanager = (PaginatedSyncManager)syncManagerRef.get();
            if (paginatedsyncmanager != null)
            {
                paginatedsyncmanager.doSync(info, paginatedsyncmanager.getNextOffset(), paginatedsyncmanager.subsequencePageSize);
            }
        }

        public PaginatedNextPageRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj, SyncManager syncmanager)
        {
            super(syncuicallbacks, obj, syncmanager);
        }
    }

    protected static class PaginatedResetRunnable extends SyncManager.UpdateRunnable
    {

        protected void performSync()
            throws Exception
        {
            PaginatedSyncManager paginatedsyncmanager = (PaginatedSyncManager)syncManagerRef.get();
            if (paginatedsyncmanager != null)
            {
                paginatedsyncmanager.doSync(info, 0, paginatedsyncmanager.firstPageSize);
            }
        }

        public PaginatedResetRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj, PaginatedSyncManager paginatedsyncmanager)
        {
            super(syncuicallbacks, obj, paginatedsyncmanager);
        }
    }

    protected static class PaginatedUpdateRunnable extends SyncManager.UpdateRunnable
    {

        protected void performSync()
            throws Exception
        {
            PaginatedSyncManager paginatedsyncmanager = (PaginatedSyncManager)syncManagerRef.get();
            if (paginatedsyncmanager != null)
            {
                paginatedsyncmanager.doSync(info, 0, Math.max(paginatedsyncmanager.firstPageSize, paginatedsyncmanager.getNextOffset()));
            }
        }

        public PaginatedUpdateRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj, SyncManager syncmanager)
        {
            super(syncuicallbacks, obj, syncmanager);
        }
    }


    public static final int DEFAULT_PAGE_SIZE = 15;
    private int firstPageSize;
    private int subsequencePageSize;

    public PaginatedSyncManager(Context context)
    {
        super(context);
        firstPageSize = 15;
        subsequencePageSize = 15;
    }

    public PaginatedSyncManager(Context context, long l, ExecutorService executorservice)
    {
        super(context, l, executorservice);
        firstPageSize = 15;
        subsequencePageSize = 15;
    }

    public PaginatedSyncManager(Context context, ExecutorService executorservice)
    {
        super(context, executorservice);
        firstPageSize = 15;
        subsequencePageSize = 15;
    }

    protected SyncManager.AutomaticSyncRunnable createAutomaticSyncRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj)
    {
        return new PaginatedAutomaticSyncRunnable(syncuicallbacks, obj, this);
    }

    protected PaginatedNextPageRunnable createNextPageSyncRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj)
    {
        return new PaginatedNextPageRunnable(syncuicallbacks, obj, this);
    }

    protected SyncManager.UpdateRunnable createOneShotSyncRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj)
    {
        return new PaginatedUpdateRunnable(syncuicallbacks, obj, this);
    }

    protected PaginatedResetRunnable createResetSyncRunnable(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj)
    {
        return new PaginatedResetRunnable(syncuicallbacks, obj, this);
    }

    protected final void doSync(Object obj)
        throws Exception
    {
        throw new UnsupportedOperationException("Do not overload doSync(context)");
    }

    protected abstract void doSync(Object obj, int i, int j)
        throws Exception;

    public int getFirstPageSize()
    {
        return firstPageSize;
    }

    protected abstract int getNextOffset()
        throws Exception;

    public int getSubsequencePageSize()
    {
        return subsequencePageSize;
    }

    public void requestSync(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj)
    {
        submit(createResetSyncRunnable(syncuicallbacks, obj));
    }

    public void requestSyncNextPage(SyncManager.SyncUiCallbacks syncuicallbacks, Object obj)
    {
        submit(createNextPageSyncRunnable(syncuicallbacks, obj));
    }

    public void setFirstPageSize(int i)
    {
        firstPageSize = i;
    }

    public void setSubsequencePageSize(int i)
    {
        subsequencePageSize = i;
    }


}
