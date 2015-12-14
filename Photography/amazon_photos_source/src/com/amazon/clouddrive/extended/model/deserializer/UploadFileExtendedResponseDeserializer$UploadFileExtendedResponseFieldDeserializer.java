// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.UploadFileExtendedResponse;
import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            UploadFileExtendedResponseDeserializer

static class  extends 
{

    public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
        throws IOException
    {
        if (super.(jsonparser, s, ieditablenode))
        {
            return true;
        }
        if ((ieditablenode instanceof UploadFileExtendedResponse) && "location".equals(s))
        {
            ((UploadFileExtendedResponse)ieditablenode).setLocation(SimpleDeserializers.deserializeString(jsonparser));
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

    ()
    {
    }
}
