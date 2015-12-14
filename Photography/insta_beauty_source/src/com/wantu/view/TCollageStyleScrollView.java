// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import bpt;
import bpu;
import com.wantu.model.res.TPhotoFreeFrameLayoutInfo;
import yo;

public class TCollageStyleScrollView extends HorizontalScrollView
{

    private static final String TAG = "TCollageStyleScrollView";
    private bpu mCallback;
    private View mCurSelectedItem;
    private LinearLayout mLayout;

    public TCollageStyleScrollView(Context context)
    {
        super(context);
        init();
    }

    public TCollageStyleScrollView(Context context, AttributeSet attributeset)
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

    public void addItem(TPhotoFreeFrameLayoutInfo tphotofreeframelayoutinfo)
    {
        try
        {
            View view = LayoutInflater.from(getContext()).inflate(0x7f03004a, null);
            ImageButton imagebutton = (ImageButton)view.findViewById(0x7f0d01c1);
            imagebutton.setTag(tphotofreeframelayoutinfo);
            imagebutton.setOnClickListener(new bpt(this));
            imagebutton.setImageBitmap(yo.a(tphotofreeframelayoutinfo.getIconBitmap(), 5F));
            mLayout.addView(view);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TPhotoFreeFrameLayoutInfo tphotofreeframelayoutinfo)
        {
            Log.e("TCollageStyleScrollView", tphotofreeframelayoutinfo.getMessage());
        }
    }

    public void removeAllItems()
    {
        mLayout.removeAllViews();
    }

    public void setCallback(bpu bpu)
    {
        mCallback = bpu;
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
    public static View access$002(TCollageStyleScrollView tcollagestylescrollview, View view)
    {
        tcollagestylescrollview.mCurSelectedItem = view;
        return view;
    }

*/

}
