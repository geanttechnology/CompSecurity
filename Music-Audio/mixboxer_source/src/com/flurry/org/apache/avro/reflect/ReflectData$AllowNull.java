// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.reflect;

import com.flurry.org.apache.avro.Schema;
import java.lang.reflect.Field;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.reflect:
//            ReflectData

public static class  extends ReflectData
{

    private static final dSchema INSTANCE = new <init>();

    public static  get()
    {
        return INSTANCE;
    }

    protected Schema createFieldSchema(Field field, Map map)
    {
        return makeNullable(super.createFieldSchema(field, map));
    }


    public ()
    {
    }
}
