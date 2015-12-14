// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.ContentProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            ContentPropertiesSerializer, SimpleSerializers, DocumentPropertiesSerializer, JsonSerializer, 
//            VideoPropertiesSerializer, ImagePropertiesSerializer

static class i
{

    public void serializeFields(ContentProperties contentproperties, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("contentType");
        SimpleSerializers.serializeString(contentproperties.getContentType(), jsongenerator);
        jsongenerator.writeFieldName("extension");
        SimpleSerializers.serializeString(contentproperties.getExtension(), jsongenerator);
        jsongenerator.writeFieldName("md5");
        SimpleSerializers.serializeString(contentproperties.getMd5(), jsongenerator);
        jsongenerator.writeFieldName("document");
        DocumentPropertiesSerializer.INSTANCE.serialize(contentproperties.getDocument(), jsongenerator);
        jsongenerator.writeFieldName("video");
        VideoPropertiesSerializer.INSTANCE.serialize(contentproperties.getVideo(), jsongenerator);
        jsongenerator.writeFieldName("contentDate");
        SimpleSerializers.serializeString(contentproperties.getContentDate(), jsongenerator);
        jsongenerator.writeFieldName("size");
        SimpleSerializers.serializeLong(contentproperties.getSize(), jsongenerator);
        jsongenerator.writeFieldName("version");
        SimpleSerializers.serializeLong(contentproperties.getVersion(), jsongenerator);
        jsongenerator.writeFieldName("image");
        ImagePropertiesSerializer.INSTANCE.serialize(contentproperties.getImage(), jsongenerator);
    }

    i()
    {
    }
}
