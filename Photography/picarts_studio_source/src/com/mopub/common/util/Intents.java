// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import java.util.List;

public class Intents
{

    private Intents()
    {
    }

    public static boolean canHandleApplicationUrl(Context context, Uri uri)
    {
        return canHandleApplicationUrl(context, uri, true);
    }

    public static boolean canHandleApplicationUrl(Context context, Uri uri, boolean flag)
    {
        if (!deviceCanHandleIntent(context, new Intent("android.intent.action.VIEW", uri)))
        {
            if (flag)
            {
                MoPubLog.w((new StringBuilder("Could not handle application specific action: ")).append(uri).append(". You may be running in the emulator or another device which does not have the required application.").toString());
            }
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean deviceCanHandleIntent(Context context, Intent intent)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            flag1 = context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (!flag1)
        {
            flag = true;
        }
        return flag;
    }

    public static Intent getStartActivityIntent(Context context, Class class1, Bundle bundle)
    {
        class1 = new Intent(context, class1);
        if (!(context instanceof Activity))
        {
            class1.addFlags(0x10000000);
        }
        if (bundle != null)
        {
            class1.putExtras(bundle);
        }
        return class1;
    }

    public static Intent intentForNativeBrowserScheme(Uri uri)
    {
        Preconditions.checkNotNull(uri);
        if (!UrlAction.OPEN_NATIVE_BROWSER.shouldTryHandlingUrl(uri))
        {
            throw new UrlParseException("URL does not have mopubnativebrowser:// scheme.");
        }
        if (!"navigate".equals(uri.getHost()))
        {
            throw new UrlParseException("URL missing 'navigate' host parameter.");
        }
        Object obj;
        try
        {
            obj = uri.getQueryParameter("url");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MoPubLog.w((new StringBuilder("Could not handle url: ")).append(uri).toString());
            throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
        }
        if (obj == null)
        {
            throw new UrlParseException("URL missing 'url' query parameter.");
        } else
        {
            return new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
        }
    }

    public static Intent intentForShareTweet(Uri uri)
    {
        if (!UrlAction.HANDLE_SHARE_TWEET.shouldTryHandlingUrl(uri))
        {
            throw new UrlParseException("URL does not have mopubshare://tweet? format.");
        }
        Object obj;
        String s;
        try
        {
            obj = uri.getQueryParameter("screen_name");
            s = uri.getQueryParameter("tweet_id");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            MoPubLog.w((new StringBuilder("Could not handle url: ")).append(uri).toString());
            throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
        }
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            throw new UrlParseException("URL missing non-empty 'screen_name' query parameter.");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new UrlParseException("URL missing non-empty 'tweet_id' query parameter.");
        } else
        {
            uri = String.format("Check out @%s's Tweet: %s", new Object[] {
                obj, String.format("https://twitter.com/%s/status/%s", new Object[] {
                    obj, s
                })
            });
            obj = new Intent("android.intent.action.SEND");
            ((Intent) (obj)).setType("text/plain");
            ((Intent) (obj)).putExtra("android.intent.extra.SUBJECT", uri);
            ((Intent) (obj)).putExtra("android.intent.extra.TEXT", uri);
            return ((Intent) (obj));
        }
    }

    public static void launchActionViewIntent(Context context, Uri uri, String s)
    {
        uri = new Intent("android.intent.action.VIEW", uri);
        if (!(context instanceof Activity))
        {
            uri.addFlags(0x10000000);
        }
        launchIntentForUserClick(context, uri, s);
    }

    public static void launchApplicationUrl(Context context, Uri uri)
    {
        if (canHandleApplicationUrl(context, uri))
        {
            launchActionViewIntent(context, uri, (new StringBuilder("Unable to open intent for: ")).append(uri).toString());
            return;
        } else
        {
            throw new IntentNotResolvableException((new StringBuilder("Could not handle application specific action: ")).append(uri).append("\n\tYou may be running in the emulator or another device which does not have the required application.").toString());
        }
    }

    public static void launchIntentForUserClick(Context context, Intent intent, String s)
    {
        com.mopub.common.Preconditions.NoThrow.checkNotNull(context);
        com.mopub.common.Preconditions.NoThrow.checkNotNull(intent);
        try
        {
            startActivity(context, intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IntentNotResolvableException((new StringBuilder()).append(s).append("\n").append(context.getMessage()).toString());
        }
    }

    public static void showMoPubBrowserForUrl(Context context, Uri uri)
    {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(uri);
        MoPubLog.d((new StringBuilder("Final URI to show in browser: ")).append(uri).toString());
        Bundle bundle = new Bundle();
        bundle.putString("URL", uri.toString());
        launchIntentForUserClick(context, getStartActivityIntent(context, com/mopub/common/MoPubBrowser, bundle), (new StringBuilder("Could not show MoPubBrowser for url: ")).append(uri).append("\n\tPerhaps you forgot to declare com.mopub.common.MoPubBrowser in your Android manifest file.").toString());
    }

    public static void startActivity(Context context, Intent intent)
    {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(intent);
        if (!(context instanceof Activity))
        {
            intent.addFlags(0x10000000);
        }
        try
        {
            context.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IntentNotResolvableException(context);
        }
    }
}
