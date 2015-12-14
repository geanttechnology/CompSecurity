// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.net.Uri;
import com.amazon.identity.auth.device.env.EnvironmentUtils;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.kcpsdk.auth.AmazonWebserviceCall;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class PhoneVerificationHelper
{

    private static final String TAG = com/amazon/identity/auth/device/utils/PhoneVerificationHelper.getName();

    private PhoneVerificationHelper()
    {
    }

    public static String getPhoneVerificationUrlFromDeepLinkUrl(String s, Tracer tracer)
    {
        try
        {
            s = Uri.parse(s).getQueryParameter("url");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.logAndReportError(TAG, tracer, "The deeplink url is malformed.", (new StringBuilder("MOA:DeepLinkUrlMalformed:")).append(s.getClass().getName()).toString());
            return null;
        }
        return s;
    }

    public static URL parsePVTinyURLFromSMS(String s)
    {
        if (s != null)
        {
            if ((s = Pattern.compile(EnvironmentUtils.getInstance().getPVTinyURLPatternString()).matcher(s)).find())
            {
                String s1 = s.group();
                s = s1;
                if (!s1.startsWith("http"))
                {
                    s = (new StringBuilder("http://")).append(s1).toString();
                }
                try
                {
                    s = new URL(s);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    MAPLog.e(TAG, "Unable to parse String recognized in SMS as URL.");
                    return null;
                }
                return s;
            }
        }
        return null;
    }

    public static String resolveTinyURLRedirect(HttpURLConnection httpurlconnection, Tracer tracer)
    {
        String s;
        AmazonWebserviceCall.setAmazonWebRequestSettings(httpurlconnection);
        httpurlconnection.setInstanceFollowRedirects(false);
        if (httpurlconnection.getResponseCode() / 100 != 3)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        s = httpurlconnection.getHeaderField("location");
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        return s;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
_L2:
        return null;
        Object obj;
        obj;
        MAPLog.logAndReportError(TAG, tracer, "IOException happens when trying to resolve the tiny url", "MOA:ResolvingTinyUrlIOException");
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        continue; /* Loop/switch isn't completed */
        obj;
        MAPLog.logAndReportError(TAG, tracer, "Unknown Exception happens when trying to resolve the tiny url", (new StringBuilder("MOA:ResolvingTinyUrlUnknownException:")).append(obj.getClass().getName()).toString());
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        if (true) goto _L2; else goto _L1
_L1:
        tracer;
        if (httpurlconnection != null)
        {
            httpurlconnection.disconnect();
        }
        throw tracer;
    }

}
