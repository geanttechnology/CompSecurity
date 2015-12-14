// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import ij;

public class FotoBeautyHelpHint extends LinearLayout
{

    ij callback;
    ImageView mImg;
    TextView mText;

    public FotoBeautyHelpHint(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030025, this, true);
        mText = (TextView)findViewById(0x7f0d00b8);
        mImg = (ImageView)findViewById(0x7f0d00b9);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        callback.a();
        return true;
    }

    public void setCallback(ij ij1)
    {
        callback = ij1;
    }

    public void setImage(int i)
    {
        mImg.setImageResource(i);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(onclicklistener);
        callback.a();
    }

    public void setText(int i)
    {
        mText.setText(getResources().getString(i));
    }
}
