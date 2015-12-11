// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.net.api.shippinglabel.DraftShippingLabelResponse;
import com.ebay.nautilus.domain.net.api.shippinglabel.GetDraftShippingLabelRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShippingLabelDraftDataManager

private final class iafToken extends AsyncTask
{

    private final String iafToken;
    private final String itemId;
    final ShippingLabelDraftDataManager this$0;
    private final String transactionId;
    private final String url;

    protected transient Content doInBackground(Address aaddress[])
    {
        Object obj = new GetDraftShippingLabelRequest(itemId, transactionId, iafToken, url);
        aaddress = new ResultStatusOwner();
        obj = (DraftShippingLabelResponse)ShippingLabelDraftDataManager.access$000(ShippingLabelDraftDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), aaddress);
        aaddress = aaddress.getResultStatus();
        if (aaddress == ResultStatus.CANCELED)
        {
            return null;
        } else
        {
            return new Content(((DraftShippingLabelResponse) (obj)).shippingLabel, aaddress);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Address[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        createDraftLabelTask = null;
        handleUpdateDraftResult(null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        createDraftLabelTask = null;
        handleUpdateDraftResult(content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public ( )
    {
        this$0 = ShippingLabelDraftDataManager.this;
        super();
        url = .url;
        itemId = .itemId;
        transactionId = .Id;
        iafToken = .iafToken;
    }
}
