// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            Decoder

public class BinaryDecoder extends Decoder
{
    static class BufferAccessor
    {

        private byte buf[];
        private final BinaryDecoder decoder;
        boolean detached;
        private int limit;
        private int pos;

        void detach()
        {
            buf = decoder.buf;
            pos = decoder.pos;
            limit = decoder.limit;
            detached = true;
        }

        byte[] getBuf()
        {
            if (detached)
            {
                return buf;
            } else
            {
                return decoder.buf;
            }
        }

        int getLim()
        {
            if (detached)
            {
                return limit;
            } else
            {
                return decoder.limit;
            }
        }

        int getPos()
        {
            if (detached)
            {
                return pos;
            } else
            {
                return decoder.pos;
            }
        }

        void setBuf(byte abyte0[], int i, int j)
        {
            if (detached)
            {
                buf = abyte0;
                limit = i + j;
                pos = i;
                return;
            } else
            {
                decoder.buf = abyte0;
                decoder.limit = i + j;
                decoder.pos = i;
                decoder.minPos = i;
                return;
            }
        }

        void setLimit(int i)
        {
            if (detached)
            {
                limit = i;
                return;
            } else
            {
                decoder.limit = i;
                return;
            }
        }

        void setPos(int i)
        {
            if (detached)
            {
                pos = i;
                return;
            } else
            {
                decoder.pos = i;
                return;
            }
        }

        private BufferAccessor(BinaryDecoder binarydecoder)
        {
            detached = false;
            decoder = binarydecoder;
        }

    }

    private static class ByteArrayByteSource extends ByteSource
    {

        private boolean compacted;
        private byte data[];
        private int max;
        private int position;

        protected void attach(int i, BinaryDecoder binarydecoder)
        {
            binarydecoder.buf = data;
            binarydecoder.pos = position;
            binarydecoder.minPos = position;
            binarydecoder.limit = max;
            ba = new BufferAccessor(binarydecoder);
        }

        public void close()
            throws IOException
        {
            ba.setPos(ba.getLim());
        }

        protected void compactAndFill(byte abyte0[], int i, int j, int k)
            throws IOException
        {
            if (!compacted)
            {
                byte abyte1[] = new byte[k + 16];
                System.arraycopy(abyte0, i, abyte1, 0, k);
                ba.setBuf(abyte1, 0, k);
                compacted = true;
            }
        }

        public boolean isEof()
        {
            return ba.getLim() - ba.getPos() == 0;
        }

        public int read()
            throws IOException
        {
            max = ba.getLim();
            position = ba.getPos();
            if (position >= max)
            {
                return -1;
            } else
            {
                byte abyte0[] = ba.getBuf();
                int i = position;
                position = i + 1;
                i = abyte0[i];
                ba.setPos(position);
                return i & 0xff;
            }
        }

        protected void readRaw(byte abyte0[], int i, int j)
            throws IOException
        {
            if (tryReadRaw(abyte0, i, j) < j)
            {
                throw new EOFException();
            } else
            {
                return;
            }
        }

        protected void skipSourceBytes(long l)
            throws IOException
        {
            if (trySkipBytes(l) < l)
            {
                throw new EOFException();
            } else
            {
                return;
            }
        }

        protected int tryReadRaw(byte abyte0[], int i, int j)
            throws IOException
        {
            return 0;
        }

        protected long trySkipBytes(long l)
            throws IOException
        {
            max = ba.getLim();
            position = ba.getPos();
            long l1 = max - position;
            if (l1 >= l)
            {
                position = (int)((long)position + l);
                ba.setPos(position);
                return l;
            } else
            {
                position = (int)((long)position + l1);
                ba.setPos(position);
                return l1;
            }
        }

        private ByteArrayByteSource(byte abyte0[], int i, int j)
        {
            compacted = false;
            if (abyte0.length < 16 || j < 16)
            {
                data = new byte[16];
                System.arraycopy(abyte0, i, data, 0, j);
                position = 0;
                max = j;
                return;
            } else
            {
                data = abyte0;
                position = i;
                max = i + j;
                return;
            }
        }

    }

    static abstract class ByteSource extends InputStream
    {

        protected BufferAccessor ba;

