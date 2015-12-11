// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.amazon.android.webkit.AmazonValueCallback;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebChromeClient

class val.uploadFile
    implements AmazonValueCallback
{

    final AndroidWebChromeClient this$0;
    final ValueCallback val$uploadFile;

    public void onReceiveValue(Uri uri)
    {
        val$uploadFile.onReceiveValue(uri);
    }

    public volatile void onReceiveValue(Object obj)
    {
        onReceiveValue((Uri)obj);
    }

    ()
    {
        this$0 = final_androidwebchromeclient;
        val$uploadFile = ValueCallback.this;
        super();
    }
}
