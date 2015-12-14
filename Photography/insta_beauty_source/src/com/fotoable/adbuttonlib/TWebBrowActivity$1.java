// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;
import yp;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class this._cls0 extends WebChromeClient
{

    final TWebBrowActivity this$0;

    public void onReceivedTitle(WebView webview, String s)
    {
        super.onReceivedTitle(webview, s);
        s = webview.getTitle();
        if (s != null)
        {
            float f = yp.a(TWebBrowActivity.this) - 150;
            f = yp.a(TWebBrowActivity.this, f);
            int i = (int)((float)yp.b(TWebBrowActivity.this, f) / 20F);
            webview = s;
            if (s.length() > i)
            {
                webview = (new StringBuilder()).append(s.substring(0, i - 1)).append("...").toString();
            }
            title.setText(webview);
        }
    }

    ()
    {
        this$0 = TWebBrowActivity.this;
        super();
    }
}
