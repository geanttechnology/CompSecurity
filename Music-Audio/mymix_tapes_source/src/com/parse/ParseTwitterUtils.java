// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import bolts.Task;
import com.parse.twitter.Twitter;
import java.util.Set;
import org.json.JSONException;

// Referenced classes of package com.parse:
//            TwitterAuthenticationProvider, ParseUser, Parse, ParseException, 
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
        getTwitter().setConsumerKey(s);
        getTwitter().setConsumerSecret(s1);
        ParseUser.registerAuthenticationProvider(getAuthenticationProvider());
        isInitialized = true;
    }

    public static boolean isLinked(ParseUser parseuser)
    {
        return parseuser.getLinkedServiceNames().contains(getAuthenticationProvider().getAuthType());
    }

    public static void link(ParseUser parseuser, Context context)
    {
        link(parseuser, context, null);
    }

    public static void link(ParseUser parseuser, Context context, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(linkInBackground(context, parseuser), savecallback, true);
    }

    public static void link(ParseUser parseuser, String s, String s1, String s2, String s3)
    {
        link(parseuser, s, s1, s2, s3, null);
    }

    public static void link(ParseUser parseuser, String s, String s1, String s2, String s3, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(linkInBackground(parseuser, s, s1, s2, s3), savecallback);
    }

    public static Task linkInBackground(Context context, ParseUser parseuser)
    {
        checkInitialization();
        getAuthenticationProvider().setContext(context);
        return parseuser.linkWithAsync(getAuthenticationProvider().getAuthType());
    }

    public static Task linkInBackground(ParseUser parseuser, String s, String s1, String s2, String s3)
    {
        checkInitialization();
        try
        {
            parseuser = parseuser.linkWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(s, s1, s2, s3));
        }
        // Misplaced declaration of an exception variable
        catch (ParseUser parseuser)
        {
            return Task.forError(new ParseException(parseuser));
        }
        return parseuser;
    }

    public static void logIn(Context context, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(context), logincallback, true);
    }

    public static void logIn(String s, String s1, String s2, String s3, LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(s, s1, s2, s3), logincallback);
    }

    public static Task logInInBackground(Context context)
    {
        checkInitialization();
        getAuthenticationProvider().setContext(context);
        return ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType());
    }

    public static Task logInInBackground(String s, String s1, String s2, String s3)
    {
        checkInitialization();
        try
        {
            s = ParseUser.logInWithAsync(getAuthenticationProvider().getAuthType(), getAuthenticationProvider().getAuthData(s, s1, s2, s3));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return Task.forError(new ParseException(s));
        }
        return s;
    }

    public static void unlink(ParseUser parseuser)
        throws ParseException
    {
        Parse.waitForTask(unlinkInBackground(parseuser));
    }

    public static Task unlinkInBackground(ParseUser parseuser)
    {
        checkInitialization();
        return parseuser.unlinkFromAsync(getAuthenticationProvider().getAuthType());
    }

    public static void unlinkInBackground(ParseUser parseuser, SaveCallback savecallback)
    {
        Parse.callbackOnMainThreadAsync(unlinkInBackground(parseuser), savecallback);
    }
}
