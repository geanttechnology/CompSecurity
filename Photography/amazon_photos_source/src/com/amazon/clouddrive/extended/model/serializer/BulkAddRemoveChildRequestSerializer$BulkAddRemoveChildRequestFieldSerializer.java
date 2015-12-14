// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.BulkAddRemoveChildRequest;
import com.amazon.clouddrive.extended.model.BulkAddRemoveRequest;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            BulkAddRemoveRequestFieldSerializer, BulkAddRemoveChildRequestSerializer

static class  extends BulkAddRemoveRequestFieldSerializer
{

    public void serializeFields(BulkAddRemoveRequest bulkaddremoverequest, JsonGenerator jsongenerator)
        throws IOException
    {
        super.serializeFields(bulkaddremoverequest, jsongenerator);
        if (bulkaddremoverequest instanceof BulkAddRemoveChildRequest)
        {
            bulkaddremoverequest = (BulkAddRemoveChildRequest)bulkaddremoverequest;
            jsongenerator.writeFieldName("parentId");
            SimpleSerializers.serializeString(bulkaddremoverequest.getParentId(), jsongenerator);
        }
    }

    ()
    {
    }
}
