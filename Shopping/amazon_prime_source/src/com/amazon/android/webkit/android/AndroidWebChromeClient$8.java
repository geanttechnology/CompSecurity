// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.ValueCallback;
import com.amazon.android.webkit.AmazonValueCallback;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebChromeClient

class val.callback
    implements AmazonValueCallback
{

    final AndroidWebChromeClient this$0;
    final ValueCallback val$callback;

    public volatile void onReceiveValue(Object obj)
    {
        onReceiveValue((String[])obj);
    }

    public void onReceiveValue(String as[])
    {
        val$callback.onReceiveValue(as);
    }

    ()
    {
        this$0 = final_androidwebchromeclient;
        val$callback = ValueCallback.this;
        super();
    }
}
