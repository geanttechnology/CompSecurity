// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.NodeExtended;
import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            NodeExtendedDeserializer

static class  extends com.amazon.clouddrive.model.deserializer.rializer
{

    public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
        throws IOException
    {
        if (super.rializer(jsonparser, s, ieditablenode))
        {
            return true;
        }
        if (ieditablenode instanceof NodeExtended)
        {
            if ("restricted".equals(s))
            {
                ((NodeExtended)ieditablenode).setRestricted(SimpleDeserializers.deserializeBoolean(jsonparser));
                return true;
            }
            if ("shareId".equals(s))
            {
                ((NodeExtended)ieditablenode).setShareId(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
            if ("shareURL".equals(s))
            {
                ((NodeExtended)ieditablenode).setShareURL(SimpleDeserializers.deserializeString(jsonparser));
                return true;
            }
        }
        return false;
    }

    public volatile boolean handleField(JsonParser jsonparser, String s, Object obj)
        throws IOException
    {
        return handleField(jsonparser, s, (IEditableNode)obj);
    }

    ()
    {
    }
}
