// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.GetSubscriptionsResponse;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            SubscriptionsListDeserializer

public class GetSubscriptionsResponseDeserializer
    implements JsonDeserializer
{
    static class GetSubscriptionsResponseFieldDeserializer
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

        GetSubscriptionsResponseFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new GetSubscriptionsResponseDeserializer();
    private final GetSubscriptionsResponseFieldDeserializer mFieldHandler = new GetSubscriptionsResponseFieldDeserializer();

    private GetSubscriptionsResponseDeserializer()
    {
    }

    public GetSubscriptionsResponse deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((GetSubscriptionsResponse) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        GetSubscriptionsResponse getsubscriptionsresponse = new GetSubscriptionsResponse();
        do
        {
            obj = getsubscriptionsresponse;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), getsubscriptionsresponse))
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
