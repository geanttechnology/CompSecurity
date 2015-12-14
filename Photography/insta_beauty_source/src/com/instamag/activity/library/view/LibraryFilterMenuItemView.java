// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.library.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import bdp;
import bdq;
import com.instamag.activity.library.model.TFilterMenuItemType;
import yp;

public class LibraryFilterMenuItemView extends LinearLayout
{

    FrameLayout btn_view;
    public bdq lisener;
    public TFilterMenuItemType mItemType;
    public int mPosition;
    TextView mTextView;

    public LibraryFilterMenuItemView(Context context)
    {
        super(context);
        initView();
    }

    public LibraryFilterMenuItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initView();
    }

    public LibraryFilterMenuItemView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initView();
    }

    public void initView()
    {
        LayoutInflater layoutinflater = (LayoutInflater)getContext().getSystemService("layout_inflater");
        btn_view.setOnClickListener(new bdp(this));
    }

    public void setDisplayText(String s)
    {
        if (s.equalsIgnoreCase("S"))
        {
            if (yp.b())
            {
                s = "\u62FC\u63A5";
            } else
            if (yp.c())
            {
                s = "\u62FC\u63A5";
            } else
            {
                s = "Strips";
            }
        }
        mTextView.setText(s);
    }

    public void setLisener(bdq bdq, TFilterMenuItemType tfiltermenuitemtype, int i)
    {
        lisener = bdq;
        mItemType = tfiltermenuitemtype;
        mPosition = i;
    }

    public void setSelected(boolean flag)
    {
        if (flag)
        {
            return;
        } else
        {
            mTextView.setTextColor(getContext().getResources().getColor(0x7f0c000f));
            mTextView.setBackgroundDrawable(null);
            return;
        }
    }
}
