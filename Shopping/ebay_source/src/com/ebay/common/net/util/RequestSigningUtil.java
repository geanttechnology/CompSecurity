// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.util;

import android.net.Uri;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class RequestSigningUtil
{
    private static class KeyValuePair
        implements Comparable
    {

        public String key;
        public String value;

        public int compareTo(KeyValuePair keyvaluepair)
        {
            if (key.compareTo(keyvaluepair.key) == 0 && value.compareTo(keyvaluepair.value) == 0)
            {
                return 0;
            }
            if (key.compareTo(keyvaluepair.key) != 0)
            {
                return key.compareTo(keyvaluepair.key);
            } else
            {
                return value.compareTo(keyvaluepair.value);
            }
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((KeyValuePair)obj);
        }

        public String toString()
        {
            return String.format("%s=%s", new Object[] {
                RequestSigningUtil.percentEncodeRfc3986(key), RequestSigningUtil.percentEncodeRfc3986(value)
            });
        }

        private KeyValuePair()
        {
            value = null;
        }

    }


    private static String SHA256_EMPTY_PAYLOAD = "e3b0c44298fc1c149afbf4c8996fb92427ae41e4649b934ca495991b7852b855";

    public RequestSigningUtil()
    {
    }

    private static byte[] getHmac(byte abyte0[], byte abyte1[])
    {
        try
        {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(abyte1, mac.getAlgorithm()));
            abyte0 = mac.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException("Couldn't create HMAC!", abyte0);
        }
        return abyte0;
    }

    private static String hmacSha1(byte abyte0[], byte abyte1[])
    {
        return toHexString(getHmac(abyte0, abyte1));
    }

    private static String percentEncodeRfc3986(String s)
    {
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            return s;
        }
        return s1;
    }

    public static URL signUrl(String s, URL url, byte abyte0[], byte abyte1[])
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "GET";
        }
        s = new ArrayList();
        StringBuilder stringbuilder = new StringBuilder();
        String as[];
        String s2;
        KeyValuePair keyvaluepair;
        int i;
        int j;
        int k;
        try
        {
            stringbuilder.append(s1);
            stringbuilder.append(url.getPath());
            s1 = url.getQuery();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        if (s1 == null) goto _L2; else goto _L1
_L1:
        if (s1.length() <= 0) goto _L2; else goto _L3
_L3:
        as = s1.replace('+', ' ').split("&");
        j = as.length;
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = as[i];
        keyvaluepair = new KeyValuePair();
        keyvaluepair.key = s2;
        keyvaluepair.value = "";
        k = s2.indexOf('=');
        if (k <= -1)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        keyvaluepair.key = s2.substring(0, k);
        keyvaluepair.value = s2.substring(k + 1);
        s.add(keyvaluepair);
        i++;
        if (true) goto _L4; else goto _L2
_L2:
        Collections.sort(s);
        stringbuilder.append(TextUtils.join("&", s));
        if (abyte0 == null) goto _L6; else goto _L5
_L5:
        stringbuilder.append(toHexString(MessageDigest.getInstance("SHA-256").digest(abyte0)));
_L8:
        s = hmacSha1(stringbuilder.toString().getBytes(), abyte1);
        return new URL(Uri.parse(url.toString()).buildUpon().appendQueryParameter("X-H", s).toString());
_L6:
        stringbuilder.append(SHA256_EMPTY_PAYLOAD);
        if (true) goto _L8; else goto _L7
_L7:
        break MISSING_BLOCK_LABEL_52;
    }

    private static String toHexString(byte abyte0[])
    {
        int j = abyte0.length;
        StringBuilder stringbuilder = new StringBuilder(j * 2);
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append("0123456789abcdef".charAt(abyte0[i] >> 4 & 0xf));
            stringbuilder.append("0123456789abcdef".charAt(abyte0[i] & 0xf));
        }

        return stringbuilder.toString();
    }


}
