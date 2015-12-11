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

public final class DecimalNode extends NumericNode
{

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
            if (obj != null)
            {
                flag = flag1;
                if (obj.getClass() == getClass())
                {
                    return ((DecimalNode)obj)._value.equals(_value);
                }
            }
        }
        return flag;
    }

    public BigInteger getBigIntegerValue()
    {
        return _value.toBigInteger();
    }

    public BigDecimal getDecimalValue()
    {
        return _value;
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
        return com.flurry.org.codehaus.jackson.JsonParser.NumberType.BIG_DECIMAL;
    }

    public Number getNumberValue()
    {
        return _value;
    }

    public int hashCode()
    {
        return _value.hashCode();
    }

    public boolean isBigDecimal()
    {
        return true;
    }

    public boolean isFloatingPointNumber()
    {
        return true;
    }

    public final void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeNumber(_value);
    }
}
