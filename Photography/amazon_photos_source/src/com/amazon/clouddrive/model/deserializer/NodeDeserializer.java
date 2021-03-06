// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.INode;
import com.amazon.clouddrive.model.Node;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, SimpleDeserializers, AssetsDeserializer

public class NodeDeserializer
    implements JsonDeserializer
{
    public static class NodeFieldDeserializer extends EditableNodeDeserializer.EditableNodeFieldDeserializer
    {

        public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
            throws IOException
        {
            if (super.handleField(jsonparser, s, ieditablenode))
            {
                return true;
            }
            if (ieditablenode instanceof INode)
            {
                if ("version".equals(s))
                {
                    ((INode)ieditablenode).setVersion(SimpleDeserializers.deserializePrimitiveLong(jsonparser));
                    return true;
                }
                if ("eTagResponse".equals(s))
                {
                    ((INode)ieditablenode).setETagResponse(SimpleDeserializers.deserializeString(jsonparser));
                    return true;
                }
                if ("assets".equals(s))
                {
                    ((INode)ieditablenode).setAssets((List)AssetsDeserializer.INSTANCE.deserialize(jsonparser));
                    return true;
                }
                if ("isShared".equals(s))
                {
                    ((INode)ieditablenode).setIsShared(SimpleDeserializers.deserializeBoolean(jsonparser));
                    return true;
                }
                if ("isRoot".equals(s))
                {
                    ((INode)ieditablenode).setIsRoot(SimpleDeserializers.deserializeBoolean(jsonparser));
                    return true;
                }
                if ("eTagRequest".equals(s))
                {
                    ((INode)ieditablenode).setETagRequest(SimpleDeserializers.deserializeString(jsonparser));
                    return true;
                }
                if ("exclusivelyTrashed".equals(s))
                {
                    ((INode)ieditablenode).setExclusivelyTrashed(SimpleDeserializers.deserializeBoolean(jsonparser));
                    return true;
                }
                if ("createdDate".equals(s))
                {
                    ((INode)ieditablenode).setCreatedDate(SimpleDeserializers.deserializeString(jsonparser));
                    return true;
                }
                if ("recursivelyTrashed".equals(s))
                {
                    ((INode)ieditablenode).setRecursivelyTrashed(SimpleDeserializers.deserializeBoolean(jsonparser));
                    return true;
                }
                if ("modifiedDate".equals(s))
                {
                    ((INode)ieditablenode).setModifiedDate(SimpleDeserializers.deserializeString(jsonparser));
                    return true;
                }
                if ("createdBy".equals(s))
                {
                    ((INode)ieditablenode).setCreatedBy(SimpleDeserializers.deserializeString(jsonparser));
                    return true;
                }
                if ("tempLink".equals(s))
                {
                    ((INode)ieditablenode).setTempLink(SimpleDeserializers.deserializeString(jsonparser));
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

        public NodeFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new NodeDeserializer();
    private final NodeFieldDeserializer mFieldHandler = new NodeFieldDeserializer();

    private NodeDeserializer()
    {
    }

    public Node deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((Node) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        Node node = new Node();
        do
        {
            obj = node;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), node))
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
