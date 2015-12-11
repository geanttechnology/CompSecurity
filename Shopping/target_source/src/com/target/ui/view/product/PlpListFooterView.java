// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

// Referenced classes of package com.target.ui.view.product:
//            PlpFooterView

public class PlpListFooterView extends PlpFooterView
{

    public PlpListFooterView(Context context)
    {
        super(context);
    }

    public PlpListFooterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PlpListFooterView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected int getBackgroundColor()
    {
        return getResources().getColor(0x7f0f0036);
    }
}
