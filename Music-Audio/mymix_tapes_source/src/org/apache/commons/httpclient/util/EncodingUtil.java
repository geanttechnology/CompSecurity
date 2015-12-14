// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.util;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.net.URLCodec;
import org.apache.commons.httpclient.HttpClientError;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EncodingUtil
{

    private static final String DEFAULT_CHARSET = "ISO-8859-1";
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$util$EncodingUtil;

    private EncodingUtil()
    {
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    private static String doFormUrlEncode(NameValuePair anamevaluepair[], String s)
        throws UnsupportedEncodingException
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < anamevaluepair.length; i++)
        {
            URLCodec urlcodec = new URLCodec();
            NameValuePair namevaluepair = anamevaluepair[i];
            if (namevaluepair.getName() == null)
            {
                continue;
            }
            if (i > 0)
            {
                stringbuffer.append("&");
            }
            stringbuffer.append(urlcodec.encode(namevaluepair.getName(), s));
            stringbuffer.append("=");
            if (namevaluepair.getValue() != null)
            {
                stringbuffer.append(urlcodec.encode(namevaluepair.getValue(), s));
            }
        }

        return stringbuffer.toString();
    }

    public static String formUrlEncode(NameValuePair anamevaluepair[], String s)
    {
        String s1;
        try
        {
            s1 = doFormUrlEncode(anamevaluepair, s);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            LOG.error("Encoding not supported: " + s);
            try
            {
                anamevaluepair = doFormUrlEncode(anamevaluepair, "ISO-8859-1");
            }
            // Misplaced declaration of an exception variable
            catch (NameValuePair anamevaluepair[])
            {
                throw new HttpClientError("Encoding not supported: ISO-8859-1");
            }
            return anamevaluepair;
        }
        return s1;
    }

    public static byte[] getAsciiBytes(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try
        {
            s = s.getBytes("US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new HttpClientError("HttpClient requires ASCII support");
        }
        return s;
    }

    public static String getAsciiString(byte abyte0[])
    {
        return getAsciiString(abyte0, 0, abyte0.length);
    }

    public static String getAsciiString(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        try
        {
            abyte0 = new String(abyte0, i, j, "US-ASCII");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new HttpClientError("HttpClient requires ASCII support");
        }
        return abyte0;
    }

    public static byte[] getBytes(String s, String s1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("data may not be null");
        }
        if (s1 == null || s1.length() == 0)
        {
            throw new IllegalArgumentException("charset may not be null or empty");
        }
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes(s1);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            if (LOG.isWarnEnabled())
            {
                LOG.warn("Unsupported encoding: " + s1 + ". System encoding used.");
            }
            return s.getBytes();
        }
        return abyte0;
    }

    public static String getString(byte abyte0[], int i, int j, String s)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("charset may not be null or empty");
        }
        String s1;
        try
        {
            s1 = new String(abyte0, i, j, s);
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            if (LOG.isWarnEnabled())
            {
                LOG.warn("Unsupported encoding: " + s + ". System encoding used");
            }
            return new String(abyte0, i, j);
        }
        return s1;
    }

    public static String getString(byte abyte0[], String s)
    {
        return getString(abyte0, 0, abyte0.length, s);
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$util$EncodingUtil == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.util.EncodingUtil");
            class$org$apache$commons$httpclient$util$EncodingUtil = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$util$EncodingUtil;
        }
        LOG = LogFactory.getLog(class1);
    }
}
