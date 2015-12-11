// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.DatedContent;
import com.ebay.nautilus.domain.data.EbayItemIdAndVariationSpecifics;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.UserDefinedList;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayBuyingRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayWatchingDataManager

private final class sort
{
    private final class LoadTask extends AsyncTask
    {

        final MyEbayWatchingDataManager.UserDefinedListLoader this$1;

        protected transient DatedContent doInBackground(Void avoid[])
        {
            try
            {
                avoid = loadList();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onCancelled()
        {
            super.onCancelled();
            handleLoadListResult(this, null);
        }

        protected void onPostExecute(DatedContent datedcontent)
        {
            super.onPostExecute(datedcontent);
            handleLoadListResult(this, datedcontent);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((DatedContent)obj);
        }

        private LoadTask()
        {
            this$1 = MyEbayWatchingDataManager.UserDefinedListLoader.this;
            super();
        }

        LoadTask(MyEbayWatchingDataManager._cls1 _pcls1)
        {
            this();
        }
    }


    public DatedContent data;
    public int listCount;
    public final String listName;
    protected LoadTask loadTask;
    public final String sort;
    final MyEbayWatchingDataManager this$0;

    private List removeItemsFromList(List list, Set set)
    {
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (set.contains(new EbayItemIdAndVariationSpecifics((MyEbayListItem)iterator.next())))
            {
                iterator.remove();
            }
        } while (true);
        if (list.isEmpty())
        {
            return Collections.emptyList();
        } else
        {
            return Collections.unmodifiableList(list);
        }
    }

    public final boolean forceReload()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        LoadTask loadtask = loadTask;
        if (loadtask == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        markDirty();
        loadTask = new LoadTask(null);
        DataManager.executeOnThreadPool(loadTask, new Void[0]);
        flag = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final DatedContent getData()
    {
        this;
        JVM INSTR monitorenter ;
        DatedContent datedcontent = data;
        this;
        JVM INSTR monitorexit ;
        return datedcontent;
        Exception exception;
        exception;
        throw exception;
    }

    final void handleLoadListResult(LoadTask loadtask, DatedContent datedcontent)
    {
        this;
        JVM INSTR monitorenter ;
        if (loadTask == loadtask)
        {
            loadTask = null;
        }
        if (datedcontent != null)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        if (!datedcontent.getStatus().hasError())
        {
            data = datedcontent;
        }
        this;
        JVM INSTR monitorexit ;
        if (data != null)
        {
            splitWatchingListAndCallback(data);
            return;
        } else
        {
            return;
        }
        loadtask;
        this;
        JVM INSTR monitorexit ;
        throw loadtask;
    }

    public final void load()
    {
        this;
        JVM INSTR monitorenter ;
        if (data == null && loadTask == null)
        {
            loadTask = new LoadTask(null);
            DataManager.executeOnThreadPool(loadTask, new Void[0]);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    final DatedContent loadList()
        throws InterruptedException
    {
        Object obj = new ResultStatusOwner();
        Object obj1 = getApi(((ResultStatusOwner) (obj)));
        if (obj1 == null)
        {
            return new DatedContent(((ResultStatusOwner) (obj)).getResultStatus());
        }
        obj = new GetMyEbayBuyingRequest(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj1)), "WatchList", 200, 1, sort);
        GetMyEbayResponse getmyebayresponse = (GetMyEbayResponse)MyEbayWatchingDataManager.access$100(MyEbayWatchingDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)));
        obj1 = getmyebayresponse.getResultStatus();
        if (((ResultStatus) (obj1)).hasError())
        {
            obj = ((ResultStatus) (obj1)).getFirstError();
            if (obj != null && "network".equals(((com.ebay.nautilus.kernel.content.er.this._cls0) (obj))._mth0()))
            {
                ((ResultStatus) (obj1)).setCanRetry(true);
            }
            return new DatedContent(((ResultStatus) (obj1)));
        }
        obj = getmyebayresponse.resultItemList;
        if (obj == null)
        {
            obj = Collections.emptyList();
        } else
        {
            obj = Collections.unmodifiableList(((List) (obj)));
        }
        return new DatedContent(new UserDefinedList(listName, getmyebayresponse.totalEntries, ((List) (obj))), ((ResultStatus) (obj1)));
    }

    public final void markDirty()
    {
        this;
        JVM INSTR monitorenter ;
        if (loadTask != null)
        {
            loadTask.cancel(true);
        }
        loadTask = null;
        data = null;
        listCount = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void removeAllItems()
    {
        this;
        JVM INSTR monitorenter ;
        if (data == null || data.getData() == null || ((UserDefinedList)data.getData()).list == null || !((UserDefinedList)data.getData()).list.isEmpty())
        {
            break MISSING_BLOCK_LABEL_59;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        listCount = 0;
        List list = Collections.emptyList();
        data = new DatedContent(new UserDefinedList(listName, 0, list));
        this;
        JVM INSTR monitorexit ;
        splitWatchingListAndCallback(data);
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void removeItems(EbayItemIdAndVariationSpecifics aebayitemidandvariationspecifics[])
    {
        this;
        JVM INSTR monitorenter ;
        if (data != null && data.getData() != null && ((UserDefinedList)data.getData()).list != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        int i;
        aebayitemidandvariationspecifics = new HashSet(Arrays.asList(aebayitemidandvariationspecifics));
        if (!"".equals(listName))
        {
            break MISSING_BLOCK_LABEL_192;
        }
        aebayitemidandvariationspecifics = removeItemsFromList(new ArrayList(((UserDefinedList)data.getData()).list), aebayitemidandvariationspecifics);
        i = aebayitemidandvariationspecifics.size();
        if (((UserDefinedList)data.getData()).list.size() != i)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aebayitemidandvariationspecifics;
        this;
        JVM INSTR monitorexit ;
        throw aebayitemidandvariationspecifics;
        listCount = i;
        ArrayList arraylist = new ArrayList(i);
        arraylist.addAll(aebayitemidandvariationspecifics);
        data = new DatedContent(new UserDefinedList(listName, i, Collections.unmodifiableList(arraylist)), data.getLastUpdatedMillis());
        splitWatchingListAndCallback(data);
        this;
        JVM INSTR monitorexit ;
    }

    public LoadTask(String s, String s1)
    {
        this$0 = MyEbayWatchingDataManager.this;
        super();
        listCount = 0;
        data = null;
        loadTask = null;
        listName = s;
        sort = s1;
    }
}
