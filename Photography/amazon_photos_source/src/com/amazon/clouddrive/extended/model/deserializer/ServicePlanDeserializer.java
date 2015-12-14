// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.BillingSchedule;
import com.amazon.clouddrive.extended.model.Period;
import com.amazon.clouddrive.extended.model.ServicePlan;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            StorageMapDeserializer, BillingScheduleDeserializer, PeriodDeserializer

public class ServicePlanDeserializer
    implements JsonDeserializer
{
    static class ServicePlanFieldDeserializer
        implements JsonFieldDeserializer
    {

        public boolean handleField(JsonParser jsonparser, String s, ServicePlan serviceplan)
            throws IOException
        {
            if ("planType".equals(s))
            {
                serviceplan.setPlanType(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("planId".equals(s))
            {
                serviceplan.setPlanId(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("renewable".equals(s))
            {
                serviceplan.setRenewable(SimpleDeserializers.deserializePrimitiveBoolean(jsonparser));
                return true;
            }
            if ("planDescription".equals(s))
            {
                serviceplan.setPlanDescription(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("storageMap".equals(s))
            {
                serviceplan.setStorageMap((Map)StorageMapDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("isPromotion".equals(s))
            {
                serviceplan.setPromotion(SimpleDeserializers.deserializePrimitiveBoolean(jsonparser));
                return true;
            }
            if ("marketplaceId".equals(s))
            {
                serviceplan.setMarketplaceId(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("billingSchedule".equals(s))
            {
                serviceplan.setBillingSchedule((BillingSchedule)BillingScheduleDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("priceAttribute".equals(s))
            {
                serviceplan.setPriceAttribute(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("available".equals(s))
            {
                serviceplan.setAvailable(SimpleDeserializers.deserializePrimitiveBoolean(jsonparser));
                return true;
            }
            if ("contractLength".equals(s))
            {
                serviceplan.setContractLength((Period)PeriodDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            }
            if ("planGroupId".equals(s))
            {
                serviceplan.setPlanGroupId(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            } else
            {
                return false;
            }
        }

        public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
            throws IOException
        {
            return handleField(jsonparser, s, (ServicePlan)obj);
        }

        ServicePlanFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new ServicePlanDeserializer();
    private final ServicePlanFieldDeserializer mFieldHandler = new ServicePlanFieldDeserializer();

    private ServicePlanDeserializer()
    {
    }

    public ServicePlan deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ServicePlan) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        ServicePlan serviceplan = new ServicePlan();
        do
        {
            obj = serviceplan;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), serviceplan))
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
