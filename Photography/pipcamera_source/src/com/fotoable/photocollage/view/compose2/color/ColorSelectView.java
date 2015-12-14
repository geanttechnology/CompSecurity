// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.photocollage.view.compose2.color;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import ew;
import java.util.ArrayList;
import java.util.List;
import ml;
import mm;

public class ColorSelectView extends FrameLayout
{

    String TAG;
    int colorAreaWidth;
    List colorItems;
    View indicate_color;
    int itemWidth;
    FrameLayout layout_color_container;
    View layout_color_indi;
    int lineHeight;
    mm listener;
    int mLineCount;
    int maxPerLineCount;

    public ColorSelectView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        TAG = "ColorSelectView";
        itemWidth = 0;
        mLineCount = 1;
        maxPerLineCount = 0;
        lineHeight = 0;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300a1, this, true);
        layout_color_container = (FrameLayout)findViewById(0x7f0c0280);
        indicate_color = findViewById(0x7f0c0282);
        layout_color_indi = findViewById(0x7f0c0281);
        layout_color_indi.setVisibility(4);
    }

    public ml colorItemInstance(String s, int i, String s1)
    {
        s1 = new ml();
        s1.a(s);
        s1.a(i);
        return s1;
    }

    protected List getColorList()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(colorItemInstance("1", -1, ""));
        arraylist.add(colorItemInstance("2", 0xffe5e5e7, ""));
        arraylist.add(colorItemInstance("3", 0xffc1c6ca, ""));
        arraylist.add(colorItemInstance("4", 0xff9da1a4, ""));
        arraylist.add(colorItemInstance("5", 0xff000000, ""));
        arraylist.add(colorItemInstance("6", 0xffd3ccc6, ""));
        arraylist.add(colorItemInstance("7", 0xffb3adac, ""));
        arraylist.add(colorItemInstance("8", 0xffa68f87, ""));
        arraylist.add(colorItemInstance("9", 0xff928179, ""));
        arraylist.add(colorItemInstance("10", 0xffb38c6f, ""));
        arraylist.add(colorItemInstance("11", 0xff6f4b3d, ""));
        arraylist.add(colorItemInstance("12", 0xffe5e6fa, ""));
        arraylist.add(colorItemInstance("13", 0xffd0c0d7, ""));
        arraylist.add(colorItemInstance("14", 0xffcca6bf, ""));
        arraylist.add(colorItemInstance("15", 0xffa69abe, ""));
        arraylist.add(colorItemInstance("16", 0xffa37bb8, ""));
        arraylist.add(colorItemInstance("17", 0xffcd77fe, ""));
        arraylist.add(colorItemInstance("18", 0xffbc54ef, ""));
        arraylist.add(colorItemInstance("19", 0xff986ef2, ""));
        arraylist.add(colorItemInstance("20", 0xffebf7f7, ""));
        arraylist.add(colorItemInstance("21", 0xffc1e4e8, ""));
        arraylist.add(colorItemInstance("22", 0xffa7eee6, ""));
        arraylist.add(colorItemInstance("23", 0xffa0d8ef, ""));
        arraylist.add(colorItemInstance("24", 0xff84a2d4, ""));
        arraylist.add(colorItemInstance("25", 0xff27caff, ""));
        arraylist.add(colorItemInstance("26", 0xff1673ff, ""));
        arraylist.add(colorItemInstance("27", 0xff1d50a3, ""));
        arraylist.add(colorItemInstance("28", 0xffe0ebaf, ""));
        arraylist.add(colorItemInstance("29", 0xffc8dc69, ""));
        arraylist.add(colorItemInstance("30", 0xffabcf53, ""));
        arraylist.add(colorItemInstance("31", 0xff93ca76, ""));
        arraylist.add(colorItemInstance("32", 0xff19d2b2, ""));
        arraylist.add(colorItemInstance("33", 0xff00a597, ""));
        arraylist.add(colorItemInstance("34", 0xff00a381, ""));
        arraylist.add(colorItemInstance("35", 0xff006e55, ""));
        arraylist.add(colorItemInstance("36", 0xfff2f3b1, ""));
        arraylist.add(colorItemInstance("37", 0xfff9e58c, ""));
        arraylist.add(colorItemInstance("38", 0xfffcd675, ""));
        arraylist.add(colorItemInstance("39", 0xfff6b978, ""));
        arraylist.add(colorItemInstance("40", 0xfff6ac94, ""));
        arraylist.add(colorItemInstance("41", 0xfffc9314, ""));
        arraylist.add(colorItemInstance("42", 0xffef7800, ""));
        arraylist.add(colorItemInstance("43", 0xffed6801, ""));
        arraylist.add(colorItemInstance("44", 0xffeb5606, ""));
        arraylist.add(colorItemInstance("45", 0xfff7511a, ""));
        arraylist.add(colorItemInstance("46", -5375, ""));
        arraylist.add(colorItemInstance("47", -9984, ""));
        arraylist.add(colorItemInstance("48", 0xfff7b500, ""));
        arraylist.add(colorItemInstance("49", 0xffe0aa12, ""));
        arraylist.add(colorItemInstance("50", 0xfffeeff2, ""));
        arraylist.add(colorItemInstance("51", 0xfff7d5d3, ""));
        arraylist.add(colorItemInstance("52", 0xfff8beba, ""));
        arraylist.add(colorItemInstance("53", 0xfff2a0a2, ""));
        arraylist.add(colorItemInstance("54", 0xffe597b1, ""));
        arraylist.add(colorItemInstance("55", 0xffef827d, ""));
        arraylist.add(colorItemInstance("56", 0xffeb6d71, ""));
        arraylist.add(colorItemInstance("57", 0xffeb6fa5, ""));
        arraylist.add(colorItemInstance("58", 0xffe95295, ""));
        arraylist.add(colorItemInstance("59", 0xfffe4f88, ""));
        arraylist.add(colorItemInstance("60", 0xffe85464, ""));
        arraylist.add(colorItemInstance("61", 0xffe80030, ""));
        arraylist.add(colorItemInstance("62", 0xffff0000, ""));
        arraylist.add(colorItemInstance("63", 0xffa52141, ""));
        arraylist.add(colorItemInstance("64", 0xffb90000, ""));
        return arraylist;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f1;
        int j;
        f1 = -1F;
        j = 0;
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 367
    //                   1 437
    //                   2 410;
           goto _L1 _L2 _L3 _L4
