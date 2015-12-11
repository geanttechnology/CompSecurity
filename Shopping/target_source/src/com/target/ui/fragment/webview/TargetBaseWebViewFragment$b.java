// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.webview;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

// Referenced classes of package com.target.ui.fragment.webview:
//            TargetBaseWebViewFragment

class this._cls0 extends WebChromeClient
{

    final TargetBaseWebViewFragment this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        if (i < 100)
        {
            TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).progressBar.setProgress(i);
        }
    }

    ()
    {
        this$0 = TargetBaseWebViewFragment.this;
        super();
    }
}
