// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.itemview;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.net.api.guidesandreviews.GetReviewsRequest;
import com.ebay.nautilus.domain.net.api.guidesandreviews.GetReviewsResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.itemview:
//            ProductReviewsDataManager

final class this._cls0 extends AsyncTask
{

    final ProductReviewsDataManager this$0;

    protected transient Content doInBackground(rams arams[])
    {
        Object obj = new GetReviewsRequest(arams[0].ebayCountry, arams[0].user, arams[0].subjectReferenceId, arams[0].pageNumber, 10);
        arams = new ResultStatusOwner();
        obj = (GetReviewsResponse)ProductReviewsDataManager.access$000(ProductReviewsDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), arams);
        arams = arams.getResultStatus();
        if (arams == ResultStatus.CANCELED)
        {
            return null;
        }
        if (arams.hasError())
        {
            return new Content(arams);
        } else
        {
            return new Content(((GetReviewsResponse) (obj)).reviews, arams);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((rams[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        ((rams)ProductReviewsDataManager.access$100(ProductReviewsDataManager.this)).onGetReviewDetails(null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        ((onGetReviewDetails)ProductReviewsDataManager.access$200(ProductReviewsDataManager.this)).onGetReviewDetails(content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    rams()
    {
        this$0 = ProductReviewsDataManager.this;
        super();
    }
}
