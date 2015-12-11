// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip;

import com.comcast.cim.cmasl.http.exceptions.CimHttpException;
import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import java.util.Map;

public class XipHttpErrorException extends CimHttpException
{

    private final DetailedRequestStatus xipStatus;

    public XipHttpErrorException(DetailedRequestStatus detailedrequeststatus, DetailedRequestStatus detailedrequeststatus1)
    {
        super(detailedrequeststatus1);
        xipStatus = detailedrequeststatus;
    }

    public static XipHttpErrorException fromHttpResponse(DetailedRequestStatus detailedrequeststatus, Map map)
    {
        String s = null;
        if (map != null)
        {
            s = (String)map.get("X-xip-error");
        }
        if (s == null)
        {
            return null;
        }
        byte byte0 = -1;
        int i = byte0;
        if (s.startsWith("XIP"))
        {
            try
            {
                i = Integer.valueOf(s.substring("XIP".length())).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Map map)
            {
                i = byte0;
            }
        }
        return new XipHttpErrorException(new DetailedRequestStatus(Integer.valueOf(i), String.format("XIP Error %d. %s", new Object[] {
            Integer.valueOf(i), getMessageForCode(i)
        })), detailedrequeststatus);
    }

    private static String getMessageForCode(int i)
    {
        switch (i)
        {
        case 3003: 
        case 3005: 
        case 3007: 
        case 3008: 
        default:
            return "This request requires authentication.";

        case 3009: 
            return "This request requires your time to be correct.";

        case 3001: 
            return "This device has not been provisioned.";

        case 3002: 
            return "The signature on the request was incorrect.";

        case 3006: 
            return "This request requires authentication.";

        case 3004: 
            return "The submitted login was not valid.";
        }
    }

    public int getDetailedStatusCode()
    {
        return xipStatus.getStatusCode().intValue();
    }

    public int getStatusCodeForDisplay()
    {
        return xipStatus.getStatusCode().intValue();
    }

    public DetailedRequestStatus getXipStatus()
    {
        return xipStatus;
    }
}
