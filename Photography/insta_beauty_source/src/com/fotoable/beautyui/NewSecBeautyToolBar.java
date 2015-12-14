// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fotoable.beautyui.newui.MNewCanSelButton;
import jl;
import jm;
import jn;
import jo;
import jp;
import jq;
import jr;
import js;
import jt;
import ju;
import jv;
import xc;

// Referenced classes of package com.fotoable.beautyui:
//            SlideSwitch

public class NewSecBeautyToolBar extends FrameLayout
{

    boolean isAutoClicked;
    private boolean isManual;
    public LinearLayout mAutoBeautyBar;
    MNewCanSelButton mBtnl;
    MNewCanSelButton mBtnm;
    MNewCanSelButton mBtns;
    int mCurPensize;
    public jv mListener;
    public RelativeLayout mManualBeautyBar;
    private TextView mManualTextView;
    TextView mTitleView;
    SlideSwitch mToggle;
    MNewCanSelButton mUndoBtn;

    public NewSecBeautyToolBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mCurPensize = 2;
        isAutoClicked = true;
        isManual = false;
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ed, this, true);
        mTitleView = (TextView)findViewById(0x7f0d0335);
        mUndoBtn = (MNewCanSelButton)findViewById(0x7f0d038d);
        mUndoBtn.setOnClickListener(new jq(this));
        mUndoBtn.setSelectedColor(0xff444444, -1);
        mUndoBtn.setEnabled(false);
        mBtns = (MNewCanSelButton)findViewById(0x7f0d038e);
        mBtns.setOnClickListener(new jr(this));
        mBtnm = (MNewCanSelButton)findViewById(0x7f0d038f);
        mBtnm.setOnClickListener(new js(this));
        mBtnl = (MNewCanSelButton)findViewById(0x7f0d0390);
        mBtnl.setOnClickListener(new jt(this));
        mBtnl.setSelectedColor(getResources().getColor(0x7f0c009d), -1);
        mBtnm.setSelectedColor(getResources().getColor(0x7f0c009d), -1);
        mBtns.setSelectedColor(getResources().getColor(0x7f0c009d), -1);
        mAutoBeautyBar = (LinearLayout)findViewById(0x7f0d0391);
        mManualBeautyBar = (RelativeLayout)findViewById(0x7f0d0393);
        mToggle = (SlideSwitch)findViewById(0x7f0d0392);
        mToggle.setSlideListener(new ju(this));
        mUndoBtn.setEnabled(false);
        updateUiPensize(2);
        context = (MNewCanSelButton)findViewById(0x7f0d0394);
        context.setSelectedColor(0xff888888, -1);
        context.setOnClickListener(new jm(this));
        mManualTextView = (TextView)findViewById(0x7f0d0213);
    }

    public int getCurPenSize()
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

    public void needBrushPen(boolean flag)
    {
        if (flag)
        {
            mBtns.setVisibility(0);
            mBtnm.setVisibility(0);
            mBtnl.setVisibility(0);
            return;
        } else
        {
            mBtns.setVisibility(4);
            mBtnm.setVisibility(4);
            mBtnl.setVisibility(4);
            return;
        }
    }

    public void setIsMunal(boolean flag)
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
            xc.a().a(0x7f04001d, mAutoBeautyBar, new jl(this));
            xc.a().a(0x7f04001e, mManualBeautyBar, new jn(this));
            return;
        } else
        {
            xc.a().a(0x7f04001e, mAutoBeautyBar, new jo(this));
            xc.a().a(0x7f04001d, mManualBeautyBar, new jp(this));
            return;
        }
    }

    public void setListener(jv jv)
    {
        mListener = jv;
    }

    public void setUITitle(int i, int j)
    {
        mManualTextView.setText(j);
        mTitleView.setText(i);
    }

    public void setUITitle(String s, String s1)
    {
        mTitleView.setText(s);
        mManualTextView.setText(s1);
    }

    public void updateUiPensize(int i)
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

    public void updateUiSwitch(boolean flag)
    {
        mToggle.initState(flag);
    }

    public void updateUiUndo(boolean flag)
    {
        mUndoBtn.setEnabled(flag);
    }
}
