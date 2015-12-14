// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.ServicePlan;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            ServicePlanSerializer, StorageMapSerializer, BillingScheduleSerializer, PeriodSerializer

static class 
{

    public void serializeFields(ServicePlan serviceplan, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("planType");
        SimpleSerializers.serializeString(serviceplan.getPlanType(), jsongenerator);
        jsongenerator.writeFieldName("planId");
        SimpleSerializers.serializeString(serviceplan.getPlanId(), jsongenerator);
        jsongenerator.writeFieldName("renewable");
        SimpleSerializers.serializePrimitiveBoolean(serviceplan.isRenewable(), jsongenerator);
        jsongenerator.writeFieldName("planDescription");
        SimpleSerializers.serializeString(serviceplan.getPlanDescription(), jsongenerator);
        jsongenerator.writeFieldName("storageMap");
        StorageMapSerializer.INSTANCE.serialize(serviceplan.getStorageMap(), jsongenerator);
        jsongenerator.writeFieldName("isPromotion");
        SimpleSerializers.serializePrimitiveBoolean(serviceplan.isPromotion(), jsongenerator);
        jsongenerator.writeFieldName("marketplaceId");
        SimpleSerializers.serializeString(serviceplan.getMarketplaceId(), jsongenerator);
        jsongenerator.writeFieldName("billingSchedule");
        BillingScheduleSerializer.INSTANCE.serialize(serviceplan.getBillingSchedule(), jsongenerator);
        jsongenerator.writeFieldName("priceAttribute");
        SimpleSerializers.serializeString(serviceplan.getPriceAttribute(), jsongenerator);
        jsongenerator.writeFieldName("available");
        SimpleSerializers.serializePrimitiveBoolean(serviceplan.isAvailable(), jsongenerator);
        jsongenerator.writeFieldName("contractLength");
        PeriodSerializer.INSTANCE.serialize(serviceplan.getContractLength(), jsongenerator);
        jsongenerator.writeFieldName("planGroupId");
        SimpleSerializers.serializeString(serviceplan.getPlanGroupId(), jsongenerator);
    }

    ()
    {
    }
}
