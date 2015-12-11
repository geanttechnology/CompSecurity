// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Locale;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, ThreadUtils, MobileAdsLogger, WebRequest

class WebUtils
{

    private static final String LOGTAG = com/amazon/device/ads/WebUtils.getSimpleName();
    private static final MobileAdsLogger logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);

    WebUtils()
    {
    }

    public static final String encloseHtml(String s, boolean flag)
    {
        String s2 = s;
        if (s != null)
        {
            String s1 = s;
            if (s.indexOf("<html>") == -1)
            {
                s1 = (new StringBuilder()).append("<html>").append(s).append("</html>").toString();
            }
            s2 = s1;
            if (flag)
            {
                s2 = s1;
                if (s1.indexOf("<!DOCTYPE html>") == -1)
                {
                    s2 = (new StringBuilder()).append("<!DOCTYPE html>").append(s1).toString();
                }
            }
        }
        return s2;
    }

    public static final void executeWebRequestInThread(String s, boolean flag)
    {
        ThreadUtils.scheduleRunnable(new Runnable(s, flag) {

            final boolean val$disconnectEnabled;
            final String val$url;

            public void run()
            {
                WebRequest webrequest = (new WebRequest.WebRequestFactory()).createWebRequest();
                webrequest.enableLog(true);
                webrequest.setUrlString(url);
                webrequest.setDisconnectEnabled(disconnectEnabled);
                try
                {
                    webrequest.makeCall();
                    return;
                }
                catch (WebRequest.WebRequestException webrequestexception)
                {
                    return;
                }
            }

            
            {
                url = s;
                disconnectEnabled = flag;
                super();
            }
        });
    }

    public static final String getScheme(String s)
    {
        String s1 = Uri.parse(s).getScheme();
        s = s1;
        if (s1 != null)
        {
            s = s1.toLowerCase(Locale.US);
        }
        return s;
    }

    public static final String getURLDecodedString(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            logger.d("getURLDecodedString threw: %s", new Object[] {
                unsupportedencodingexception
            });
            return s;
        }
        return s1;
    }

    public static final String getURLEncodedString(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            logger.d("getURLEncodedString threw: %s", new Object[] {
                unsupportedencodingexception
            });
            return s;
        }
        return s1;
    }

    public static boolean launchActivityForIntentLink(String s, Context context)
    {
        String s1;
label0:
        {
            if (s != null)
            {
                s1 = s;
                if (!s.equals(""))
                {
                    break label0;
                }
            }
            s1 = "about:blank";
        }
        logger.d((new StringBuilder()).append("Launch Intent: ").append(s1).toString());
        s = new Intent();
        if (s1.startsWith("intent:"))
        {
            try
            {
                s = Intent.parseUri(s1, 1);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
        } else
        {
            s.setData(Uri.parse(s1));
        }
        s.setAction("android.intent.action.VIEW");
        s.setFlags(0x10000000);
        try
        {
            context.startActivity(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context = s.getAction();
            MobileAdsLogger mobileadslogger = logger;
            StringBuilder stringbuilder = (new StringBuilder()).append("Could not handle ");
            if (context.startsWith("market://"))
            {
                s = "market";
            } else
            {
                s = "intent";
            }
            mobileadslogger.w(stringbuilder.append(s).append(" action: ").append(context).toString());
            return false;
        }
        return true;
    }

}
