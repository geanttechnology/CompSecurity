// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.UserManager;

public class UserManagerImpl
    implements UserManager
{

    private final Context context;

    public UserManagerImpl(Context context1)
    {
        context = context1;
    }

    private String getAccountKey(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "default_account_key";
        }
        return s1;
    }

    public Endpoint getStoredEndpointFromSharedPreferences(String s)
    {
        Object obj = null;
        s = getAccountKey(s);
        String s1 = context.getSharedPreferences("galleryKindleSharedPrefs", 0).getString((new StringBuilder()).append("endpointUrl").append(s).toString(), null);
        s = obj;
        if (s1 != null)
        {
            s = new Endpoint(s1, false);
        }
        return s;
    }

    public void removeEndpointSharedPreferences(String s)
    {
        s = getAccountKey(s);
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().remove((new StringBuilder()).append("endpointUrl").append(s).toString()).apply();
    }

    public void storeEndpointInSharedPreferences(String s, Endpoint endpoint)
    {
        s = getAccountKey(s);
        context.getSharedPreferences("galleryKindleSharedPrefs", 0).edit().putString((new StringBuilder()).append("endpointUrl").append(s).toString(), endpoint.getEndpoint()).apply();
    }
}
