// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.extension.blueKai;

import android.app.Activity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import tv.freewheel.ad.interfaces.IAdContext;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.extension.IExtension;
import tv.freewheel.extension.ParamParser;
import tv.freewheel.utils.CommonUtil;
import tv.freewheel.utils.Logger;

public class BlueKaiDataExtension
    implements IExtension
{

    static boolean alreadySync = false;
    private IAdContext adContext;
    private String bluekaiScript;
    private IConstants constants;
    private Logger logger;
    IEventListener requestCompleteListener;
    private WebView webView;

    public BlueKaiDataExtension()
    {
        bluekaiScript = "<!DOCTYPE html><html><head><meta charset='utf-8'></head><body><iframe name='__bkframe' height='0' width='0' frameborder='0' src='javascript:void(0)'></iframe><script type='text/javascript' src='http://tags.bkrtx.com/js/bk-coretag.js'></script><script type='text/javascript'>bk_allow_multiple_calls=true;bk_use_multiple_iframes=true;bk_send_statid_payload=true;bk_addPageCtx('id','androidId_md5');bk_addPageCtx('MD5_Android','androidId_md5');bk_doJSTag(14819, 0);</script></body></html>";
        requestCompleteListener = new IEventListener() {

            final BlueKaiDataExtension this$0;

            public void run(IEvent ievent)
            {
                if ("false".equalsIgnoreCase((String)(String)ievent.getData().get(constants.INFO_KEY_SUCCESS())))
                {
                    logger.debug("RequestComplete: false, return.");
                } else
                if (adContext != null)
                {
                    logger.debug("requestCompleteListener()");
                    if ((new ParamParser(adContext, "extension.blueKai")).parseBoolean("bluekaiMobileDataSync", Boolean.valueOf(false)).booleanValue() && !BlueKaiDataExtension.alreadySync)
                    {
                        ievent = getAndroidId();
                        if (ievent != null)
                        {
                            bluekaiScript = bluekaiScript.replace("androidId_md5", CommonUtil.md5(ievent));
                            webView = new WebView(adContext.getActivity());
                            webView.getSettings().setJavaScriptEnabled(true);
                            webView.loadData(bluekaiScript, "text/html", "UTF-8");
                            BlueKaiDataExtension.alreadySync = true;
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = BlueKaiDataExtension.this;
                super();
            }
        };
    }

    private String getAndroidId()
    {
        if (CommonUtil.parseBoolean((String)adContext.getParameter("_fw_did_android_id"), Boolean.valueOf(true)).booleanValue())
        {
            String s = android.provider.Settings.Secure.getString(adContext.getActivity().getContentResolver(), "android_id");
            if (s != null && !s.isEmpty())
            {
                return s;
            }
        }
        return null;
    }

    public void init(IAdContext iadcontext)
    {
        adContext = iadcontext;
        constants = iadcontext.getConstants();
        logger = Logger.getLogger(this);
        logger.debug("init");
        adContext.addEventListener(constants.EVENT_REQUEST_COMPLETE(), requestCompleteListener);
    }

    public void stop()
    {
        logger.debug("stop");
        if (adContext != null)
        {
            if (webView != null)
            {
                webView.stopLoading();
            }
            adContext.removeEventListener(constants.EVENT_REQUEST_COMPLETE(), requestCompleteListener);
            adContext = null;
        }
    }








/*
    static String access$402(BlueKaiDataExtension bluekaidataextension, String s)
    {
        bluekaidataextension.bluekaiScript = s;
        return s;
    }

*/



/*
    static WebView access$502(BlueKaiDataExtension bluekaidataextension, WebView webview)
    {
        bluekaidataextension.webView = webview;
        return webview;
    }

*/
}
