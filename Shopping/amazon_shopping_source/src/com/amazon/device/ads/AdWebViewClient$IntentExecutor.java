// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.amazon.device.ads:
//            AdWebViewClient, Log

class this._cls0
    implements this._cls0
{

    final AdWebViewClient this$0;

    public boolean execute(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent.addFlags(0x10000000);
        try
        {
            AdWebViewClient.access$000(AdWebViewClient.this).startActivity(intent);
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Log.w(AdWebViewClient.access$100(), "Could not handle intent with URI: %s", new Object[] {
                s
            });
            return true;
        }
        return true;
    }

    ()
    {
        this$0 = AdWebViewClient.this;
        super();
    }
}
