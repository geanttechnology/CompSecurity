// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.data.MessageFolder;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessagesDataManagerBase, MessagesUtils, UserContextObservingDataManager

public class MessageFoldersDataManager extends MessagesDataManagerBase
{
    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return MessageFoldersDataManager.KEY;
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

        public MessageFoldersDataManager create(EbayContext ebaycontext)
        {
            return new MessageFoldersDataManager(ebaycontext, this);
        }

        public volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }


        protected KeyParams()
        {
        }
    }

    private final class MessageLoadTask extends MessagesDataManagerBase.MessageLoadTaskBase
    {

        final MessageFoldersDataManager this$0;

        protected void onPostExecute(ResultStatus resultstatus)
        {
            super.onPostExecute(resultstatus);
            messageLoadTask = null;
            if (!resultstatus.hasError())
            {
                setContent(Collections.unmodifiableList(getOutFolders()), resultstatus);
            }
            ((Observer)unmodifiableList).onMessageFoldersListChanged(MessageFoldersDataManager.this, getContent());
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ResultStatus)obj);
        }

        public MessageLoadTask()
        {
            this$0 = MessageFoldersDataManager.this;
            super(MessageFoldersDataManager.this, null, null);
        }
    }

    public static interface Observer
    {

        public abstract void onMessageFoldersDataChanged(MessageFoldersDataManager messagefoldersdatamanager, Content content);

        public abstract void onMessageFoldersListChanged(MessageFoldersDataManager messagefoldersdatamanager, Content content);
    }


    public static final KeyParams KEY = new KeyParams();
    private MessageLoadTask messageLoadTask;

    MessageFoldersDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/MessageFoldersDataManager$Observer, keyparams);
        messageLoadTask = null;
    }

    private int countUnreadMessages(List list)
    {
        int j = 0;
        int i = 0;
        if (list != null)
        {
            list = list.iterator();
            do
            {
                j = i;
                if (!list.hasNext())
                {
                    break;
                }
                if (((EbayMessage)list.next()).isUnread())
                {
                    i++;
                }
            } while (true);
        }
        return j;
    }

    protected void cancelAllLoaders()
    {
        if (messageLoadTask != null)
        {
            messageLoadTask.cancel(true);
            messageLoadTask = null;
        }
    }

    public List getDataIfExists()
    {
        return (List)contentData;
    }

    void informMessagesAdded(List list)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessagesAdded: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("]").toString());
        }
        NautilusKernel.verifyMain();
        int i;
        if (list != null && contentData != null)
        {
            if ((i = list.size()) != 0)
            {
                long l = ((EbayMessage)list.get(0)).folderId;
                ArrayList arraylist = new ArrayList((Collection)contentData);
                MessageFolder messagefolder = MessagesUtils.findByIdAndRemove(l, arraylist);
                if (messagefolder != null)
                {
                    int j = countUnreadMessages(list);
                    list = messagefolder.buildUpon().totalMessageCount(messagefolder.totalMessageCount + i).newMessageCount(messagefolder.newMessageCount + j).build();
                    arraylist.add(list);
                    contentData = Collections.unmodifiableList(arraylist);
                    ((Observer)dispatcher).onMessageFoldersDataChanged(this, new Content(MessagesUtils.makeList(list)));
                    return;
                }
            }
        }
    }

    void informMessagesDeleted(List list)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessagesDeleted: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("]").toString());
        }
        NautilusKernel.verifyMain();
        int i;
        if (list != null && contentData != null)
        {
            if ((i = list.size()) != 0)
            {
                long l = ((EbayMessage)list.get(0)).folderId;
                ArrayList arraylist = new ArrayList((Collection)contentData);
                MessageFolder messagefolder = MessagesUtils.findByIdAndRemove(l, arraylist);
                if (messagefolder != null)
                {
                    int j = countUnreadMessages(list);
                    list = messagefolder.buildUpon().totalMessageCount(Math.max(0, messagefolder.totalMessageCount - i)).newMessageCount(Math.max(0, messagefolder.newMessageCount - j)).build();
                    arraylist.add(list);
                    contentData = Collections.unmodifiableList(arraylist);
                    ((Observer)dispatcher).onMessageFoldersDataChanged(this, new Content(MessagesUtils.makeList(list)));
                    return;
                }
            }
        }
    }

    void informMessagesMoved(List list, long l)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessagesMoved: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("], sourceFolderId[").append(l).append("]").toString());
        }
        NautilusKernel.verifyMain();
        int i;
        if (list != null && contentData != null)
        {
            if ((i = list.size()) != 0)
            {
                int j = countUnreadMessages(list);
                long l1 = ((EbayMessage)list.get(0)).folderId;
                list = new ArrayList((Collection)contentData);
                ArrayList arraylist = new ArrayList(2);
                MessageFolder messagefolder = MessagesUtils.findByIdAndRemove(l, list);
                if (messagefolder != null)
                {
                    messagefolder = messagefolder.buildUpon().totalMessageCount(Math.max(0, messagefolder.totalMessageCount - i)).newMessageCount(Math.max(0, messagefolder.newMessageCount - j)).build();
                    list.add(messagefolder);
                    arraylist.add(messagefolder);
                }
                messagefolder = MessagesUtils.findByIdAndRemove(l1, list);
                if (messagefolder != null)
                {
                    messagefolder = messagefolder.buildUpon().totalMessageCount(messagefolder.totalMessageCount + i).newMessageCount(messagefolder.newMessageCount + j).build();
                    list.add(messagefolder);
                    arraylist.add(messagefolder);
                }
                if (!arraylist.isEmpty())
                {
                    contentData = Collections.unmodifiableList(list);
                    ((Observer)dispatcher).onMessageFoldersDataChanged(this, new Content(arraylist));
                    return;
                }
            }
        }
    }

    void informMessagesRead(List list, List list1)
    {
        if (log.isLoggable || logDm.isLoggable)
        {
            logDm.log((new StringBuilder()).append("informMessagesRead: ").append(this).toString());
            logDm.log((new StringBuilder()).append("  Params: messages[").append(list).append("]").toString());
        }
        NautilusKernel.verifyMain();
        if (list != null && !list.isEmpty() && contentData != null)
        {
            EbayMessage ebaymessage = (EbayMessage)list.get(0);
            ArrayList arraylist = new ArrayList((Collection)contentData);
            MessageFolder messagefolder = MessagesUtils.findByIdAndRemove(ebaymessage.folderId, arraylist);
            if (messagefolder != null)
            {
                if (list1 != null)
                {
                    list = messagefolder.buildUpon().newMessageCount(countUnreadMessages(list1)).build();
                    arraylist.add(list);
                    contentData = Collections.unmodifiableList(arraylist);
                } else
                {
                    int j = list.size();
                    int i;
                    if (ebaymessage.isUnread())
                    {
                        i = 1;
                    } else
                    {
                        i = -1;
                    }
                    list = messagefolder.buildUpon().newMessageCount(messagefolder.newMessageCount + j * i).build();
                    arraylist.add(list);
                    contentData = Collections.unmodifiableList(arraylist);
                }
                list = new Content(MessagesUtils.makeList(list));
                ((Observer)dispatcher).onMessageFoldersDataChanged(this, list);
                return;
            }
        }
    }

    public void loadData(Observer observer)
    {
        super.loadData(observer);
        NautilusKernel.verifyMain();
        if (messageLoadTask == null)
        {
            if (contentData == null)
            {
                setContent(Collections.unmodifiableList(Arrays.asList(new MessageFolder[] {
                    (new com.ebay.nautilus.domain.data.MessageFolder.Builder(0L)).build(), (new com.ebay.nautilus.domain.data.MessageFolder.Builder(1L)).build(), (new com.ebay.nautilus.domain.data.MessageFolder.Builder(6L)).build()
                })), ResultStatus.SUCCESS);
                messageLoadTask = new MessageLoadTask();
                executeOnThreadPool(messageLoadTask, new Void[0]);
            }
            if (observer != null)
            {
                observer.onMessageFoldersListChanged(this, getContent());
                return;
            }
        }
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public boolean reloadData()
    {
        super.reloadData();
        NautilusKernel.verifyMain();
        if (messageLoadTask != null)
        {
            return false;
        } else
        {
            clearContent();
            messageLoadTask = new MessageLoadTask();
            executeOnThreadPool(messageLoadTask, new Void[0]);
            return true;
        }
    }



/*
    static MessageLoadTask access$002(MessageFoldersDataManager messagefoldersdatamanager, MessageLoadTask messageloadtask)
    {
        messagefoldersdatamanager.messageLoadTask = messageloadtask;
        return messageloadtask;
    }

*/

}
