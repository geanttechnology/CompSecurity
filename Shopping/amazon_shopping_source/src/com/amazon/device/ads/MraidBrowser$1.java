// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.amazon.device.ads:
//            MraidBrowser, Log

class this._cls0 extends WebViewClient
{

    final MraidBrowser this$0;

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Log.w(MraidBrowser.LOG_TAG, "MRAID error: %s", new Object[] {
            s
        });
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        while (s == null || !s.startsWith("market:") && !s.startsWith("tel:") && !s.startsWith("voicemail:") && !s.startsWith("sms:") && !s.startsWith("mailto:") && !s.startsWith("geo:") && !s.startsWith("google.streetview:")) 
        {
            return false;
        }
        try
        {
            MraidBrowser.access$000(MraidBrowser.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            Log.w(MraidBrowser.LOG_TAG, "Could not handle intent with URI: %s", new Object[] {
                s
            });
        }
        return true;
    }

    tion()
    {
        this$0 = MraidBrowser.this;
        super();
    }
}
