// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessagesDataManagerBase, MessagesUtils, MessageFoldersDataManager, MessageContentsDataManager, 
//            UserContextObservingDataManager

public class MessageFolderContentsDataManager extends MessagesDataManagerBase
{
    private final class DeleteTask extends MessagesDataManagerBase.DeleteTaskBase
    {

        final MessageFolderContentsDataManager this$0;

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            if (resultstatus.hasError())
            {
                MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(getEbayContext(), MessageFoldersDataManager.KEY);
                if (messagefoldersdatamanager != null)
                {
                    messagefoldersdatamanager.informError(resultstatus);
                }
                resultstatus = new Content(getMessages(), resultstatus);
                ((Observer)KEY).onMessageFolderContentsRemoved(MessageFolderContentsDataManager.this, resultstatus);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public DeleteTask(List list)
        {
            this$0 = MessageFolderContentsDataManager.this;
            super(MessageFolderContentsDataManager.this, list);
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readLong());
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
        public final long folderId;

        public MessageFolderContentsDataManager create(EbayContext ebaycontext)
        {
            return new MessageFolderContentsDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (obj != null && obj.getClass().equals(getClass()))
                {
                    if (folderId != ((KeyParams) (obj = (KeyParams)obj)).folderId)
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + Long.valueOf(folderId).hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("folderId:").append(folderId).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeLong(folderId);
        }


        public KeyParams(long l)
        {
            folderId = l;
        }

        public KeyParams(MessageFolder messagefolder)
        {
            folderId = messagefolder.folderId;
        }
    }

    private final class MessageLoadTask extends MessagesDataManagerBase.MessageLoadTaskBase
    {

        final MessageFolderContentsDataManager this$0;

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            messageLoader = null;
            if (!resultstatus.hasError())
            {
                setContent(getOutMessages(), resultstatus);
            }
            ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public MessageLoadTask(long l)
        {
            this$0 = MessageFolderContentsDataManager.this;
            super(MessageFolderContentsDataManager.this, Long.valueOf(l), null);
        }
    }

    public static interface Observer
    {

        public abstract void onMessageContentsChanged(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content);

        public abstract void onMessageFolderContentsAdded(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content);

        public abstract void onMessageFolderContentsLoaded(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content);

        public abstract void onMessageFolderContentsRemoved(MessageFolderContentsDataManager messagefoldercontentsdatamanager, Content content);
    }

    private final class ReviseTask extends MessagesDataManagerBase.ReviseTaskBase
    {

        final MessageFolderContentsDataManager this$0;

        protected void onPostExecute(ResultStatus resultstatus)
        {
            onPostExecute(resultstatus);
            if (resultstatus.hasError())
            {
                invalidateData();
                EbayContext ebaycontext = getEbayContext();
                Object obj = getMessages();
                Content content = new Content(obj, resultstatus);
                MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(ebaycontext, MessageFoldersDataManager.KEY);
                if (destFolderId != null)
                {
                    if (messagefoldersdatamanager != null)
                    {
                        messagefoldersdatamanager.informError(resultstatus);
                    }
                    MessageFolderContentsDataManager messagefoldercontentsdatamanager = (MessageFolderContentsDataManager)DataManager.getIfExists(ebaycontext, new KeyParams(destFolderId.longValue()));
                    if (messagefoldercontentsdatamanager != null)
                    {
                        messagefoldercontentsdatamanager.informError(resultstatus);
                    }
                    ((Observer)
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public ReviseTask(List list, Long long1, Long long2, Boolean boolean1, Boolean boolean2)
        {
            this$0 = MessageFolderContentsDataManager.this;
            super(MessageFolderContentsDataManager.this, list, long1, long2, boolean1, boolean2);
        }
    }


    private MessageLoadTask messageLoader;

    MessageFolderContentsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        MessagesDataManagerBase(ebaycontext, com/ebay/nautilus/domain/content/dm/MessageFolderContentsDataManager$Observer, keyparams);
        messageLoader = null;
    }

    private void addToContents(List list)
    {
        if (contentData == null)
        {
            return;
        } else
        {
            ((List)contentData).removeAll(list);
            ((List)contentData).addAll(list);
            return;
        }
    }

    private void removeFromContents(EbayMessage ebaymessage)
    {
        if (contentData == null)
        {
            return;
        } else
        {
            ((List)contentData).remove(ebaymessage);
            return;
        }
    }

    private void removeFromContents(List list)
    {
        if (contentData == null)
        {
            return;
        } else
        {
            ((List)contentData).removeAll(list);
            return;
        }
    }

    private void scheduleReviseTask(List list, Long long1, Boolean boolean1, Boolean boolean2)
    {
        if (list != null && !list.isEmpty() && (long1 != null || boolean1 != null || boolean2 != null))
        {
            long l = ((EbayMessage)list.get(0)).folderId;
            int i = 0;
            while (i < list.size()) 
            {
                int j = Math.min(list.size(), i + 10);
                executeOnThreadPool(new ReviseTask(list.subList(i, j), Long.valueOf(l), long1, boolean1, boolean2), new Void[0]);
                i = j;
            }
        }
    }

    private boolean updateContents(EbayMessage ebaymessage)
    {
        if (contentData == null)
        {
            return false;
        } else
        {
            return MessagesUtils.update(ebaymessage, (List)contentData);
        }
    }

    private boolean updateContents(List list)
    {
        if (list == null)
        {
            return false;
        }
        boolean flag = true;
        for (list = list.iterator(); list.hasNext();)
        {
            if (updateContents((EbayMessage)list.next()) && flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        return flag;
    }

    public void addNewMessage(EbayMessage ebaymessage)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("addNewMessage: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(ebaymessage).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (ebaymessage != null)
        {
            updateContents(MessagesUtils.makeList(ebaymessage.clone()));
            MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(getEbayContext(), MessageFoldersDataManager.KEY);
            if (messagefoldersdatamanager != null)
            {
                messagefoldersdatamanager.informMessagesAdded(MessagesUtils.makeList(ebaymessage.clone()));
                return;
            }
        }
    }

    protected void cancelAllLoaders()
    {
        if (messageLoader != null)
        {
            messageLoader.cancel(true);
            messageLoader = null;
        }
    }

    public final void deleteMessages(List list)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("deleteMessages: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("Message list must not be null/empty!");
        }
        list = new ArrayList(list);
        removeFromContents(list);
        Object obj = (MessageFoldersDataManager)DataManager.getIfExists(getEbayContext(), MessageFoldersDataManager.KEY);
        if (obj != null)
        {
            ((MessageFoldersDataManager) (obj)).informMessagesDeleted(list);
        }
        obj = new Content(list);
        ((Observer)dispatcher).onMessageFolderContentsRemoved(this, ((Content) (obj)));
        int j;
        for (int i = 0; i < list.size(); i = j)
        {
            j = Math.min(list.size(), i + 10);
            executeOnThreadPool(new DeleteTask(list.subList(i, j)), new Void[0]);
        }

    }

    public final void flagMessages(List list, boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("flagMessages: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("], isFlagged[").append(flag).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("Message list must not be null/empty!");
        }
        Object obj = new ArrayList(list.size());
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).add(((EbayMessage)iterator.next()).buildUpon().flagged(flag).build())) { }
        updateContents(((List) (obj)));
        Iterator iterator1 = ((List) (obj)).iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            Object obj1 = (EbayMessage)iterator1.next();
            obj1 = (MessageContentsDataManager)DataManager.getIfExists(getEbayContext(), new KeyParams(((EbayMessage) (obj1))));
            if (obj1 != null)
            {
                ((MessageContentsDataManager) (obj1)).informMessageFlagged(flag);
            }
        } while (true);
        obj = new Content(obj);
        ((Observer)dispatcher).onMessageContentsChanged(this, ((Content) (obj)));
        scheduleReviseTask(list, null, null, Boolean.valueOf(flag));
    }

    protected Content getContent()
    {
        if (contentData == null)
        {
            return new Content(contentStatus);
        } else
        {
            return new Content(Collections.unmodifiableList((List)contentData), contentStatus);
        }
    }

    public final long getFolder()
    {
        return ((KeyParams)getParams()).folderId;
    }

    final void informMessageDeleted(EbayMessage ebaymessage)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessageDeleted: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(ebaymessage).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (ebaymessage == null)
        {
            return;
        } else
        {
            removeFromContents(ebaymessage);
            ebaymessage = new Content(MessagesUtils.makeList(ebaymessage));
            ((Observer)dispatcher).onMessageFolderContentsRemoved(this, ebaymessage);
            return;
        }
    }

    final void informMessageUpdated(EbayMessage ebaymessage)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessageUpdated: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: message[").append(ebaymessage).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (ebaymessage == null)
        {
            return;
        } else
        {
            updateContents(ebaymessage);
            ebaymessage = new Content(MessagesUtils.makeList(ebaymessage));
            ((Observer)dispatcher).onMessageContentsChanged(this, ebaymessage);
            return;
        }
    }

    final void informMessagesAdded(List list)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessageAdded: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (list == null)
        {
            return;
        } else
        {
            addToContents(list);
            list = new Content(list);
            ((Observer)dispatcher).onMessageFolderContentsAdded(this, list);
            return;
        }
    }

