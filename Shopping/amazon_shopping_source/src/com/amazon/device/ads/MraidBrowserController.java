// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.net.Uri;

// Referenced classes of package com.amazon.device.ads:
//            MraidAbstractController, MraidView, MraidDisplayController, Log, 
//            AdView

class MraidBrowserController extends MraidAbstractController
{

    private static final String LOGTAG = "MraidBrowserController";

    MraidBrowserController(MraidView mraidview)
    {
        super(mraidview);
    }

    protected void executeAmazonMobileCallback(MraidView mraidview, String s)
    {
        if (mraidview.getOnSpecialUrlClickListener() != null)
        {
            if (mraidview.getDisplayController().isExpanded())
            {
                mraidview.getDisplayController().close();
            }
            mraidview.getOnSpecialUrlClickListener().onSpecialUrlClick(mraidview, s);
        }
    }

    protected void open(String s)
    {
        MraidView mraidview = getView();
        if (s == null || s.length() == 0)
        {
            Log.e("MraidBrowserController", "URI cannot be null or empty");
            return;
        }
        Log.d("MraidBrowserController", "Opening in-app browser: %s", new Object[] {
            s
        });
        Object obj = Uri.parse(s);
        if (((Uri) (obj)).getScheme() != null && ((Uri) (obj)).getScheme().equals("amazonmobile"))
        {
            executeAmazonMobileCallback(mraidview, s);
            return;
        }
        String s1;
        try
        {
            obj = ((Uri) (obj)).getQueryParameter("d.url");
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            Log.e("MraidBrowserController", "Could not open non-hierarchical URI: %s", new Object[] {
                s
            });
            return;
        }
        s1 = ((String) (obj));
        if (obj == null)
        {
            s1 = s;
        }
        if (s1.startsWith("amazonmobile:"))
        {
            executeAmazonMobileCallback(mraidview, s1);
            return;
        }
        if (mraidview.getOnOpenListener() != null)
        {
            mraidview.getOnOpenListener().onOpen(mraidview);
        }
        if (s1.startsWith("http:") || s1.startsWith("https:"))
        {
            (new MraidBrowser.MraidBrowserBuilder()).withContext(getView().getContext()).withUrl(s1).withExternalBrowserButton().show();
            return;
        } else
        {
            mraidview.adView.launchExternalBrowserForLink(s1);
            return;
        }
    }
}
