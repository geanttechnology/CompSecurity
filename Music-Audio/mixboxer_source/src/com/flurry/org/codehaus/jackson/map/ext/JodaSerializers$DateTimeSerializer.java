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
import org.joda.time.DateTime;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ext:
//            JodaSerializers

public static final class t> extends t>
{

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        if (serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.ATES_AS_TIMESTAMPS))
        {
            serializerprovider = "number";
        } else
        {
            serializerprovider = "string";
        }
        return createSchemaNode(serializerprovider, true);
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((DateTime)obj, jsongenerator, serializerprovider);
    }

    public void serialize(DateTime datetime, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.ATES_AS_TIMESTAMPS))
        {
            jsongenerator.writeNumber(datetime.getMillis());
            return;
        } else
        {
            jsongenerator.writeString(datetime.toString());
            return;
        }
    }

    public ()
    {
        super(org/joda/time/DateTime);
    }
}
