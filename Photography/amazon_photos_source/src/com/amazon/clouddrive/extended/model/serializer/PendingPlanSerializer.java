// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.PendingPlan;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

public class PendingPlanSerializer
    implements JsonSerializer
{
    static class PendingPlanFieldSerializer
    {

        public void serializeFields(PendingPlan pendingplan, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeFieldName("planId");
            SimpleSerializers.serializeString(pendingplan.getPlanId(), jsongenerator);
            jsongenerator.writeFieldName("endDate");
            SimpleSerializers.serializeString(pendingplan.getEndDate(), jsongenerator);
            jsongenerator.writeFieldName("startDate");
            SimpleSerializers.serializeString(pendingplan.getStartDate(), jsongenerator);
        }

        PendingPlanFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new PendingPlanSerializer();
    private final PendingPlanFieldSerializer mFieldSerializer = new PendingPlanFieldSerializer();

    private PendingPlanSerializer()
    {
    }

    public final void serialize(PendingPlan pendingplan, JsonGenerator jsongenerator)
        throws IOException
    {
        if (pendingplan == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(pendingplan, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((PendingPlan)obj, jsongenerator);
    }

}
