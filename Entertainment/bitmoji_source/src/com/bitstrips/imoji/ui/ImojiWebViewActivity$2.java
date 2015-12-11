// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiWebViewActivity

class val.intent
    implements Runnable
{

    final ImojiWebViewActivity this$0;
    final Intent val$intent;

    public void run()
    {
        webView.loadUrl(val$intent.getData().toString());
    }

    ()
    {
        this$0 = final_imojiwebviewactivity;
        val$intent = Intent.this;
        super();
    }
}
