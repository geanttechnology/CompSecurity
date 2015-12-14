// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.Context;
import android.content.res.Resources;
import com.millennialmedia.internal.video.InlineWebVideoView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class val.height
    implements Runnable
{

    final val.height this$1;
    final int val$height;
    final String val$viewTag;
    final int val$width;
    final int val$x;
    final int val$y;

    public void run()
    {
        Object obj = (MMWebView)JSBridge.access$100(_fld0).get();
        if (obj != null)
        {
            android.util.DisplayMetrics displaymetrics = ((MMWebView) (obj)).getContext().getResources().getDisplayMetrics();
            obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(val$viewTag);
            if (obj != null)
            {
                ((InlineWebVideoView) (obj)).reposition(cess._mth600(this._cls1.this, displaymetrics, val$x), cess._mth600(this._cls1.this, displaymetrics, val$y), cess._mth600(this._cls1.this, displaymetrics, val$width), cess._mth600(this._cls1.this, displaymetrics, val$height));
            }
        }
    }

    A()
    {
        this$1 = final_a;
        val$viewTag = s;
        val$x = i;
        val$y = j;
        val$width = k;
        val$height = I.this;
        super();
    }
}
