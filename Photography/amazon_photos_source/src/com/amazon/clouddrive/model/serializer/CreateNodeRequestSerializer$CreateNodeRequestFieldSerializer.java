// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.serializer;

import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.clouddrive.model.IEditableNode;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.model.serializer:
//            CreateNodeRequestSerializer, SimpleSerializers

static class i extends i
{

    public void serializeFields(IEditableNode ieditablenode, JsonGenerator jsongenerator)
        throws IOException
    {
        super.ields(ieditablenode, jsongenerator);
        if (ieditablenode instanceof CreateNodeRequest)
        {
            ieditablenode = (CreateNodeRequest)ieditablenode;
            jsongenerator.writeFieldName("conflictResolution");
            SimpleSerializers.serializeString(ieditablenode.getConflictResolution(), jsongenerator);
        }
    }

    i()
    {
    }
}
