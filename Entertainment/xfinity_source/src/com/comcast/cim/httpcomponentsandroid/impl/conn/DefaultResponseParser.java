// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.conn;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.HttpResponseFactory;
import com.comcast.cim.httpcomponentsandroid.NoHttpResponseException;
import com.comcast.cim.httpcomponentsandroid.ProtocolException;
import com.comcast.cim.httpcomponentsandroid.impl.io.AbstractMessageParser;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.message.LineParser;
import com.comcast.cim.httpcomponentsandroid.message.ParserCursor;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultResponseParser extends AbstractMessageParser
{

    private final CharArrayBuffer lineBuf;
    private final Log log = LogFactory.getLog(getClass());
    private final int maxGarbageLines;
    private final HttpResponseFactory responseFactory;

    public DefaultResponseParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        super(sessioninputbuffer, lineparser, httpparams);
        if (httpresponsefactory == null)
        {
            throw new IllegalArgumentException("Response factory may not be null");
        } else
        {
            responseFactory = httpresponsefactory;
            lineBuf = new CharArrayBuffer(128);
            maxGarbageLines = httpparams.getIntParameter("http.connection.max-status-line-garbage", 0x7fffffff);
            return;
        }
    }

    protected HttpMessage parseHead(SessionInputBuffer sessioninputbuffer)
        throws IOException, HttpException
    {
        int i = 0;
        do
        {
            lineBuf.clear();
            int j = sessioninputbuffer.readLine(lineBuf);
            if (j == -1 && i == 0)
            {
                throw new NoHttpResponseException("The target server failed to respond");
            }
            ParserCursor parsercursor = new ParserCursor(0, lineBuf.length());
            if (lineParser.hasProtocolVersion(lineBuf, parsercursor))
            {
                sessioninputbuffer = lineParser.parseStatusLine(lineBuf, parsercursor);
                return responseFactory.newHttpResponse(sessioninputbuffer, null);
            }
            if (j == -1 || i >= maxGarbageLines)
            {
                throw new ProtocolException("The server failed to respond with a valid HTTP response");
            }
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Garbage in response: ").append(lineBuf.toString()).toString());
            }
            i++;
        } while (true);
    }
}
