// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import axw;
import azq;
import azr;
import bdg;
import com.fotoable.global.ImageView_Color;
import com.instamag.activity.library.model.TResTypeManager;

public class TResTypeItemView extends LinearLayout
{

    public boolean isSelected;
    ImageView_Color mImageView_Color;
    View mLeftLineView;
    View mLineView;
    public azr mListener;
    public bdg mResType;
    TextView mTextView;

    public TResTypeItemView(Context context, bdg bdg1, azr azr)
    {
        super(context);
        isSelected = false;
        mListener = null;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03007d, this, true);
        mTextView = (TextView)findViewById(0x7f0d01ce);
        mLineView = findViewById(0x7f0d0276);
        mLeftLineView = findViewById(0x7f0d0274);
        mImageView_Color = (ImageView_Color)findViewById(0x7f0d0275);
        mResType = bdg1;
        mListener = azr;
        mLineView.setVisibility(4);
        mLeftLineView.setVisibility(4);
        mImageView_Color.setVisibility(8);
        if (mResType.a != TResTypeManager.KPORTRAITTYPEID) goto _L2; else goto _L1
_L1:
        mImageView_Color.setVisibility(0);
        mTextView.setVisibility(8);
        mLeftLineView.setVisibility(0);
        mImageView_Color.setBackgroundResource(0x7f020125);
_L4:
        setOnClickListener(new azq(this));
        return;
_L2:
        if (mResType.a == TResTypeManager.KSQUARETYPEID)
        {
            mImageView_Color.setVisibility(0);
            mTextView.setVisibility(8);
            mImageView_Color.setBackgroundResource(0x7f020127);
        } else
        if (mResType.a == TResTypeManager.KLANDSCAPETYPEID)
        {
            mImageView_Color.setVisibility(0);
            mTextView.setVisibility(8);
            mImageView_Color.setBackgroundResource(0x7f020121);
        } else
        if (mResType.a == TResTypeManager.KSTRIPSTYPEID)
        {
            mImageView_Color.setVisibility(0);
            mTextView.setVisibility(8);
            mImageView_Color.setBackgroundResource(0x7f020123);
        } else
        {
            mImageView_Color.setVisibility(8);
            mTextView.setVisibility(0);
            mLeftLineView.setVisibility(4);
            mTextView.setText(mResType.b);
            if (axw.b())
            {
                mTextView.setText(mResType.b);
            } else
            if (axw.c())
            {
                mTextView.setText(mResType.c);
            } else
            {
                mTextView.setText(mResType.d);
            }
            if (mResType.a == TResTypeManager.KRES_COMMONLYUSED)
            {
                mLineView.setVisibility(0);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setSelected(boolean flag)
    {
        super.setSelected(flag);
        if (flag)
        {
            mTextView.setTextColor(getResources().getColor(0x7f0c0094));
            mImageView_Color.setSelected(true);
            return;
        } else
        {
            mTextView.setTextColor(getResources().getColor(0x7f0c00a6));
            mImageView_Color.setSelected(false);
            return;
        }
    }

    public void setText(String s)
    {
        mTextView.setText(s);
    }
}
