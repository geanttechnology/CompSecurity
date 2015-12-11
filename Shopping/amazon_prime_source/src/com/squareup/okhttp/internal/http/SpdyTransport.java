// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.okio.ByteString;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Okio;
import com.squareup.okhttp.internal.okio.Sink;
import com.squareup.okhttp.internal.okio.Source;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Transport, OkHeaders, StatusLine, Request, 
//            Headers, RequestLine, HttpEngine, RetryableSink

public final class SpdyTransport
    implements Transport
{
    private static class SpdySource
        implements Source
    {

        private final OutputStream cacheBody;
        private final CacheRequest cacheRequest;
        private boolean closed;
        private boolean inputExhausted;
        private final Source source;
        private final SpdyStream stream;

        private boolean discardStream()
        {
            Exception exception;
            long l;
            try
            {
                l = stream.getReadTimeoutMillis();
                stream.setReadTimeout(l);
                stream.setReadTimeout(100L);
            }
            catch (IOException ioexception)
            {
                return false;
            }
            Util.skipAll(this, 100);
            stream.setReadTimeout(l);
            return true;
            exception;
            stream.setReadTimeout(l);
            throw exception;
        }

        public void close()
            throws IOException
        {
            if (!closed)
            {
                if (!inputExhausted && cacheBody != null)
                {
                    discardStream();
                }
                closed = true;
                if (!inputExhausted)
                {
                    stream.closeLater(ErrorCode.CANCEL);
                    if (cacheRequest != null)
                    {
                        cacheRequest.abort();
                        return;
                    }
                }
            }
        }

        public long read(OkBuffer okbuffer, long l)
            throws IOException
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (inputExhausted)
            {
                l = -1L;
            } else
            {
                long l1 = source.read(okbuffer, l);
                if (l1 == -1L)
                {
                    inputExhausted = true;
                    if (cacheRequest != null)
                    {
                        cacheBody.close();
                    }
                    return -1L;
                }
                l = l1;
                if (cacheBody != null)
                {
                    Okio.copy(okbuffer, okbuffer.size() - l1, l1, cacheBody);
                    return l1;
                }
            }
            return l;
        }

        SpdySource(SpdyStream spdystream, CacheRequest cacherequest)
            throws IOException
        {
            stream = spdystream;
            source = spdystream.getSource();
            if (cacherequest != null)
            {
                spdystream = cacherequest.getBody();
            } else
            {
                spdystream = null;
            }
            if (spdystream == null)
            {
                cacherequest = null;
            }
            cacheBody = spdystream;
            cacheRequest = cacherequest;
        }
    }


    private final HttpEngine httpEngine;
    private final SpdyConnection spdyConnection;
    private SpdyStream stream;

    public SpdyTransport(HttpEngine httpengine, SpdyConnection spdyconnection)
    {
        httpEngine = httpengine;
        spdyConnection = spdyconnection;
    }

    private static boolean isProhibitedHeader(Protocol protocol, ByteString bytestring)
    {
        boolean flag = false;
        if (protocol == Protocol.SPDY_3)
        {
            if (bytestring.equalsAscii("connection") || bytestring.equalsAscii("host") || bytestring.equalsAscii("keep-alive") || bytestring.equalsAscii("proxy-connection") || bytestring.equalsAscii("transfer-encoding"))
            {
                flag = true;
            }
        } else
        if (protocol == Protocol.HTTP_2)
        {
            if (bytestring.equalsAscii("connection") || bytestring.equalsAscii("host") || bytestring.equalsAscii("keep-alive") || bytestring.equalsAscii("proxy-connection") || bytestring.equalsAscii("te") || bytestring.equalsAscii("transfer-encoding") || bytestring.equalsAscii("encoding") || bytestring.equalsAscii("upgrade"))
            {
                return true;
            }
        } else
        {
            throw new AssertionError(protocol);
        }
        return flag;
    }

    private static String joinOnNull(String s, String s1)
    {
        return (new StringBuilder(s)).append('\0').append(s1).toString();
    }

    public static Response.Builder readNameValueBlock(List list, Protocol protocol)
        throws IOException
    {
        String s1 = null;
        String s = "HTTP/1.1";
        Headers.Builder builder = new Headers.Builder();
        builder.set(OkHeaders.SELECTED_PROTOCOL, protocol.name.utf8());
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                break;
            }
            ByteString bytestring = ((Header)list.get(i)).name;
            String s5 = ((Header)list.get(i)).value.utf8();
            int j = 0;
            while (j < s5.length()) 
            {
                int l = s5.indexOf('\0', j);
                int k = l;
                if (l == -1)
                {
                    k = s5.length();
                }
                String s4 = s5.substring(j, k);
                String s2;
                String s3;
                if (bytestring.equals(Header.RESPONSE_STATUS))
                {
                    s2 = s4;
                    s3 = s;
                } else
                if (bytestring.equals(Header.VERSION))
                {
                    s3 = s4;
                    s2 = s1;
                } else
                {
                    s2 = s1;
                    s3 = s;
                    if (!isProhibitedHeader(protocol, bytestring))
                    {
                        builder.add(bytestring.utf8(), s4);
                        s2 = s1;
                        s3 = s;
                    }
                }
                j = k + 1;
                s1 = s2;
                s = s3;
            }
            i++;
        } while (true);
        if (s1 == null)
        {
            throw new ProtocolException("Expected ':status' header not present");
        }
        if (s == null)
        {
            throw new ProtocolException("Expected ':version' header not present");
        } else
        {
            return (new Response.Builder()).statusLine(new StatusLine((new StringBuilder()).append(s).append(" ").append(s1).toString())).headers(builder.build());
        }
    }

    public static List writeNameValueBlock(Request request, Protocol protocol, String s)
    {
        ArrayList arraylist;
        String s1;
        Headers headers = request.headers();
        arraylist = new ArrayList(headers.size() + 10);
        arraylist.add(new Header(Header.TARGET_METHOD, request.method()));
        arraylist.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        s1 = HttpEngine.hostHeader(request.url());
        int i;
        if (Protocol.SPDY_3 == protocol)
        {
            arraylist.add(new Header(Header.VERSION, s));
            arraylist.add(new Header(Header.TARGET_HOST, s1));
        } else
        if (Protocol.HTTP_2 == protocol)
        {
            arraylist.add(new Header(Header.TARGET_AUTHORITY, s1));
        } else
        {
            throw new AssertionError();
        }
        arraylist.add(new Header(Header.TARGET_SCHEME, request.url().getProtocol()));
        request = new LinkedHashSet();
        i = 0;
        break MISSING_BLOCK_LABEL_159;
_L5:
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_159;
        if (i >= headers.size())
        {
            break; /* Loop/switch isn't completed */
        }
        s = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
        s1 = headers.value(i);
        if (!isProhibitedHeader(protocol, s) && !s.equals(Header.TARGET_METHOD) && !s.equals(Header.TARGET_PATH) && !s.equals(Header.TARGET_SCHEME) && !s.equals(Header.TARGET_AUTHORITY) && !s.equals(Header.TARGET_HOST) && !s.equals(Header.VERSION))
        {
label0:
            {
                if (!request.add(s))
                {
                    break label0;
                }
                arraylist.add(new Header(s, s1));
            }
        }
        break MISSING_BLOCK_LABEL_200;
        int j = 0;
_L3:
        if (j < arraylist.size())
        {
label1:
            {
                if (!((Header)arraylist.get(j)).name.equals(s))
                {
                    break label1;
                }
                arraylist.set(j, new Header(s, joinOnNull(((Header)arraylist.get(j)).value.utf8(), s1)));
            }
        }
        continue; /* Loop/switch isn't completed */
        j++;
        if (true) goto _L3; else goto _L1
_L1:
        return arraylist;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean canReuseConnection()
    {
        return true;
    }

    public Sink createRequestBody(Request request)
        throws IOException
    {
        writeRequestHeaders(request);
        return stream.getSink();
    }

    public void disconnect(HttpEngine httpengine)
        throws IOException
    {
        stream.close(ErrorCode.CANCEL);
    }

    public void emptyTransferStream()
    {
    }

    public void flushRequest()
        throws IOException
    {
        stream.getSink().close();
    }

    public Source getTransferStream(CacheRequest cacherequest)
        throws IOException
    {
        return new SpdySource(stream, cacherequest);
    }

    public Response.Builder readResponseHeaders()
        throws IOException
    {
        return readNameValueBlock(stream.getResponseHeaders(), spdyConnection.getProtocol());
    }

    public void releaseConnectionOnIdle()
    {
    }

    public void writeRequestBody(RetryableSink retryablesink)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public void writeRequestHeaders(Request request)
        throws IOException
    {
        if (stream != null)
        {
            return;
        } else
        {
            httpEngine.writingRequestHeaders();
            boolean flag = httpEngine.hasRequestBody();
            String s = RequestLine.version(httpEngine.getConnection().getHttpMinorVersion());
            stream = spdyConnection.newStream(writeNameValueBlock(request, spdyConnection.getProtocol(), s), flag, true);
            stream.setReadTimeout(httpEngine.client.getReadTimeout());
            return;
        }
    }
}
