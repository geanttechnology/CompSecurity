// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SlidingDrawer;

public class WrappingSlidingDrawer extends SlidingDrawer
{

    private boolean a;
    private int b;

    public WrappingSlidingDrawer(Context context, AttributeSet attributeset)
    {
        boolean flag = true;
        super(context, attributeset);
        int i = attributeset.getAttributeIntValue("android", "orientation", 1);
        b = attributeset.getAttributeIntValue("android", "topOffset", 0);
        if (i != 1)
        {
            flag = false;
        }
        a = flag;
    }

    public WrappingSlidingDrawer(Context context, AttributeSet attributeset, int i)
    {
        boolean flag = true;
        super(context, attributeset, i);
        i = attributeset.getAttributeIntValue("android", "orientation", 1);
        b = attributeset.getAttributeIntValue("android", "topOffset", 0);
        if (i != 1)
        {
            flag = false;
        }
        a = flag;
    }

    protected void onMeasure(int i, int j)
    {
        View view;
        View view1;
        int k;
        int l;
        int i1;
        int k1;
        k = android.view.View.MeasureSpec.getMode(i);
        l = android.view.View.MeasureSpec.getSize(i);
        i1 = android.view.View.MeasureSpec.getMode(j);
        k1 = android.view.View.MeasureSpec.getSize(j);
        if (k == 0 || i1 == 0)
        {
            throw new RuntimeException("WrappingSlidingDrawer cannot have UNSPECIFIED dimensions");
        }
        view = getHandle();
        view1 = getContent();
        measureChild(view, i, j);
        if (!a) goto _L2; else goto _L1
_L1:
        view1.measure(i, android.view.View.MeasureSpec.makeMeasureSpec(k1 - view.getMeasuredHeight() - b, i1));
        k = view.getMeasuredHeight();
        l = b;
        i1 = view1.getMeasuredHeight();
        j = view1.getMeasuredWidth();
        i = j;
        if (view.getMeasuredWidth() > j)
        {
            i = view.getMeasuredWidth();
        }
        k = i1 + (k + l);
        j = i;
        i = k;
_L4:
        setMeasuredDimension(j, i);
        return;
_L2:
        i = view.getMeasuredWidth();
        int j1 = b;
        getContent().measure(android.view.View.MeasureSpec.makeMeasureSpec(l - i - j1, k), j);
        i = view.getMeasuredWidth();
        j = b;
        k = view1.getMeasuredWidth() + (i + j);
        l = view1.getMeasuredHeight();
        i = l;
        j = k;
        if (view.getMeasuredHeight() > l)
        {
            i = view.getMeasuredHeight();
            j = k;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
