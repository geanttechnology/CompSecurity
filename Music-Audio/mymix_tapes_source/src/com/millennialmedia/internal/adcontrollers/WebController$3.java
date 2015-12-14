// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.widget.RelativeLayout;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.ViewUtils;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            WebController

class val.layoutParams
    implements Runnable
{

    final WebController this$0;
    final RelativeLayout val$containerLayout;
    final android.widget.ayoutParams val$layoutParams;

    public void run()
    {
        if (WebController.access$000(WebController.this) == null)
        {
            MMLog.e(WebController.access$200(), "MMWebView instance is null, unable to attach");
            WebController.access$100(WebController.this).attachFailed();
            return;
        } else
        {
            ViewUtils.attachView(val$containerLayout, WebController.access$000(WebController.this), val$layoutParams);
            WebController.access$100(WebController.this).attachSucceeded();
            return;
        }
    }

    bControllerListener()
    {
        this$0 = final_webcontroller;
        val$containerLayout = relativelayout;
        val$layoutParams = android.widget.ayoutParams.this;
        super();
    }
}
