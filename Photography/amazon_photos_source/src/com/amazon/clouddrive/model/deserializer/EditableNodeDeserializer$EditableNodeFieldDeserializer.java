// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.ContentProperties;
import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.Settings;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, EditableNodeDeserializer, SimpleDeserializers, NodeIdListDeserializer, 
//            JsonDeserializer, ContentPropertiesDeserializer, PropertiesDeserializer, LabelListDeserializer, 
//            CollectionPropertiesDeserializer, KindObjectIdListMapDeserializer, SettingsDeserializer, TransformListDeserializer

static class 
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

    ()
    {
    }
}
