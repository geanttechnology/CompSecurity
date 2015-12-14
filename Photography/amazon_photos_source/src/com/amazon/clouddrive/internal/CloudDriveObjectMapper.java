// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.exceptions.ActionRequiredException;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.RebuildRequestException;
import com.amazon.clouddrive.model.deserializer.JsonDeserializer;
import com.amazon.clouddrive.model.serializer.JsonSerializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;

class CloudDriveObjectMapper
{

    static Object readStream(InputStream inputstream, JsonDeserializer jsondeserializer)
        throws CloudDriveException, InterruptedException
    {
        InputStream inputstream1;
        InputStream inputstream2;
        InputStream inputstream3;
        inputstream1 = null;
        inputstream3 = null;
        inputstream2 = null;
        inputstream = (new JsonFactory()).createJsonParser(inputstream);
        inputstream2 = inputstream;
        inputstream1 = inputstream;
        inputstream3 = inputstream;
        inputstream.nextToken();
        inputstream2 = inputstream;
        inputstream1 = inputstream;
        inputstream3 = inputstream;
        jsondeserializer = ((JsonDeserializer) (jsondeserializer.deserialize(inputstream)));
        if (inputstream != null)
        {
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                return jsondeserializer;
            }
        }
        return jsondeserializer;
        inputstream;
        inputstream1 = inputstream2;
        throw new InterruptedException();
        inputstream;
        if (inputstream1 != null)
        {
            try
            {
                inputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (JsonDeserializer jsondeserializer) { }
        }
        throw inputstream;
        inputstream;
        inputstream1 = inputstream3;
        throw new ActionRequiredException("Failed to read stream from the service.", inputstream);
    }

    static void writeStream(OutputStream outputstream, Object obj, JsonSerializer jsonserializer)
        throws CloudDriveException, InterruptedException
    {
        OutputStream outputstream1;
        OutputStream outputstream2;
        OutputStream outputstream3;
        outputstream1 = null;
        outputstream3 = null;
        outputstream2 = null;
        outputstream = (new JsonFactory()).createJsonGenerator(outputstream, JsonEncoding.UTF8);
        outputstream2 = outputstream;
        outputstream1 = outputstream;
        outputstream3 = outputstream;
        jsonserializer.serialize(obj, outputstream);
        if (outputstream == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        outputstream.close();
        return;
        outputstream;
        outputstream1 = outputstream2;
        throw new InterruptedException();
        outputstream;
        if (outputstream1 != null)
        {
            try
            {
                outputstream1.close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        throw outputstream;
        outputstream;
        outputstream1 = outputstream3;
        throw new RebuildRequestException("Failed to write request to the service.", outputstream);
        outputstream;
    }
}
