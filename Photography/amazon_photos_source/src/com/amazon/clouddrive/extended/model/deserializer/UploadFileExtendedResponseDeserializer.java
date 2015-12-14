// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.UploadFileExtendedResponse;
import com.amazon.clouddrive.model.IEditableNode;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.SimpleDeserializers;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            AbstractDeserializer

public class UploadFileExtendedResponseDeserializer extends AbstractDeserializer
{
    static class UploadFileExtendedResponseFieldDeserializer extends NodeExtendedDeserializer.NodeExtendedFieldDeserializer
    {

        public boolean handleField(JsonParser jsonparser, String s, IEditableNode ieditablenode)
            throws IOException
        {
            if (super.handleField(jsonparser, s, ieditablenode))
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

        UploadFileExtendedResponseFieldDeserializer()
        {
        }
    }


    public static final JsonDeserializer INSTANCE = new UploadFileExtendedResponseDeserializer();

    public UploadFileExtendedResponseDeserializer()
    {
        super(new UploadFileExtendedResponseFieldDeserializer());
    }

    protected UploadFileExtendedResponse createValue()
    {
        return new UploadFileExtendedResponse();
    }

    protected volatile Object createValue()
    {
        return createValue();
    }

}
