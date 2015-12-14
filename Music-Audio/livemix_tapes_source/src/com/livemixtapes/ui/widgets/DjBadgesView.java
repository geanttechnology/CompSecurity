// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.livemixtapes.utils.Utility;

public class DjBadgesView extends HorizontalScrollView
{
    public static interface DjClickListener
    {

        public abstract void onClickDj(String s);
    }


    private android.view.View.OnClickListener clickDjListener = new android.view.View.OnClickListener() {

        final DjBadgesView this$0;

        public void onClick(View view)
        {
            if (djClickListener != null)
            {
                djClickListener.onClickDj(((TextView)view).getText().toString());
            }
        }

            
            {
                this$0 = DjBadgesView.this;
                super();
            }
    };
    private DjClickListener djClickListener;

    public DjBadgesView(Context context)
    {
        super(context);
        init(context);
    }

    public DjBadgesView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public DjBadgesView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private void init(Context context)
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = new android.view.ViewGroup.MarginLayoutParams(-2, -2);
        context = new LinearLayout(context);
        context.setOrientation(0);
        context.setLayoutParams(marginlayoutparams);
        addView(context);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
    }

    public void loadDjs(String as[], boolean flag)
    {
        LinearLayout linearlayout;
        int i;
        int j;
        int k;
        int l;
        j = (int)Utility.dpToPixel(getContext(), 4F);
        k = (int)Utility.dpToPixel(getContext(), 4F);
        l = getContext().getResources().getColor(0x7f0b001b);
        linearlayout = (LinearLayout)getChildAt(0);
        linearlayout.removeAllViews();
        i = 0;
_L5:
        if (i < as.length) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
        layoutparams.setMargins(0, 0, k, 0);
        TextView textview = new TextView(getContext());
        textview.setText(as[i]);
        textview.setBackgroundResource(0x7f020094);
        textview.setTextColor(l);
        textview.setTextSize(12F);
        textview.setLayoutParams(layoutparams);
        textview.setPadding(j, 0, j, 0);
        if (djClickListener != null)
        {
            textview.setOnClickListener(clickDjListener);
        }
        linearlayout.addView(textview);
        if (flag) goto _L1; else goto _L3
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setOnDjClickListener(DjClickListener djclicklistener)
    {
        djClickListener = djclicklistener;
    }

}
