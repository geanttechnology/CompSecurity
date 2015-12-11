// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.MessageTypeException;
import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;
import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.type:
//            IntegerValue, Value, ValueType

class BigIntegerValueImpl extends IntegerValue
{

    private static BigInteger BYTE_MAX = BigInteger.valueOf(127L);
    private static BigInteger BYTE_MIN = BigInteger.valueOf(-128L);
    private static BigInteger INT_MAX = BigInteger.valueOf(0x7fffffffL);
    private static BigInteger INT_MIN = BigInteger.valueOf(0xffffffff80000000L);
    private static BigInteger LONG_MAX = BigInteger.valueOf(0x7fffffffffffffffL);
    private static BigInteger LONG_MIN = BigInteger.valueOf(0x8000000000000000L);
    private static BigInteger SHORT_MAX = BigInteger.valueOf(32767L);
    private static BigInteger SHORT_MIN = BigInteger.valueOf(-32768L);
    private BigInteger value;

    BigIntegerValueImpl(BigInteger biginteger)
    {
        value = biginteger;
    }

    public BigInteger bigIntegerValue()
    {
        return value;
    }

    public byte byteValue()
    {
        return value.byteValue();
    }

    public double doubleValue()
    {
        return value.doubleValue();
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj instanceof Value)
            {
                obj = (Value)obj;
                flag = flag1;
                if (((Value) (obj)).getType() == ValueType.INTEGER)
                {
                    return value.equals(((IntegerValue)(IntegerValue)((Value) (obj)).getValue()).bigIntegerValue());
                }
            }
        }
        return flag;
    }

    public float floatValue()
    {
        return value.floatValue();
    }

    public int getInt()
    {
        if (value.compareTo(INT_MAX) > 0 || value.compareTo(INT_MIN) < 0)
        {
            throw new MessageTypeException();
        } else
        {
            return value.intValue();
        }
    }

    public long getLong()
    {
        if (value.compareTo(LONG_MAX) > 0 || value.compareTo(LONG_MIN) < 0)
        {
            throw new MessageTypeException();
        } else
        {
            return value.longValue();
        }
    }

    public IntegerValue getValue()
    {
        return this;
    }

    public volatile Value getValue()
    {
        return getValue();
    }

    public int hashCode()
    {
        if (INT_MIN.compareTo(value) <= 0 && value.compareTo(INT_MAX) <= 0)
        {
            return (int)value.longValue();
        }
        if (LONG_MIN.compareTo(value) <= 0 && value.compareTo(LONG_MAX) <= 0)
        {
            long l = value.longValue();
            return (int)(l >>> 32 ^ l);
        } else
        {
            return value.hashCode();
        }
    }

    public int intValue()
    {
        return value.intValue();
    }

    public long longValue()
    {
        return value.longValue();
    }

    public short shortValue()
    {
        return value.shortValue();
    }

    public String toString()
    {
        return value.toString();
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        return stringbuilder.append(value.toString());
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.write(value);
    }

}
