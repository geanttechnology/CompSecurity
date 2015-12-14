// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.Settings;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers

public class SettingsSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new SettingsSerializer();

    private SettingsSerializer()
    {
    }

    public final void serialize(Settings settings, JsonGenerator jsongenerator)
        throws IOException
    {
        if (settings == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            jsongenerator.writeFieldName("favorite");
            SimpleSerializers.serializeBoolean(settings.isFavorite(), jsongenerator);
            jsongenerator.writeFieldName("hidden");
            SimpleSerializers.serializeBoolean(settings.isHidden(), jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((Settings)obj, jsongenerator);
    }

}
