// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            CollectionMap

public class UrlMaker
{

    public static final int DEFAULT_PORT = -1;
    private static final Pattern QUERY_PATTERN = Pattern.compile("([^=&]+)(=([^&]*))?");
    public static final String UTF8_ENCODING = "UTF-8";
    private String fragment;
    private String host;
    private String path;
    private int port;
    private CollectionMap query;
    private String scheme;
    private String userInfo;

    public UrlMaker()
    {
        port = -1;
        query = new CollectionMap();
    }

    public UrlMaker(UrlMaker urlmaker)
    {
        port = -1;
        query = new CollectionMap();
        scheme = urlmaker.getScheme();
        userInfo = urlmaker.getUserInfo();
        host = urlmaker.getHost();
        port = urlmaker.getPort();
        path = urlmaker.getPath();
        query = new CollectionMap(urlmaker.getQuery());
        fragment = urlmaker.getFragment();
    }

    public UrlMaker(String s)
        throws URISyntaxException, UnsupportedEncodingException
    {
        this(new URI(s));
    }

    public UrlMaker(String s, String s1, String s2, int i, String s3, String s4, String s5)
        throws UnsupportedEncodingException
    {
        port = -1;
        query = new CollectionMap();
        scheme = s;
        userInfo = s1;
        host = s2;
        port = i;
        path = s3;
        query = parseQuery(s4);
        fragment = s5;
    }

    public UrlMaker(URI uri)
        throws UnsupportedEncodingException
    {
        String s1 = uri.getScheme();
        String s2 = uri.getRawUserInfo();
        String s3 = uri.getHost();
        int i = uri.getPort();
        String s;
        if ("".equals(uri.getRawPath()))
        {
            s = null;
        } else
        {
            s = uri.getRawPath();
        }
        this(s1, s2, s3, i, s, uri.getRawQuery(), uri.getRawFragment());
    }

    public static CollectionMap parseQuery(String s)
        throws UnsupportedEncodingException
    {
        CollectionMap collectionmap = new CollectionMap();
        if (s != null)
        {
            Matcher matcher = QUERY_PATTERN.matcher(s);
            while (matcher.find()) 
            {
                String s1 = URLDecoder.decode(matcher.group(1), "UTF-8");
                if (matcher.groupCount() > 2)
                {
                    s = URLDecoder.decode(matcher.group(3), "UTF-8");
                } else
                {
                    s = null;
                }
                collectionmap.add(s1, s);
            }
        }
        return collectionmap;
    }

    public static String urlEncode(CollectionMap collectionmap)
        throws UnsupportedEncodingException
    {
        if (collectionmap == null || collectionmap.isEmpty())
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (collectionmap = collectionmap.entrySet().iterator(); collectionmap.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)collectionmap.next();
            if (entry.getKey() != null && !((String)entry.getKey()).isEmpty())
            {
                Iterator iterator = ((List)entry.getValue()).iterator();
                while (iterator.hasNext()) 
                {
                    String s = (String)iterator.next();
                    if (stringbuffer.length() > 0)
                    {
                        stringbuffer.append('&');
                    }
                    stringbuffer.append(URLEncoder.encode((String)entry.getKey(), "UTF-8"));
                    if (s != null)
                    {
                        stringbuffer.append('=').append(URLEncoder.encode(s, "UTF-8"));
                    }
                }
            }
        }

        return stringbuffer.toString();
    }

    public String build()
        throws UnsupportedEncodingException
    {
        StringBuilder stringbuilder = new StringBuilder(256);
        if (scheme != null)
        {
            stringbuilder.append(scheme).append("://");
        }
        if (userInfo != null)
        {
            stringbuilder.append(userInfo).append('@');
        }
        if (host != null)
        {
            stringbuilder.append(host);
        }
        if (port > 0)
        {
            stringbuilder.append(':').append(port);
        }
        if (path != null)
        {
            stringbuilder.append(path);
        }
        if (query != null && !query.isEmpty())
        {
            String s = urlEncode(query);
            if (s != null)
            {
                stringbuilder.append('?').append(s);
            }
        }
        if (fragment != null)
        {
            stringbuilder.append('#').append(fragment);
        }
        return stringbuilder.toString();
    }

    public String getFragment()
    {
        return fragment;
    }

    public String getHost()
    {
        return host;
    }

    public String getPath()
    {
        return path;
    }

    public int getPort()
    {
        return port;
    }

    public CollectionMap getQuery()
    {
        return query;
    }

    public String getScheme()
    {
        return scheme;
    }

    public String getUserInfo()
    {
        return userInfo;
    }

    public UrlMaker setFragment(String s)
    {
        fragment = s;
        return this;
    }

    public UrlMaker setHost(String s)
    {
        host = s;
        return this;
    }

    public UrlMaker setPath(String s)
    {
        path = s;
        return this;
    }

    public UrlMaker setPort(int i)
    {
        port = i;
        return this;
    }

    public UrlMaker setQuery(CollectionMap collectionmap)
    {
        query.set(collectionmap);
        return this;
    }

    public UrlMaker setScheme(String s)
    {
        scheme = s;
        return this;
    }

    public UrlMaker setUserInfo(String s)
    {
        userInfo = s;
        return this;
    }

}
