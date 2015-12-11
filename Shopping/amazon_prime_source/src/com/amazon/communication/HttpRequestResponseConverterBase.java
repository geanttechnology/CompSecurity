// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.communication:
//            HttpRequestResponseConverter, ProtocolException

public abstract class HttpRequestResponseConverterBase
    implements HttpRequestResponseConverter
{

    protected static final String COLON_DELIMITER = ":";
    public static final String CONNECTION_TIMEOUT_MS_HEADER = "x-amz-connection-timeout-ms";
    protected static final byte CR = 13;
    protected static final String CRLF = "\r\n";
    protected static final String HTTP_1_1 = "HTTP/1.1";
    protected static final String HTTP_PROTOCOL = "HTTP";
    protected static final int HTTP_PROTOCOL_MAJOR = 1;
    protected static final int HTTP_PROTOCOL_MINOR = 1;
    protected static final byte LF = 10;
    public static final String SOCKET_TIMEOUT_MS_HEADER = "x-amz-socket-timeout-ms";
    protected static final String SPACE_DELIMITER = " ";

    public HttpRequestResponseConverterBase()
    {
    }

    public String getNextLine(InputStream inputstream)
        throws ProtocolException
    {
        return getNextLine(new StringBuilder(), inputstream);
    }

    public String getNextLine(StringBuilder stringbuilder, InputStream inputstream)
        throws ProtocolException
    {
        int i;
        int j;
        try
        {
            j = inputstream.read();
        }
        // Misplaced declaration of an exception variable
        catch (StringBuilder stringbuilder)
        {
            throw new ProtocolException("Invalid message format: unexpected end of buffer", stringbuilder);
        }
        i = (byte)j;
_L2:
        if (j == -1 || i == 13)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i != 10)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        throw new ProtocolException("Invalid message format: LF not preceded by CR");
        char c = (char)i;
        stringbuilder.append(c);
        j = inputstream.read();
        i = (byte)j;
        if (true) goto _L2; else goto _L1
_L1:
        i = inputstream.read();
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if ((byte)i == 10)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        throw new ProtocolException("Invalid message format: CR not followed by LF");
        throw new ProtocolException("Invalid message format: unexpected end of buffer");
        return stringbuilder.toString();
    }

    protected boolean isEndOfHeaders(String s)
    {
        return s.length() == 0;
    }
}
