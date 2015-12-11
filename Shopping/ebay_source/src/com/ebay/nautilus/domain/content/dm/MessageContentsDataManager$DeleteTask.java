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
            Object obj = getEbayContext();
            MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(((com.ebay.nautilus.kernel.content.EbayContext) (obj)), MessageFoldersDataManager.KEY);
            if (messagefoldersdatamanager != null)
            {
                messagefoldersdatamanager.informError(resultstatus);
            }
            obj = (MessageFolderContentsDataManager)DataManager.getIfExists(((com.ebay.nautilus.kernel.content.EbayContext) (obj)), MessageContentsDataManager.access$800(MessageContentsDataManager.this));
            if (obj != null)
            {
                ((MessageFolderContentsDataManager) (obj)).informError(resultstatus);
            }
            resultstatus = new Content(getMessage(), resultstatus);
            ((getMessage)MessageContentsDataManager.access$1100(MessageContentsDataManager.this)).DeleteMessageCompleted(MessageContentsDataManager.this, resultstatus);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public (EbayMessage ebaymessage)
    {
        this$0 = MessageContentsDataManager.this;
        super(MessageContentsDataManager.this, ebaymessage);
    }
}
