// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.BaseDeviceInfo;
import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, SimpleDeserializers, VersionHistoryMapDeserializer

public class BaseDeviceInfoDeserializer
    implements JsonDeserializer
{

    public static final JsonDeserializer INSTANCE = new BaseDeviceInfoDeserializer();

    private BaseDeviceInfoDeserializer()
    {
    }

    public BaseDeviceInfo deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((BaseDeviceInfo) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        BaseDeviceInfo basedeviceinfo = new BaseDeviceInfo();
        do
        {
            obj = basedeviceinfo;
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
            if ("deviceModel".equals(obj))
            {
                basedeviceinfo.setDeviceModel(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("creationTime".equals(obj))
            {
                basedeviceinfo.setCreationTime(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("deviceId".equals(obj))
            {
                basedeviceinfo.setDeviceId(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("deviceStatus".equals(obj))
            {
                basedeviceinfo.setDeviceStatus(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("devicePlatform".equals(obj))
            {
                basedeviceinfo.setDevicePlatform(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("deviceClass".equals(obj))
            {
                basedeviceinfo.setDeviceClass(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("osVersionHistory".equals(obj))
            {
                basedeviceinfo.setOsVersionHistory((Map)VersionHistoryMapDeserializer.INSTANCE.deserialize(jsonparser));
            } else
            if ("deviceFriendlyName".equals(obj))
            {
                basedeviceinfo.setDeviceFriendlyName(SimpleDeserializers.deserializeString(jsonparser));
            } else
            if ("lastModifiedTime".equals(obj))
            {
                basedeviceinfo.setLastModifiedTime(SimpleDeserializers.deserializeString(jsonparser));
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
