// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            AnonymousAuthenticationProvider, ParseUser, ParseTaskUtils, LogInCallback

public final class ParseAnonymousUtils
{

    static final String AUTH_TYPE = "anonymous";
    private static AnonymousAuthenticationProvider provider;

    private ParseAnonymousUtils()
    {
    }

    private static AnonymousAuthenticationProvider getProvider()
    {
        if (provider == null)
        {
            provider = new AnonymousAuthenticationProvider();
            ParseUser.registerAuthenticationProvider(provider);
        }
        return provider;
    }

    public static boolean isLinked(ParseUser parseuser)
    {
        return parseuser.isLinked("anonymous");
    }

    static ParseUser lazyLogIn()
    {
        AnonymousAuthenticationProvider anonymousauthenticationprovider = getProvider();
        return ParseUser.logInLazyUser(anonymousauthenticationprovider.getAuthType(), anonymousauthenticationprovider.getAuthData());
    }

    public static void logIn(LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(), logincallback);
    }

    public static cu logInInBackground()
    {
        return getProvider().logInAsync();
    }
}
