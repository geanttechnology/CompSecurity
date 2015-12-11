// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.webkit.WebView;

// Referenced classes of package com.poshmark.ui.fragments:
//            MappPageFragment

class this._cls1
    implements com.poshmark.utils.face._cls1
{

    final this._cls1 this$1;

    public void runOnUIThread(Object obj)
    {
        webView.loadUrl("javascript:gp_command.queue.ready=true;");
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
