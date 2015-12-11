// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.network.TrackingRequest;

// Referenced classes of package com.mopub.common:
//            UrlHandler, Preconditions

public abstract class UrlAction extends Enum
{

    private static final UrlAction $VALUES[];
    public static final UrlAction FOLLOW_DEEP_LINK;
    public static final UrlAction FOLLOW_DEEP_LINK_WITH_FALLBACK;
    public static final UrlAction HANDLE_MOPUB_SCHEME;
    public static final UrlAction HANDLE_PHONE_SCHEME;
    public static final UrlAction HANDLE_SHARE_TWEET;
    public static final UrlAction IGNORE_ABOUT_SCHEME;
    public static final UrlAction NOOP;
    public static final UrlAction OPEN_APP_MARKET;
    public static final UrlAction OPEN_IN_APP_BROWSER;
    public static final UrlAction OPEN_NATIVE_BROWSER;
    private final boolean mRequiresUserInteraction;

    private UrlAction(String s, int i, boolean flag)
    {
        super(s, i);
        mRequiresUserInteraction = flag;
    }


    public static UrlAction valueOf(String s)
    {
        return (UrlAction)Enum.valueOf(com/mopub/common/UrlAction, s);
    }

    public static UrlAction[] values()
    {
        return (UrlAction[])$VALUES.clone();
    }

    public void handleUrl(UrlHandler urlhandler, Context context, Uri uri, boolean flag)
        throws IntentNotResolvableException
    {
        MoPubLog.d((new StringBuilder()).append("Ad event URL: ").append(uri).toString());
        if (mRequiresUserInteraction && !flag)
        {
            throw new IntentNotResolvableException("Attempted to handle action without user interaction.");
        } else
        {
            performAction(context, uri, urlhandler);
            return;
        }
    }

    protected abstract void performAction(Context context, Uri uri, UrlHandler urlhandler)
        throws IntentNotResolvableException;

    public abstract boolean shouldTryHandlingUrl(Uri uri);

