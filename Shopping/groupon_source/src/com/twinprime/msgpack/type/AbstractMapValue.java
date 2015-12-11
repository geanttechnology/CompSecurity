// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import java.util.AbstractMap;

// Referenced classes of package com.twinprime.msgpack.type:
//            MapValue, ValueType, Value

abstract class AbstractMapValue extends AbstractMap
    implements MapValue
{

    AbstractMapValue()
    {
    }

    public ValueType getType()
    {
        return ValueType.MAP;
    }

    public MapValue getValue()
    {
        return this;
    }

    public volatile Value getValue()
    {
        return getValue();
    }
}
