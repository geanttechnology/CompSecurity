// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView
{

    public CustomScrollView(Context context)
    {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public CustomScrollView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public void fling(int i)
    {
        super.fling(i);
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
    }
}
