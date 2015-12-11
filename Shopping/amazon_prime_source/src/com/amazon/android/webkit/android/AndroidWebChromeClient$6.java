// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.JsResult;
import com.amazon.android.webkit.AmazonJsResult;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebChromeClient

class val.jsResult extends AmazonJsResult
{

    final AndroidWebChromeClient this$0;
    final JsResult val$jsResult;

    public void cancel()
    {
        val$jsResult.cancel();
    }

    public void confirm()
    {
        val$jsResult.confirm();
    }

    ()
    {
        this$0 = final_androidwebchromeclient;
        val$jsResult = JsResult.this;
        super();
    }
}
