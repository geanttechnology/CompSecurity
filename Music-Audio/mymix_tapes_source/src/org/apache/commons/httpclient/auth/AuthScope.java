// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.util.LangUtils;

public class AuthScope
{

    public static final AuthScope ANY = new AuthScope(ANY_HOST, -1, ANY_REALM, ANY_SCHEME);
    public static final String ANY_HOST = null;
    public static final int ANY_PORT = -1;
    public static final String ANY_REALM = null;
    public static final String ANY_SCHEME = null;
    private String host;
    private int port;
    private String realm;
    private String scheme;

    public AuthScope(String s, int i)
    {
        this(s, i, ANY_REALM, ANY_SCHEME);
    }

    public AuthScope(String s, int i, String s1)
    {
        this(s, i, s1, ANY_SCHEME);
    }

    public AuthScope(String s, int i, String s1, String s2)
    {
        scheme = null;
        realm = null;
        host = null;
        port = -1;
        int j;
        if (s == null)
        {
            s = ANY_HOST;
        } else
        {
            s = s.toLowerCase();
        }
        host = s;
        j = i;
        if (i < 0)
        {
            j = -1;
        }
        port = j;
        s = s1;
        if (s1 == null)
        {
            s = ANY_REALM;
        }
        realm = s;
        if (s2 == null)
        {
            s = ANY_SCHEME;
        } else
        {
            s = s2.toUpperCase();
        }
        scheme = s;
    }

    public AuthScope(AuthScope authscope)
    {
        scheme = null;
        realm = null;
        host = null;
        port = -1;
        if (authscope == null)
        {
            throw new IllegalArgumentException("Scope may not be null");
        } else
        {
            host = authscope.getHost();
            port = authscope.getPort();
            realm = authscope.getRealm();
            scheme = authscope.getScheme();
            return;
        }
    }

    private static boolean paramsEqual(int i, int j)
    {
        return i == j;
    }

    private static boolean paramsEqual(String s, String s1)
    {
        if (s == null)
        {
            return s == s1;
        } else
        {
            return s.equals(s1);
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = true;
        if (obj != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (obj == this) goto _L4; else goto _L3
_L3:
        if (!(obj instanceof AuthScope))
        {
            return super.equals(obj);
        }
        obj = (AuthScope)obj;
        if (!paramsEqual(host, ((AuthScope) (obj)).host) || !paramsEqual(port, ((AuthScope) (obj)).port) || !paramsEqual(realm, ((AuthScope) (obj)).realm))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (paramsEqual(scheme, ((AuthScope) (obj)).scheme)) goto _L4; else goto _L5
_L5:
        return false;
    }

    public String getHost()
    {
        return host;
    }

    public int getPort()
    {
        return port;
    }

    public String getRealm()
    {
        return realm;
    }

    public String getScheme()
    {
        return scheme;
    }

    public int hashCode()
    {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, host), port), realm), scheme);
    }

    public int match(AuthScope authscope)
    {
        int j = 0;
        int i;
        if (paramsEqual(scheme, authscope.scheme))
        {
            i = 0 + 1;
        } else
        {
            i = j;
            if (scheme != ANY_SCHEME)
            {
                i = j;
                if (authscope.scheme != ANY_SCHEME)
                {
                    return -1;
                }
            }
        }
        if (paramsEqual(realm, authscope.realm))
        {
            j = i + 2;
        } else
        {
            j = i;
            if (realm != ANY_REALM)
            {
                j = i;
                if (authscope.realm != ANY_REALM)
                {
                    return -1;
                }
            }
        }
        if (paramsEqual(port, authscope.port))
        {
            i = j + 4;
        } else
        {
            i = j;
            if (port != -1)
            {
                i = j;
                if (authscope.port != -1)
                {
                    return -1;
                }
            }
        }
        if (paramsEqual(host, authscope.host))
        {
            j = i + 8;
        } else
        {
            j = i;
            if (host != ANY_HOST)
            {
                j = i;
                if (authscope.host != ANY_HOST)
                {
                    return -1;
                }
            }
        }
        return j;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (scheme != null)
        {
            stringbuffer.append(scheme.toUpperCase());
            stringbuffer.append(' ');
        }
        if (realm != null)
        {
            stringbuffer.append('\'');
            stringbuffer.append(realm);
            stringbuffer.append('\'');
        } else
        {
            stringbuffer.append("<any realm>");
        }
        if (host != null)
        {
            stringbuffer.append('@');
            stringbuffer.append(host);
            if (port >= 0)
            {
                stringbuffer.append(':');
                stringbuffer.append(port);
            }
        }
        return stringbuffer.toString();
    }

}
