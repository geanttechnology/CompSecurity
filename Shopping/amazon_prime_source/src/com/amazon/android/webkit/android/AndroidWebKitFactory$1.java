// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.util.Log;
import com.amazon.android.webkit.AmazonHistoryManager;
import com.amazon.android.webkit.AmazonWebView;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebKitFactory

class this._cls0 extends AmazonHistoryManager
{

    final AndroidWebKitFactory this$0;

    public void clearHistory()
    {
        Log.w(com/amazon/android/webkit/AmazonWebView.getName(), "clear browsing history not supported for default webview");
    }

    ()
    {
        this$0 = AndroidWebKitFactory.this;
        super();
    }
}
