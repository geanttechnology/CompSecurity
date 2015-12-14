// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.exceptions.BadToken;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.ConflictError;
import com.amazon.clouddrive.exceptions.Forbidden;
import com.amazon.clouddrive.exceptions.InvalidParameter;
import com.amazon.clouddrive.exceptions.NoRetryException;
import com.amazon.clouddrive.exceptions.NoRetryServiceException;
import com.amazon.clouddrive.exceptions.PreConditionFailure;
import com.amazon.clouddrive.exceptions.ResourceNotFound;
import com.amazon.clouddrive.exceptions.RetryException;
import com.amazon.clouddrive.exceptions.SystemFault;
import com.amazon.clouddrive.exceptions.SystemUnavailable;
import com.amazon.clouddrive.exceptions.TooManyRequests;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

class ErrorDeserializer
{

    static CloudDriveException getCloudDriveException(InputStream inputstream, int i)
        throws NoRetryServiceException
    {
        String s;
        String s2;
        s2 = null;
        s = null;
        String s1;
        JsonParser jsonparser;
        JsonToken jsontoken;
        s1 = (new StringBuilder()).append("Non-successful response code: ").append(i).toString();
        jsonparser = (new JsonFactory()).createJsonParser(inputstream);
        jsontoken = jsonparser.nextToken();
        if (jsontoken == JsonToken.VALUE_NULL)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        inputstream = s2;
        if (jsontoken == JsonToken.START_OBJECT)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        throw new NoRetryServiceException("Unexpected response format.");
_L2:
        if (jsonparser.nextToken() == JsonToken.END_OBJECT)
        {
            break; /* Loop/switch isn't completed */
        }
        if (jsonparser.getCurrentToken() != JsonToken.FIELD_NAME)
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = jsonparser.getCurrentName();
        if ("message".equals(s2))
        {
            if (jsonparser.nextToken() != JsonToken.VALUE_NULL)
            {
                s1 = jsonparser.getText();
            }
            continue; /* Loop/switch isn't completed */
        }
        if ("code".equals(s2))
        {
            if (jsonparser.nextToken() != JsonToken.VALUE_NULL)
            {
                inputstream = jsonparser.getText();
            }
            continue; /* Loop/switch isn't completed */
        }
        if ("logref".equals(s2))
        {
            if (jsonparser.nextToken() != JsonToken.VALUE_NULL)
            {
                s = jsonparser.getText();
            }
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            jsonparser.skipChildren();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new NoRetryServiceException("Failed to parse Cloud Drive service error message", inputstream);
        }
        if (true) goto _L2; else goto _L1
_L1:
        switch (i)
        {
        default:
            if (i >= 500 && i < 600)
            {
                return new RetryException(s1, inputstream, s);
            } else
            {
                return new NoRetryException(s1, inputstream, s);
            }

        case 400: 
            return new InvalidParameter(s1, inputstream, s);

        case 401: 
            return new BadToken(s1, inputstream, s);

        case 403: 
            return new Forbidden(s1, inputstream, s);

        case 404: 
            return new ResourceNotFound(s1, inputstream, s);

        case 409: 
            return new ConflictError(s1, inputstream, s);

        case 412: 
            return new PreConditionFailure(s1, inputstream, s);

        case 429: 
            return new TooManyRequests(s1, inputstream, s);

        case 500: 
            return new SystemFault(s1, inputstream, s);

        case 503: 
            return new SystemUnavailable(s1, inputstream, s);
        }
    }
}
