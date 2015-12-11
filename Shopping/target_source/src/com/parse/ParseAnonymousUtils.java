// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.parse:
//            ParseUser, ParseTaskUtils, LogInCallback

public final class ParseAnonymousUtils
{

    static final String AUTH_TYPE = "anonymous";

    private ParseAnonymousUtils()
    {
    }

    static Map getAuthData()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("id", UUID.randomUUID().toString());
        return hashmap;
    }

    public static boolean isLinked(ParseUser parseuser)
    {
        return parseuser.isLinked("anonymous");
    }

    public static void logIn(LogInCallback logincallback)
    {
        ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(), logincallback);
    }

    public static j logInInBackground()
    {
        return ParseUser.logInWithInBackground("anonymous", getAuthData());
    }
}
