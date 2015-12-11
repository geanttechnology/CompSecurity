// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.cache;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.utils.DateUtils;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.util.Args;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package cz.msebera.android.httpclient.client.cache:
//            Resource

public class HttpCacheEntry
    implements Serializable
{

    private static final long serialVersionUID = 0xa89023e2a4a4d35bL;
    private final Date date;
    private final Date requestDate;
    private final Resource resource;
    private final Date responseDate;
    private final HeaderGroup responseHeaders;
    private final StatusLine statusLine;
    private final Map variantMap;

    public HttpCacheEntry(Date date1, Date date2, StatusLine statusline, Header aheader[], Resource resource1)
    {
        this(date1, date2, statusline, aheader, resource1, ((Map) (new HashMap())));
    }

    public HttpCacheEntry(Date date1, Date date2, StatusLine statusline, Header aheader[], Resource resource1, Map map)
    {
        Args.notNull(date1, "Request date");
        Args.notNull(date2, "Response date");
        Args.notNull(statusline, "Status line");
        Args.notNull(aheader, "Response headers");
        requestDate = date1;
        responseDate = date2;
        statusLine = statusline;
        responseHeaders = new HeaderGroup();
        responseHeaders.setHeaders(aheader);
        resource = resource1;
        if (map != null)
        {
            date1 = new HashMap(map);
        } else
        {
            date1 = null;
        }
        variantMap = date1;
        date = parseDate();
    }

    private Date parseDate()
    {
        Header header = getFirstHeader("Date");
        if (header == null)
        {
            return null;
        } else
        {
            return DateUtils.parseDate(header.getValue());
        }
    }

    public Header[] getAllHeaders()
    {
        return responseHeaders.getAllHeaders();
    }

    public Date getDate()
    {
        return date;
    }

    public Header getFirstHeader(String s)
    {
        return responseHeaders.getFirstHeader(s);
    }

    public Header[] getHeaders(String s)
    {
        return responseHeaders.getHeaders(s);
    }

    public ProtocolVersion getProtocolVersion()
    {
        return statusLine.getProtocolVersion();
    }

    public String getReasonPhrase()
    {
        return statusLine.getReasonPhrase();
    }

    public Date getRequestDate()
    {
        return requestDate;
    }

    public Resource getResource()
    {
        return resource;
    }

    public Date getResponseDate()
    {
        return responseDate;
    }

    public int getStatusCode()
    {
        return statusLine.getStatusCode();
    }

    public StatusLine getStatusLine()
    {
        return statusLine;
    }

    public Map getVariantMap()
    {
        return Collections.unmodifiableMap(variantMap);
    }

    public boolean hasVariants()
    {
        return getFirstHeader("Vary") != null;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[request date=").append(requestDate).append("; response date=").append(responseDate).append("; statusLine=").append(statusLine).append("]").toString();
    }
}
