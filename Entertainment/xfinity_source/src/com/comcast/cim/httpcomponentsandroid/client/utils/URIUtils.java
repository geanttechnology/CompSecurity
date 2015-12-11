// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.utils;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Stack;

public class URIUtils
{

    private URIUtils()
    {
    }

    public static URI createURI(String s, String s1, int i, String s2, String s3, String s4)
        throws URISyntaxException
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s1 != null)
        {
            if (s != null)
            {
                stringbuilder.append(s);
                stringbuilder.append("://");
            }
            stringbuilder.append(s1);
            if (i > 0)
            {
                stringbuilder.append(':');
                stringbuilder.append(i);
            }
        }
        if (s2 == null || !s2.startsWith("/"))
        {
            stringbuilder.append('/');
        }
        if (s2 != null)
        {
            stringbuilder.append(s2);
        }
        if (s3 != null)
        {
            stringbuilder.append('?');
            stringbuilder.append(s3);
        }
        if (s4 != null)
        {
            stringbuilder.append('#');
            stringbuilder.append(s4);
        }
        return new URI(stringbuilder.toString());
    }

    public static HttpHost extractHost(URI uri)
    {
        if (uri != null && uri.isAbsolute())
        {
            int i = uri.getPort();
            String s1 = uri.getHost();
            String s = s1;
            int j = i;
            if (s1 == null)
            {
                String s3 = uri.getAuthority();
                s = s3;
                j = i;
                if (s3 != null)
                {
                    j = s3.indexOf('@');
                    String s2 = s3;
                    if (j >= 0)
                    {
                        if (s3.length() > j + 1)
                        {
                            s2 = s3.substring(j + 1);
                        } else
                        {
                            s2 = null;
                        }
                    }
                    s = s2;
                    j = i;
                    if (s2 != null)
                    {
                        int k = s2.indexOf(':');
                        s = s2;
                        j = i;
                        if (k >= 0)
                        {
                            if (k + 1 < s2.length())
                            {
                                i = Integer.parseInt(s2.substring(k + 1));
                            }
                            s = s2.substring(0, k);
                            j = i;
                        }
                    }
                }
            }
            uri = uri.getScheme();
            if (s != null)
            {
                return new HttpHost(s, j, uri);
            }
        }
        return null;
    }

    private static String normalizePath(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
label0:
            {
                for (int i = 0; i < s.length() && s.charAt(i) == '/'; i++)
                {
                    break label0;
                }

                s1 = s;
                if (i > 1)
                {
                    return s.substring(i - 1);
                }
            }
        }
        return s1;
    }

    private static URI removeDotSegments(URI uri)
    {
        Object obj = uri.getPath();
        if (obj == null || ((String) (obj)).indexOf("/.") == -1)
        {
            return uri;
        }
        String as[] = ((String) (obj)).split("/");
        Object obj1 = new Stack();
        int i = 0;
        while (i < as.length) 
        {
            if (as[i].length() != 0 && !".".equals(as[i]))
            {
                if ("..".equals(as[i]))
                {
                    if (!((Stack) (obj1)).isEmpty())
                    {
                        ((Stack) (obj1)).pop();
                    }
                } else
                {
                    ((Stack) (obj1)).push(as[i]);
                }
            }
            i++;
        }
        as = new StringBuilder();
        String s;
        for (obj1 = ((Stack) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); as.append('/').append(s))
        {
            s = (String)((Iterator) (obj1)).next();
        }

        try
        {
            uri = new URI(uri.getScheme(), uri.getAuthority(), as.toString(), uri.getQuery(), uri.getFragment());
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            throw new IllegalArgumentException(uri);
        }
        return uri;
    }

    public static URI resolve(URI uri, String s)
    {
        return resolve(uri, URI.create(s));
    }

    public static URI resolve(URI uri, URI uri1)
    {
        if (uri == null)
        {
            throw new IllegalArgumentException("Base URI may nor be null");
        }
        if (uri1 == null)
        {
            throw new IllegalArgumentException("Reference URI may nor be null");
        }
        String s = uri1.toString();
        if (s.startsWith("?"))
        {
            return resolveReferenceStartingWithQueryString(uri, uri1);
        }
        boolean flag;
        if (s.length() == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            uri1 = URI.create("#");
        }
        uri1 = uri.resolve(uri1);
        uri = uri1;
        if (flag)
        {
            uri = uri1.toString();
            uri = URI.create(uri.substring(0, uri.indexOf('#')));
        }
        return removeDotSegments(uri);
    }

    private static URI resolveReferenceStartingWithQueryString(URI uri, URI uri1)
    {
        String s = uri.toString();
        uri = s;
        if (s.indexOf('?') > -1)
        {
            uri = s.substring(0, s.indexOf('?'));
        }
        return URI.create((new StringBuilder()).append(uri).append(uri1.toString()).toString());
    }

    public static URI rewriteURI(URI uri, HttpHost httphost)
        throws URISyntaxException
    {
        return rewriteURI(uri, httphost, false);
    }

    public static URI rewriteURI(URI uri, HttpHost httphost, boolean flag)
        throws URISyntaxException
    {
        if (uri == null)
        {
            throw new IllegalArgumentException("URI may not be null");
        }
        if (httphost != null)
        {
            String s = httphost.getSchemeName();
            String s2 = httphost.getHostName();
            int i = httphost.getPort();
            httphost = normalizePath(uri.getRawPath());
            String s3 = uri.getRawQuery();
            if (flag)
            {
                uri = null;
            } else
            {
                uri = uri.getRawFragment();
            }
            return createURI(s, s2, i, httphost, s3, uri);
        }
        httphost = normalizePath(uri.getRawPath());
        String s1 = uri.getRawQuery();
        if (flag)
        {
            uri = null;
        } else
        {
            uri = uri.getRawFragment();
        }
        return createURI(null, null, -1, httphost, s1, uri);
    }
}
