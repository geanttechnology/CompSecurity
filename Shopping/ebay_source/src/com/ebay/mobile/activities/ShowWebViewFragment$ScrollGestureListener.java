// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.view.MotionEvent;
import android.webkit.WebView;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewFragment

class this._cls0 extends android.view.stureListener
{

    final ShowWebViewFragment this$0;

    public boolean onDown(MotionEvent motionevent)
    {
        webview.flingScroll(0, 0);
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        webview.flingScroll(0, -(int)f1);
        return true;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        int i = (int)f1;
        int j = (int)((float)webview.getContentHeight() * webview.getScale());
        int k = webview.getScrollY() + webview.getHeight();
        int l = k + i;
        if (i >= 0 || webview.getScrollY() != 0)
        {
            if (i < 0 && webview.getScrollY() + i < 0)
            {
                webview.scrollBy(0, -webview.getScrollY());
                return true;
            }
            if (l > j)
            {
                webview.scrollBy(0, j - k);
                return true;
            }
            if (l < j)
            {
                webview.scrollBy(0, i);
                return true;
            }
        }
        return true;
    }

    ()
    {
        this$0 = ShowWebViewFragment.this;
        super();
    }
}
