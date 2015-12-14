// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fotoable.beautyui.newui.FlexibleThumbSeekbar;
import ir;
import is;
import it;
import iu;
import iv;

// Referenced classes of package com.fotoable.beautyui:
//            NewFilterScrollView

public class NewFilterContainer extends LinearLayout
{

    private int curFilterId;
    private float curFilterValue;
    private ImageView mBtnCompare;
    NewFilterScrollView mFilterScroll;
    public FlexibleThumbSeekbar mFilterSeekBar;
    public iv mListener;
    private ImageView mbtnFaceAdjust;

    public NewFilterContainer(Context context)
    {
        super(context);
        curFilterValue = 0.7F;
        init();
    }

    public NewFilterContainer(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        curFilterValue = 0.7F;
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ef, this, true);
        mBtnCompare = (ImageView)findViewById(0x7f0d00c4);
        mbtnFaceAdjust = (ImageView)findViewById(0x7f0d0398);
        mbtnFaceAdjust.setOnClickListener(new ir(this));
        mBtnCompare.setOnTouchListener(new is(this));
        mFilterScroll = (NewFilterScrollView)findViewById(0x7f0d0399);
        mFilterScroll.setCallback(new it(this));
        mFilterSeekBar = (FlexibleThumbSeekbar)findViewById(0x7f0d0397);
        mFilterSeekBar.setProgress(70);
        mFilterSeekBar.setVisibility(4);
        mbtnFaceAdjust.setVisibility(4);
        mFilterSeekBar.setOnSeekBarChangeListener(new iu(this));
    }

    public float getFilterValue()
    {
        return curFilterValue;
    }

    public void needScrollView()
    {
        mFilterScroll.needScrollView();
    }

    public void setBtnFindState(boolean flag)
    {
        if (flag)
        {
            mbtnFaceAdjust.setVisibility(4);
            return;
        } else
        {
            mbtnFaceAdjust.setVisibility(0);
            return;
        }
    }

    public void setFilterScroll(int i, float f)
    {
        mFilterScroll.setItemViewSelected(i);
        mFilterSeekBar.setProgress((int)((float)mFilterSeekBar.getMax() * f));
        curFilterValue = f;
    }

    public void setFilterValue(float f)
    {
        mFilterSeekBar.setProgress((int)(100F * f));
        curFilterValue = f;
    }

    public void setItemViewSelected(String s)
    {
        mFilterScroll.setItemViewSelected(s);
    }

    public void setListener(iv iv)
    {
        mListener = iv;
    }

    public void setPresetScrollImg(Bitmap bitmap)
    {
        mFilterScroll.setPresetScrollImg(bitmap);
    }

    public void setScrollImage(Bitmap bitmap)
    {
        mFilterScroll.setScrollImage(bitmap);
    }


/*
    public static int access$002(NewFilterContainer newfiltercontainer, int i)
    {
        newfiltercontainer.curFilterId = i;
        return i;
    }

*/


/*
    public static float access$102(NewFilterContainer newfiltercontainer, float f)
    {
        newfiltercontainer.curFilterValue = f;
        return f;
    }

*/
}
