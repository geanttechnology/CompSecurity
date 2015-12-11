// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.MessageTypeException;

// Referenced classes of package com.twinprime.msgpack.unpacker:
//            Accept

final class IntAccept extends Accept
{

    int value;

    IntAccept()
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
        if (l < 0xffffffff80000000L || l > 0x7fffffffL)
        {
            throw new MessageTypeException();
        } else
        {
            value = (int)l;
            return;
        }
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
            throw new MessageTypeException();
        } else
        {
            value = i;
            return;
        }
    }

    void acceptUnsignedInteger(long l)
    {
        if (l < 0L || l > 0x7fffffffL)
        {
            throw new MessageTypeException();
        } else
        {
            value = (int)l;
            return;
        }
    }

    void acceptUnsignedInteger(short word0)
    {
        value = 0xffff & word0;
    }
}
