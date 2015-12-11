// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

// Referenced classes of package com.google.common.io:
//            ByteStreams, Closer, ByteSink, CharSource, 
//            ByteProcessor, BaseEncoding, MultiInputStream

public abstract class ByteSource
{
    private final class AsCharSource extends CharSource
    {

        private final Charset charset;
        final ByteSource this$0;

        public Reader openStream()
            throws IOException
        {
            return new InputStreamReader(ByteSource.this.openStream(), charset);
        }

        public String toString()
        {
            String s = String.valueOf(Object.this.toString());
            String s1 = String.valueOf(charset);
            return (new StringBuilder(String.valueOf(s).length() + 15 + String.valueOf(s1).length())).append(s).append(".asCharSource(").append(s1).append(")").toString();
        }

        private AsCharSource(Charset charset1)
        {
            this$0 = ByteSource.this;
            super();
            charset = (Charset)Preconditions.checkNotNull(charset1);
        }

    }

    private static class ByteArrayByteSource extends ByteSource
    {

        final byte bytes[];
        final int length;
        final int offset;

        public long copyTo(OutputStream outputstream)
            throws IOException
        {
            outputstream.write(bytes, offset, length);
            return (long)length;
        }

        public HashCode hash(HashFunction hashfunction)
            throws IOException
        {
            return hashfunction.hashBytes(bytes, offset, length);
        }

        public boolean isEmpty()
        {
            return length == 0;
        }

        public InputStream openBufferedStream()
            throws IOException
        {
            return openStream();
        }

        public InputStream openStream()
        {
            return new ByteArrayInputStream(bytes, offset, length);
        }

        public Object read(ByteProcessor byteprocessor)
            throws IOException
        {
            byteprocessor.processBytes(bytes, offset, length);
            return byteprocessor.getResult();
        }

        public byte[] read()
        {
            return Arrays.copyOfRange(bytes, offset, offset + length);
        }

        public long size()
        {
            return (long)length;
        }

        public Optional sizeIfKnown()
        {
            return Optional.of(Long.valueOf(length));
        }

        public ByteSource slice(long l, long l1)
        {
            int i;
            int j;
            boolean flag;
            if (l >= 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "offset (%s) may not be negative", new Object[] {
                Long.valueOf(l)
            });
            if (l1 >= 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "length (%s) may not be negative", new Object[] {
                Long.valueOf(l1)
            });
            l = Math.min(l, length);
            l1 = Math.min(l1, (long)length - l);
            i = offset;
            j = (int)l;
            return new ByteArrayByteSource(bytes, i + j, (int)l1);
        }

        public String toString()
        {
            String s = Ascii.truncate(BaseEncoding.base16().encode(bytes, offset, length), 30, "...");
            return (new StringBuilder(String.valueOf(s).length() + 17)).append("ByteSource.wrap(").append(s).append(")").toString();
        }

        ByteArrayByteSource(byte abyte0[])
        {
            this(abyte0, 0, abyte0.length);
        }

        ByteArrayByteSource(byte abyte0[], int i, int j)
        {
            bytes = abyte0;
            offset = i;
            length = j;
        }
    }

    private static final class ConcatenatedByteSource extends ByteSource
    {

        final Iterable sources;

        public boolean isEmpty()
            throws IOException
        {
            for (Iterator iterator = sources.iterator(); iterator.hasNext();)
            {
                if (!((ByteSource)iterator.next()).isEmpty())
                {
                    return false;
                }
            }

            return true;
        }

        public InputStream openStream()
            throws IOException
        {
            return new MultiInputStream(sources.iterator());
        }

        public long size()
            throws IOException
        {
            long l = 0L;
            for (Iterator iterator = sources.iterator(); iterator.hasNext();)
            {
                l += ((ByteSource)iterator.next()).size();
            }

            return l;
        }

        public Optional sizeIfKnown()
        {
            long l = 0L;
            for (Iterator iterator = sources.iterator(); iterator.hasNext();)
            {
                Optional optional = ((ByteSource)iterator.next()).sizeIfKnown();
                if (!optional.isPresent())
                {
                    return Optional.absent();
                }
                l += ((Long)optional.get()).longValue();
            }

            return Optional.of(Long.valueOf(l));
        }

        public String toString()
        {
            String s = String.valueOf(sources);
            return (new StringBuilder(String.valueOf(s).length() + 19)).append("ByteSource.concat(").append(s).append(")").toString();
        }

        ConcatenatedByteSource(Iterable iterable)
        {
            sources = (Iterable)Preconditions.checkNotNull(iterable);
        }
    }

    private static final class EmptyByteSource extends ByteArrayByteSource
    {

