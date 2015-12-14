// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Hashtable;
import java.util.Locale;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.util.EncodingUtil;

// Referenced classes of package org.apache.commons.httpclient:
//            URIException

public class URI
    implements Cloneable, Comparable, Serializable
{
    public static class DefaultCharsetChanged extends RuntimeException
    {

        public static final int DOCUMENT_CHARSET = 2;
        public static final int PROTOCOL_CHARSET = 1;
        public static final int UNKNOWN = 0;
        private String reason;
        private int reasonCode;

        public String getReason()
        {
            return reason;
        }

        public int getReasonCode()
        {
            return reasonCode;
        }

        public DefaultCharsetChanged(int i, String s)
        {
            super(s);
            reason = s;
            reasonCode = i;
        }
    }

    public static class LocaleToCharsetMap
    {

        private static final Hashtable LOCALE_TO_CHARSET_MAP;

        public static String getCharset(Locale locale)
        {
            String s = (String)LOCALE_TO_CHARSET_MAP.get(locale.toString());
            if (s != null)
            {
                return s;
            } else
            {
                return (String)LOCALE_TO_CHARSET_MAP.get(locale.getLanguage());
            }
        }

        static 
        {
            LOCALE_TO_CHARSET_MAP = new Hashtable();
            LOCALE_TO_CHARSET_MAP.put("ar", "ISO-8859-6");
            LOCALE_TO_CHARSET_MAP.put("be", "ISO-8859-5");
            LOCALE_TO_CHARSET_MAP.put("bg", "ISO-8859-5");
            LOCALE_TO_CHARSET_MAP.put("ca", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("cs", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("da", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("de", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("el", "ISO-8859-7");
            LOCALE_TO_CHARSET_MAP.put("en", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("es", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("et", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("fi", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("fr", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("hr", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("hu", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("is", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("it", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("iw", "ISO-8859-8");
            LOCALE_TO_CHARSET_MAP.put("ja", "Shift_JIS");
            LOCALE_TO_CHARSET_MAP.put("ko", "EUC-KR");
            LOCALE_TO_CHARSET_MAP.put("lt", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("lv", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("mk", "ISO-8859-5");
            LOCALE_TO_CHARSET_MAP.put("nl", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("no", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("pl", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("pt", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("ro", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("ru", "ISO-8859-5");
            LOCALE_TO_CHARSET_MAP.put("sh", "ISO-8859-5");
            LOCALE_TO_CHARSET_MAP.put("sk", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("sl", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("sq", "ISO-8859-2");
            LOCALE_TO_CHARSET_MAP.put("sr", "ISO-8859-5");
            LOCALE_TO_CHARSET_MAP.put("sv", "ISO-8859-1");
            LOCALE_TO_CHARSET_MAP.put("tr", "ISO-8859-9");
            LOCALE_TO_CHARSET_MAP.put("uk", "ISO-8859-5");
            LOCALE_TO_CHARSET_MAP.put("zh", "GB2312");
            LOCALE_TO_CHARSET_MAP.put("zh_TW", "Big5");
        }

        public LocaleToCharsetMap()
        {
        }
    }


    protected static final BitSet IPv4address;
    protected static final BitSet IPv6address;
    protected static final BitSet IPv6reference;
    protected static final BitSet URI_reference;
    protected static final BitSet abs_path;
    protected static final BitSet absoluteURI;
    public static final BitSet allowed_IPv6reference;
    public static final BitSet allowed_abs_path;
    public static final BitSet allowed_authority;
    public static final BitSet allowed_fragment;
    public static final BitSet allowed_host;
    public static final BitSet allowed_opaque_part;
    public static final BitSet allowed_query;
    public static final BitSet allowed_reg_name;
    public static final BitSet allowed_rel_path;
    public static final BitSet allowed_userinfo;
    public static final BitSet allowed_within_authority;
    public static final BitSet allowed_within_path;
    public static final BitSet allowed_within_query;
    public static final BitSet allowed_within_userinfo;
    protected static final BitSet alpha;
    protected static final BitSet alphanum;
    protected static final BitSet authority;
    public static final BitSet control;
    protected static String defaultDocumentCharset;
    protected static String defaultDocumentCharsetByLocale;
    protected static String defaultDocumentCharsetByPlatform;
    protected static String defaultProtocolCharset = "UTF-8";
    public static final BitSet delims;
    protected static final BitSet digit;
    public static final BitSet disallowed_opaque_part;
    public static final BitSet disallowed_rel_path;
    protected static final BitSet domainlabel;
    protected static final BitSet escaped;
    protected static final BitSet fragment;
    protected static final BitSet hex;
    protected static final BitSet hier_part;
    protected static final BitSet host;
    protected static final BitSet hostname;
    protected static final BitSet hostport;
    protected static final BitSet mark;
    protected static final BitSet net_path;
    protected static final BitSet opaque_part;
    protected static final BitSet param;
    protected static final BitSet path;
    protected static final BitSet path_segments;
    protected static final BitSet pchar;
    protected static final BitSet percent;
    protected static final BitSet port;
    protected static final BitSet query;
    protected static final BitSet reg_name;
    protected static final BitSet rel_path;
    protected static final BitSet rel_segment;
    protected static final BitSet relativeURI;
    protected static final BitSet reserved;
    protected static final char rootPath[] = {
        '/'
    };
    protected static final BitSet scheme;
    protected static final BitSet segment;
    static final long serialVersionUID = 0x864831aad836c36L;
    protected static final BitSet server;
    public static final BitSet space;
    protected static final BitSet toplabel;
    protected static final BitSet unreserved;
    public static final BitSet unwise;
    protected static final BitSet uric;
    protected static final BitSet uric_no_slash;
    protected static final BitSet userinfo;
    public static final BitSet within_userinfo;
    protected char _authority[];
    protected char _fragment[];
    protected char _host[];
    protected boolean _is_IPv4address;
    protected boolean _is_IPv6reference;
    protected boolean _is_abs_path;
    protected boolean _is_hier_part;
    protected boolean _is_hostname;
    protected boolean _is_net_path;
    protected boolean _is_opaque_part;
    protected boolean _is_reg_name;
    protected boolean _is_rel_path;
    protected boolean _is_server;
    protected char _opaque[];
    protected char _path[];
    protected int _port;
    protected char _query[];
    protected char _scheme[];
    protected char _uri[];
    protected char _userinfo[];
    protected int hash;
    protected String protocolCharset;

    protected URI()
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
    }

    public URI(String s)
        throws URIException
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        parseUriReference(s, false);
    }

    public URI(String s, String s1)
        throws URIException
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        protocolCharset = s1;
        parseUriReference(s, false);
    }

    public URI(String s, String s1, String s2)
        throws URIException
    {
        Object obj = null;
        super();
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        if (s == null)
        {
            throw new URIException(1, "scheme required");
        }
        s = s.toLowerCase().toCharArray();
        if (validate(s, scheme))
        {
            _scheme = s;
            _opaque = encode(s1, allowed_opaque_part, getProtocolCharset());
            _is_opaque_part = true;
            if (s2 == null)
            {
                s = obj;
            } else
            {
                s = s2.toCharArray();
            }
            _fragment = s;
            setURI();
            return;
        } else
        {
            throw new URIException(1, "incorrect scheme");
        }
    }

    public URI(String s, String s1, String s2, int i)
        throws URIException
    {
        this(s, s1, s2, i, null, null, null);
    }

    public URI(String s, String s1, String s2, int i, String s3)
        throws URIException
    {
        this(s, s1, s2, i, s3, null, null);
    }

    public URI(String s, String s1, String s2, int i, String s3, String s4)
        throws URIException
    {
        this(s, s1, s2, i, s3, s4, null);
    }

    public URI(String s, String s1, String s2, int i, String s3, String s4, String s5)
        throws URIException
    {
        if (s2 == null)
        {
            s1 = null;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            if (s1 != null)
            {
                s1 = s1 + '@';
            } else
            {
                s1 = "";
            }
            s2 = stringbuffer.append(s1).append(s2);
            if (i != -1)
            {
                s1 = ":" + i;
            } else
            {
                s1 = "";
            }
            s1 = s2.append(s1).toString();
        }
        this(s, s1, s3, s4, s5);
    }

    public URI(String s, String s1, String s2, String s3)
        throws URIException
    {
        this(s, s1, s2, ((String) (null)), s3);
    }

    public URI(String s, String s1, String s2, String s3, String s4)
        throws URIException
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        StringBuffer stringbuffer = new StringBuffer();
        if (s != null)
        {
            stringbuffer.append(s);
            stringbuffer.append(':');
        }
        if (s1 != null)
        {
            stringbuffer.append("//");
            stringbuffer.append(s1);
        }
        if (s2 != null)
        {
            if ((s != null || s1 != null) && !s2.startsWith("/"))
            {
                throw new URIException(1, "abs_path requested");
            }
            stringbuffer.append(s2);
        }
        if (s3 != null)
        {
            stringbuffer.append('?');
            stringbuffer.append(s3);
        }
        if (s4 != null)
        {
            stringbuffer.append('#');
            stringbuffer.append(s4);
        }
        parseUriReference(stringbuffer.toString(), false);
    }

    public URI(String s, boolean flag)
        throws URIException, NullPointerException
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        parseUriReference(s, flag);
    }

    public URI(String s, boolean flag, String s1)
        throws URIException, NullPointerException
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        protocolCharset = s1;
        parseUriReference(s, flag);
    }

    public URI(URI uri, String s)
        throws URIException
    {
        this(uri, new URI(s));
    }

    public URI(URI uri, String s, boolean flag)
        throws URIException
    {
        this(uri, new URI(s, flag));
    }

    public URI(URI uri, URI uri1)
        throws URIException
    {
        boolean flag = false;
        super();
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        if (uri._scheme == null)
        {
            throw new URIException(1, "base URI required");
        }
        if (uri._scheme != null)
        {
            _scheme = uri._scheme;
            _authority = uri._authority;
            _is_net_path = uri._is_net_path;
        }
        if (uri._is_opaque_part || uri1._is_opaque_part)
        {
            _scheme = uri._scheme;
            if (uri._is_opaque_part || uri1._is_opaque_part)
            {
                flag = true;
            }
            _is_opaque_part = flag;
            _opaque = uri1._opaque;
            _fragment = uri1._fragment;
            setURI();
            return;
        }
        flag = Arrays.equals(uri._scheme, uri1._scheme);
        if (uri1._scheme != null && (!flag || uri1._authority != null))
        {
            _scheme = uri1._scheme;
            _is_net_path = uri1._is_net_path;
            _authority = uri1._authority;
            if (uri1._is_server)
            {
                _is_server = uri1._is_server;
                _userinfo = uri1._userinfo;
                _host = uri1._host;
                _port = uri1._port;
            } else
            if (uri1._is_reg_name)
            {
                _is_reg_name = uri1._is_reg_name;
            }
            _is_abs_path = uri1._is_abs_path;
            _is_rel_path = uri1._is_rel_path;
            _path = uri1._path;
        } else
        if (uri._authority != null && uri1._scheme == null)
        {
            _is_net_path = uri._is_net_path;
            _authority = uri._authority;
            if (uri._is_server)
            {
                _is_server = uri._is_server;
                _userinfo = uri._userinfo;
                _host = uri._host;
                _port = uri._port;
            } else
            if (uri._is_reg_name)
            {
                _is_reg_name = uri._is_reg_name;
            }
        }
        if (uri1._authority != null)
        {
            _is_net_path = uri1._is_net_path;
            _authority = uri1._authority;
            if (uri1._is_server)
            {
                _is_server = uri1._is_server;
                _userinfo = uri1._userinfo;
                _host = uri1._host;
                _port = uri1._port;
            } else
            if (uri1._is_reg_name)
            {
                _is_reg_name = uri1._is_reg_name;
            }
            _is_abs_path = uri1._is_abs_path;
            _is_rel_path = uri1._is_rel_path;
            _path = uri1._path;
        }
        if (uri1._authority == null && (uri1._scheme == null || flag))
        {
            if ((uri1._path == null || uri1._path.length == 0) && uri1._query == null)
            {
                _path = uri._path;
                _query = uri._query;
            } else
            {
                _path = resolvePath(uri._path, uri1._path);
            }
        }
        if (uri1._query != null)
        {
            _query = uri1._query;
        }
        if (uri1._fragment != null)
        {
            _fragment = uri1._fragment;
        }
        setURI();
        parseUriReference(new String(_uri), true);
    }

    public URI(char ac[])
        throws URIException, NullPointerException
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        parseUriReference(new String(ac), true);
    }

    public URI(char ac[], String s)
        throws URIException, NullPointerException
    {
        hash = 0;
        _uri = null;
        protocolCharset = null;
        _scheme = null;
        _opaque = null;
        _authority = null;
        _userinfo = null;
        _host = null;
        _port = -1;
        _path = null;
        _query = null;
        _fragment = null;
        protocolCharset = s;
        parseUriReference(new String(ac), true);
    }

    protected static String decode(String s, String s1)
        throws URIException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Component array of chars may not be null");
        }
        try
        {
            s = URLCodec.decodeUrl(EncodingUtil.getAsciiBytes(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new URIException(s.getMessage());
        }
        return EncodingUtil.getString(s, s1);
    }

    protected static String decode(char ac[], String s)
        throws URIException
    {
        if (ac == null)
        {
            throw new IllegalArgumentException("Component array of chars may not be null");
        } else
        {
            return decode(new String(ac), s);
        }
    }

    protected static char[] encode(String s, BitSet bitset, String s1)
        throws URIException
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Original string may not be null");
        }
        if (bitset == null)
        {
            throw new IllegalArgumentException("Allowed bitset may not be null");
        } else
        {
            return EncodingUtil.getAsciiString(URLCodec.encodeUrl(bitset, EncodingUtil.getBytes(s, s1))).toCharArray();
        }
    }

    public static String getDefaultDocumentCharset()
    {
        return defaultDocumentCharset;
    }

    public static String getDefaultDocumentCharsetByLocale()
    {
        return defaultDocumentCharsetByLocale;
    }

    public static String getDefaultDocumentCharsetByPlatform()
    {
        return defaultDocumentCharsetByPlatform;
    }

    public static String getDefaultProtocolCharset()
    {
        return defaultProtocolCharset;
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws ClassNotFoundException, IOException
    {
        objectinputstream.defaultReadObject();
    }

    public static void setDefaultDocumentCharset(String s)
        throws DefaultCharsetChanged
    {
        defaultDocumentCharset = s;
        throw new DefaultCharsetChanged(2, "the default document charset changed");
    }

    public static void setDefaultProtocolCharset(String s)
        throws DefaultCharsetChanged
    {
        defaultProtocolCharset = s;
        throw new DefaultCharsetChanged(1, "the default protocol charset changed");
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.defaultWriteObject();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        this;
        JVM INSTR monitorenter ;
        URI uri;
        uri = (URI)super.clone();
        uri._uri = _uri;
        uri._scheme = _scheme;
        uri._opaque = _opaque;
        uri._authority = _authority;
        uri._userinfo = _userinfo;
        uri._host = _host;
        uri._port = _port;
        uri._path = _path;
        uri._query = _query;
        uri._fragment = _fragment;
        uri.protocolCharset = protocolCharset;
        uri._is_hier_part = _is_hier_part;
        uri._is_opaque_part = _is_opaque_part;
        uri._is_net_path = _is_net_path;
        uri._is_abs_path = _is_abs_path;
        uri._is_rel_path = _is_rel_path;
        uri._is_reg_name = _is_reg_name;
        uri._is_server = _is_server;
        uri._is_hostname = _is_hostname;
        uri._is_IPv4address = _is_IPv4address;
        uri._is_IPv6reference = _is_IPv6reference;
        this;
        JVM INSTR monitorexit ;
        return uri;
        Exception exception;
        exception;
        throw exception;
    }

    public int compareTo(Object obj)
        throws ClassCastException
    {
        obj = (URI)obj;
        if (!equals(_authority, ((URI) (obj)).getRawAuthority()))
        {
            return -1;
        } else
        {
            return toString().compareTo(((URI) (obj)).toString());
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof URI))
            {
                return false;
            }
            obj = (URI)obj;
            if (!equals(_scheme, ((URI) (obj))._scheme))
            {
                return false;
            }
            if (!equals(_opaque, ((URI) (obj))._opaque))
            {
                return false;
            }
            if (!equals(_authority, ((URI) (obj))._authority))
            {
                return false;
            }
            if (!equals(_path, ((URI) (obj))._path))
            {
                return false;
            }
            if (!equals(_query, ((URI) (obj))._query))
            {
                return false;
            }
            if (!equals(_fragment, ((URI) (obj))._fragment))
            {
                return false;
            }
        }
        return true;
    }

    protected boolean equals(char ac[], char ac1[])
    {
        if (ac != null || ac1 != null)
        {
            if (ac == null || ac1 == null)
            {
                return false;
            }
            if (ac.length != ac1.length)
            {
                return false;
            }
            int i = 0;
            while (i < ac.length) 
            {
                if (ac[i] != ac1[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public String getAboveHierPath()
        throws URIException
    {
        char ac[] = getRawAboveHierPath();
        if (ac == null)
        {
            return null;
        } else
        {
            return decode(ac, getProtocolCharset());
        }
    }

    public String getAuthority()
        throws URIException
    {
        if (_authority == null)
        {
            return null;
        } else
        {
            return decode(_authority, getProtocolCharset());
        }
    }

    public String getCurrentHierPath()
        throws URIException
    {
        char ac[] = getRawCurrentHierPath();
        if (ac == null)
        {
            return null;
        } else
        {
            return decode(ac, getProtocolCharset());
        }
    }

    public String getEscapedAboveHierPath()
        throws URIException
    {
        char ac[] = getRawAboveHierPath();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getEscapedAuthority()
    {
        if (_authority == null)
        {
            return null;
        } else
        {
            return new String(_authority);
        }
    }

    public String getEscapedCurrentHierPath()
        throws URIException
    {
        char ac[] = getRawCurrentHierPath();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getEscapedFragment()
    {
        if (_fragment == null)
        {
            return null;
        } else
        {
            return new String(_fragment);
        }
    }

    public String getEscapedName()
    {
        char ac[] = getRawName();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getEscapedPath()
    {
        char ac[] = getRawPath();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getEscapedPathQuery()
    {
        char ac[] = getRawPathQuery();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getEscapedQuery()
    {
        if (_query == null)
        {
            return null;
        } else
        {
            return new String(_query);
        }
    }

    public String getEscapedURI()
    {
        if (_uri == null)
        {
            return null;
        } else
        {
            return new String(_uri);
        }
    }

    public String getEscapedURIReference()
    {
        char ac[] = getRawURIReference();
        if (ac == null)
        {
            return null;
        } else
        {
            return new String(ac);
        }
    }

    public String getEscapedUserinfo()
    {
        if (_userinfo == null)
        {
            return null;
        } else
        {
            return new String(_userinfo);
        }
    }

    public String getFragment()
        throws URIException
    {
        if (_fragment == null)
        {
            return null;
        } else
        {
            return decode(_fragment, getProtocolCharset());
        }
    }

    public String getHost()
        throws URIException
    {
        if (_host != null)
        {
            return decode(_host, getProtocolCharset());
        } else
        {
            return null;
        }
    }

    public String getName()
        throws URIException
    {
        if (getRawName() == null)
        {
            return null;
        } else
        {
            return decode(getRawName(), getProtocolCharset());
        }
    }

    public String getPath()
        throws URIException
    {
        char ac[] = getRawPath();
        if (ac == null)
        {
            return null;
        } else
        {
            return decode(ac, getProtocolCharset());
        }
    }

    public String getPathQuery()
        throws URIException
    {
        char ac[] = getRawPathQuery();
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
        return _port;
    }

    public String getProtocolCharset()
    {
        if (protocolCharset != null)
        {
            return protocolCharset;
        } else
        {
            return defaultProtocolCharset;
        }
    }

    public String getQuery()
        throws URIException
    {
        if (_query == null)
        {
            return null;
        } else
        {
            return decode(_query, getProtocolCharset());
        }
    }

    public char[] getRawAboveHierPath()
        throws URIException
    {
        char ac[] = getRawCurrentHierPath();
        if (ac == null)
        {
            return null;
        } else
        {
            return getRawCurrentHierPath(ac);
        }
    }

    public char[] getRawAuthority()
    {
        return _authority;
    }

    public char[] getRawCurrentHierPath()
        throws URIException
    {
        if (_path == null)
        {
            return null;
        } else
        {
            return getRawCurrentHierPath(_path);
        }
    }

    protected char[] getRawCurrentHierPath(char ac[])
        throws URIException
    {
        if (_is_opaque_part)
        {
            throw new URIException(1, "no hierarchy level");
        }
        if (ac == null)
        {
            throw new URIException(1, "empty path");
        }
        String s = new String(ac);
        int i = s.indexOf('/');
        int j = s.lastIndexOf('/');
        char ac1[];
        if (j == 0)
        {
            ac1 = rootPath;
        } else
        {
            ac1 = ac;
            if (i != j)
            {
                ac1 = ac;
                if (j != -1)
                {
                    return s.substring(0, j).toCharArray();
                }
            }
        }
        return ac1;
    }

    public char[] getRawFragment()
    {
        return _fragment;
    }

    public char[] getRawHost()
    {
        return _host;
    }

    public char[] getRawName()
    {
        if (_path == null)
        {
            return null;
        }
        boolean flag = false;
        int j = _path.length - 1;
        do
        {
label0:
            {
                int i = ((flag) ? 1 : 0);
                if (j >= 0)
                {
                    if (_path[j] != '/')
                    {
                        break label0;
                    }
                    i = j + 1;
                }
                j = _path.length - i;
                char ac[] = new char[j];
                System.arraycopy(_path, i, ac, 0, j);
                return ac;
            }
            j--;
        } while (true);
    }

    public char[] getRawPath()
    {
        if (_is_opaque_part)
        {
            return _opaque;
        } else
        {
            return _path;
        }
    }

    public char[] getRawPathQuery()
    {
        if (_path == null && _query == null)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer();
        if (_path != null)
        {
            stringbuffer.append(_path);
        }
        if (_query != null)
        {
            stringbuffer.append('?');
            stringbuffer.append(_query);
        }
        return stringbuffer.toString().toCharArray();
    }

    public char[] getRawQuery()
    {
        return _query;
    }

    public char[] getRawScheme()
    {
        return _scheme;
    }

    public char[] getRawURI()
    {
        return _uri;
    }

    public char[] getRawURIReference()
    {
        if (_fragment == null)
        {
            return _uri;
        }
        if (_uri == null)
        {
            return _fragment;
        } else
        {
            return (new String(_uri) + "#" + new String(_fragment)).toCharArray();
        }
    }

    public char[] getRawUserinfo()
    {
        return _userinfo;
    }

    public String getScheme()
    {
        if (_scheme == null)
        {
            return null;
        } else
        {
            return new String(_scheme);
        }
    }

    public String getURI()
        throws URIException
    {
        if (_uri == null)
        {
            return null;
        } else
        {
            return decode(_uri, getProtocolCharset());
        }
    }

    public String getURIReference()
        throws URIException
    {
        char ac[] = getRawURIReference();
        if (ac == null)
        {
            return null;
        } else
        {
            return decode(ac, getProtocolCharset());
        }
    }

    public String getUserinfo()
        throws URIException
    {
        if (_userinfo == null)
        {
            return null;
        } else
        {
            return decode(_userinfo, getProtocolCharset());
        }
    }

    public boolean hasAuthority()
    {
        return _authority != null || _is_net_path;
    }

    public boolean hasFragment()
    {
        return _fragment != null;
    }

    public boolean hasQuery()
    {
        return _query != null;
    }

    public boolean hasUserinfo()
    {
        return _userinfo != null;
    }

    public int hashCode()
    {
        if (hash == 0)
        {
            char ac[] = _uri;
            if (ac != null)
            {
                int i = 0;
                for (int k = ac.length; i < k; i++)
                {
                    hash = hash * 31 + ac[i];
                }

            }
            ac = _fragment;
            if (ac != null)
            {
                int j = 0;
                for (int l = ac.length; j < l; j++)
                {
                    hash = hash * 31 + ac[j];
                }

            }
        }
        return hash;
    }

    protected int indexFirstOf(String s, String s1)
    {
        return indexFirstOf(s, s1, -1);
    }

    protected int indexFirstOf(String s, String s1, int i)
    {
        while (s == null || s.length() == 0 || s1 == null || s1.length() == 0) 
        {
            return -1;
        }
        int j;
        if (i < 0)
        {
            j = 0;
        } else
        {
            j = i;
            if (i > s.length())
            {
                return -1;
            }
        }
        i = s.length();
        s1 = s1.toCharArray();
        for (int k = 0; k < s1.length;)
        {
            int i1 = s.indexOf(s1[k], j);
            int l = i;
            if (i1 >= 0)
            {
                l = i;
                if (i1 < i)
                {
                    l = i1;
                }
            }
            k++;
            i = l;
        }

        j = i;
        if (i == s.length())
        {
            j = -1;
        }
        return j;
    }

    protected int indexFirstOf(char ac[], char c)
    {
        return indexFirstOf(ac, c, 0);
    }

    protected int indexFirstOf(char ac[], char c, int i)
    {
        if (ac != null && ac.length != 0) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        if (i < 0)
        {
            j = 0;
        } else
        {
            j = i;
            if (i > ac.length)
            {
                return -1;
            }
        }
        i = j;
        if (i >= ac.length)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        j = i;
        if (ac[i] == c) goto _L4; else goto _L3
_L3:
        i++;
        break MISSING_BLOCK_LABEL_25;
        return -1;
    }

    public boolean isAbsPath()
    {
        return _is_abs_path;
    }

    public boolean isAbsoluteURI()
    {
        return _scheme != null;
    }

    public boolean isHierPart()
    {
        return _is_hier_part;
    }

    public boolean isHostname()
    {
        return _is_hostname;
    }

    public boolean isIPv4address()
    {
        return _is_IPv4address;
    }

    public boolean isIPv6reference()
    {
        return _is_IPv6reference;
    }

    public boolean isNetPath()
    {
        return _is_net_path || _authority != null;
    }

    public boolean isOpaquePart()
    {
        return _is_opaque_part;
    }

    public boolean isRegName()
    {
        return _is_reg_name;
    }

    public boolean isRelPath()
    {
        return _is_rel_path;
    }

    public boolean isRelativeURI()
    {
        return _scheme == null;
    }

    public boolean isServer()
    {
        return _is_server;
    }

    public void normalize()
        throws URIException
    {
        if (isAbsPath())
        {
            _path = normalize(_path);
            setURI();
        }
    }

    protected char[] normalize(char ac[])
        throws URIException
    {
        String s;
        if (ac == null)
        {
            return null;
        }
        s = new String(ac);
        if (!s.startsWith("./")) goto _L2; else goto _L1
_L1:
        ac = s.substring(1);
_L4:
        int i = ac.indexOf("/./");
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        ac = ac.substring(0, i) + ac.substring(i + 2);
        continue; /* Loop/switch isn't completed */
_L2:
        if (s.startsWith("../"))
        {
            ac = s.substring(2);
        } else
        {
            ac = s;
            if (s.startsWith(".."))
            {
                ac = s.substring(2);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj = ac;
        if (ac.endsWith("/."))
        {
            obj = ac.substring(0, ac.length() - 1);
        }
        int j = 0;
        do
        {
            int i1 = ((String) (obj)).indexOf("/../", j);
            if (i1 == -1)
            {
                break;
            }
            int j1 = ((String) (obj)).lastIndexOf('/', i1 - 1);
            if (j1 >= 0)
            {
                obj = ((String) (obj)).substring(0, j1) + ((String) (obj)).substring(i1 + 3);
            } else
            {
                j = i1 + 3;
            }
        } while (true);
        ac = ((char []) (obj));
        if (((String) (obj)).endsWith("/.."))
        {
            int k = ((String) (obj)).lastIndexOf('/', ((String) (obj)).length() - 4);
            ac = ((char []) (obj));
            if (k >= 0)
            {
                ac = ((String) (obj)).substring(0, k + 1);
            }
        }
        do
        {
            int l = ac.indexOf("/../");
            if (l == -1 || ac.lastIndexOf('/', l - 1) >= 0)
            {
                Object obj1 = ac;
                if (ac.endsWith("/.."))
                {
                    obj1 = ac;
                    if (ac.lastIndexOf('/', ac.length() - 4) < 0)
                    {
                        obj1 = "/";
                    }
                }
                return ((String) (obj1)).toCharArray();
            }
            ac = ac.substring(l + 3);
        } while (true);
    }

    protected void parseAuthority(String s, boolean flag)
        throws URIException
    {
        _is_IPv6reference = false;
        _is_IPv4address = false;
        _is_hostname = false;
        _is_server = false;
        _is_reg_name = false;
        String s1 = getProtocolCharset();
        int i = 1;
        int j = 1;
        int k = 0;
        int l = s.indexOf('@');
        if (l != -1)
        {
            char ac[];
            if (flag)
            {
                ac = s.substring(0, l).toCharArray();
            } else
            {
                ac = encode(s.substring(0, l), allowed_userinfo, s1);
            }
            _userinfo = ac;
            k = l + 1;
        }
        if (s.indexOf('[', k) >= k)
        {
            i = s.indexOf(']', k);
            if (i == -1)
            {
                throw new URIException(1, "IPv6reference");
            }
            i++;
            char ac1[];
            if (flag)
            {
                ac1 = s.substring(k, i).toCharArray();
            } else
            {
                ac1 = encode(s.substring(k, i), allowed_IPv6reference, s1);
            }
            _host = ac1;
            _is_IPv6reference = true;
        } else
        {
            int i1 = s.indexOf(':', k);
            j = i;
            i = i1;
            if (i1 == -1)
            {
                i = s.length();
                j = 0;
            }
            _host = s.substring(k, i).toCharArray();
            if (validate(_host, IPv4address))
            {
                _is_IPv4address = true;
            } else
            if (validate(_host, hostname))
            {
                _is_hostname = true;
            } else
            {
                _is_reg_name = true;
            }
        }
        if (_is_reg_name)
        {
            _is_IPv6reference = false;
            _is_IPv4address = false;
            _is_hostname = false;
            _is_server = false;
            if (flag)
            {
                _authority = s.toCharArray();
                if (!validate(_authority, reg_name))
                {
                    throw new URIException("Invalid authority");
                }
            } else
            {
                _authority = encode(s, allowed_reg_name, s1);
            }
            return;
        }
        if (s.length() - 1 > i && j != 0 && s.charAt(i) == ':')
        {
            try
            {
                _port = Integer.parseInt(s.substring(i + 1));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new URIException(1, "invalid port number");
            }
        }
        s = new StringBuffer();
        if (_userinfo != null)
        {
            s.append(_userinfo);
            s.append('@');
        }
        if (_host != null)
        {
            s.append(_host);
            if (_port != -1)
            {
                s.append(':');
                s.append(_port);
            }
        }
        _authority = s.toString().toCharArray();
        _is_server = true;
    }

    protected void parseUriReference(String s, boolean flag)
        throws URIException
    {
        boolean flag1;
        int j2;
        boolean flag2;
label0:
        {
            if (s == null)
            {
                throw new URIException("URI-Reference required");
            }
            String s1 = s.trim();
            int i = s1.length();
            j2 = i;
            s = s1;
            if (i > 0)
            {
                char c = s1.charAt(0);
                BitSet bitset = delims;
                j2 = i;
                s = s1;
                if (validate(new char[] {
    c
}, bitset))
                {
                    j2 = i;
                    s = s1;
                    if (i >= 2)
                    {
                        char c1 = s1.charAt(i - 1);
                        BitSet bitset1 = delims;
                        j2 = i;
                        s = s1;
                        if (validate(new char[] {
    c1
}, bitset1))
                        {
                            s = s1.substring(1, i - 1);
                            j2 = i - 2;
                        }
                    }
                }
            }
            flag1 = false;
            i = 0;
            int k = s.indexOf(':');
            int i1 = s.indexOf('/');
            if (k > 0 || s.startsWith("//"))
            {
                flag2 = i;
                if (i1 < 0)
                {
                    break label0;
                }
                flag2 = i;
                if (i1 >= k)
                {
                    break label0;
                }
            }
            flag2 = true;
        }
        Object obj;
        int j;
label1:
        {
label2:
            {
                int l;
                int j1;
                int i2;
                int k2;
                if (flag2)
                {
                    obj = "/?#";
                } else
                {
                    obj = ":/?#";
                }
                j = indexFirstOf(s, ((String) (obj)), 0);
                j1 = j;
                if (j == -1)
                {
                    j1 = 0;
                }
                l = j1;
                j = ((flag1) ? 1 : 0);
                if (j1 > 0)
                {
                    l = j1;
                    j = ((flag1) ? 1 : 0);
                    if (j1 < j2)
                    {
                        l = j1;
                        j = ((flag1) ? 1 : 0);
                        if (s.charAt(j1) == ':')
                        {
                            obj = s.substring(0, j1).toLowerCase().toCharArray();
                            if (!validate(((char []) (obj)), scheme))
                            {
                                break label2;
                            }
                            _scheme = ((char []) (obj));
                            l = j1 + 1;
                            j = l;
                        }
                    }
                }
                _is_hier_part = false;
                _is_rel_path = false;
                _is_abs_path = false;
                _is_net_path = false;
                i2 = l;
                k2 = j;
                if (l >= 0)
                {
                    i2 = l;
                    k2 = j;
                    if (l < j2)
                    {
                        i2 = l;
                        k2 = j;
                        if (s.charAt(l) == '/')
                        {
                            _is_hier_part = true;
                            int l1 = l;
                            int k1 = j;
                            if (l + 2 < j2)
                            {
                                l1 = l;
                                k1 = j;
                                if (s.charAt(l + 1) == '/')
                                {
                                    l1 = l;
                                    k1 = j;
                                    if (!flag2)
                                    {
                                        k1 = indexFirstOf(s, "/?#", l + 2);
                                        j = k1;
                                        if (k1 == -1)
                                        {
                                            if (s.substring(l + 2).length() == 0)
                                            {
                                                j = l + 2;
                                            } else
                                            {
                                                j = s.length();
                                            }
                                        }
                                        parseAuthority(s.substring(l + 2, j), flag);
                                        l1 = j;
                                        _is_net_path = true;
                                        k1 = j;
                                    }
                                }
                            }
                            i2 = l1;
                            k2 = k1;
                            if (k1 == l1)
                            {
                                _is_abs_path = true;
                                k2 = k1;
                                i2 = l1;
                            }
                        }
                    }
                }
                if (k2 < j2)
                {
                    l = indexFirstOf(s, "?#", k2);
                    j = l;
                    if (l == -1)
                    {
                        j = s.length();
                    }
                    if (!_is_abs_path)
                    {
                        if (!flag && prevalidate(s.substring(k2, j), disallowed_rel_path) || flag && validate(s.substring(k2, j).toCharArray(), rel_path))
                        {
                            _is_rel_path = true;
                        } else
                        if (!flag && prevalidate(s.substring(k2, j), disallowed_opaque_part) || flag && validate(s.substring(k2, j).toCharArray(), opaque_part))
                        {
                            _is_opaque_part = true;
                        } else
                        {
                            _path = null;
                        }
                    }
                    obj = s.substring(k2, j);
                    if (flag)
                    {
                        setRawPath(((String) (obj)).toCharArray());
                    } else
                    {
                        setPath(((String) (obj)));
                    }
                    i2 = j;
                }
                obj = getProtocolCharset();
                j = i2;
                if (i2 >= 0)
                {
                    j = i2;
                    if (i2 + 1 < j2)
                    {
                        j = i2;
                        if (s.charAt(i2) == '?')
                        {
                            l = s.indexOf('#', i2 + 1);
                            j = l;
                            if (l == -1)
                            {
                                j = s.length();
                            }
                            if (flag)
                            {
                                _query = s.substring(i2 + 1, j).toCharArray();
                                if (!validate(_query, uric))
                                {
                                    throw new URIException("Invalid query");
                                }
                            } else
                            {
                                _query = encode(s.substring(i2 + 1, j), allowed_query, ((String) (obj)));
                            }
                        }
                    }
                }
                break label1;
            }
            throw new URIException("incorrect scheme");
        }
        if (j >= 0 && j + 1 <= j2 && s.charAt(j) == '#')
        {
            if (j + 1 == j2)
            {
                _fragment = "".toCharArray();
            } else
            {
                if (flag)
                {
                    s = s.substring(j + 1).toCharArray();
                } else
                {
                    s = encode(s.substring(j + 1), allowed_fragment, ((String) (obj)));
                }
                _fragment = s;
            }
        }
        setURI();
    }

    protected boolean prevalidate(String s, BitSet bitset)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        s = s.toCharArray();
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= s.length)
                {
                    break label1;
                }
                if (bitset.get(s[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    protected char[] removeFragmentIdentifier(char ac[])
    {
        if (ac == null)
        {
            return null;
        }
        int i = (new String(ac)).indexOf('#');
        char ac1[] = ac;
        if (i != -1)
        {
            ac1 = (new String(ac)).substring(0, i).toCharArray();
        }
        return ac1;
    }

    protected char[] resolvePath(char ac[], char ac1[])
        throws URIException
    {
        String s;
        if (ac == null)
        {
            s = "";
        } else
        {
            s = new String(ac);
        }
        if (ac1 == null || ac1.length == 0)
        {
            return normalize(ac);
        }
        if (ac1[0] == '/')
        {
            return normalize(ac1);
        }
        int i = s.lastIndexOf('/');
        if (i != -1)
        {
            s.substring(0, i + 1).toCharArray();
        }
        StringBuffer stringbuffer = new StringBuffer(s.length() + ac1.length);
        if (i != -1)
        {
            ac = s.substring(0, i + 1);
        } else
        {
            ac = "/";
        }
        stringbuffer.append(ac);
        stringbuffer.append(ac1);
        return normalize(stringbuffer.toString().toCharArray());
    }

    public void setEscapedAuthority(String s)
        throws URIException
    {
        parseAuthority(s, true);
        setURI();
    }

    public void setEscapedFragment(String s)
        throws URIException
    {
        if (s == null)
        {
            _fragment = null;
            hash = 0;
            return;
        } else
        {
            setRawFragment(s.toCharArray());
            return;
        }
    }

    public void setEscapedPath(String s)
        throws URIException
    {
        if (s == null)
        {
            _opaque = null;
            _path = null;
            setURI();
            return;
        } else
        {
            setRawPath(s.toCharArray());
            return;
        }
    }

    public void setEscapedQuery(String s)
        throws URIException
    {
        if (s == null)
        {
            _query = null;
            setURI();
            return;
        } else
        {
            setRawQuery(s.toCharArray());
            return;
        }
    }

    public void setFragment(String s)
        throws URIException
    {
        if (s == null || s.length() == 0)
        {
            if (s == null)
            {
                s = null;
            } else
            {
                s = s.toCharArray();
            }
            _fragment = s;
            hash = 0;
            return;
        } else
        {
            _fragment = encode(s, allowed_fragment, getProtocolCharset());
            hash = 0;
            return;
        }
    }

    public void setPath(String s)
        throws URIException
    {
        if (s == null || s.length() == 0)
        {
            if (s == null)
            {
                s = null;
            } else
            {
                s = s.toCharArray();
            }
            _opaque = s;
            _path = s;
            setURI();
            return;
        }
        String s1 = getProtocolCharset();
        if (_is_net_path || _is_abs_path)
        {
            _path = encode(s, allowed_abs_path, s1);
        } else
        if (_is_rel_path)
        {
            StringBuffer stringbuffer = new StringBuffer(s.length());
            int i = s.indexOf('/');
            if (i == 0)
            {
                throw new URIException(1, "incorrect relative path");
            }
            if (i > 0)
            {
                stringbuffer.append(encode(s.substring(0, i), allowed_rel_path, s1));
                stringbuffer.append(encode(s.substring(i), allowed_abs_path, s1));
            } else
            {
                stringbuffer.append(encode(s, allowed_rel_path, s1));
            }
            _path = stringbuffer.toString().toCharArray();
        } else
        if (_is_opaque_part)
        {
            StringBuffer stringbuffer1 = new StringBuffer();
            stringbuffer1.insert(0, encode(s.substring(0, 1), uric_no_slash, s1));
            stringbuffer1.insert(1, encode(s.substring(1), uric, s1));
            _opaque = stringbuffer1.toString().toCharArray();
        } else
        {
            throw new URIException(1, "incorrect path");
        }
        setURI();
    }

    public void setQuery(String s)
        throws URIException
    {
        if (s == null || s.length() == 0)
        {
            if (s == null)
            {
                s = null;
            } else
            {
                s = s.toCharArray();
            }
            _query = s;
            setURI();
            return;
        } else
        {
            setRawQuery(encode(s, allowed_query, getProtocolCharset()));
            return;
        }
    }

    public void setRawAuthority(char ac[])
        throws URIException, NullPointerException
    {
        parseAuthority(new String(ac), true);
        setURI();
    }

    public void setRawFragment(char ac[])
        throws URIException
    {
        if (ac == null || ac.length == 0)
        {
            _fragment = ac;
            hash = 0;
            return;
        }
        if (!validate(ac, fragment))
        {
            throw new URIException(3, "escaped fragment not valid");
        } else
        {
            _fragment = ac;
            hash = 0;
            return;
        }
    }

    public void setRawPath(char ac[])
        throws URIException
    {
        if (ac == null || ac.length == 0)
        {
            _opaque = ac;
            _path = ac;
            setURI();
            return;
        }
        ac = removeFragmentIdentifier(ac);
        if (_is_net_path || _is_abs_path)
        {
            if (ac[0] != '/')
            {
                throw new URIException(1, "not absolute path");
            }
            if (!validate(ac, abs_path))
            {
                throw new URIException(3, "escaped absolute path not valid");
            }
            _path = ac;
        } else
        if (_is_rel_path)
        {
            int i = indexFirstOf(ac, '/');
            if (i == 0)
            {
                throw new URIException(1, "incorrect path");
            }
            if (i > 0 && !validate(ac, 0, i - 1, rel_segment) && !validate(ac, i, -1, abs_path) || i < 0 && !validate(ac, 0, -1, rel_segment))
            {
                throw new URIException(3, "escaped relative path not valid");
            }
            _path = ac;
        } else
        if (_is_opaque_part)
        {
            if (!uric_no_slash.get(ac[0]) && !validate(ac, 1, -1, uric))
            {
                throw new URIException(3, "escaped opaque part not valid");
            }
            _opaque = ac;
        } else
        {
            throw new URIException(1, "incorrect path");
        }
        setURI();
    }

    public void setRawQuery(char ac[])
        throws URIException
    {
        if (ac == null || ac.length == 0)
        {
            _query = ac;
            setURI();
            return;
        }
        ac = removeFragmentIdentifier(ac);
        if (!validate(ac, query))
        {
            throw new URIException(3, "escaped query not valid");
        } else
        {
            _query = ac;
            setURI();
            return;
        }
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
                stringbuffer.append(_authority);
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

    public String toString()
    {
        return getEscapedURI();
    }

    protected boolean validate(char ac[], int i, int j, BitSet bitset)
    {
        int k = j;
        if (j == -1)
        {
            k = ac.length - 1;
        }
        for (; i <= k; i++)
        {
            if (!bitset.get(ac[i]))
            {
                return false;
            }
        }

        return true;
    }

    protected boolean validate(char ac[], BitSet bitset)
    {
        return validate(ac, 0, -1, bitset);
    }

    static 
    {
        defaultDocumentCharset = null;
        defaultDocumentCharsetByLocale = null;
        defaultDocumentCharsetByPlatform = null;
        Locale locale = Locale.getDefault();
        if (locale != null)
        {
            defaultDocumentCharsetByLocale = LocaleToCharsetMap.getCharset(locale);
            defaultDocumentCharset = defaultDocumentCharsetByLocale;
        }
        try
        {
            defaultDocumentCharsetByPlatform = System.getProperty("file.encoding");
        }
        catch (SecurityException securityexception) { }
        if (defaultDocumentCharset == null)
        {
            defaultDocumentCharset = defaultDocumentCharsetByPlatform;
        }
        percent = new BitSet(256);
        percent.set(37);
        digit = new BitSet(256);
        for (int i = 48; i <= 57; i++)
        {
            digit.set(i);
        }

        alpha = new BitSet(256);
        for (int j = 97; j <= 122; j++)
        {
            alpha.set(j);
        }

        for (int k = 65; k <= 90; k++)
        {
            alpha.set(k);
        }

        alphanum = new BitSet(256);
        alphanum.or(alpha);
        alphanum.or(digit);
        hex = new BitSet(256);
        hex.or(digit);
        for (int l = 97; l <= 102; l++)
        {
            hex.set(l);
        }

        for (int i1 = 65; i1 <= 70; i1++)
        {
            hex.set(i1);
        }

        escaped = new BitSet(256);
        escaped.or(percent);
        escaped.or(hex);
        mark = new BitSet(256);
        mark.set(45);
        mark.set(95);
        mark.set(46);
        mark.set(33);
        mark.set(126);
        mark.set(42);
        mark.set(39);
        mark.set(40);
        mark.set(41);
        unreserved = new BitSet(256);
        unreserved.or(alphanum);
        unreserved.or(mark);
        reserved = new BitSet(256);
        reserved.set(59);
        reserved.set(47);
        reserved.set(63);
        reserved.set(58);
        reserved.set(64);
        reserved.set(38);
        reserved.set(61);
        reserved.set(43);
        reserved.set(36);
        reserved.set(44);
        uric = new BitSet(256);
        uric.or(reserved);
        uric.or(unreserved);
        uric.or(escaped);
        fragment = uric;
        query = uric;
        pchar = new BitSet(256);
        pchar.or(unreserved);
        pchar.or(escaped);
        pchar.set(58);
        pchar.set(64);
        pchar.set(38);
        pchar.set(61);
        pchar.set(43);
        pchar.set(36);
        pchar.set(44);
        param = pchar;
        segment = new BitSet(256);
        segment.or(pchar);
        segment.set(59);
        segment.or(param);
        path_segments = new BitSet(256);
        path_segments.set(47);
        path_segments.or(segment);
        abs_path = new BitSet(256);
        abs_path.set(47);
        abs_path.or(path_segments);
        uric_no_slash = new BitSet(256);
        uric_no_slash.or(unreserved);
        uric_no_slash.or(escaped);
        uric_no_slash.set(59);
        uric_no_slash.set(63);
        uric_no_slash.set(59);
        uric_no_slash.set(64);
        uric_no_slash.set(38);
        uric_no_slash.set(61);
        uric_no_slash.set(43);
        uric_no_slash.set(36);
        uric_no_slash.set(44);
        opaque_part = new BitSet(256);
        opaque_part.or(uric_no_slash);
        opaque_part.or(uric);
        path = new BitSet(256);
        path.or(abs_path);
        path.or(opaque_part);
        port = digit;
        IPv4address = new BitSet(256);
        IPv4address.or(digit);
        IPv4address.set(46);
        IPv6address = new BitSet(256);
        IPv6address.or(hex);
        IPv6address.set(58);
        IPv6address.or(IPv4address);
        IPv6reference = new BitSet(256);
        IPv6reference.set(91);
        IPv6reference.or(IPv6address);
        IPv6reference.set(93);
        toplabel = new BitSet(256);
        toplabel.or(alphanum);
        toplabel.set(45);
        domainlabel = toplabel;
        hostname = new BitSet(256);
        hostname.or(toplabel);
        hostname.set(46);
        host = new BitSet(256);
        host.or(hostname);
        host.or(IPv6reference);
        hostport = new BitSet(256);
        hostport.or(host);
        hostport.set(58);
        hostport.or(port);
        userinfo = new BitSet(256);
        userinfo.or(unreserved);
        userinfo.or(escaped);
        userinfo.set(59);
        userinfo.set(58);
        userinfo.set(38);
        userinfo.set(61);
        userinfo.set(43);
        userinfo.set(36);
        userinfo.set(44);
        within_userinfo = new BitSet(256);
        within_userinfo.or(userinfo);
        within_userinfo.clear(59);
        within_userinfo.clear(58);
        within_userinfo.clear(64);
        within_userinfo.clear(63);
        within_userinfo.clear(47);
        server = new BitSet(256);
        server.or(userinfo);
        server.set(64);
        server.or(hostport);
        reg_name = new BitSet(256);
        reg_name.or(unreserved);
        reg_name.or(escaped);
        reg_name.set(36);
        reg_name.set(44);
        reg_name.set(59);
        reg_name.set(58);
        reg_name.set(64);
        reg_name.set(38);
        reg_name.set(61);
        reg_name.set(43);
        authority = new BitSet(256);
        authority.or(server);
        authority.or(reg_name);
        scheme = new BitSet(256);
        scheme.or(alpha);
        scheme.or(digit);
        scheme.set(43);
        scheme.set(45);
        scheme.set(46);
        rel_segment = new BitSet(256);
        rel_segment.or(unreserved);
        rel_segment.or(escaped);
        rel_segment.set(59);
        rel_segment.set(64);
        rel_segment.set(38);
        rel_segment.set(61);
        rel_segment.set(43);
        rel_segment.set(36);
        rel_segment.set(44);
        rel_path = new BitSet(256);
        rel_path.or(rel_segment);
        rel_path.or(abs_path);
        net_path = new BitSet(256);
        net_path.set(47);
        net_path.or(authority);
        net_path.or(abs_path);
        hier_part = new BitSet(256);
        hier_part.or(net_path);
        hier_part.or(abs_path);
        hier_part.or(query);
        relativeURI = new BitSet(256);
        relativeURI.or(net_path);
        relativeURI.or(abs_path);
        relativeURI.or(rel_path);
        relativeURI.or(query);
        absoluteURI = new BitSet(256);
        absoluteURI.or(scheme);
        absoluteURI.set(58);
        absoluteURI.or(hier_part);
        absoluteURI.or(opaque_part);
        URI_reference = new BitSet(256);
        URI_reference.or(absoluteURI);
        URI_reference.or(relativeURI);
        URI_reference.set(35);
        URI_reference.or(fragment);
        control = new BitSet(256);
        for (int j1 = 0; j1 <= 31; j1++)
        {
            control.set(j1);
        }

        control.set(127);
        space = new BitSet(256);
        space.set(32);
        delims = new BitSet(256);
        delims.set(60);
        delims.set(62);
        delims.set(35);
        delims.set(37);
        delims.set(34);
        unwise = new BitSet(256);
        unwise.set(123);
        unwise.set(125);
        unwise.set(124);
        unwise.set(92);
        unwise.set(94);
        unwise.set(91);
        unwise.set(93);
        unwise.set(96);
        disallowed_rel_path = new BitSet(256);
        disallowed_rel_path.or(uric);
        disallowed_rel_path.andNot(rel_path);
        disallowed_opaque_part = new BitSet(256);
        disallowed_opaque_part.or(uric);
        disallowed_opaque_part.andNot(opaque_part);
        allowed_authority = new BitSet(256);
        allowed_authority.or(authority);
        allowed_authority.clear(37);
        allowed_opaque_part = new BitSet(256);
        allowed_opaque_part.or(opaque_part);
        allowed_opaque_part.clear(37);
        allowed_reg_name = new BitSet(256);
        allowed_reg_name.or(reg_name);
        allowed_reg_name.clear(37);
        allowed_userinfo = new BitSet(256);
        allowed_userinfo.or(userinfo);
        allowed_userinfo.clear(37);
        allowed_within_userinfo = new BitSet(256);
        allowed_within_userinfo.or(within_userinfo);
        allowed_within_userinfo.clear(37);
        allowed_IPv6reference = new BitSet(256);
        allowed_IPv6reference.or(IPv6reference);
        allowed_IPv6reference.clear(91);
        allowed_IPv6reference.clear(93);
        allowed_host = new BitSet(256);
        allowed_host.or(hostname);
        allowed_host.or(allowed_IPv6reference);
        allowed_within_authority = new BitSet(256);
        allowed_within_authority.or(server);
        allowed_within_authority.or(reg_name);
        allowed_within_authority.clear(59);
        allowed_within_authority.clear(58);
        allowed_within_authority.clear(64);
        allowed_within_authority.clear(63);
        allowed_within_authority.clear(47);
        allowed_abs_path = new BitSet(256);
        allowed_abs_path.or(abs_path);
        allowed_abs_path.andNot(percent);
        allowed_abs_path.clear(43);
        allowed_rel_path = new BitSet(256);
        allowed_rel_path.or(rel_path);
        allowed_rel_path.clear(37);
        allowed_rel_path.clear(43);
        allowed_within_path = new BitSet(256);
        allowed_within_path.or(abs_path);
        allowed_within_path.clear(47);
        allowed_within_path.clear(59);
        allowed_within_path.clear(61);
        allowed_within_path.clear(63);
        allowed_query = new BitSet(256);
        allowed_query.or(uric);
        allowed_query.clear(37);
        allowed_within_query = new BitSet(256);
        allowed_within_query.or(allowed_query);
        allowed_within_query.andNot(reserved);
        allowed_fragment = new BitSet(256);
        allowed_fragment.or(uric);
        allowed_fragment.clear(37);
    }
}
