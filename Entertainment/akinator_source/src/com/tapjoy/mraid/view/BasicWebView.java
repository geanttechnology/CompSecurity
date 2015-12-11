// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BasicWebView extends WebView
{
    final class a extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final BasicWebView a;

        public final boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return true;
        }

        a()
        {
            a = BasicWebView.this;
            super();
        }
    }


    public BasicWebView(Context context)
    {
        super(context);
        setScrollContainer(false);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        new GestureDetector(new a());
        if (getSettings() != null)
        {
            getSettings().setJavaScriptEnabled(true);
            if (android.os.Build.VERSION.SDK_INT >= 17)
            {
                getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
        }
        setBackgroundColor(0);
    }

    public BasicWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }
}