        static final EmptyByteSource INSTANCE = new EmptyByteSource();

        public CharSource asCharSource(Charset charset)
        {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        public byte[] read()
        {
            return bytes;
        }

        public String toString()
        {
            return "ByteSource.empty()";
        }


        EmptyByteSource()
        {
            super(new byte[0]);
        }
    }

    private final class SlicedByteSource extends ByteSource
    {

        final long length;
        final long offset;
        final ByteSource this$0;

        private InputStream sliceStream(InputStream inputstream)
            throws IOException
        {
            if (offset <= 0L)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            long l = ByteStreams.skipUpTo(inputstream, offset);
            if (l < offset)
            {
                inputstream.close();
                return new ByteArrayInputStream(new byte[0]);
            }
            break MISSING_BLOCK_LABEL_68;
            Throwable throwable;
            throwable;
            Closer closer;
            closer = Closer.create();
            closer.register(inputstream);
            throw closer.rethrow(throwable);
            inputstream;
            closer.close();
            throw inputstream;
            return ByteStreams.limit(inputstream, length);
        }

        public boolean isEmpty()
            throws IOException
        {
            return length == 0L || isEmpty();
        }

        public InputStream openBufferedStream()
            throws IOException
        {
            return sliceStream(ByteSource.this.openBufferedStream());
        }

        public InputStream openStream()
            throws IOException
        {
            return sliceStream(ByteSource.this.openStream());
        }

        public Optional sizeIfKnown()
        {
            Optional optional = ByteSource.this.sizeIfKnown();
            if (optional.isPresent())
            {
                long l = ((Long)optional.get()).longValue();
                long l1 = Math.min(offset, l);
                return Optional.of(Long.valueOf(Math.min(length, l - l1)));
            } else
            {
                return Optional.absent();
            }
        }

        public ByteSource slice(long l, long l1)
        {
            long l2;
            boolean flag;
            if (l >= 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "offset (%s) may not be negative", new Object[] {
                Long.valueOf(l)
            });
            if (l1 >= 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "length (%s) may not be negative", new Object[] {
                Long.valueOf(l1)
            });
            l2 = length;
            return ByteSource.this.slice(offset + l, Math.min(l1, l2 - l));
        }

        public String toString()
        {
            String s = String.valueOf(Object.this.toString());
            long l = offset;
            long l1 = length;
            return (new StringBuilder(String.valueOf(s).length() + 50)).append(s).append(".slice(").append(l).append(", ").append(l1).append(")").toString();
        }

        SlicedByteSource(long l, long l1)
        {
            this$0 = ByteSource.this;
            super();
            boolean flag;
            if (l >= 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "offset (%s) may not be negative", new Object[] {
                Long.valueOf(l)
            });
            if (l1 >= 0L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "length (%s) may not be negative", new Object[] {
                Long.valueOf(l1)
            });
            offset = l;
            length = l1;
        }
    }


    protected ByteSource()
    {
    }

    public static ByteSource concat(Iterable iterable)
    {
        return new ConcatenatedByteSource(iterable);
    }

    public static ByteSource concat(Iterator iterator)
    {
        return concat(((Iterable) (ImmutableList.copyOf(iterator))));
    }

    public static transient ByteSource concat(ByteSource abytesource[])
    {
        return concat(((Iterable) (ImmutableList.copyOf(abytesource))));
    }

    private long countByReading(InputStream inputstream)
        throws IOException
    {
        long l = 0L;
        do
        {
            long l1 = inputstream.read(ByteStreams.skipBuffer);
            if (l1 != -1L)
            {
                l += l1;
            } else
            {
                return l;
            }
        } while (true);
    }

    private long countBySkipping(InputStream inputstream)
        throws IOException
    {
        long l = 0L;
        do
        {
            long l1 = ByteStreams.skipUpTo(inputstream, 0x7fffffffL);
            if (l1 > 0L)
            {
                l += l1;
            } else
            {
                return l;
            }
        } while (true);
    }

    public static ByteSource empty()
    {
        return EmptyByteSource.INSTANCE;
    }

    public static ByteSource wrap(byte abyte0[])
    {
        return new ByteArrayByteSource(abyte0);
    }

    public CharSource asCharSource(Charset charset)
    {
        return new AsCharSource(charset);
    }

