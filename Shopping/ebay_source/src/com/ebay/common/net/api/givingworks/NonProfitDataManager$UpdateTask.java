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
//            NonProfitDataManager, SetUserDonationDetailsRequest

private final class <init> extends AsyncTask
{

    final NonProfitDataManager this$0;

    protected transient Content doInBackground(String as[])
    {
        as = new SetUserDonationDetailsRequest(NonProfitDataManager.access$400(NonProfitDataManager.this), NonProfitDataManager.access$300(NonProfitDataManager.this).site, as);
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        NonProfitDataManager.access$700(NonProfitDataManager.this, as, resultstatusowner);
        as = resultstatusowner.getResultStatus();
        if (as == ResultStatus.CANCELED)
        {
            return null;
        } else
        {
            return new Content(as);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        NonProfitDataManager.access$800(NonProfitDataManager.this, this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    private I()
    {
        this$0 = NonProfitDataManager.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
