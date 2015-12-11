// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.view.product:
//            PlpHeaderView

static class rootContainer extends a
{

    AisleBadgeView aisle;
    TargetErrorView errorContainer;
    TextView find;
    TextView inStore;
    View rootContainer;
    View storeLocationHeader;

    public (View view)
    {
        super(view);
        rootContainer = view;
    }
}
