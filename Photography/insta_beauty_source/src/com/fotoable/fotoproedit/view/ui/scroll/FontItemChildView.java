// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import alr;
import ama;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import yp;

public class FontItemChildView extends LinearLayout
{

    private ImageView imgDownloadTip;
    private ImageView imgFontName;
    Boolean selected;
    public TextView textView;

    public FontItemChildView(Context context)
    {
        super(context);
    }

    public FontItemChildView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030126, this, true);
        textView = (TextView)findViewById(0x7f0d01ce);
        imgFontName = (ImageView)findViewById(0x7f0d0437);
        imgDownloadTip = (ImageView)findViewById(0x7f0d0438);
        selected = Boolean.valueOf(false);
    }

    public void hideDownloadTip()
    {
        imgDownloadTip.setVisibility(4);
    }

    public void setBackColor(int i)
    {
        textView.setBackgroundColor(i);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        selected = Boolean.valueOf(flag);
    }

    public void setTextWithFont(String s, ama ama1)
    {
        if (!ama1.a)
        {
            textView.setTypeface(ama1.b());
            textView.setText("FotoRus");
            if (s == "sans" && yp.a())
            {
                textView.setText("\u73A9\u56FE");
                textView.setTextSize(20F);
            }
        } else
        {
            imgFontName.setBackgroundResource(ama1.c);
            if (!alr.a().b(ama1))
            {
                imgDownloadTip.setVisibility(0);
                return;
            }
        }
    }
}
