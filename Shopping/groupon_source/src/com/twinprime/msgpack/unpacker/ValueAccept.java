// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.unpacker;

import com.twinprime.msgpack.packer.Unconverter;
import com.twinprime.msgpack.type.ValueFactory;
import java.io.IOException;
import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.unpacker:
//            Accept

final class ValueAccept extends Accept
{

    private Unconverter uc;

    ValueAccept()
    {
        super(null);
        uc = null;
    }

    void acceptArray(int i)
        throws IOException
    {
        uc.writeArrayBegin(i);
    }

    void acceptDouble(double d)
        throws IOException
    {
        uc.write(ValueFactory.createFloatValue(d));
    }

    void acceptEmptyRaw()
        throws IOException
    {
        uc.write(ValueFactory.createRawValue());
    }

    void acceptFloat(float f)
        throws IOException
    {
        uc.write(ValueFactory.createFloatValue(f));
    }

    void acceptInteger(byte byte0)
        throws IOException
    {
        uc.write(ValueFactory.createIntegerValue(byte0));
    }

    void acceptInteger(int i)
        throws IOException
    {
        uc.write(ValueFactory.createIntegerValue(i));
    }

    void acceptInteger(long l)
        throws IOException
    {
        uc.write(ValueFactory.createIntegerValue(l));
    }

    void acceptInteger(short word0)
        throws IOException
    {
        uc.write(ValueFactory.createIntegerValue(word0));
    }

    void acceptMap(int i)
        throws IOException
    {
        uc.writeMapBegin(i);
    }

    void acceptNil()
        throws IOException
    {
        uc.write(ValueFactory.createNilValue());
    }

    void acceptRaw(byte abyte0[])
        throws IOException
    {
        uc.write(ValueFactory.createRawValue(abyte0));
    }

    void acceptUnsignedInteger(byte byte0)
        throws IOException
    {
        uc.write(ValueFactory.createIntegerValue(byte0 & 0xff));
    }

    void acceptUnsignedInteger(int i)
        throws IOException
    {
        if (i < 0)
        {
            long l = 0x7fffffff & i;
            uc.write(ValueFactory.createIntegerValue(l + 0x80000000L));
            return;
        } else
        {
            uc.write(ValueFactory.createIntegerValue(i));
            return;
        }
    }

    void acceptUnsignedInteger(long l)
        throws IOException
    {
        if (l < 0L)
        {
            BigInteger biginteger = BigInteger.valueOf(0x7fffffffffffffffL + l + 1L).setBit(63);
            uc.write(ValueFactory.createIntegerValue(biginteger));
            return;
        } else
        {
            uc.write(ValueFactory.createIntegerValue(l));
            return;
        }
    }

    void acceptUnsignedInteger(short word0)
        throws IOException
    {
        uc.write(ValueFactory.createIntegerValue(0xffff & word0));
    }

    void setUnconverter(Unconverter unconverter)
        throws IOException
    {
        uc = unconverter;
    }
}
