// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.device.ads:
//            AdWebViewClient, Log, AdView, AmazonDeviceLauncher

static class context
    implements context
{

    private final AdView adView;
    private final Context context;

    public boolean execute(String s)
    {
        specialUrlClicked(s);
        return true;
    }

    protected void handleApplicationDefinedSpecialURL(String s)
    {
        Log.i(AdWebViewClient.access$100(), "Special url clicked, but was not handled by SDK. Url: %s", new Object[] {
            s
        });
    }

    protected boolean launchExternalActivity(String s)
    {
        Intent intent = new Intent();
        if (s.startsWith("intent:"))
        {
            try
            {
                s = Intent.parseUri(s, 1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
        } else
        {
            intent.setData(Uri.parse(s));
            s = intent;
        }
        try
        {
            s.setAction("android.intent.action.VIEW");
            s.addFlags(0x10000000);
            context.startActivity(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public void specialUrlClicked(String s)
    {
        if (adView != null && adView.isAdViewRenderable()) goto _L2; else goto _L1
_L1:
        Log.d(AdWebViewClient.access$100(), "AdView is Null");
_L4:
        return;
_L2:
        Object obj;
        Uri uri;
        Log.d(AdWebViewClient.access$100(), "Executing AmazonMobile Intent");
        uri = Uri.parse(s);
        try
        {
            obj = uri.getQueryParameters("intent");
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            unsupportedoperationexception = null;
        }
        if (obj != null && ((List) (obj)).size() > 0)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                if (launchExternalActivity((String)((Iterator) (obj)).next()))
                {
                    return;
                }
            }

            handleApplicationDefinedSpecialURL(s);
            return;
        }
        if (!AmazonDeviceLauncher.isWindowshopPresent(context))
        {
            break MISSING_BLOCK_LABEL_233;
        }
        if (!uri.getHost().equals("shopping"))
        {
            continue; /* Loop/switch isn't completed */
        }
        unsupportedoperationexception = uri.getQueryParameter("app-action");
        if (unsupportedoperationexception == null || unsupportedoperationexception.length() == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!unsupportedoperationexception.equals("detail"))
        {
            break; /* Loop/switch isn't completed */
        }
        s = uri.getQueryParameter("asin");
        if (s != null && s.length() != 0)
        {
            AmazonDeviceLauncher.launchWindowshopDetailPage(context, s);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!unsupportedoperationexception.equals("search"))
        {
            continue; /* Loop/switch isn't completed */
        }
        s = uri.getQueryParameter("keyword");
        if (s == null || s.length() == 0) goto _L4; else goto _L5
_L5:
        AmazonDeviceLauncher.launchWindowshopSearchPage(context, s);
        return;
        if (!unsupportedoperationexception.equals("webview")) goto _L4; else goto _L6
_L6:
        handleApplicationDefinedSpecialURL(s);
        return;
        handleApplicationDefinedSpecialURL(s);
        return;
    }

    (AdView adview, Context context1)
    {
        adView = adview;
        context = context1;
    }
}
