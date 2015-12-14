// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.BulkResponse;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            ErrorMapDeserializer

class BulkResponseFieldDeserializer
    implements JsonFieldDeserializer
{

    BulkResponseFieldDeserializer()
    {
    }

    public boolean handleField(JsonParser jsonparser, String s, BulkResponse bulkresponse)
        throws IOException
    {
        if ("errorMap".equals(s))
        {
            bulkresponse.setErrorMap((Map)ErrorMapDeserializer.INSTANCE.deserialize(jsonparser));
            return true;
        }
        if ("message".equals(s))
        {
            bulkresponse.setMessage(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (BulkResponse)obj);
    }
}
