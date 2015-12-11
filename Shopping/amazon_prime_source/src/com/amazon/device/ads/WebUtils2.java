// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package com.amazon.device.ads:
//            WebUtils

class WebUtils2
{
    private static class WebUtilsStatic
    {

        String encloseHtml(String s, boolean flag)
        {
            return WebUtils.encloseHtml(s, flag);
        }

        void executeWebRequestInThread(String s, boolean flag)
        {
            WebUtils.executeWebRequestInThread(s, flag);
        }

        String getScheme(String s)
        {
            return WebUtils.getScheme(s);
        }

        String getURLDecodedString(String s)
        {
            return WebUtils.getURLDecodedString(s);
        }

        String getURLEncodedString(String s)
        {
            return WebUtils.getURLEncodedString(s);
        }

        boolean launchActivityForIntentLink(String s, Context context)
        {
            return WebUtils.launchActivityForIntentLink(s, context);
        }

        private WebUtilsStatic()
        {
        }

    }


    private final WebUtilsStatic webUtilsAdapter = new WebUtilsStatic();

    WebUtils2()
    {
    }

    String encloseHtml(String s, boolean flag)
    {
        return webUtilsAdapter.encloseHtml(s, flag);
    }

    void executeWebRequestInThread(String s, boolean flag)
    {
        webUtilsAdapter.executeWebRequestInThread(s, flag);
    }

    String getScheme(String s)
    {
        return webUtilsAdapter.getScheme(s);
    }

    String getURLDecodedString(String s)
    {
        return webUtilsAdapter.getURLDecodedString(s);
    }

    String getURLEncodedString(String s)
    {
        return webUtilsAdapter.getURLEncodedString(s);
    }

    boolean isUrlValid(String s)
    {
        try
        {
            new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    boolean launchActivityForIntentLink(String s, Context context)
    {
        return webUtilsAdapter.launchActivityForIntentLink(s, context);
    }
}
