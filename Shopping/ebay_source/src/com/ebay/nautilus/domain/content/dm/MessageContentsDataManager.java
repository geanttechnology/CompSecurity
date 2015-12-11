// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.AsyncTask;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.domain.net.api.shopping.GetSingleItemRequest;
import com.ebay.nautilus.domain.net.api.shopping.GetSingleItemResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessagesDataManagerBase, MessageFoldersDataManager, MessagesUtils, MessageFolderContentsDataManager, 
//            UserContextObservingDataManager

public class MessageContentsDataManager extends MessagesDataManagerBase
{
    private final class BodyLoadTask extends MessagesDataManagerBase.MessageLoadTaskBase
    {

        final MessageContentsDataManager this$0;

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            bodyLoadTask = null;
            if (resultstatus.hasError() && (contentData == null || TextUtils.isEmpty(((EbayMessage)contentData).text)))
            {
                ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public BodyLoadTask(EbayMessage ebaymessage)
        {
            this$0 = MessageContentsDataManager.this;
            super(MessageContentsDataManager.this, null, ebaymessage);
        }
    }

    private final class ItemLoadTask extends AsyncTask
    {

        private final EbayMessage message;
        final MessageContentsDataManager this$0;

        protected transient Content doInBackground(Void avoid[])
        {
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Starting background task: ").append(this).toString());
            }
            Object obj = null;
            ResultStatusOwner resultstatusowner = new ResultStatusOwner();
            Object obj1 = getShoppingApi(resultstatusowner);
            avoid = obj;
            if (obj1 != null)
            {
                avoid = new GetSingleItemRequest(((com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi) (obj1)), message.itemId, "Details");
                obj1 = (GetSingleItemResponse)safeSendRequest(avoid, resultstatusowner);
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
            if (MessagesDataManagerBase.log.isLoggable || MessagesDataManagerBase.logDm.isLoggable || MessagesDataManagerBase.logDmNetwork.isLoggable)
            {
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("Finishing task: ").append(this).toString());
                MessagesDataManagerBase.logDmNetwork.log((new StringBuilder()).append("  Result: hasError[").append(content.getStatus().hasError()).append("], data[").append(content.getData()).append("]").toString());
            }
            itemLoadTask = null;
            if (!content.getStatus().hasError())
            {
                itemContentStatus = content.getStatus();
                itemContentData = (EbayItem)content.getData();
                ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Content)obj);
        }

        public String toString()
        {
            return (new StringBuilder()).append(getClass().getSimpleName()).append("(message[").append(message).append("], item ID[").append(message.itemId).append("])").toString();
        }

        public ItemLoadTask(EbayMessage ebaymessage)
        {
            this$0 = MessageContentsDataManager.this;
            super();
            message = ebaymessage;
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams((EbayMessage)EbayMessage.CREATOR.createFromParcel(parcel));
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final EbayMessage message;

        public MessageContentsDataManager create(EbayContext ebaycontext)
        {
            return new MessageContentsDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj == this)
            {
                return true;
            }
            if (obj != null && obj.getClass().equals(getClass()))
            {
                return ((KeyParams)obj).message.equals(message);
            } else
            {
                return false;
            }
        }

        public final EbayMessage getMessage()
        {
            return message;
        }

        public int hashCode()
        {
            return hashCode() * 31 + message.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("message:").append(message).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            message.writeToParcel(parcel, i);
        }


