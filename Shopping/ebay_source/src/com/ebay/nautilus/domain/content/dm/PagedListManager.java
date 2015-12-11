// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Collections;

public abstract class PagedListManager
{
    private final class LoadTask extends AsyncTask
    {

        final PagedListManager this$0;

        protected transient ListContent doInBackground(Integer ainteger[])
        {
            try
            {
                ainteger = loadData(ainteger[0].intValue());
            }
            // Misplaced declaration of an exception variable
            catch (Integer ainteger[])
            {
                return null;
            }
            return ainteger;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Integer[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadDataResult(this, null);
        }

        protected void onPostExecute(ListContent listcontent)
        {
            super.onPostExecute(listcontent);
            handleLoadDataResult(this, listcontent);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ListContent)obj);
        }

        private LoadTask()
        {
            this$0 = PagedListManager.this;
            super();
        }

    }


    private ListContent data;
    protected int highestPageIndex;
    private int highestPageRequested;
    private ArrayList items;
    protected final int itemsPerPage;
    private LoadTask loadTask;
    private long timeLastUpdatedMillis;
    protected int totalNumberOfItems;

    public PagedListManager(int i)
    {
        timeLastUpdatedMillis = -1L;
        itemsPerPage = i;
    }

    public boolean forceReload()
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        LoadTask loadtask = loadTask;
        if (loadtask == null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        markDirty();
        load(1);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final ListContent getData()
    {
        this;
        JVM INSTR monitorenter ;
        ListContent listcontent = data;
        this;
        JVM INSTR monitorexit ;
        return listcontent;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract ResultStatus getPage(int i, ArrayList arraylist)
        throws InterruptedException;

    final void handleLoadDataResult(LoadTask loadtask, ListContent listcontent)
    {
        this;
        JVM INSTR monitorenter ;
        LoadTask loadtask1 = loadTask;
        if (loadtask1 == loadtask) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        loadTask = null;
        if (listcontent == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!listcontent.getStatus().hasError())
        {
            data = listcontent;
            if (highestPageRequested > data.getHighestPageIndex())
            {
                highestPageRequested = data.getHighestPageIndex();
            }
            if (highestPageRequested > data.getPagesLoaded())
            {
                loadTask = new LoadTask();
                DataManager.executeOnThreadPool(loadTask, new Integer[] {
                    Integer.valueOf(data.getPagesLoaded() + 1)
                });
            }
        }
        handleLoadListResult(listcontent);
        if (true) goto _L1; else goto _L3
_L3:
        loadtask;
        throw loadtask;
    }

    protected abstract void handleLoadListResult(ListContent listcontent);

    protected boolean isErrorRetriable(com.ebay.nautilus.kernel.content.ResultStatus.Message message)
    {
        return "network".equals(message.getCategory());
    }

    public final void load(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        if (i <= 0 || i > 100)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        j = 0;
        if (i > highestPageRequested)
        {
            highestPageRequested = i;
        }
        i = j;
        if (data == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        j = data.getPagesLoaded();
        i = j;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        i = j;
        if (highestPageRequested <= data.getHighestPageIndex())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        highestPageRequested = data.getHighestPageIndex();
        i = j;
        if (highestPageRequested > i && loadTask == null)
        {
            loadTask = new LoadTask();
            onLoadStarted();
            DataManager.executeOnThreadPool(loadTask, new Integer[] {
                Integer.valueOf(i + 1)
            });
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final ListContent loadData(int i)
        throws InterruptedException
    {
        Object obj;
        ResultStatus resultstatus;
        com.ebay.nautilus.kernel.content.ResultStatus.Message message;
        int j;
        int k;
        if (items == null)
        {
            items = new ArrayList();
        } else
        if (i == 1)
        {
            items.clear();
        }
        resultstatus = getPage(i, items);
        if (i == 1)
        {
            timeLastUpdatedMillis = System.currentTimeMillis();
        }
        obj = null;
        message = resultstatus.getFirstError();
        if (message != null)
        {
            if (isErrorRetriable(message))
            {
                resultstatus.setCanRetry(true);
            }
            i--;
        } else
        {
            if (i == highestPageIndex)
            {
                obj = items;
            } else
            {
                obj = new ArrayList(items);
            }
            obj = Collections.unmodifiableList(((java.util.List) (obj)));
        }
        k = totalNumberOfItems;
        j = k;
        if (k > highestPageIndex * itemsPerPage)
        {
            j = highestPageIndex * itemsPerPage;
        }
        return new ListContent(((java.util.List) (obj)), i, highestPageIndex, j, totalNumberOfItems, resultstatus, timeLastUpdatedMillis);
    }

    protected final ListContent loadInitialPageSynchronous()
        throws InterruptedException
    {
        if (data != null)
        {
            throw new IllegalStateException("loadInitialPageSynchronous() must be used only during initialization.  Use loadData() for subsequent requests.");
        }
        ListContent listcontent = loadData(1);
        if (!listcontent.getStatus().hasError())
        {
            data = listcontent;
        }
        return listcontent;
    }

    public void markDirty()
    {
        this;
        JVM INSTR monitorenter ;
        if (loadTask != null)
        {
            loadTask.cancel(true);
        }
        items = null;
        timeLastUpdatedMillis = -1L;
        totalNumberOfItems = 0;
        highestPageIndex = 0;
        highestPageRequested = 0;
        data = null;
        loadTask = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract void onLoadStarted();
}
