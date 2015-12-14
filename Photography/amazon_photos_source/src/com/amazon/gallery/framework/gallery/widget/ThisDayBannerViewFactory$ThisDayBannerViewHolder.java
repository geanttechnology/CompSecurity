// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.amazon.gallery.thor.widget.RibbonMarkerView;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ThisDayBannerViewFactory

static class ribbonView extends android.support.v7.widget.yBannerViewHolder
{

    LinearLayout photosContainer;
    ProgressBar progressBar;
    RibbonMarkerView ribbonView;

    public (View view)
    {
        super(view);
        photosContainer = (LinearLayout)view.findViewById(0x7f0c01f1);
        progressBar = (ProgressBar)view.findViewById(0x7f0c01f0);
        ribbonView = (RibbonMarkerView)view.findViewById(0x7f0c01f2);
    }
}
