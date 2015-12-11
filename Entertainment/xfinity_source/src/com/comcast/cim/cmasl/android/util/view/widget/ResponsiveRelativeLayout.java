// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.RelativeLayout;

public class ResponsiveRelativeLayout extends RelativeLayout
{

    private boolean adjustForActionBar;
    int statusBarHeight;

    public ResponsiveRelativeLayout(Context context)
    {
        super(context);
        adjustForActionBar = true;
        init();
    }

    public ResponsiveRelativeLayout(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        adjustForActionBar = true;
        context = context.obtainStyledAttributes(attributeset, com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout, 0, 0);
        adjustForActionBar = context.getBoolean(com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout_adjustForActionBar, true);
        context.recycle();
        init();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public ResponsiveRelativeLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        adjustForActionBar = true;
        context = context.obtainStyledAttributes(attributeset, com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout, 0, 0);
        adjustForActionBar = context.getBoolean(com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveRelativeLayout_adjustForActionBar, true);
        context.recycle();
        init();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void init()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            requestFitSystemWindows();
        }
    }

    public void adjustForFullScreen()
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)getLayoutParams();
        marginlayoutparams.setMargins(marginlayoutparams.leftMargin, marginlayoutparams.topMargin - statusBarHeight, marginlayoutparams.rightMargin, marginlayoutparams.bottomMargin);
        setLayoutParams(marginlayoutparams);
    }

    public void adjustForStatusBar()
    {
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)getLayoutParams();
        marginlayoutparams.setMargins(marginlayoutparams.leftMargin, marginlayoutparams.topMargin + statusBarHeight, marginlayoutparams.rightMargin, marginlayoutparams.bottomMargin);
        setLayoutParams(marginlayoutparams);
    }

    public boolean fitSystemWindows(Rect rect)
    {
        int j = rect.top;
        if (!adjustForActionBar)
        {
            rect = new TypedValue();
            int i = 0;
            if (getContext().getTheme().resolveAttribute(0x10102eb, rect, true))
            {
                i = TypedValue.complexToDimensionPixelSize(((TypedValue) (rect)).data, getResources().getDisplayMetrics());
            }
            statusBarHeight = j - i;
        }
        Log.d("ResponsiveRelativeLayout", "fitSystemWindows");
        return false;
    }

    public int getStatusBarHeight()
    {
        return statusBarHeight;
    }
}
