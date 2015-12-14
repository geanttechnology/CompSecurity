// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class CameraFilterItemView extends FrameLayout
{

    private ImageView mResIcon;
    private TextView mResText;
    private FrameLayout mState;
    private int textId;

    public CameraFilterItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300f5, this, true);
        mState = (FrameLayout)findViewById(0x7f0d03aa);
        mResIcon = (ImageView)findViewById(0x7f0d01cd);
        mResText = (TextView)findViewById(0x7f0d01ce);
    }

    public String getFilterPath()
    {
        return mResIcon.getTag().toString();
    }

    public String getText()
    {
        return mResText.getText().toString();
    }

    public int getTextRes()
    {
        return textId;
    }

    public void setFilterPath(String s)
    {
        mResIcon.setTag(s);
    }

    public void setResorce(int i, int j)
    {
        setSelected(false);
        textId = i;
        mResIcon.setBackgroundResource(j);
        mResText.setText(i);
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            mState.setVisibility(0);
            mResText.setTextColor(getResources().getColor(0x7f0c0020));
            return;
        } else
        {
            mResText.setTextColor(-1);
            mState.setVisibility(4);
            return;
        }
    }
}