        protected void attach(int i, BinaryDecoder binarydecoder)
        {
            binarydecoder.buf = new byte[i];
            binarydecoder.pos = 0;
            binarydecoder.minPos = 0;
            binarydecoder.limit = 0;
            ba = new BufferAccessor(binarydecoder);
        }

        public int available()
            throws IOException
        {
            return ba.getLim() - ba.getPos();
        }

        protected void compactAndFill(byte abyte0[], int i, int j, int k)
            throws IOException
        {
            System.arraycopy(abyte0, i, abyte0, j, k);
            ba.setPos(j);
            i = tryReadRaw(abyte0, j + k, abyte0.length - k);
            ba.setLimit(k + i);
        }

        protected void detach()
        {
            ba.detach();
        }

        abstract boolean isEof();

        public int read(byte abyte0[], int i, int j)
            throws IOException
        {
            int l = ba.getLim();
            int k = ba.getPos();
            byte abyte1[] = ba.getBuf();
            l -= k;
            if (l >= j)
            {
                System.arraycopy(abyte1, k, abyte0, i, j);
                ba.setPos(k + j);
                return j;
            }
            System.arraycopy(abyte1, k, abyte0, i, l);
            ba.setPos(k + l);
            i = l + tryReadRaw(abyte0, i + l, j - l);
            if (i == 0)
            {
                return -1;
            } else
            {
                return i;
            }
        }

        protected abstract void readRaw(byte abyte0[], int i, int j)
            throws IOException;

        public long skip(long l)
            throws IOException
        {
            int i = ba.getLim();
            int j = ba.getPos();
            int k = i - j;
            if ((long)k > l)
            {
                i = (int)((long)j + l);
                ba.setPos(i);
                return l;
            } else
            {
                ba.setPos(i);
                return trySkipBytes(l - (long)k) + (long)k;
            }
        }

        protected abstract void skipSourceBytes(long l)
            throws IOException;

        protected abstract int tryReadRaw(byte abyte0[], int i, int j)
            throws IOException;

        protected abstract long trySkipBytes(long l)
            throws IOException;

        protected ByteSource()
        {
        }
    }

    private static class InputStreamByteSource extends ByteSource
    {

        private InputStream in;
        protected boolean isEof;

        public void close()
            throws IOException
        {
            in.close();
        }

        public boolean isEof()
        {
            return isEof;
        }

        public int read()
            throws IOException
        {
            if (ba.getLim() - ba.getPos() == 0)
            {
                return in.read();
            } else
            {
                int i = ba.getPos();
                byte byte0 = ba.getBuf()[i];
                ba.setPos(i + 1);
                return byte0 & 0xff;
            }
        }

        protected void readRaw(byte abyte0[], int i, int j)
            throws IOException
        {
            while (j > 0) 
            {
                int k = in.read(abyte0, i, j);
                if (k < 0)
                {
                    isEof = true;
                    throw new EOFException();
                }
                j -= k;
                i += k;
            }
        }

        protected void skipSourceBytes(long l)
            throws IOException
        {
            boolean flag = false;
            while (l > 0L) 
            {
                long l1 = in.skip(l);
                if (l1 > 0L)
                {
                    l -= l1;
                } else
                if (l1 == 0L)
                {
                    if (flag)
                    {
                        isEof = true;
                        throw new EOFException();
                    }
                    flag = true;
                } else
                {
                    isEof = true;
                    throw new EOFException();
                }
            }
        }

        protected int tryReadRaw(byte abyte0[], int i, int j)
            throws IOException
        {
            int k = j;
_L2:
            if (k <= 0)
            {
                break MISSING_BLOCK_LABEL_31;
            }
            int l = in.read(abyte0, i, k);
            if (l >= 0)
            {
                break MISSING_BLOCK_LABEL_36;
            }
            try
            {
                isEof = true;
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                isEof = true;
            }
            return j - k;
            k -= l;
            i += l;
            if (true) goto _L2; else goto _L1
_L1:
        }

