// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import com.amazon.mShop.control.history.HistoryBrowser;
import com.amazon.mShop.platform.Platform;

// Referenced classes of package com.amazon.mShop.history:
//            HistoryView

class this._cls0
    implements com.amazon.mShop.error..AmazonErrorBoxActionListener
{

    final HistoryView this$0;

    public void onActionButtonClick(int i)
    {
        com.amazon.mShop.platform.ry.getInstance().invokeLater(new Runnable() {

            final HistoryView._cls3 this$1;

            public void run()
            {
                HistoryView.access$400(this$0);
                HistoryView.access$300(this$0).replayPageRequest();
            }

            
            {
                this$1 = HistoryView._cls3.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = HistoryView.this;
        super();
    }
}
