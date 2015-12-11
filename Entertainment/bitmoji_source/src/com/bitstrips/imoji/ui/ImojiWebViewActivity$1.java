// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.Intent;
import android.net.MailTo;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Locale;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiWebViewActivity

class this._cls0 extends WebViewClient
{

    final ImojiWebViewActivity this$0;

    private Intent createEmailIntent(MailTo mailto)
    {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", mailto.getTo(), null));
        intent.putExtra("android.intent.extra.SUBJECT", mailto.getSubject());
        intent.putExtra("android.intent.extra.TEXT", String.format(Locale.US, "Device: %s %s %s\nOS: %d\nImoji Android v%s\n\n%s:\n", new Object[] {
            Build.MANUFACTURER, Build.MODEL, Build.PRODUCT, Integer.valueOf(android.os.wActivity._fld1), "2.1.390", getString(0x7f060064)
        }));
        return intent;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (MailTo.isMailTo(s))
        {
            webview = createEmailIntent(MailTo.parse(s));
            startActivity(webview);
            return true;
        } else
        {
            return super.shouldOverrideUrlLoading(webview, s);
        }
    }

    ()
    {
        this$0 = ImojiWebViewActivity.this;
        super();
    }
}
