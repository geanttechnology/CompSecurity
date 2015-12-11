// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.api.shopping.GetSingleItemRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetSingleItemResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageContentsDataManager, MessagesDataManagerBase

private final class message extends AsyncTask
{

    private final EbayMessage message;
    final MessageContentsDataManager this$0;

    protected transient Content doInBackground(Void avoid[])
    {
        if (MessagesDataManagerBase.log.dTask || MessagesDataManagerBase.logDm.dTask || MessagesDataManagerBase.logDmNetwork.rk)
        {
            MessagesDataManagerBase.logDmNetwork.rk((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        Object obj = null;
        ResultStatusOwner resultstatusowner = new ResultStatusOwner();
        Object obj1 = getShoppingApi(resultstatusowner);
        avoid = obj;
        if (obj1 != null)
        {
            avoid = new GetSingleItemRequest(((com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi) (obj1)), message.itemId, "Details");
            obj1 = (GetSingleItemResponse)MessageContentsDataManager.access$500(MessageContentsDataManager.this, avoid, resultstatusowner);
            avoid = obj;
            if (obj1 != null)
            {
                avoid = ((GetSingleItemResponse) (obj1)).item;
            }
        }
        return new Content(avoid, resultstatusowner.getResultStatus());
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Content content)
    {
        super.onPostExecute(content);
        if (MessagesDataManagerBase.log.dTask || MessagesDataManagerBase.logDm.dTask || MessagesDataManagerBase.logDmNetwork.rk)
        {
            MessagesDataManagerBase.logDmNetwork.rk((new StringBuilder()).append("Finishing task: ").append(this).toString());
            MessagesDataManagerBase.logDmNetwork.rk((new StringBuilder()).append("  Result: hasError[").append(content.getStatus().hasError()).append("], data[").append(content.getData()).append("]").toString());
        }
        MessageContentsDataManager.access$302(MessageContentsDataManager.this, null);
        if (!content.getStatus().hasError())
        {
            MessageContentsDataManager.access$602(MessageContentsDataManager.this, content.getStatus());
            MessageContentsDataManager.access$402(MessageContentsDataManager.this, (EbayItem)content.getData());
            ((this._cls0)MessageContentsDataManager.access$700(MessageContentsDataManager.this)).ssageItemChanged(MessageContentsDataManager.this, content);
            return;
        } else
        {
            MessagesDataManagerBase.logDm._mth0((new StringBuilder()).append("Error loading item.  Status:").append(content.getStatus()).append(", itemId:").append(message.itemId).toString());
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Content)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(message[").append(message).append("], item ID[").append(message.itemId).append("])").toString();
    }

    public Q(EbayMessage ebaymessage)
    {
        this$0 = MessageContentsDataManager.this;
        super();
        message = ebaymessage;
    }
}
