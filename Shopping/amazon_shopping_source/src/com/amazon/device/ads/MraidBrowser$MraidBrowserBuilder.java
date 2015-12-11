// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.amazon.device.ads:
//            MraidBrowser, Utils, Assets, Log, 
//            AdActivity

static class 
{

    private static final String LOGTAG = com/amazon/device/ads/MraidBrowser$MraidBrowserBuilder.getSimpleName();
    private Context context;
    private boolean showOpenExternalBrowserButton;
    private String url;

    void show()
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (Utils.isNullOrWhiteSpace(url))
        {
            throw new IllegalArgumentException("Url must not be null or white space");
        }
        if (!Assets.getInstance().ensureAssetsCreated())
        {
            Log.e(LOGTAG, "Could not load application assets, failed to open URI: %s", new Object[] {
                url
            });
            return;
        } else
        {
            Intent intent = new Intent(context, com/amazon/device/ads/AdActivity);
            intent.putExtra("adapter", com/amazon/device/ads/MraidBrowser.getName());
            intent.putExtra("extra_url", url);
            intent.putExtra("extra_open_btn", showOpenExternalBrowserButton);
            intent.addFlags(0x10000000);
            context.startActivity(intent);
            return;
        }
    }

    context withContext(Context context1)
    {
        context = context1;
        return this;
    }

    context withExternalBrowserButton()
    {
        showOpenExternalBrowserButton = true;
        return this;
    }

    showOpenExternalBrowserButton withUrl(String s)
    {
        url = s;
        return this;
    }


    ()
    {
    }
}
