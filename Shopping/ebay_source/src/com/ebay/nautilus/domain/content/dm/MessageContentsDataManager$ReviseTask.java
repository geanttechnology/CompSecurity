// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageContentsDataManager, MessageFoldersDataManager, MessageFolderContentsDataManager

private final class  extends 
{

    final MessageContentsDataManager this$0;

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        if (resultstatus.hasError())
        {
            invalidateData();
            Object obj = getEbayContext();
            Object obj1 = (MessageFoldersDataManager)DataManager.getIfExists(((com.ebay.nautilus.kernel.content.EbayContext) (obj)), MessageFoldersDataManager.KEY);
            if (obj1 != null)
            {
                ((MessageFoldersDataManager) (obj1)).informError(resultstatus);
            }
            obj1 = (MessageFolderContentsDataManager)DataManager.getIfExists(((com.ebay.nautilus.kernel.content.EbayContext) (obj)), MessageContentsDataManager.access$800(MessageContentsDataManager.this));
            if (obj1 != null)
            {
                ((MessageFolderContentsDataManager) (obj1)).informError(resultstatus);
            }
            obj1 = new Content(getMessage(), resultstatus);
            if (destFolderId != null)
            {
                obj = (MessageFolderContentsDataManager)DataManager.getIfExists(((com.ebay.nautilus.kernel.content.EbayContext) (obj)), new rams(destFolderId.longValue()));
                if (obj != null)
                {
                    ((MessageFolderContentsDataManager) (obj)).informError(resultstatus);
                }
                ((mError)MessageContentsDataManager.access$900(MessageContentsDataManager.this)).MoveMessageCompleted(MessageContentsDataManager.this, ((Content) (obj1)), sourceFolderId.longValue());
            }
            if (isRead != null || isFlagged != null)
            {
                ((isFlagged)MessageContentsDataManager.access$1000(MessageContentsDataManager.this)).MessageContentsChanged(MessageContentsDataManager.this, ((Content) (obj1)));
            }
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public rams(EbayMessage ebaymessage, Boolean boolean1, Boolean boolean2)
    {
        this$0 = MessageContentsDataManager.this;
        super(MessageContentsDataManager.this, ebaymessage, null, null, boolean1, boolean2);
    }

    public (EbayMessage ebaymessage, Long long1, Long long2)
    {
        this$0 = MessageContentsDataManager.this;
        super(MessageContentsDataManager.this, ebaymessage, long1, long2, null, null);
    }
}
