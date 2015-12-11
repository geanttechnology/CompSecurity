// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.KeyDeserializer;
import com.fasterxml.jackson.databind.deser.KeyDeserializers;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class StdKeyDeserializers
    implements KeyDeserializers, Serializable
{

    private static final long serialVersionUID = 0xcd01b6e7cfbcee7L;

    public StdKeyDeserializers()
    {
    }

    public static KeyDeserializer constructDelegatingKeyDeserializer(DeserializationConfig deserializationconfig, JavaType javatype, JsonDeserializer jsondeserializer)
    {
        return new StdKeyDeserializer.DelegatingKD(javatype.getRawClass(), jsondeserializer);
    }

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumresolver)
    {
        return new StdKeyDeserializer.EnumKD(enumresolver, null);
    }

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumresolver, AnnotatedMethod annotatedmethod)
    {
        return new StdKeyDeserializer.EnumKD(enumresolver, annotatedmethod);
    }

    public static KeyDeserializer constructStringKeyDeserializer(DeserializationConfig deserializationconfig, JavaType javatype)
    {
        return StdKeyDeserializer.StringKD.forType(javatype.getRawClass());
    }

    public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig deserializationconfig, JavaType javatype)
    {
        javatype = deserializationconfig.introspect(javatype);
        java.lang.reflect.Constructor constructor = javatype.findSingleArgConstructor(new Class[] {
            java/lang/String
        });
        if (constructor != null)
        {
            if (deserializationconfig.canOverrideAccessModifiers())
            {
                ClassUtil.checkAndFixAccess(constructor);
            }
            return new StdKeyDeserializer.StringCtorKeyDeserializer(constructor);
        }
        javatype = javatype.findFactoryMethod(new Class[] {
            java/lang/String
        });
        if (javatype != null)
        {
            if (deserializationconfig.canOverrideAccessModifiers())
            {
                ClassUtil.checkAndFixAccess(javatype);
            }
            return new StdKeyDeserializer.StringFactoryKeyDeserializer(javatype);
        } else
        {
            return null;
        }
    }

    public KeyDeserializer findKeyDeserializer(JavaType javatype, DeserializationConfig deserializationconfig, BeanDescription beandescription)
        throws JsonMappingException
    {
        deserializationconfig = javatype.getRawClass();
        if (deserializationconfig == java/lang/String || deserializationconfig == java/lang/Object)
        {
            return StdKeyDeserializer.StringKD.forType(deserializationconfig);
        }
        if (deserializationconfig == java/util/UUID)
        {
            return new StdKeyDeserializer.UuidKD();
        }
        javatype = deserializationconfig;
        if (deserializationconfig.isPrimitive())
        {
            javatype = ClassUtil.wrapperType(deserializationconfig);
        }
        if (javatype == java/lang/Integer)
        {
            return new StdKeyDeserializer.IntKD();
        }
        if (javatype == java/lang/Long)
        {
            return new StdKeyDeserializer.LongKD();
        }
        if (javatype == java/util/Date)
        {
            return new StdKeyDeserializer.DateKD();
        }
        if (javatype == java/util/Calendar)
        {
            return new StdKeyDeserializer.CalendarKD();
        }
        if (javatype == java/lang/Boolean)
        {
            return new StdKeyDeserializer.BoolKD();
        }
        if (javatype == java/lang/Byte)
        {
            return new StdKeyDeserializer.ByteKD();
        }
        if (javatype == java/lang/Character)
        {
            return new StdKeyDeserializer.CharKD();
        }
        if (javatype == java/lang/Short)
        {
            return new StdKeyDeserializer.ShortKD();
        }
        if (javatype == java/lang/Float)
        {
            return new StdKeyDeserializer.FloatKD();
        }
        if (javatype == java/lang/Double)
        {
            return new StdKeyDeserializer.DoubleKD();
        }
        if (javatype == java/util/Locale)
        {
            return new StdKeyDeserializer.LocaleKD();
        } else
        {
            return null;
        }
    }
}
