// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ResponseEntityProxy, ConnectionHolder

class HttpResponseProxy
    implements CloseableHttpResponse
{

    private final ConnectionHolder connHolder;
    private final HttpResponse original;

    public HttpResponseProxy(HttpResponse httpresponse, ConnectionHolder connectionholder)
    {
        original = httpresponse;
        connHolder = connectionholder;
        ResponseEntityProxy.enchance(httpresponse, connectionholder);
    }

    public void addHeader(Header header)
    {
        original.addHeader(header);
    }

    public void addHeader(String s, String s1)
    {
        original.addHeader(s, s1);
    }

    public void close()
        throws IOException
    {
        if (connHolder != null)
        {
            connHolder.abortConnection();
        }
    }

    public boolean containsHeader(String s)
    {
        return original.containsHeader(s);
    }

    public Header[] getAllHeaders()
    {
        return original.getAllHeaders();
    }

    public HttpEntity getEntity()
    {
        return original.getEntity();
    }

    public Header getFirstHeader(String s)
    {
        return original.getFirstHeader(s);
    }

    public Header[] getHeaders(String s)
    {
        return original.getHeaders(s);
    }

    public Header getLastHeader(String s)
    {
        return original.getLastHeader(s);
    }

    public Locale getLocale()
    {
        return original.getLocale();
    }

    public HttpParams getParams()
    {
        return original.getParams();
    }

    public ProtocolVersion getProtocolVersion()
    {
        return original.getProtocolVersion();
    }

    public StatusLine getStatusLine()
    {
        return original.getStatusLine();
    }

    public HeaderIterator headerIterator()
    {
        return original.headerIterator();
    }

    public HeaderIterator headerIterator(String s)
    {
        return original.headerIterator(s);
    }

    public void removeHeader(Header header)
    {
        original.removeHeader(header);
    }

    public void removeHeaders(String s)
    {
        original.removeHeaders(s);
    }

    public void setEntity(HttpEntity httpentity)
    {
        original.setEntity(httpentity);
    }

    public void setHeader(Header header)
    {
        original.setHeader(header);
    }

    public void setHeader(String s, String s1)
    {
        original.setHeader(s, s1);
    }

    public void setHeaders(Header aheader[])
    {
        original.setHeaders(aheader);
    }

    public void setLocale(Locale locale)
    {
        original.setLocale(locale);
    }

    public void setParams(HttpParams httpparams)
    {
        original.setParams(httpparams);
    }

    public void setReasonPhrase(String s)
        throws IllegalStateException
    {
        original.setReasonPhrase(s);
    }

    public void setStatusCode(int i)
        throws IllegalStateException
    {
        original.setStatusCode(i);
    }

    public void setStatusLine(ProtocolVersion protocolversion, int i)
    {
        original.setStatusLine(protocolversion, i);
    }

    public void setStatusLine(ProtocolVersion protocolversion, int i, String s)
    {
        original.setStatusLine(protocolversion, i, s);
    }

    public void setStatusLine(StatusLine statusline)
    {
        original.setStatusLine(statusline);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("HttpResponseProxy{");
        stringbuilder.append(original);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }
}
