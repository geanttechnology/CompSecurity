// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.node;


// Referenced classes of package com.fasterxml.jackson.databind.node:
//            ValueNode

public abstract class NumericNode extends ValueNode
{

    protected NumericNode()
    {
    }

    public final double asDouble(double d)
    {
        return doubleValue();
    }

    public final int asInt(int i)
    {
        return intValue();
    }

    public abstract double doubleValue();

    public abstract int intValue();
}
