// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.exceptions;

import com.comcast.cim.cmasl.http.response.DetailedRequestStatus;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CimHttpException extends CimException
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/http/exceptions/CimHttpException);
    private DetailedRequestStatus detailedStatus;

    public CimHttpException(DetailedRequestStatus detailedrequeststatus)
    {
        super(detailedrequeststatus.getStatusMessage());
        detailedStatus = detailedrequeststatus;
    }

    public DetailedRequestStatus getDetailedStatus()
    {
        return detailedStatus;
    }

    public int getDetailedStatusCode()
    {
        return detailedStatus.getStatusCode().intValue();
    }

    public int getStatusCode()
    {
        return detailedStatus.getStatusCode().intValue();
    }

    public int getStatusCodeForDisplay()
    {
        return detailedStatus.getStatusCode().intValue();
    }

}
