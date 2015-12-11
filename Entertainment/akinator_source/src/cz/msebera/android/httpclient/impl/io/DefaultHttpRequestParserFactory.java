// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.io;

import cz.msebera.android.httpclient.HttpRequestFactory;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.impl.DefaultHttpRequestFactory;
import cz.msebera.android.httpclient.io.HttpMessageParser;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.SessionInputBuffer;
import cz.msebera.android.httpclient.message.BasicLineParser;
import cz.msebera.android.httpclient.message.LineParser;

// Referenced classes of package cz.msebera.android.httpclient.impl.io:
//            DefaultHttpRequestParser

public class DefaultHttpRequestParserFactory
    implements HttpMessageParserFactory
{

    public static final DefaultHttpRequestParserFactory INSTANCE = new DefaultHttpRequestParserFactory();
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    public DefaultHttpRequestParserFactory()
    {
        this(null, null);
    }

    public DefaultHttpRequestParserFactory(LineParser lineparser, HttpRequestFactory httprequestfactory)
    {
        if (lineparser == null)
        {
            lineparser = BasicLineParser.INSTANCE;
        }
        lineParser = lineparser;
        if (httprequestfactory == null)
        {
            httprequestfactory = DefaultHttpRequestFactory.INSTANCE;
        }
        requestFactory = httprequestfactory;
    }

    public HttpMessageParser create(SessionInputBuffer sessioninputbuffer, MessageConstraints messageconstraints)
    {
        return new DefaultHttpRequestParser(sessioninputbuffer, lineParser, requestFactory, messageconstraints);
    }

}
