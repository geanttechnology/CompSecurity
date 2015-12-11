// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.poshmark.ui.fragments:
//            MappPageFragment

class this._cls0 extends WebChromeClient
{

    final MappPageFragment this$0;

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        Log.d("MyApplication", (new StringBuilder()).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
        return true;
    }

    public void onReceivedTitle(WebView webview, String s)
    {
        super.onReceivedTitle(webview, s);
        if (s != null && s.length() > 0 && title == null)
        {
            title = s;
            if (getUserVisibleHint())
            {
                setTitle(title);
            }
        }
    }

    ()
    {
        this$0 = MappPageFragment.this;
        super();
    }
}
