// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import ajo;
import ajp;
import ajq;
import ajr;
import ajs;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.fotoable.fotoproedit.view.ui.color.ColorSelectView;
import yp;

public class FontShadowOutlineEditView extends FrameLayout
{

    private boolean isAutoChanged;
    private ColorSelectView mColorSelectOutlineView;
    private ColorSelectView mColorSelectShadowView;
    private Context mContext;
    private ajs mListener;
    private SeekBar mShadowSeekBar;
    private SeekBar mStrokeSeekBar;

    public FontShadowOutlineEditView(Context context)
    {
        super(context);
        isAutoChanged = true;
        mContext = context;
        init();
    }

    public FontShadowOutlineEditView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        isAutoChanged = true;
        mContext = context;
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030107, this, true);
        mColorSelectShadowView = (ColorSelectView)findViewById(0x7f0d03cc);
        int i = yp.a(getContext()) - 36;
        mColorSelectShadowView.setMaxWeidth(yp.a(getContext(), i));
        mColorSelectShadowView.setOnColorSelectorListener(new ajo(this));
        mColorSelectOutlineView = (ColorSelectView)findViewById(0x7f0d03ce);
        mColorSelectOutlineView.setMaxWeidth(yp.a(getContext(), i));
        mColorSelectOutlineView.setOnColorSelectorListener(new ajp(this));
        mShadowSeekBar = (SeekBar)findViewById(0x7f0d03cb);
        mShadowSeekBar.setMax(100);
        mShadowSeekBar.setProgress(50);
        mShadowSeekBar.setOnSeekBarChangeListener(new ajq(this));
        mStrokeSeekBar = (SeekBar)findViewById(0x7f0d03cd);
        mStrokeSeekBar.setMax(100);
        mStrokeSeekBar.setProgress(0);
        mStrokeSeekBar.setOnSeekBarChangeListener(new ajr(this));
    }

    public void setShadowNum(int i)
    {
        isAutoChanged = false;
        mShadowSeekBar.setProgress(i * 5 + 50);
    }

    public void setShadowOutlineListener(ajs ajs)
    {
        mListener = ajs;
    }

    public void setStrokeNum(int i)
    {
        isAutoChanged = false;
        mStrokeSeekBar.setProgress(i * 5);
    }




/*
    public static boolean access$102(FontShadowOutlineEditView fontshadowoutlineeditview, boolean flag)
    {
        fontshadowoutlineeditview.isAutoChanged = flag;
        return flag;
    }

*/
}
