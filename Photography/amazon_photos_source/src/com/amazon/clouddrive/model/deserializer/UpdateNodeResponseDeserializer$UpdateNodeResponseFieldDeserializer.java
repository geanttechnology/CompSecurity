// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.UpdateNodeResponse;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            UpdateNodeResponseDeserializer, SimpleDeserializers

static class q extends q
{

    public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
        throws IOException
    {
        if (super.q(jsonparser, s, ieditablenode))
        {
            return true;
        }
        if ((ieditablenode instanceof UpdateNodeResponse) && "location".equals(s))
        {
            ((UpdateNodeResponse)ieditablenode).setLocation(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        } else
        {
            return false;
        }
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (IEditableNode)obj);
    }

    q()
    {
    }
}
