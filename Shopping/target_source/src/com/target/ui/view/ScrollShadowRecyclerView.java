// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.target.ui.view.a.a;

public class ScrollShadowRecyclerView extends RecyclerView
{

    private a mScrollShadowDelegate;

    public ScrollShadowRecyclerView(Context context)
    {
        super(context);
        r();
    }

    public ScrollShadowRecyclerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        r();
    }

    public ScrollShadowRecyclerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        r();
    }

    private void r()
    {
        mScrollShadowDelegate = new a(this, getContext());
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        mScrollShadowDelegate.a(canvas, getTopFadingEdgeStrength());
    }

    protected float getTopFadingEdgeStrength()
    {
        int i = getChildCount();
        float f = super.getTopFadingEdgeStrength();
        if (i != 0)
        {
            View view = getChildAt(0);
            if (d(view) > 0)
            {
                return 1.0F;
            }
            int j = view.getTop();
            float f1 = getVerticalFadingEdgeLength();
            if (j < getPaddingTop())
            {
                return (float)(-(j - getPaddingTop())) / f1;
            }
        }
        return f;
    }

    public int getVerticalFadingEdgeLength()
    {
        return mScrollShadowDelegate.a();
    }
}
