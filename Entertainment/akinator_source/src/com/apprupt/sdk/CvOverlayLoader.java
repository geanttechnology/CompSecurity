// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import java.util.ArrayList;

// Referenced classes of package com.apprupt.sdk:
//            CvLauncher, CvWebView, CvOverlayActivity

class CvOverlayLoader
{

    public static ArrayList loadedViews = new ArrayList();
    private Context mContext;
    private CvLauncher mLauncher;
    private boolean shouldLaunch;
    private boolean startImidiately;
    private WebView webView;

    public CvOverlayLoader(Context context)
    {
        this(context, false);
    }

    public CvOverlayLoader(Context context, boolean flag)
    {
        shouldLaunch = true;
        mContext = context;
        mLauncher = new CvLauncher(mContext);
        startImidiately = flag;
        context = new _cls1(flag);
        webView = new CvWebView(mContext);
        webView.setWebViewClient(context);
    }

    private void showOverlay()
    {
        loadedViews.add(webView);
        Intent intent = new Intent(mContext, com/apprupt/sdk/CvOverlayActivity);
        intent.addFlags(0x10000000);
        mContext.startActivity(intent);
    }

    public void load(String s)
    {
        if (startImidiately)
        {
            showOverlay();
        }
        webView.loadUrl(s);
    }





/*
    static boolean access$102(CvOverlayLoader cvoverlayloader, boolean flag)
    {
        cvoverlayloader.shouldLaunch = flag;
        return flag;
    }

*/


    /* member class not found */
    class _cls1 {}

}
