// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            BufferedSink, BufferedSource, Util, Segment, 
//            SegmentPool, ByteString, Deadline, Sink, 
//            Source

public final class OkBuffer
    implements BufferedSink, BufferedSource, Cloneable
{

    Segment head;
    long size;

    public OkBuffer()
    {
    }

    private byte[] readBytes(long l)
    {
        Util.checkOffsetAndCount(size, 0L, l);
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount > Integer.MAX_VALUE: ").append(l).toString());
        }
        int i = 0;
        byte abyte0[] = new byte[(int)l];
        do
        {
            if ((long)i >= l)
            {
                break;
            }
            int k = (int)Math.min(l - (long)i, head.limit - head.pos);
            System.arraycopy(head.data, head.pos, abyte0, i, k);
            int j = i + k;
            Segment segment = head;
            segment.pos = segment.pos + k;
            i = j;
            if (head.pos == head.limit)
            {
                Segment segment1 = head;
                head = segment1.pop();
                SegmentPool.INSTANCE.recycle(segment1);
                i = j;
            }
        } while (true);
        size = size - l;
        return abyte0;
    }

    public OkBuffer buffer()
    {
        return this;
    }

    public void clear()
    {
        skip(size);
    }

    public OkBuffer clone()
    {
        OkBuffer okbuffer = new OkBuffer();
        if (size() != 0L)
        {
            okbuffer.write(head.data, head.pos, head.limit - head.pos);
            Segment segment = head.next;
            while (segment != head) 
            {
                okbuffer.write(segment.data, segment.pos, segment.limit - segment.pos);
                segment = segment.next;
            }
        }
        return okbuffer;
    }

    public volatile Object clone()
        throws CloneNotSupportedException
    {
        return clone();
    }

    public void close()
    {
    }

    public long completeSegmentByteCount()
    {
        long l1 = size;
        if (l1 == 0L)
        {
            return 0L;
        }
        Segment segment = head.prev;
        long l = l1;
        if (segment.limit < 2048)
        {
            l = l1 - (long)(segment.limit - segment.pos);
        }
        return l;
    }

    public OkBuffer deadline(Deadline deadline1)
    {
        return this;
    }

    public volatile Sink deadline(Deadline deadline1)
    {
        return deadline(deadline1);
    }

    public volatile Source deadline(Deadline deadline1)
    {
        return deadline(deadline1);
    }

    public volatile BufferedSink emitCompleteSegments()
        throws IOException
    {
        return emitCompleteSegments();
    }

    public OkBuffer emitCompleteSegments()
    {
        return this;
    }

    public boolean equals(Object obj)
    {
        if (!(obj instanceof OkBuffer))
        {
            return false;
        }
        obj = (OkBuffer)obj;
        if (size != ((OkBuffer) (obj)).size)
        {
            return false;
        }
        if (size == 0L)
        {
            return true;
        }
        Segment segment = head;
        obj = ((OkBuffer) (obj)).head;
        int i = segment.pos;
        int j = ((Segment) (obj)).pos;
        long l = 0L;
        while (l < size) 
        {
            long l1 = Math.min(segment.limit - i, ((Segment) (obj)).limit - j);
            boolean flag = false;
            int k = i;
            i = j;
            j = k;
            for (k = ((flag) ? 1 : 0); (long)k < l1;)
            {
                if (segment.data[j] != ((Segment) (obj)).data[i])
                {
                    return false;
                }
                k++;
                i++;
                j++;
            }

            if (j == segment.limit)
            {
                segment = segment.next;
                j = segment.pos;
            }
            if (i == ((Segment) (obj)).limit)
            {
                obj = ((Segment) (obj)).next;
                k = ((Segment) (obj)).pos;
            } else
            {
                k = i;
            }
            l += l1;
            i = j;
            j = k;
        }
        return true;
    }

    public boolean exhausted()
    {
        return size == 0L;
    }

    public void flush()
    {
    }

    public byte getByte(long l)
    {
        Util.checkOffsetAndCount(size, l, 1L);
        Segment segment = head;
        do
        {
            int i = segment.limit - segment.pos;
            if (l < (long)i)
            {
                return segment.data[segment.pos + (int)l];
            }
            l -= i;
            segment = segment.next;
        } while (true);
    }

    public int hashCode()
    {
        Segment segment = head;
        if (segment == null)
        {
            return 0;
        }
        int j = 1;
        Segment segment1;
        int i;
        do
        {
            int k = segment.pos;
            int l = segment.limit;
            i = j;
            for (j = k; j < l; j++)
            {
                i = i * 31 + segment.data[j];
            }

            segment1 = segment.next;
            j = i;
            segment = segment1;
        } while (segment1 != head);
        return i;
    }

    public long indexOf(byte byte0)
    {
        return indexOf(byte0, 0L);
    }

    public long indexOf(byte byte0, long l)
    {
        Segment segment = head;
        if (segment == null)
        {
            return -1L;
        }
        long l1 = 0L;
        do
        {
            int i = segment.limit - segment.pos;
            Segment segment1;
            if (l > (long)i)
            {
                l -= i;
            } else
            {
                byte abyte0[] = segment.data;
                l = (long)segment.pos + l;
                for (long l2 = segment.limit; l < l2; l++)
                {
                    if (abyte0[(int)l] == byte0)
                    {
                        return (l1 + l) - (long)segment.pos;
                    }
                }

                l = 0L;
            }
            l1 += i;
            segment1 = segment.next;
            segment = segment1;
        } while (segment1 != head);
        return -1L;
    }

    public InputStream inputStream()
    {
        return new InputStream() {

            final OkBuffer this$0;

            public int available()
            {
                return (int)Math.min(size, 0x7fffffffL);
            }

            public void close()
            {
            }

            public int read()
            {
                return readByte() & 0xff;
            }

            public int read(byte abyte0[], int i, int j)
            {
                return OkBuffer.this.read(abyte0, i, j);
            }

            public String toString()
            {
                return (new StringBuilder()).append(OkBuffer.this).append(".inputStream()").toString();
            }

            
            {
                this$0 = OkBuffer.this;
                super();
            }
        };
    }

    public OutputStream outputStream()
    {
        return new OutputStream() {

            final OkBuffer this$0;

            public void close()
            {
            }

            public void flush()
            {
            }

            public String toString()
            {
                return (new StringBuilder()).append(this).append(".outputStream()").toString();
            }

            public void write(int i)
            {
                writeByte((byte)i);
            }

            public void write(byte abyte0[], int i, int j)
            {
                OkBuffer.this.write(abyte0, i, j);
            }

            
            {
                this$0 = OkBuffer.this;
                super();
            }
        };
    }

    int read(byte abyte0[], int i, int j)
    {
        Segment segment = head;
        if (segment == null)
        {
            i = -1;
        } else
        {
            j = Math.min(j, segment.limit - segment.pos);
            System.arraycopy(segment.data, segment.pos, abyte0, i, j);
            segment.pos = segment.pos + j;
            size = size - (long)j;
            i = j;
            if (segment.pos == segment.limit)
            {
                head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
                return j;
            }
        }
        return i;
    }

    public long read(OkBuffer okbuffer, long l)
    {
        if (size == 0L)
        {
            return -1L;
        }
        long l1 = l;
        if (l > size)
        {
            l1 = size;
        }
        okbuffer.write(this, l1);
        return l1;
    }

    public byte readByte()
    {
        if (size == 0L)
        {
            throw new IllegalStateException("size == 0");
        }
        Segment segment = head;
        int i = segment.pos;
        int j = segment.limit;
        byte abyte0[] = segment.data;
        int k = i + 1;
        byte byte0 = abyte0[i];
        size = size - 1L;
        if (k == j)
        {
            head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
            return byte0;
        } else
        {
            segment.pos = k;
            return byte0;
        }
    }

    public ByteString readByteString(long l)
    {
        return new ByteString(readBytes(l));
    }

    public int readInt()
    {
        if (size < 4L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("size < 4: ").append(size).toString());
        }
        Segment segment = head;
        int j = segment.pos;
        int i = segment.limit;
        if (i - j < 4)
        {
            return (readByte() & 0xff) << 24 | (readByte() & 0xff) << 16 | (readByte() & 0xff) << 8 | readByte() & 0xff;
        }
        byte abyte0[] = segment.data;
        int k = j + 1;
        j = abyte0[j];
        int i1 = k + 1;
        k = abyte0[k];
        int l = i1 + 1;
        byte byte0 = abyte0[i1];
        i1 = l + 1;
        j = (j & 0xff) << 24 | (k & 0xff) << 16 | (byte0 & 0xff) << 8 | abyte0[l] & 0xff;
        size = size - 4L;
        if (i1 == i)
        {
            head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
            return j;
        } else
        {
            segment.pos = i1;
            return j;
        }
    }

    public int readIntLe()
    {
        return Util.reverseBytesInt(readInt());
    }

    public short readShort()
    {
        if (size < 2L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("size < 2: ").append(size).toString());
        }
        Segment segment = head;
        int k = segment.pos;
        int i = segment.limit;
        if (i - k < 2)
        {
            return (short)((readByte() & 0xff) << 8 | readByte() & 0xff);
        }
        byte abyte0[] = segment.data;
        int j = k + 1;
        k = abyte0[k];
        int l = j + 1;
        j = abyte0[j];
        size = size - 2L;
        if (l == i)
        {
            head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else
        {
            segment.pos = l;
        }
        return (short)((k & 0xff) << 8 | j & 0xff);
    }

    public int readShortLe()
    {
        return Util.reverseBytesShort(readShort());
    }

    public String readUtf8(long l)
    {
        Util.checkOffsetAndCount(size, 0L, l);
        if (l > 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount > Integer.MAX_VALUE: ").append(l).toString());
        }
        if (l != 0L) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L4:
        return ((String) (obj));
_L2:
        Segment segment = head;
        if ((long)segment.pos + l > (long)segment.limit)
        {
            try
            {
                obj = new String(readBytes(l), "UTF-8");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new AssertionError(obj);
            }
            return ((String) (obj));
        }
        String s;
        try
        {
            s = new String(segment.data, segment.pos, (int)l, "UTF-8");
            segment.pos = (int)((long)segment.pos + l);
            size = size - l;
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new AssertionError(unsupportedencodingexception);
        }
        obj = s;
        if (segment.pos != segment.limit) goto _L4; else goto _L3
_L3:
        head = segment.pop();
        SegmentPool.INSTANCE.recycle(segment);
        return s;
    }

    public String readUtf8Line(boolean flag)
        throws EOFException
    {
        long l = indexOf((byte)10);
        if (l == -1L)
        {
            if (flag)
            {
                throw new EOFException();
            }
            String s;
            if (size != 0L)
            {
                s = readUtf8(size);
            } else
            {
                s = null;
            }
            return s;
        }
        if (l > 0L && getByte(l - 1L) == 13)
        {
            String s1 = readUtf8(l - 1L);
            skip(2L);
            return s1;
        } else
        {
            String s2 = readUtf8(l);
            skip(1L);
            return s2;
        }
    }

    public void require(long l)
        throws EOFException
    {
        if (size < l)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public long seek(byte byte0)
        throws EOFException
    {
        long l = indexOf(byte0);
        if (l == -1L)
        {
            throw new EOFException();
        } else
        {
            return l;
        }
    }

    List segmentSizes()
    {
        if (head != null) goto _L2; else goto _L1
_L1:
        Object obj = Collections.emptyList();
_L4:
        return ((List) (obj));
_L2:
        ArrayList arraylist = new ArrayList();
        arraylist.add(Integer.valueOf(head.limit - head.pos));
        Segment segment = head.next;
        do
        {
            obj = arraylist;
            if (segment == head)
            {
                continue;
            }
            arraylist.add(Integer.valueOf(segment.limit - segment.pos));
            segment = segment.next;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public long size()
    {
        return size;
    }

    public void skip(long l)
    {
        Util.checkOffsetAndCount(size, 0L, l);
        size = size - l;
        do
        {
            if (l <= 0L)
            {
                break;
            }
            int i = (int)Math.min(l, head.limit - head.pos);
            long l1 = l - (long)i;
            Segment segment = head;
            segment.pos = segment.pos + i;
            l = l1;
            if (head.pos == head.limit)
            {
                Segment segment1 = head;
                head = segment1.pop();
                SegmentPool.INSTANCE.recycle(segment1);
                l = l1;
            }
        } while (true);
    }

    public String toString()
    {
        if (size == 0L)
        {
            return "OkBuffer[size=0]";
        }
        if (size <= 16L)
        {
            ByteString bytestring = clone().readByteString(size);
            return String.format("OkBuffer[size=%s data=%s]", new Object[] {
                Long.valueOf(size), bytestring.hex()
            });
        }
        String s;
        MessageDigest messagedigest;
        try
        {
            messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(head.data, head.pos, head.limit - head.pos);
            for (Segment segment = head.next; segment != head; segment = segment.next)
            {
                messagedigest.update(segment.data, segment.pos, segment.limit - segment.pos);
            }

        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new AssertionError();
        }
        s = String.format("OkBuffer[size=%s md5=%s]", new Object[] {
            Long.valueOf(size), ByteString.of(messagedigest.digest()).hex()
        });
        return s;
    }

    Segment writableSegment(int i)
    {
        if (i < 1 || i > 2048)
        {
            throw new IllegalArgumentException();
        }
        Segment segment;
        if (head == null)
        {
            head = SegmentPool.INSTANCE.take();
            Segment segment1 = head;
            Segment segment3 = head;
            segment = head;
            segment3.prev = segment;
            segment1.next = segment;
        } else
        {
            Segment segment2 = head.prev;
            segment = segment2;
            if (segment2.limit + i > 2048)
            {
                return segment2.push(SegmentPool.INSTANCE.take());
            }
        }
        return segment;
    }

    public volatile BufferedSink write(ByteString bytestring)
        throws IOException
    {
        return write(bytestring);
    }

    public volatile BufferedSink write(byte abyte0[])
        throws IOException
    {
        return write(abyte0);
    }

    public volatile BufferedSink write(byte abyte0[], int i, int j)
        throws IOException
    {
        return write(abyte0, i, j);
    }

    public OkBuffer write(ByteString bytestring)
    {
        return write(bytestring.data, 0, bytestring.data.length);
    }

    public OkBuffer write(byte abyte0[])
    {
        return write(abyte0, 0, abyte0.length);
    }

    public OkBuffer write(byte abyte0[], int i, int j)
    {
        for (int k = i + j; i < k;)
        {
            Segment segment = writableSegment(1);
            int l = Math.min(k - i, 2048 - segment.limit);
            System.arraycopy(abyte0, i, segment.data, segment.limit, l);
            i += l;
            segment.limit = segment.limit + l;
        }

        size = size + (long)j;
        return this;
    }

    public void write(OkBuffer okbuffer, long l)
    {
        if (okbuffer == this)
        {
            throw new IllegalArgumentException("source == this");
        }
        Util.checkOffsetAndCount(okbuffer.size, 0L, l);
_L5:
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_248;
        }
        if (l >= (long)(okbuffer.head.limit - okbuffer.head.pos)) goto _L2; else goto _L1
_L1:
        Segment segment;
        if (head != null)
        {
            segment = head.prev;
        } else
        {
            segment = null;
        }
        if (segment != null && (long)(segment.limit - segment.pos) + l <= 2048L) goto _L4; else goto _L3
_L3:
        okbuffer.head = okbuffer.head.split((int)l);
_L2:
        segment = okbuffer.head;
        long l1 = segment.limit - segment.pos;
        okbuffer.head = segment.pop();
        if (head == null)
        {
            head = segment;
            segment = head;
            Segment segment1 = head;
            Segment segment2 = head;
            segment1.prev = segment2;
            segment.next = segment2;
        } else
        {
            head.prev.push(segment).compact();
        }
        okbuffer.size = okbuffer.size - l1;
        size = size + l1;
        l -= l1;
        if (true) goto _L5; else goto _L4
_L4:
        okbuffer.head.writeTo(segment, (int)l);
        okbuffer.size = okbuffer.size - l;
        size = size + l;
    }

    public volatile BufferedSink writeByte(int i)
        throws IOException
    {
        return writeByte(i);
    }

    public OkBuffer writeByte(int i)
    {
        Segment segment = writableSegment(1);
        byte abyte0[] = segment.data;
        int j = segment.limit;
        segment.limit = j + 1;
        abyte0[j] = (byte)i;
        size = size + 1L;
        return this;
    }

    public volatile BufferedSink writeInt(int i)
        throws IOException
    {
        return writeInt(i);
    }

    public OkBuffer writeInt(int i)
    {
        Segment segment = writableSegment(4);
        byte abyte0[] = segment.data;
        int k = segment.limit;
        int j = k + 1;
        abyte0[k] = (byte)(i >> 24 & 0xff);
        k = j + 1;
        abyte0[j] = (byte)(i >> 16 & 0xff);
        j = k + 1;
        abyte0[k] = (byte)(i >> 8 & 0xff);
        abyte0[j] = (byte)(i & 0xff);
        segment.limit = j + 1;
        size = size + 4L;
        return this;
    }

    public volatile BufferedSink writeShort(int i)
        throws IOException
    {
        return writeShort(i);
    }

    public OkBuffer writeShort(int i)
    {
        Segment segment = writableSegment(2);
        byte abyte0[] = segment.data;
        int j = segment.limit;
        int k = j + 1;
        abyte0[j] = (byte)(i >> 8 & 0xff);
        abyte0[k] = (byte)(i & 0xff);
        segment.limit = k + 1;
        size = size + 2L;
        return this;
    }

    public volatile BufferedSink writeUtf8(String s)
        throws IOException
    {
        return writeUtf8(s);
    }

    public OkBuffer writeUtf8(String s)
    {
        try
        {
            s = s.getBytes("UTF-8");
            s = write(s, 0, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }
}
