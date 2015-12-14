// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common:
//            aj

public class OnSizeChangedFrameLayout extends FrameLayout
{

    private aj a;

    public OnSizeChangedFrameLayout(Context context)
    {
        super(context);
    }

    public OnSizeChangedFrameLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public OnSizeChangedFrameLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onSizeChanged(int i, int j, int k, int l)
    {
        super.onSizeChanged(i, j, k, l);
        if (a != null)
        {
            a.a(i, j, k, l);
        }
    }

    public void setOnSizeChangedListener(aj aj1)
    {
        a = aj1;
    }
}
