// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.DefaultHttpResponseFactory;
import cz.msebera.android.httpclient.impl.io.AbstractMessageParser;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

public class DefaultHttpResponseParser extends AbstractMessageParser
{

    private final CharArrayBuffer lineBuf;
    public HttpClientAndroidLog log;
    private final HttpResponseFactory responseFactory;

    public DefaultHttpResponseParser(SessionInputBuffer sessioninputbuffer)
    {
        this(sessioninputbuffer, null, null, MessageConstraints.DEFAULT);
    }

    public DefaultHttpResponseParser(SessionInputBuffer sessioninputbuffer, MessageConstraints messageconstraints)
    {
        this(sessioninputbuffer, null, null, messageconstraints);
    }

    public DefaultHttpResponseParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpResponseFactory httpresponsefactory, MessageConstraints messageconstraints)
    {
        super(sessioninputbuffer, lineparser, messageconstraints);
        log = new HttpClientAndroidLog(getClass());
        if (httpresponsefactory == null)
        {
            httpresponsefactory = DefaultHttpResponseFactory.INSTANCE;
        }
        responseFactory = httpresponsefactory;
        lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpResponseParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpResponseFactory httpresponsefactory, HttpParams httpparams)
    {
        super(sessioninputbuffer, lineparser, httpparams);
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(httpresponsefactory, "Response factory");
        responseFactory = httpresponsefactory;
        lineBuf = new CharArrayBuffer(128);
    }

    protected volatile HttpMessage parseHead(SessionInputBuffer sessioninputbuffer)
        throws IOException, HttpException, ParseException
    {
        return parseHead(sessioninputbuffer);
    }

    protected HttpResponse parseHead(SessionInputBuffer sessioninputbuffer)
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
            if (j == -1 || reject(lineBuf, i))
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

    protected boolean reject(CharArrayBuffer chararraybuffer, int i)
    {
        return false;
    }
}
