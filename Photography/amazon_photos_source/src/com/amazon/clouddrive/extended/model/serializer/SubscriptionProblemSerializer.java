// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.serializer;

import com.amazon.clouddrive.extended.model.SubscriptionProblem;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import com.amazon.clouddrive.model.serializer.SimpleSerializers;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;

public class SubscriptionProblemSerializer
    implements JsonSerializer
{
    static class SubscriptionProblemFieldSerializer
    {

        public void serializeFields(SubscriptionProblem subscriptionproblem, JsonGenerator jsongenerator)
            throws IOException
        {
            jsongenerator.writeFieldName("effectiveDate");
            SimpleSerializers.serializeString(subscriptionproblem.getEffectiveDate(), jsongenerator);
            jsongenerator.writeFieldName("billingPeriodNumber");
            SimpleSerializers.serializePrimitiveLong(subscriptionproblem.getBillingPeriodNumber(), jsongenerator);
            jsongenerator.writeFieldName("problemID");
            SimpleSerializers.serializeString(subscriptionproblem.getProblemID(), jsongenerator);
            jsongenerator.writeFieldName("problemCode");
            SimpleSerializers.serializeString(subscriptionproblem.getProblemCode(), jsongenerator);
            jsongenerator.writeFieldName("problemStatus");
            SimpleSerializers.serializeString(subscriptionproblem.getProblemStatus(), jsongenerator);
        }

        SubscriptionProblemFieldSerializer()
        {
        }
    }


    public static final JsonSerializer INSTANCE = new SubscriptionProblemSerializer();
    private final SubscriptionProblemFieldSerializer mFieldSerializer = new SubscriptionProblemFieldSerializer();

    private SubscriptionProblemSerializer()
    {
    }

    public final void serialize(SubscriptionProblem subscriptionproblem, JsonGenerator jsongenerator)
        throws IOException
    {
        if (subscriptionproblem == null)
        {
            jsongenerator.writeNull();
            return;
        } else
        {
            jsongenerator.writeStartObject();
            mFieldSerializer.serializeFields(subscriptionproblem, jsongenerator);
            jsongenerator.writeEndObject();
            return;
        }
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator)
        throws IOException
    {
        serialize((SubscriptionProblem)obj, jsongenerator);
    }

}
