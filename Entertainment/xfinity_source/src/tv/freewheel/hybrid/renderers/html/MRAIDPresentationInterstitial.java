// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import android.app.Activity;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.renderers.html:
//            MRAIDBasePresentation, MRAIDWebView, HTMLRenderer

class MRAIDPresentationInterstitial extends MRAIDBasePresentation
{

    private MRAIDWebView interstitialView;
    private Logger logger;

    public MRAIDPresentationInterstitial(Activity activity, HTMLRenderer htmlrenderer, boolean flag)
    {
        super(activity, htmlrenderer, flag);
        logger = Logger.getLogger(this);
        interstitialView = new MRAIDWebView(activity, htmlrenderer, true, flag);
        interstitialView.setFullScreen(true);
    }

    public void close()
    {
        logger.info("close");
        interstitialView.closeCustomView();
        removeView();
    }

    public void collapse()
    {
        logger.info("collapse, do nothing in interstitial presentation");
    }

    public void dispose()
    {
        interstitialView.dispose();
    }

    public void expand(String s, int i, int j)
    {
        logger.info("expand, do nothing in interstitial presentation");
    }

    public String getAbsoluteURL(String s)
    {
        return interstitialView.URLWithBaseURL(s);
    }

    public MRAIDWebView getCurrentView()
    {
        return interstitialView;
    }

    public void getDefaultPositionOnScreen(int ai[])
    {
        ai[0] = 0;
        ai[1] = 0;
        ai[2] = getFullScreenWidth();
        ai[3] = getFullScreenHeight();
    }

    public void loadContent(String s)
    {
        logger.info("loadContent");
        interstitialView.loadDataWithBaseURL(null, s, null, "utf-8", null);
    }

    public void loadURL(String s)
    {
        logger.info((new StringBuilder()).append("loadURL(").append(s).append(")").toString());
        interstitialView.loadUrl(s);
    }

    public void runJavaScript(String s)
    {
        interstitialView.runJavaScript(s);
    }

    public void show()
    {
        logger.info("show");
        addView(interstitialView);
    }
}
