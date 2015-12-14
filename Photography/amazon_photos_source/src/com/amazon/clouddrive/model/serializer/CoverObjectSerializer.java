// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.CoverObject;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers

public class CoverObjectSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new CoverObjectSerializer();

    private CoverObjectSerializer()
    {
    }

    public final void serialize(CoverObject coverobject, JsonGenerator jsongenerator)
        throws IOException
    {
        if (coverobject == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("id");
            SimpleSerializers.serializeString(coverobject.getId(), jsongenerator);
            jsongenerator.writeFieldName("tempLink");
            SimpleSerializers.serializeString(coverobject.getTempLink(), jsongenerator);
            jsongenerator.writeFieldName("isDefault");
            SimpleSerializers.serializeBoolean(coverobject.isDefault(), jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((CoverObject)obj, jsongenerator);
    }

}
