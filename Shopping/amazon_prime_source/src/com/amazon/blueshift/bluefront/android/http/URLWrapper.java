// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.http;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLWrapper
{

    private final URL mUrl;

    public URLWrapper(String s)
        throws MalformedURLException
    {
        mUrl = new URL(s);
    }

    public URLConnection openConnection()
        throws IOException
    {
        return mUrl.openConnection();
    }

    public String toString()
    {
        return mUrl.toString();
    }
}
