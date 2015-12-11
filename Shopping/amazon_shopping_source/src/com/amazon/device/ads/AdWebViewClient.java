// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.device.ads:
//            Log, AdView, AmazonDeviceLauncher

class AdWebViewClient extends WebViewClient
{
    static class AmazonMobileExecutor
        implements UrlExecutor
    {

        private final AdView adView;
        private final Context context;

        public boolean execute(String s)
        {
            specialUrlClicked(s);
            return true;
        }

        protected void handleApplicationDefinedSpecialURL(String s)
        {
            Log.i(AdWebViewClient.LOG_TAG, "Special url clicked, but was not handled by SDK. Url: %s", new Object[] {
                s
            });
        }

        protected boolean launchExternalActivity(String s)
        {
            Intent intent = new Intent();
            if (s.startsWith("intent:"))
            {
                try
                {
                    s = Intent.parseUri(s, 1);
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    return false;
                }
            } else
            {
                intent.setData(Uri.parse(s));
                s = intent;
            }
            try
            {
                s.setAction("android.intent.action.VIEW");
                s.addFlags(0x10000000);
                context.startActivity(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            return true;
        }

        public void specialUrlClicked(String s)
        {
            if (adView != null && adView.isAdViewRenderable()) goto _L2; else goto _L1
_L1:
            Log.d(AdWebViewClient.LOG_TAG, "AdView is Null");
_L4:
            return;
_L2:
            Object obj;
            Uri uri;
            Log.d(AdWebViewClient.LOG_TAG, "Executing AmazonMobile Intent");
            uri = Uri.parse(s);
            try
            {
                obj = uri.getQueryParameters("intent");
            }
            catch (UnsupportedOperationException unsupportedoperationexception)
            {
                unsupportedoperationexception = null;
            }
            if (obj != null && ((List) (obj)).size() > 0)
            {
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
                {
                    if (launchExternalActivity((String)((Iterator) (obj)).next()))
                    {
                        return;
                    }
                }

                handleApplicationDefinedSpecialURL(s);
                return;
            }
            if (!AmazonDeviceLauncher.isWindowshopPresent(context))
            {
                break MISSING_BLOCK_LABEL_233;
            }
            if (!uri.getHost().equals("shopping"))
            {
                continue; /* Loop/switch isn't completed */
            }
            unsupportedoperationexception = uri.getQueryParameter("app-action");
            if (unsupportedoperationexception == null || unsupportedoperationexception.length() == 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!unsupportedoperationexception.equals("detail"))
            {
                break; /* Loop/switch isn't completed */
            }
            s = uri.getQueryParameter("asin");
            if (s != null && s.length() != 0)
            {
                AmazonDeviceLauncher.launchWindowshopDetailPage(context, s);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (!unsupportedoperationexception.equals("search"))
            {
                continue; /* Loop/switch isn't completed */
            }
            s = uri.getQueryParameter("keyword");
            if (s == null || s.length() == 0) goto _L4; else goto _L5
_L5:
            AmazonDeviceLauncher.launchWindowshopSearchPage(context, s);
            return;
            if (!unsupportedoperationexception.equals("webview")) goto _L4; else goto _L6
_L6:
            handleApplicationDefinedSpecialURL(s);
            return;
            handleApplicationDefinedSpecialURL(s);
            return;
        }

        AmazonMobileExecutor(AdView adview, Context context1)
        {
            adView = adview;
            context = context1;
        }
    }

    class DefaultExecutor
        implements UrlExecutor
    {

        final AdWebViewClient this$0;

        public boolean execute(String s)
        {
            adView.launchExternalBrowserForLink(s);
            return true;
        }

        DefaultExecutor()
        {
            this$0 = AdWebViewClient.this;
            super();
        }
    }

    class IntentExecutor
        implements UrlExecutor
    {

        final AdWebViewClient this$0;

        public boolean execute(String s)
        {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            intent.addFlags(0x10000000);
            try
            {
                context.startActivity(intent);
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                Log.w(AdWebViewClient.LOG_TAG, "Could not handle intent with URI: %s", new Object[] {
                    s
                });
                return true;
            }
            return true;
        }

        IntentExecutor()
        {
            this$0 = AdWebViewClient.this;
            super();
        }
    }

    class MopubExecutor
        implements UrlExecutor
    {

        final AdWebViewClient this$0;

        public boolean execute(String s)
        {
            return true;
        }

        MopubExecutor()
        {
            this$0 = AdWebViewClient.this;
            super();
        }
    }

    static interface UrlExecutor
    {

        public abstract boolean execute(String s);
    }


    public static final String AMAZON_MOBILE = "amazonmobile";
    public static final String GEO = "geo";
    public static final String GOOGLE_STREETVIEW = "google.streetview";
    private static final String LOG_TAG = com/amazon/device/ads/AdWebViewClient.getSimpleName();
    public static final String MAILTO = "mailto";
    public static final String MOPUB = "mopub";
    public static final String MRAID = "mraid";
    public static final String SMS = "sms";
    public static final String TELEPHONE = "tel";
    public static final String VOICEMAIL = "voicemail";
    protected static final HashSet intentSchemes;
    protected static Set redirectHosts;
    private final AdView adView;
    private final Context context;
    private final HashMap urlExecutors = new HashMap();

    public AdWebViewClient(AdView adview, Context context1)
    {
        context = context1;
        adView = adview;
        setupUrlExecutors();
    }

    private static boolean isHoneycombVersion()
    {
        return android.os.Build.VERSION.SDK_INT >= 11 && android.os.Build.VERSION.SDK_INT <= 13;
    }

    private void setupUrlExecutors()
    {
        urlExecutors.put("mopub", new MopubExecutor());
        urlExecutors.put("amazonmobile", new AmazonMobileExecutor(adView, context));
        IntentExecutor intentexecutor = new IntentExecutor();
        for (Iterator iterator = intentSchemes.iterator(); iterator.hasNext(); putUrlExecutor((String)iterator.next(), intentexecutor)) { }
    }

    protected String getScheme(String s)
    {
        return Uri.parse(s).getScheme();
    }

    protected boolean interpretScheme(String s, String s1)
    {
label0:
        {
            boolean flag = false;
            if (s1 != null)
            {
                if (!urlExecutors.containsKey(s1))
                {
                    break label0;
                }
                flag = ((UrlExecutor)urlExecutors.get(s1)).execute(s);
            }
            return flag;
        }
        Log.d(LOG_TAG, "Scheme %s unrecognized. Launching external browser.", new Object[] {
            s1
        });
        return adView.launchExternalBrowserForLink(s);
    }

    public void onLoadResource(WebView webview, String s)
    {
        Log.d(LOG_TAG, "Loaded resource: %s", new Object[] {
            s
        });
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (adView == null)
        {
            Log.w(LOG_TAG, "Call to onPageFinished() ignored because view is null.");
            return;
        } else
        {
            adView.onPageFinished();
            return;
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Log.e(LOG_TAG, "Error: %s", new Object[] {
            s
        });
        super.onReceivedError(webview, i, s, s1);
    }

    public void putUrlExecutor(String s, UrlExecutor urlexecutor)
    {
        urlExecutors.put(s, urlexecutor);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        boolean flag;
        if (adView == null)
        {
            flag = false;
        } else
        {
            if (!adView.isAdViewRenderable())
            {
                return true;
            }
            webview = Uri.parse(s);
            boolean flag1 = true;
            flag = flag1;
            if (redirectHosts.contains(webview.getHost()))
            {
                flag = flag1;
                if (!isHoneycombVersion())
                {
                    flag = false;
                }
            }
            if (interpretScheme(s, getScheme(s)))
            {
                return true;
            }
        }
        return flag;
    }

    static 
    {
        intentSchemes = new HashSet();
        intentSchemes.add("tel");
        intentSchemes.add("voicemail");
        intentSchemes.add("sms");
        intentSchemes.add("mailto");
        intentSchemes.add("geo");
        intentSchemes.add("google.streetview");
        redirectHosts = new HashSet();
        redirectHosts.add("aax-us-east.amazon-adsystem.com");
        redirectHosts.add("aax-us-east.amazon-adsystem.com");
        redirectHosts.add("aax-beta.integ.amazon.com");
        redirectHosts.add("pda-bes.amazon.com");
        redirectHosts.add("d16g-cornerstone-bes.integ.amazon.com");
    }



}
