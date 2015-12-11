// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.api.trading.ReviseMyMessagesRequest;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessagesDataManagerBase, MessagesUtils

protected class isFlagged extends AsyncTask
{

    protected final Long destFolderId;
    protected final Boolean isFlagged;
    protected final Boolean isRead;
    private final List messages;
    protected final Long sourceFolderId;
    final MessagesDataManagerBase this$0;

    private EbayMessage ensureMessageIsUpdated(EbayMessage ebaymessage, Long long1, Boolean boolean1, Boolean boolean2)
    {
        ebaymessage = ebaymessage.buildUpon();
        if (long1 != null)
        {
            ebaymessage.kBase(long1.longValue());
        }
        if (boolean1 != null)
        {
            ebaymessage.kBase(boolean1.booleanValue());
        }
        if (boolean2 != null)
        {
            ebaymessage.kBase(boolean2.booleanValue());
        }
        return ebaymessage.kBase();
    }

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
            obj = new ReviseMyMessagesRequest(((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)), messages, destFolderId, isRead, isFlagged);
            MessagesDataManagerBase.access$100(MessagesDataManagerBase.this, ((com.ebay.nautilus.kernel.net.Request) (obj)), avoid);
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
        return (new StringBuilder()).append(getClass().getSimpleName()).append("(messages[").append(messages).append("], sourceFolderId[").append(sourceFolderId).append("], destFolderId[").append(destFolderId).append("], isRead[").append(isRead).append("], isFlagged[").append(isFlagged).append("])").toString();
    }

    public (EbayMessage ebaymessage, Long long1, Long long2, Boolean boolean1, Boolean boolean2)
    {
        this(MessagesUtils.makeList(ebaymessage), long1, long2, boolean1, boolean2);
    }

    public <init>(List list, Long long1, Long long2, Boolean boolean1, Boolean boolean2)
    {
        this$0 = MessagesDataManagerBase.this;
        super();
        if (list == null || list.size() == 0 || long2 == null && boolean1 == null && boolean2 == null)
        {
            throw new IllegalArgumentException("Must revise message folder, read state or flagged state.");
        }
        messagesdatamanagerbase = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); add(ensureMessageIsUpdated((EbayMessage)list.next(), long2, boolean1, boolean2))) { }
        messages = MessagesDataManagerBase.this;
        sourceFolderId = long1;
        destFolderId = long2;
        isRead = boolean1;
        isFlagged = boolean2;
    }
}