    public boolean contentEquals(ByteSource bytesource)
        throws IOException
    {
        Closer closer;
        byte abyte0[];
        byte abyte1[];
        Preconditions.checkNotNull(bytesource);
        abyte0 = new byte[8192];
        abyte1 = new byte[8192];
        closer = Closer.create();
        InputStream inputstream;
        inputstream = (InputStream)closer.register(openStream());
        bytesource = (InputStream)closer.register(bytesource.openStream());
_L4:
        int i = ByteStreams.read(inputstream, abyte0, 0, 8192);
        if (i != ByteStreams.read(bytesource, abyte1, 0, 8192)) goto _L2; else goto _L1
_L1:
        boolean flag = Arrays.equals(abyte0, abyte1);
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        closer.close();
        return false;
        if (i == 8192) goto _L4; else goto _L3
_L3:
        closer.close();
        return true;
        bytesource;
        throw closer.rethrow(bytesource);
        bytesource;
        closer.close();
        throw bytesource;
    }

    public long copyTo(ByteSink bytesink)
        throws IOException
    {
        Closer closer;
        Preconditions.checkNotNull(bytesink);
        closer = Closer.create();
        long l = ByteStreams.copy((InputStream)closer.register(openStream()), (OutputStream)closer.register(bytesink.openStream()));
        closer.close();
        return l;
        bytesink;
        throw closer.rethrow(bytesink);
        bytesink;
        closer.close();
        throw bytesink;
    }

    public long copyTo(OutputStream outputstream)
        throws IOException
    {
        Closer closer;
        Preconditions.checkNotNull(outputstream);
        closer = Closer.create();
        long l = ByteStreams.copy((InputStream)closer.register(openStream()), outputstream);
        closer.close();
        return l;
        outputstream;
        throw closer.rethrow(outputstream);
        outputstream;
        closer.close();
        throw outputstream;
    }

    public HashCode hash(HashFunction hashfunction)
        throws IOException
    {
        hashfunction = hashfunction.newHasher();
        copyTo(Funnels.asOutputStream(hashfunction));
        return hashfunction.hash();
    }

    public boolean isEmpty()
        throws IOException
    {
        Object obj;
        obj = sizeIfKnown();
        if (((Optional) (obj)).isPresent() && ((Long)((Optional) (obj)).get()).longValue() == 0L)
        {
            return true;
        }
        obj = Closer.create();
        int i = ((InputStream)((Closer) (obj)).register(openStream())).read();
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Closer) (obj)).close();
        return flag;
        Object obj1;
        obj1;
        throw ((Closer) (obj)).rethrow(((Throwable) (obj1)));
        obj1;
        ((Closer) (obj)).close();
        throw obj1;
    }

    public InputStream openBufferedStream()
        throws IOException
    {
        InputStream inputstream = openStream();
        if (inputstream instanceof BufferedInputStream)
        {
            return (BufferedInputStream)inputstream;
        } else
        {
            return new BufferedInputStream(inputstream);
        }
    }

    public abstract InputStream openStream()
        throws IOException;

    public Object read(ByteProcessor byteprocessor)
        throws IOException
    {
        Closer closer;
        Preconditions.checkNotNull(byteprocessor);
        closer = Closer.create();
        byteprocessor = ((ByteProcessor) (ByteStreams.readBytes((InputStream)closer.register(openStream()), byteprocessor)));
        closer.close();
        return byteprocessor;
        byteprocessor;
        throw closer.rethrow(byteprocessor);
        byteprocessor;
        closer.close();
        throw byteprocessor;
    }

    public byte[] read()
        throws IOException
    {
        Closer closer = Closer.create();
        byte abyte0[] = ByteStreams.toByteArray((InputStream)closer.register(openStream()));
        closer.close();
        return abyte0;
        Object obj;
        obj;
        throw closer.rethrow(((Throwable) (obj)));
        obj;
        closer.close();
        throw obj;
    }

    public long size()
        throws IOException
    {
        Object obj;
        obj = sizeIfKnown();
        if (((Optional) (obj)).isPresent())
        {
            return ((Long)((Optional) (obj)).get()).longValue();
        }
        obj = Closer.create();
        long l = countBySkipping((InputStream)((Closer) (obj)).register(openStream()));
        ((Closer) (obj)).close();
        return l;
        Object obj1;
        obj1;
        ((Closer) (obj)).close();
        obj = Closer.create();
        l = countByReading((InputStream)((Closer) (obj)).register(openStream()));
        ((Closer) (obj)).close();
        return l;
        obj1;
        ((Closer) (obj)).close();
        throw obj1;
        obj1;
        throw ((Closer) (obj)).rethrow(((Throwable) (obj1)));
        obj1;
        ((Closer) (obj)).close();
        throw obj1;
    }

    public Optional sizeIfKnown()
    {
        return Optional.absent();
    }

    public ByteSource slice(long l, long l1)
    {
        return new SlicedByteSource(l, l1);
    }
}
