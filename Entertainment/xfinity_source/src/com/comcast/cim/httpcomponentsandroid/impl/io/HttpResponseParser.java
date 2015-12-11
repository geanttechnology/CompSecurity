// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.impl.io;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpMessage;
import com.comcast.cim.httpcomponentsandroid.HttpResponseFactory;
import com.comcast.cim.httpcomponentsandroid.NoHttpResponseException;
import com.comcast.cim.httpcomponentsandroid.ParseException;
import com.comcast.cim.httpcomponentsandroid.io.SessionInputBuffer;
import com.comcast.cim.httpcomponentsandroid.message.LineParser;
import com.comcast.cim.httpcomponentsandroid.message.ParserCursor;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.util.CharArrayBuffer;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.impl.io:
//            AbstractMessageParser

public class HttpResponseParser extends AbstractMessageParser
{

    private final CharArrayBuffer lineBuf;
    private final HttpResponseFactory responseFactory;

    public HttpResponseParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        super(sessioninputbuffer, lineparser, httpparams);
        if (httpresponsefactory == null)
        {
            throw new IllegalArgumentException("Response factory may not be null");
        } else
        {
            responseFactory = httpresponsefactory;
            lineBuf = new CharArrayBuffer(128);
            return;
        }
    }

    protected HttpMessage parseHead(SessionInputBuffer sessioninputbuffer)
        throws IOException, HttpException, ParseException
    {
        lineBuf.clear();
        if (sessioninputbuffer.readLine(lineBuf) == -1)
        {
            throw new NoHttpResponseException("The target server failed to respond");
        } else
        {
            sessioninputbuffer = new ParserCursor(0, lineBuf.length());
            sessioninputbuffer = lineParser.parseStatusLine(lineBuf, sessioninputbuffer);
            return responseFactory.newHttpResponse(sessioninputbuffer, null);
        }
    }
}
