// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.GetSubscriptionsResponse;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            GetSubscriptionsResponseDeserializer, SubscriptionsListDeserializer

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, GetSubscriptionsResponse getsubscriptionsresponse)
        throws IOException
    {
        if ("subscriptionsList".equals(s))
        {
            getsubscriptionsresponse.setSubscriptionsList((List)SubscriptionsListDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (GetSubscriptionsResponse)obj);
    }

    ()
    {
    }
}
