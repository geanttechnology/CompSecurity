// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import android.os.AsyncTask;
import com.ebay.common.model.local.AvailabilityIdentifier;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.Arrays;

// Referenced classes of package com.ebay.common.net.api.local:
//            EbayNowInventoryLookupDataManager, EbayNowInventoryLookupRequest, EbayNowInventoryLookupResponse

final class this._cls0 extends AsyncTask
{

    final EbayNowInventoryLookupDataManager this$0;

    protected transient Content doInBackground(AvailabilityIdentifier aavailabilityidentifier[])
    {
        if (EbayNowInventoryLookupDataManager.logger._fld0)
        {
            EbayNowInventoryLookupDataManager.logger._mth0("load task");
        }
        if (EbayNowInventoryLookupDataManager.logger._fld0)
        {
            EbayNowInventoryLookupDataManager.logger._mth0((new StringBuilder()).append("load task: params=").append(Arrays.asList(aavailabilityidentifier)).toString());
        }
        Object obj = new EbayNowInventoryLookupRequest(aavailabilityidentifier);
        aavailabilityidentifier = new ResultStatusOwner();
        obj = (EbayNowInventoryLookupResponse)EbayNowInventoryLookupDataManager.access$000(EbayNowInventoryLookupDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), aavailabilityidentifier);
        aavailabilityidentifier = aavailabilityidentifier.getResultStatus();
        if (aavailabilityidentifier == ResultStatus.CANCELED)
        {
            return null;
        }
        if (aavailabilityidentifier.hasError())
        {
            return new Content(aavailabilityidentifier);
        } else
        {
            return new Content(((EbayNowInventoryLookupResponse) (obj)).getResult(), aavailabilityidentifier);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((AvailabilityIdentifier[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        EbayNowInventoryLookupDataManager.access$100(EbayNowInventoryLookupDataManager.this, this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    ()
    {
        this$0 = EbayNowInventoryLookupDataManager.this;
        super();
    }
}
