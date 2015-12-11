// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

class StringUtils
{

    private static final String TAG;
    private static final char hexArray[];
    private static final MessageDigest m_md5Digest;
    private static final MessageDigest m_sha1Digest;

    StringUtils()
    {
    }

    static String ListToSeperatedString(List list, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s1 = (String)list.next();
            if (!s1.isEmpty())
            {
                if (stringbuilder.length() > 0)
                {
                    stringbuilder.append(s);
                }
                stringbuilder.append(s1);
            }
        } while (true);
        return stringbuilder.toString();
    }

    static String MD5(String s)
    {
        if (s == null || s.isEmpty())
        {
            return "";
        }
        if (m_md5Digest != null)
        {
            m_md5Digest.update(s.getBytes());
            return bytesToHex(m_md5Digest.digest());
        } else
        {
            return "";
        }
    }

    static String bytesToHex(byte abyte0[])
    {
        char ac[] = new char[abyte0.length * 2];
        for (int i = 0; i < abyte0.length; i++)
        {
            int j = abyte0[i] & 0xff;
            ac[i * 2] = hexArray[j >>> 4];
            ac[i * 2 + 1] = hexArray[j & 0xf];
        }

        return new String(ac);
    }

    static Header[] mapToHeader(Map map)
    {
        Header aheader[] = new Header[map.size()];
        int i = 0;
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (!((String)entry.getKey()).isEmpty() && !((String)entry.getValue()).isEmpty())
            {
                aheader[i] = new BasicHeader((String)entry.getKey(), (String)entry.getValue());
                i++;
            }
        } while (true);
        return (Header[])Arrays.copyOf(aheader, i);
    }

    static String new_session_id()
    {
        return UUID.randomUUID().toString().toLowerCase(Locale.US).replaceAll("-", "");
    }

    static List splitNonRegex(String s, String s1)
    {
        ArrayList arraylist = new ArrayList();
        do
        {
            int i = s.indexOf(s1);
            if (i == -1)
            {
                if (!s.isEmpty())
                {
                    arraylist.add(s);
                }
                return arraylist;
            }
            if (i > 1)
            {
                arraylist.add(s.substring(0, i));
            }
            s = s.substring(s1.length() + i);
        } while (true);
    }

    static Map splitQuery(String s)
    {
        LinkedHashMap linkedhashmap = new LinkedHashMap();
        for (s = splitNonRegex(s, "&").iterator(); s.hasNext();)
        {
            String s1 = (String)s.next();
            int i = s1.indexOf("=");
            try
            {
                linkedhashmap.put(URLDecoder.decode(s1.substring(0, i), "UTF-8"), URLDecoder.decode(s1.substring(i + 1), "UTF-8"));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                Log.d(TAG, "Unsupported encoding", unsupportedencodingexception);
            }
        }

        return linkedhashmap;
    }

    static String xor(String s, String s1)
    {
        String s2 = (new StringBuilder()).append(s.length()).append("&").toString();
        byte abyte0[] = new byte[s.length() + s2.length()];
        int i1 = s1.length();
        int j = 0;
        int i = 0;
        int k = 0;
        while (k < s2.length()) 
        {
            byte byte0 = (byte)s2.charAt(k);
            int l = j + 1;
            abyte0[i] = (byte)(byte0 ^ (byte)s1.charAt(j) & 0xa);
            if (l >= i1)
            {
                j = 0;
            } else
            {
                j = l;
            }
            k++;
            i++;
        }
        k = 0;
        l = j;
        j = i;
        while (k < s.length()) 
        {
            byte0 = (byte)s.charAt(k);
            i = l + 1;
            abyte0[j] = (byte)(byte0 ^ (byte)s1.charAt(l) & 0xa);
            if (i >= i1)
            {
                i = 0;
            }
            k++;
            j++;
            l = i;
        }
        return bytesToHex(abyte0);
    }

    static 
    {
        MessageDigest messagedigest;
        TAG = com/threatmetrix/TrustDefenderMobile/StringUtils.getSimpleName();
        hexArray = "0123456789abcdef".toCharArray();
        messagedigest = null;
        MessageDigest messagedigest1 = MessageDigest.getInstance("MD5");
        messagedigest = messagedigest1;
_L1:
        m_md5Digest = messagedigest;
        messagedigest = null;
        messagedigest1 = MessageDigest.getInstance("SHA1");
        messagedigest = messagedigest1;
_L2:
        m_sha1Digest = messagedigest;
        return;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        Log.v(TAG, "MD5 digest failed", nosuchalgorithmexception);
          goto _L1
        nosuchalgorithmexception;
        Log.v(TAG, "SHA1 digest failed", nosuchalgorithmexception);
          goto _L2
    }
}
