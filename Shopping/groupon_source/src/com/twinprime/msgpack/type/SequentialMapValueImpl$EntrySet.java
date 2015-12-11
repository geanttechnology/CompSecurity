// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package com.twinprime.msgpack.type:
//            SequentialMapValueImpl, Value

private static class array extends AbstractSet
{

    private Value array[];

    public Iterator iterator()
    {
        return new terator(array);
    }

    public int size()
    {
        return array.length / 2;
    }

    terator(Value avalue[])
    {
        array = avalue;
    }
}
