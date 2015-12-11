// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import java.math.BigInteger;

// Referenced classes of package com.twinprime.msgpack.type:
//            ArrayValueImpl, DoubleValueImpl, IntValueImpl, LongValueImpl, 
//            BigIntegerValueImpl, SequentialMapValueImpl, NilValue, ByteArrayRawValueImpl, 
//            StringRawValueImpl, ArrayValue, Value, FloatValue, 
//            IntegerValue, MapValue, RawValue

public final class ValueFactory
{

    public static ArrayValue createArrayValue()
    {
        return ArrayValueImpl.getEmptyInstance();
    }

    public static ArrayValue createArrayValue(Value avalue[], boolean flag)
    {
        if (avalue.length == 0)
        {
            return ArrayValueImpl.getEmptyInstance();
        } else
        {
            return new ArrayValueImpl(avalue, flag);
        }
    }

    public static FloatValue createFloatValue(double d)
    {
        return new DoubleValueImpl(d);
    }

    public static IntegerValue createIntegerValue(int i)
    {
        return new IntValueImpl(i);
    }

    public static IntegerValue createIntegerValue(long l)
    {
        return new LongValueImpl(l);
    }

    public static IntegerValue createIntegerValue(BigInteger biginteger)
    {
        return new BigIntegerValueImpl(biginteger);
    }

    public static MapValue createMapValue()
    {
        return SequentialMapValueImpl.getEmptyInstance();
    }

    public static MapValue createMapValue(Value avalue[], boolean flag)
    {
        if (avalue.length == 0)
        {
            return SequentialMapValueImpl.getEmptyInstance();
        } else
        {
            return new SequentialMapValueImpl(avalue, flag);
        }
    }

    public static NilValue createNilValue()
    {
        return NilValue.getInstance();
    }

    public static RawValue createRawValue()
    {
        return ByteArrayRawValueImpl.getEmptyInstance();
    }

    public static RawValue createRawValue(String s)
    {
        return new StringRawValueImpl(s);
    }

    public static RawValue createRawValue(byte abyte0[])
    {
        return createRawValue(abyte0, false);
    }

    public static RawValue createRawValue(byte abyte0[], int i, int j)
    {
        return new ByteArrayRawValueImpl(abyte0, i, j);
    }

    public static RawValue createRawValue(byte abyte0[], boolean flag)
    {
        return new ByteArrayRawValueImpl(abyte0, flag);
    }
}
