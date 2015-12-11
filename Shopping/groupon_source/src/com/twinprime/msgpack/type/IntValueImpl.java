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

class IntValueImpl extends IntegerValue
{

    private static int BYTE_MAX = 127;
    private static int BYTE_MIN = -128;
    private static int SHORT_MAX = 32767;
    private static int SHORT_MIN = -32768;
    private int value;

    IntValueImpl(int i)
    {
        value = i;
    }

    public BigInteger bigIntegerValue()
    {
        return BigInteger.valueOf(value);
    }

    public byte byteValue()
    {
        return (byte)value;
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
                    int i;
                    int j;
                    boolean flag1;
                    try
                    {
                        i = value;
                        j = ((IntegerValue)((Value) (obj)).getValue()).getInt();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        return false;
                    }
                    if (i == j)
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
        return value;
    }

    public long getLong()
    {
        return (long)value;
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
        return value;
    }

    public int intValue()
    {
        return value;
    }

    public long longValue()
    {
        return (long)value;
    }

    public short shortValue()
    {
        return (short)value;
    }

    public String toString()
    {
        return Integer.toString(value);
    }

    public StringBuilder toString(StringBuilder stringbuilder)
    {
        return stringbuilder.append(Integer.toString(value));
    }

    public void writeTo(Packer packer)
        throws IOException
    {
        packer.write(value);
    }

}
