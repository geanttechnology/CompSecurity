// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.ListChildrenResponse;
import com.amazon.clouddrive.model.PaginatedCloudDriveResponse;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonDeserializer, PaginatedCloudDriveResponseFieldDeserializer, NodeListDeserializer

public class ListChildrenResponseDeserializer
    implements JsonDeserializer
{
    public static class ListChildrenResponseFieldDeserializer extends PaginatedCloudDriveResponseFieldDeserializer
    {

        public boolean handleField(JsonParser jsonparser, String s, PaginatedCloudDriveResponse paginatedclouddriveresponse)
            throws IOException
        {
            if (super.handleField(jsonparser, s, paginatedclouddriveresponse))
            {
                return true;
            }
            if ((paginatedclouddriveresponse instanceof ListChildrenResponse) && "data".equals(s))
            {
                ((ListChildrenResponse)paginatedclouddriveresponse).setData((List)NodeListDeserializer.INSTANCE.deserialize(jsonparser));
                return true;
            } else
            {
                return false;
            }
        }

        public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
            throws IOException
        {
            return handleField(jsonparser, s, (PaginatedCloudDriveResponse)obj);
        }

        public ListChildrenResponseFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new ListChildrenResponseDeserializer();
    private final ListChildrenResponseFieldDeserializer mFieldHandler = new ListChildrenResponseFieldDeserializer();

    private ListChildrenResponseDeserializer()
    {
    }

    public ListChildrenResponse deserialize(JsonParser jsonparser)
        throws IOException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_NULL) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ListChildrenResponse) (obj));
_L2:
        if (jsontoken != JsonToken.START_OBJECT)
        {
            throw new JsonParseException((new StringBuilder()).append("Expected start of object, got ").append(jsontoken).toString(), jsonparser.getTokenLocation());
        }
        ListChildrenResponse listchildrenresponse = new ListChildrenResponse();
        do
        {
            obj = listchildrenresponse;
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
            if (!mFieldHandler.handleField(jsonparser, ((String) (obj)), listchildrenresponse))
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
