// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apx;
import android.support.v7.apy;
import android.support.v7.apz;
import android.support.v7.aqe;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            Variant, FrameReader, FrameWriter, NameValueBlockReader, 
//            ErrorCode, HeadersMode, Settings, Header

public final class Spdy3
    implements Variant
{
    static final class Reader
        implements FrameReader
    {

        private final boolean client;
        private final NameValueBlockReader headerBlockReader;
        private final apx source;

        private static transient IOException ioException(String s, Object aobj[])
            throws IOException
        {
            throw new IOException(String.format(s, aobj));
        }

        private void readGoAway(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            if (j != 8)
            {
                throw ioException("TYPE_GOAWAY length: %d != 8", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.k();
            j = source.k();
            ErrorCode errorcode = ErrorCode.fromSpdyGoAway(j);
            if (errorcode == null)
            {
                throw ioException("TYPE_GOAWAY unexpected error code: %d", new Object[] {
                    Integer.valueOf(j)
                });
            } else
            {
                handler.goAway(i & 0x7fffffff, errorcode, apy.b);
                return;
            }
        }

        private void readHeaders(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            handler.headers(false, false, source.k() & 0x7fffffff, -1, headerBlockReader.readNameValueBlock(j - 4), HeadersMode.SPDY_HEADERS);
        }

        private void readPing(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            boolean flag1 = true;
            if (j != 4)
            {
                throw ioException("TYPE_PING length: %d != 4", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.k();
            boolean flag2 = client;
            boolean flag;
            if ((i & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag2 == flag)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            handler.ping(flag, i, 0);
        }

        private void readRstStream(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            if (j != 8)
            {
                throw ioException("TYPE_RST_STREAM length: %d != 8", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.k();
            j = source.k();
            ErrorCode errorcode = ErrorCode.fromSpdy3Rst(j);
            if (errorcode == null)
            {
                throw ioException("TYPE_RST_STREAM unexpected error code: %d", new Object[] {
                    Integer.valueOf(j)
                });
            } else
            {
                handler.rstStream(i & 0x7fffffff, errorcode);
                return;
            }
        }

        private void readSettings(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            boolean flag = true;
            int k = source.k();
            if (j != k * 8 + 4)
            {
                throw ioException("TYPE_SETTINGS length: %d != 4 + 8 * %d", new Object[] {
                    Integer.valueOf(j), Integer.valueOf(k)
                });
            }
            Settings settings = new Settings();
            for (j = 0; j < k; j++)
            {
                int l = source.k();
                settings.set(l & 0xffffff, (0xff000000 & l) >>> 24, source.k());
            }

            if ((i & 1) == 0)
            {
                flag = false;
            }
            handler.settings(flag, settings);
        }

        private void readSynReply(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            int k = source.k();
            List list = headerBlockReader.readNameValueBlock(j - 4);
            boolean flag;
            if ((i & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            handler.headers(false, flag, k & 0x7fffffff, -1, list, HeadersMode.SPDY_REPLY);
        }

        private void readSynStream(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            boolean flag1 = true;
            int k = source.k();
            int l = source.k();
            source.j();
            List list = headerBlockReader.readNameValueBlock(j - 10);
            boolean flag;
            if ((i & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if ((i & 2) == 0)
            {
                flag1 = false;
            }
            handler.headers(flag1, flag, k & 0x7fffffff, l & 0x7fffffff, list, HeadersMode.SPDY_SYN_STREAM);
        }

        private void readWindowUpdate(FrameReader.Handler handler, int i, int j)
            throws IOException
        {
            if (j != 8)
            {
                throw ioException("TYPE_WINDOW_UPDATE length: %d != 8", new Object[] {
                    Integer.valueOf(j)
                });
            }
            i = source.k();
            long l = source.k() & 0x7fffffff;
            if (l == 0L)
            {
                throw ioException("windowSizeIncrement was 0", new Object[] {
                    Long.valueOf(l)
                });
            } else
            {
                handler.windowUpdate(i & 0x7fffffff, l);
                return;
            }
        }

        public void close()
            throws IOException
        {
            headerBlockReader.close();
        }

        public boolean nextFrame(FrameReader.Handler handler)
            throws IOException
        {
            boolean flag = false;
            int i;
            int j;
            int k;
            int l;
            try
            {
                j = source.k();
                k = source.k();
            }
            // Misplaced declaration of an exception variable
            catch (FrameReader.Handler handler)
            {
                return false;
            }
            if ((0x80000000 & j) != 0)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            l = (0xff000000 & k) >>> 24;
            k &= 0xffffff;
            if (i != 0)
            {
                i = (0x7fff0000 & j) >>> 16;
                if (i != 3)
                {
                    throw new ProtocolException((new StringBuilder()).append("version != 3: ").append(i).toString());
                }
                switch (0xffff & j)
                {
                case 5: // '\005'
                default:
                    source.g(k);
                    return true;

                case 1: // '\001'
                    readSynStream(handler, l, k);
                    return true;

                case 2: // '\002'
                    readSynReply(handler, l, k);
                    return true;

                case 3: // '\003'
                    readRstStream(handler, l, k);
                    return true;

                case 4: // '\004'
                    readSettings(handler, l, k);
                    return true;

                case 6: // '\006'
                    readPing(handler, l, k);
                    return true;

                case 7: // '\007'
                    readGoAway(handler, l, k);
                    return true;

                case 8: // '\b'
                    readHeaders(handler, l, k);
                    return true;

                case 9: // '\t'
                    readWindowUpdate(handler, l, k);
                    break;
                }
                return true;
            }
            if ((l & 1) != 0)
            {
                flag = true;
            }
            handler.data(flag, 0x7fffffff & j, source, k);
            return true;
        }

        public void readConnectionPreface()
        {
        }

        Reader(apx apx1, boolean flag)
        {
            source = apx1;
            headerBlockReader = new NameValueBlockReader(source);
            client = flag;
        }
    }

    static final class Writer
        implements FrameWriter
    {

        private final boolean client;
        private boolean closed;
        private final apv headerBlockBuffer = new apv();
        private final apw headerBlockOut;
        private final apw sink;

        private void writeNameValueBlockToBuffer(List list)
            throws IOException
        {
            if (headerBlockBuffer.a() != 0L)
            {
                throw new IllegalStateException();
            }
            headerBlockOut.e(list.size());
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                apy apy1 = ((Header)list.get(i)).name;
                headerBlockOut.e(apy1.f());
                headerBlockOut.b(apy1);
                apy1 = ((Header)list.get(i)).value;
                headerBlockOut.e(apy1.f());
                headerBlockOut.b(apy1);
            }

            headerBlockOut.flush();
        }

        public void ackSettings(Settings settings1)
        {
        }

        public void close()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            closed = true;
            Util.closeAll(sink, headerBlockOut);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void connectionPreface()
        {
            this;
            JVM INSTR monitorenter ;
        }

        public void data(boolean flag, int i, apv apv1, int j)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            int k;
            if (flag)
            {
                k = 1;
            } else
            {
                k = 0;
            }
            sendDataFrame(i, k, apv1, j);
            this;
            JVM INSTR monitorexit ;
            return;
            apv1;
            throw apv1;
        }

        public void flush()
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void goAway(int i, ErrorCode errorcode, byte abyte0[])
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            errorcode;
            this;
            JVM INSTR monitorexit ;
            throw errorcode;
            if (errorcode.spdyGoAwayCode == -1)
            {
                throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
            }
            sink.e(0x80030007);
            sink.e(8);
            sink.e(i);
            sink.e(errorcode.spdyGoAwayCode);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void headers(int i, List list)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            writeNameValueBlockToBuffer(list);
            int j = (int)(headerBlockBuffer.a() + 4L);
            sink.e(0x80030008);
            sink.e(j & 0xffffff | 0);
            sink.e(0x7fffffff & i);
            sink.a(headerBlockBuffer);
            this;
            JVM INSTR monitorexit ;
        }

        public int maxDataLength()
        {
            return 16383;
        }

        public void ping(boolean flag, int i, int j)
            throws IOException
        {
            boolean flag2 = true;
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_29;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            boolean flag3 = client;
            boolean flag1;
            if ((i & 1) == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag3 != flag1)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
              goto _L1
_L3:
            if (flag == flag1)
            {
                break MISSING_BLOCK_LABEL_64;
            }
            throw new IllegalArgumentException("payload != reply");
            sink.e(0x80030006);
            sink.e(4);
            sink.e(i);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
_L1:
            if (true) goto _L3; else goto _L2
_L2:
        }

        public void pushPromise(int i, int j, List list)
            throws IOException
        {
        }

        public void rstStream(int i, ErrorCode errorcode)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            errorcode;
            this;
            JVM INSTR monitorexit ;
            throw errorcode;
            if (errorcode.spdyRstCode == -1)
            {
                throw new IllegalArgumentException();
            }
            sink.e(0x80030003);
            sink.e(8);
            sink.e(0x7fffffff & i);
            sink.e(errorcode.spdyRstCode);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        void sendDataFrame(int i, int j, apv apv1, int k)
            throws IOException
        {
            if (closed)
            {
                throw new IOException("closed");
            }
            if ((long)k > 0xffffffL)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("FRAME_TOO_LARGE max size is 16Mib: ").append(k).toString());
            }
            sink.e(0x7fffffff & i);
            sink.e((j & 0xff) << 24 | 0xffffff & k);
            if (k > 0)
            {
                sink.write(apv1, k);
            }
        }

        public void settings(Settings settings1)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            settings1;
            this;
            JVM INSTR monitorexit ;
            throw settings1;
            int i = settings1.size();
            sink.e(0x80030004);
            sink.e(i * 8 + 4 & 0xffffff | 0);
            sink.e(i);
            int j = 0;
_L2:
            if (j > 10)
            {
                break MISSING_BLOCK_LABEL_139;
            }
            if (!settings1.isSet(j))
            {
                break MISSING_BLOCK_LABEL_151;
            }
            int k = settings1.flags(j);
            sink.e((k & 0xff) << 24 | j & 0xffffff);
            sink.e(settings1.get(j));
            break MISSING_BLOCK_LABEL_151;
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            j++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void synReply(boolean flag, int i, List list)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_24;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            writeNameValueBlockToBuffer(list);
            int j;
            int k;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            k = (int)(headerBlockBuffer.a() + 4L);
            sink.e(0x80030002);
            sink.e((j & 0xff) << 24 | k & 0xffffff);
            sink.e(0x7fffffff & i);
            sink.a(headerBlockBuffer);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        public void synStream(boolean flag, boolean flag1, int i, int j, List list)
            throws IOException
        {
            byte byte0 = 0;
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_29;
            list;
            this;
            JVM INSTR monitorexit ;
            throw list;
            int k;
            writeNameValueBlockToBuffer(list);
            k = (int)(10L + headerBlockBuffer.a());
            break MISSING_BLOCK_LABEL_49;
_L2:
            sink.e(0x80030001);
            sink.e(((byte0 | flag2) & 0xff) << 24 | k & 0xffffff);
            sink.e(i & 0x7fffffff);
            sink.e(j & 0x7fffffff);
            sink.f(0);
            sink.a(headerBlockBuffer);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
            return;
            boolean flag2;
            if (flag)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag1)
            {
                byte0 = 2;
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        public void windowUpdate(int i, long l)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            if (closed)
            {
                throw new IOException("closed");
            }
            break MISSING_BLOCK_LABEL_26;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
            if (l != 0L && l <= 0x7fffffffL)
            {
                break MISSING_BLOCK_LABEL_67;
            }
            throw new IllegalArgumentException((new StringBuilder()).append("windowSizeIncrement must be between 1 and 0x7fffffff: ").append(l).toString());
            sink.e(0x80030009);
            sink.e(8);
            sink.e(i);
            sink.e((int)l);
            sink.flush();
            this;
            JVM INSTR monitorexit ;
        }

        Writer(apw apw1, boolean flag)
        {
            sink = apw1;
            client = flag;
            apw1 = new Deflater();
            apw1.setDictionary(Spdy3.DICTIONARY);
            headerBlockOut = aqe.a(new apz(headerBlockBuffer, apw1));
        }
    }


    static final byte DICTIONARY[];
    static final int FLAG_FIN = 1;
    static final int FLAG_UNIDIRECTIONAL = 2;
    static final int TYPE_DATA = 0;
    static final int TYPE_GOAWAY = 7;
    static final int TYPE_HEADERS = 8;
    static final int TYPE_PING = 6;
    static final int TYPE_RST_STREAM = 3;
    static final int TYPE_SETTINGS = 4;
    static final int TYPE_SYN_REPLY = 2;
    static final int TYPE_SYN_STREAM = 1;
    static final int TYPE_WINDOW_UPDATE = 9;
    static final int VERSION = 3;

    public Spdy3()
    {
    }

    public Protocol getProtocol()
    {
        return Protocol.SPDY_3;
    }

    public FrameReader newReader(apx apx, boolean flag)
    {
        return new Reader(apx, flag);
    }

    public FrameWriter newWriter(apw apw, boolean flag)
    {
        return new Writer(apw, flag);
    }

    static 
    {
        try
        {
            DICTIONARY = "\000\000\000\007options\000\000\000\004head\000\000\000\004post\000\000\000\003put\000\000\000\006delete\000\000\000\005trace\000\000\000\006accept\000\000\000\016accept-charset\000\000\000\017accept-encoding\000\000\000\017accept-language\000\000\000\raccept-ranges\000\000\000\003age\000\000\000\005allow\000\000\000\rauthorization\000\000\000\rcache-control\000\000\000\nconnection\000\000\000\fcontent-base\000\000\000\020content-encoding\000\000\000\020content-language\000\000\000\016content-length\000\000\000\020content-location\000\000\000\013content-md5\000\000\000\rcontent-range\000\000\000\fcontent-type\000\000\000\004date\000\000\000\004etag\000\000\000\006expect\000\000\000\007expires\000\000\000\004from\000\000\000\004host\000\000\000\bif-match\000\000\000\021if-modified-since\000\000\000\rif-none-match\000\000\000\bif-range\000\000\000\023if-unmodified-since\000\000\000\rlast-modified\000\000\000\blocation\000\000\000\fmax-forwards\000\000\000\006pragma\000\000\000\022proxy-authenticate\000\000\000\023proxy-authorization\000\000\000\005range\000\000\000\007referer\000\000\000\013retry-after\000\000\000\006server\000\000\000\002te\000\000\000\007trailer\000\000\000\021transfer-encoding\000\000\000\007upgrade\000\000\000\nuser-agent\000\000\000\004vary\000\000\000\003via\000\000\000\007warning\000\000\000\020www-authenticate\000\000\000\006method\000\000\000\003get\000\000\000\006status\000\000\000\006200 OK\000\000\000\007version\000\000\000\bHTTP/1.1\000\000\000\003url\000\000\000\006public\000\000\000\nset-cookie\000\000\000\nkeep-alive\000\000\000\006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(Util.UTF_8.name());
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError();
        }
    }
}
