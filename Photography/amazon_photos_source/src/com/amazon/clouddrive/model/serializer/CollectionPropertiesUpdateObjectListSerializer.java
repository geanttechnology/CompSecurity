// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.CollectionPropertiesUpdateObject;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, CollectionPropertiesUpdateObjectSerializer

public class CollectionPropertiesUpdateObjectListSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new CollectionPropertiesUpdateObjectListSerializer();

    private CollectionPropertiesUpdateObjectListSerializer()
    {
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((List)obj, jsongenerator);
    }

    public void serialize(List list, JsonGenerator jsongenerator)
        throws IOException
    {
        if (list == null)
        {
            jsongenerator.writeNull();
            return;
        }
        jsongenerator.writeStartArray();
        CollectionPropertiesUpdateObject collectionpropertiesupdateobject;
        for (list = list.iterator(); list.hasNext(); CollectionPropertiesUpdateObjectSerializer.INSTANCE.serialize(collectionpropertiesupdateobject, jsongenerator))
        {
            collectionpropertiesupdateobject = (CollectionPropertiesUpdateObject)list.next();
        }

        jsongenerator.writeEndArray();
    }

}
