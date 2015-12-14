// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.GetAccountEndpointResponse;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, GetAccountEndpointResponseDeserializer, SimpleDeserializers

static class _81_
    implements JsonFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, GetAccountEndpointResponse getaccountendpointresponse)
        throws IOException
    {
        if ("contentUrl".equals(s))
        {
            getaccountendpointresponse.setContentUrl(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("marketplaceAtSignup".equals(s))
        {
            getaccountendpointresponse.setMarketplaceAtSignup(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("countryAtSignup".equals(s))
        {
            getaccountendpointresponse.setCountryAtSignup(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("customerExists".equals(s))
        {
            getaccountendpointresponse.setCustomerExists(SimpleDeserializers.deserializePrimitiveBoolean(jsonparser));
            return true;
        }
        if ("metadataUrl".equals(s))
        {
            getaccountendpointresponse.setMetadataUrl(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("region".equals(s))
        {
            getaccountendpointresponse.setRegion(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("retailUrl".equals(s))
        {
            getaccountendpointresponse.setRetailUrl(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (GetAccountEndpointResponse)obj);
    }

    _81_()
    {
    }
}
