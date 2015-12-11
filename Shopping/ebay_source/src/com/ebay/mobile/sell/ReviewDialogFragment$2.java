// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.view.View;
import android.widget.CheckedTextView;
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
        autoRelistCheckedText.setLines(autoRelistCheckedText.getLineCount());
        if (ReviewDialogFragment.access$000(ReviewDialogFragment.this))
        {
            autoRelistLearnMore.setVisibility(8);
            return;
        } else
        {
            autoRelistDetailsContainer.setVisibility(8);
            return;
        }
    }

    ()
    {
        this$0 = ReviewDialogFragment.this;
        super();
    }
}
