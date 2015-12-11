// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageFolderContentsDataManager

private final class > extends >
{

    final MessageFolderContentsDataManager this$0;

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.tExecute(resultstatus);
        MessageFolderContentsDataManager.access$002(MessageFolderContentsDataManager.this, null);
        if (!resultstatus.hasError())
        {
            setContent(getOutMessages(), resultstatus);
        }
        ((getOutMessages)MessageFolderContentsDataManager.access$100(MessageFolderContentsDataManager.this)).geFolderContentsLoaded(MessageFolderContentsDataManager.this, getContent());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public (long l)
    {
        this$0 = MessageFolderContentsDataManager.this;
        super(MessageFolderContentsDataManager.this, Long.valueOf(l), null);
    }
}
