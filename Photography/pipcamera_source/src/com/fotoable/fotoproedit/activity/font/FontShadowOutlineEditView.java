// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.fotoable.photocollage.view.compose2.color.ColorSelectView;
import ew;
import he;
import mm;

public class FontShadowOutlineEditView extends FrameLayout
{

    private boolean isAutoChanged;
    private ColorSelectView mColorSelectOutlineView;
    private ColorSelectView mColorSelectShadowView;
    private Context mContext;
    private he mListener;
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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300bf, this, true);
        mColorSelectShadowView = (ColorSelectView)findViewById(0x7f0c02de);
        int i = ew.a(getContext()) - 36;
        mColorSelectShadowView.setMaxWeidth(ew.a(getContext(), i));
        mColorSelectShadowView.setOnColorSelectorListener(new mm() {

            final FontShadowOutlineEditView a;

            public void TouchBegin()
            {
            }

            public void TouchEnd()
            {
            }

            public void onColorSelector(int j)
            {
                if (a.mListener != null)
                {
                    a.mListener.c(j);
                }
            }

            
            {
                a = FontShadowOutlineEditView.this;
                super();
            }
        });
        mColorSelectOutlineView = (ColorSelectView)findViewById(0x7f0c02e0);
        mColorSelectOutlineView.setMaxWeidth(ew.a(getContext(), i));
        mColorSelectOutlineView.setOnColorSelectorListener(new mm() {

            final FontShadowOutlineEditView a;

            public void TouchBegin()
            {
            }

            public void TouchEnd()
            {
            }

            public void onColorSelector(int j)
            {
                if (a.mListener != null)
                {
                    a.mListener.d(j);
                }
            }

            
            {
                a = FontShadowOutlineEditView.this;
                super();
            }
        });
        mShadowSeekBar = (SeekBar)findViewById(0x7f0c02dd);
        mShadowSeekBar.setMax(100);
        mShadowSeekBar.setProgress(50);
        mShadowSeekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final FontShadowOutlineEditView a;

            public void onProgressChanged(SeekBar seekbar, int j, boolean flag)
            {
                if (a.mListener != null && a.isAutoChanged)
                {
                    j = (j - 50) / 10;
                    a.mListener.a(j);
                    Log.e("onpregeress", "fontshadownum changed");
                    return;
                } else
                {
                    a.isAutoChanged = true;
                    return;
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (a.mListener != null)
                {
                    a.mListener.a();
                }
            }

            
            {
                a = FontShadowOutlineEditView.this;
                super();
            }
        });
        mStrokeSeekBar = (SeekBar)findViewById(0x7f0c02df);
        mStrokeSeekBar.setMax(100);
        mStrokeSeekBar.setProgress(0);
        mStrokeSeekBar.setOnSeekBarChangeListener(new android.widget.SeekBar.OnSeekBarChangeListener() {

            final FontShadowOutlineEditView a;

            public void onProgressChanged(SeekBar seekbar, int j, boolean flag)
            {
                if (a.mListener != null && a.isAutoChanged)
                {
                    j /= 5;
                    a.mListener.b(j);
                    return;
                } else
                {
                    a.isAutoChanged = true;
                    return;
                }
            }

            public void onStartTrackingTouch(SeekBar seekbar)
            {
            }

            public void onStopTrackingTouch(SeekBar seekbar)
            {
                if (a.mListener != null)
                {
                    a.mListener.b();
                }
            }

            
            {
                a = FontShadowOutlineEditView.this;
                super();
            }
        });
    }

    public void setShadowNum(int i)
    {
        isAutoChanged = false;
        mShadowSeekBar.setProgress(i * 5 + 50);
    }

    public void setShadowOutlineListener(he he)
    {
        mListener = he;
    }

    public void setStrokeNum(int i)
    {
        isAutoChanged = false;
        mStrokeSeekBar.setProgress(i * 5);
    }




/*
    static boolean access$102(FontShadowOutlineEditView fontshadowoutlineeditview, boolean flag)
    {
        fontshadowoutlineeditview.isAutoChanged = flag;
        return flag;
    }

*/
}
