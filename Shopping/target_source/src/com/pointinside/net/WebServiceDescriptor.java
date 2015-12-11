// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net;

import android.net.Uri;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;

public class WebServiceDescriptor
{

    public final String apiKey;
    public final Uri baseUri;
    public final String password;
    public final String username;

    public WebServiceDescriptor(Uri uri)
    {
        this(uri, null, null);
    }

    public WebServiceDescriptor(Uri uri, String s)
    {
        this(uri, null, null, s);
    }

    public WebServiceDescriptor(Uri uri, String s, String s1)
    {
        this(uri, s, s1, null);
    }

    public WebServiceDescriptor(Uri uri, String s, String s1, String s2)
    {
        baseUri = uri;
        username = s;
        password = s1;
        apiKey = s2;
    }

    public AuthScope getAuthScope()
    {
        return new AuthScope(baseUri.getHost(), baseUri.getPort());
    }

    public Credentials getCredentials()
    {
        if (username == null || password == null)
        {
            return null;
        } else
        {
            return new UsernamePasswordCredentials(username, password);
        }
    }

    public android.net.Uri.Builder getMethodUriBuilder(String s)
    {
        return baseUri.buildUpon().appendPath(s);
    }
}
