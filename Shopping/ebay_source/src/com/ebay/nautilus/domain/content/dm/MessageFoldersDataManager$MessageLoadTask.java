// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Collections;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageFoldersDataManager

private final class e extends e
{

    final MessageFoldersDataManager this$0;

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        MessageFoldersDataManager.access$002(MessageFoldersDataManager.this, null);
        if (!resultstatus.hasError())
        {
            setContent(Collections.unmodifiableList(getOutFolders()), resultstatus);
        }
        ((getOutFolders)MessageFoldersDataManager.access$100(MessageFoldersDataManager.this)).geFoldersListChanged(MessageFoldersDataManager.this, getContent());
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public e()
    {
        this$0 = MessageFoldersDataManager.this;
        super(MessageFoldersDataManager.this, null, null);
    }
}
