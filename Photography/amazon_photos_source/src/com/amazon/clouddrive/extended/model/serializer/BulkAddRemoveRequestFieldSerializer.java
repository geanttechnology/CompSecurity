// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.BulkAddRemoveRequest;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.NodeIdListSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

class BulkAddRemoveRequestFieldSerializer
{

    BulkAddRemoveRequestFieldSerializer()
    {
    }

    public void serializeFields(BulkAddRemoveRequest bulkaddremoverequest, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("value");
        NodeIdListSerializer.INSTANCE.serialize(bulkaddremoverequest.getNodeIds(), jsongenerator);
        jsongenerator.writeFieldName("op");
        SimpleSerializers.serializeString(bulkaddremoverequest.getOp(), jsongenerator);
        jsongenerator.writeFieldName("resourceVersion");
        SimpleSerializers.serializeString(bulkaddremoverequest.getResourceVersion(), jsongenerator);
    }
}
