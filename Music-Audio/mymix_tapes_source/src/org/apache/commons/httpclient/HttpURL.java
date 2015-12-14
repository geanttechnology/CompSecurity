// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import org.apache.commons.httpclient.util.URIUtil;

// Referenced classes of package org.apache.commons.httpclient:
//            URI, URIException

public class HttpURL extends URI
{

    public static final int DEFAULT_PORT = 80;
    public static final char DEFAULT_SCHEME[] = {
        'h', 't', 't', 'p'
    };
    public static final int _default_port = 80;
    public static final char _default_scheme[] = DEFAULT_SCHEME;
    static final long serialVersionUID = 0x9ca990a4050b271dL;

    protected HttpURL()
    {
    }

    public HttpURL(String s)
        throws URIException
    {
        parseUriReference(s, false);
        checkValid();
    }

    public HttpURL(String s, int i, String s1)
        throws URIException
    {
        this(null, null, s, i, s1, null, null);
    }

    public HttpURL(String s, int i, String s1, String s2)
        throws URIException
    {
        this(null, null, s, i, s1, s2, null);
    }

    public HttpURL(String s, String s1)
        throws URIException
    {
        protocolCharset = s1;
        parseUriReference(s, false);
        checkValid();
    }

    public HttpURL(String s, String s1, int i, String s2)
        throws URIException
    {
        this(s, s1, i, s2, null, null);
    }

    public HttpURL(String s, String s1, int i, String s2, String s3)
        throws URIException
    {
        this(s, s1, i, s2, s3, null);
    }

