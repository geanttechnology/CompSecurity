// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.api.trading.DeleteMyMessagesRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessagesDataManagerBase, MessagesUtils

protected class messages extends AsyncTask
{

    private final List messages;
    final MessagesDataManagerBase this$0;

    protected transient ResultStatus doInBackground(Void avoid[])
    {
        if (MessagesDataManagerBase.log.kBase || MessagesDataManagerBase.logDm.kBase || MessagesDataManagerBase.logDmNetwork.ork)
        {
            MessagesDataManagerBase.logDmNetwork.ork((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        avoid = new ResultStatusOwner();
        Object obj = getTradingApi(avoid);
        if (obj != null)
        {
            obj = new DeleteMyMessagesRequest(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), messages);
            MessagesDataManagerBase.access$200(MessagesDataManagerBase.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), avoid);
        }
        return avoid.getResultStatus();
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected EbayMessage getMessage()
    {
        if (messages.isEmpty())
        {
            return null;
        } else
        {
            return (EbayMessage)messages.get(0);
        }
    }

    protected List getMessages()
    {
        return messages;
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        if (MessagesDataManagerBase.log.kBase || MessagesDataManagerBase.logDm.kBase || MessagesDataManagerBase.logDmNetwork.ork)
        {
            MessagesDataManagerBase.logDmNetwork.ork((new StringBuilder()).append("Finishing task: ").append(this).toString());
            MessagesDataManagerBase.logDmNetwork.ork((new StringBuilder()).append("  Result: hasError[").append(resultstatus.hasError()).append("]").toString());
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(messages[").append(messages).append("])").toString();
    }

    public (EbayMessage ebaymessage)
    {
        this(MessagesUtils.makeList(ebaymessage));
    }

    public <init>(List list)
    {
        this$0 = MessagesDataManagerBase.this;
        super();
        messages = list;
    }
}
