// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout.widget;

import android.view.View;
import android.widget.HorizontalScrollView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results.layout.widget:
//            BrandstripWidget

class val.view
    implements android.view.GlobalLayoutListener
{

    final BrandstripWidget this$0;
    final View val$view;

    public void onGlobalLayout()
    {
        val$view.getLocationOnScreen(BrandstripWidget.access$000(BrandstripWidget.this));
        BrandstripWidget.access$100(BrandstripWidget.this).scrollTo(BrandstripWidget.access$100(BrandstripWidget.this).getScrollX() + BrandstripWidget.access$000(BrandstripWidget.this)[0], 0);
    }

    Q()
    {
        this$0 = final_brandstripwidget;
        val$view = View.this;
        super();
    }
}
