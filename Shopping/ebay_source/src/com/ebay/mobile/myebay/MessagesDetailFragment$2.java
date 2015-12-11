// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import com.ebay.nautilus.domain.data.EbayMessage;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesDetailFragment

class lastPageSelection extends android.support.v4.view.ngeListener
{

    private int lastPageSelection;
    final MessagesDetailFragment this$0;

    public void onPageSelected(int i)
    {
        int j = lastPageSelection;
        lastPageSelection = i;
        if (!MessagesDetailFragment.access$100(MessagesDetailFragment.this).equals(MessagesDetailFragment.access$000(MessagesDetailFragment.this).get(i)) && -1 == MessagesDetailFragment.access$200(MessagesDetailFragment.this))
        {
            notifyPaneActivated(vePane.MESSAGES_DETAIL);
            MessagesDetailFragment.access$300(MessagesDetailFragment.this, j, i);
        }
        MessagesDetailFragment.access$402(MessagesDetailFragment.this, false);
        MessagesDetailFragment.access$502(MessagesDetailFragment.this, null);
    }

    vePane()
    {
        this$0 = MessagesDetailFragment.this;
        super();
        lastPageSelection = -1;
    }
}
