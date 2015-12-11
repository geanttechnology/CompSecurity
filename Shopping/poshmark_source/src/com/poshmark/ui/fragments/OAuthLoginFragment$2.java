// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

// Referenced classes of package com.poshmark.ui.fragments:
//            OAuthLoginFragment

class this._cls0 extends WebChromeClient
{

    final OAuthLoginFragment this$0;

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        Log.d("MyApplication", (new StringBuilder()).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
        return true;
    }

    ()
    {
        this$0 = OAuthLoginFragment.this;
        super();
    }
}
