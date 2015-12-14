// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import java.io.OutputStream;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.clouddrive.internal:
//            PostRequestWriter, CloudDriveObjectMapper

class SinglePartPostRequestWriter
    implements PostRequestWriter
{

    private final Object mRequest;
    private final JsonSerializer mSerializer;

    SinglePartPostRequestWriter(Object obj, JsonSerializer jsonserializer)
    {
        mRequest = obj;
        mSerializer = jsonserializer;
    }

    public void writeHeaders(HttpURLConnection httpurlconnection)
        throws CloudDriveException
    {
        httpurlconnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    }

    public void writeRequest(OutputStream outputstream)
        throws CloudDriveException, InterruptedException
    {
        CloudDriveObjectMapper.writeStream(outputstream, mRequest, mSerializer);
    }
}