    final void informMessagesMoved(List list, long l)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessagesMoved: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("], sourceFolderId[").append(l).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (list != null && !list.isEmpty())
        {
            long l1 = ((KeyParams)getParams()).folderId;
            long l2 = ((EbayMessage)list.get(0)).folderId;
            Content content = new Content(list);
            if (l1 == l)
            {
                removeFromContents(list);
                ((Observer)dispatcher).onMessageFolderContentsRemoved(this, content);
                return;
            }
            if (l1 == l2)
            {
                addToContents(list);
                ((Observer)dispatcher).onMessageFolderContentsAdded(this, content);
                return;
            }
        }
    }

    public void loadData(Observer observer)
    {
        loadData(observer);
        NautilusKernel.verifyMain();
        if (messageLoader == null)
        {
            observer = (Observer)getSafeCallback(observer);
            if (contentData == null)
            {
                messageLoader = new MessageLoadTask(((KeyParams)getParams()).folderId);
                executeOnThreadPool(messageLoader, new Void[0]);
                return;
            }
            if (observer != null)
            {
                observer.onMessageFolderContentsLoaded(this, getContent());
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public final void markReadMessages(List list, boolean flag)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("markReadMessages: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("], isRead[").append(flag).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (list == null || list.isEmpty())
        {
            return;
        }
        Object obj = new ArrayList(list.size());
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((List) (obj)).add(((EbayMessage)iterator.next()).buildUpon().read(flag).build())) { }
        updateContents(((List) (obj)));
        EbayContext ebaycontext = getEbayContext();
        Object obj1 = (MessageFoldersDataManager)DataManager.getIfExists(ebaycontext, MessageFoldersDataManager.KEY);
        if (obj1 != null)
        {
            ((MessageFoldersDataManager) (obj1)).informMessagesRead(((List) (obj)), (List)contentData);
        }
        obj1 = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            MessageContentsDataManager messagecontentsdatamanager = (MessageContentsDataManager)DataManager.getIfExists(ebaycontext, new KeyParams((EbayMessage)((Iterator) (obj1)).next()));
            if (messagecontentsdatamanager != null)
            {
                messagecontentsdatamanager.informMessageRead(flag);
            }
        } while (true);
        obj = new Content(obj);
        ((Observer)dispatcher).onMessageContentsChanged(this, ((Content) (obj)));
        scheduleReviseTask(list, null, Boolean.valueOf(flag), null);
    }

    public final void moveMessages(List list, MessageFolder messagefolder)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("moveMessages: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("], destFolder[").append(messagefolder).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (list == null || list.isEmpty())
        {
            throw new IllegalArgumentException("Message list must not be null/empty!");
        }
        if (messagefolder == null)
        {
            throw new IllegalArgumentException("Missing destination folder for a message move!");
        }
        long l = messagefolder.folderId;
        if (l == ((KeyParams)getParams()).folderId)
        {
            return;
        }
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); arraylist.add(((EbayMessage)list.next()).buildUpon().folderId(l).build())) { }
        removeFromContents(arraylist);
        list = getEbayContext();
        MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(list, MessageFoldersDataManager.KEY);
        if (messagefoldersdatamanager != null)
        {
            messagefoldersdatamanager.informMessagesMoved(arraylist, ((KeyParams)getParams()).folderId);
        }
        list = (MessageFolderContentsDataManager)DataManager.getIfExists(list, new KeyParams(l));
        if (list != null)
        {
            list.informMessagesMoved(arraylist, ((KeyParams)getParams()).folderId);
        }
        list = new Content(arraylist);
        ((Observer)dispatcher).onMessageFolderContentsRemoved(this, list);
        scheduleReviseTask(arraylist, Long.valueOf(messagefolder.folderId), null, null);
    }

    public final boolean reloadData()
    {
        reloadData();
        NautilusKernel.verifyMain();
        if (messageLoader != null)
        {
            return false;
        } else
        {
            clearContent();
            messageLoader = new MessageLoadTask(((KeyParams)getParams()).folderId);
            executeOnThreadPool(messageLoader, new Void[0]);
            return true;
        }
    }


/*
    static MessageLoadTask access$002(MessageFolderContentsDataManager messagefoldercontentsdatamanager, MessageLoadTask messageloadtask)
    {
        messagefoldercontentsdatamanager.messageLoader = messageloadtask;
        return messageloadtask;
    }

*/





}
