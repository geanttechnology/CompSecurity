// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import ajg;
import akw;
import ams;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.List;

public class FontColorSelcView extends FrameLayout
{

    String TAG;
    int colorAreaWidth;
    List colorItems;
    int itemHeight;
    int itemWidth;
    FrameLayout layout_color_container;
    ajg listener;

    public FontColorSelcView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "ColorSelectView";
        itemWidth = 0;
        itemHeight = 0;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300fd, this, true);
        layout_color_container = (FrameLayout)findViewById(0x7f0d03ab);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f = -1F;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 36
    //                   0 339
    //                   1 36
    //                   2 362;
           goto _L1 _L2 _L1 _L3
_L1:
        float f1 = -1F;
_L5:
        int l = layout_color_container.getLeft();
        int k = layout_color_container.getRight();
        int i1 = layout_color_container.getTop();
        int j1 = layout_color_container.getBottom();
        boolean flag1 = false;
        boolean flag = flag1;
        if (f1 >= (float)l)
        {
            flag = flag1;
            if (f1 <= (float)k)
            {
                flag = flag1;
                if (f >= (float)i1)
                {
                    flag = flag1;
                    if (f <= (float)j1)
                    {
                        flag = true;
                    }
                }
            }
        }
        if (f1 >= 0.0F && flag)
        {
            Log.v(TAG, String.valueOf(f1));
            if (colorItems.size() != 0)
            {
                int i = (int)(f1 / (float)itemWidth);
                int j = (int)(f / (float)itemHeight) * 16 + i;
                Log.v(TAG, (new StringBuilder()).append("pos = ").append(String.valueOf(j)).toString());
                i = j;
                if (j >= colorItems.size())
                {
                    j -= (int)((float)k - f1) / itemWidth;
                    i = j;
                    if (j >= colorItems.size())
                    {
                        i = colorItems.size() - 1;
                    }
                }
                if (i < colorItems.size())
                {
                    i = ((ams)colorItems.get(i)).a();
                    if (listener != null)
                    {
                        listener.a(i);
                    }
                }
            }
        }
        return true;
_L2:
        Log.v(TAG, "ACTION_DOWN");
        f1 = motionevent.getX();
        f = motionevent.getY();
        continue; /* Loop/switch isn't completed */
_L3:
        Log.v(TAG, "ACTION_MOVE");
        f1 = motionevent.getX();
        f = motionevent.getY();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setMaxWeidth(int i, int j)
    {
        layout_color_container.removeAllViews();
        colorItems = akw.a().a;
        itemWidth = (int)((float)i / 16F);
        itemHeight = (int)((float)j / 4F);
        android.view.ViewGroup.LayoutParams layoutparams = getLayoutParams();
        layoutparams.width = i;
        layoutparams.height = j;
        requestLayout();
        j = 0;
        int k = 0;
        i = 0;
        while (j < colorItems.size()) 
        {
            Object obj = (ams)colorItems.get(j);
            FrameLayout framelayout = new FrameLayout(getContext(), null);
            framelayout.setBackgroundColor(((ams) (obj)).a());
            obj = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
            int l;
            int i1;
            if (obj == null)
            {
                obj = new android.widget.FrameLayout.LayoutParams(-1, -1);
                obj.gravity = 51;
                obj.width = itemWidth;
                obj.height = itemHeight;
                obj.topMargin = k;
                obj.leftMargin = i;
                framelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj.width = itemWidth;
                obj.height = itemHeight;
                obj.topMargin = k;
                obj.leftMargin = i;
            }
            layout_color_container.addView(framelayout);
            framelayout.requestLayout();
            i1 = i + itemWidth;
            l = k;
            i = i1;
            if (i1 >= itemWidth * 16)
            {
                l = k + itemHeight;
                i = 0;
            }
            j++;
            k = l;
        }
    }

    public void setOnColorSelectorListener(ajg ajg1)
    {
        listener = ajg1;
    }
}
