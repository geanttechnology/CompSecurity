// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;

public class TouchableWebView extends WebView
{

    public TouchableWebView(Context context)
    {
        super(context, null);
    }

    public TouchableWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public TouchableWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(motionevent);
    }
}
