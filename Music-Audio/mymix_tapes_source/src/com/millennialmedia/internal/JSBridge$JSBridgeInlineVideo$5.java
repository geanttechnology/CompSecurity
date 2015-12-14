// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.internal.video.InlineWebVideoView;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class val.viewTag
    implements Runnable
{

    final ToFullScreen this$1;
    final String val$viewTag;

    public void run()
    {
        Object obj = (MMWebView)JSBridge.access$100(_fld0).get();
        if (obj != null)
        {
            obj = (InlineWebVideoView)((MMWebView) (obj)).findViewWithTag(val$viewTag);
            if (obj != null)
            {
                ((InlineWebVideoView) (obj)).expandToFullScreen();
            }
        }
    }

    A()
    {
        this$1 = final_a;
        val$viewTag = String.this;
        super();
    }
}
