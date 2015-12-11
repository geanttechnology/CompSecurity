// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpConnection;
import cz.msebera.android.httpclient.config.ConnectionConfig;
import cz.msebera.android.httpclient.conn.HttpConnectionFactory;
import cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.io.DefaultHttpRequestWriterFactory;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            DefaultManagedHttpClientConnection, DefaultHttpResponseParserFactory, LoggingManagedHttpClientConnection

public class ManagedHttpClientConnectionFactory
    implements HttpConnectionFactory
{

    private static final AtomicLong COUNTER = new AtomicLong();
    public static final ManagedHttpClientConnectionFactory INSTANCE = new ManagedHttpClientConnectionFactory();
    public HttpClientAndroidLog headerlog;
    public HttpClientAndroidLog log;
    private final HttpMessageWriterFactory requestWriterFactory;
    private final HttpMessageParserFactory responseParserFactory;
    public HttpClientAndroidLog wirelog;

    public ManagedHttpClientConnectionFactory()
    {
        this(null, null);
    }

    public ManagedHttpClientConnectionFactory(HttpMessageParserFactory httpmessageparserfactory)
    {
        this(null, httpmessageparserfactory);
    }

    public ManagedHttpClientConnectionFactory(HttpMessageWriterFactory httpmessagewriterfactory, HttpMessageParserFactory httpmessageparserfactory)
    {
        log = new HttpClientAndroidLog(cz/msebera/android/httpclient/impl/conn/DefaultManagedHttpClientConnection);
        headerlog = new HttpClientAndroidLog("cz.msebera.android.httpclient.headers");
        wirelog = new HttpClientAndroidLog("cz.msebera.android.httpclient.wire");
        if (httpmessagewriterfactory == null)
        {
            httpmessagewriterfactory = DefaultHttpRequestWriterFactory.INSTANCE;
        }
        requestWriterFactory = httpmessagewriterfactory;
        if (httpmessageparserfactory == null)
        {
            httpmessageparserfactory = DefaultHttpResponseParserFactory.INSTANCE;
        }
        responseParserFactory = httpmessageparserfactory;
    }

    public volatile HttpConnection create(Object obj, ConnectionConfig connectionconfig)
    {
        return create((HttpRoute)obj, connectionconfig);
    }

    public ManagedHttpClientConnection create(HttpRoute httproute, ConnectionConfig connectionconfig)
    {
        CodingErrorAction codingerroraction;
        CharsetDecoder charsetdecoder;
        CharsetEncoder charsetencoder;
        Charset charset;
        if (connectionconfig != null)
        {
            httproute = connectionconfig;
        } else
        {
            httproute = ConnectionConfig.DEFAULT;
        }
        charsetdecoder = null;
        charsetencoder = null;
        charset = httproute.getCharset();
        if (httproute.getMalformedInputAction() != null)
        {
            connectionconfig = httproute.getMalformedInputAction();
        } else
        {
            connectionconfig = CodingErrorAction.REPORT;
        }
        if (httproute.getUnmappableInputAction() != null)
        {
            codingerroraction = httproute.getUnmappableInputAction();
        } else
        {
            codingerroraction = CodingErrorAction.REPORT;
        }
        if (charset != null)
        {
            charsetdecoder = charset.newDecoder();
            charsetdecoder.onMalformedInput(connectionconfig);
            charsetdecoder.onUnmappableCharacter(codingerroraction);
            charsetencoder = charset.newEncoder();
            charsetencoder.onMalformedInput(connectionconfig);
            charsetencoder.onUnmappableCharacter(codingerroraction);
        }
        return new LoggingManagedHttpClientConnection((new StringBuilder()).append("http-outgoing-").append(Long.toString(COUNTER.getAndIncrement())).toString(), log, headerlog, wirelog, httproute.getBufferSize(), httproute.getFragmentSizeHint(), charsetdecoder, charsetencoder, httproute.getMessageConstraints(), null, null, requestWriterFactory, responseParserFactory);
    }

}
