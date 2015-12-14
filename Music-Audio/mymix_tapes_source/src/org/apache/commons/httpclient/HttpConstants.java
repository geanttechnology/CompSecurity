// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.UnsupportedEncodingException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpConstants
{

    public static final String DEFAULT_CONTENT_CHARSET = "ISO-8859-1";
    public static final String HTTP_ELEMENT_CHARSET = "US-ASCII";
    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$HttpConstants;

    public HttpConstants()
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
            throw new RuntimeException("HttpClient requires ASCII support");
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
            throw new RuntimeException("HttpClient requires ASCII support");
        }
        return abyte0;
    }

    public static byte[] getBytes(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        byte abyte0[];
        try
        {
            abyte0 = s.getBytes("US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            if (LOG.isWarnEnabled())
            {
                LOG.warn("Unsupported encoding: US-ASCII. System default encoding used");
            }
            return s.getBytes();
        }
        return abyte0;
    }

    public static byte[] getContentBytes(String s)
    {
        return getContentBytes(s, null);
    }

    public static byte[] getContentBytes(String s, String s1)
    {
        String s2;
label0:
        {
            if (s == null)
            {
                throw new IllegalArgumentException("Parameter may not be null");
            }
            if (s1 != null)
            {
                s2 = s1;
                if (!s1.equals(""))
                {
                    break label0;
                }
            }
            s2 = "ISO-8859-1";
        }
        try
        {
            s1 = s.getBytes(s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            if (LOG.isWarnEnabled())
            {
                LOG.warn("Unsupported encoding: " + s2 + ". HTTP default encoding used");
            }
            try
            {
                s1 = s.getBytes("ISO-8859-1");
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                if (LOG.isWarnEnabled())
                {
                    LOG.warn("Unsupported encoding: ISO-8859-1. System encoding used");
                }
                return s.getBytes();
            }
            return s1;
        }
        return s1;
    }

    public static String getContentString(byte abyte0[])
    {
        return getContentString(abyte0, null);
    }

    public static String getContentString(byte abyte0[], int i, int j)
    {
        return getContentString(abyte0, i, j, null);
    }

    public static String getContentString(byte abyte0[], int i, int j, String s)
    {
        String s1;
label0:
        {
            if (abyte0 == null)
            {
                throw new IllegalArgumentException("Parameter may not be null");
            }
            if (s != null)
            {
                s1 = s;
                if (!s.equals(""))
                {
                    break label0;
                }
            }
            s1 = "ISO-8859-1";
        }
        try
        {
            s = new String(abyte0, i, j, s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (LOG.isWarnEnabled())
            {
                LOG.warn("Unsupported encoding: " + s1 + ". Default HTTP encoding used");
            }
            try
            {
                s = new String(abyte0, i, j, "ISO-8859-1");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (LOG.isWarnEnabled())
                {
                    LOG.warn("Unsupported encoding: ISO-8859-1. System encoding used");
                }
                return new String(abyte0, i, j);
            }
            return s;
        }
        return s;
    }

    public static String getContentString(byte abyte0[], String s)
    {
        return getContentString(abyte0, 0, abyte0.length, s);
    }

    public static String getString(byte abyte0[])
    {
        return getString(abyte0, 0, abyte0.length);
    }

    public static String getString(byte abyte0[], int i, int j)
    {
        if (abyte0 == null)
        {
            throw new IllegalArgumentException("Parameter may not be null");
        }
        String s;
        try
        {
            s = new String(abyte0, i, j, "US-ASCII");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            if (LOG.isWarnEnabled())
            {
                LOG.warn("Unsupported encoding: US-ASCII. System default encoding used");
            }
            return new String(abyte0, i, j);
        }
        return s;
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$HttpConstants == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.HttpConstants");
            class$org$apache$commons$httpclient$HttpConstants = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$HttpConstants;
        }
        LOG = LogFactory.getLog(class1);
    }
}
