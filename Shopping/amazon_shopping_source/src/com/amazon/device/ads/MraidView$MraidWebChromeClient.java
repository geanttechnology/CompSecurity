// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            MraidView, Log

protected class this._cls0 extends WebChromeClient
{

    final MraidView this$0;

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        Log.d(MraidView.access$700(), s1);
        return false;
    }

    protected ()
    {
        this$0 = MraidView.this;
        super();
    }
}
