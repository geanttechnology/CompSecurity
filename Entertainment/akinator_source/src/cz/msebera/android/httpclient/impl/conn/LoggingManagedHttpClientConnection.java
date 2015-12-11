// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.entity.ContentLengthStrategy;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.io.HttpMessageParserFactory;
import cz.msebera.android.httpclient.io.HttpMessageWriterFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

// Referenced classes of package cz.msebera.android.httpclient.impl.conn:
//            DefaultManagedHttpClientConnection, Wire, LoggingInputStream, LoggingOutputStream

class LoggingManagedHttpClientConnection extends DefaultManagedHttpClientConnection
{

    private final HttpClientAndroidLog headerlog;
    public HttpClientAndroidLog log;
    private final Wire wire;

    public LoggingManagedHttpClientConnection(String s, HttpClientAndroidLog httpclientandroidlog, HttpClientAndroidLog httpclientandroidlog1, HttpClientAndroidLog httpclientandroidlog2, int i, int j, CharsetDecoder charsetdecoder, 
            CharsetEncoder charsetencoder, MessageConstraints messageconstraints, ContentLengthStrategy contentlengthstrategy, ContentLengthStrategy contentlengthstrategy1, HttpMessageWriterFactory httpmessagewriterfactory, HttpMessageParserFactory httpmessageparserfactory)
    {
        super(s, i, j, charsetdecoder, charsetencoder, messageconstraints, contentlengthstrategy, contentlengthstrategy1, httpmessagewriterfactory, httpmessageparserfactory);
        log = httpclientandroidlog;
        headerlog = httpclientandroidlog1;
        wire = new Wire(httpclientandroidlog2, s);
    }

    public void close()
        throws IOException
    {
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append(getId()).append(": Close connection").toString());
        }
        super.close();
    }

    protected InputStream getSocketInputStream(Socket socket)
        throws IOException
    {
        InputStream inputstream = super.getSocketInputStream(socket);
        socket = inputstream;
        if (wire.enabled())
        {
            socket = new LoggingInputStream(inputstream, wire);
        }
        return socket;
    }

    protected OutputStream getSocketOutputStream(Socket socket)
        throws IOException
    {
        OutputStream outputstream = super.getSocketOutputStream(socket);
        socket = outputstream;
        if (wire.enabled())
        {
            socket = new LoggingOutputStream(outputstream, wire);
        }
        return socket;
    }

    protected void onRequestSubmitted(HttpRequest httprequest)
    {
        if (httprequest != null && headerlog.isDebugEnabled())
        {
            headerlog.debug((new StringBuilder()).append(getId()).append(" >> ").append(httprequest.getRequestLine().toString()).toString());
            httprequest = httprequest.getAllHeaders();
            int j = httprequest.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = httprequest[i];
                headerlog.debug((new StringBuilder()).append(getId()).append(" >> ").append(obj.toString()).toString());
            }

        }
    }

    protected void onResponseReceived(HttpResponse httpresponse)
    {
        if (httpresponse != null && headerlog.isDebugEnabled())
        {
            headerlog.debug((new StringBuilder()).append(getId()).append(" << ").append(httpresponse.getStatusLine().toString()).toString());
            httpresponse = httpresponse.getAllHeaders();
            int j = httpresponse.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = httpresponse[i];
                headerlog.debug((new StringBuilder()).append(getId()).append(" << ").append(obj.toString()).toString());
            }

        }
    }

    public void shutdown()
        throws IOException
    {
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append(getId()).append(": Shutdown connection").toString());
        }
        super.shutdown();
    }
}
