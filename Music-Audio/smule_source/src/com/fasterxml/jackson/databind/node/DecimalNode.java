// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package com.fasterxml.jackson.databind.node:
//            NumericNode

public class DecimalNode extends NumericNode
{

    private static final BigDecimal MAX_INTEGER = BigDecimal.valueOf(0x7fffffffL);
    private static final BigDecimal MAX_LONG = BigDecimal.valueOf(0x7fffffffffffffffL);
    private static final BigDecimal MIN_INTEGER = BigDecimal.valueOf(0xffffffff80000000L);
    private static final BigDecimal MIN_LONG = BigDecimal.valueOf(0x8000000000000000L);
    public static final DecimalNode ZERO;
    protected final BigDecimal _value;

    public DecimalNode(BigDecimal bigdecimal)
    {
        _value = bigdecimal;
    }

    public static DecimalNode valueOf(BigDecimal bigdecimal)
    {
        return new DecimalNode(bigdecimal);
    }

    public String asText()
    {
        return _value.toString();
    }

    public JsonToken asToken()
    {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public BigInteger bigIntegerValue()
    {
        return _value.toBigInteger();
    }

    public BigDecimal decimalValue()
    {
        return _value;
    }

    public double doubleValue()
    {
        return _value.doubleValue();
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj instanceof DecimalNode)
            {
                if (((DecimalNode)obj)._value.compareTo(_value) != 0)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public float floatValue()
    {
        return _value.floatValue();
    }

    public int hashCode()
    {
        return Double.valueOf(doubleValue()).hashCode();
    }

    public int intValue()
    {
        return _value.intValue();
    }

    public long longValue()
    {
        return _value.longValue();
    }

    public com.fasterxml.jackson.core.JsonParser.NumberType numberType()
    {
        return com.fasterxml.jackson.core.JsonParser.NumberType.BIG_DECIMAL;
    }

    public Number numberValue()
    {
        return _value;
    }

    public final void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
    {
        jsongenerator.writeNumber(_value);
    }

    static 
    {
        ZERO = new DecimalNode(BigDecimal.ZERO);
    }
}
