// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.BillingSchedule;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            BillingScheduleSerializer, PeriodSerializer

static class 
{

    public void serializeFields(BillingSchedule billingschedule, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("billingPeriod");
        PeriodSerializer.INSTANCE.serialize(billingschedule.getBillingPeriod(), jsongenerator);
        jsongenerator.writeFieldName("currencyCode");
        SimpleSerializers.serializeString(billingschedule.getCurrencyCode(), jsongenerator);
        jsongenerator.writeFieldName("price");
        SimpleSerializers.serializeString(billingschedule.getPrice(), jsongenerator);
    }

    ()
    {
    }
}
