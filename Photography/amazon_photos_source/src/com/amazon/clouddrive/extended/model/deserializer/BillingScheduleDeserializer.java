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
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            PeriodDeserializer

public class BillingScheduleDeserializer
    implements JsonDeserializer
{
    static class BillingScheduleFieldDeserializer
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

        BillingScheduleFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new BillingScheduleDeserializer();
    private final BillingScheduleFieldDeserializer mFieldHandler = new BillingScheduleFieldDeserializer();

    private BillingScheduleDeserializer()
    {
    }

    public BillingSchedule deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((BillingSchedule) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        BillingSchedule billingschedule = new BillingSchedule();
        do
        {
            obj = billingschedule;
            if (jsonparser.nextToken() == JsonToken.END_OBJECT)
            {
                continue;
            }
            if (jsonparser.getCurrentToken() != JsonToken.FIELD_NAME)
            {
                throw new JsonParseException((new StringBuilder()).append("Expected field name, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
            }
            obj = jsonparser.getCurrentName();
            if (jsonparser.nextToken() == null)
            {
                throw new JsonParseException("Unexpected end of input", jsonparser.getTokenLocation());
            }
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), billingschedule))
            {
                jsonparser.skipChildren();
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object deserialize(JsonParser jsonparser)
        throws IOException
    {
        return deserialize(jsonparser);
    }

}
