// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.text.TextUtils;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.kernel.content.ResultStatus;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MessageContentsDataManager

private final class ase extends ase
{

    final MessageContentsDataManager this$0;

    protected void onPostExecute(ResultStatus resultstatus)
    {
        super.onPostExecute(resultstatus);
        MessageContentsDataManager.access$002(MessageContentsDataManager.this, null);
        if (resultstatus.hasError() && (contentData == null || TextUtils.isEmpty(((EbayMessage)contentData).text)))
        {
            ((this._cls0)MessageContentsDataManager.access$100(MessageContentsDataManager.this)).ssageContentsChanged(MessageContentsDataManager.this, new Content(contentData, resultstatus));
        } else
        {
            if (!resultstatus.hasError())
            {
                setContent(getOutMessage(), resultstatus);
            }
            ((getOutMessage)MessageContentsDataManager.access$200(MessageContentsDataManager.this)).ssageContentsChanged(MessageContentsDataManager.this, getContent());
        }
        if (MessageContentsDataManager.access$300(MessageContentsDataManager.this) == null && MessageContentsDataManager.access$400(MessageContentsDataManager.this) == null && contentData != null && ((EbayMessage)contentData).itemId != -1L)
        {
            MessageContentsDataManager.access$302(MessageContentsDataManager.this, new <init>(MessageContentsDataManager.this, (EbayMessage)contentData));
            DataManager.executeOnThreadPool(MessageContentsDataManager.access$300(MessageContentsDataManager.this), new Void[0]);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((ResultStatus)obj);
    }

    public ase(EbayMessage ebaymessage)
    {
        this$0 = MessageContentsDataManager.this;
        super(MessageContentsDataManager.this, null, ebaymessage);
    }
}
