// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.categorybrowser;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearSmoothScroller;

// Referenced classes of package com.ebay.mobile.categorybrowser:
//            TopLevelCategoriesAdapter

private class this._cls0 extends LinearSmoothScroller
{

    final this._cls0 this$0;

    public PointF computeScrollVectorForPosition(int i)
    {
        return this._mth0(this._cls0.this, i);
    }

    protected int getVerticalSnapPreference()
    {
        return -1;
    }

    public (Context context)
    {
        this$0 = this._cls0.this;
        super(context);
    }
}
