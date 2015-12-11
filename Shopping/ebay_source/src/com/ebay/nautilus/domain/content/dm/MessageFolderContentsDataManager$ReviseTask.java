// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageFolderContentsDataManager, MessageFoldersDataManager, MessageContentsDataManager

private final class > extends >
{

    final MessageFolderContentsDataManager this$0;

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.tExecute(resultstatus);
        if (resultstatus.hasError())
        {
            invalidateData();
            com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getEbayContext();
            Object obj = getMessages();
            Content content = new Content(obj, resultstatus);
            MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(ebaycontext, MessageFoldersDataManager.KEY);
            if (destFolderId != null)
            {
                if (messagefoldersdatamanager != null)
                {
                    messagefoldersdatamanager.informError(resultstatus);
                }
                MessageFolderContentsDataManager messagefoldercontentsdatamanager = (MessageFolderContentsDataManager)DataManager.getIfExists(ebaycontext, new init>(destFolderId.longValue()));
                if (messagefoldercontentsdatamanager != null)
                {
                    messagefoldercontentsdatamanager.informError(resultstatus);
                }
                (()MessageFolderContentsDataManager.access$200(MessageFolderContentsDataManager.this)).MessageFolderContentsRemoved(MessageFolderContentsDataManager.this, content);
            }
            if (isRead != null)
            {
                if (messagefoldersdatamanager != null)
                {
                    messagefoldersdatamanager.informError(resultstatus);
                }
                ((isRead)MessageFolderContentsDataManager.access$300(MessageFolderContentsDataManager.this)).MessageContentsChanged(MessageFolderContentsDataManager.this, content);
            }
            if (isFlagged != null)
            {
                obj = ((List) (obj)).iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    MessageContentsDataManager messagecontentsdatamanager = (MessageContentsDataManager)DataManager.getIfExists(ebaycontext, new isFlagged((EbayMessage)((Iterator) (obj)).next()));
                    if (messagecontentsdatamanager != null)
                    {
                        messagecontentsdatamanager.informError(resultstatus);
                    }
                } while (true);
                ((isFlagged)MessageFolderContentsDataManager.access$400(MessageFolderContentsDataManager.this)).MessageContentsChanged(MessageFolderContentsDataManager.this, content);
            }
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public (List list, Long long1, Long long2, Boolean boolean1, Boolean boolean2)
    {
        this$0 = MessageFolderContentsDataManager.this;
        super(MessageFolderContentsDataManager.this, list, long1, long2, boolean1, boolean2);
    }
}
