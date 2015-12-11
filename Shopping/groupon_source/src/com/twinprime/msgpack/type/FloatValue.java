// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;


// Referenced classes of package com.twinprime.msgpack.type:
//            NumberValue, ValueType

public abstract class FloatValue extends NumberValue
{

    public FloatValue()
    {
    }

    public abstract double getDouble();

    public ValueType getType()
    {
        return ValueType.FLOAT;
    }
}
