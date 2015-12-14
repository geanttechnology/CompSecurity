// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;

// Referenced classes of package org.apache.commons.httpclient.util:
//            EncodingUtil

public class URIUtil
{
    protected static class Coder extends URI
    {

        public static String decode(char ac[], String s)
            throws URIException
        {
            return URI.decode(ac, s);
        }

        public static char[] encode(String s, BitSet bitset, String s1)
            throws URIException
        {
            return URI.encode(s, bitset, s1);
        }

        public static String replace(String s, char c, char c1)
        {
            StringBuffer stringbuffer = new StringBuffer(s.length());
            int i = 0;
            do
            {
                int j = s.indexOf(c);
                if (j >= 0)
                {
                    stringbuffer.append(s.substring(0, j));
                    stringbuffer.append(c1);
                } else
                {
                    stringbuffer.append(s.substring(i));
                }
                i = j;
            } while (j >= 0);
            return stringbuffer.toString();
        }

        public static String replace(String s, char ac[], char ac1[])
        {
            for (int i = ac.length; i > 0; i--)
            {
                s = replace(s, ac[i], ac1[i]);
            }

            return s;
        }

        public static boolean verifyEscaped(char ac[])
        {
            int i = 0;
_L7:
            if (i >= ac.length) goto _L2; else goto _L1
_L1:
            char c = ac[i];
            if (c <= '\200') goto _L4; else goto _L3
_L3:
            return false;
_L4:
            int j;
            j = i;
            if (c != '%')
            {
                continue; /* Loop/switch isn't completed */
            }
            i++;
            if (Character.digit(ac[i], 16) == -1) goto _L3; else goto _L5
_L5:
            j = i + 1;
            if (Character.digit(ac[j], 16) == -1) goto _L3; else goto _L6
_L6:
            i = j + 1;
              goto _L7
_L2:
            return true;
        }

        protected Coder()
        {
        }
    }


    protected static final BitSet empty = new BitSet(1);

    public URIUtil()
    {
    }

    public static String decode(String s)
        throws URIException
    {
        try
        {
            s = EncodingUtil.getString(URLCodec.decodeUrl(EncodingUtil.getAsciiBytes(s)), URI.getDefaultProtocolCharset());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new URIException(s.getMessage());
        }
        return s;
    }

    public static String decode(String s, String s1)
        throws URIException
    {
        return Coder.decode(s.toCharArray(), s1);
    }

    public static String encode(String s, BitSet bitset)
        throws URIException
    {
        return encode(s, bitset, URI.getDefaultProtocolCharset());
    }

    public static String encode(String s, BitSet bitset, String s1)
        throws URIException
    {
        return EncodingUtil.getAsciiString(URLCodec.encodeUrl(bitset, EncodingUtil.getBytes(s, s1)));
    }

    public static String encodeAll(String s)
        throws URIException
    {
        return encodeAll(s, URI.getDefaultProtocolCharset());
    }

    public static String encodeAll(String s, String s1)
        throws URIException
    {
        return encode(s, empty, s1);
    }

    public static String encodePath(String s)
        throws URIException
    {
        return encodePath(s, URI.getDefaultProtocolCharset());
    }

    public static String encodePath(String s, String s1)
        throws URIException
    {
        return encode(s, URI.allowed_abs_path, s1);
    }

    public static String encodePathQuery(String s)
        throws URIException
    {
        return encodePathQuery(s, URI.getDefaultProtocolCharset());
    }

    public static String encodePathQuery(String s, String s1)
        throws URIException
    {
        int i = s.indexOf('?');
        if (i < 0)
        {
            return encode(s, URI.allowed_abs_path, s1);
        } else
        {
            return encode(s.substring(0, i), URI.allowed_abs_path, s1) + '?' + encode(s.substring(i + 1), URI.allowed_query, s1);
        }
    }

    public static String encodeQuery(String s)
        throws URIException
    {
        return encodeQuery(s, URI.getDefaultProtocolCharset());
    }

    public static String encodeQuery(String s, String s1)
        throws URIException
    {
        return encode(s, URI.allowed_query, s1);
    }

