// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebView, AmazonUrlRequest, PrerenderStatus, AmazonHttpAuthHandler, 
//            AmazonSslErrorHandler, AmazonWebResourceResponse

public class AmazonWebViewClient
{

    public static final Pattern ACCEPTED_URI_SCHEMA = Pattern.compile("(?i)((?:http|https|file):\\/\\/|(?:inline|data|about|javascript):)(.*)");
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_OK = 0;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;

    public AmazonWebViewClient()
    {
    }

    public static boolean defaultShouldOverrideUrlLoading(AmazonWebView amazonwebview, String s)
    {
        while (amazonwebview == null || s == null || ACCEPTED_URI_SCHEMA.matcher(s).matches()) 
        {
            return false;
        }
        try
        {
            s = Intent.parseUri(s, 1);
            s.addCategory("android.intent.category.BROWSABLE");
            amazonwebview.getContext().startActivity(s);
        }
        // Misplaced declaration of an exception variable
        catch (AmazonWebView amazonwebview)
        {
            Log.e("AmazonWebViewClient", "Unable to Launch Application, check URI");
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (AmazonWebView amazonwebview)
        {
            Log.e("AmazonWebViewClient", "Unable to Launch Application");
            return false;
        }
        return true;
    }

    public void doUpdateVisitedHistory(AmazonWebView amazonwebview, String s, boolean flag)
    {
    }

    public void onBeforeUrlRequest(AmazonUrlRequest amazonurlrequest)
    {
    }

    public void onCompletedUrlRequest(AmazonUrlRequest amazonurlrequest)
    {
    }

    public void onDocumentLoadFinished(AmazonWebView amazonwebview)
    {
    }

    public void onFormResubmission(AmazonWebView amazonwebview, Message message, Message message1)
    {
    }

    public void onLoadResource(AmazonWebView amazonwebview, String s)
    {
    }

    public void onPageFinished(AmazonWebView amazonwebview, String s)
    {
    }

    public void onPageStarted(AmazonWebView amazonwebview, String s, Bitmap bitmap)
    {
    }

    public void onPrerenderingComplete(AmazonWebView amazonwebview, String s, String s1, PrerenderStatus prerenderstatus)
    {
    }

    public void onPrerenderingPageLoadFinished(AmazonWebView amazonwebview, String s, String s1)
    {
    }

    public void onPrerenderingStarted(AmazonWebView amazonwebview, String s, String s1)
    {
    }

    public void onReceivedError(AmazonWebView amazonwebview, int i, String s, String s1)
    {
    }

    public void onReceivedHttpAuthRequest(AmazonWebView amazonwebview, AmazonHttpAuthHandler amazonhttpauthhandler, String s, String s1)
    {
    }

    public void onReceivedLoginRequest(AmazonWebView amazonwebview, String s, String s1, String s2)
    {
    }

    public void onReceivedSslError(AmazonWebView amazonwebview, AmazonSslErrorHandler amazonsslerrorhandler, SslError sslerror)
    {
    }

    public void onScaleChanged(AmazonWebView amazonwebview, float f, float f1)
    {
    }

    public void onTooManyRedirects(AmazonWebView amazonwebview, Message message, Message message1)
    {
    }

    public void onUnhandledKeyEvent(AmazonWebView amazonwebview, KeyEvent keyevent)
    {
    }

    public boolean shouldAllowPrerender(String s, String s1)
    {
        return false;
    }

    public AmazonWebResourceResponse shouldInterceptRequest(AmazonWebView amazonwebview, String s)
    {
        return null;
    }

    public boolean shouldOverrideKeyEvent(AmazonWebView amazonwebview, KeyEvent keyevent)
    {
        return false;
    }

    public boolean shouldOverrideUrlLoading(AmazonWebView amazonwebview, String s)
    {
        return false;
    }

}
