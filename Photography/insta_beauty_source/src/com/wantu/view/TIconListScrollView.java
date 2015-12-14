// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import bqg;
import bqh;
import bqi;

public class TIconListScrollView extends HorizontalScrollView
{

    private static final String TAG = "TIconListScrollView";
    private bqi mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TIconListScrollView(Context context)
    {
        super(context);
        init();
    }

    public TIconListScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        addView(mLayout);
    }

    public void addItem(int i)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f03006d, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0d0033);
            imagebutton.setImageDrawable(getResources().getDrawable(i));
            imagebutton.setTag(Integer.valueOf(mLayout.getChildCount()));
            imagebutton.setOnClickListener(new bqh(this));
            mLayout.addView(view);
            return;
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            Log.e("TIconListScrollView", notfoundexception.getMessage());
        }
    }

    public void clear()
    {
        mLayout.removeAllViews();
    }

    public void scrollTo(int i)
    {
        if (i < mLayout.getChildCount())
        {
            (new Handler()).postDelayed(new bqg(this, i), 0L);
        }
    }

    public void setCallback(bqi bqi)
    {
        mCallback = bqi;
    }

    public void setItemSelected(int i, Boolean boolean1)
    {
        if (i < mLayout.getChildCount())
        {
            View view = mLayout.getChildAt(i);
            view.setSelected(boolean1.booleanValue());
            mCurSelectedItem = view;
        }
    }




/*
    public static View access$102(TIconListScrollView ticonlistscrollview, View view)
    {
        ticonlistscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
