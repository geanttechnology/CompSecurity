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
import com.crashlytics.android.Crashlytics;
import yu;

public class TIconListScrollView extends HorizontalScrollView
{

    private static final String TAG = "TIconListScrollView";
    private yu mCallback;
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
            View view = LayoutInflater.from(getContext()).inflate(0x7f030042, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0c002c);
            imagebutton.setImageDrawable(getResources().getDrawable(i));
            imagebutton.setTag(Integer.valueOf(mLayout.getChildCount()));
            imagebutton.setOnClickListener(new android.view.View.OnClickListener() {

                final TIconListScrollView a;

                public void onClick(View view1)
                {
                    if (a.mCurSelectedItem != view1)
                    {
                        if (a.mCurSelectedItem != null)
                        {
                            a.mCurSelectedItem.setSelected(false);
                        }
                        a.mCurSelectedItem = view1;
                        view1.setSelected(true);
                        if (a.mCallback != null)
                        {
                            a.mCallback.a(view1.getTag());
                            return;
                        }
                    }
                }

            
            {
                a = TIconListScrollView.this;
                super();
            }
            });
            mLayout.addView(view);
            return;
        }
        catch (android.content.res.Resources.NotFoundException notfoundexception)
        {
            Log.e("TIconListScrollView", notfoundexception.getMessage());
            Crashlytics.logException(notfoundexception);
            return;
        }
    }

    public void setCallback(yu yu)
    {
        mCallback = yu;
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
    static View access$002(TIconListScrollView ticonlistscrollview, View view)
    {
        ticonlistscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
