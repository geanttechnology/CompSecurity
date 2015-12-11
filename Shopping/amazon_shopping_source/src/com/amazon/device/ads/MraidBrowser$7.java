// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Intent;
import android.view.View;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            MraidBrowser, Log, AdUtils

class 
    implements android.view.tener
{

    final String originalUrl;
    final MraidBrowser this$0;
    final Intent val$intent;

    public void onClick(View view)
    {
        String s = MraidBrowser.access$200(MraidBrowser.this).getUrl();
        view = s;
        if (s == null)
        {
            Log.w(MraidBrowser.LOG_TAG, "The current URL is null. Reverting to the original URL for external browser.");
            view = originalUrl;
        }
        AdUtils.launchActivityForIntentLink(view, MraidBrowser.access$200(MraidBrowser.this).getContext());
    }

    ()
    {
        this$0 = final_mraidbrowser;
        val$intent = Intent.this;
        super();
        originalUrl = val$intent.getStringExtra("extra_url");
    }
}
