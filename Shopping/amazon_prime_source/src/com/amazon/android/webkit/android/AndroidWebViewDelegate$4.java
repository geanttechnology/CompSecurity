// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.ValueCallback;
import com.amazon.android.webkit.AmazonValueCallback;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewDelegate

class val.callback
    implements ValueCallback
{

    final AndroidWebViewDelegate this$0;
    final AmazonValueCallback val$callback;

    public volatile void onReceiveValue(Object obj)
    {
        onReceiveValue((String)obj);
    }

    public void onReceiveValue(String s)
    {
        val$callback.onReceiveValue(s);
    }

    ()
    {
        this$0 = final_androidwebviewdelegate;
        val$callback = AmazonValueCallback.this;
        super();
    }
}
