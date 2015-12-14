// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

// Referenced classes of package com.google.common.hash:
//            HashFunction, AbstractHasher, Funnel, HashCode, 
//            Hasher, PrimitiveSink

abstract class AbstractStreamingHashFunction
    implements HashFunction
{
    protected static abstract class AbstractStreamingHasher extends AbstractHasher
    {

        private final ByteBuffer buffer;
        private final int bufferSize;
        private final int chunkSize;

        private void munch()
        {
            buffer.flip();
            for (; buffer.remaining() >= chunkSize; process(buffer)) { }
            buffer.compact();
        }

        private void munchIfFull()
        {
            if (buffer.remaining() < 8)
            {
                munch();
            }
        }

        public final HashCode hash()
        {
            munch();
            buffer.flip();
            if (buffer.remaining() > 0)
            {
                processRemaining(buffer);
            }
            return makeHash();
        }

        abstract HashCode makeHash();

        protected abstract void process(ByteBuffer bytebuffer);

        protected void processRemaining(ByteBuffer bytebuffer)
        {
            bytebuffer.position(bytebuffer.limit());
            bytebuffer.limit(chunkSize + 7);
            for (; bytebuffer.position() < chunkSize; bytebuffer.putLong(0L)) { }
            bytebuffer.limit(chunkSize);
            bytebuffer.flip();
            process(bytebuffer);
        }

        public final Hasher putChar(char c)
        {
            buffer.putChar(c);
            munchIfFull();
            return this;
        }

        public final Hasher putObject(Object obj, Funnel funnel)
        {
            funnel.funnel(obj, this);
            return this;
        }

        public final Hasher putString(CharSequence charsequence)
        {
            for (int i = 0; i < charsequence.length(); i++)
            {
                putChar(charsequence.charAt(i));
            }

            return this;
        }

        public volatile PrimitiveSink putString(CharSequence charsequence)
        {
            return putString(charsequence);
        }

        protected AbstractStreamingHasher(int i)
        {
            this(i, i);
        }

        protected AbstractStreamingHasher(int i, int j)
        {
            boolean flag;
            if (j % i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag);
            buffer = ByteBuffer.allocate(j + 7).order(ByteOrder.LITTLE_ENDIAN);
            bufferSize = j;
            chunkSize = i;
        }
    }


    AbstractStreamingHashFunction()
    {
    }
}
