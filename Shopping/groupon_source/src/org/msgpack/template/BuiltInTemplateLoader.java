// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.template;


// Referenced classes of package org.msgpack.template:
//            AnyTemplate, BigIntegerTemplate, BooleanArrayTemplate, BooleanTemplate, 
//            ByteArrayTemplate, ByteBufferTemplate, ByteTemplate, DoubleArrayTemplate, 
//            DoubleTemplate, FloatArrayTemplate, FloatTemplate, IntArrayTemplate, 
//            IntegerTemplate, LongArrayTemplate, LongTemplate, ShortArrayTemplate, 
//            ShortTemplate, StringTemplate, CollectionTemplate, ListTemplate, 
//            MapTemplate, NullableTemplate

public class BuiltInTemplateLoader
{

    public static void load()
    {
        AnyTemplate.getInstance();
        BigIntegerTemplate.getInstance();
        BooleanArrayTemplate.getInstance();
        BooleanTemplate.getInstance();
        ByteArrayTemplate.getInstance();
        ByteBufferTemplate.getInstance();
        ByteTemplate.getInstance();
        DoubleArrayTemplate.getInstance();
        DoubleTemplate.getInstance();
        FloatArrayTemplate.getInstance();
        FloatTemplate.getInstance();
        IntArrayTemplate.getInstance();
        IntegerTemplate.getInstance();
        LongArrayTemplate.getInstance();
        LongTemplate.getInstance();
        ShortArrayTemplate.getInstance();
        ShortTemplate.getInstance();
        StringTemplate.getInstance();
        CollectionTemplate.load();
        ListTemplate.load();
        MapTemplate.load();
        NullableTemplate.load();
    }
}
