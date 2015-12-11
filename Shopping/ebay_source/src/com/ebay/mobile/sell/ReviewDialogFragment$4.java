// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.widget.CheckedTextView;

// Referenced classes of package com.ebay.mobile.sell:
//            ReviewDialogFragment

class this._cls0
    implements Runnable
{

    final ReviewDialogFragment this$0;

    public void run()
    {
        autoRelistCheckedText.setLines(autoRelistCheckedText.getLineCount());
    }

    ()
    {
        this$0 = ReviewDialogFragment.this;
        super();
    }
}
