// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.NodeExtended;
import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class NodeExtendedDeserializer
    implements JsonDeserializer
{
    static class NodeExtendedFieldDeserializer extends com.amazon.clouddrive.model.deserializer.NodeDeserializer.NodeFieldDeserializer
    {

        public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
            throws IOException
        {
            if (super.handleField(jsonparser, s, ieditablenode))
            {
                return true;
            }
            if (ieditablenode instanceof NodeExtended)
            {
                if ("restricted".equals(s))
                {
                    ((NodeExtended)ieditablenode).setRestricted(SimpleDeserializers.deserializeBoolean(jsonparser));
                    return true;
                }
                if ("shareId".equals(s))
                {
                    ((NodeExtended)ieditablenode).setShareId(SimpleDeserializers.deserializeString(jsonparser));
                    return true;
                }
                if ("shareURL".equals(s))
                {
                    ((NodeExtended)ieditablenode).setShareURL(SimpleDeserializers.deserializeString(jsonparser));
                    return true;
                }
            }
            return false;
        }

        public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
            throws IOException
        {
            return handleField(jsonparser, s, (IEditableNode)obj);
        }

        NodeExtendedFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new NodeExtendedDeserializer();
    private final NodeExtendedFieldDeserializer mFieldHandler = new NodeExtendedFieldDeserializer();

    private NodeExtendedDeserializer()
    {
    }

    public NodeExtended deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((NodeExtended) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        NodeExtended nodeextended = new NodeExtended();
        do
        {
            obj = nodeextended;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), nodeextended))
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
