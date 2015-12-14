// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package in.srain.cube.views;

import android.content.Context;
import android.widget.FrameLayout;

// Referenced classes of package in.srain.cube.views:
//            GridViewWithHeaderAndFooter

private class this._cls0 extends FrameLayout
{

    final GridViewWithHeaderAndFooter this$0;

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        int i1 = getPaddingLeft() + getPaddingLeft();
        if (i1 != i)
        {
            offsetLeftAndRight(i1 - i);
        }
        super.onLayout(flag, i, j, k, l);
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(android.view.Layout(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), android.view.Layout(i)), j);
    }

    public (Context context)
    {
        this$0 = GridViewWithHeaderAndFooter.this;
        super(context);
    }
}
