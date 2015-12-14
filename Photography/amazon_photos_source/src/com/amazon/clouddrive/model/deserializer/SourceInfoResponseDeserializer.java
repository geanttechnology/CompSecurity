// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.BaseDeviceInfo;
import com.amazon.clouddrive.model.SourceInfoResponse;
import com.amazon.clouddrive.model.SourceStatus;
import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, MediaTypeUsageMapDeserializer, BaseDeviceInfoDeserializer, SourceStatusDeserializer, 
//            SimpleDeserializers, VersionHistoryMapDeserializer

public class SourceInfoResponseDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new SourceInfoResponseDeserializer();

    private SourceInfoResponseDeserializer()
    {
    }

    public SourceInfoResponse deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((SourceInfoResponse) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        SourceInfoResponse sourceinforesponse = new SourceInfoResponse();
        do
        {
            obj = sourceinforesponse;
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
            if ("sourceUsage".equals(obj))
            {
                sourceinforesponse.setSourceUsage((Map)MediaTypeUsageMapDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            if ("device".equals(obj))
            {
                sourceinforesponse.setDevice((BaseDeviceInfo)BaseDeviceInfoDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            if ("sourceStatus".equals(obj))
            {
                sourceinforesponse.setSourceStatus((SourceStatus)SourceStatusDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            if ("lastModifiedTime".equals(obj))
            {
                sourceinforesponse.setLastModifiedTime(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("sourceApplicationName".equals(obj))
            {
                sourceinforesponse.setSourceApplicationName(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("creationTime".equals(obj))
            {
                sourceinforesponse.setCreationTime(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("sourceId".equals(obj))
            {
                sourceinforesponse.setSourceId(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("sourceVersionHistory".equals(obj))
            {
                sourceinforesponse.setSourceVersionHistory((Map)VersionHistoryMapDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            if ("lastSeenTime".equals(obj))
            {
                sourceinforesponse.setLastSeenTime(SimpleDeserializers.deserializeString(jsonparser));
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
