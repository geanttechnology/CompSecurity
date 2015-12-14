// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.PendingPlan;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            PendingPlanDeserializer

static class 
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

    ()
    {
    }
}
