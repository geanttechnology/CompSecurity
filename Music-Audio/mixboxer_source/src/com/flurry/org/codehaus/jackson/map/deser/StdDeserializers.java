// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser;

import com.flurry.org.codehaus.jackson.map.deser.std.AtomicBooleanDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.CalendarDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.ClassDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.DateDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.FromStringDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.JavaTypeDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.StringDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.TimestampDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.TokenBufferDeserializer;
import com.flurry.org.codehaus.jackson.map.deser.std.UntypedObjectDeserializer;
import com.flurry.org.codehaus.jackson.map.type.ClassKey;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

class StdDeserializers
{

    final HashMap _deserializers = new HashMap();

    private StdDeserializers()
    {
        add(new UntypedObjectDeserializer());
        StringDeserializer stringdeserializer = new StringDeserializer();
        add(stringdeserializer, java/lang/String);
        add(stringdeserializer, java/lang/CharSequence);
        add(new ClassDeserializer());
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.BooleanDeserializer(java/lang/Boolean, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.ByteDeserializer(java/lang/Byte, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.ShortDeserializer(java/lang/Short, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.CharacterDeserializer(java/lang/Character, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.IntegerDeserializer(java/lang/Integer, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.LongDeserializer(java/lang/Long, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.FloatDeserializer(java/lang/Float, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.DoubleDeserializer(java/lang/Double, null));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.BooleanDeserializer(Boolean.TYPE, Boolean.FALSE));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.ByteDeserializer(Byte.TYPE, Byte.valueOf((byte)0)));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.ShortDeserializer(Short.TYPE, Short.valueOf((short)0)));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.CharacterDeserializer(Character.TYPE, Character.valueOf('\0')));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.IntegerDeserializer(Integer.TYPE, Integer.valueOf(0)));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.LongDeserializer(Long.TYPE, Long.valueOf(0L)));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.FloatDeserializer(Float.TYPE, Float.valueOf(0.0F)));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.DoubleDeserializer(Double.TYPE, Double.valueOf(0.0D)));
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.NumberDeserializer());
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.BigDecimalDeserializer());
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.BigIntegerDeserializer());
        add(new CalendarDeserializer());
        add(new DateDeserializer());
        add(new CalendarDeserializer(java/util/GregorianCalendar), java/util/GregorianCalendar);
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.SqlDateDeserializer());
        add(new TimestampDeserializer());
        for (Iterator iterator = FromStringDeserializer.all().iterator(); iterator.hasNext(); add((FromStringDeserializer)iterator.next())) { }
        add(new com.flurry.org.codehaus.jackson.map.deser.std.StdDeserializer.StackTraceElementDeserializer());
        add(new AtomicBooleanDeserializer());
        add(new TokenBufferDeserializer());
        add(new JavaTypeDeserializer());
    }

    private void add(StdDeserializer stddeserializer)
    {
        add(stddeserializer, stddeserializer.getValueClass());
    }

    private void add(StdDeserializer stddeserializer, Class class1)
    {
        _deserializers.put(new ClassKey(class1), stddeserializer);
    }

    public static HashMap constructAll()
    {
        return (new StdDeserializers())._deserializers;
    }
}
