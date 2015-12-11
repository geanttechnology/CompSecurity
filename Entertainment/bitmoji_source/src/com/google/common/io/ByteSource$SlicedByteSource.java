// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.google.common.io:
//            ByteSource, ByteStreams, Closer

private final class length extends ByteSource
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
        return length == 0L || super.isEmpty();
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

    (long l, long l1)
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
