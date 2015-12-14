// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.GetAccountQuotaResponse;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, GetAccountQuotaResponseDeserializer, SimpleDeserializers

static class 
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, GetAccountQuotaResponse getaccountquotaresponse)
        throws IOException
    {
        if ("quota".equals(s))
        {
            getaccountquotaresponse.setQuota(SimpleDeserializers.deserializePrimitiveLong(jsonparser));
            return true;
        }
        if ("lastCalculated".equals(s))
        {
            getaccountquotaresponse.setLastCalculated(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("available".equals(s))
        {
            getaccountquotaresponse.setAvailable(SimpleDeserializers.deserializePrimitiveLong(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (GetAccountQuotaResponse)obj);
    }

    ()
    {
    }
}