    public HttpURL(String s, String s1, int i, String s2, String s3, String s4)
        throws URIException
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (s != null || s1 != null || i != -1)
        {
            _scheme = DEFAULT_SCHEME;
            stringbuffer.append(_default_scheme);
            stringbuffer.append("://");
            if (s != null)
            {
                stringbuffer.append(s);
                stringbuffer.append('@');
            }
            if (s1 != null)
            {
                stringbuffer.append(URIUtil.encode(s1, URI.allowed_host));
                if (i != -1 || i != 80)
                {
                    stringbuffer.append(':');
                    stringbuffer.append(i);
                }
            }
        }
        if (s2 != null)
        {
            if (scheme != null && !s2.startsWith("/"))
            {
                throw new URIException(1, "abs_path requested");
            }
            stringbuffer.append(URIUtil.encode(s2, URI.allowed_abs_path));
        }
        if (s3 != null)
        {
            stringbuffer.append('?');
            stringbuffer.append(URIUtil.encode(s3, URI.allowed_query));
        }
        if (s4 != null)
        {
            stringbuffer.append('#');
            stringbuffer.append(URIUtil.encode(s4, URI.allowed_fragment));
        }
        parseUriReference(stringbuffer.toString(), true);
        checkValid();
    }

    public HttpURL(String s, String s1, String s2)
        throws URIException
    {
        this(s, s1, s2, -1, null, null, null);
    }

    public HttpURL(String s, String s1, String s2, int i)
        throws URIException
    {
        this(s, s1, s2, i, null, null, null);
    }

    public HttpURL(String s, String s1, String s2, int i, String s3)
        throws URIException
    {
        this(s, s1, s2, i, s3, null, null);
    }

    public HttpURL(String s, String s1, String s2, int i, String s3, String s4)
        throws URIException
    {
        this(s, s1, s2, i, s3, s4, null);
    }

    public HttpURL(String s, String s1, String s2, int i, String s3, String s4, String s5)
        throws URIException
    {
        this(toUserinfo(s, s1), s2, i, s3, s4, s5);
    }

    public HttpURL(String s, String s1, String s2, String s3)
        throws URIException
    {
        this(null, null, s, -1, s1, s2, s3);
    }

    public HttpURL(String s, String s1, String s2, String s3, String s4)
        throws URIException
    {
        this(s, s1, -1, s2, s3, s4);
    }

    public HttpURL(HttpURL httpurl, String s)
        throws URIException
    {
        this(httpurl, new HttpURL(s));
    }

    public HttpURL(HttpURL httpurl, HttpURL httpurl1)
        throws URIException
    {
        super(httpurl, httpurl1);
        checkValid();
    }

    public HttpURL(char ac[])
        throws URIException, NullPointerException
    {
        parseUriReference(new String(ac), true);
        checkValid();
    }

    public HttpURL(char ac[], String s)
        throws URIException, NullPointerException
    {
        protocolCharset = s;
        parseUriReference(new String(ac), true);
        checkValid();
    }

    protected static String toUserinfo(String s, String s1)
        throws URIException
    {
        if (s == null)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer(20);
        stringbuffer.append(URIUtil.encode(s, URI.allowed_within_userinfo));
        if (s1 == null)
        {
            return stringbuffer.toString();
        } else
        {
            stringbuffer.append(':');
            stringbuffer.append(URIUtil.encode(s1, URI.allowed_within_userinfo));
            return stringbuffer.toString();
        }
    }

    protected void checkValid()
        throws URIException
    {
        if (!equals(_scheme, DEFAULT_SCHEME) && _scheme != null)
        {
            throw new URIException(1, "wrong class use");
        } else
        {
            return;
        }
    }

    public String getEscapedPassword()
    {
        char ac[] = getRawPassword();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getEscapedUser()
    {
        char ac[] = getRawUser();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getPassword()
        throws URIException
    {
        char ac[] = getRawPassword();
        if (ac == null)
        {
            return null;
        } else
        {
            return decode(ac, getProtocolCharset());
        }
    }

    public int getPort()
    {
        if (_port == -1)
        {
            return 80;
        } else
        {
            return _port;
        }
    }

    public char[] getRawAboveHierPath()
        throws URIException
    {
        char ac[] = getRawCurrentHierPath();
        if (ac == null || ac.length == 0)
        {
            return rootPath;
        } else
        {
            return getRawCurrentHierPath(ac);
        }
    }

    public char[] getRawCurrentHierPath()
        throws URIException
    {
        if (_path == null || _path.length == 0)
        {
            return rootPath;
        } else
        {
            return super.getRawCurrentHierPath(_path);
        }
    }

    public char[] getRawPassword()
    {
        int i = indexFirstOf(_userinfo, ':');
        if (i == -1)
        {
            return null;
        } else
        {
            int j = _userinfo.length - i - 1;
            char ac[] = new char[j];
            System.arraycopy(_userinfo, i + 1, ac, 0, j);
            return ac;
        }
    }

    public char[] getRawPath()
    {
        char ac[];
label0:
        {
            char ac1[] = super.getRawPath();
            if (ac1 != null)
            {
                ac = ac1;
                if (ac1.length != 0)
                {
                    break label0;
                }
            }
            ac = rootPath;
        }
        return ac;
    }

    public char[] getRawScheme()
    {
        if (_scheme == null)
        {
            return null;
        } else
        {
            return DEFAULT_SCHEME;
        }
    }

    public char[] getRawUser()
    {
        if (_userinfo == null || _userinfo.length == 0)
        {
            return null;
        }
        int i = indexFirstOf(_userinfo, ':');
        if (i == -1)
        {
            return _userinfo;
        } else
        {
            char ac[] = new char[i];
            System.arraycopy(_userinfo, 0, ac, 0, i);
            return ac;
        }
    }

    public String getScheme()
    {
        if (_scheme == null)
        {
            return null;
        } else
        {
            return new String(DEFAULT_SCHEME);
        }
    }

    public String getUser()
        throws URIException
    {
        char ac[] = getRawUser();
        if (ac == null)
        {
            return null;
        } else
        {
            return decode(ac, getProtocolCharset());
        }
    }

    public void setEscapedPassword(String s)
        throws URIException
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = s.toCharArray();
        }
        setRawPassword(s);
    }

    public void setEscapedUser(String s)
        throws URIException, NullPointerException
    {
        setRawUser(s.toCharArray());
    }

    public void setEscapedUserinfo(String s, String s1)
        throws URIException, NullPointerException
    {
        char ac[] = s.toCharArray();
        if (s1 == null)
        {
            s = null;
        } else
        {
            s = s1.toCharArray();
        }
        setRawUserinfo(ac, s);
    }

    public void setPassword(String s)
        throws URIException
    {
        if (s == null)
        {
            s = null;
        } else
        {
            s = encode(s, allowed_within_userinfo, getProtocolCharset());
        }
        setRawPassword(s);
    }

    public void setQuery(String s, String s1)
        throws URIException, NullPointerException
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s2 = getProtocolCharset();
        stringbuffer.append(encode(s, allowed_within_query, s2));
        stringbuffer.append('=');
        stringbuffer.append(encode(s1, allowed_within_query, s2));
        _query = stringbuffer.toString().toCharArray();
        setURI();
    }

    public void setQuery(String as[], String as1[])
        throws URIException, NullPointerException
    {
        int j = as.length;
        if (j != as1.length)
        {
            throw new URIException("wrong array size of query");
        }
        StringBuffer stringbuffer = new StringBuffer();
        String s = getProtocolCharset();
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(encode(as[i], allowed_within_query, s));
            stringbuffer.append('=');
            stringbuffer.append(encode(as1[i], allowed_within_query, s));
            if (i + 1 < j)
            {
                stringbuffer.append('&');
            }
        }

        _query = stringbuffer.toString().toCharArray();
        setURI();
    }

    public void setRawPassword(char ac[])
        throws URIException
    {
        if (ac != null && !validate(ac, within_userinfo))
        {
            throw new URIException(3, "escaped password not valid");
        }
        if (getRawUser() == null || getRawUser().length == 0)
        {
            throw new URIException(1, "username required");
        }
        Object obj = new String(getRawUser());
        if (ac == null)
        {
            ac = null;
        } else
        {
            ac = new String(ac);
        }
        obj = (new StringBuffer()).append(((String) (obj)));
        if (ac == null)
        {
            ac = "";
        } else
        {
            ac = ":" + ac;
        }
        obj = ((StringBuffer) (obj)).append(ac).toString();
        ac = new String(getRawHost());
        if (_port != -1)
        {
            ac = ac + ":" + _port;
        }
        ac = obj + "@" + ac;
        _userinfo = ((String) (obj)).toCharArray();
        _authority = ac.toCharArray();
        setURI();
    }

    public void setRawUser(char ac[])
        throws URIException
    {
        if (ac == null || ac.length == 0)
        {
            throw new URIException(1, "user required");
        }
        if (!validate(ac, within_userinfo))
        {
            throw new URIException(3, "escaped user not valid");
        }
        Object obj = new String(ac);
        ac = getRawPassword();
        if (ac == null)
        {
            ac = null;
        } else
        {
            ac = new String(ac);
        }
        obj = (new StringBuffer()).append(((String) (obj)));
        if (ac == null)
        {
            ac = "";
        } else
        {
            ac = ":" + ac;
        }
        obj = ((StringBuffer) (obj)).append(ac).toString();
        ac = new String(getRawHost());
        if (_port != -1)
        {
            ac = ac + ":" + _port;
        }
        ac = obj + "@" + ac;
        _userinfo = ((String) (obj)).toCharArray();
        _authority = ac.toCharArray();
        setURI();
    }

    public void setRawUserinfo(char ac[], char ac1[])
        throws URIException
    {
        if (ac == null || ac.length == 0)
        {
            throw new URIException(1, "user required");
        }
        if (!validate(ac, within_userinfo) || ac1 != null && !validate(ac1, within_userinfo))
        {
            throw new URIException(3, "escaped userinfo not valid");
        }
        String s = new String(ac);
        if (ac1 == null)
        {
            ac = null;
        } else
        {
            ac = new String(ac1);
        }
        ac1 = (new StringBuffer()).append(s);
        if (ac == null)
        {
            ac = "";
        } else
        {
            ac = ":" + ac;
        }
        ac1 = ac1.append(ac).toString();
        ac = new String(getRawHost());
        if (_port != -1)
        {
            ac = ac + ":" + _port;
        }
        ac = ac1 + "@" + ac;
        _userinfo = ac1.toCharArray();
        _authority = ac.toCharArray();
        setURI();
    }

    protected void setURI()
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        if (_scheme != null)
        {
            stringbuffer.append(_scheme);
            stringbuffer.append(':');
        }
        if (_is_net_path)
        {
            stringbuffer.append("//");
            if (_authority != null)
            {
                if (_userinfo != null)
                {
                    if (_host != null)
                    {
                        stringbuffer.append(_host);
                        if (_port != -1)
                        {
                            stringbuffer.append(':');
                            stringbuffer.append(_port);
                        }
                    }
                } else
                {
                    stringbuffer.append(_authority);
                }
            }
        }
        if (_opaque == null || !_is_opaque_part) goto _L2; else goto _L1
_L1:
        stringbuffer.append(_opaque);
_L4:
        if (_query != null)
        {
            stringbuffer.append('?');
            stringbuffer.append(_query);
        }
        _uri = stringbuffer.toString().toCharArray();
        hash = 0;
        return;
_L2:
        if (_path != null && _path.length != 0)
        {
            stringbuffer.append(_path);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setUser(String s)
        throws URIException, NullPointerException
    {
        setRawUser(encode(s, allowed_within_userinfo, getProtocolCharset()));
    }

    public void setUserinfo(String s, String s1)
        throws URIException, NullPointerException
    {
        String s2 = getProtocolCharset();
        char ac[] = encode(s, within_userinfo, s2);
        if (s1 == null)
        {
            s = null;
        } else
        {
            s = encode(s1, within_userinfo, s2);
        }
        setRawUserinfo(ac, s);
    }

}
