// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class filterItemView extends LinearLayout
{

    FrameLayout mBg;
    ImageView mResIcon;
    TextView mResText;
    int selectedBg;
    int unselectedBg;

    public filterItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        unselectedBg = 0;
        selectedBg = 0;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300f2, this, true);
        mBg = (FrameLayout)findViewById(0x7f0d03a6);
        mResIcon = (ImageView)findViewById(0x7f0d01cd);
        mResText = (TextView)findViewById(0x7f0d0317);
    }

    public String getText()
    {
        return mResText.getText().toString();
    }

    public void setImageBmp(Bitmap bitmap)
    {
        mResIcon.setImageBitmap(bitmap);
    }

    public void setInitData(int i, int j, int k, int l)
    {
        unselectedBg = i;
        selectedBg = j;
        mBg.setBackgroundColor(unselectedBg);
        mResIcon.setImageResource(l);
        mResText.setText(k);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            mBg.setBackgroundColor(selectedBg);
            return;
        } else
        {
            mBg.setBackgroundColor(unselectedBg);
            return;
        }
    }
}
