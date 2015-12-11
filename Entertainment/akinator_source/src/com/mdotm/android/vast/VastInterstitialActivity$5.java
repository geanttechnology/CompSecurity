// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import android.content.Intent;
import android.net.Uri;
import com.mdotm.android.listener.InterstitialActionListener;
import com.mdotm.android.utils.MdotMLogger;

// Referenced classes of package com.mdotm.android.vast:
//            VastInterstitialActivity

class val.clickedUrl extends Thread
{

    final VastInterstitialActivity this$0;
    private final String val$clickedUrl;

    public void run()
    {
        adClicked();
        MdotMLogger.i(this, (new StringBuilder("Clicked to migrate url ")).append(val$clickedUrl).toString());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(val$clickedUrl));
        intent.addFlags(0x10000000);
        try
        {
            startActivity(intent);
        }
        catch (Exception exception)
        {
            MdotMLogger.i(this, (new StringBuilder("Could not open browser on ad click to ")).append(exception).toString());
        }
        if (VastInterstitialActivity.access$10(VastInterstitialActivity.this) != null)
        {
            VastInterstitialActivity.access$10(VastInterstitialActivity.this).onLeave();
        }
    }

    ner()
    {
        this$0 = final_vastinterstitialactivity;
        val$clickedUrl = String.this;
        super();
    }
}
