// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.CloudDriveSubscription;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

// Referenced classes of package com.amazon.clouddrive.extended.model.serializer:
//            CloudDriveSubscriptionSerializer, PendingPlanSerializer, SubscriptionProblemListSerializer

static class 
{

    public void serializeFields(CloudDriveSubscription clouddrivesubscription, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeFieldName("baseCurrencyCode");
        SimpleSerializers.serializeString(clouddrivesubscription.getBaseCurrencyCode(), jsongenerator);
        jsongenerator.writeFieldName("autoRenewEnabled");
        SimpleSerializers.serializeBoolean(clouddrivesubscription.isAutoRenewEnabled(), jsongenerator);
        jsongenerator.writeFieldName("currentContractPeriod");
        SimpleSerializers.serializeLong(clouddrivesubscription.getCurrentContractPeriod(), jsongenerator);
        jsongenerator.writeFieldName("subscriptionId");
        SimpleSerializers.serializeString(clouddrivesubscription.getSubscriptionId(), jsongenerator);
        jsongenerator.writeFieldName("subscriptionStartDate");
        SimpleSerializers.serializeString(clouddrivesubscription.getSubscriptionStartDate(), jsongenerator);
        jsongenerator.writeFieldName("marketplaceId");
        SimpleSerializers.serializeString(clouddrivesubscription.getMarketplaceId(), jsongenerator);
        jsongenerator.writeFieldName("pendingPlan");
        PendingPlanSerializer.INSTANCE.serialize(clouddrivesubscription.getPendingPlan(), jsongenerator);
        jsongenerator.writeFieldName("expectedStatusEndDate");
        SimpleSerializers.serializeString(clouddrivesubscription.getExpectedStatusEndDate(), jsongenerator);
        jsongenerator.writeFieldName("subscriptionProblemsList");
        SubscriptionProblemListSerializer.INSTANCE.serialize(clouddrivesubscription.getSubscriptionProblemsList(), jsongenerator);
        jsongenerator.writeFieldName("planId");
        SimpleSerializers.serializeString(clouddrivesubscription.getPlanId(), jsongenerator);
        jsongenerator.writeFieldName("preferredPaymentPlanId");
        SimpleSerializers.serializeString(clouddrivesubscription.getPreferredPaymentPlanId(), jsongenerator);
        jsongenerator.writeFieldName("gracePeriodBeforeCancellation");
        SimpleSerializers.serializeLong(clouddrivesubscription.getGracePeriodBeforeCancellation(), jsongenerator);
        jsongenerator.writeFieldName("currentBillingPeriod");
        SimpleSerializers.serializeLong(clouddrivesubscription.getCurrentBillingPeriod(), jsongenerator);
        jsongenerator.writeFieldName("nextBillDate");
        SimpleSerializers.serializeString(clouddrivesubscription.getNextBillDate(), jsongenerator);
        jsongenerator.writeFieldName("nextBillAmount");
        SimpleSerializers.serializeString(clouddrivesubscription.getNextBillAmount(), jsongenerator);
        jsongenerator.writeFieldName("contractEndDate");
        SimpleSerializers.serializeString(clouddrivesubscription.getContractEndDate(), jsongenerator);
        jsongenerator.writeFieldName("subscriptionStatus");
        SimpleSerializers.serializeString(clouddrivesubscription.getSubscriptionStatus(), jsongenerator);
        jsongenerator.writeFieldName("hasOpenProblems");
        SimpleSerializers.serializeBoolean(clouddrivesubscription.isHasOpenProblems(), jsongenerator);
        jsongenerator.writeFieldName("statusStartDate");
        SimpleSerializers.serializeString(clouddrivesubscription.getStatusStartDate(), jsongenerator);
    }

    ()
    {
    }
}
