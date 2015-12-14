// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.GetAccountQuotaResponse;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, JsonFieldDeserializer, SimpleDeserializers

public class GetAccountQuotaResponseDeserializer
    implements JsonDeserializer
{
    static class GetAccountQuotaResponseFieldDeserializer
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

        GetAccountQuotaResponseFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new GetAccountQuotaResponseDeserializer();
    private final GetAccountQuotaResponseFieldDeserializer mFieldHandler = new GetAccountQuotaResponseFieldDeserializer();

    private GetAccountQuotaResponseDeserializer()
    {
    }

    public GetAccountQuotaResponse deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((GetAccountQuotaResponse) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        GetAccountQuotaResponse getaccountquotaresponse = new GetAccountQuotaResponse();
        do
        {
            obj = getaccountquotaresponse;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), getaccountquotaresponse))
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
