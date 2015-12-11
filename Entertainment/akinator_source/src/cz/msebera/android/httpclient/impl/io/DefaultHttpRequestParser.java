// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.ConnectionClosedException;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpMessage;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.impl.DefaultHttpRequestFactory;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.LineParser;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            AbstractMessageParser

public class DefaultHttpRequestParser extends AbstractMessageParser
{

    private final CharArrayBuffer lineBuf;
    private final HttpRequestFactory requestFactory;

    public DefaultHttpRequestParser(SessionInputBuffer sessioninputbuffer)
    {
        this(sessioninputbuffer, null, null, MessageConstraints.DEFAULT);
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessioninputbuffer, MessageConstraints messageconstraints)
    {
        this(sessioninputbuffer, null, null, messageconstraints);
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpRequestFactory httprequestfactory, MessageConstraints messageconstraints)
    {
        super(sessioninputbuffer, lineparser, messageconstraints);
        if (httprequestfactory == null)
        {
            httprequestfactory = DefaultHttpRequestFactory.INSTANCE;
        }
        requestFactory = httprequestfactory;
        lineBuf = new CharArrayBuffer(128);
    }

    public DefaultHttpRequestParser(SessionInputBuffer sessioninputbuffer, LineParser lineparser, HttpRequestFactory httprequestfactory, HttpParams httpparams)
    {
        super(sessioninputbuffer, lineparser, httpparams);
        requestFactory = (HttpRequestFactory)Args.notNull(httprequestfactory, "Request factory");
        lineBuf = new CharArrayBuffer(128);
    }

    protected volatile HttpMessage parseHead(SessionInputBuffer sessioninputbuffer)
        throws IOException, HttpException, ParseException
    {
        return parseHead(sessioninputbuffer);
    }

    protected HttpRequest parseHead(SessionInputBuffer sessioninputbuffer)
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
