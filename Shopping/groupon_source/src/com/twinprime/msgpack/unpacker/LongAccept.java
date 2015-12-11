// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.MessageTypeException;

// Referenced classes of package com.twinprime.msgpack.unpacker:
//            Accept

final class LongAccept extends Accept
{

    long value;

    LongAccept()
    {
        super("integer");
    }

    void acceptInteger(byte byte0)
    {
        value = byte0;
    }

    void acceptInteger(int i)
    {
        value = i;
    }

    void acceptInteger(long l)
    {
        value = l;
    }

    void acceptInteger(short word0)
    {
        value = word0;
    }

    void acceptUnsignedInteger(byte byte0)
    {
        value = byte0 & 0xff;
    }

    void acceptUnsignedInteger(int i)
    {
        if (i < 0)
        {
            value = (long)(0x7fffffff & i) + 0x80000000L;
            return;
        } else
        {
            value = i;
            return;
        }
    }

    void acceptUnsignedInteger(long l)
    {
        if (l < 0L)
        {
            throw new MessageTypeException();
        } else
        {
            value = l;
            return;
        }
    }

    void acceptUnsignedInteger(short word0)
    {
        value = 0xffff & word0;
    }
}
