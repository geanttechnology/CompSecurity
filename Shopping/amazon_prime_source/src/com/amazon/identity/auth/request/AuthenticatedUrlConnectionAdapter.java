// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.request;

import android.net.Uri;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.request:
//            IRequestAdapter

public abstract class AuthenticatedUrlConnectionAdapter
    implements IRequestAdapter
{

    private final HttpURLConnection mUrlConnection;

    public AuthenticatedUrlConnectionAdapter(HttpURLConnection httpurlconnection)
    {
        mUrlConnection = httpurlconnection;
    }

    public abstract byte[] getBody();

    public String getHeader(String s)
    {
        return mUrlConnection.getRequestProperty(s);
    }

    public Map getHeaders()
    {
        return mUrlConnection.getRequestProperties();
    }

    public String getHttpVerb()
    {
        return mUrlConnection.getRequestMethod();
    }

    public Uri getUri()
    {
        return Uri.parse(mUrlConnection.getURL().toString());
    }

    protected HttpURLConnection getUrlConnection()
    {
        return mUrlConnection;
    }

    public void setHeader(String s, String s1)
    {
        mUrlConnection.setRequestProperty(s, s1);
    }
}
