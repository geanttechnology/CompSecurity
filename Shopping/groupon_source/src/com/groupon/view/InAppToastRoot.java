// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

// Referenced classes of package com.groupon.view:
//            InAppToast

public class InAppToastRoot extends FrameLayout
{

    private InAppToast toast;

    public InAppToastRoot(Context context)
    {
        super(context);
    }

    public InAppToastRoot(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public InAppToastRoot(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (toast != null)
        {
            toast.refreshIfNeeded(500);
        }
    }

    public void setToast(InAppToast inapptoast)
    {
        toast = inapptoast;
    }
}
