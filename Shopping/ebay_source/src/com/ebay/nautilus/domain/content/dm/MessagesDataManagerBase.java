// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.InternalDomainError;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.trading.DeleteMyMessagesRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyMessagesRequest;
import com.ebay.nautilus.domain.net.api.trading.GetMyMessagesResponse;
import com.ebay.nautilus.domain.net.api.trading.ReviseMyMessagesRequest;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager, MessagesUtils

public abstract class MessagesDataManagerBase extends UserContextObservingDataManager
{
    protected class DeleteTaskBase extends AsyncTask
    {

        private final List messages;
        final MessagesDataManagerBase this$0;

        protected transient ResultStatus doInBackground(Void avoid[])
        {
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            avoid = new ResultStatusOwner();
            Object obj = getTradingApi(avoid);
            if (obj != null)
            {
                obj = new DeleteMyMessagesRequest(((EbayTradingApi) (obj)), messages);
                safeSendRequest(((Request) (obj)), avoid);
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
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Finishing task: ").append(this).toString());
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("  Result: hasError[").append(resultstatus.hasError()).append("]").toString());
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

        public DeleteTaskBase(EbayMessage ebaymessage)
        {
            this(MessagesUtils.makeList(ebaymessage));
        }

        public DeleteTaskBase(List list)
        {
            this$0 = MessagesDataManagerBase.this;
            super();
            messages = list;
        }
    }

    protected class MessageLoadTaskBase extends AsyncTask
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
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            avoid = new ResultStatusOwner();
            Object obj = getTradingApi(avoid);
            if (obj != null)
            {
                obj = new GetMyMessagesRequest(((EbayTradingApi) (obj)), inFolderId, inMessage, daysToFetch);
                obj = (GetMyMessagesResponse)safeSendRequest(((Request) (obj)), avoid);
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
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Finishing task: ").append(this).toString());
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("  Result: hasError[").append(resultstatus.hasError()).append("]").toString());
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

        public MessageLoadTaskBase(Long long1, EbayMessage ebaymessage)
        {
            this(long1, ebaymessage, 90L);
        }

        public MessageLoadTaskBase(Long long1, EbayMessage ebaymessage, long l)
        {
            this$0 = MessagesDataManagerBase.this;
            super();
            inFolderId = long1;
            inMessage = ebaymessage;
            daysToFetch = l;
        }
    }

    protected class ReviseTaskBase extends AsyncTask
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
                ebaymessage.folderId(long1.longValue());
            }
            if (boolean1 != null)
            {
                ebaymessage.read(boolean1.booleanValue());
            }
            if (boolean2 != null)
            {
                ebaymessage.flagged(boolean2.booleanValue());
            }
            return ebaymessage.build();
        }

        protected transient ResultStatus doInBackground(Void avoid[])
        {
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            avoid = new ResultStatusOwner();
            Object obj = getTradingApi(avoid);
            if (obj != null)
            {
                obj = new ReviseMyMessagesRequest(((EbayTradingApi) (obj)), messages, destFolderId, isRead, isFlagged);
                safeSendRequest(((Request) (obj)), avoid);
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
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Finishing task: ").append(this).toString());
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("  Result: hasError[").append(resultstatus.hasError()).append("]").toString());
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

        public ReviseTaskBase(EbayMessage ebaymessage, Long long1, Long long2, Boolean boolean1, Boolean boolean2)
        {
            this(MessagesUtils.makeList(ebaymessage), long1, long2, boolean1, boolean2);
        }

        public ReviseTaskBase(List list, Long long1, Long long2, Boolean boolean1, Boolean boolean2)
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


    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages", 3, "User Messages sent between eBay members and to/from eBay.");
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logDm = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages.Dm", 3, "User Messages sent between eBay members and to/from eBay.");
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logDmNetwork = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("Messages.Dm.Network", 3, "User Messages sent between eBay members and to/from eBay.");
    protected Object contentData;
    protected ResultStatus contentStatus;
    private volatile EbayCountry currentCountry;
    private volatile String currentIafToken;

    protected MessagesDataManagerBase(EbayContext ebaycontext, Class class1, UserContextObservingDataManager.KeyBase keybase)
    {
        super(ebaycontext, class1, keybase);
        contentStatus = ResultStatus.UNKNOWN;
        contentData = null;
    }

    protected abstract void cancelAllLoaders();

    protected void clearContent()
    {
        contentData = null;
        contentStatus = ResultStatus.UNKNOWN;
    }

    protected Content getContent()
    {
        return new Content(contentData, contentStatus);
    }

    protected EbayShoppingApi getShoppingApi(ResultStatusOwner resultstatusowner)
    {
        EbayCountry ebaycountry = currentCountry;
        if (ebaycountry == null)
        {
            resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getCountryNotSpecifiedMessage()
            });
            return null;
        } else
        {
            return new EbayShoppingApi(ebaycountry.site);
        }
    }

    protected EbayTradingApi getTradingApi(ResultStatusOwner resultstatusowner)
    {
        EbayCountry ebaycountry = currentCountry;
        String s = currentIafToken;
        if (ebaycountry == null)
        {
            resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getCountryNotSpecifiedMessage()
            });
        }
        if (s == null)
        {
            resultstatusowner.addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                InternalDomainError.getPleaseSignInMessage()
            });
            return null;
        } else
        {
            return new EbayTradingApi(ebaycountry.site, s);
        }
    }

    void informError(ResultStatus resultstatus)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informError: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Result: hasError[").append(resultstatus.hasError()).append("]").toString());
        }
        if (resultstatus.hasError())
        {
            invalidateData();
        }
    }

    public void invalidateData()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("Invalidate data: ").append(this).toString());
        }
        NautilusKernel.verifyMain();
        clearContent();
        cancelAllLoaders();
    }

    public void loadData(Object obj)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("Load data: ").append(this).toString());
        }
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("onCurrentCountryChanged: ").append(this).toString());
        }
        super.onCurrentCountryChanged(usercontextdatamanager, ebaycountry);
        currentCountry = ebaycountry;
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("onCurrentUserChanged: ").append(this).toString());
        }
        currentIafToken = s1;
        if (!flag)
        {
            invalidateData();
        }
    }

    protected void onLastObserverUnregistered()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("onLastObserverUnregistered: ").append(this).toString());
        }
        super.onLastObserverUnregistered();
        cancelAllLoaders();
    }

    public boolean reloadData()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("Reload data: ").append(this).toString());
        }
        return true;
    }

    protected void setContent(Object obj, ResultStatus resultstatus)
    {
        contentData = obj;
        contentStatus = resultstatus;
    }




}
