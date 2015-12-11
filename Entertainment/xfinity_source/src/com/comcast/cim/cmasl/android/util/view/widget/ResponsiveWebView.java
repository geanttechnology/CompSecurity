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
import android.webkit.WebView;

public class ResponsiveWebView extends WebView
{

    private boolean adjustForActionBar;

    public ResponsiveWebView(Context context)
    {
        super(context);
        adjustForActionBar = true;
        init();
    }

    public ResponsiveWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        adjustForActionBar = true;
        context = context.obtainStyledAttributes(attributeset, com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView, 0, 0);
        adjustForActionBar = context.getBoolean(com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView_adjustForActionBar, true);
        context.recycle();
        init();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    public ResponsiveWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        adjustForActionBar = true;
        context = context.obtainStyledAttributes(attributeset, com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView, 0, 0);
        adjustForActionBar = context.getBoolean(com.comcast.cim.cmasl.android.util.R.styleable.com_comcast_cim_cmasl_android_util_view_widget_ResponsiveWebView_adjustForActionBar, true);
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

    protected boolean fitSystemWindows(Rect rect)
    {
        int j = rect.top;
        int i = j;
        if (!adjustForActionBar)
        {
            TypedValue typedvalue = new TypedValue();
            i = 0;
            if (getContext().getTheme().resolveAttribute(0x10102eb, typedvalue, true))
            {
                i = TypedValue.complexToDimensionPixelSize(typedvalue.data, getResources().getDisplayMetrics());
            }
            i = j - i;
        }
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)getLayoutParams();
        marginlayoutparams.setMargins(rect.left, i, rect.right, rect.bottom);
        setLayoutParams(marginlayoutparams);
        Log.d("ResponsiveWebView", "fitSystemWindows");
        return false;
    }
}
