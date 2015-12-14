// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.DocumentProperties;
import com.amazon.clouddrive.model.ImageProperties;
import com.amazon.clouddrive.model.VideoProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, ContentPropertiesDeserializer, SimpleDeserializers, DocumentPropertiesDeserializer, 
//            JsonDeserializer, VideoPropertiesDeserializer, ImagePropertiesDeserializer

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, ContentProperties contentproperties)
        throws IOException
    {
        if ("contentType".equals(s))
        {
            contentproperties.setContentType(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("extension".equals(s))
        {
            contentproperties.setExtension(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("md5".equals(s))
        {
            contentproperties.setMd5(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("document".equals(s))
        {
            contentproperties.setDocument((DocumentProperties)DocumentPropertiesDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        }
        if ("video".equals(s))
        {
            contentproperties.setVideo((VideoProperties)VideoPropertiesDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        }
        if ("contentDate".equals(s))
        {
            contentproperties.setContentDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("size".equals(s))
        {
            contentproperties.setSize(SimpleDeserializers.deserializeLong(jsonparser));
            return true;
        }
        if ("version".equals(s))
        {
            contentproperties.setVersion(SimpleDeserializers.deserializeLong(jsonparser));
            return true;
        }
        if ("image".equals(s))
        {
            contentproperties.setImage((ImageProperties)ImagePropertiesDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (ContentProperties)obj);
    }

    ()
    {
    }
}
