// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;

// Referenced classes of package com.target.ui.view:
//            BadgeView

public class DealsBadgeView extends BadgeView
{

    public DealsBadgeView(Context context)
    {
        super(context);
    }

    public DealsBadgeView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public DealsBadgeView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public String getBadgeContentDescription()
    {
        return getResources().getString(0x7f09018b);
    }

    public int getForegroundDrawable()
    {
        return 0x7f020183;
    }

    public String getTextOverlay()
    {
        return null;
    }
}
