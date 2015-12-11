// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.sell:
//            ReviewDialogFragment

class this._cls0
    implements Runnable
{

    final ReviewDialogFragment this$0;

    public void run()
    {
        autoRelistDetails.setLines(autoRelistDetails.getLineCount());
        autoRelistLearnMore.setLines(autoRelistLearnMore.getLineCount());
        autoRelistDetailsContainer.setVisibility(8);
    }

    ()
    {
        this$0 = ReviewDialogFragment.this;
        super();
    }
}
