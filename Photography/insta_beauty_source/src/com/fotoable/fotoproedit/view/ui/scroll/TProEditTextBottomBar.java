// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import ani;
import anj;
import ank;
import anl;
import com.fotoable.fotoproedit.activity.font.ComButtonItemView;

public class TProEditTextBottomBar extends LinearLayout
{

    public ComButtonItemView bottom_1;
    public ComButtonItemView bottom_2;
    public ComButtonItemView bottom_3;
    public anl mListener;

    public TProEditTextBottomBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030124, this, true);
        bottom_1 = (ComButtonItemView)findViewById(0x7f0d0433);
        bottom_1.setImage(0x7f020313);
        bottom_2 = (ComButtonItemView)findViewById(0x7f0d0434);
        bottom_2.setImage(0x7f02030f);
        bottom_3 = (ComButtonItemView)findViewById(0x7f0d0435);
        bottom_3.setImage(0x7f02030d);
        bottom_1.setOnClickListener(new ani(this));
        bottom_2.setOnClickListener(new anj(this));
        bottom_3.setOnClickListener(new ank(this));
    }

    private void setBtnSelected(ComButtonItemView combuttonitemview)
    {
        setBottomUnselected();
        combuttonitemview.setSelected(true);
    }

    public void setBottomUnselected()
    {
        bottom_1.setSelected(false);
        bottom_2.setSelected(false);
        bottom_3.setSelected(false);
    }

    public void setFontBtnSelected()
    {
        setBottomUnselected();
        bottom_2.setSelected(true);
    }

    public void setKeyBoardBtnSelected()
    {
        setBottomUnselected();
        bottom_1.setSelected(true);
    }

    public void setListner(anl anl)
    {
        mListener = anl;
    }

}
