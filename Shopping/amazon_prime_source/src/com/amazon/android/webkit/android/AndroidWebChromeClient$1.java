// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.os.Message;
import com.amazon.android.webkit.AmazonWebView;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebChromeClient, AndroidWebViewDelegate

class val.resultMsg
    implements com.amazon.android.webkit.reateWindowCallback
{

    final AndroidWebChromeClient this$0;
    final Message val$resultMsg;

    public void allow(AmazonWebView amazonwebview)
    {
        ((android.webkit.dWebChromeClient._cls1)val$resultMsg.obj).setWebView(((AndroidWebViewDelegate)amazonwebview.getWebViewDelegate()).getDelegate());
        val$resultMsg.sendToTarget();
    }

    public void disallow()
    {
        val$resultMsg.sendToTarget();
    }

    dowCallback()
    {
        this$0 = final_androidwebchromeclient;
        val$resultMsg = Message.this;
        super();
    }
}
