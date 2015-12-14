// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.BulkAddRemoveChildRequest;
import com.amazon.clouddrive.extended.model.BulkAddRemoveRequest;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            BulkAddRemoveRequestFieldSerializer

public class BulkAddRemoveChildRequestSerializer
    implements JsonSerializer
{
    static class BulkAddRemoveChildRequestFieldSerializer extends BulkAddRemoveRequestFieldSerializer
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

        BulkAddRemoveChildRequestFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new BulkAddRemoveChildRequestSerializer();
    private final BulkAddRemoveChildRequestFieldSerializer mFieldSerializer = new BulkAddRemoveChildRequestFieldSerializer();

    private BulkAddRemoveChildRequestSerializer()
    {
    }

    public void serialize(BulkAddRemoveChildRequest bulkaddremovechildrequest, JsonGenerator jsongenerator)
        throws IOException
    {
        if (bulkaddremovechildrequest == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(bulkaddremovechildrequest, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((BulkAddRemoveChildRequest)obj, jsongenerator);
    }

}
