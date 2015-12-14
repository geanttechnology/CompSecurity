// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.CloudDriveSubscription;
import com.amazon.clouddrive.extended.model.PendingPlan;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            CloudDriveSubscriptionDeserializer, PendingPlanDeserializer, SubscriptionProblemListDeserializer

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, CloudDriveSubscription clouddrivesubscription)
        throws IOException
    {
        if ("baseCurrencyCode".equals(s))
        {
            clouddrivesubscription.setBaseCurrencyCode(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("autoRenewEnabled".equals(s))
        {
            clouddrivesubscription.setAutoRenewEnabled(SimpleDeserializers.deserializeBoolean(jsonparser));
            return true;
        }
        if ("currentContractPeriod".equals(s))
        {
            clouddrivesubscription.setCurrentContractPeriod(SimpleDeserializers.deserializeLong(jsonparser));
            return true;
        }
        if ("subscriptionId".equals(s))
        {
            clouddrivesubscription.setSubscriptionId(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("subscriptionStartDate".equals(s))
        {
            clouddrivesubscription.setSubscriptionStartDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("marketplaceId".equals(s))
        {
            clouddrivesubscription.setMarketplaceId(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("pendingPlan".equals(s))
        {
            clouddrivesubscription.setPendingPlan((PendingPlan)PendingPlanDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        }
        if ("expectedStatusEndDate".equals(s))
        {
            clouddrivesubscription.setExpectedStatusEndDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("subscriptionProblemsList".equals(s))
        {
            clouddrivesubscription.setSubscriptionProblemsList((List)SubscriptionProblemListDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        }
        if ("planId".equals(s))
        {
            clouddrivesubscription.setPlanId(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("preferredPaymentPlanId".equals(s))
        {
            clouddrivesubscription.setPreferredPaymentPlanId(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("gracePeriodBeforeCancellation".equals(s))
        {
            clouddrivesubscription.setGracePeriodBeforeCancellation(SimpleDeserializers.deserializeLong(jsonparser));
            return true;
        }
        if ("currentBillingPeriod".equals(s))
        {
            clouddrivesubscription.setCurrentBillingPeriod(SimpleDeserializers.deserializeLong(jsonparser));
            return true;
        }
        if ("nextBillDate".equals(s))
        {
            clouddrivesubscription.setNextBillDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("nextBillAmount".equals(s))
        {
            clouddrivesubscription.setNextBillAmount(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("contractEndDate".equals(s))
        {
            clouddrivesubscription.setContractEndDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("subscriptionStatus".equals(s))
        {
            clouddrivesubscription.setSubscriptionStatus(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("hasOpenProblems".equals(s))
        {
            clouddrivesubscription.setHasOpenProblems(SimpleDeserializers.deserializeBoolean(jsonparser));
            return true;
        }
        if ("statusStartDate".equals(s))
        {
            clouddrivesubscription.setStatusStartDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (CloudDriveSubscription)obj);
    }

    ()
    {
    }
}
