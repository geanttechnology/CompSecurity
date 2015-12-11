// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class SdkWebView extends WebView
{

    public SdkWebView(Context context)
    {
        super(context);
        init();
    }

    public SdkWebView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init();
    }

    public SdkWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init();
    }

    private void init()
    {
        if (android.os.Build.VERSION.SDK_INT <= 14)
        {
            setScrollBarStyle(0);
        }
    }
}
