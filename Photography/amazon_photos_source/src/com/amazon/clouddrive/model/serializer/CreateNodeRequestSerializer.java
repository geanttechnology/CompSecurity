// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.clouddrive.model.IEditableNode;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            JsonSerializer, SimpleSerializers

public class CreateNodeRequestSerializer
    implements JsonSerializer
{
    static class CreateNodeRequestFieldSerializer extends EditableNodeSerializer.EditableNodeFieldSerializer
    {

        public void serializeFields(IEditableNode ieditablenode, JsonGenerator jsongenerator)
            throws IOException
        {
            super.serializeFields(ieditablenode, jsongenerator);
            if (ieditablenode instanceof CreateNodeRequest)
            {
                ieditablenode = (CreateNodeRequest)ieditablenode;
                jsongenerator.writeFieldName("conflictResolution");
                SimpleSerializers.serializeString(ieditablenode.getConflictResolution(), jsongenerator);
            }
        }

        CreateNodeRequestFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new CreateNodeRequestSerializer();
    private final CreateNodeRequestFieldSerializer mFieldSerializer = new CreateNodeRequestFieldSerializer();

    private CreateNodeRequestSerializer()
    {
    }

    public final void serialize(CreateNodeRequest createnoderequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (createnoderequest == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(createnoderequest, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((CreateNodeRequest)obj, jsongenerator);
    }

}
