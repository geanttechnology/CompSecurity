// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Task;
import java.util.Set;
import org.json.JSONException;

// Referenced classes of package com.parse:
//            AnonymousAuthenticationProvider, ParseUser, Parse, LogInCallback

public final class ParseAnonymousUtils
{

    static final String AUTH_TYPE_ANONYMOUS = "anonymous";
    static final String SERVICE_NAME_ANONYMOUS = "anonymous";
    private static AnonymousAuthenticationProvider provider;

    private ParseAnonymousUtils()
    {
    }

    static void initialize()
    {
        if (provider == null)
        {
            provider = new AnonymousAuthenticationProvider();
            ParseUser.registerAuthenticationProvider(provider);
        }
    }

    public static boolean isLinked(ParseUser parseuser)
    {
        return parseuser.getLinkedServiceNames().contains("anonymous");
    }

    static ParseUser lazyLogIn()
    {
        ParseUser parseuser;
        try
        {
            parseuser = ParseUser.logInLazyUser(provider.getAuthType(), provider.getAuthData());
        }
        catch (JSONException jsonexception)
        {
            throw new RuntimeException(jsonexception);
        }
        return parseuser;
    }

    public static void logIn(LogInCallback logincallback)
    {
        Parse.callbackOnMainThreadAsync(logInInBackground(), logincallback);
    }

    public static Task logInInBackground()
    {
        return ParseUser.logInWithAsync(provider.getAuthType());
    }
}
