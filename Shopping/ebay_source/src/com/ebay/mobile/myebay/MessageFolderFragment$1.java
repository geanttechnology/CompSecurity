// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.text.style.ClickableSpan;
import android.view.View;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessageFolderFragment, MessagesFilterType

class this._cls0 extends ClickableSpan
{

    final MessageFolderFragment this$0;

    public void onClick(View view)
    {
        MessageFolderFragment.access$000(MessageFolderFragment.this).setFilterType(MessagesFilterType.FILTER_ALL);
        notifyFilterTypeChanged(MessagesFilterType.FILTER_ALL);
    }

    ssageFolderListAdapter()
    {
        this$0 = MessageFolderFragment.this;
        super();
    }
}
