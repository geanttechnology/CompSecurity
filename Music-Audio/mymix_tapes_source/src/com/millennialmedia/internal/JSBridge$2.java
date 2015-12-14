// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;
import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge, MMWebView

class val.js
    implements Runnable
{

    final JSBridge this$0;
    final String val$js;

    public void run()
    {
        MMWebView mmwebview = (MMWebView)JSBridge.access$100(JSBridge.this).get();
        if (mmwebview != null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("Calling js: ").append(val$js).toString());
            }
            mmwebview.evaluateJavascript(val$js, null);
        }
    }

    ()
    {
        this$0 = final_jsbridge;
        val$js = String.this;
        super();
    }
}
