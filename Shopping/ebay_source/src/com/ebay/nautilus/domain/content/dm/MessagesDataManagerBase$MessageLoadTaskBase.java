// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.api.trading.GetMyMessagesRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyMessagesResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessagesDataManagerBase

protected class daysToFetch extends AsyncTask
{

    private static final long DEFAULT_DAYS_TO_FETCH = 90L;
    private final long daysToFetch;
    private final Long inFolderId;
    private final EbayMessage inMessage;
    private List outFolders;
    private List outMessages;
    final MessagesDataManagerBase this$0;

    protected transient ResultStatus doInBackground(Void avoid[])
    {
        if (MessagesDataManagerBase.log.kBase || MessagesDataManagerBase.logDm.kBase || MessagesDataManagerBase.logDmNetwork.kBase)
        {
            MessagesDataManagerBase.logDmNetwork.kBase((new StringBuilder()).append("Starting background task: ").append(this).toString());
        }
        avoid = new ResultStatusOwner();
        Object obj = getTradingApi(avoid);
        if (obj != null)
        {
            obj = new GetMyMessagesRequest(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), inFolderId, inMessage, daysToFetch);
            obj = (GetMyMessagesResponse)MessagesDataManagerBase.access$000(MessagesDataManagerBase.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), avoid);
            if (obj != null)
            {
                outFolders = ((GetMyMessagesResponse) (obj)).folders;
                outMessages = ((GetMyMessagesResponse) (obj)).messages;
            }
            if (outFolders == null)
            {
                outFolders = Collections.emptyList();
            }
            if (outMessages == null)
            {
                outMessages = Collections.emptyList();
            }
        }
        return avoid.getResultStatus();
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected List getOutFolders()
    {
        return outFolders;
    }

    protected EbayMessage getOutMessage()
    {
        if (outMessages.isEmpty())
        {
            return null;
        } else
        {
            return (EbayMessage)outMessages.get(0);
        }
    }

    protected List getOutMessages()
    {
        return outMessages;
    }

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        if (MessagesDataManagerBase.log.kBase || MessagesDataManagerBase.logDm.kBase || MessagesDataManagerBase.logDmNetwork.kBase)
        {
            MessagesDataManagerBase.logDmNetwork.kBase((new StringBuilder()).append("Finishing task: ").append(this).toString());
            MessagesDataManagerBase.logDmNetwork.kBase((new StringBuilder()).append("  Result: hasError[").append(resultstatus.hasError()).append("]").toString());
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(inFolderId[").append(inFolderId).append("], inMessage[").append(inMessage).append("], daysToFetch[").append(daysToFetch).append("])").toString();
    }

    public (Long long1, EbayMessage ebaymessage)
    {
        this(long1, ebaymessage, 90L);
    }

    public <init>(Long long1, EbayMessage ebaymessage, long l)
    {
        this$0 = MessagesDataManagerBase.this;
        super();
        inFolderId = long1;
        inMessage = ebaymessage;
        daysToFetch = l;
    }
}
