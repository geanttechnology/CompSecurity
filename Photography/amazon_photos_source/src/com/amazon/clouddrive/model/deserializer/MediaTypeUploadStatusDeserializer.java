// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.MediaTypeUploadStatus;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, SimpleDeserializers

public class MediaTypeUploadStatusDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new MediaTypeUploadStatusDeserializer();

    private MediaTypeUploadStatusDeserializer()
    {
    }

    public MediaTypeUploadStatus deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((MediaTypeUploadStatus) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        MediaTypeUploadStatus mediatypeuploadstatus = new MediaTypeUploadStatus();
        do
        {
            obj = mediatypeuploadstatus;
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
            if ("uploadQueueSize".equals(obj))
            {
                mediatypeuploadstatus.setUploadQueueSize(SimpleDeserializers.deserializePrimitiveLong(jsonparser));
            } else
            if ("isAutoSaveActive".equals(obj))
            {
                mediatypeuploadstatus.setIsAutoSaveActive(SimpleDeserializers.deserializePrimitiveBoolean(jsonparser));
            } else
            if ("backlogSize".equals(obj))
            {
                mediatypeuploadstatus.setBacklogSize(SimpleDeserializers.deserializePrimitiveLong(jsonparser));
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
