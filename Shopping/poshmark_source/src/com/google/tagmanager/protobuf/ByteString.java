// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.tagmanager.protobuf:
//            LiteralByteString, RopeByteString, Internal, CodedInputStream, 
//            CodedOutputStream

public abstract class ByteString
    implements Iterable
{
    public static interface ByteIterator
        extends Iterator
    {

        public abstract byte nextByte();
    }

    static final class CodedBuilder
    {

        private final byte buffer[];
        private final CodedOutputStream output;

        public ByteString build()
        {
            output.checkNoSpaceLeft();
            return new LiteralByteString(buffer);
        }

        public CodedOutputStream getCodedOutput()
        {
            return output;
        }

        private CodedBuilder(int i)
        {
            buffer = new byte[i];
            output = CodedOutputStream.newInstance(buffer);
        }

    }

    public static final class Output extends OutputStream
    {

        private static final byte EMPTY_BYTE_ARRAY[] = new byte[0];
        private byte buffer[];
        private int bufferPos;
        private final ArrayList flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        private void flushFullBuffer(int i)
        {
            flushedBuffers.add(new LiteralByteString(buffer));
            flushedBuffersTotalBytes = flushedBuffersTotalBytes + buffer.length;
            buffer = new byte[Math.max(initialCapacity, Math.max(i, flushedBuffersTotalBytes >>> 1))];
            bufferPos = 0;
        }

        private void flushLastBuffer()
        {
            if (bufferPos < buffer.length)
            {
                if (bufferPos > 0)
                {
                    byte abyte0[] = new byte[bufferPos];
                    System.arraycopy(buffer, 0, abyte0, 0, bufferPos);
                    flushedBuffers.add(new LiteralByteString(abyte0));
                }
            } else
            {
                flushedBuffers.add(new LiteralByteString(buffer));
                buffer = EMPTY_BYTE_ARRAY;
            }
            flushedBuffersTotalBytes = flushedBuffersTotalBytes + bufferPos;
            bufferPos = 0;
        }

        public void reset()
        {
            this;
            JVM INSTR monitorenter ;
            flushedBuffers.clear();
            flushedBuffersTotalBytes = 0;
            bufferPos = 0;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public int size()
        {
            this;
            JVM INSTR monitorenter ;
            int i;
            int j;
            i = flushedBuffersTotalBytes;
            j = bufferPos;
            this;
            JVM INSTR monitorexit ;
            return i + j;
            Exception exception;
            exception;
            throw exception;
        }

        public ByteString toByteString()
        {
            this;
            JVM INSTR monitorenter ;
            ByteString bytestring;
            flushLastBuffer();
            bytestring = ByteString.copyFrom(flushedBuffers);
            this;
            JVM INSTR monitorexit ;
            return bytestring;
            Exception exception;
            exception;
            throw exception;
        }

        public String toString()
        {
            return String.format("<ByteString.Output@%s size=%d>", new Object[] {
                Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())
            });
        }

        public void write(int i)
        {
            this;
            JVM INSTR monitorenter ;
            byte abyte0[];
            int j;
            if (bufferPos == buffer.length)
            {
                flushFullBuffer(1);
            }
            abyte0 = buffer;
            j = bufferPos;
            bufferPos = j + 1;
            abyte0[j] = (byte)i;
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        public void write(byte abyte0[], int i, int j)
        {
            this;
            JVM INSTR monitorenter ;
            if (j > buffer.length - bufferPos) goto _L2; else goto _L1
_L1:
            System.arraycopy(abyte0, i, buffer, bufferPos, j);
            bufferPos = bufferPos + j;
_L4:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            int k;
            k = buffer.length - bufferPos;
            System.arraycopy(abyte0, i, buffer, bufferPos, k);
            j -= k;
            flushFullBuffer(j);
            System.arraycopy(abyte0, i + k, buffer, 0, j);
            bufferPos = j;
            if (true) goto _L4; else goto _L3
_L3:
            abyte0;
            throw abyte0;
        }

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
            this;
            JVM INSTR monitorenter ;
            byte abyte0[];
            ByteString abytestring[];
            int j;
            abytestring = (ByteString[])flushedBuffers.toArray(new ByteString[flushedBuffers.size()]);
            abyte0 = buffer;
            j = bufferPos;
            this;
            JVM INSTR monitorexit ;
            int k = abytestring.length;
            for (int i = 0; i < k; i++)
            {
                abytestring[i].writeTo(outputstream);
            }

            break MISSING_BLOCK_LABEL_72;
            outputstream;
            this;
            JVM INSTR monitorexit ;
            throw outputstream;
            byte abyte1[] = new byte[j];
            System.arraycopy(abyte0, 0, abyte1, 0, j);
            outputstream.write(abyte1);
            return;
        }


        Output(int i)
        {
            if (i < 0)
            {
                throw new IllegalArgumentException("Buffer size < 0");
            } else
            {
                initialCapacity = i;
                flushedBuffers = new ArrayList();
                buffer = new byte[i];
                return;
            }
        }
    }


    static final boolean $assertionsDisabled;
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;

    ByteString()
    {
    }

    private static ByteString balancedConcat(Iterator iterator1, int i)
    {
        if (!$assertionsDisabled && i < 1)
        {
            throw new AssertionError();
        }
        if (i == 1)
        {
            return (ByteString)iterator1.next();
        } else
        {
            int j = i >>> 1;
            return balancedConcat(iterator1, j).concat(balancedConcat(iterator1, i - j));
        }
    }

    public static ByteString copyFrom(Iterable iterable)
    {
        if (!(iterable instanceof Collection))
        {
            ArrayList arraylist = new ArrayList();
            Iterator iterator1 = iterable.iterator();
            do
            {
                iterable = arraylist;
                if (!iterator1.hasNext())
                {
                    break;
                }
                arraylist.add((ByteString)iterator1.next());
            } while (true);
        } else
        {
            iterable = (Collection)iterable;
        }
        if (iterable.isEmpty())
        {
            return EMPTY;
        } else
        {
            return balancedConcat(iterable.iterator(), iterable.size());
        }
    }

    public static ByteString copyFrom(String s, String s1)
        throws UnsupportedEncodingException
    {
        return new LiteralByteString(s.getBytes(s1));
    }

    public static ByteString copyFrom(ByteBuffer bytebuffer)
    {
        return copyFrom(bytebuffer, bytebuffer.remaining());
    }

    public static ByteString copyFrom(ByteBuffer bytebuffer, int i)
    {
        byte abyte0[] = new byte[i];
        bytebuffer.get(abyte0);
        return new LiteralByteString(abyte0);
    }

    public static ByteString copyFrom(byte abyte0[])
    {
        return copyFrom(abyte0, 0, abyte0.length);
    }

    public static ByteString copyFrom(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        return new LiteralByteString(abyte1);
    }

    public static ByteString copyFromUtf8(String s)
    {
        try
        {
            s = new LiteralByteString(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported?", s);
        }
        return s;
    }

    static CodedBuilder newCodedBuilder(int i)
    {
        return new CodedBuilder(i);
    }

    public static Output newOutput()
    {
        return new Output(128);
    }

    public static Output newOutput(int i)
    {
        return new Output(i);
    }

    private static ByteString readChunk(InputStream inputstream, int i)
        throws IOException
    {
        byte abyte0[] = new byte[i];
        int j = 0;
        do
        {
label0:
            {
                int k;
                if (j < i)
                {
                    k = inputstream.read(abyte0, j, i - j);
                    if (k != -1)
                    {
                        break label0;
                    }
                }
                if (j == 0)
                {
                    return null;
                } else
                {
                    return copyFrom(abyte0, 0, j);
                }
            }
            j += k;
        } while (true);
    }

    public static ByteString readFrom(InputStream inputstream)
        throws IOException
    {
        return readFrom(inputstream, 256, 8192);
    }

    public static ByteString readFrom(InputStream inputstream, int i)
        throws IOException
    {
        return readFrom(inputstream, i, i);
    }

    public static ByteString readFrom(InputStream inputstream, int i, int j)
        throws IOException
    {
        ArrayList arraylist = new ArrayList();
        do
        {
            ByteString bytestring = readChunk(inputstream, i);
            if (bytestring == null)
            {
                return copyFrom(arraylist);
            }
            arraylist.add(bytestring);
            i = Math.min(i * 2, j);
        } while (true);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List asReadOnlyByteBufferList();

    public abstract byte byteAt(int i);

    public ByteString concat(ByteString bytestring)
    {
        int i = size();
        int j = bytestring.size();
        if ((long)i + (long)j >= 0x7fffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("ByteString would be too long: ").append(i).append("+").append(j).toString());
        } else
        {
            return RopeByteString.concatenate(this, bytestring);
        }
    }

    public abstract void copyTo(ByteBuffer bytebuffer);

    public void copyTo(byte abyte0[], int i)
    {
        copyTo(abyte0, 0, i, size());
    }

    public void copyTo(byte abyte0[], int i, int j, int k)
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Source offset < 0: ").append(i).toString());
        }
        if (j < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Target offset < 0: ").append(j).toString());
        }
        if (k < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Length < 0: ").append(k).toString());
        }
        if (i + k > size())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Source end offset < 0: ").append(i + k).toString());
        }
        if (j + k > abyte0.length)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Target end offset < 0: ").append(j + k).toString());
        }
        if (k > 0)
        {
            copyToInternal(abyte0, i, j, k);
        }
    }

    protected abstract void copyToInternal(byte abyte0[], int i, int j, int k);

    public boolean endsWith(ByteString bytestring)
    {
        return size() >= bytestring.size() && substring(size() - bytestring.size()).equals(bytestring);
    }

    public abstract boolean equals(Object obj);

    protected abstract int getTreeDepth();

    public abstract int hashCode();

    protected abstract boolean isBalanced();

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    public abstract ByteIterator iterator();

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public abstract CodedInputStream newCodedInput();

    public abstract InputStream newInput();

    protected abstract int partialHash(int i, int j, int k);

    protected abstract int partialIsValidUtf8(int i, int j, int k);

    protected abstract int peekCachedHashCode();

    public abstract int size();

    public boolean startsWith(ByteString bytestring)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (size() >= bytestring.size())
        {
            flag = flag1;
            if (substring(0, bytestring.size()).equals(bytestring))
            {
                flag = true;
            }
        }
        return flag;
    }

    public ByteString substring(int i)
    {
        return substring(i, size());
    }

    public abstract ByteString substring(int i, int j);

    public byte[] toByteArray()
    {
        int i = size();
        if (i == 0)
        {
            return Internal.EMPTY_BYTE_ARRAY;
        } else
        {
            byte abyte0[] = new byte[i];
            copyToInternal(abyte0, 0, 0, i);
            return abyte0;
        }
    }

    public String toString()
    {
        return String.format("<ByteString@%s size=%d>", new Object[] {
            Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())
        });
    }

    public abstract String toString(String s)
        throws UnsupportedEncodingException;

    public String toStringUtf8()
    {
        String s;
        try
        {
            s = toString("UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            throw new RuntimeException("UTF-8 not supported?", unsupportedencodingexception);
        }
        return s;
    }

    public abstract void writeTo(OutputStream outputstream)
        throws IOException;

    void writeTo(OutputStream outputstream, int i, int j)
        throws IOException
    {
        if (i < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Source offset < 0: ").append(i).toString());
        }
        if (j < 0)
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Length < 0: ").append(j).toString());
        }
        if (i + j > size())
        {
            throw new IndexOutOfBoundsException((new StringBuilder()).append("Source end offset exceeded: ").append(i + j).toString());
        }
        if (j > 0)
        {
            writeToInternal(outputstream, i, j);
        }
    }

    abstract void writeToInternal(OutputStream outputstream, int i, int j)
        throws IOException;

    static 
    {
        boolean flag;
        if (!com/google/tagmanager/protobuf/ByteString.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
