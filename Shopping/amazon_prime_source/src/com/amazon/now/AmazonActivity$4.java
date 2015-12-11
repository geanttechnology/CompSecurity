// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.view.View;
import com.amazon.now.nav.NowSlidingPaneLayout;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.now:
//            AmazonActivity

class eLayout
    implements android.view.ner
{

    final AmazonActivity this$0;
    final NowSlidingPaneLayout val$layout;

    public void onClick(View view)
    {
        UIUtils.closeSoftKeyboard(view);
        if (val$layout.isOpen())
        {
            val$layout.closePane();
            return;
        } else
        {
            val$layout.openPane();
            return;
        }
    }

    eLayout()
    {
        this$0 = final_amazonactivity;
        val$layout = NowSlidingPaneLayout.this;
        super();
    }
}
