// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageFolderContentsDataManager, MessageFoldersDataManager

private final class > extends >
{

    final MessageFolderContentsDataManager this$0;

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.tExecute(resultstatus);
        if (resultstatus.hasError())
        {
            MessageFoldersDataManager messagefoldersdatamanager = (MessageFoldersDataManager)DataManager.getIfExists(getEbayContext(), MessageFoldersDataManager.KEY);
            if (messagefoldersdatamanager != null)
            {
                messagefoldersdatamanager.informError(resultstatus);
            }
            resultstatus = new Content(getMessages(), resultstatus);
            ((getMessages)MessageFolderContentsDataManager.access$500(MessageFolderContentsDataManager.this)).MessageFolderContentsRemoved(MessageFolderContentsDataManager.this, resultstatus);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public (List list)
    {
        this$0 = MessageFolderContentsDataManager.this;
        super(MessageFolderContentsDataManager.this, list);
    }
}