        protected long trySkipBytes(long l)
            throws IOException
        {
            boolean flag;
            long l1;
            l1 = l;
            flag = false;
_L2:
            if (l1 <= 0L)
            {
                break MISSING_BLOCK_LABEL_74;
            }
            long l2 = in.skip(l);
            if (l2 > 0L)
            {
                l1 -= l2;
                continue; /* Loop/switch isn't completed */
            }
            if (l2 == 0L)
            {
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_79;
                }
                try
                {
                    isEof = true;
                }
                catch (EOFException eofexception)
                {
                    isEof = true;
                }
                break MISSING_BLOCK_LABEL_74;
            }
            isEof = true;
            return l - l1;
            flag = true;
            if (true) goto _L2; else goto _L1
_L1:
        }

        private InputStreamByteSource(InputStream inputstream)
        {
            isEof = false;
            in = inputstream;
        }

    }


    private byte buf[];
    private int limit;
    private int minPos;
    private int pos;
    private final Utf8 scratchUtf8;
    private ByteSource source;

    protected BinaryDecoder()
    {
        source = null;
        buf = null;
        minPos = 0;
        pos = 0;
        limit = 0;
        scratchUtf8 = new Utf8();
    }

    BinaryDecoder(InputStream inputstream, int i)
    {
        source = null;
        buf = null;
        minPos = 0;
        pos = 0;
        limit = 0;
        scratchUtf8 = new Utf8();
        configure(inputstream, i);
    }

    BinaryDecoder(byte abyte0[], int i, int j)
    {
        source = null;
        buf = null;
        minPos = 0;
        pos = 0;
        limit = 0;
        scratchUtf8 = new Utf8();
        configure(abyte0, i, j);
    }

    private void configureSource(int i, ByteSource bytesource)
    {
        if (source != null)
        {
            source.detach();
        }
        bytesource.attach(i, this);
        source = bytesource;
    }

    private long doSkipItems()
        throws IOException
    {
        long l;
        for (l = readInt(); l < 0L; l = readInt())
        {
            doSkipBytes(readLong());
        }

        return l;
    }

    private void ensureBounds(int i)
        throws IOException
    {
        int j = limit - pos;
        if (j < i)
        {
            source.compactAndFill(buf, pos, minPos, j);
        }
    }

    private long innerLongDecode(long l)
        throws IOException
    {
        int i = 1;
        int j = buf[pos] & 0xff;
        long l2 = l ^ ((long)j & 127L) << 28;
        l = l2;
        if (j > 127)
        {
            byte abyte0[] = buf;
            int k = pos;
            i = 1 + 1;
            k = abyte0[k + 1] & 0xff;
            l = l2 ^ ((long)k & 127L) << 35;
            if (k > 127)
            {
                byte abyte1[] = buf;
                int j1 = pos;
                int i1 = i + 1;
                j1 = abyte1[j1 + 2] & 0xff;
                long l3 = l ^ ((long)j1 & 127L) << 42;
                i = i1;
                l = l3;
                if (j1 > 127)
                {
                    byte abyte2[] = buf;
                    i = pos;
                    i1++;
                    int k1 = abyte2[i + 3] & 0xff;
                    l3 ^= ((long)k1 & 127L) << 49;
                    i = i1;
                    l = l3;
                    if (k1 > 127)
                    {
                        byte abyte3[] = buf;
                        i = pos;
                        i1++;
                        int l1 = abyte3[i + 4] & 0xff;
                        l3 ^= ((long)l1 & 127L) << 56;
                        i = i1;
                        l = l3;
                        if (l1 > 127)
                        {
                            byte abyte4[] = buf;
                            int i2 = pos;
                            i = i1 + 1;
                            i1 = abyte4[i2 + 5] & 0xff;
                            l = l3 ^ ((long)i1 & 127L) << 63;
                            if (i1 > 127)
                            {
                                throw new IOException("Invalid long encoding");
                            }
                        }
                    }
                }
            }
        }
        pos = pos + i;
        return l;
    }

    public long arrayNext()
        throws IOException
    {
        return doReadItemCount();
    }

    BinaryDecoder configure(InputStream inputstream, int i)
    {
        configureSource(i, new InputStreamByteSource(inputstream));
        return this;
    }

    BinaryDecoder configure(byte abyte0[], int i, int j)
    {
        configureSource(8192, new ByteArrayByteSource(abyte0, i, j));
        return this;
    }

    protected void doReadBytes(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = limit - pos;
        if (j <= k)
        {
            System.arraycopy(buf, pos, abyte0, i, j);
            pos = pos + j;
            return;
        } else
        {
            System.arraycopy(buf, pos, abyte0, i, k);
            pos = limit;
            source.readRaw(abyte0, i + k, j - k);
            return;
        }
    }

    protected long doReadItemCount()
        throws IOException
    {
        long l1 = readLong();
        long l = l1;
        if (l1 < 0L)
        {
            readLong();
            l = -l1;
        }
        return l;
    }

    protected void doSkipBytes(long l)
        throws IOException
    {
        int i = limit - pos;
        if (l <= (long)i)
        {
            pos = (int)((long)pos + l);
            return;
        } else
        {
            pos = 0;
            limit = 0;
            long l1 = i;
            source.skipSourceBytes(l - l1);
            return;
        }
    }

    BufferAccessor getBufferAccessor()
    {
        return new BufferAccessor(this);
    }

    public InputStream inputStream()
    {
        return source;
    }

    public boolean isEnd()
        throws IOException
    {
        if (limit - pos <= 0)
        {
            if (source.isEof())
            {
                return true;
            }
            int i = source.tryReadRaw(buf, 0, buf.length);
            pos = 0;
            limit = i;
            if (i == 0)
            {
                return true;
            }
        }
        return false;
    }

    public long mapNext()
        throws IOException
    {
        return doReadItemCount();
    }

    public long readArrayStart()
        throws IOException
    {
        return doReadItemCount();
    }

    public boolean readBoolean()
        throws IOException
    {
        if (limit == pos)
        {
            limit = source.tryReadRaw(buf, 0, buf.length);
            pos = 0;
            if (limit == 0)
            {
                throw new EOFException();
            }
        }
        byte abyte0[] = buf;
        int i = pos;
        pos = i + 1;
        return (abyte0[i] & 0xff) == 1;
    }

    public ByteBuffer readBytes(ByteBuffer bytebuffer)
        throws IOException
    {
        int i = readInt();
        if (bytebuffer != null && i <= bytebuffer.capacity())
        {
            bytebuffer.clear();
        } else
        {
            bytebuffer = ByteBuffer.allocate(i);
        }
        doReadBytes(bytebuffer.array(), bytebuffer.position(), i);
        bytebuffer.limit(i);
        return bytebuffer;
    }

    public double readDouble()
        throws IOException
    {
        ensureBounds(8);
        byte byte0 = buf[pos];
        byte byte1 = buf[pos + 1];
        byte byte2 = buf[pos + 2];
        byte byte3 = buf[pos + 3];
        byte byte4 = buf[pos + 4];
        byte byte5 = buf[pos + 5];
        byte byte6 = buf[pos + 6];
        byte byte7 = buf[pos + 7];
        if (pos + 8 > limit)
        {
            throw new EOFException();
        } else
        {
            pos = pos + 8;
            return Double.longBitsToDouble((long)(byte0 & 0xff | (byte1 & 0xff) << 8 | (byte2 & 0xff) << 16 | (byte3 & 0xff) << 24) & 0xffffffffL | (long)(byte4 & 0xff | (byte5 & 0xff) << 8 | (byte6 & 0xff) << 16 | (byte7 & 0xff) << 24) << 32);
        }
    }

    public int readEnum()
        throws IOException
    {
        return readInt();
    }

    public void readFixed(byte abyte0[], int i, int j)
        throws IOException
    {
        doReadBytes(abyte0, i, j);
    }

    public float readFloat()
        throws IOException
    {
        ensureBounds(4);
        byte byte0 = buf[pos];
        byte byte1 = buf[pos + 1];
        byte byte2 = buf[pos + 2];
        byte byte3 = buf[pos + 3];
        if (pos + 4 > limit)
        {
            throw new EOFException();
        } else
        {
            pos = pos + 4;
            return Float.intBitsToFloat(byte0 & 0xff | (byte1 & 0xff) << 8 | (byte2 & 0xff) << 16 | (byte3 & 0xff) << 24);
        }
    }

    public int readIndex()
        throws IOException
    {
        return readInt();
    }

    public int readInt()
        throws IOException
    {
        ensureBounds(5);
        int i = 1;
        int i1 = buf[pos] & 0xff;
        int k = i1 & 0x7f;
        int j = k;
        if (i1 > 127)
        {
            byte abyte0[] = buf;
            j = pos;
            i = 1 + 1;
            int j1 = abyte0[j + 1] & 0xff;
            j = k ^ (j1 & 0x7f) << 7;
            if (j1 > 127)
            {
                byte abyte1[] = buf;
                int k1 = pos;
                int l = i + 1;
                int l1 = abyte1[k1 + 2] & 0xff;
                k1 = j ^ (l1 & 0x7f) << 14;
                i = l;
                j = k1;
                if (l1 > 127)
                {
                    byte abyte2[] = buf;
                    i = pos;
                    l++;
                    int i2 = abyte2[i + 3] & 0xff;
                    k1 ^= (i2 & 0x7f) << 21;
                    i = l;
                    j = k1;
                    if (i2 > 127)
                    {
                        byte abyte3[] = buf;
                        j = pos;
                        i = l + 1;
                        l = abyte3[j + 4] & 0xff;
                        j = k1 ^ (l & 0x7f) << 28;
                        if (l > 127)
                        {
                            throw new IOException("Invalid int encoding");
                        }
                    }
                }
            }
        }
        pos = pos + i;
        if (pos > limit)
        {
            throw new EOFException();
        } else
        {
            return j >>> 1 ^ -(j & 1);
        }
    }

    public long readLong()
        throws IOException
    {
        ensureBounds(10);
        byte abyte0[] = buf;
        int i = pos;
        pos = i + 1;
        int j = abyte0[i] & 0xff;
        i = j & 0x7f;
        long l1;
        if (j > 127)
        {
            byte abyte1[] = buf;
            int k = pos;
            pos = k + 1;
            k = abyte1[k] & 0xff;
            i ^= (k & 0x7f) << 7;
            if (k > 127)
            {
                byte abyte2[] = buf;
                int l = pos;
                pos = l + 1;
                l = abyte2[l] & 0xff;
                i ^= (l & 0x7f) << 14;
                if (l > 127)
                {
                    byte abyte3[] = buf;
                    int i1 = pos;
                    pos = i1 + 1;
                    i1 = abyte3[i1] & 0xff;
                    i ^= (i1 & 0x7f) << 21;
                    if (i1 > 127)
                    {
                        l1 = innerLongDecode(i);
                    } else
                    {
                        l1 = i;
                    }
                } else
                {
                    l1 = i;
                }
            } else
            {
                l1 = i;
            }
        } else
        {
            l1 = i;
        }
        if (pos > limit)
        {
            throw new EOFException();
        } else
        {
            return l1 >>> 1 ^ -(1L & l1);
        }
    }

    public long readMapStart()
        throws IOException
    {
        return doReadItemCount();
    }

    public void readNull()
        throws IOException
    {
    }

    public Utf8 readString(Utf8 utf8)
        throws IOException
    {
        int i = readInt();
        if (utf8 == null)
        {
            utf8 = new Utf8();
        }
        utf8.setByteLength(i);
        if (i != 0)
        {
            doReadBytes(utf8.getBytes(), 0, i);
        }
        return utf8;
    }

    public String readString()
        throws IOException
    {
        return readString(scratchUtf8).toString();
    }

    public long skipArray()
        throws IOException
    {
        return doSkipItems();
    }

    public void skipBytes()
        throws IOException
    {
        doSkipBytes(readInt());
    }

    public void skipFixed(int i)
        throws IOException
    {
        doSkipBytes(i);
    }

    public long skipMap()
        throws IOException
    {
        return doSkipItems();
    }

    public void skipString()
        throws IOException
    {
        doSkipBytes(readInt());
    }



/*
    static byte[] access$302(BinaryDecoder binarydecoder, byte abyte0[])
    {
        binarydecoder.buf = abyte0;
        return abyte0;
    }

*/



/*
    static int access$402(BinaryDecoder binarydecoder, int i)
    {
        binarydecoder.pos = i;
        return i;
    }

*/



/*
    static int access$502(BinaryDecoder binarydecoder, int i)
    {
        binarydecoder.limit = i;
        return i;
    }

*/


/*
    static int access$602(BinaryDecoder binarydecoder, int i)
    {
        binarydecoder.minPos = i;
        return i;
    }

*/
}
