// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.PendingPlan;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class PendingPlanDeserializer
    implements JsonDeserializer
{
    static class PendingPlanFieldDeserializer
        implements JsonFieldDeserializer
    {

        public boolean handleField(JsonParser jsonparser, String s, PendingPlan pendingplan)
            throws IOException
        {
            if ("planId".equals(s))
            {
                pendingplan.setPlanId(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("endDate".equals(s))
            {
                pendingplan.setEndDate(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("startDate".equals(s))
            {
                pendingplan.setStartDate(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            } else
            {
                return false;
            }
        }

        public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
            throws IOException
        {
            return handleField(jsonparser, s, (PendingPlan)obj);
        }

        PendingPlanFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new PendingPlanDeserializer();
    private final PendingPlanFieldDeserializer mFieldHandler = new PendingPlanFieldDeserializer();

    private PendingPlanDeserializer()
    {
    }

    public PendingPlan deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((PendingPlan) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        PendingPlan pendingplan = new PendingPlan();
        do
        {
            obj = pendingplan;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), pendingplan))
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
