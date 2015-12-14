// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.SetupSourceRequest;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers

public class SetupSourceRequestSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new SetupSourceRequestSerializer();

    private SetupSourceRequestSerializer()
    {
    }

    public final void serialize(SetupSourceRequest setupsourcerequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (setupsourcerequest == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("sourceVersion");
            SimpleSerializers.serializeString(setupsourcerequest.getSourceVersion(), jsongenerator);
            jsongenerator.writeFieldName("deviceFriendlyName");
            SimpleSerializers.serializeString(setupsourcerequest.getDeviceFriendlyName(), jsongenerator);
            jsongenerator.writeFieldName("deviceSerialNumber");
            SimpleSerializers.serializeString(setupsourcerequest.getDeviceSerialNumber(), jsongenerator);
            jsongenerator.writeFieldName("osVersion");
            SimpleSerializers.serializeString(setupsourcerequest.getOsVersion(), jsongenerator);
            jsongenerator.writeFieldName("deviceModel");
            SimpleSerializers.serializeString(setupsourcerequest.getDeviceModel(), jsongenerator);
            jsongenerator.writeFieldName("deviceClass");
            SimpleSerializers.serializeString(setupsourcerequest.getDeviceClass(), jsongenerator);
            jsongenerator.writeFieldName("devicePlatform");
            SimpleSerializers.serializeString(setupsourcerequest.getDevicePlatform(), jsongenerator);
            jsongenerator.writeFieldName("sourceApplicationName");
            SimpleSerializers.serializeString(setupsourcerequest.getSourceApplicationName(), jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((SetupSourceRequest)obj, jsongenerator);
    }

}
