// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import bqm;
import bqn;
import yo;

public class TMagFilterListScrollView extends HorizontalScrollView
{

    private static final String TAG = "TMagFilterListScrollView";
    private bqn mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TMagFilterListScrollView(Context context)
    {
        super(context);
        init();
    }

    public TMagFilterListScrollView(Context context, AttributeSet attributeset)
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

    public void addFilterItem(int i, String s)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f03009b, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0d01ef);
            imagebutton.setTag(s);
            imagebutton.setOnClickListener(new bqm(this));
            imagebutton.setImageBitmap(yo.a(yo.a(getResources().getDrawable(i)), 15F));
            ((TextView)view.findViewById(0x7f0d01f0)).setText(s);
            mLayout.addView(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("TMagFilterListScrollView", s.getMessage());
        }
    }

    public void cancelSelected()
    {
        if (mCurSelectedItem != null)
        {
            mCurSelectedItem.setSelected(false);
            mCurSelectedItem = null;
        }
    }

    public int getItemCount()
    {
        int i = 0;
        if (mLayout != null)
        {
            i = mLayout.getChildCount();
        }
        return i;
    }

    public void setCallback(bqn bqn)
    {
        mCallback = bqn;
    }

    public void setItemSelected(int i, Boolean boolean1)
    {
        if (mCurSelectedItem != null)
        {
            mCurSelectedItem.setSelected(false);
        }
        if (i < mLayout.getChildCount())
        {
            View view = mLayout.getChildAt(i);
            view.setSelected(boolean1.booleanValue());
            mCurSelectedItem = view;
        }
    }

    public void setItemSelectedWithNoActionByFilterName(String s)
    {
        if (mCurSelectedItem != null)
        {
            mCurSelectedItem.setSelected(false);
        }
        int i = 0;
        do
        {
label0:
            {
                if (i < mLayout.getChildCount())
                {
                    View view = mLayout.getChildAt(i);
                    if (!((ImageButton)view.findViewById(0x7f0d01ef)).getTag().toString().equalsIgnoreCase(s))
                    {
                        break label0;
                    }
                    view.setSelected(true);
                    mCurSelectedItem = view;
                }
                return;
            }
            i++;
        } while (true);
    }



/*
    public static View access$002(TMagFilterListScrollView tmagfilterlistscrollview, View view)
    {
        tmagfilterlistscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
