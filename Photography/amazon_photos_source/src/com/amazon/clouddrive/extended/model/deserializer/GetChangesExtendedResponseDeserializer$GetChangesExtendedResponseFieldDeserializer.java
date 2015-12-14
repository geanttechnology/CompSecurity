// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.GetChangesExtendedResponse;
import com.amazon.clouddrive.model.deserializer.JsonFieldDeserializer;
import com.amazon.clouddrive.model.deserializer.ListDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            GetChangesExtendedResponseDeserializer, NodeExtendedDeserializer

static class mListDeserializer
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

    ()
    {
        mListDeserializer = new ListDeserializer(NodeExtendedDeserializer.INSTANCE);
    }
}
