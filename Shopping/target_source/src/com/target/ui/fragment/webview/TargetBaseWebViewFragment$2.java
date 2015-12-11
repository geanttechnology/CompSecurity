// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.webview;

import android.view.KeyEvent;
import android.view.View;
import com.target.ui.view.ObservableScrollWebView;

// Referenced classes of package com.target.ui.fragment.webview:
//            TargetBaseWebViewFragment

class this._cls0
    implements android.view.WebViewFragment._cls2
{

    final TargetBaseWebViewFragment this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getAction() == 1 && TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).webView.canGoBack())
        {
            TargetBaseWebViewFragment.b(TargetBaseWebViewFragment.this).webView.goBack();
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = TargetBaseWebViewFragment.this;
        super();
    }
}
