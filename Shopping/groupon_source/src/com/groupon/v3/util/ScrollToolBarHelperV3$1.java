// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.util;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.v3.util:
//            ScrollToolBarHelperV3

class this._cls0
    implements android.view.lLayoutListener
{

    final ScrollToolBarHelperV3 this$0;

    public void onGlobalLayout()
    {
        ScrollToolBarHelperV3.access$200(ScrollToolBarHelperV3.this).setY(ScrollToolBarHelperV3.access$000(ScrollToolBarHelperV3.this).getY() + (float)ScrollToolBarHelperV3.access$000(ScrollToolBarHelperV3.this).getHeight() + (float)ScrollToolBarHelperV3.access$100(ScrollToolBarHelperV3.this).getHeight());
        ScrollToolBarHelperV3.access$200(ScrollToolBarHelperV3.this).setPadding(0, 0, 0, ScrollToolBarHelperV3.access$100(ScrollToolBarHelperV3.this).getHeight());
        ScrollToolBarHelperV3.access$200(ScrollToolBarHelperV3.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    Listener()
    {
        this$0 = ScrollToolBarHelperV3.this;
        super();
    }
}