    public static String encodeWithinAuthority(String s)
        throws URIException
    {
        return encodeWithinAuthority(s, URI.getDefaultProtocolCharset());
    }

    public static String encodeWithinAuthority(String s, String s1)
        throws URIException
    {
        return encode(s, URI.allowed_within_authority, s1);
    }

    public static String encodeWithinPath(String s)
        throws URIException
    {
        return encodeWithinPath(s, URI.getDefaultProtocolCharset());
    }

    public static String encodeWithinPath(String s, String s1)
        throws URIException
    {
        return encode(s, URI.allowed_within_path, s1);
    }

    public static String encodeWithinQuery(String s)
        throws URIException
    {
        return encodeWithinQuery(s, URI.getDefaultProtocolCharset());
    }

    public static String encodeWithinQuery(String s, String s1)
        throws URIException
    {
        return encode(s, URI.allowed_within_query, s1);
    }

    public static String getFromPath(String s)
    {
        boolean flag = false;
        if (s == null)
        {
            s = null;
        } else
        {
            int j = s.indexOf("//");
            int i = ((flag) ? 1 : 0);
            if (j >= 0)
            {
                if (s.lastIndexOf("/", j - 1) >= 0)
                {
                    i = ((flag) ? 1 : 0);
                } else
                {
                    i = j + 2;
                }
            }
            i = s.indexOf("/", i);
            if (i < 0)
            {
                if (j >= 0)
                {
                    return "/";
                }
            } else
            {
                return s.substring(i);
            }
        }
        return s;
    }

    public static String getName(String s)
    {
        if (s != null && s.length() != 0)
        {
            String s1 = getPath(s);
            int i = s1.lastIndexOf("/");
            int j = s1.length();
            s = s1;
            if (i >= 0)
            {
                return s1.substring(i + 1, j);
            }
        }
        return s;
    }

    public static String getPath(String s)
    {
        int j = 0;
        if (s == null)
        {
            s = null;
        } else
        {
            int k = s.indexOf("//");
            int i = j;
            int l;
            if (k >= 0)
            {
                if (s.lastIndexOf("/", k - 1) >= 0)
                {
                    i = j;
                } else
                {
                    i = k + 2;
                }
            }
            l = s.indexOf("/", i);
            i = s.length();
            if (s.indexOf('?', l) != -1)
            {
                i = s.indexOf('?', l);
            }
            j = i;
            if (s.lastIndexOf("#") > l)
            {
                j = i;
                if (s.lastIndexOf("#") < i)
                {
                    j = s.lastIndexOf("#");
                }
            }
            if (l < 0)
            {
                if (k >= 0)
                {
                    return "/";
                }
            } else
            {
                return s.substring(l, j);
            }
        }
        return s;
    }

    public static String getPathQuery(String s)
    {
        int j = 0;
        if (s == null)
        {
            s = null;
        } else
        {
            int k = s.indexOf("//");
            int i = j;
            if (k >= 0)
            {
                if (s.lastIndexOf("/", k - 1) >= 0)
                {
                    i = j;
                } else
                {
                    i = k + 2;
                }
            }
            j = s.indexOf("/", i);
            i = s.length();
            if (s.lastIndexOf("#") > j)
            {
                i = s.lastIndexOf("#");
            }
            if (j < 0)
            {
                if (k >= 0)
                {
                    return "/";
                }
            } else
            {
                return s.substring(j, i);
            }
        }
        return s;
    }

    public static String getQuery(String s)
    {
        int j = 0;
        if (s != null && s.length() != 0)
        {
            int k = s.indexOf("//");
            int i = j;
            if (k >= 0)
            {
                if (s.lastIndexOf("/", k - 1) >= 0)
                {
                    i = j;
                } else
                {
                    i = k + 2;
                }
            }
            j = s.indexOf("/", i);
            i = s.length();
            j = s.indexOf("?", j);
            if (j >= 0)
            {
                j++;
                if (s.lastIndexOf("#") > j)
                {
                    i = s.lastIndexOf("#");
                }
                if (j < 0 || j == i)
                {
                    s = null;
                } else
                {
                    s = s.substring(j, i);
                }
                return s;
            }
        }
        return null;
    }

}
