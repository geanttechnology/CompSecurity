// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.UpdateCollectionPropertiesRequest;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers, CollectionPropertiesUpdateObjectListSerializer

public class UpdateCollectionPropertiesRequestSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new UpdateCollectionPropertiesRequestSerializer();

    private UpdateCollectionPropertiesRequestSerializer()
    {
    }

    public final void serialize(UpdateCollectionPropertiesRequest updatecollectionpropertiesrequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (updatecollectionpropertiesrequest == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("id");
            SimpleSerializers.serializeString(updatecollectionpropertiesrequest.getId(), jsongenerator);
            jsongenerator.writeFieldName("operations");
            CollectionPropertiesUpdateObjectListSerializer.INSTANCE.serialize(updatecollectionpropertiesrequest.getOperations(), jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((UpdateCollectionPropertiesRequest)obj, jsongenerator);
    }

}