_L1:
        float f;
        boolean flag;
        if (listener != null)
        {
            listener.TouchEnd();
        }
        f = -1F;
        flag = false;
_L6:
        int i = layout_color_container.getLeft();
        int k = layout_color_container.getRight();
        int l = layout_color_container.getTop();
        int i1 = layout_color_container.getBottom();
        if (f >= (float)i && f <= (float)k && f1 >= (float)l && f1 <= (float)i1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (f >= 0.0F && i != 0)
        {
            Log.v(TAG, String.valueOf(f));
            if (colorItems.size() != 0)
            {
                i = j;
                if (f1 > (float)lineHeight)
                {
                    i = 1;
                }
                j = (int)(f / (float)itemWidth) + i * maxPerLineCount;
                Log.v(TAG, (new StringBuilder()).append("pos = ").append(String.valueOf(j)).toString());
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
                    i = ((ml)colorItems.get(i)).a();
                    if (listener != null)
                    {
                        listener.onColorSelector(i);
                    }
                }
            }
        }
        if (flag)
        {
            layout_color_indi.setVisibility(4);
        }
        return true;
_L2:
        Log.v(TAG, "ACTION_DOWN");
        f = motionevent.getX();
        f1 = motionevent.getY();
        if (listener != null)
        {
            listener.TouchBegin();
            flag = false;
        } else
        {
            flag = false;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        Log.v(TAG, "ACTION_MOVE");
        f = motionevent.getX();
        f1 = motionevent.getY();
        flag = false;
        continue; /* Loop/switch isn't completed */
_L3:
        if (listener != null)
        {
            listener.TouchEnd();
            f = -1F;
            flag = true;
        } else
        {
            f = -1F;
            flag = true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setMaxSizeWithDoubleLine(int i, int j)
    {
        mLineCount = 2;
        colorItems = getColorList();
        lineHeight = j / mLineCount;
        maxPerLineCount = colorItems.size() / mLineCount;
        if (colorItems.size() % 2 != 0)
        {
            maxPerLineCount = maxPerLineCount + 1;
        }
        itemWidth = (int)((float)i / (float)maxPerLineCount);
        i = itemWidth * maxPerLineCount;
        colorAreaWidth = i;
        getLayoutParams().width = i + ew.a(getContext(), 15F);
        i = 0;
        while (i < colorItems.size()) 
        {
            int k = i / maxPerLineCount;
            Object obj = (ml)colorItems.get(i);
            FrameLayout framelayout = new FrameLayout(getContext());
            framelayout.setBackgroundColor(((ml) (obj)).a());
            obj = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
            if (obj == null)
            {
                obj = new android.widget.FrameLayout.LayoutParams(itemWidth, lineHeight, 51);
                obj.width = itemWidth;
                obj.height = lineHeight;
                if (i >= maxPerLineCount)
                {
                    j = i - maxPerLineCount;
                } else
                {
                    j = i;
                }
                obj.leftMargin = j * itemWidth;
                obj.topMargin = lineHeight * k;
                framelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj.width = itemWidth;
                obj.height = lineHeight;
                if (i > maxPerLineCount)
                {
                    j = i - maxPerLineCount;
                } else
                {
                    j = i;
                }
                obj.leftMargin = j * itemWidth;
                obj.topMargin = lineHeight * k;
            }
            layout_color_container.addView(framelayout);
            framelayout.requestLayout();
            i++;
        }
        requestLayout();
    }

    public void setMaxWeidth(int i)
    {
        colorItems = getColorList();
        itemWidth = (int)((float)i / (float)colorItems.size());
        i = itemWidth * colorItems.size();
        colorAreaWidth = i;
        getLayoutParams().width = i + ew.a(getContext(), 15F);
        i = 0;
        while (i < colorItems.size()) 
        {
            Object obj = (ml)colorItems.get(i);
            FrameLayout framelayout = new FrameLayout(getContext());
            framelayout.setBackgroundColor(((ml) (obj)).a());
            obj = (android.widget.FrameLayout.LayoutParams)framelayout.getLayoutParams();
            if (obj == null)
            {
                obj = new android.widget.FrameLayout.LayoutParams(itemWidth, -1, 3);
                obj.width = itemWidth;
                obj.height = -1;
                obj.leftMargin = itemWidth * i;
                framelayout.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            } else
            {
                obj.width = itemWidth;
                obj.height = -1;
                obj.leftMargin = itemWidth * i;
            }
            layout_color_container.addView(framelayout);
            framelayout.requestLayout();
            i++;
        }
        requestLayout();
    }

    public void setOnColorSelectorListener(mm mm1)
    {
        listener = mm1;
    }
}
