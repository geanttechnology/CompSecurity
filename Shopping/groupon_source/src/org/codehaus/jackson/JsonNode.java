// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.codehaus.jackson:
//            JsonToken

public abstract class JsonNode
    implements Iterable
{

    protected static final List NO_NODES = Collections.emptyList();
    protected static final List NO_STRINGS = Collections.emptyList();

    protected JsonNode()
    {
    }

    public abstract String asText();

    public abstract JsonToken asToken();

    public abstract boolean equals(Object obj);

    public JsonNode get(String s)
    {
        return null;
    }

    public BigInteger getBigIntegerValue()
    {
        return BigInteger.ZERO;
    }

    public byte[] getBinaryValue()
        throws IOException
    {
        return null;
    }

    public BigDecimal getDecimalValue()
    {
        return BigDecimal.ZERO;
    }

    public double getDoubleValue()
    {
        return 0.0D;
    }

    public Iterator getElements()
    {
        return NO_NODES.iterator();
    }

    public Iterator getFields()
    {
        return Collections.emptyList().iterator();
    }

    public int getIntValue()
    {
        return 0;
    }

    public long getLongValue()
    {
        return 0L;
    }

    public abstract JsonParser.NumberType getNumberType();

    public Number getNumberValue()
    {
        return null;
    }

    public String getTextValue()
    {
        return null;
    }

    public boolean isArray()
    {
        return false;
    }

    public boolean isBinary()
    {
        return false;
    }

    public boolean isNumber()
    {
        return false;
    }

    public boolean isObject()
    {
        return false;
    }

    public boolean isPojo()
    {
        return false;
    }

    public final Iterator iterator()
    {
        return getElements();
    }

    public int size()
    {
        return 0;
    }

    public abstract String toString();

}
