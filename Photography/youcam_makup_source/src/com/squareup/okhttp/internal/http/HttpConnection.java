// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import okio.d;
import okio.e;
import okio.f;
import okio.l;
import okio.q;
import okio.r;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            StatusLine, OkHeaders, RetryableSink, CacheRequest, 
//            HttpEngine

public final class HttpConnection
{

    private static final String CRLF = "\r\n";
    private static final byte FINAL_CHUNK[] = {
        48, 13, 10, 13, 10
    };
    private static final byte HEX_DIGITS[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    private static final int ON_IDLE_CLOSE = 2;
    private static final int ON_IDLE_HOLD = 0;
    private static final int ON_IDLE_POOL = 1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final Connection connection;
    private int onIdle;
    private final ConnectionPool pool;
    private final e sink;
    private final Socket socket;
    private final f source;
    private int state;

    public HttpConnection(ConnectionPool connectionpool, Connection connection1, Socket socket1)
    {
        state = 0;
        onIdle = 0;
        pool = connectionpool;
        connection = connection1;
        socket = socket1;
        source = l.a(l.b(socket1));
        sink = l.a(l.a(socket1));
    }

    public long bufferSize()
    {
        return source.b().a();
    }

    public void closeIfOwnedBy(Object obj)
    {
        Internal.instance.closeIfOwnedBy(connection, obj);
    }

    public void closeOnIdle()
    {
        onIdle = 2;
        if (state == 0)
        {
            state = 6;
            connection.getSocket().close();
        }
    }

    public boolean discard(r r, int i)
    {
        int j;
        boolean flag;
        try
        {
            j = socket.getSoTimeout();
            socket.setSoTimeout(i);
        }
        // Misplaced declaration of an exception variable
        catch (r r)
        {
            return false;
        }
        flag = Util.skipAll(r, i);
        socket.setSoTimeout(j);
        return flag;
        r;
        socket.setSoTimeout(j);
        throw r;
    }

    public void emptyResponseBody()
    {
        newFixedLengthSource(null, 0L);
    }

    public void flush()
    {
        sink.flush();
    }

    public boolean isClosed()
    {
        return state == 6;
    }

    public boolean isReadable()
    {
        Exception exception;
        int i;
        boolean flag;
        try
        {
            i = socket.getSoTimeout();
        }
        catch (SocketTimeoutException sockettimeoutexception)
        {
            return true;
        }
        catch (IOException ioexception)
        {
            return false;
        }
        socket.setSoTimeout(1);
        flag = source.e();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        socket.setSoTimeout(i);
        return false;
        socket.setSoTimeout(i);
        return true;
        exception;
        socket.setSoTimeout(i);
        throw exception;
    }

    public q newChunkedSink()
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 2;
            return new ChunkedSink();
        }
    }

    public r newChunkedSource(CacheRequest cacherequest, HttpEngine httpengine)
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 5;
            return new ChunkedSource(cacherequest, httpengine);
        }
    }

    public q newFixedLengthSink(long l1)
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 2;
            return new FixedLengthSink(l1);
        }
    }

    public r newFixedLengthSource(CacheRequest cacherequest, long l1)
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 5;
            return new FixedLengthSource(cacherequest, l1);
        }
    }

    public r newUnknownLengthSource(CacheRequest cacherequest)
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 5;
            return new UnknownLengthSource(cacherequest);
        }
    }

    public void poolOnIdle()
    {
        onIdle = 1;
        if (state == 0)
        {
            onIdle = 0;
            Internal.instance.recycle(pool, connection);
        }
    }

    public void readHeaders(com.squareup.okhttp.Headers.Builder builder)
    {
        do
        {
            String s1 = source.o();
            if (s1.length() != 0)
            {
                Internal.instance.addLine(builder, s1);
            } else
            {
                return;
            }
        } while (true);
    }

    public com.squareup.okhttp.Response.Builder readResponse()
    {
        if (state != 1 && state != 3)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        }
        StatusLine statusline;
        com.squareup.okhttp.Response.Builder builder;
        do
        {
            statusline = StatusLine.parse(source.o());
            builder = (new com.squareup.okhttp.Response.Builder()).protocol(statusline.protocol).code(statusline.code).message(statusline.message);
            com.squareup.okhttp.Headers.Builder builder1 = new com.squareup.okhttp.Headers.Builder();
            readHeaders(builder1);
            builder1.add(OkHeaders.SELECTED_PROTOCOL, statusline.protocol.toString());
            builder.headers(builder1.build());
        } while (statusline.code == 100);
        state = 4;
        return builder;
    }

    public void setTimeouts(int i, int j)
    {
        if (i != 0)
        {
            source.timeout().timeout(i, TimeUnit.MILLISECONDS);
        }
        if (j != 0)
        {
            sink.timeout().timeout(j, TimeUnit.MILLISECONDS);
        }
    }

    public void writeRequest(Headers headers, String s1)
    {
        if (state != 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        }
        sink.b(s1).b("\r\n");
        for (int i = 0; i < headers.size(); i++)
        {
            sink.b(headers.name(i)).b(": ").b(headers.value(i)).b("\r\n");
        }

        sink.b("\r\n");
        state = 1;
    }

    public void writeRequestBody(RetryableSink retryablesink)
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
        } else
        {
            state = 3;
            retryablesink.writeToSocket(sink);
            return;
        }
    }





