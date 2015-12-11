// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.util:
//            ScrollToolBarHelper

class val.fragment
    implements android.view.balLayoutListener
{

    final ScrollToolBarHelper this$0;
    final Fragment val$fragment;

    public void onGlobalLayout()
    {
        ScrollToolBarHelper.access$200(ScrollToolBarHelper.this).setY(ScrollToolBarHelper.access$000(ScrollToolBarHelper.this).getY() + (float)ScrollToolBarHelper.access$000(ScrollToolBarHelper.this).getHeight() + (float)ScrollToolBarHelper.access$100(ScrollToolBarHelper.this).getHeight());
        ScrollToolBarHelper.access$200(ScrollToolBarHelper.this).setPadding(0, 0, 0, ScrollToolBarHelper.access$100(ScrollToolBarHelper.this).getHeight());
        if (val$fragment instanceof ToolBarInitializeListener)
        {
            ((ToolBarInitializeListener)val$fragment).onToolBarInitialized();
        }
        ScrollToolBarHelper.access$200(ScrollToolBarHelper.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    ToolBarInitializeListener()
    {
        this$0 = final_scrolltoolbarhelper;
        val$fragment = Fragment.this;
        super();
    }
}
