// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip.ams;

import com.comcast.cim.cmasl.http.exceptions.CimHttpException;
import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.xip.XipResponseHandler;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

// Referenced classes of package com.comcast.cim.cmasl.xip.ams:
//            AmsRequestStatus, AmsHttpErrorException

public abstract class AMSResponseHandler extends XipResponseHandler
{

    private DetailedRequestStatus detailedRequestStatus;
    protected DetailedRequestStatus detailedStatus;
    private CimHttpException httpException;
    protected final ObjectMapper jsonObjectMapper;

    public AMSResponseHandler(ObjectMapper objectmapper)
    {
        jsonObjectMapper = objectmapper;
    }

    protected abstract void handleAMSResponseBody(JsonNode jsonnode)
        throws IOException;

    public void handleResponseBody(InputStream inputstream)
    {
        AmsHttpErrorException amshttperrorexception;
        inputstream = (JsonNode)jsonObjectMapper.readValue(inputstream, com/fasterxml/jackson/databind/JsonNode);
        detailedStatus = ((AmsRequestStatus)jsonObjectMapper.readValue(inputstream.traverse(), com/comcast/cim/cmasl/xip/ams/AmsRequestStatus)).toDetailedRequestStatus();
        amshttperrorexception = AmsHttpErrorException.fromHttpStatusAndAMSStatus(detailedRequestStatus, detailedStatus);
        if (amshttperrorexception != null)
        {
            try
            {
                throw amshttperrorexception;
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream) { }
            try
            {
                if (httpException != null)
                {
                    throw httpException;
                }
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                throw new CimIOException(inputstream);
            }
            break MISSING_BLOCK_LABEL_90;
        }
        if (httpException != null)
        {
            throw httpException;
        }
        break MISSING_BLOCK_LABEL_99;
        throw new CimIOException(inputstream);
        handleAMSResponseBody(inputstream);
        return;
    }

    public void handleResponseHeaders(String s, DetailedRequestStatus detailedrequeststatus, Map map)
    {
        try
        {
            super.handleResponseHeaders(s, detailedrequeststatus, map);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            httpException = s;
        }
        detailedRequestStatus = detailedrequeststatus;
    }
}
