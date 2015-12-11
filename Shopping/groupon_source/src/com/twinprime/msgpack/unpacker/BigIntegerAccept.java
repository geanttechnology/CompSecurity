// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.unpacker:
//            Accept

final class BigIntegerAccept extends Accept
{

    BigInteger value;

    BigIntegerAccept()
    {
        super("integer");
    }

    void acceptInteger(byte byte0)
    {
        value = BigInteger.valueOf(byte0);
    }

    void acceptInteger(int i)
    {
        value = BigInteger.valueOf(i);
    }

    void acceptInteger(long l)
    {
        value = BigInteger.valueOf(l);
    }

    void acceptInteger(short word0)
    {
        value = BigInteger.valueOf(word0);
    }

    void acceptUnsignedInteger(byte byte0)
    {
        value = BigInteger.valueOf(byte0 & 0xff);
    }

    void acceptUnsignedInteger(int i)
    {
        if (i < 0)
        {
            value = BigInteger.valueOf((long)(0x7fffffff & i) + 0x80000000L);
            return;
        } else
        {
            value = BigInteger.valueOf(i);
            return;
        }
    }

    void acceptUnsignedInteger(long l)
    {
        if (l < 0L)
        {
            value = BigInteger.valueOf(0x7fffffffffffffffL + l + 1L).setBit(63);
            return;
        } else
        {
            value = BigInteger.valueOf(l);
            return;
        }
    }

    void acceptUnsignedInteger(short word0)
    {
        value = BigInteger.valueOf(0xffff & word0);
    }
}
