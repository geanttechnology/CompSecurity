// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.crop;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.crashlytics.android.Crashlytics;
import com.instamag.activity.commonview.ItemView;
import ms;

public class TProEditCropScrollView extends HorizontalScrollView
{

    private static final String TAG = "TFilterListScrollView";
    private ms mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TProEditCropScrollView(Context context)
    {
        super(context);
        init();
    }

    public TProEditCropScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    private final void init()
    {
        mLayout = new LinearLayout(getContext());
        mLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -1));
        mLayout.setOrientation(0);
        mLayout.setBackgroundColor(0);
        setHorizontalScrollBarEnabled(false);
        addView(mLayout);
        initItem();
    }

    public ItemView addItem(int i, String s, String s1)
    {
        ItemView itemview;
        try
        {
            itemview = new ItemView(getContext(), null);
            itemview.setData(s1, i);
            itemview.setTag(s);
            itemview.setClickable(true);
            itemview.setTextColor(-1);
            itemview.setOnClickListener(new android.view.View.OnClickListener() {

                final TProEditCropScrollView a;

                public void onClick(View view)
                {
                    if (a.mCurSelectedItem != view)
                    {
                        if (a.mCurSelectedItem != null)
                        {
                            a.mCurSelectedItem.setSelected(false);
                        }
                        a.mCurSelectedItem = view;
                    }
                    view.setSelected(true);
                    if (a.mCallback != null)
                    {
                        a.mCallback.a((String)view.getTag(), a);
                    }
                }

            
            {
                a = TProEditCropScrollView.this;
                super();
            }
            });
            mLayout.addView(itemview);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
            Log.e("TFilterListScrollView", s.getMessage());
            return null;
        }
        return itemview;
    }

    public void initItem()
    {
        if (mLayout != null)
        {
            mLayout.removeAllViews();
        }
        ItemView itemview = addItem(0x7f0202a0, "free", getContext().getResources().getString(0x7f060292));
        itemview.setSelected(true);
        mCurSelectedItem = itemview;
        addItem(0x7f020295, "1-1", getContext().getResources().getString(0x7f060291));
        addItem(0x7f020298, "3-4", "3:4");
        addItem(0x7f0202a1, "goldenV", getContext().getResources().getString(0x7f060293));
        addItem(0x7f020296, "2-3", "2:3");
        addItem(0x7f020297, "3-2", "3:2");
        addItem(0x7f020299, "4-3", "4:3");
        addItem(0x7f020294, "16-9", "16:9");
        addItem(0x7f02029a, "9-16", "9:16");
    }

    public void setCallback(ms ms)
    {
        mCallback = ms;
    }



/*
    static View access$002(TProEditCropScrollView tproeditcropscrollview, View view)
    {
        tproeditcropscrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
