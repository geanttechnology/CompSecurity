// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.shareinstagram;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.List;
import og;
import oh;
import oi;

public class ColorScrollView extends FrameLayout
{

    int colorAreaWidth;
    FrameLayout colorContainer;
    List colorItems;
    int itemWidth;
    int lineHeight;
    private oh lisener;
    int mLineCount;
    int maxPerLineCount;

    public ColorScrollView(Context context)
    {
        super(context);
        mLineCount = 1;
        itemWidth = 0;
        maxPerLineCount = 0;
        lineHeight = 0;
        initView(context);
    }

    public ColorScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mLineCount = 1;
        itemWidth = 0;
        maxPerLineCount = 0;
        lineHeight = 0;
        initView(context);
    }

    public ColorScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mLineCount = 1;
        itemWidth = 0;
        maxPerLineCount = 0;
        lineHeight = 0;
        initView(context);
    }

    private void initView(Context context)
    {
        ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(com.fotoable.fotoadpackage.R.layout.view_color_scroll, this, true);
        colorContainer = (FrameLayout)findViewById(com.fotoable.fotoadpackage.R.id.layout_color_container);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f1 = -1F;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 317
    //                   1 373
    //                   2 360;
           goto _L1 _L2 _L3 _L4
_L1:
        if (lisener != null)
        {
            lisener.b();
        }
_L8:
        float f = -1F;
_L6:
        int l = colorContainer.getLeft();
        int k = colorContainer.getRight();
        int i1 = colorContainer.getTop();
        int j1 = colorContainer.getBottom();
        boolean flag1 = false;
        boolean flag = flag1;
        if (f >= (float)l)
        {
            flag = flag1;
            if (f <= (float)k)
            {
                flag = flag1;
                if (f1 >= (float)i1)
                {
                    flag = flag1;
                    if (f1 <= (float)j1)
                    {
                        flag = true;
                    }
                }
            }
        }
        if (f >= 0.0F && flag && colorItems.size() != 0)
        {
            int i = (int)f1 / lineHeight;
            int j = (int)(f / (float)itemWidth);
            j = i * maxPerLineCount + j;
            i = j;
            if (j >= colorItems.size())
            {
                j -= (int)((float)k - f) / itemWidth;
                i = j;
                if (j >= colorItems.size())
                {
                    i = colorItems.size() - 1;
                }
            }
            if (i < colorItems.size())
            {
                i = ((og)colorItems.get(i)).a();
                if (lisener != null)
                {
                    lisener.a(i);
                }
            }
        }
        return true;
_L2:
        float f2 = motionevent.getX();
        float f3 = motionevent.getY();
        f1 = f3;
        f = f2;
        if (lisener != null)
        {
            lisener.a();
            f1 = f3;
            f = f2;
        }
        break; /* Loop/switch isn't completed */
_L4:
        f = motionevent.getX();
        f1 = motionevent.getY();
        break; /* Loop/switch isn't completed */
_L3:
        if (lisener == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        lisener.b();
        f = -1F;
        if (true) goto _L6; else goto _L5
_L5:
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void setMaxSizeWithMultyLine(int i, int j, int k)
    {
        colorContainer.removeAllViews();
        mLineCount = i;
        colorItems = oi.a();
        lineHeight = k / mLineCount;
        maxPerLineCount = colorItems.size() / mLineCount;
        if (colorItems.size() % mLineCount != 0)
        {
            maxPerLineCount = maxPerLineCount + 1;
        }
        itemWidth = (int)((float)j / (float)maxPerLineCount);
        colorAreaWidth = itemWidth * maxPerLineCount;
        getLayoutParams();
        i = 0;
        while (i < colorItems.size()) 
        {
            j = i / maxPerLineCount;
            Object obj = (og)colorItems.get(i);
            FrameLayout framelayout = new FrameLayout(getContext());
            framelayout.setBackgroundColor(((og) (obj)).a());
            obj = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
            if (obj == null)
            {
                obj = new android.widget.FrameLayout.LayoutParams(itemWidth, lineHeight, 51);
                obj.width = itemWidth;
                obj.height = lineHeight;
                obj.leftMargin = (i % maxPerLineCount) * itemWidth;
                obj.topMargin = j * lineHeight;
                framelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj.gravity = 51;
                obj.width = itemWidth;
                obj.height = lineHeight;
                obj.leftMargin = (i % maxPerLineCount) * itemWidth;
                obj.topMargin = j * lineHeight;
            }
            colorContainer.addView(framelayout);
            framelayout.requestLayout();
            i++;
        }
        requestLayout();
    }

    public void setOnMultyColorSelectorLisener(oh oh1)
    {
        lisener = oh1;
    }
}
