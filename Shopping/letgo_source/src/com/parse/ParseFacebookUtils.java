// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.cu;
import com.facebook.AccessToken;
import java.util.Collection;
import java.util.Collections;

// Referenced classes of package com.parse:
//            FacebookAuthenticationProvider, ParseUser, ParseTaskUtils, SaveCallback, 
//            LogInCallback

public final class ParseFacebookUtils
{

    static boolean isInitialized;
    static FacebookAuthenticationProvider provider;

    private ParseFacebookUtils()
    {
    }

    private static void checkInitialization()
    {
        if (!isInitialized)
        {
            throw new IllegalStateException("You must call ParseFacebookUtils.initialize() before using ParseFacebookUtils");
        } else
        {
            return;
        }
    }

    public static void initialize(Context context)
    {
        initialize(context, 64206);
    }

    public static void initialize(Context context, int i)
    {
        provider = new FacebookAuthenticationProvider(context, i);
        ParseUser.registerAuthenticationProvider(provider);
        isInitialized = true;
    }

    public static boolean isLinked(ParseUser parseuser)
    {
        return parseuser.isLinked("facebook");
    }

    private static cu linkAsync(ParseUser parseuser, Activity activity, Fragment fragment, Collection collection, FacebookAuthenticationProvider.LoginAuthorizationType loginauthorizationtype)
    {
        Object obj;
        checkInitialization();
        obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        if (activity == null) goto _L2; else goto _L1
_L1:
        provider.setActivity(activity);
_L4:
        return provider.setPermissions(((Collection) (obj))).setLoginAuthorizationType(loginauthorizationtype).linkAsync(parseuser);
_L2:
        if (fragment != null)
        {
            provider.setFragment(fragment);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static cu linkInBackground(ParseUser parseuser, AccessToken accesstoken)
    {
        checkInitialization();
        return provider.linkAsync(parseuser, provider.getAuthData(accesstoken));
    }

    public static cu linkInBackground(ParseUser parseuser, AccessToken accesstoken, SaveCallback savecallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(linkInBackground(parseuser, accesstoken), savecallback, true);
    }

    public static cu linkWithPublishPermissionsInBackground(ParseUser parseuser, Activity activity, Collection collection)
    {
        return linkAsync(parseuser, activity, null, collection, FacebookAuthenticationProvider.LoginAuthorizationType.PUBLISH);
    }

    public static cu linkWithPublishPermissionsInBackground(ParseUser parseuser, Activity activity, Collection collection, SaveCallback savecallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(linkWithPublishPermissionsInBackground(parseuser, activity, collection), savecallback, true);
    }

    public static cu linkWithPublishPermissionsInBackground(ParseUser parseuser, Fragment fragment, Collection collection)
    {
        return linkAsync(parseuser, null, fragment, collection, FacebookAuthenticationProvider.LoginAuthorizationType.PUBLISH);
    }

    public static cu linkWithPublishPermissionsInBackground(ParseUser parseuser, Fragment fragment, Collection collection, SaveCallback savecallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(linkWithPublishPermissionsInBackground(parseuser, fragment, collection), savecallback, true);
    }

    public static cu linkWithReadPermissionsInBackground(ParseUser parseuser, Activity activity, Collection collection)
    {
        return linkAsync(parseuser, activity, null, collection, FacebookAuthenticationProvider.LoginAuthorizationType.READ);
    }

    public static cu linkWithReadPermissionsInBackground(ParseUser parseuser, Activity activity, Collection collection, SaveCallback savecallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(linkWithReadPermissionsInBackground(parseuser, activity, collection), savecallback, true);
    }

    public static cu linkWithReadPermissionsInBackground(ParseUser parseuser, Fragment fragment, Collection collection)
    {
        return linkAsync(parseuser, null, fragment, collection, FacebookAuthenticationProvider.LoginAuthorizationType.READ);
    }

    public static cu linkWithReadPermissionsInBackground(ParseUser parseuser, Fragment fragment, Collection collection, SaveCallback savecallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(linkWithReadPermissionsInBackground(parseuser, fragment, collection), savecallback, true);
    }

    private static cu logInAsync(Activity activity, Fragment fragment, Collection collection, FacebookAuthenticationProvider.LoginAuthorizationType loginauthorizationtype)
    {
        Object obj;
        checkInitialization();
        obj = collection;
        if (collection == null)
        {
            obj = Collections.emptyList();
        }
        if (activity == null) goto _L2; else goto _L1
_L1:
        provider.setActivity(activity);
_L4:
        return provider.setPermissions(((Collection) (obj))).setLoginAuthorizationType(loginauthorizationtype).logInAsync();
_L2:
        if (fragment != null)
        {
            provider.setFragment(fragment);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static cu logInInBackground(AccessToken accesstoken)
    {
        checkInitialization();
        return provider.logInAsync(provider.getAuthData(accesstoken));
    }

    public static cu logInInBackground(AccessToken accesstoken, LogInCallback logincallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(logInInBackground(accesstoken), logincallback, true);
    }

    public static cu logInWithPublishPermissionsInBackground(Activity activity, Collection collection)
    {
        return logInAsync(activity, null, collection, FacebookAuthenticationProvider.LoginAuthorizationType.PUBLISH);
    }

    public static cu logInWithPublishPermissionsInBackground(Activity activity, Collection collection, LogInCallback logincallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(logInWithPublishPermissionsInBackground(activity, collection), logincallback, true);
    }

    public static cu logInWithPublishPermissionsInBackground(Fragment fragment, Collection collection)
    {
        return logInAsync(null, fragment, collection, FacebookAuthenticationProvider.LoginAuthorizationType.PUBLISH);
    }

    public static cu logInWithPublishPermissionsInBackground(Fragment fragment, Collection collection, LogInCallback logincallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(logInWithPublishPermissionsInBackground(fragment, collection), logincallback, true);
    }

    public static cu logInWithReadPermissionsInBackground(Activity activity, Collection collection)
    {
        return logInAsync(activity, null, collection, FacebookAuthenticationProvider.LoginAuthorizationType.READ);
    }

    public static cu logInWithReadPermissionsInBackground(Activity activity, Collection collection, LogInCallback logincallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(logInWithReadPermissionsInBackground(activity, collection), logincallback, true);
    }

    public static cu logInWithReadPermissionsInBackground(Fragment fragment, Collection collection)
    {
        return logInAsync(null, fragment, collection, FacebookAuthenticationProvider.LoginAuthorizationType.READ);
    }

    public static cu logInWithReadPermissionsInBackground(Fragment fragment, Collection collection, LogInCallback logincallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(logInWithReadPermissionsInBackground(fragment, collection), logincallback, true);
    }

    public static boolean onActivityResult(int i, int j, Intent intent)
    {
        if (provider != null)
        {
            return provider.onActivityResult(i, j, intent);
        } else
        {
            return false;
        }
    }

    public static cu unlinkInBackground(ParseUser parseuser)
    {
        checkInitialization();
        return provider.unlinkAsync(parseuser);
    }

    public static cu unlinkInBackground(ParseUser parseuser, SaveCallback savecallback)
    {
        return ParseTaskUtils.callbackOnMainThreadAsync(unlinkInBackground(parseuser), savecallback);
    }
}
