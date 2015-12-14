// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.net.URLEncoder;

// Referenced classes of package com.amazon.clouddrive.internal:
//            MultiPartPostBodyWriterHelper, RequestAssertUtils, CloudDriveObjectMapper

public static class mBodyAfterFileContents
{

    private final DataOutputStream mAfterFileOS;
    private final DataOutputStream mBeforeFileOS;
    private final ByteArrayOutputStream mBodyAfterFileContents = new ByteArrayOutputStream();
    private final ByteArrayOutputStream mBodyBeforeFileContents = new ByteArrayOutputStream();
    private String mMimeType;
    private String mName;
    private boolean mNeedsLineEnding;

    private mBodyAfterFileContents addBodyAfterFileContents()
        throws IOException
    {
        if (mNeedsLineEnding)
        {
            mAfterFileOS.writeBytes("\r\n");
        }
        mAfterFileOS.writeBytes("--*****--");
        mAfterFileOS.flush();
        return this;
    }

    public mAfterFileOS addContent()
        throws IOException
    {
        mNeedsLineEnding = true;
        RequestAssertUtils.assertNotNull(mName, "Name cannot be null.");
        RequestAssertUtils.assertNotNullOrEmpty(mMimeType, "MimeType cannot be null.");
        mBeforeFileOS.writeBytes("--*****\r\n");
        mBeforeFileOS.writeBytes("Content-Disposition: form-data; name=\"content\"; filename=\"");
        mBeforeFileOS.writeBytes(URLEncoder.encode(mName, "UTF-8"));
        mBeforeFileOS.writeBytes("\"\r\n");
        mBeforeFileOS.writeBytes(String.format("Content-Type: %s\r\n", new Object[] {
            mMimeType
        }));
        mBeforeFileOS.writeBytes("\r\n");
        mBeforeFileOS.flush();
        return this;
    }

    public mBeforeFileOS addMetadata(Object obj, JsonSerializer jsonserializer)
        throws IOException, CloudDriveException, InterruptedException
    {
        RequestAssertUtils.assertNotNull(obj, "Request cannot be null.");
        mBeforeFileOS.writeBytes("--*****\r\n");
        mBeforeFileOS.writeBytes("Content-Disposition: form-data; name=\"metadata\"\r\n");
        mBeforeFileOS.writeBytes("\r\n");
        CloudDriveObjectMapper.writeStream(mBeforeFileOS, obj, jsonserializer);
        mBeforeFileOS.writeBytes("\r\n");
        mBeforeFileOS.flush();
        return this;
    }

    public MultiPartPostBodyWriterHelper build()
        throws IOException
    {
        addBodyAfterFileContents();
        return new MultiPartPostBodyWriterHelper(this, null);
    }

    public addBodyAfterFileContents withName(String s)
    {
        mName = s;
        mMimeType = URLConnection.guessContentTypeFromName(s);
        if (mMimeType == null)
        {
            mMimeType = "application/octet-stream";
        }
        return this;
    }



    public ()
    {
        mNeedsLineEnding = false;
        mName = "";
        mMimeType = "application/octet-stream";
        mBeforeFileOS = new DataOutputStream(mBodyBeforeFileContents);
        mAfterFileOS = new DataOutputStream(mBodyAfterFileContents);
    }
}
