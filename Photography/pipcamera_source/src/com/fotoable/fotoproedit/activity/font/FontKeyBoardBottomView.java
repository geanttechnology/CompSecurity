// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import hb;
import hc;
import hf;
import hg;
import hq;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTFontView, FontStyleColorShadowView, FontTextLabelInfo

public class FontKeyBoardBottomView extends FrameLayout
{

    private hq fontlistListener = new hq() {

        final FontKeyBoardBottomView a;

        public void a(hb hb)
        {
            if (a.mListener != null)
            {
                a.mListener.a(hb);
            }
        }

            
            {
                a = FontKeyBoardBottomView.this;
                super();
            }
    };
    private FrameLayout mFontCOntainer;
    private FontTFontView mFontView;
    private hc mListener;
    private FontStyleColorShadowView mStyleView;
    private hf styleListner = new hf() {

        final FontKeyBoardBottomView a;

        public void a()
        {
            if (a.mListener != null)
            {
                a.mListener.a();
            }
        }

        public void a(int i)
        {
            if (a.mListener != null)
            {
                a.mListener.a(i);
            }
        }

        public void a(FontTextLabelInfo fonttextlabelinfo)
        {
            if (a.mListener != null)
            {
                a.mListener.a(fonttextlabelinfo);
            }
        }

        public void b()
        {
            if (a.mListener != null)
            {
                a.mListener.b();
            }
        }

        public void b(int i)
        {
            if (a.mListener != null)
            {
                a.mListener.b(i);
            }
        }

        public void b(FontTextLabelInfo fonttextlabelinfo)
        {
            if (a.mListener != null)
            {
                a.mListener.b(fonttextlabelinfo);
            }
        }

        public void c(int i)
        {
            if (a.mListener != null)
            {
                a.mListener.c(i);
            }
        }

        public void d(int i)
        {
            if (a.mListener != null)
            {
                a.mListener.d(i);
            }
        }

            
            {
                a = FontKeyBoardBottomView.this;
                super();
            }
    };
    private SeekBar transparenSeekBar;
    private android.widget.SeekBar.OnSeekBarChangeListener transparenlistner = new android.widget.SeekBar.OnSeekBarChangeListener() {

        final FontKeyBoardBottomView a;

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            if (a.mListener != null)
            {
                a.mListener.e(i);
            }
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
        }

            
            {
                a = FontKeyBoardBottomView.this;
                super();
            }
    };

    public FontKeyBoardBottomView(Context context)
    {
        super(context);
        init();
    }

    public FontKeyBoardBottomView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public FontKeyBoardBottomView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300b9, this, true);
        mFontView = (FontTFontView)findViewById(0x7f0c02cb);
        mStyleView = (FontStyleColorShadowView)findViewById(0x7f0c02cc);
        mFontCOntainer = (FrameLayout)findViewById(0x7f0c02c9);
        transparenSeekBar = (SeekBar)findViewById(0x7f0c02ca);
        mStyleView.setVisibility(4);
        mStyleView.setStyleColorShadowListener(styleListner);
        mStyleView.setHiddenpPromptListener(new hg() {

            final FontKeyBoardBottomView a;

            public void a()
            {
                if (a.mListener != null)
                {
                    a.mListener.c();
                }
            }

            
            {
                a = FontKeyBoardBottomView.this;
                super();
            }
        });
        mFontView.setCallback(fontlistListener);
        transparenSeekBar.setMax(255);
        transparenSeekBar.setProgress(255);
        transparenSeekBar.setOnSeekBarChangeListener(transparenlistner);
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

    public void setListener(hc hc)
    {
        mListener = hc;
    }

    public void setStyleFontAndTxt(FontTextLabelInfo fonttextlabelinfo, hb hb)
    {
        mStyleView.setStyleFontAndTxt(fonttextlabelinfo, hb);
    }

    public void showFontView()
    {
        if (mFontCOntainer.getVisibility() != 0)
        {
            hiddenAll();
            mFontCOntainer.setVisibility(0);
        }
    }

    public void showStyleView()
    {
        if (mStyleView.getVisibility() != 0)
        {
            hiddenAll();
            mStyleView.setVisibility(0);
        }
    }

}
