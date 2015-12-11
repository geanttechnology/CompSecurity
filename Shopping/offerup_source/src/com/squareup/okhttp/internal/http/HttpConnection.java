// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Internal;
import d.aa;
import d.ab;
import d.ac;
import d.f;
import d.i;
import d.j;
import d.q;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            StatusLine, OkHeaders, RetryableSink, HttpEngine

public final class HttpConnection
{

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
    private final i sink;
    private final Socket socket;
    private final j source;
    private int state;

    public HttpConnection(ConnectionPool connectionpool, Connection connection1, Socket socket1)
    {
        state = 0;
        onIdle = 0;
        pool = connectionpool;
        connection = connection1;
        socket = socket1;
        source = q.a(q.b(socket1));
        sink = q.a(q.a(socket1));
    }

    public final long bufferSize()
    {
        return source.b().a();
    }

    public final void closeIfOwnedBy(Object obj)
    {
        Internal.instance.closeIfOwnedBy(connection, obj);
    }

    public final void closeOnIdle()
    {
        onIdle = 2;
        if (state == 0)
        {
            state = 6;
            connection.getSocket().close();
        }
    }

    public final void flush()
    {
        sink.flush();
    }

    public final boolean isClosed()
    {
        return state == 6;
    }

    public final boolean isReadable()
    {
        Exception exception;
        int k;
        boolean flag;
        try
        {
            k = socket.getSoTimeout();
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
        socket.setSoTimeout(k);
        return false;
        socket.setSoTimeout(k);
        return true;
        exception;
        socket.setSoTimeout(k);
        throw exception;
    }

    public final aa newChunkedSink()
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 2;
            return new ChunkedSink(null);
        }
    }

    public final ab newChunkedSource(HttpEngine httpengine)
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 5;
            return new ChunkedSource(httpengine);
        }
    }

    public final aa newFixedLengthSink(long l)
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 2;
            return new FixedLengthSink(l, null);
        }
    }

    public final ab newFixedLengthSource(long l)
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 5;
            return new FixedLengthSource(l);
        }
    }

    public final ab newUnknownLengthSource()
    {
        if (state != 4)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 5;
            return new UnknownLengthSource(null);
        }
    }

    public final void poolOnIdle()
    {
        onIdle = 1;
        if (state == 0)
        {
            onIdle = 0;
            Internal.instance.recycle(pool, connection);
        }
    }

    public final void readHeaders(com.squareup.okhttp.Headers.Builder builder)
    {
        do
        {
            String s = source.o();
            if (s.length() != 0)
            {
                Internal.instance.addLenient(builder, s);
            } else
            {
                return;
            }
        } while (true);
    }

    public final com.squareup.okhttp.Response.Builder readResponse()
    {
        if (state != 1 && state != 3)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        }
        com.squareup.okhttp.Response.Builder builder;
        try
        {
            StatusLine statusline;
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
        }
        catch (EOFException eofexception)
        {
            IOException ioexception = new IOException((new StringBuilder("unexpected end of stream on ")).append(connection).append(" (recycle count=").append(Internal.instance.recycleCount(connection)).append(")").toString());
            ioexception.initCause(eofexception);
            throw ioexception;
        }
        return builder;
    }

    public final void setTimeouts(int k, int l)
    {
        if (k != 0)
        {
            source.timeout().timeout(k, TimeUnit.MILLISECONDS);
        }
        if (l != 0)
        {
            sink.timeout().timeout(l, TimeUnit.MILLISECONDS);
        }
    }

    public final void writeRequest(Headers headers, String s)
    {
        if (state != 0)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        }
        sink.b(s).b("\r\n");
        int k = 0;
        for (int l = headers.size(); k < l; k++)
        {
            sink.b(headers.name(k)).b(": ").b(headers.value(k)).b("\r\n");
        }

        sink.b("\r\n");
        state = 1;
    }

    public final void writeRequestBody(RetryableSink retryablesink)
    {
        if (state != 1)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
        } else
        {
            state = 3;
            retryablesink.writeToSocket(sink);
            return;
        }
    }




/*
    static int access$402(HttpConnection httpconnection, int k)
    {
        httpconnection.state = k;
        return k;
    }

*/




