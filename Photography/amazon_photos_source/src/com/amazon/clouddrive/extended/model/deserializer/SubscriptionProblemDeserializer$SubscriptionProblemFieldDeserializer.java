// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.SubscriptionProblem;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            SubscriptionProblemDeserializer

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, SubscriptionProblem subscriptionproblem)
        throws IOException
    {
        if ("effectiveDate".equals(s))
        {
            subscriptionproblem.setEffectiveDate(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("billingPeriodNumber".equals(s))
        {
            subscriptionproblem.setBillingPeriodNumber(SimpleDeserializers.deserializePrimitiveLong(jsonparser));
            return true;
        }
        if ("problemID".equals(s))
        {
            subscriptionproblem.setProblemID(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("problemCode".equals(s))
        {
            subscriptionproblem.setProblemCode(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("problemStatus".equals(s))
        {
            subscriptionproblem.setProblemStatus(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (SubscriptionProblem)obj);
    }

    ()
    {
    }
}
