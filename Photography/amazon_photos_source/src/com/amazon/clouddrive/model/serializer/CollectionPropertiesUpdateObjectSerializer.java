// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.CollectionPropertiesUpdateObject;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, CollectionPropertiesSerializer, SimpleSerializers

public class CollectionPropertiesUpdateObjectSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new CollectionPropertiesUpdateObjectSerializer();

    private CollectionPropertiesUpdateObjectSerializer()
    {
    }

    public final void serialize(CollectionPropertiesUpdateObject collectionpropertiesupdateobject, JsonGenerator jsongenerator)
        throws IOException
    {
        if (collectionpropertiesupdateobject == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("collectionProperties");
            CollectionPropertiesSerializer.INSTANCE.serialize(collectionpropertiesupdateobject.getCollectionProperties(), jsongenerator);
            jsongenerator.writeFieldName("op");
            SimpleSerializers.serializeString(collectionpropertiesupdateobject.getOp(), jsongenerator);
            jsongenerator.writeFieldName("path");
            SimpleSerializers.serializeString(collectionpropertiesupdateobject.getPath(), jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((CollectionPropertiesUpdateObject)obj, jsongenerator);
    }

}
