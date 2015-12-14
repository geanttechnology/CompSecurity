// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.BillingSchedule;
import com.amazon.clouddrive.extended.model.Period;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            BillingScheduleDeserializer, PeriodDeserializer

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, BillingSchedule billingschedule)
        throws IOException
    {
        if ("billingPeriod".equals(s))
        {
            billingschedule.setBillingPeriod((Period)PeriodDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        }
        if ("currencyCode".equals(s))
        {
            billingschedule.setCurrencyCode(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("price".equals(s))
        {
            billingschedule.setPrice(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (BillingSchedule)obj);
    }

    ()
    {
    }
}