/*
    static int access$602(HttpConnection httpconnection, int k)
    {
        httpconnection.onIdle = k;
        return k;
    }

*/



    private class ChunkedSink
        implements aa
    {

        private boolean closed;
        final HttpConnection this$0;

        public final void close()
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
            sink.b("0\r\n\r\n");
            state = 3;
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        public final void flush()
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

        public final ac timeout()
        {
            return sink.timeout();
        }

        public final void write(f f1, long l)
        {
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (l == 0L)
            {
                return;
            } else
            {
                sink.i(l);
                sink.b("\r\n");
                sink.write(f1, l);
                sink.b("\r\n");
                return;
            }
        }

        private ChunkedSink()
        {
            this$0 = HttpConnection.this;
            super();
        }

        ChunkedSink(_cls1 _pcls1)
        {
            this();
        }
    }


    private class ChunkedSource extends AbstractSource
    {
        private class AbstractSource
            implements ab
        {

            protected boolean closed;
            final HttpConnection this$0;

            protected final void endOfInput(boolean flag)
            {
                if (state != 5)
                {
                    throw new IllegalStateException((new StringBuilder("state: ")).append(state).toString());
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

            public ac timeout()
            {
                return source.timeout();
            }

            protected final void unexpectedEndOfInput()
            {
                Util.closeQuietly(connection.getSocket());
                state = 6;
            }

            private AbstractSource()
            {
                this$0 = HttpConnection.this;
                super();
            }

            AbstractSource(_cls1 _pcls1)
            {
                this();
            }
        }


        private static final long NO_CHUNK_YET = -1L;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;
        final HttpConnection this$0;

        private void readChunkSize()
        {
            if (bytesRemainingInChunk != -1L)
            {
                source.o();
            }
            try
            {
                bytesRemainingInChunk = source.m();
                String s = source.o().trim();
                if (bytesRemainingInChunk < 0L || !s.isEmpty() && !s.startsWith(";"))
                {
                    throw new ProtocolException((new StringBuilder("expected chunk size and optional extensions but was \"")).append(bytesRemainingInChunk).append(s).append("\"").toString());
                }
            }
            catch (NumberFormatException numberformatexception)
            {
                throw new ProtocolException(numberformatexception.getMessage());
            }
            if (bytesRemainingInChunk == 0L)
            {
                hasMoreChunks = false;
                com.squareup.okhttp.Headers.Builder builder = new com.squareup.okhttp.Headers.Builder();
                readHeaders(builder);
                httpEngine.receiveHeaders(builder.build());
                endOfInput(true);
            }
        }

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(f f1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (hasMoreChunks) goto _L2; else goto _L1
_L1:
            return -1L;
_L2:
            if (bytesRemainingInChunk != 0L && bytesRemainingInChunk != -1L)
            {
                break; /* Loop/switch isn't completed */
            }
            readChunkSize();
            if (!hasMoreChunks) goto _L1; else goto _L3
_L3:
            l = source.read(f1, Math.min(l, bytesRemainingInChunk));
            if (l == -1L)
            {
                unexpectedEndOfInput();
                throw new IOException("unexpected end of stream");
            } else
            {
                bytesRemainingInChunk = bytesRemainingInChunk - l;
                return l;
            }
        }

        ChunkedSource(HttpEngine httpengine)
        {
            this$0 = HttpConnection.this;
            super(null);
            bytesRemainingInChunk = -1L;
            hasMoreChunks = true;
            httpEngine = httpengine;
        }
    }


    private class FixedLengthSink
        implements aa
    {

        private long bytesRemaining;
        private boolean closed;
        final HttpConnection this$0;

        public final void close()
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

        public final void flush()
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

        public final ac timeout()
        {
            return sink.timeout();
        }

        public final void write(f f1, long l)
        {
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(f1.a(), 0L, l);
            if (l > bytesRemaining)
            {
                throw new ProtocolException((new StringBuilder("expected ")).append(bytesRemaining).append(" bytes but received ").append(l).toString());
            } else
            {
                sink.write(f1, l);
                bytesRemaining = bytesRemaining - l;
                return;
            }
        }

        private FixedLengthSink(long l)
        {
            this$0 = HttpConnection.this;
            super();
            bytesRemaining = l;
        }

        FixedLengthSink(long l, _cls1 _pcls1)
        {
            this(l);
        }
    }


    private class FixedLengthSource extends AbstractSource
    {

        private long bytesRemaining;
        final HttpConnection this$0;

        public void close()
        {
            if (closed)
            {
                return;
            }
            if (bytesRemaining != 0L && !Util.discard(this, 100, TimeUnit.MILLISECONDS))
            {
                unexpectedEndOfInput();
            }
            closed = true;
        }

        public long read(f f1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (bytesRemaining == 0L)
            {
                return -1L;
            }
            l = source.read(f1, Math.min(bytesRemaining, l));
            if (l == -1L)
            {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            bytesRemaining = bytesRemaining - l;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
            return l;
        }

        public FixedLengthSource(long l)
        {
            this$0 = HttpConnection.this;
            super(null);
            bytesRemaining = l;
            if (bytesRemaining == 0L)
            {
                endOfInput(true);
            }
        }
    }


    private class UnknownLengthSource extends AbstractSource
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

        public long read(f f1, long l)
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
            }
            if (closed)
            {
                throw new IllegalStateException("closed");
            }
            if (inputExhausted)
            {
                return -1L;
            }
            l = source.read(f1, l);
            if (l == -1L)
            {
                inputExhausted = true;
                endOfInput(false);
                return -1L;
            } else
            {
                return l;
            }
        }

        private UnknownLengthSource()
        {
            this$0 = HttpConnection.this;
            super(null);
        }

        UnknownLengthSource(_cls1 _pcls1)
        {
            this();
        }
    }

}
