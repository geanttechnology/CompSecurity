// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ext;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;
import java.lang.reflect.Type;
import org.joda.time.LocalDate;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ext:
//            JodaSerializers

public static final class > extends >
{

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        if (serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.TES_AS_TIMESTAMPS))
        {
            serializerprovider = "array";
        } else
        {
            serializerprovider = "string";
        }
        return createSchemaNode(serializerprovider, true);
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((LocalDate)obj, jsongenerator, serializerprovider);
    }

    public void serialize(LocalDate localdate, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.TES_AS_TIMESTAMPS))
        {
            jsongenerator.writeStartArray();
            jsongenerator.writeNumber(localdate.year().eNumber());
            jsongenerator.writeNumber(localdate.monthOfYear().eNumber());
            jsongenerator.writeNumber(localdate.dayOfMonth().eNumber());
            jsongenerator.writeEndArray();
            return;
        } else
        {
            jsongenerator.writeString(printLocalDate(localdate));
            return;
        }
    }

    public Q()
    {
        super(org/joda/time/LocalDate);
    }
}
