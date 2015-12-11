// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.ShippingLabelContact;
import com.ebay.nautilus.domain.net.api.shippinglabel.DraftShippingLabelResponse;
import com.ebay.nautilus.domain.net.api.shippinglabel.UpdateDraftShippingLabelAddressRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ShippingLabelDraftDataManager

private final class addressType extends AsyncTask
{

    private final ShippingLabelContact address;
    private final com.ebay.nautilus.domain.data.sTask.onPostExecute addressType;
    private final String labelId;
    final ShippingLabelDraftDataManager this$0;
    private final URL url;

    protected transient Content doInBackground(String as[])
    {
        Object obj = new UpdateDraftShippingLabelAddressRequest(address, addressType, labelId, ShippingLabelDraftDataManager.access$100(ShippingLabelDraftDataManager.this)._fld0, url);
        as = new ResultStatusOwner();
        obj = (DraftShippingLabelResponse)ShippingLabelDraftDataManager.access$200(ShippingLabelDraftDataManager.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), as);
        as = as.getResultStatus();
        if (as == ResultStatus.CANCELED)
        {
            return null;
        } else
        {
            return new Content(((DraftShippingLabelResponse) (obj)).shippingLabel, as);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        updateDraftAddressTask = null;
        handleUpdateDraftResult(null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        updateDraftAddressTask = null;
        handleUpdateDraftResult(content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (ShippingLabelContact shippinglabelcontact, com.ebay.nautilus.domain.data.sTask stask, String s, URL url1)
    {
        this$0 = ShippingLabelDraftDataManager.this;
        super();
        url = url1;
        labelId = s;
        address = shippinglabelcontact;
        addressType = stask;
    }
}
