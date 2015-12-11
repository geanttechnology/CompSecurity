// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;

// Referenced classes of package cz.msebera.android.httpclient.client.utils:
//            URIBuilder

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
            int j = uri.getPort();
            String s1 = uri.getHost();
            String s = s1;
            int i = j;
            if (s1 == null)
            {
                String s3 = uri.getAuthority();
                s = s3;
                i = j;
                if (s3 != null)
                {
                    i = s3.indexOf('@');
                    String s2 = s3;
                    if (i >= 0)
                    {
                        if (s3.length() > i + 1)
                        {
                            s2 = s3.substring(i + 1);
                        } else
                        {
                            s2 = null;
                        }
                    }
                    s = s2;
                    i = j;
                    if (s2 != null)
                    {
                        int i1 = s2.indexOf(':');
                        s = s2;
                        i = j;
                        if (i1 >= 0)
                        {
                            int l = i1 + 1;
                            int k = 0;
                            for (i = l; i < s2.length() && Character.isDigit(s2.charAt(i)); i++)
                            {
                                k++;
                            }

                            i = j;
                            if (k > 0)
                            {
                                try
                                {
                                    i = Integer.parseInt(s2.substring(l, l + k));
                                }
                                catch (NumberFormatException numberformatexception)
                                {
                                    i = j;
                                }
                            }
                            s = s2.substring(0, i1);
                        }
                    }
                }
            }
            uri = uri.getScheme();
            if (!TextUtils.isBlank(s))
            {
                return new HttpHost(s, i, uri);
            }
        }
        return null;
    }

    private static URI normalizeSyntax(URI uri)
    {
        if (!uri.isOpaque() && uri.getAuthority() != null) goto _L2; else goto _L1
_L1:
        Object obj = uri;
_L4:
        return ((URI) (obj));
_L2:
        Args.check(uri.isAbsolute(), "Base URI must be absolute");
        Object obj1;
        String as[];
        int i;
        int j;
        if (uri.getPath() == null)
        {
            obj = "";
        } else
        {
            obj = uri.getPath();
        }
        as = ((String) (obj)).split("/");
        obj1 = new Stack();
        j = as.length;
        i = 0;
        while (i < j) 
        {
            String s = as[i];
            if (s.length() != 0 && !".".equals(s))
            {
                if ("..".equals(s))
                {
                    if (!((Stack) (obj1)).isEmpty())
                    {
                        ((Stack) (obj1)).pop();
                    }
                } else
                {
                    ((Stack) (obj1)).push(s);
                }
            }
            i++;
        }
        StringBuilder stringbuilder = new StringBuilder();
        String s1;
        for (obj1 = ((Stack) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); stringbuilder.append('/').append(s1))
        {
            s1 = (String)((Iterator) (obj1)).next();
        }

        if (((String) (obj)).lastIndexOf('/') == ((String) (obj)).length() - 1)
        {
            stringbuilder.append('/');
        }
        try
        {
            obj1 = new URI(uri.getScheme().toLowerCase(Locale.ENGLISH), uri.getAuthority().toLowerCase(Locale.ENGLISH), stringbuilder.toString(), null, null);
            if (uri.getQuery() != null)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        // Misplaced declaration of an exception variable
        catch (URI uri)
        {
            throw new IllegalArgumentException(uri);
        }
        obj = obj1;
        if (uri.getFragment() == null) goto _L4; else goto _L3
_L3:
        obj = new StringBuilder(((URI) (obj1)).toASCIIString());
        if (uri.getQuery() != null)
        {
            ((StringBuilder) (obj)).append('?').append(uri.getRawQuery());
        }
        if (uri.getFragment() != null)
        {
            ((StringBuilder) (obj)).append('#').append(uri.getRawFragment());
        }
        uri = URI.create(((StringBuilder) (obj)).toString());
        return uri;
    }

    public static URI resolve(URI uri, HttpHost httphost, List list)
        throws URISyntaxException
    {
        Args.notNull(uri, "Request URI");
        if (list == null || list.isEmpty())
        {
            list = new URIBuilder(uri);
        } else
        {
            URIBuilder uribuilder = new URIBuilder((URI)list.get(list.size() - 1));
            String s = uribuilder.getFragment();
            for (int i = list.size() - 1; s == null && i >= 0; i--)
            {
                s = ((URI)list.get(i)).getFragment();
            }

            uribuilder.setFragment(s);
            list = uribuilder;
        }
        if (list.getFragment() == null)
        {
            list.setFragment(uri.getFragment());
        }
        if (httphost != null && !list.isAbsolute())
        {
            list.setScheme(httphost.getSchemeName());
            list.setHost(httphost.getHostName());
            list.setPort(httphost.getPort());
        }
        return list.build();
    }

    public static URI resolve(URI uri, String s)
    {
        return resolve(uri, URI.create(s));
    }

    public static URI resolve(URI uri, URI uri1)
    {
        Args.notNull(uri, "Base URI");
        Args.notNull(uri1, "Reference URI");
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
        return normalizeSyntax(uri);
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

    public static URI rewriteURI(URI uri)
        throws URISyntaxException
    {
        Args.notNull(uri, "URI");
        if (uri.isOpaque())
        {
            return uri;
        }
        uri = new URIBuilder(uri);
        if (uri.getUserInfo() != null)
        {
            uri.setUserInfo(null);
        }
        if (TextUtils.isEmpty(uri.getPath()))
        {
            uri.setPath("/");
        }
        if (uri.getHost() != null)
        {
            uri.setHost(uri.getHost().toLowerCase(Locale.ENGLISH));
        }
        uri.setFragment(null);
        return uri.build();
    }

    public static URI rewriteURI(URI uri, HttpHost httphost)
        throws URISyntaxException
    {
        return rewriteURI(uri, httphost, false);
    }

    public static URI rewriteURI(URI uri, HttpHost httphost, boolean flag)
        throws URISyntaxException
    {
        Args.notNull(uri, "URI");
        if (uri.isOpaque())
        {
            return uri;
        }
        uri = new URIBuilder(uri);
        if (httphost != null)
        {
            uri.setScheme(httphost.getSchemeName());
            uri.setHost(httphost.getHostName());
            uri.setPort(httphost.getPort());
        } else
        {
            uri.setScheme(null);
            uri.setHost(null);
            uri.setPort(-1);
        }
        if (flag)
        {
            uri.setFragment(null);
        }
        if (TextUtils.isEmpty(uri.getPath()))
        {
            uri.setPath("/");
        }
        return uri.build();
    }
}
