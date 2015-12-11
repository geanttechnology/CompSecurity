// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.protobuf:
//            ByteString, RopeByteString, Utf8, CodedInputStream

class LiteralByteString extends ByteString
{
    private class LiteralByteIterator
        implements ByteString.ByteIterator
    {

        private final int limit;
        private int position;
        final LiteralByteString this$0;

        public boolean hasNext()
        {
            return position < limit;
        }

        public Byte next()
        {
            return Byte.valueOf(nextByte());
        }

        public volatile Object next()
        {
            return next();
        }

        public byte nextByte()
        {
            byte byte0;
            byte abyte0[];
            int i;
            try
            {
                abyte0 = bytes;
                i = position;
                position = i + 1;
            }
            catch (ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
            {
                throw new NoSuchElementException(arrayindexoutofboundsexception.getMessage());
            }
            byte0 = abyte0[i];
            return byte0;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        private LiteralByteIterator()
        {
            this$0 = LiteralByteString.this;
            super();
            position = 0;
            limit = size();
        }

    }


    protected final byte bytes[];
    private int hash;

    LiteralByteString(byte abyte0[])
    {
        hash = 0;
        bytes = abyte0;
    }

    public byte byteAt(int i)
    {
        return bytes[i];
    }

    protected void copyToInternal(byte abyte0[], int i, int j, int k)
    {
        System.arraycopy(bytes, i, abyte0, j, k);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ByteString))
        {
            return false;
        }
        if (size() != ((ByteString)obj).size())
        {
            return false;
        }
        if (size() == 0)
        {
            return true;
        }
        if (obj instanceof LiteralByteString)
        {
            return equalsRange((LiteralByteString)obj, 0, size());
        }
        if (obj instanceof RopeByteString)
        {
            return obj.equals(this);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Has a new type of ByteString been created? Found ").append(obj.getClass()).toString());
        }
    }

    boolean equalsRange(LiteralByteString literalbytestring, int i, int j)
    {
        if (j > literalbytestring.size())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Length too large: ").append(j).append(size()).toString());
        }
        if (i + j > literalbytestring.size())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Ran off end of other: ").append(i).append(", ").append(j).append(", ").append(literalbytestring.size()).toString());
        }
        byte abyte0[] = bytes;
        byte abyte1[] = literalbytestring.bytes;
        int l = getOffsetIntoBytes();
        int k = getOffsetIntoBytes();
        for (i = literalbytestring.getOffsetIntoBytes() + i; k < l + j; i++)
        {
            if (abyte0[k] != abyte1[i])
            {
                return false;
            }
            k++;
        }

        return true;
    }

    protected int getOffsetIntoBytes()
    {
        return 0;
    }

    public int hashCode()
    {
        int j = hash;
        int i = j;
        if (j == 0)
        {
            i = size();
            int k = partialHash(i, 0, i);
            i = k;
            if (k == 0)
            {
                i = 1;
            }
            hash = i;
        }
        return i;
    }

    public boolean isValidUtf8()
    {
        int i = getOffsetIntoBytes();
        return Utf8.isValidUtf8(bytes, i, size() + i);
    }

    public ByteString.ByteIterator iterator()
    {
        return new LiteralByteIterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public CodedInputStream newCodedInput()
    {
        return CodedInputStream.newInstance(bytes, getOffsetIntoBytes(), size());
    }

    public InputStream newInput()
    {
        return new ByteArrayInputStream(bytes, getOffsetIntoBytes(), size());
    }

    protected int partialHash(int i, int j, int k)
    {
        byte abyte0[] = bytes;
        int l = getOffsetIntoBytes() + j;
        j = i;
        for (i = l; i < l + k; i++)
        {
            j = j * 31 + abyte0[i];
        }

        return j;
    }

    protected int partialIsValidUtf8(int i, int j, int k)
    {
        j = getOffsetIntoBytes() + j;
        return Utf8.partialIsValidUtf8(i, bytes, j, j + k);
    }

    protected int peekCachedHashCode()
    {
        return hash;
    }

    public int size()
    {
        return bytes.length;
    }

    public String toString(String s)
        throws UnsupportedEncodingException
    {
        return new String(bytes, getOffsetIntoBytes(), size(), s);
    }
}
