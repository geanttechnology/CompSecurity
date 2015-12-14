// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class WebUtils
{
    static class WebUtilsExecutor
    {

        String getURLEncodedString(String s)
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
                String _tmp = WebUtils.LOGTAG;
                return s;
            }
            return s1;
        }

        WebUtilsExecutor()
        {
        }
    }


    private static final String LOGTAG = com/amazon/device/ads/identity/WebUtils.getSimpleName();
    private static WebUtilsExecutor executor = new WebUtilsExecutor();

    private WebUtils()
    {
    }

    public static final String getURLEncodedString(String s)
    {
        return executor.getURLEncodedString(s);
    }


}
