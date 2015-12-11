// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.type:
//            FloatValue, Value, ValueType

class DoubleValueImpl extends FloatValue
{

    private double value;

    DoubleValueImpl(double d)
    {
        value = d;
    }

    public BigInteger bigIntegerValue()
    {
        return (new BigDecimal(value)).toBigInteger();
    }

    public byte byteValue()
    {
        return (byte)(int)value;
    }

    public double doubleValue()
    {
        return value;
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
                if (((Value) (obj)).getType() == ValueType.FLOAT)
                {
                    boolean flag1;
                    if (value == ((FloatValue)((Value) (obj)).getValue()).getDouble())
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

    public double getDouble()
    {
        return value;
    }

    public FloatValue getValue()
    {
        return this;
    }

    public volatile Value getValue()
    {
        return getValue();
    }

    public int hashCode()
    {
        long l = Double.doubleToLongBits(value);
        return (int)(l >>> 32 ^ l);
    }

    public int intValue()
    {
        return (int)value;
    }

    public long longValue()
    {
        return (long)value;
    }

    public short shortValue()
    {
        return (short)(int)value;
    }

    public String toString()
    {
        return Double.toString(value);
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        return stringbuilder.append(Double.toString(value));
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.write(value);
    }
}
