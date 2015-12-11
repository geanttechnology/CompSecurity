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

class LongValueImpl extends IntegerValue
{

    private static long BYTE_MAX = 127L;
    private static long BYTE_MIN = -128L;
    private static long INT_MAX = 0x7fffffffL;
    private static long INT_MIN = 0xffffffff80000000L;
    private static long SHORT_MAX = 32767L;
    private static long SHORT_MIN = -32768L;
    private long value;

    LongValueImpl(long l)
    {
        value = l;
    }

    public BigInteger bigIntegerValue()
    {
        return BigInteger.valueOf(value);
    }

    public byte byteValue()
    {
        return (byte)(int)value;
    }

    public double doubleValue()
    {
        return (double)value;
    }

    public boolean equals(Object obj)
    {
        boolean flag2 = false;
        boolean flag;
        if (obj == this)
        {
            flag = true;
        } else
        {
            flag = flag2;
            if (obj instanceof Value)
            {
                obj = (Value)obj;
                flag = flag2;
                if (((Value) (obj)).getType() == ValueType.INTEGER)
                {
                    long l;
                    long l1;
                    boolean flag1;
                    try
                    {
                        l = value;
                        l1 = ((IntegerValue)((Value) (obj)).getValue()).getLong();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        return false;
                    }
                    if (l == l1)
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    return flag1;
                }
            }
        }
        return flag;
    }

    public float floatValue()
    {
        return (float)value;
    }

    public int getInt()
    {
        if (value > INT_MAX || value < INT_MIN)
        {
            throw new MessageTypeException();
        } else
        {
            return (int)value;
        }
    }

    public long getLong()
    {
        return value;
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
        if (INT_MIN <= value && value <= INT_MAX)
        {
            return (int)value;
        } else
        {
            return (int)(value ^ value >>> 32);
        }
    }

    public int intValue()
    {
        return (int)value;
    }

    public long longValue()
    {
        return value;
    }

    public short shortValue()
    {
        return (short)(int)value;
    }

    public String toString()
    {
        return Long.toString(value);
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        return stringbuilder.append(Long.toString(value));
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.write(value);
    }

}
