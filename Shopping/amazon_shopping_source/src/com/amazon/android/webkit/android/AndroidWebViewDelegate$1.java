// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewDelegate

class this._cls0 extends WebView
{

    final AndroidWebViewDelegate this$0;

    protected void onScrollChanged(int i, int j, int k, int l)
    {
        AndroidWebViewDelegate.access$200(AndroidWebViewDelegate.this, i, j);
        super.onScrollChanged(i, j, k, l);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return AndroidWebViewDelegate.access$300(AndroidWebViewDelegate.this, motionevent) || super.onTouchEvent(motionevent);
    }

    public boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, boolean flag)
    {
        AndroidWebViewDelegate.access$000(AndroidWebViewDelegate.this, i, j, k, l, i1, j1, k1, l1, flag);
        AndroidWebViewDelegate.access$100(AndroidWebViewDelegate.this, i, j, k, l);
        return super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
    }

    (Context context)
    {
        this$0 = AndroidWebViewDelegate.this;
        super(context);
    }
}
