// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.ser.std;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.util.EnumValues;

// Referenced classes of package org.codehaus.jackson.map.ser.std:
//            ScalarSerializerBase

public class EnumSerializer extends ScalarSerializerBase
{

    protected final EnumValues _values;

    public EnumSerializer(EnumValues enumvalues)
    {
        super(java/lang/Enum, false);
        _values = enumvalues;
    }

    public static EnumSerializer construct(Class class1, SerializationConfig serializationconfig, BasicBeanDescription basicbeandescription)
    {
        basicbeandescription = serializationconfig.getAnnotationIntrospector();
        if (serializationconfig.isEnabled(org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING))
        {
            class1 = EnumValues.constructFromToString(class1, basicbeandescription);
        } else
        {
            class1 = EnumValues.constructFromName(class1, basicbeandescription);
        }
        return new EnumSerializer(class1);
    }

    public EnumValues getEnumValues()
    {
        return _values;
    }

    public final void serialize(Enum enum, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (serializerprovider.isEnabled(org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_ENUMS_USING_INDEX))
        {
            jsongenerator.writeNumber(enum.ordinal());
            return;
        } else
        {
            jsongenerator.writeString(_values.serializedValueFor(enum));
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((Enum)obj, jsongenerator, serializerprovider);
    }
}
