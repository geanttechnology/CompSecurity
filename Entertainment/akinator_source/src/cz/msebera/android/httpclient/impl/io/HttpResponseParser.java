// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            AbstractMessageParser

public class HttpResponseParser extends AbstractMessageParser
{

    private final CharArrayBuffer lineBuf = new CharArrayBuffer(128);
    private final HttpResponseFactory responseFactory;

    public HttpResponseParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        super(sessioninputbuffer, lineparser, httpparams);
        responseFactory = (HttpResponseFactory)Args.notNull(httpresponsefactory, "Response factory");
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
