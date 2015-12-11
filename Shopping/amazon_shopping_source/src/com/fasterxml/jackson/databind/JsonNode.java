// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.core.TreeNode;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class JsonNode
    implements TreeNode, Iterable
{

    protected static final List NO_NODES = Collections.emptyList();
    protected static final List NO_STRINGS = Collections.emptyList();

    protected JsonNode()
    {
    }

    public double asDouble(double d)
    {
        return d;
    }

    public int asInt(int i)
    {
        return i;
    }

    public abstract String asText();

    public double doubleValue()
    {
        return 0.0D;
    }

    public Iterator elements()
    {
        return NO_NODES.iterator();
    }

    public abstract boolean equals(Object obj);

    public JsonNode get(String s)
    {
        return null;
    }

    public int intValue()
    {
        return 0;
    }

    public final Iterator iterator()
    {
        return elements();
    }

    public abstract JsonNode path(String s);

    public int size()
    {
        return 0;
    }

    public abstract String toString();

}
