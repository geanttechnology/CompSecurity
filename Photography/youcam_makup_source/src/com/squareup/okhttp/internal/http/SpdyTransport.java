// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.ErrorCode;
import com.squareup.okhttp.internal.spdy.Header;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.spdy.SpdyStream;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.q;
import okio.r;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            Transport, OkHeaders, StatusLine, RequestLine, 
//            HttpEngine, RetryableSink, CacheRequest

public final class SpdyTransport
    implements Transport
{

    private static final List HTTP_2_PROHIBITED_HEADERS = Util.immutableList(new ByteString[] {
        ByteString.a("connection"), ByteString.a("host"), ByteString.a("keep-alive"), ByteString.a("proxy-connection"), ByteString.a("te"), ByteString.a("transfer-encoding"), ByteString.a("encoding"), ByteString.a("upgrade")
    });
    private static final List SPDY_3_PROHIBITED_HEADERS = Util.immutableList(new ByteString[] {
        ByteString.a("connection"), ByteString.a("host"), ByteString.a("keep-alive"), ByteString.a("proxy-connection"), ByteString.a("transfer-encoding")
    });
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
        if (protocol == Protocol.SPDY_3)
        {
            return SPDY_3_PROHIBITED_HEADERS.contains(bytestring);
        }
        if (protocol == Protocol.HTTP_2)
        {
            return HTTP_2_PROHIBITED_HEADERS.contains(bytestring);
        } else
        {
            throw new AssertionError(protocol);
        }
    }

    private static String joinOnNull(String s1, String s2)
    {
        return (new StringBuilder(s1)).append('\0').append(s2).toString();
    }

    public static com.squareup.okhttp.Response.Builder readNameValueBlock(List list, Protocol protocol)
    {
        String s1 = null;
        String s2 = "HTTP/1.1";
        com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
        builder.set(OkHeaders.SELECTED_PROTOCOL, protocol.toString());
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                break;
            }
            ByteString bytestring = ((Header)list.get(i)).name;
            String s4 = ((Header)list.get(i)).value.a();
            int j = 0;
            while (j < s4.length()) 
            {
                int l = s4.indexOf('\0', j);
                int k = l;
                if (l == -1)
                {
                    k = s4.length();
                }
                String s3 = s4.substring(j, k);
                if (bytestring.equals(Header.RESPONSE_STATUS))
                {
                    s1 = s3;
                } else
                if (bytestring.equals(Header.VERSION))
                {
                    s2 = s3;
                } else
                if (!isProhibitedHeader(protocol, bytestring))
                {
                    builder.add(bytestring.a(), s3);
                }
                j = k + 1;
            }
            i++;
        } while (true);
        if (s1 == null)
        {
            throw new ProtocolException("Expected ':status' header not present");
        }
        if (s2 == null)
        {
            throw new ProtocolException("Expected ':version' header not present");
        } else
        {
            list = StatusLine.parse((new StringBuilder()).append(s2).append(" ").append(s1).toString());
            return (new com.squareup.okhttp.Response.Builder()).protocol(protocol).code(((StatusLine) (list)).code).message(((StatusLine) (list)).message).headers(builder.build());
        }
    }

    public static List writeNameValueBlock(Request request, Protocol protocol, String s1)
    {
        ArrayList arraylist;
        String s2;
        Headers headers = request.headers();
        arraylist = new ArrayList(headers.size() + 10);
        arraylist.add(new Header(Header.TARGET_METHOD, request.method()));
        arraylist.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        s2 = HttpEngine.hostHeader(request.url());
        int i;
        if (Protocol.SPDY_3 == protocol)
        {
            arraylist.add(new Header(Header.VERSION, s1));
            arraylist.add(new Header(Header.TARGET_HOST, s2));
        } else
        if (Protocol.HTTP_2 == protocol)
        {
            arraylist.add(new Header(Header.TARGET_AUTHORITY, s2));
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
        s1 = ByteString.a(headers.name(i).toLowerCase(Locale.US));
        s2 = headers.value(i);
        if (!isProhibitedHeader(protocol, s1) && !s1.equals(Header.TARGET_METHOD) && !s1.equals(Header.TARGET_PATH) && !s1.equals(Header.TARGET_SCHEME) && !s1.equals(Header.TARGET_AUTHORITY) && !s1.equals(Header.TARGET_HOST) && !s1.equals(Header.VERSION))
        {
label0:
            {
                if (!request.add(s1))
                {
                    break label0;
                }
                arraylist.add(new Header(s1, s2));
            }
        }
        break MISSING_BLOCK_LABEL_200;
        int j = 0;
_L3:
        if (j < arraylist.size())
        {
label1:
            {
                if (!((Header)arraylist.get(j)).name.equals(s1))
                {
                    break label1;
                }
                arraylist.set(j, new Header(s1, joinOnNull(((Header)arraylist.get(j)).value.a(), s2)));
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

    public q createRequestBody(Request request, long l)
    {
        return stream.getSink();
    }

    public void disconnect(HttpEngine httpengine)
    {
        stream.close(ErrorCode.CANCEL);
    }

    public void emptyTransferStream()
    {
    }

    public void flushRequest()
    {
        stream.getSink().close();
    }

    public r getTransferStream(CacheRequest cacherequest)
    {
        return new SpdySource(stream, cacherequest);
    }

    public com.squareup.okhttp.Response.Builder readResponseHeaders()
    {
        return readNameValueBlock(stream.getResponseHeaders(), spdyConnection.getProtocol());
    }

    public void releaseConnectionOnIdle()
    {
    }

    public void writeRequestBody(RetryableSink retryablesink)
    {
        retryablesink.writeToSocket(stream.getSink());
    }

    public void writeRequestHeaders(Request request)
    {
        if (stream != null)
        {
            return;
        } else
        {
            httpEngine.writingRequestHeaders();
            boolean flag = httpEngine.permitsRequestBody();
            String s1 = RequestLine.version(httpEngine.getConnection().getProtocol());
            stream = spdyConnection.newStream(writeNameValueBlock(request, spdyConnection.getProtocol(), s1), flag, true);
            stream.readTimeout().timeout(httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
            return;
        }
    }


    private class SpdySource
        implements r
    {

        private final q cacheBody;
        private final CacheRequest cacheRequest;
        private boolean closed;
        private boolean inputExhausted;
        private final r source;
        private final SpdyStream stream;

        private boolean discardStream()
        {
            Exception exception;
            long l = stream.readTimeout().timeoutNanos();
            stream.readTimeout().timeout(100L, TimeUnit.MILLISECONDS);
            try
            {
                Util.skipAll(this, 100);
            }
            catch (IOException ioexception)
            {
                stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
                return false;
            }
            finally
            {
                stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
            }
            stream.readTimeout().timeout(l, TimeUnit.NANOSECONDS);
            return true;
            throw exception;
        }

        public void close()
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

        public long read(d d1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (!inputExhausted)
            {
                l = source.read(d1, l);
                if (l == -1L)
                {
                    inputExhausted = true;
                    if (cacheRequest != null)
                    {
                        cacheBody.close();
                        return -1L;
                    }
                } else
                {
                    if (cacheBody != null)
                    {
                        cacheBody.write(d1.r(), l);
                    }
                    return l;
                }
            }
            return -1L;
        }

        public s timeout()
        {
            return source.timeout();
        }

        SpdySource(SpdyStream spdystream, CacheRequest cacherequest)
        {
            stream = spdystream;
            source = spdystream.getSource();
            if (cacherequest != null)
            {
                spdystream = cacherequest.body();
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

}