/*
    static int access$302(HttpConnection httpconnection, int i)
    {
        httpconnection.state = i;
        return i;
    }

*/





/*
    static int access$602(HttpConnection httpconnection, int i)
    {
        httpconnection.onIdle = i;
        return i;
    }

*/




    private class ChunkedSink
        implements q
    {

        private boolean closed;
        private final byte hex[] = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
            0, 0, 0, 0, 0, 0, 13, 10
        };
        final HttpConnection this$0;

        private void writeHex(long l1)
        {
            int i = 16;
            int j;
            long l2;
            do
            {
                byte abyte0[] = hex;
                j = i - 1;
                abyte0[j] = HttpConnection.HEX_DIGITS[(int)(15L & l1)];
                l2 = l1 >>> 4;
                i = j;
                l1 = l2;
            } while (l2 != 0L);
            sink.c(hex, j, hex.length - j);
        }

        public void close()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = closed;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            closed = true;
            sink.c(HttpConnection.FINAL_CHUNK);
            state = 3;
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public void flush()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = closed;
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            sink.flush();
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public s timeout()
        {
            return sink.timeout();
        }

        public void write(d d1, long l1)
        {
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (l1 == 0L)
            {
                return;
            } else
            {
                writeHex(l1);
                sink.write(d1, l1);
                sink.b("\r\n");
                return;
            }
        }

        private ChunkedSink()
        {
            this$0 = HttpConnection.this;
            super();
        }

    }


    private class ChunkedSource extends AbstractSource
        implements r
    {
        private class AbstractSource
        {

            protected final q cacheBody;
            private final CacheRequest cacheRequest;
            protected boolean closed;
            final HttpConnection this$0;

            protected final void cacheWrite(d d1, long l1)
            {
                if (cacheBody != null)
                {
                    d1 = d1.r();
                    d1.g(d1.a() - l1);
                    cacheBody.write(d1, l1);
                }
            }

            protected final void endOfInput(boolean flag)
            {
                if (state != 5)
                {
                    throw new IllegalStateException((new StringBuilder()).append("state: ").append(state).toString());
                }
                if (cacheRequest != null)
                {
                    cacheBody.close();
                }
                state = 0;
                if (flag && onIdle == 1)
                {
                    onIdle = 0;
                    Internal.instance.recycle(pool, connection);
                } else
                if (onIdle == 2)
                {
                    state = 6;
                    connection.getSocket().close();
                    return;
                }
            }

            protected final void unexpectedEndOfInput()
            {
                if (cacheRequest != null)
                {
                    cacheRequest.abort();
                }
                Util.closeQuietly(connection.getSocket());
                state = 6;
            }

            AbstractSource(CacheRequest cacherequest)
            {
                this$0 = HttpConnection.this;
                super();
                if (cacherequest != null)
                {
                    httpconnection = cacherequest.body();
                } else
                {
                    httpconnection = null;
                }
                if (HttpConnection.this == null)
                {
                    cacherequest = null;
                }
                cacheBody = HttpConnection.this;
                cacheRequest = cacherequest;
            }
        }


        private static final int NO_CHUNK_YET = -1;
        private int bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;
        final HttpConnection this$0;

        private void readChunkSize()
        {
            if (bytesRemainingInChunk != -1)
            {
                source.o();
            }
            String s1 = source.o();
            int i = s1.indexOf(";");
            Object obj = s1;
            if (i != -1)
            {
                obj = s1.substring(0, i);
            }
            try
            {
                bytesRemainingInChunk = Integer.parseInt(((String) (obj)).trim(), 16);
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new ProtocolException((new StringBuilder()).append("Expected a hex chunk size but was ").append(((String) (obj))).toString());
            }
            if (bytesRemainingInChunk == 0)
            {
                hasMoreChunks = false;
                obj = new com.squareup.okhttp.Headers.Builder();
                readHeaders(((com.squareup.okhttp.Headers.Builder) (obj)));
                httpEngine.receiveHeaders(((com.squareup.okhttp.Headers.Builder) (obj)).build());
                endOfInput(true);
            }
        }

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (hasMoreChunks && !discard(this, 100))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(d d1, long l1)
        {
            if (l1 < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l1).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (hasMoreChunks) goto _L2; else goto _L1
_L1:
            return -1L;
_L2:
            if (bytesRemainingInChunk != 0 && bytesRemainingInChunk != -1)
            {
                break; /* Loop/switch isn't completed */
            }
            readChunkSize();
            if (!hasMoreChunks) goto _L1; else goto _L3
_L3:
            l1 = source.read(d1, Math.min(l1, bytesRemainingInChunk));
            if (l1 == -1L)
            {
                unexpectedEndOfInput();
                throw new IOException("unexpected end of stream");
            } else
            {
                bytesRemainingInChunk = (int)((long)bytesRemainingInChunk - l1);
                cacheWrite(d1, l1);
                return l1;
            }
        }

        public s timeout()
        {
            return source.timeout();
        }

        ChunkedSource(CacheRequest cacherequest, HttpEngine httpengine)
        {
            this$0 = HttpConnection.this;
            super(cacherequest);
            bytesRemainingInChunk = -1;
            hasMoreChunks = true;
            httpEngine = httpengine;
        }
    }


    private class FixedLengthSink
        implements q
    {

        private long bytesRemaining;
        private boolean closed;
        final HttpConnection this$0;

        public void close()
        {
            if (closed)
            {
                return;
            }
            closed = true;
            if (bytesRemaining > 0L)
            {
                throw new ProtocolException("unexpected end of stream");
            } else
            {
                state = 3;
                return;
            }
        }

        public void flush()
        {
            if (closed)
            {
                return;
            } else
            {
                sink.flush();
                return;
            }
        }

        public s timeout()
        {
            return sink.timeout();
        }

        public void write(d d1, long l1)
        {
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(d1.a(), 0L, l1);
            if (l1 > bytesRemaining)
            {
                throw new ProtocolException((new StringBuilder()).append("expected ").append(bytesRemaining).append(" bytes but received ").append(l1).toString());
            } else
            {
                sink.write(d1, l1);
                bytesRemaining = bytesRemaining - l1;
                return;
            }
        }

        private FixedLengthSink(long l1)
        {
            this$0 = HttpConnection.this;
            super();
            bytesRemaining = l1;
        }

        FixedLengthSink(long l1, _cls1 _pcls1)
        {
            this(l1);
        }
    }


    private class FixedLengthSource extends AbstractSource
        implements r
    {

        private long bytesRemaining;
        final HttpConnection this$0;

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (bytesRemaining != 0L && !discard(this, 100))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(d d1, long l1)
        {
            if (l1 < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l1).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (bytesRemaining == 0L)
            {
                return -1L;
            }
            l1 = source.read(d1, Math.min(bytesRemaining, l1));
            if (l1 == -1L)
            {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            bytesRemaining = bytesRemaining - l1;
            cacheWrite(d1, l1);
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
            return l1;
        }

        public s timeout()
        {
            return source.timeout();
        }

        public FixedLengthSource(CacheRequest cacherequest, long l1)
        {
            this$0 = HttpConnection.this;
            super(cacherequest);
            bytesRemaining = l1;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
        }
    }


    private class UnknownLengthSource extends AbstractSource
        implements r
    {

        private boolean inputExhausted;
        final HttpConnection this$0;

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (!inputExhausted)
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(d d1, long l1)
        {
            if (l1 < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l1).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (inputExhausted)
            {
                return -1L;
            }
            l1 = source.read(d1, l1);
            if (l1 == -1L)
            {
                inputExhausted = true;
                endOfInput(false);
                return -1L;
            } else
            {
                cacheWrite(d1, l1);
                return l1;
            }
        }

        public s timeout()
        {
            return source.timeout();
        }

        UnknownLengthSource(CacheRequest cacherequest)
        {
            this$0 = HttpConnection.this;
            super(cacherequest);
        }
    }

}
