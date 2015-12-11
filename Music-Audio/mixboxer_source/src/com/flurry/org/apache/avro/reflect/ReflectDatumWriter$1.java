// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.reflect;

import java.lang.reflect.Array;
import java.util.Iterator;

// Referenced classes of package com.flurry.org.apache.avro.reflect:
//            ReflectDatumWriter

class val.array
    implements Iterator
{

    private int i;
    private final int length;
    final ReflectDatumWriter this$0;
    final Object val$array;

    public boolean hasNext()
    {
        return i < length;
    }

    public Object next()
    {
        Object obj = val$array;
        int j = i;
        i = j + 1;
        return Array.get(obj, j);
    }

    public void remove()
    {
        throw new UnsupportedOperationException();
    }

    ()
    {
        this$0 = final_reflectdatumwriter;
        val$array = Object.this;
        super();
        i = 0;
        length = Array.getLength(val$array);
    }
}
