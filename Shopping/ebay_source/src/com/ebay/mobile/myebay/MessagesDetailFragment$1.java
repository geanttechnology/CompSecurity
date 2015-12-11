// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.View;

// Referenced classes of package com.ebay.mobile.myebay:
//            MessagesDetailFragment

class this._cls0
    implements android.view.ragment._cls1
{

    final MessagesDetailFragment this$0;

    public void onClick(View view)
    {
        notifyPaneActivated(vePane.MESSAGES_DETAIL);
    }

    vePane()
    {
        this$0 = MessagesDetailFragment.this;
        super();
    }
}
