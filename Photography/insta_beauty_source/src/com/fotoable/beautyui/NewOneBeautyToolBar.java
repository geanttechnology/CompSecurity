// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fotoable.beautyui.newui.FlexibleThumbSeekbar;
import com.fotoable.beautyui.newui.MNewCanSelButton;
import ja;
import jb;
import jc;
import jd;
import je;
import jf;
import jg;
import jh;
import ji;
import jj;
import jk;
import xc;

public class NewOneBeautyToolBar extends FrameLayout
{

    boolean isManual;
    public RelativeLayout mAutoBeautyBar;
    private TextView mAutoTextView;
    MNewCanSelButton mBtnl;
    MNewCanSelButton mBtnm;
    MNewCanSelButton mBtns;
    RelativeLayout mContainer;
    int mCurPensize;
    public jk mListener;
    public RelativeLayout mManualBeautyBar;
    private TextView mManualTextView;
    FlexibleThumbSeekbar mSeekbar;
    MNewCanSelButton mUndoBtn;

    public NewOneBeautyToolBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mCurPensize = 2;
        isManual = true;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ec, this, true);
        mUndoBtn = (MNewCanSelButton)findViewById(0x7f0d038d);
        mUndoBtn.setOnClickListener(new jf(this));
        mUndoBtn.setSelectedColor(0xff444444, -1);
        mUndoBtn.setEnabled(false);
        mBtns = (MNewCanSelButton)findViewById(0x7f0d038e);
        mBtns.setOnClickListener(new jg(this));
        mBtnm = (MNewCanSelButton)findViewById(0x7f0d038f);
        mBtnm.setOnClickListener(new jh(this));
        mBtnl = (MNewCanSelButton)findViewById(0x7f0d0390);
        mBtnl.setOnClickListener(new ji(this));
        mBtnl.setSelectedColor(getResources().getColor(0x7f0c009d), -1);
        mBtnm.setSelectedColor(getResources().getColor(0x7f0c009d), -1);
        mBtns.setSelectedColor(getResources().getColor(0x7f0c009d), -1);
        mUndoBtn.setEnabled(false);
        updateUiPenSize(2);
        mAutoBeautyBar = (RelativeLayout)findViewById(0x7f0d0387);
        mManualBeautyBar = (RelativeLayout)findViewById(0x7f0d038a);
        mSeekbar = (FlexibleThumbSeekbar)findViewById(0x7f0d0389);
        mSeekbar.setOnSeekBarChangeListener(new jj(this));
        context = (MNewCanSelButton)findViewById(0x7f0d038c);
        context.setOnClickListener(new jb(this));
        context.setSelectedColor(0xff888888, -1);
        mAutoTextView = (TextView)findViewById(0x7f0d0388);
        mManualTextView = (TextView)findViewById(0x7f0d038b);
    }

    public int getCurrentPenSize()
    {
        return mCurPensize;
    }

    public void initManual(boolean flag)
    {
        isManual = flag;
        if (!isManual)
        {
            mAutoBeautyBar.setVisibility(0);
            mManualBeautyBar.setVisibility(8);
            return;
        } else
        {
            mAutoBeautyBar.setVisibility(8);
            mManualBeautyBar.setVisibility(0);
            return;
        }
    }

    public void setIsManual(boolean flag)
    {
        if (isManual == flag)
        {
            return;
        }
        isManual = flag;
        mAutoBeautyBar.setVisibility(0);
        mManualBeautyBar.setVisibility(0);
        if (!isManual)
        {
            xc.a().a(0x7f04001d, mAutoBeautyBar, new ja(this));
            xc.a().a(0x7f04001e, mManualBeautyBar, new jc(this));
            return;
        } else
        {
            xc.a().a(0x7f04001e, mAutoBeautyBar, new jd(this));
            xc.a().a(0x7f04001d, mManualBeautyBar, new je(this));
            return;
        }
    }

    public void setListener(jk jk)
    {
        mListener = jk;
    }

    public void setUITitle(int i, int j)
    {
        mAutoTextView.setText(i);
        mManualTextView.setText(j);
    }

    public void setUITitle(String s, String s1)
    {
        mAutoTextView.setText(s);
        mManualTextView.setText(s1);
    }

    public void updateUiPenSize(int i)
    {
        if (i == 1)
        {
            mBtns.setSelected(true);
            mBtnm.setSelected(false);
            mBtnl.setSelected(false);
        } else
        if (i == 3)
        {
            mBtns.setSelected(false);
            mBtnm.setSelected(false);
            mBtnl.setSelected(true);
        } else
        {
            mBtns.setSelected(false);
            mBtnm.setSelected(true);
            mBtnl.setSelected(false);
        }
        mCurPensize = i;
    }

    public void updateUiSeekbar(float f)
    {
        mSeekbar.setProgress((int)((float)mSeekbar.getMax() * f));
    }

    public void updateUiUndo(boolean flag)
    {
        mUndoBtn.setEnabled(flag);
    }
}
