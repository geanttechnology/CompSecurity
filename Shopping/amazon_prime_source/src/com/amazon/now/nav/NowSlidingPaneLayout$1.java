// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.nav;

import android.view.View;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.now.nav:
//            NowSlidingPaneLayout

class this._cls0
    implements android.support.v4.widget.SlideListener
{

    final NowSlidingPaneLayout this$0;

    public void onPanelClosed(View view)
    {
        if (!NowSlidingPaneLayout.access$000(NowSlidingPaneLayout.this))
        {
            return;
        } else
        {
            NowSlidingPaneLayout.access$002(NowSlidingPaneLayout.this, false);
            return;
        }
    }

    public void onPanelOpened(View view)
    {
        UIUtils.closeSoftKeyboard(view);
    }

    public void onPanelSlide(View view, float f)
    {
        if (NowSlidingPaneLayout.access$000(NowSlidingPaneLayout.this))
        {
            return;
        } else
        {
            NowSlidingPaneLayout.access$002(NowSlidingPaneLayout.this, true);
            return;
        }
    }

    ()
    {
        this$0 = NowSlidingPaneLayout.this;
        super();
    }
}
