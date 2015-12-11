// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package com.flurry.org.codehaus.jackson.node:
//            NumericNode

public final class BigIntegerNode extends NumericNode
{

    protected final BigInteger _value;

    public BigIntegerNode(BigInteger biginteger)
    {
        _value = biginteger;
    }

    public static BigIntegerNode valueOf(BigInteger biginteger)
    {
        return new BigIntegerNode(biginteger);
    }

    public boolean asBoolean(boolean flag)
    {
        return !BigInteger.ZERO.equals(_value);
    }

    public String asText()
    {
        return _value.toString();
    }

    public JsonToken asToken()
    {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (obj == null)
            {
                return false;
            }
            if (obj.getClass() != getClass())
            {
                return false;
            }
            if (((BigIntegerNode)obj)._value != _value)
            {
                return false;
            }
        }
        return true;
    }

    public BigInteger getBigIntegerValue()
    {
        return _value;
    }

    public BigDecimal getDecimalValue()
    {
        return new BigDecimal(_value);
    }

    public double getDoubleValue()
    {
        return _value.doubleValue();
    }

    public int getIntValue()
    {
        return _value.intValue();
    }

    public long getLongValue()
    {
        return _value.longValue();
    }

    public com.flurry.org.codehaus.jackson.JsonParser.NumberType getNumberType()
    {
        return com.flurry.org.codehaus.jackson.JsonParser.NumberType.BIG_INTEGER;
    }

    public Number getNumberValue()
    {
        return _value;
    }

    public int hashCode()
    {
        return _value.hashCode();
    }

    public boolean isBigInteger()
    {
        return true;
    }

    public boolean isIntegralNumber()
    {
        return true;
    }

    public final void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeNumber(_value);
    }
}
