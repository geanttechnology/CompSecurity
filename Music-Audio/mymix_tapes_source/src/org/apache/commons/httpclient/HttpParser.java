// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.commons.httpclient.util.EncodingUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// Referenced classes of package org.apache.commons.httpclient:
//            HttpException, Header, ProtocolException, Wire

public class HttpParser
{

    private static final Log LOG;
    static Class class$org$apache$commons$httpclient$HttpParser;

    private HttpParser()
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

    public static Header[] parseHeaders(InputStream inputstream)
        throws IOException, HttpException
    {
        LOG.trace("enter HeaderParser.parseHeaders(InputStream, String)");
        return parseHeaders(inputstream, "US-ASCII");
    }

    public static Header[] parseHeaders(InputStream inputstream, String s)
        throws IOException, HttpException
    {
        LOG.trace("enter HeaderParser.parseHeaders(InputStream, String)");
        ArrayList arraylist = new ArrayList();
        String s1 = null;
        StringBuffer stringbuffer = null;
        do
        {
            String s2 = readLine(inputstream, s);
            if (s2 == null || s2.trim().length() < 1)
            {
                if (s1 != null)
                {
                    arraylist.add(new Header(s1, stringbuffer.toString()));
                }
                return (Header[])(Header[])arraylist.toArray(new Header[arraylist.size()]);
            }
            if (s2.charAt(0) == ' ' || s2.charAt(0) == '\t')
            {
                if (stringbuffer != null)
                {
                    stringbuffer.append(' ');
                    stringbuffer.append(s2.trim());
                }
            } else
            {
                if (s1 != null)
                {
                    arraylist.add(new Header(s1, stringbuffer.toString()));
                }
                int i = s2.indexOf(":");
                if (i < 0)
                {
                    throw new ProtocolException("Unable to parse header: " + s2);
                }
                s1 = s2.substring(0, i).trim();
                stringbuffer = new StringBuffer(s2.substring(i + 1).trim());
            }
        } while (true);
    }

    public static String readLine(InputStream inputstream)
        throws IOException
    {
        LOG.trace("enter HttpParser.readLine(InputStream)");
        return readLine(inputstream, "US-ASCII");
    }

    public static String readLine(InputStream inputstream, String s)
        throws IOException
    {
        LOG.trace("enter HttpParser.readLine(InputStream, String)");
        inputstream = readRawLine(inputstream);
        if (inputstream != null) goto _L2; else goto _L1
_L1:
        inputstream = null;
_L4:
        return inputstream;
_L2:
        int i;
        int k = inputstream.length;
        boolean flag = false;
        i = ((flag) ? 1 : 0);
        if (k > 0)
        {
            i = ((flag) ? 1 : 0);
            if (inputstream[k - 1] == 10)
            {
                int j = 0 + 1;
                i = j;
                if (k > 1)
                {
                    i = j;
                    if (inputstream[k - 2] == 13)
                    {
                        i = j + 1;
                    }
                }
            }
        }
        s = EncodingUtil.getString(inputstream, 0, k - i, s);
        inputstream = s;
        if (!Wire.HEADER_WIRE.enabled()) goto _L4; else goto _L3
_L3:
        inputstream = s;
        if (i != 2) goto _L6; else goto _L5
_L5:
        inputstream = s + "\r\n";
_L8:
        Wire.HEADER_WIRE.input(inputstream);
        return s;
_L6:
        if (i == 1)
        {
            inputstream = s + "\n";
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static byte[] readRawLine(InputStream inputstream)
        throws IOException
    {
        LOG.trace("enter HttpParser.readRawLine()");
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        int i;
        do
        {
            i = inputstream.read();
            if (i < 0)
            {
                break;
            }
            bytearrayoutputstream.write(i);
        } while (i != 10);
        if (bytearrayoutputstream.size() == 0)
        {
            return null;
        } else
        {
            return bytearrayoutputstream.toByteArray();
        }
    }

    static 
    {
        Class class1;
        if (class$org$apache$commons$httpclient$HttpParser == null)
        {
            class1 = _mthclass$("org.apache.commons.httpclient.HttpParser");
            class$org$apache$commons$httpclient$HttpParser = class1;
        } else
        {
            class1 = class$org$apache$commons$httpclient$HttpParser;
        }
        LOG = LogFactory.getLog(class1);
    }
}
