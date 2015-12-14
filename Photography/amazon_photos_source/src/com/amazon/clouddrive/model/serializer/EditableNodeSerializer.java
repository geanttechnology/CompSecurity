// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.EditableNode;
import com.amazon.clouddrive.model.IEditableNode;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers, NodeIdListSerializer, ContentPropertiesSerializer, 
//            PropertiesSerializer, LabelListSerializer, CollectionPropertiesSerializer, KindObjectIdListMapSerializer, 
//            SettingsSerializer, TransformListSerializer

public class EditableNodeSerializer
    implements JsonSerializer
{
    public static class EditableNodeFieldSerializer
    {

        public void serializeFields(IEditableNode ieditablenode, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeFieldName("name");
            SimpleSerializers.serializeString(ieditablenode.getName(), jsongenerator);
            jsongenerator.writeFieldName("description");
            SimpleSerializers.serializeString(ieditablenode.getDescription(), jsongenerator);
            jsongenerator.writeFieldName("parents");
            NodeIdListSerializer.INSTANCE.serialize(ieditablenode.getParents(), jsongenerator);
            jsongenerator.writeFieldName("id");
            SimpleSerializers.serializeString(ieditablenode.getId(), jsongenerator);
            jsongenerator.writeFieldName("contentProperties");
            ContentPropertiesSerializer.INSTANCE.serialize(ieditablenode.getContentProperties(), jsongenerator);
            jsongenerator.writeFieldName("properties");
            PropertiesSerializer.INSTANCE.serialize(ieditablenode.getProperties(), jsongenerator);
            jsongenerator.writeFieldName("kind");
            SimpleSerializers.serializeString(ieditablenode.getKind(), jsongenerator);
            jsongenerator.writeFieldName("labels");
            LabelListSerializer.INSTANCE.serialize(ieditablenode.getLabels(), jsongenerator);
            jsongenerator.writeFieldName("status");
            SimpleSerializers.serializeString(ieditablenode.getStatus(), jsongenerator);
            jsongenerator.writeFieldName("collectionProperties");
            CollectionPropertiesSerializer.INSTANCE.serialize(ieditablenode.getCollectionProperties(), jsongenerator);
            jsongenerator.writeFieldName("parentMap");
            KindObjectIdListMapSerializer.INSTANCE.serialize(ieditablenode.getParentMap(), jsongenerator);
            jsongenerator.writeFieldName("settings");
            SettingsSerializer.INSTANCE.serialize(ieditablenode.getSettings(), jsongenerator);
            jsongenerator.writeFieldName("transforms");
            TransformListSerializer.INSTANCE.serialize(ieditablenode.getTransforms(), jsongenerator);
        }

        public EditableNodeFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new EditableNodeSerializer();
    private final EditableNodeFieldSerializer mFiledSerializer = new EditableNodeFieldSerializer();

    private EditableNodeSerializer()
    {
    }

    public final void serialize(EditableNode editablenode, JsonGenerator jsongenerator)
        throws IOException
    {
        if (editablenode == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFiledSerializer.serializeFields(editablenode, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((EditableNode)obj, jsongenerator);
    }

}
