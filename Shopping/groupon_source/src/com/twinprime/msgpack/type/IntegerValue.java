// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;


// Referenced classes of package com.twinprime.msgpack.type:
//            NumberValue, ValueType

public abstract class IntegerValue extends NumberValue
{

    public IntegerValue()
    {
    }

    public abstract int getInt();

    public abstract long getLong();

    public ValueType getType()
    {
        return ValueType.INTEGER;
    }
}
