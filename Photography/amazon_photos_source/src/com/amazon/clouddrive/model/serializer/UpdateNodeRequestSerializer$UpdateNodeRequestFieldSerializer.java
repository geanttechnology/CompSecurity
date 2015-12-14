// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.UpdateNodeRequest;
import com.amazon.clouddrive.utils.Optional;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            UpdateNodeRequestSerializer, SimpleSerializers, LabelListSerializer, JsonSerializer, 
//            SettingsSerializer

static class i
{

    public void serializeFields(UpdateNodeRequest updatenoderequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (updatenoderequest.getName().isPresent())
        {
            jsongenerator.writeFieldName("name");
            SimpleSerializers.serializeString((String)updatenoderequest.getName().get(), jsongenerator);
        }
        if (updatenoderequest.getDescription().isPresent())
        {
            jsongenerator.writeFieldName("description");
            SimpleSerializers.serializeString((String)updatenoderequest.getDescription().get(), jsongenerator);
        }
        if (updatenoderequest.getLabels().isPresent())
        {
            jsongenerator.writeFieldName("labels");
            LabelListSerializer.INSTANCE.serialize(updatenoderequest.getLabels().get(), jsongenerator);
        }
        if (updatenoderequest.getSettings().isPresent())
        {
            jsongenerator.writeFieldName("settings");
            SettingsSerializer.INSTANCE.serialize(updatenoderequest.getSettings().get(), jsongenerator);
        }
    }

    i()
    {
    }
}
