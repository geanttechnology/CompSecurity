// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.client.cache.HttpCacheEntry;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class CacheKeyGenerator
{

    private static final URI BASE_URI = URI.create("http://example.com/");

    CacheKeyGenerator()
    {
    }

    private int canonicalizePort(int i, String s)
    {
        int j;
        if (i == -1 && "http".equalsIgnoreCase(s))
        {
            j = 80;
        } else
        {
            j = i;
            if (i == -1)
            {
                j = i;
                if ("https".equalsIgnoreCase(s))
                {
                    return 443;
                }
            }
        }
        return j;
    }

    private boolean isRelativeRequest(HttpRequest httprequest)
    {
        httprequest = httprequest.getRequestLine().getUri();
        return "*".equals(httprequest) || httprequest.startsWith("/");
    }

    public String canonicalizeUri(String s)
    {
        String s1;
        String s2;
        String s3;
        Object obj;
        int i;
        try
        {
            obj = new URL(URIUtils.resolve(BASE_URI, s).toASCIIString());
            s2 = ((URL) (obj)).getProtocol();
            s3 = ((URL) (obj)).getHost();
            i = canonicalizePort(((URL) (obj)).getPort(), s2);
            s1 = ((URL) (obj)).getPath();
            obj = ((URL) (obj)).getQuery();
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            return s;
        }
        catch (MalformedURLException malformedurlexception)
        {
            return s;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        s1 = (new StringBuilder()).append(s1).append("?").append(((String) (obj))).toString();
        s1 = (new URL(s2, s3, i, s1)).toString();
        return s1;
    }

    protected String getFullHeaderValue(Header aheader[])
    {
        if (aheader == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder("");
        boolean flag = true;
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            Header header = aheader[i];
            if (!flag)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append(header.getValue().trim());
            flag = false;
        }

        return stringbuilder.toString();
    }

    public String getURI(HttpHost httphost, HttpRequest httprequest)
    {
        if (isRelativeRequest(httprequest))
        {
            return canonicalizeUri(String.format("%s%s", new Object[] {
                httphost.toString(), httprequest.getRequestLine().getUri()
            }));
        } else
        {
            return canonicalizeUri(httprequest.getRequestLine().getUri());
        }
    }

    public String getVariantKey(HttpRequest httprequest, HttpCacheEntry httpcacheentry)
    {
        Object obj = new ArrayList();
        httpcacheentry = httpcacheentry.getHeaders("Vary");
        int k = httpcacheentry.length;
        for (int i = 0; i < k; i++)
        {
            HeaderElement aheaderelement[] = httpcacheentry[i].getElements();
            int l = aheaderelement.length;
            for (int j = 0; j < l; j++)
            {
                ((List) (obj)).add(aheaderelement[j].getName());
            }

        }

        Collections.sort(((List) (obj)));
        String s;
        boolean flag;
        try
        {
            httpcacheentry = new StringBuilder("{");
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequest httprequest)
        {
            throw new RuntimeException("couldn't encode to UTF-8", httprequest);
        }
        flag = true;
        obj = ((List) (obj)).iterator();
_L1:
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_201;
        }
        s = (String)((Iterator) (obj)).next();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        httpcacheentry.append("&");
        httpcacheentry.append(URLEncoder.encode(s, Consts.UTF_8.name()));
        httpcacheentry.append("=");
        httpcacheentry.append(URLEncoder.encode(getFullHeaderValue(httprequest.getHeaders(s)), Consts.UTF_8.name()));
        flag = false;
          goto _L1
        httpcacheentry.append("}");
        return httpcacheentry.toString();
    }

    public String getVariantURI(HttpHost httphost, HttpRequest httprequest, HttpCacheEntry httpcacheentry)
    {
        if (!httpcacheentry.hasVariants())
        {
            return getURI(httphost, httprequest);
        } else
        {
            return (new StringBuilder()).append(getVariantKey(httprequest, httpcacheentry)).append(getURI(httphost, httprequest)).toString();
        }
    }

}
