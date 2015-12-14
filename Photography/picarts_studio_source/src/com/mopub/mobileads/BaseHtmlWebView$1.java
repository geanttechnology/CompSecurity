// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.mopub.mobileads:
//            BaseHtmlWebView, ViewGestureDetector

class val.isScrollable
    implements android.view.er
{

    final BaseHtmlWebView this$0;
    final boolean val$isScrollable;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        BaseHtmlWebView.access$000(BaseHtmlWebView.this).sendTouchEvent(motionevent);
        return motionevent.getAction() == 2 && !val$isScrollable;
    }

    r()
    {
        this$0 = final_basehtmlwebview;
        val$isScrollable = Z.this;
        super();
    }
}
