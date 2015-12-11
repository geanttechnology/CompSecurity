// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.richpush.RichPushMessage;
import com.urbanairship.richpush.RichPushUser;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.urbanairship.widget:
//            UAWebViewClient

public class UAWebView extends WebView
{

    private static final String CACHE_DIRECTORY = "urbanairship";
    private String currentClientAuthRequestUrl;
    private RichPushMessage currentMessage;
    private WebViewClient webViewClient;

    public UAWebView(Context context)
    {
        this(context, null);
    }

    public UAWebView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0x1010085);
    }

    public UAWebView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        if (!isInEditMode())
        {
            init(context, attributeset, i, 0);
        }
    }

    public UAWebView(Context context, AttributeSet attributeset, int i, int j)
    {
        super(context, attributeset, i, j);
        if (!isInEditMode())
        {
            init(context, attributeset, i, j);
        }
    }

    private String createBasicAuth(String s, String s1)
    {
        s = (new StringBuilder()).append(s).append(":").append(s1).toString();
        return (new StringBuilder("Basic ")).append(Base64.encodeToString(s.getBytes(), 2)).toString();
    }

    private String getCachePath()
    {
        File file = new File(UAirship.getApplicationContext().getCacheDir(), "urbanairship");
        if (!file.exists())
        {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private void init(Context context, AttributeSet attributeset, int i, int j)
    {
        WebSettings websettings;
        websettings = getSettings();
        if (android.os.Build.VERSION.SDK_INT >= 7)
        {
            websettings.setAppCacheEnabled(true);
            websettings.setAppCachePath(getCachePath());
            websettings.setDomStorageEnabled(true);
        }
        if (android.os.Build.VERSION.SDK_INT < 21 || attributeset == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        context = context.getTheme().obtainStyledAttributes(attributeset, com.urbanairship.R.styleable.UAWebView, i, j);
        websettings.setMixedContentMode(context.getInteger(com.urbanairship.R.styleable.UAWebView_mixed_content_mode, 2));
        context.recycle();
        websettings.setAllowFileAccess(true);
        websettings.setJavaScriptEnabled(true);
        websettings.setCacheMode(-1);
        initializeView();
        populateCustomJavascriptInterfaces();
        return;
        attributeset;
        context.recycle();
        throw attributeset;
    }

    private void onPreLoad()
    {
        currentMessage = null;
        if (getWebViewClient() == null)
        {
            Logger.info("No web view client set, setting a default UAWebViewClient for landing page view.");
            setWebViewClient(new UAWebViewClient());
        }
        if (currentClientAuthRequestUrl != null && getWebViewClient() != null && (getWebViewClient() instanceof UAWebViewClient))
        {
            ((UAWebViewClient)getWebViewClient()).removeAuthRequestCredentials(currentClientAuthRequestUrl);
            currentClientAuthRequestUrl = null;
        }
    }

    private void setClientAuthRequest(String s, String s1, String s2)
    {
        if (s != null)
        {
            currentClientAuthRequestUrl = s;
            if (getWebViewClient() != null && (getWebViewClient() instanceof UAWebViewClient))
            {
                ((UAWebViewClient)getWebViewClient()).addAuthRequestCredentials(Uri.parse(s).getHost(), s1, s2);
                return;
            }
        }
    }

    public RichPushMessage getCurrentMessage()
    {
        return currentMessage;
    }

    WebViewClient getWebViewClient()
    {
        return webViewClient;
    }

    protected void initializeView()
    {
    }

    public void loadData(String s, String s1, String s2)
    {
        onPreLoad();
        super.loadData(s, s1, s2);
    }

    public void loadDataWithBaseURL(String s, String s1, String s2, String s3, String s4)
    {
        onPreLoad();
        super.loadDataWithBaseURL(s, s1, s2, s3, s4);
    }

    public void loadRichPushMessage(RichPushMessage richpushmessage)
    {
        if (richpushmessage == null)
        {
            Logger.warn("Unable to load null message into UAWebView");
            return;
        }
        RichPushUser richpushuser = UAirship.shared().getRichPushManager().getRichPushUser();
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("Authorization", createBasicAuth(richpushuser.getId(), richpushuser.getPassword()));
            loadUrl(richpushmessage.getMessageBodyUrl(), hashmap);
        } else
        {
            loadUrl(richpushmessage.getMessageBodyUrl());
        }
        currentMessage = richpushmessage;
        setClientAuthRequest(richpushmessage.getMessageBodyUrl(), richpushuser.getId(), richpushuser.getPassword());
    }

    public void loadUrl(String s)
    {
        onPreLoad();
        if (s != null && s.startsWith(UAirship.shared().getAirshipConfigOptions().landingPageContentURL))
        {
            AirshipConfigOptions airshipconfigoptions1;
            if (android.os.Build.VERSION.SDK_INT >= 8)
            {
                AirshipConfigOptions airshipconfigoptions = UAirship.shared().getAirshipConfigOptions();
                HashMap hashmap = new HashMap();
                hashmap.put("Authorization", createBasicAuth(airshipconfigoptions.getAppKey(), airshipconfigoptions.getAppSecret()));
                super.loadUrl(s, hashmap);
            } else
            {
                super.loadUrl(s);
            }
            airshipconfigoptions1 = UAirship.shared().getAirshipConfigOptions();
            setClientAuthRequest(s, airshipconfigoptions1.getAppKey(), airshipconfigoptions1.getAppSecret());
            return;
        } else
        {
            super.loadUrl(s);
            return;
        }
    }

    public void loadUrl(String s, Map map)
    {
        onPreLoad();
        super.loadUrl(s, map);
        if (s != null && s.startsWith(UAirship.shared().getAirshipConfigOptions().landingPageContentURL))
        {
            map = UAirship.shared().getAirshipConfigOptions();
            setClientAuthRequest(s, map.getAppKey(), map.getAppSecret());
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            int i = getScrollY();
            int j = getScrollX();
            onScrollChanged(j, i, j, i);
        }
        return super.onTouchEvent(motionevent);
    }

    protected void populateCustomJavascriptInterfaces()
    {
    }

    public void setWebViewClient(WebViewClient webviewclient)
    {
        if (!(webviewclient instanceof UAWebViewClient))
        {
            Logger.warn("The web view client should extend UAWebViewClient to support urban airship url overrides and triggering actions from.");
        }
        webViewClient = webviewclient;
        super.setWebViewClient(webviewclient);
    }
}
