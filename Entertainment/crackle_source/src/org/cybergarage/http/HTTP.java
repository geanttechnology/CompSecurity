// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.net.URL;

public class HTTP
{

    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CALLBACK = "CALLBACK";
    public static final String CHARSET = "charset";
    public static final String CHUNKED = "Chunked";
    public static final String CLOSE = "close";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_RANGE_BYTES = "bytes";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final byte CR = 13;
    public static final String CRLF = "\r\n";
    public static final String DATE = "Date";
    public static final int DEFAULT_CHUNK_SIZE = 0x80000;
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_TIMEOUT = 30;
    public static final String EXT = "EXT";
    public static final String GET = "GET";
    public static final String HEAD = "HEAD";
    public static final String HEADER_LINE_DELIM = " :";
    public static final String HOST = "HOST";
    public static final String KEEP_ALIVE = "Keep-Alive";
    public static final byte LF = 10;
    public static final String LOCATION = "Location";
    public static final String MAN = "MAN";
    public static final String MAX_AGE = "max-age";
    public static final String MX = "MX";
    public static final String MYNAME = "MYNAME";
    public static final String M_SEARCH = "M-SEARCH";
    public static final String NOTIFY = "NOTIFY";
    public static final String NO_CACHE = "no-cache";
    public static final String NT = "NT";
    public static final String NTS = "NTS";
    public static final String POST = "POST";
    public static final String RANGE = "Range";
    public static final String REQEST_LINE_DELIM = " ";
    public static final String SEQ = "SEQ";
    public static final String SERVER = "Server";
    public static final String SID = "SID";
    public static final String SOAP_ACTION = "SOAPACTION";
    public static final String ST = "ST";
    public static final String STATUS_LINE_DELIM = " ";
    public static final String SUBSCRIBE = "SUBSCRIBE";
    public static final String TAB = "\t";
    public static final String TIMEOUT = "TIMEOUT";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String UNSUBSCRIBE = "UNSUBSCRIBE";
    public static final String USN = "USN";
    public static final String VERSION = "1.1";
    public static final String VERSION_10 = "1.0";
    public static final String VERSION_11 = "1.1";
    private static int chunkSize = 0x80000;

    public HTTP()
    {
    }

    public static final String getAbsoluteURL(String s, String s1)
    {
        try
        {
            s = new URL(s);
            s = (new StringBuilder(String.valueOf(s.getProtocol()))).append("://").append(s.getHost()).append(":").append(s.getPort()).append(toRelativeURL(s1)).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public static final int getChunkSize()
    {
        return chunkSize;
    }

    public static final String getHost(String s)
    {
        try
        {
            s = (new URL(s)).getHost();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    public static final int getPort(String s)
    {
        int i;
        int j;
        try
        {
            i = (new URL(s)).getPort();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return 80;
        }
        j = i;
        if (i <= 0)
        {
            j = 80;
        }
        return j;
    }

    public static final String getRequestHostURL(String s, int i)
    {
        return (new StringBuilder("http://")).append(s).append(":").append(i).toString();
    }

    public static final boolean isAbsoluteURL(String s)
    {
        try
        {
            new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static final void setChunkSize(int i)
    {
        chunkSize = i;
    }

    public static final String toRelativeURL(String s)
    {
        return toRelativeURL(s, true);
    }

    public static final String toRelativeURL(String s, boolean flag)
    {
        String s2 = s;
        if (isAbsoluteURL(s)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = s2;
        if (s.length() > 0)
        {
            obj = s2;
            if (s.charAt(0) != '/')
            {
                obj = (new StringBuilder("/")).append(s).toString();
            }
        }
_L4:
        return ((String) (obj));
_L2:
        String s1 = s2;
        try
        {
            obj = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return s1;
        }
        s1 = s2;
        s2 = ((URL) (obj)).getPath();
        s = s2;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s1 = s2;
        obj = ((URL) (obj)).getQuery();
        s = s2;
        s1 = s2;
        if (((String) (obj)).equals(""))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s1 = s2;
        s = (new StringBuilder(String.valueOf(s2))).append("?").append(((String) (obj))).toString();
        obj = s;
        s1 = s;
        if (!s.endsWith("/")) goto _L4; else goto _L3
_L3:
        s1 = s;
        s = s.substring(0, s.length() - 1);
        return s;
    }

}
