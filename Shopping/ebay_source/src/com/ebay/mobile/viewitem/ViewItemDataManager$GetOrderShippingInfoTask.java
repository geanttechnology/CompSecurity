// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager, ViewItemViewData

private final class _INFO extends AsyncTask
{

    final ViewItemDataManager this$0;
    private final ViewItemViewData viewData;

    protected transient Content doInBackground(Content acontent[])
    {
label0:
        {
            Content content = null;
            ResultStatus resultstatus = ViewItemDataManager.access$1700(ViewItemDataManager.this, (Item)acontent[0].getData());
            if (resultstatus != ResultStatus.CANCELED)
            {
                if (!resultstatus.hasError())
                {
                    break label0;
                }
                content = new Content(null, resultstatus);
            }
            return content;
        }
        return acontent[0];
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLoadDataResult(_INFO, viewData, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLoadDataResult(_INFO, viewData, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (ViewItemViewData viewitemviewdata)
    {
        this$0 = ViewItemDataManager.this;
        super();
        viewData = viewitemviewdata;
        ViewItemDataManager.access$000(ViewItemDataManager.this, _INFO);
    }
}
