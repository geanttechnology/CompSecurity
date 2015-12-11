// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.support.v7.cu;
import com.parse.twitter.Twitter;

// Referenced classes of package com.parse:
//            TwitterAuthenticationProvider, ParseUser, ParseTaskUtils, ParseException, 
//            SaveCallback, LogInCallback

public final class ParseTwitterUtils
{

    private static boolean isInitialized;
    private static TwitterAuthenticationProvider provider;
    private static Twitter twitter;

    private ParseTwitterUtils()
    {
    }

    private static void checkInitialization()
    {
        if (!isInitialized)
        {
            throw new IllegalStateException("You must call ParseTwitterUtils.initialize() before using ParseTwitterUtils");
        } else
        {
            return;
        }
    }

    private static TwitterAuthenticationProvider getAuthenticationProvider()
    {
        if (provider == null)
        {
            provider = new TwitterAuthenticationProvider(getTwitter());
            ParseUser.registerAuthenticationProvider(provider);
        }
        return provider;
    }

    public static Twitter getTwitter()
    {
        if (twitter == null)
        {
            twitter = new Twitter("", "");
        }
        return twitter;
    }

    public static void initialize(String s, String s1)
    {
        getTwitter().setConsumerKey(s).setConsumerSecret(s1);
        getAuthenticationProvider();
        isInitialized = true;
    }

    public static boolean isLinked(ParseUser parseuser)
    {
        return parseuser.isLinked("twitter");
    }

    public static void link(ParseUser parseuser, Context context)
    {
        link(parseuser, context, null);
    }

    public static void link(ParseUser parseuser, Context context, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(linkInBackground(context, parseuser), savecallback, true);
    }

    public static void link(ParseUser parseuser, String s, String s1, String s2, String s3)
    {
        link(parseuser, s, s1, s2, s3, null);
    }

    public static void link(ParseUser parseuser, String s, String s1, String s2, String s3, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(linkInBackground(parseuser, s, s1, s2, s3), savecallback);
    }

    public static cu linkInBackground(Context context, ParseUser parseuser)
    {
        checkInitialization();
        return getAuthenticationProvider().setContext(context).linkAsync(parseuser);
    }

    public static cu linkInBackground(ParseUser parseuser, String s, String s1, String s2, String s3)
    {
        checkInitialization();
        TwitterAuthenticationProvider twitterauthenticationprovider = getAuthenticationProvider();
        return twitterauthenticationprovider.linkAsync(parseuser, twitterauthenticationprovider.getAuthData(s, s1, s2, s3));
    }

    public static void logIn(Context context, LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(context), logincallback, true);
    }

    public static void logIn(String s, String s1, String s2, String s3, LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(s, s1, s2, s3), logincallback);
    }

    public static cu logInInBackground(Context context)
    {
        checkInitialization();
        return getAuthenticationProvider().setContext(context).logInAsync();
    }

    public static cu logInInBackground(String s, String s1, String s2, String s3)
    {
        checkInitialization();
        TwitterAuthenticationProvider twitterauthenticationprovider = getAuthenticationProvider();
        return twitterauthenticationprovider.logInAsync(twitterauthenticationprovider.getAuthData(s, s1, s2, s3));
    }

    public static void unlink(ParseUser parseuser)
        throws ParseException
    {
        ParseTaskUtils.wait(unlinkInBackground(parseuser));
    }

    public static cu unlinkInBackground(ParseUser parseuser)
    {
        checkInitialization();
        return getAuthenticationProvider().unlinkAsync(parseuser);
    }

    public static void unlinkInBackground(ParseUser parseuser, SaveCallback savecallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(unlinkInBackground(parseuser), savecallback);
    }
}
