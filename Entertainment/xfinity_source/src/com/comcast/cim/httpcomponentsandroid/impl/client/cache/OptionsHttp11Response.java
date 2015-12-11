// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.client.cache;

import com.comcast.cim.httpcomponentsandroid.Header;
import com.comcast.cim.httpcomponentsandroid.HeaderIterator;
import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.HttpVersion;
import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.StatusLine;
import com.comcast.cim.httpcomponentsandroid.message.AbstractHttpMessage;
import com.comcast.cim.httpcomponentsandroid.message.BasicStatusLine;
import com.comcast.cim.httpcomponentsandroid.message.HeaderGroup;
import com.comcast.cim.httpcomponentsandroid.params.BasicHttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import java.util.Locale;

final class OptionsHttp11Response extends AbstractHttpMessage
    implements HttpResponse
{

    private final StatusLine statusLine;
    private final ProtocolVersion version;

    OptionsHttp11Response()
    {
        statusLine = new BasicStatusLine(HttpVersion.HTTP_1_1, 501, "");
        version = HttpVersion.HTTP_1_1;
    }

    public void addHeader(Header header)
    {
    }

    public void addHeader(String s, String s1)
    {
    }

    public boolean containsHeader(String s)
    {
        return headergroup.containsHeader(s);
    }

    public Header[] getAllHeaders()
    {
        return headergroup.getAllHeaders();
    }

    public HttpEntity getEntity()
    {
        return null;
    }

    public Header getFirstHeader(String s)
    {
        return headergroup.getFirstHeader(s);
    }

    public Header[] getHeaders(String s)
    {
        return headergroup.getHeaders(s);
    }

    public Locale getLocale()
    {
        return null;
    }

    public HttpParams getParams()
    {
        if (params == null)
        {
            params = new BasicHttpParams();
        }
        return params;
    }

    public ProtocolVersion getProtocolVersion()
    {
        return version;
    }

    public StatusLine getStatusLine()
    {
        return statusLine;
    }

    public HeaderIterator headerIterator()
    {
        return headergroup.iterator();
    }

    public HeaderIterator headerIterator(String s)
    {
        return headergroup.iterator(s);
    }

    public void removeHeader(Header header)
    {
    }

    public void removeHeaders(String s)
    {
    }

    public void setEntity(HttpEntity httpentity)
    {
    }

    public void setHeader(Header header)
    {
    }

    public void setHeader(String s, String s1)
    {
    }

    public void setHeaders(Header aheader[])
    {
    }

    public void setLocale(Locale locale)
    {
    }

    public void setParams(HttpParams httpparams)
    {
    }

    public void setReasonPhrase(String s)
        throws IllegalStateException
    {
    }

    public void setStatusCode(int i)
        throws IllegalStateException
    {
    }

    public void setStatusLine(StatusLine statusline)
    {
    }
}
