// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.os.AsyncTask;
import com.ebay.common.UserCache;
import com.ebay.common.net.api.trading.LeaveFeedbackParameters;
import com.ebay.common.net.api.trading.LeaveFeedbackRequest;
import com.ebay.mobile.Item;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.ServiceContentOverride;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemDataManager

private final class ACK extends AsyncTask
{

    private final EbayTradingApi api;
    private final LeaveFeedbackParameters parameters;
    final ViewItemDataManager this$0;

    protected transient Content doInBackground(Content acontent[])
    {
        Object obj;
label0:
        {
            Content content = null;
            LeaveFeedbackRequest leavefeedbackrequest = new LeaveFeedbackRequest(api, parameters);
            obj = new ResultStatusOwner();
            ViewItemDataManager.access$2400(ViewItemDataManager.this, leavefeedbackrequest, ((ResultStatusOwner) (obj)));
            if (((ResultStatusOwner) (obj)).getResultStatus() != ResultStatus.CANCELED)
            {
                if (((ResultStatusOwner) (obj)).getResultStatus().hasError())
                {
                    break label0;
                }
                content = acontent[0];
                ((Item)content.getData()).feedbackLeft = true;
                acontent = ((Item)content.getData()).getIdString();
                obj = String.valueOf(((Item)content.getData()).transactionId);
                ViewItemDataManager.access$700(ViewItemDataManager.this).addToLeftFeedback(acontent, ((String) (obj)));
                ServiceContentOverride.setFeedbackLeft(((Item)content.getData()).id, ((String) (obj)));
            }
            return content;
        }
        return new Content(null, ((ResultStatusOwner) (obj)).getResultStatus());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Content[])aobj);
    }

    protected void onCancelled()
    {
        super.onCancelled();
        handleLeaveFeedbackResult(this, null);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        handleLeaveFeedbackResult(this, content);
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public (EbayTradingApi ebaytradingapi, LeaveFeedbackParameters leavefeedbackparameters)
    {
        this$0 = ViewItemDataManager.this;
        super();
        api = ebaytradingapi;
        parameters = leavefeedbackparameters;
        ViewItemDataManager.access$000(ViewItemDataManager.this, ACK);
    }
}