        public KeyParams(EbayMessage ebaymessage)
        {
            message = ebaymessage.clone();
        }
    }

    public static interface Observer
    {

        public abstract void onDeleteMessageCompleted(MessageContentsDataManager messagecontentsdatamanager, Content content);

        public abstract void onMessageContentsChanged(MessageContentsDataManager messagecontentsdatamanager, Content content);

        public abstract void onMessageItemChanged(MessageContentsDataManager messagecontentsdatamanager, Content content);

        public abstract void onMoveMessageCompleted(MessageContentsDataManager messagecontentsdatamanager, Content content, long l);
    }

    private final class ReviseTask extends MessagesDataManagerBase.ReviseTaskBase
    {

        final MessageContentsDataManager this$0;

        protected void onPostExecute(ResultStatus resultstatus)
        {
            onPostExecute(resultstatus);
            if (resultstatus.hasError())
            {
                invalidateData();
                Object obj = getEbayContext();
                Object obj1 = (MessageFoldersDataManager)DataManager.getIfExists(((EbayContext) (obj)), MessageFoldersDataManager.KEY);
                if (obj1 != null)
                {
                    ((MessageFoldersDataManager) (obj1)).informError(resultstatus);
                }
                obj1 = (MessageFolderContentsDataManager)DataManager.getIfExists(((EbayContext) (obj)), folderContentsKey);
                if (obj1 != null)
                {
                    ((MessageFolderContentsDataManager) (obj1)).informError(resultstatus);
                }
                obj1 = new Content(getMessage(), resultstatus);
                if (destFolderId != null)
                {
                    obj = (MessageFolderContentsDataManager)DataManager.getIfExists(((EbayContext) (obj)), new KeyParams(destFolderId.longValue()));
                    if (obj != null)
                    {
                        ((MessageFolderContentsDataManager) (obj)).informError(resultstatus);
                    }
                    ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public ReviseTask(EbayMessage ebaymessage, Boolean boolean1, Boolean boolean2)
        {
            this$0 = MessageContentsDataManager.this;
            super(MessageContentsDataManager.this, ebaymessage, null, null, boolean1, boolean2);
        }

        public ReviseTask(EbayMessage ebaymessage, Long long1, Long long2)
        {
            this$0 = MessageContentsDataManager.this;
            super(MessageContentsDataManager.this, ebaymessage, long1, long2, null, null);
        }
    }


    private BodyLoadTask bodyLoadTask;
    private final MessageFolderContentsDataManager.KeyParams folderContentsKey;
    private EbayItem itemContentData;
    private ResultStatus itemContentStatus;
    private ItemLoadTask itemLoadTask;

    MessageContentsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        MessagesDataManagerBase(ebaycontext, com/ebay/nautilus/domain/content/dm/MessageContentsDataManager$Observer, keyparams);
        itemContentStatus = ResultStatus.UNKNOWN;
        itemContentData = null;
        bodyLoadTask = null;
        itemLoadTask = null;
        folderContentsKey = new KeyParams((new Builder(keyparams.message.folderId)).build());
    }

    private void clearItemContent()
    {
        itemContentStatus = ResultStatus.UNKNOWN;
        itemContentData = null;
    }

    private Content getItemContent()
    {
        return new Content(itemContentData, itemContentStatus);
    }

    protected void cancelAllLoaders()
    {
        if (bodyLoadTask != null)
        {
            bodyLoadTask.cancel(true);
        }
        if (itemLoadTask != null)
        {
            itemLoadTask.cancel(true);
        }
    }

    public void deleteMessage()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("deleteMessage: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(contentData).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (contentData == null)
        {
            return;
        }
        Object obj = getEbayContext();
        MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(((EbayContext) (obj)), MessageFoldersDataManager.KEY);
        if (messagefoldersdatamanager != null)
        {
            messagefoldersdatamanager.informMessagesDeleted(MessagesUtils.makeList(contentData));
        }
        obj = (MessageFolderContentsDataManager)DataManager.getIfExists(((EbayContext) (obj)), folderContentsKey);
        if (obj != null)
        {
            ((MessageFolderContentsDataManager) (obj)).informMessageDeleted((EbayMessage)contentData);
        }
        obj = new Content(contentData);
        ((Observer)dispatcher).onDeleteMessageCompleted(this, ((Content) (obj)));
        executeOnThreadPool(new DeleteTask((EbayMessage)contentData), new Void[0]);
    }

    public void flagMessage(boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("flagMessage: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(contentData).append("], isFlagged[").append(flag).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (contentData == null)
        {
            return;
        }
        contentData = ((EbayMessage)contentData).buildUpon().flagged(flag).build();
        MessageFolderContentsDataManager messagefoldercontentsdatamanager = (MessageFolderContentsDataManager)DataManager.getIfExists(getEbayContext(), folderContentsKey);
        if (messagefoldercontentsdatamanager != null)
        {
            messagefoldercontentsdatamanager.informMessageUpdated((EbayMessage)contentData);
        }
        ((Observer)dispatcher).onMessageContentsChanged(this, getContent());
        executeOnThreadPool(new ReviseTask((EbayMessage)contentData, null, Boolean.valueOf(flag)), new Void[0]);
    }

    void informMessageFlagged(boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessageFlagged: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: isFlagged[").append(flag).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (contentData != null)
        {
            contentData = ((EbayMessage)contentData).buildUpon().flagged(flag).build();
        }
        ((Observer)dispatcher).onMessageContentsChanged(this, getContent());
    }

    void informMessageRead(boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessageRead: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: isRead[").append(flag).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (contentData != null)
        {
            contentData = ((EbayMessage)contentData).buildUpon().read(flag).build();
        }
        ((Observer)dispatcher).onMessageContentsChanged(this, getContent());
    }

    public void invalidateData()
    {
        invalidateData();
        clearItemContent();
    }

    public void loadData(Observer observer)
    {
        loadData(observer);
        NautilusKernel.verifyMain();
        if (contentData == null)
        {
            setContent(((KeyParams)getParams()).getMessage(), ResultStatus.SUCCESS);
        }
        if (!TextUtils.isEmpty(((EbayMessage)contentData).text)) goto _L2; else goto _L1
_L1:
        bodyLoadTask = new BodyLoadTask((EbayMessage)contentData);
        executeOnThreadPool(bodyLoadTask, new Void[0]);
_L8:
        if (itemContentData != null || ((EbayMessage)contentData).itemId == -1L) goto _L4; else goto _L3
_L3:
        itemLoadTask = new ItemLoadTask((EbayMessage)contentData);
        executeOnThreadPool(itemLoadTask, new Void[0]);
_L6:
        return;
_L2:
        if (observer != null)
        {
            observer.onMessageContentsChanged(this, getContent());
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (itemContentData == null || observer == null) goto _L6; else goto _L5
_L5:
        observer.onMessageItemChanged(this, getItemContent());
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public EbayMessage markReadMessage(boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("markReadMessage: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(contentData).append("], isRead[").append(flag).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (contentData == null)
        {
            return null;
        }
        contentData = ((EbayMessage)contentData).buildUpon().read(flag).build();
        Object obj1 = getEbayContext();
        Object obj = (MessageFolderContentsDataManager)DataManager.getIfExists(((EbayContext) (obj1)), folderContentsKey);
        if (obj != null)
        {
            ((MessageFolderContentsDataManager) (obj)).informMessageUpdated((EbayMessage)contentData);
        }
        obj1 = (MessageFoldersDataManager)DataManager.getIfExists(((EbayContext) (obj1)), MessageFoldersDataManager.KEY);
        if (obj1 != null)
        {
            List list = MessagesUtils.makeList(contentData);
            if (obj != null)
            {
                obj = (List)((MessageFolderContentsDataManager) (obj)).contentData;
            } else
            {
                obj = null;
            }
            ((MessageFoldersDataManager) (obj1)).informMessagesRead(list, ((List) (obj)));
        }
        ((Observer)dispatcher).onMessageContentsChanged(this, getContent());
        executeOnThreadPool(new ReviseTask((EbayMessage)contentData, Boolean.valueOf(flag), null), new Void[0]);
        return (EbayMessage)contentData;
    }

    public EbayMessage markRepliedMessage()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("markRepliedMessage: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(contentData).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (contentData == null)
        {
            return null;
        }
        contentData = ((EbayMessage)contentData).buildUpon().replied(true).build();
        MessageFolderContentsDataManager messagefoldercontentsdatamanager = (MessageFolderContentsDataManager)DataManager.getIfExists(getEbayContext(), folderContentsKey);
        if (messagefoldercontentsdatamanager != null)
        {
            messagefoldercontentsdatamanager.informMessageUpdated((EbayMessage)contentData);
        }
        ((Observer)dispatcher).onMessageContentsChanged(this, getContent());
        return (EbayMessage)contentData;
    }

    public void messageIsNew()
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("messageIsNew: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(contentData).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (contentData != null)
        {
            Object obj = getEbayContext();
            MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(((EbayContext) (obj)), MessageFoldersDataManager.KEY);
            if (messagefoldersdatamanager != null)
            {
                messagefoldersdatamanager.informMessagesAdded(MessagesUtils.makeList(contentData));
            }
            obj = (MessageFolderContentsDataManager)DataManager.getIfExists(((EbayContext) (obj)), folderContentsKey);
            if (obj != null)
            {
                ((MessageFolderContentsDataManager) (obj)).informMessagesAdded(MessagesUtils.makeList(contentData));
                return;
            }
        }
    }

    public void moveMessage(MessageFolder messagefolder)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("moveMessages: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(contentData).append("], destFolder[").append(messagefolder).append("]").toString());
        }
        NautilusKernel.verifyMain();
        break MISSING_BLOCK_LABEL_90;
        if (contentData != null && messagefolder != null)
        {
            long l = ((EbayMessage)contentData).folderId;
            long l1 = messagefolder.folderId;
            if (l1 != l)
            {
                contentData = ((EbayMessage)contentData).buildUpon().folderId(l1).build();
                messagefolder = MessagesUtils.makeList(contentData);
                Object obj = getEbayContext();
                Object obj1 = (MessageFoldersDataManager)DataManager.getIfExists(((EbayContext) (obj)), MessageFoldersDataManager.KEY);
                if (obj1 != null)
                {
                    ((MessageFoldersDataManager) (obj1)).informMessagesMoved(messagefolder, l);
                }
                obj1 = (MessageFolderContentsDataManager)DataManager.getIfExists(((EbayContext) (obj)), folderContentsKey);
                if (obj1 != null)
                {
                    ((MessageFolderContentsDataManager) (obj1)).informMessagesMoved(messagefolder, l);
                }
                obj = (MessageFolderContentsDataManager)DataManager.getIfExists(((EbayContext) (obj)), new KeyParams(l1));
                if (obj != null)
                {
                    ((MessageFolderContentsDataManager) (obj)).informMessagesMoved(messagefolder, l);
                }
                ((Observer)dispatcher).onMoveMessageCompleted(this, getContent(), l);
                executeOnThreadPool(new ReviseTask((EbayMessage)contentData, Long.valueOf(l), Long.valueOf(l1)), new Void[0]);
                return;
            }
        }
        return;
    }

    public boolean reloadData()
    {
        reloadData();
        NautilusKernel.verifyMain();
        boolean flag = false;
        if (bodyLoadTask == null)
        {
            flag = true;
            clearContent();
            bodyLoadTask = new BodyLoadTask(((KeyParams)getParams()).message);
            executeOnThreadPool(bodyLoadTask, new Void[0]);
        }
        if (itemLoadTask == null)
        {
            flag = true;
            clearItemContent();
            itemLoadTask = new ItemLoadTask(((KeyParams)getParams()).message);
            executeOnThreadPool(itemLoadTask, new Void[0]);
        }
        return flag;
    }


/*
    static BodyLoadTask access$002(MessageContentsDataManager messagecontentsdatamanager, BodyLoadTask bodyloadtask)
    {
        messagecontentsdatamanager.bodyLoadTask = bodyloadtask;
        return bodyloadtask;
    }

*/







/*
    static ItemLoadTask access$302(MessageContentsDataManager messagecontentsdatamanager, ItemLoadTask itemloadtask)
    {
        messagecontentsdatamanager.itemLoadTask = itemloadtask;
        return itemloadtask;
    }

*/



/*
    static EbayItem access$402(MessageContentsDataManager messagecontentsdatamanager, EbayItem ebayitem)
    {
        messagecontentsdatamanager.itemContentData = ebayitem;
        return ebayitem;
    }

*/



/*
    static ResultStatus access$602(MessageContentsDataManager messagecontentsdatamanager, ResultStatus resultstatus)
    {
        messagecontentsdatamanager.itemContentStatus = resultstatus;
        return resultstatus;
    }

*/



}
