// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.widget.FrameLayout;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            HeaderGridView

private class this._cls0 extends FrameLayout
{

    final HeaderGridView this$0;

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(android.view.GridView.FullWidthFixedViewLayout(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), android.view.GridView.getPaddingRight(i)), j);
    }

    public (Context context)
    {
        this$0 = HeaderGridView.this;
        super(context);
    }
}
