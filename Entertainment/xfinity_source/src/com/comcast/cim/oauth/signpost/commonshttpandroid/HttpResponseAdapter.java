// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.oauth.signpost.commonshttpandroid;

import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import java.io.IOException;
import java.io.InputStream;

public class HttpResponseAdapter
{

    private HttpResponse response;

    public InputStream getContent()
        throws IOException
    {
        return response.getEntity().getContent();
    }

    public String getReasonPhrase()
        throws Exception
    {
        return response.getStatusLine().getReasonPhrase();
    }

    public int getStatusCode()
        throws IOException
    {
        return response.getStatusLine().getStatusCode();
    }
}
