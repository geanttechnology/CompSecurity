// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.ListChildrenResponse;
import com.amazon.clouddrive.model.PaginatedCloudDriveResponse;
import java.io.IOException;
import java.util.List;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            PaginatedCloudDriveResponseFieldDeserializer, ListChildrenResponseDeserializer, NodeListDeserializer, JsonDeserializer

public static class  extends PaginatedCloudDriveResponseFieldDeserializer
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

    public ()
    {
    }
}