    static 
    {
        HANDLE_MOPUB_SCHEME = new UrlAction("HANDLE_MOPUB_SCHEME", 0, false) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                context = uri.getHost();
                urlhandler = urlhandler.getMoPubSchemeListener();
                if ("finishLoad".equals(context))
                {
                    urlhandler.onFinishLoad();
                    return;
                }
                if ("close".equals(context))
                {
                    urlhandler.onClose();
                    return;
                }
                if ("failLoad".equals(context))
                {
                    urlhandler.onFailLoad();
                    return;
                } else
                {
                    throw new IntentNotResolvableException((new StringBuilder()).append("Could not handle MoPub Scheme url: ").append(uri).toString());
                }
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                return "mopub".equals(uri.getScheme());
            }

        };
        IGNORE_ABOUT_SCHEME = new UrlAction("IGNORE_ABOUT_SCHEME", 1, false) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                MoPubLog.d("Link to about page ignored.");
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                return "about".equals(uri.getScheme());
            }

        };
        HANDLE_PHONE_SCHEME = new UrlAction("HANDLE_PHONE_SCHEME", 2, true) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                Intents.launchActionViewIntent(context, uri, (new StringBuilder()).append("Could not handle intent with URI: ").append(uri).append("\n\tIs ").append("this intent supported on your phone?").toString());
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                uri = uri.getScheme();
                return "tel".equals(uri) || "voicemail".equals(uri) || "sms".equals(uri) || "mailto".equals(uri) || "geo".equals(uri) || "google.streetview".equals(uri);
            }

        };
        OPEN_NATIVE_BROWSER = new UrlAction("OPEN_NATIVE_BROWSER", 3, true) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                urlhandler = (new StringBuilder()).append("Unable to load mopub native browser url: ").append(uri).toString();
                try
                {
                    Intents.launchIntentForUserClick(context, Intents.intentForNativeBrowserScheme(uri), urlhandler);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new IntentNotResolvableException((new StringBuilder()).append(urlhandler).append("\n\t").append(context.getMessage()).toString());
                }
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                return "mopubnativebrowser".equals(uri.getScheme());
            }

        };
        OPEN_APP_MARKET = new UrlAction("OPEN_APP_MARKET", 4, true) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                Intents.launchApplicationUrl(context, uri);
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                String s = uri.getScheme();
                String s1 = uri.getHost();
                return "play.google.com".equals(s1) || "market.android.com".equals(s1) || "market".equals(s) || uri.toString().startsWith("play.google.com/") || uri.toString().startsWith("market.android.com/");
            }

        };
        OPEN_IN_APP_BROWSER = new UrlAction("OPEN_IN_APP_BROWSER", 5, true) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                if (!urlhandler.shouldSkipShowMoPubBrowser())
                {
                    Intents.showMoPubBrowserForUrl(context, uri);
                }
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                uri = uri.getScheme();
                return "http".equals(uri) || "https".equals(uri);
            }

        };
        HANDLE_SHARE_TWEET = new UrlAction("HANDLE_SHARE_TWEET", 6, true) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                Preconditions.checkNotNull(context);
                Preconditions.checkNotNull(uri);
                urlhandler = (new StringBuilder()).append("Could not handle share tweet intent with URI ").append(uri).toString();
                try
                {
                    Intents.launchIntentForUserClick(context, Intent.createChooser(Intents.intentForShareTweet(uri), "Share via"), urlhandler);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new IntentNotResolvableException((new StringBuilder()).append(urlhandler).append("\n\t").append(context.getMessage()).toString());
                }
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                Preconditions.checkNotNull(uri);
                return "mopubshare".equals(uri.getScheme()) && "tweet".equals(uri.getHost());
            }

        };
        FOLLOW_DEEP_LINK_WITH_FALLBACK = new UrlAction("FOLLOW_DEEP_LINK_WITH_FALLBACK", 7, true) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                if (!"navigate".equalsIgnoreCase(uri.getHost()))
                {
                    throw new IntentNotResolvableException("Deeplink+ URL did not have 'navigate' as the host.");
                }
                String s;
                java.util.List list;
                Object obj;
                try
                {
                    obj = uri.getQueryParameter("primaryUrl");
                    list = uri.getQueryParameters("primaryTrackingUrl");
                    s = uri.getQueryParameter("fallbackUrl");
                    uri = uri.getQueryParameters("fallbackTrackingUrl");
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    throw new IntentNotResolvableException("Deeplink+ URL was not a hierarchical URI.");
                }
                if (obj == null)
                {
                    throw new IntentNotResolvableException("Deeplink+ did not have 'primaryUrl' query param.");
                }
                obj = Uri.parse(((String) (obj)));
                if (shouldTryHandlingUrl(((Uri) (obj))))
                {
                    throw new IntentNotResolvableException("Deeplink+ had another Deeplink+ as the 'primaryUrl'.");
                }
                try
                {
                    Intents.launchApplicationUrl(context, ((Uri) (obj)));
                    TrackingRequest.makeTrackingHttpRequest(list, context, com.mopub.common.event.BaseEvent.Name.CLICK_REQUEST);
                    return;
                }
                catch (IntentNotResolvableException intentnotresolvableexception) { }
                if (s == null)
                {
                    throw new IntentNotResolvableException("Unable to handle 'primaryUrl' for Deeplink+ and 'fallbackUrl' was missing.");
                }
                if (shouldTryHandlingUrl(Uri.parse(s)))
                {
                    throw new IntentNotResolvableException("Deeplink+ URL had another Deeplink+ URL as the 'fallbackUrl'.");
                } else
                {
                    urlhandler.handleUrl(context, s, true, uri);
                    return;
                }
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                return "deeplink+".equalsIgnoreCase(uri.getScheme());
            }

        };
        FOLLOW_DEEP_LINK = new UrlAction("FOLLOW_DEEP_LINK", 8, true) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
                Intents.launchApplicationUrl(context, uri);
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                String s = uri.getScheme();
                uri = uri.getHost();
                return !TextUtils.isEmpty(s) && !TextUtils.isEmpty(uri);
            }

        };
        NOOP = new UrlAction("NOOP", 9, false) {

            protected void performAction(Context context, Uri uri, UrlHandler urlhandler)
                throws IntentNotResolvableException
            {
            }

            public boolean shouldTryHandlingUrl(Uri uri)
            {
                return false;
            }

        };
        $VALUES = (new UrlAction[] {
            HANDLE_MOPUB_SCHEME, IGNORE_ABOUT_SCHEME, HANDLE_PHONE_SCHEME, OPEN_NATIVE_BROWSER, OPEN_APP_MARKET, OPEN_IN_APP_BROWSER, HANDLE_SHARE_TWEET, FOLLOW_DEEP_LINK_WITH_FALLBACK, FOLLOW_DEEP_LINK, NOOP
        });
    }
}
