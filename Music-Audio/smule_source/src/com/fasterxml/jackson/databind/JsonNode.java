// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.util.EmptyIterator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class JsonNode
    implements TreeNode, Iterable
{

    protected JsonNode()
    {
    }

    public boolean asBoolean()
    {
        return asBoolean(false);
    }

    public boolean asBoolean(boolean flag)
    {
        return flag;
    }

    public double asDouble()
    {
        return asDouble(0.0D);
    }

    public double asDouble(double d)
    {
        return d;
    }

    public int asInt()
    {
        return asInt(0);
    }

    public int asInt(int i)
    {
        return i;
    }

    public long asLong()
    {
        return asLong(0L);
    }

    public long asLong(long l)
    {
        return l;
    }

    public abstract String asText();

    public String asText(String s)
    {
        String s1 = asText();
        if (s1 == null)
        {
            return s;
        } else
        {
            return s1;
        }
    }

    public BigInteger bigIntegerValue()
    {
        return BigInteger.ZERO;
    }

    public byte[] binaryValue()
    {
        return null;
    }

    public boolean booleanValue()
    {
        return false;
    }

    public BigDecimal decimalValue()
    {
        return BigDecimal.ZERO;
    }

    public abstract JsonNode deepCopy();

    public double doubleValue()
    {
        return 0.0D;
    }

    public Iterator elements()
    {
        return EmptyIterator.instance();
    }

    public Iterator fields()
    {
        return EmptyIterator.instance();
    }

    public final List findParents(String s)
    {
        List list = findParents(s, null);
        s = list;
        if (list == null)
        {
            s = Collections.emptyList();
        }
        return s;
    }

    public abstract List findParents(String s, List list);

    public float floatValue()
    {
        return 0.0F;
    }

    public JsonNode get(String s)
    {
        return null;
    }

    public abstract JsonNodeType getNodeType();

    public boolean has(String s)
    {
        return get(s) != null;
    }

    public int intValue()
    {
        return 0;
    }

    public final boolean isArray()
    {
        return getNodeType() == JsonNodeType.ARRAY;
    }

    public final boolean isBinary()
    {
        return getNodeType() == JsonNodeType.BINARY;
    }

    public final boolean isContainerNode()
    {
        JsonNodeType jsonnodetype = getNodeType();
        return jsonnodetype == JsonNodeType.OBJECT || jsonnodetype == JsonNodeType.ARRAY;
    }

    public final boolean isNumber()
    {
        return getNodeType() == JsonNodeType.NUMBER;
    }

    public final boolean isObject()
    {
        return getNodeType() == JsonNodeType.OBJECT;
    }

    public final boolean isPojo()
    {
        return getNodeType() == JsonNodeType.POJO;
    }

    public final boolean isTextual()
    {
        return getNodeType() == JsonNodeType.STRING;
    }

    public final boolean isValueNode()
    {
        class _cls1
        {

            static final int $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[];

            static 
            {
                $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType = new int[JsonNodeType.values().length];
                try
                {
                    $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.ARRAY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.OBJECT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$fasterxml$jackson$databind$node$JsonNodeType[JsonNodeType.MISSING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.fasterxml.jackson.databind.node.JsonNodeType[getNodeType().ordinal()])
        {
        default:
            return true;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return false;
        }
    }

    public final Iterator iterator()
    {
        return elements();
    }

    public long longValue()
    {
        return 0L;
    }

    public Number numberValue()
    {
        return null;
    }

    public int size()
    {
        return 0;
    }

    public String textValue()
    {
        return null;
    }

    public abstract String toString();
}
