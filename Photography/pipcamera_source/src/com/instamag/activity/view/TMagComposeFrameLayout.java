// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

// Referenced classes of package com.instamag.activity.view:
//            TDecorateInfosLayerView

public class TMagComposeFrameLayout extends FrameLayout
{

    private TDecorateInfosLayerView decView;
    private boolean isTracking;

    public TMagComposeFrameLayout(Context context)
    {
        super(context);
    }

    public TMagComposeFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }
}
