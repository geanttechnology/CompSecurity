// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.ContentProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers, DocumentPropertiesSerializer, VideoPropertiesSerializer, 
//            ImagePropertiesSerializer

public class ContentPropertiesSerializer
    implements JsonSerializer
{
    static class ContentPropertiesFieldSerializer
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

        ContentPropertiesFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new ContentPropertiesSerializer();
    private final ContentPropertiesFieldSerializer mFieldSerializer = new ContentPropertiesFieldSerializer();

    private ContentPropertiesSerializer()
    {
    }

    public final void serialize(ContentProperties contentproperties, JsonGenerator jsongenerator)
        throws IOException
    {
        if (contentproperties == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(contentproperties, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((ContentProperties)obj, jsongenerator);
    }

}
