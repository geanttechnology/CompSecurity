// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.GetChangesExtendedResponse;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.ListDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            NodeExtendedDeserializer

public class GetChangesExtendedResponseDeserializer
    implements JsonDeserializer
{
    static class GetChangesExtendedResponseFieldDeserializer
        implements JsonFieldDeserializer
    {

        private final ListDeserializer mListDeserializer;

        public boolean handleField(JsonParser jsonparser, String s, GetChangesExtendedResponse getchangesextendedresponse)
            throws IOException
        {
            if ("reset".equals(s))
            {
                getchangesextendedresponse.setReset(SimpleDeserializers.deserializePrimitiveBoolean(jsonparser));
                return true;
            }
            if ("checkpoint".equals(s))
            {
                getchangesextendedresponse.setCheckpoint(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("nodes".equals(s))
            {
                getchangesextendedresponse.setNodes(mListDeserializer.deserialize(jsonparser));
                return true;
            } else
            {
                return false;
            }
        }

        public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
            throws IOException
        {
            return handleField(jsonparser, s, (GetChangesExtendedResponse)obj);
        }

        GetChangesExtendedResponseFieldDeserializer()
        {
            mListDeserializer = new ListDeserializer(NodeExtendedDeserializer.INSTANCE);
        }
    }


    public static final JsonDeserializer INSTANCE = new GetChangesExtendedResponseDeserializer();
    private final GetChangesExtendedResponseFieldDeserializer mFieldHandler = new GetChangesExtendedResponseFieldDeserializer();

    private GetChangesExtendedResponseDeserializer()
    {
    }

    public GetChangesExtendedResponse deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((GetChangesExtendedResponse) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        GetChangesExtendedResponse getchangesextendedresponse = new GetChangesExtendedResponse();
        do
        {
            obj = getchangesextendedresponse;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), getchangesextendedresponse))
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
