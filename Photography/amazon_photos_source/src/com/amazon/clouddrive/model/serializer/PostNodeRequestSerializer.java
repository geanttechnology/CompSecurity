// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.PostNodeRequest;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers

public class PostNodeRequestSerializer
    implements JsonSerializer
{
    static class PostNodeRequestFieldSerializer extends EditableNodeSerializer.EditableNodeFieldSerializer
    {

        public void serializeFields(IEditableNode ieditablenode, JsonGenerator jsongenerator)
            throws IOException
        {
            super.serializeFields(ieditablenode, jsongenerator);
            if (ieditablenode instanceof PostNodeRequest)
            {
                ieditablenode = (PostNodeRequest)ieditablenode;
                jsongenerator.writeFieldName("conflictResolution");
                SimpleSerializers.serializeString(ieditablenode.getConflictResolution(), jsongenerator);
            }
        }

        PostNodeRequestFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new PostNodeRequestSerializer();
    private final PostNodeRequestFieldSerializer mFieldSerializer = new PostNodeRequestFieldSerializer();

    private PostNodeRequestSerializer()
    {
    }

    public final void serialize(PostNodeRequest postnoderequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (postnoderequest == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(postnoderequest, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((PostNodeRequest)obj, jsongenerator);
    }

}
