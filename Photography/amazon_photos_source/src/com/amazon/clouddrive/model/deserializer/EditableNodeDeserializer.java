// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.EditableNode;
import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.Settings;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, JsonFieldDeserializer, SimpleDeserializers, NodeIdListDeserializer, 
//            ContentPropertiesDeserializer, PropertiesDeserializer, LabelListDeserializer, CollectionPropertiesDeserializer, 
//            KindObjectIdListMapDeserializer, SettingsDeserializer, TransformListDeserializer

public class EditableNodeDeserializer
    implements JsonDeserializer
{
    static class EditableNodeFieldDeserializer
        implements JsonFieldDeserializer
    {

        public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
            throws IOException
        {
            if ("name".equals(s))
            {
                ieditablenode.setName(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("description".equals(s))
            {
                ieditablenode.setDescription(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("parents".equals(s))
            {
                ieditablenode.setParents((List)NodeIdListDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("id".equals(s))
            {
                ieditablenode.setId(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("contentProperties".equals(s))
            {
                ieditablenode.setContentProperties((ContentProperties)ContentPropertiesDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("properties".equals(s))
            {
                ieditablenode.setProperties((Map)PropertiesDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("kind".equals(s))
            {
                ieditablenode.setKind(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("labels".equals(s))
            {
                ieditablenode.setLabels((List)LabelListDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("status".equals(s))
            {
                ieditablenode.setStatus(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("collectionProperties".equals(s))
            {
                ieditablenode.setCollectionProperties((CollectionProperties)CollectionPropertiesDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("parentMap".equals(s))
            {
                ieditablenode.setParentMap((Map)KindObjectIdListMapDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("settings".equals(s))
            {
                ieditablenode.setSettings((Settings)SettingsDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("transforms".equals(s))
            {
                ieditablenode.setTransforms((List)TransformListDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            } else
            {
                return false;
            }
        }

        public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
            throws IOException
        {
            return handleField(jsonparser, s, (IEditableNode)obj);
        }

        EditableNodeFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new EditableNodeDeserializer();
    private final EditableNodeFieldDeserializer mFieldHandler = new EditableNodeFieldDeserializer();

    private EditableNodeDeserializer()
    {
    }

    public EditableNode deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((EditableNode) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        EditableNode editablenode = new EditableNode();
        do
        {
            obj = editablenode;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), editablenode))
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
