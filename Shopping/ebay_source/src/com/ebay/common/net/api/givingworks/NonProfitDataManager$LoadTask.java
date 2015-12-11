// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            NonProfitDataManager, GetFavoritesRequest, FindNonProfitResponse

private final class <init> extends AsyncTask
{

    final NonProfitDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        avoid = null;
        if (NonProfitDataManager.access$300(NonProfitDataManager.this) == null || NonProfitDataManager.access$400(NonProfitDataManager.this) == null)
        {
            avoid = new Content(null, ResultStatus.SUCCESS);
        } else
        {
            Object obj = new GetFavoritesRequest(NonProfitDataManager.access$400(NonProfitDataManager.this), NonProfitDataManager.access$300(NonProfitDataManager.this).site);
            Object obj1 = new ResultStatusOwner();
            obj = (FindNonProfitResponse)NonProfitDataManager.access$500(NonProfitDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), ((ResultStatusOwner) (obj1)));
            obj1 = ((ResultStatusOwner) (obj1)).getResultStatus();
            if (obj1 != ResultStatus.CANCELED)
            {
                if (((ResultStatus) (obj1)).hasError())
                {
                    return new Content(((ResultStatus) (obj1)));
                } else
                {
                    return new Content(((FindNonProfitResponse) (obj)).getNonprofits(), ((ResultStatus) (obj1)));
                }
            }
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        NonProfitDataManager.access$600(NonProfitDataManager.this, this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    private ()
    {
        this$0 = NonProfitDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
