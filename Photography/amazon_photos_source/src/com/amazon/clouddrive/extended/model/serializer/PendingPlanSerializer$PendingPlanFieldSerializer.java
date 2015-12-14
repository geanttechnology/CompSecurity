// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.PendingPlan;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            PendingPlanSerializer

static class 
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

    ()
    {
    }
}
