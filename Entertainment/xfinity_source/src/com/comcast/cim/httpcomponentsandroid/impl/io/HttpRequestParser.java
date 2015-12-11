// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.io;

import com.comcast.cim.httpcomponentsandroid.ConnectionClosedException;
import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.HttpRequestFactory;
import com.comcast.cim.httpcomponentsandroid.ParseException;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.message.LineParser;
import com.comcast.cim.httpcomponentsandroid.message.ParserCursor;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.io:
//            AbstractMessageParser

public class HttpRequestParser extends AbstractMessageParser
{

    private final CharArrayBuffer lineBuf;
    private final HttpRequestFactory requestFactory;

    protected HttpMessage parseHead(SessionInputBuffer sessioninputbuffer)
        throws IOException, HttpException, ParseException
    {
        lineBuf.clear();
        if (sessioninputbuffer.readLine(lineBuf) == -1)
        {
            throw new ConnectionClosedException("Client closed connection");
        } else
        {
            sessioninputbuffer = new ParserCursor(0, lineBuf.length());
            sessioninputbuffer = lineParser.parseRequestLine(lineBuf, sessioninputbuffer);
            return requestFactory.newHttpRequest(sessioninputbuffer);
        }
    }
}
