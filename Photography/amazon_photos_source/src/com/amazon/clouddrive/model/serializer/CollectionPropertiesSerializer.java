// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.CollectionProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, QueryObjectSerializer, SimpleSerializers, CoverObjectListSerializer

public class CollectionPropertiesSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new CollectionPropertiesSerializer();

    private CollectionPropertiesSerializer()
    {
    }

    public final void serialize(CollectionProperties collectionproperties, JsonGenerator jsongenerator)
        throws IOException
    {
        if (collectionproperties == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("query");
            QueryObjectSerializer.INSTANCE.serialize(collectionproperties.getQuery(), jsongenerator);
            jsongenerator.writeFieldName("areCoversDesired");
            SimpleSerializers.serializeBoolean(collectionproperties.areCoversDesired(), jsongenerator);
            jsongenerator.writeFieldName("covers");
            CoverObjectListSerializer.INSTANCE.serialize(collectionproperties.getCovers(), jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((CollectionProperties)obj, jsongenerator);
    }

}
