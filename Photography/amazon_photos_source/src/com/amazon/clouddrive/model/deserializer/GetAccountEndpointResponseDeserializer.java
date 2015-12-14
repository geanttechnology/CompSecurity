// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.GetAccountEndpointResponse;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, JsonFieldDeserializer, SimpleDeserializers

public class GetAccountEndpointResponseDeserializer
    implements JsonDeserializer
{
    static class GetAccountEndpointResponseFieldDeserializer
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

        GetAccountEndpointResponseFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new GetAccountEndpointResponseDeserializer();
    private final GetAccountEndpointResponseFieldDeserializer mFieldHandler = new GetAccountEndpointResponseFieldDeserializer();

    private GetAccountEndpointResponseDeserializer()
    {
    }

    public GetAccountEndpointResponse deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((GetAccountEndpointResponse) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        GetAccountEndpointResponse getaccountendpointresponse = new GetAccountEndpointResponse();
        do
        {
            obj = getaccountendpointresponse;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), getaccountendpointresponse))
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
