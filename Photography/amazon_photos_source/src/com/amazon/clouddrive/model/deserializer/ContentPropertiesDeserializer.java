// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.DocumentProperties;
import com.amazon.clouddrive.model.ImageProperties;
import com.amazon.clouddrive.model.VideoProperties;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, JsonFieldDeserializer, SimpleDeserializers, DocumentPropertiesDeserializer, 
//            VideoPropertiesDeserializer, ImagePropertiesDeserializer

public class ContentPropertiesDeserializer
    implements JsonDeserializer
{
    static class ContentPropertiesFieldDeserializer
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

        ContentPropertiesFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new ContentPropertiesDeserializer();
    private final ContentPropertiesFieldDeserializer mFieldHandler = new ContentPropertiesFieldDeserializer();

    private ContentPropertiesDeserializer()
    {
    }

    public ContentProperties deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ContentProperties) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        ContentProperties contentproperties = new ContentProperties();
        do
        {
            obj = contentproperties;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), contentproperties))
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
