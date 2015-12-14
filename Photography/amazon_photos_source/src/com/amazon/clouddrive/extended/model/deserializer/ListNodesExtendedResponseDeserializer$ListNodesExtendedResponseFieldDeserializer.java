// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.extended.model.deserializer;

import com.amazon.clouddrive.extended.model.ListNodesExtendedResponse;
import com.amazon.clouddrive.model.PaginatedCloudDriveResponse;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.deserializer.PaginatedCloudDriveResponseFieldDeserializer;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.extended.model.deserializer:
//            ListNodesExtendedResponseDeserializer, ExtendedDeserializers

static class  extends PaginatedCloudDriveResponseFieldDeserializer
{

    public boolean handleField(JsonParser jsonparser, String s, PaginatedCloudDriveResponse paginatedclouddriveresponse)
        throws IOException
    {
        if (super.handleField(jsonparser, s, paginatedclouddriveresponse))
        {
            return true;
        }
        if ((paginatedclouddriveresponse instanceof ListNodesExtendedResponse) && "data".equals(s))
        {
            ((ListNodesExtendedResponse)paginatedclouddriveresponse).setData((List)ExtendedDeserializers.LIST_NODE_EXTENDED_DESERIALIZER.deserialize(jsonparser));
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

    ()
    {
    }
}
