// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.BulkTrashRestoreNodesRequest;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            BulkAddRemoveRequestFieldSerializer

public class BulkTrashRestoreNodesRequestSerializer
    implements JsonSerializer
{

    public static final JsonSerializer INSTANCE = new BulkTrashRestoreNodesRequestSerializer();
    private BulkAddRemoveRequestFieldSerializer mFieldSerializer;

    private BulkTrashRestoreNodesRequestSerializer()
    {
        mFieldSerializer = new BulkAddRemoveRequestFieldSerializer();
    }

    public void serialize(BulkTrashRestoreNodesRequest bulktrashrestorenodesrequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (bulktrashrestorenodesrequest == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(bulktrashrestorenodesrequest, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((BulkTrashRestoreNodesRequest)obj, jsongenerator);
    }

}
