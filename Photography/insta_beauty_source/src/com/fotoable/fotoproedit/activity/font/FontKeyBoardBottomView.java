// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import ajh;
import aji;
import ajj;
import ajk;
import ajl;
import ajm;
import ajn;
import ajz;
import akm;
import ama;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.SeekBar;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTFontView, FontStyleColorShadowView, FontTextLabelInfo

public class FontKeyBoardBottomView extends FrameLayout
{

    private FrameLayout container_bg;
    private akm fontlistListener;
    private FrameLayout mFontCOntainer;
    private FontTFontView mFontView;
    private ajn mListener;
    private FontStyleColorShadowView mStyleView;
    private ajz styleListner;
    private SeekBar transparenSeekBar;
    private android.widget.SeekBar.OnSeekBarChangeListener transparenlistner;

    public FontKeyBoardBottomView(Context context)
    {
        super(context);
        transparenlistner = new aji(this);
        styleListner = new ajj(this);
        fontlistListener = new ajk(this);
        init();
    }

    public FontKeyBoardBottomView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        transparenlistner = new aji(this);
        styleListner = new ajj(this);
        fontlistListener = new ajk(this);
        init();
    }

    public FontKeyBoardBottomView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        transparenlistner = new aji(this);
        styleListner = new ajj(this);
        fontlistListener = new ajk(this);
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030101, this, true);
        container_bg = (FrameLayout)findViewById(0x7f0d03b7);
        mFontView = (FontTFontView)findViewById(0x7f0d03ba);
        mStyleView = (FontStyleColorShadowView)findViewById(0x7f0d03bb);
        mFontCOntainer = (FrameLayout)findViewById(0x7f0d03b8);
        transparenSeekBar = (SeekBar)findViewById(0x7f0d03b9);
        mStyleView.setVisibility(4);
        mStyleView.setStyleColorShadowListener(styleListner);
        mStyleView.setHiddenpPromptListener(new ajh(this));
        mFontView.setCallback(fontlistListener);
        transparenSeekBar.setMax(255);
        transparenSeekBar.setProgress(255);
        transparenSeekBar.setOnSeekBarChangeListener(transparenlistner);
    }

    private void makeAnimation(int i)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, getHeight());
        translateanimation.setDuration(200L);
        translateanimation.setInterpolator(new AccelerateInterpolator());
        translateanimation.setAnimationListener(new ajm(this, i));
        container_bg.startAnimation(translateanimation);
    }

    private void makeTransYAnimation(View view, int i, int j, long l, boolean flag)
    {
        if (view == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (view.getVisibility() != 0)
        {
            return;
        }
        try
        {
            TranslateAnimation translateanimation = new TranslateAnimation(0.0F, 0.0F, i, j);
            translateanimation.setDuration(l);
            translateanimation.setInterpolator(new DecelerateInterpolator());
            translateanimation.setAnimationListener(new ajl(this, flag, view));
            view.startAnimation(translateanimation);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view) { }
    }

    private void showTapViewAtIndex(int i, boolean flag)
    {
        Object obj;
label0:
        {
            obj = null;
            if (i != 3)
            {
                if (i == 2)
                {
                    obj = mStyleView;
                } else
                {
                    obj = mFontCOntainer;
                }
            }
            if (((View) (obj)).getVisibility() != 0)
            {
                if (!flag)
                {
                    break label0;
                }
                makeAnimation(i);
            }
            return;
        }
        hiddenAll();
        ((View) (obj)).setVisibility(0);
    }

    public void hiddenAll()
    {
        mFontCOntainer.setVisibility(8);
        mStyleView.setVisibility(8);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return true;
    }

    public void refreshFontList()
    {
        mFontView.refreshFontList();
    }

    public void setListener(ajn ajn)
    {
        mListener = ajn;
    }

    public void setStyleFontAndTxt(FontTextLabelInfo fonttextlabelinfo, ama ama)
    {
        mStyleView.setStyleFontAndTxt(fonttextlabelinfo, ama);
    }

    public void showBgView(boolean flag)
    {
        showTapViewAtIndex(3, flag);
    }

    public void showFontView(boolean flag)
    {
        showTapViewAtIndex(1, flag);
    }

    public void showStyleView(boolean flag)
    {
        showTapViewAtIndex(2, flag);
    }




}
