// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.IEditableNode;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            EditableNodeSerializer, SimpleSerializers, NodeIdListSerializer, JsonSerializer, 
//            ContentPropertiesSerializer, PropertiesSerializer, LabelListSerializer, CollectionPropertiesSerializer, 
//            KindObjectIdListMapSerializer, SettingsSerializer, TransformListSerializer

public static class 
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

    public ()
    {
    }
}
