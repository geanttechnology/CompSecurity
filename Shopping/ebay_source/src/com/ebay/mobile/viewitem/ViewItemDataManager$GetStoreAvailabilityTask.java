// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import java.util.ArrayList;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData

private final class ITY extends AsyncTask
{

    private boolean onVipLoad;
    private final ArrayList selections;
    final ViewItemDataManager this$0;
    private final ViewItemViewData viewData;

    protected transient Content doInBackground(Content acontent[])
    {
        ViewItemDataManager.access$100(ViewItemDataManager.this, (Item)acontent[0].getData(), viewData.searchRefinedPostalCode, selections);
        return acontent[0];
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        if (onVipLoad)
        {
            handleLoadDataResult(ITY, viewData, null);
            return;
        } else
        {
            handleGetStoreAvailabilityResult(this, null);
            return;
        }
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        if (onVipLoad)
        {
            handleLoadDataResult(ITY, viewData, content);
            return;
        } else
        {
            handleGetStoreAvailabilityResult(this, content);
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (ArrayList arraylist, ViewItemViewData viewitemviewdata, boolean flag)
    {
        this$0 = ViewItemDataManager.this;
        super();
        onVipLoad = false;
        selections = arraylist;
        onVipLoad = flag;
        viewData = viewitemviewdata;
        if (flag)
        {
            ViewItemDataManager.access$000(ViewItemDataManager.this, ITY);
        }
    }
}
