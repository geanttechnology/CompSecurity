// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager.protobuf;

import java.util.NoSuchElementException;

// Referenced classes of package com.google.tagmanager.protobuf:
//            BoundedByteString

private class <init>
    implements <init>
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

    private ()
    {
        this$0 = BoundedByteString.this;
        super();
        position = getOffsetIntoBytes();
        limit = position + size();
    }

    position(position position1)
    {
        this();
    }
}
