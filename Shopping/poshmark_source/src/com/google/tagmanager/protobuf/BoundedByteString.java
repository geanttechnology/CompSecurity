// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.tagmanager.protobuf:
//            LiteralByteString

class BoundedByteString extends LiteralByteString
{
    private class BoundedByteIterator
        implements ByteString.ByteIterator
    {

        private final int limit;
        private int position;
        final BoundedByteString this$0;

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
            if (position >= limit)
            {
                throw new NoSuchElementException();
            } else
            {
                byte abyte0[] = bytes;
                int i = position;
                position = i + 1;
                return abyte0[i];
            }
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        private BoundedByteIterator()
        {
            this$0 = BoundedByteString.this;
            super();
            position = getOffsetIntoBytes();
            limit = position + size();
        }

    }


    private final int bytesLength;
    private final int bytesOffset;

    BoundedByteString(byte abyte0[], int i, int j)
    {
        super(abyte0);
        if (i < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Offset too small: ").append(i).toString());
        }
        if (j < 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Length too small: ").append(i).toString());
        }
        if ((long)i + (long)j > (long)abyte0.length)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Offset+Length too large: ").append(i).append("+").append(j).toString());
        } else
        {
            bytesOffset = i;
            bytesLength = j;
            return;
        }
    }

    public byte byteAt(int i)
    {
        if (i < 0)
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("Index too small: ").append(i).toString());
        }
        if (i >= size())
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("Index too large: ").append(i).append(", ").append(size()).toString());
        } else
        {
            return bytes[bytesOffset + i];
        }
    }

    protected void copyToInternal(byte abyte0[], int i, int j, int k)
    {
        System.arraycopy(bytes, getOffsetIntoBytes() + i, abyte0, j, k);
    }

    protected int getOffsetIntoBytes()
    {
        return bytesOffset;
    }

    public ByteString.ByteIterator iterator()
    {
        return new BoundedByteIterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public int size()
    {
        return bytesLength;
    }
}
