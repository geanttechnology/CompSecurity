// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.target.ui.view.a.a;

public class ScrollShadowScrollView extends ScrollView
{

    private a mScrollShadowDelegate;

    public ScrollShadowScrollView(Context context)
    {
        super(context);
        a();
    }

    public ScrollShadowScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ScrollShadowScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        mScrollShadowDelegate = new a(this, getContext());
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas);
        mScrollShadowDelegate.a(canvas, getTopFadingEdgeStrength());
    }

    public int getVerticalFadingEdgeLength()
    {
        return mScrollShadowDelegate.a();
    }
}
