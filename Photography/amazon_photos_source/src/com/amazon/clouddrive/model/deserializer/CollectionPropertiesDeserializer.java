// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.QueryObject;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, QueryObjectDeserializer, SimpleDeserializers, CoverObjectListDeserializer

public class CollectionPropertiesDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new CollectionPropertiesDeserializer();

    private CollectionPropertiesDeserializer()
    {
    }

    public CollectionProperties deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((CollectionProperties) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        CollectionProperties collectionproperties = new CollectionProperties();
        do
        {
            obj = collectionproperties;
            if (jsonparser.nextToken() == JsonToken.END_OBJECT)
            {
                continue;
            }
            if (jsonparser.getCurrentToken() != JsonToken.FIELD_NAME)
            {
                throw new JsonParseException((new StringBuilder()).append("Expected field name, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
            }
            obj = jsonparser.getCurrentName();
            if (jsonparser.nextToken() == null)
            {
                throw new JsonParseException("Unexpected end of input", jsonparser.getTokenLocation());
            }
            if ("query".equals(obj))
            {
                collectionproperties.setQuery((QueryObject)QueryObjectDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            if ("areCoversDesired".equals(obj))
            {
                collectionproperties.setCoversDesired(SimpleDeserializers.deserializeBoolean(jsonparser));
            } else
            if ("covers".equals(obj))
            {
                collectionproperties.setCovers((List)CoverObjectListDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            {
                jsonparser.skipChildren();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object deserialize(JsonParser jsonparser)
        throws IOException
    {
        return deserialize(jsonparser);
    }

}
