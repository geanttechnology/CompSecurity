// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest;

import android.content.Context;
import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest:
//            DummyRestClient

class xception
    implements HttpFactory
{

    public HttpClient getHttpClient(Context context)
    {
        return null;
    }

    public HttpGet getHttpGetRequest()
        throws InvalidParameterException
    {
        return null;
    }

    public HttpPost getHttpPostRequest()
        throws InvalidParameterException
    {
        return null;
    }

    public BasicSourceInfo getSourceInfo()
    {
        return null;
    }

    public void onAccountDeregistered()
    {
    }

    public void onAccountRegistered()
    {
    }

    xception()
    {
    }
}
