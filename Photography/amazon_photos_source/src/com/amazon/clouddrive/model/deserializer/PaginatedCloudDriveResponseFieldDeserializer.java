// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.model.deserializer;

import com.amazon.clouddrive.model.PaginatedCloudDriveResponse;
import java.io.IOException;
import org.codehaus.jackson.JsonParser;

// Referenced classes of package com.amazon.clouddrive.model.deserializer:
//            JsonFieldDeserializer, SimpleDeserializers

public class PaginatedCloudDriveResponseFieldDeserializer
    implements JsonFieldDeserializer
{

    public PaginatedCloudDriveResponseFieldDeserializer()
    {
    }

    public boolean handleField(JsonParser jsonparser, String s, PaginatedCloudDriveResponse paginatedclouddriveresponse)
        throws IOException
    {
        if ("nextToken".equals(s))
        {
            paginatedclouddriveresponse.setNextToken(SimpleDeserializers.deserializeString(jsonparser));
            return true;
        }
        if ("count".equals(s))
        {
            paginatedclouddriveresponse.setCount(SimpleDeserializers.deserializeInteger(jsonparser).intValue());
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
}
