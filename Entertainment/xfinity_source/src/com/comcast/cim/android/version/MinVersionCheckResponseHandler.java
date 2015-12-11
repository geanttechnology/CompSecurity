// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.version;

import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.xip.XipResponseHandler;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinVersionCheckResponseHandler extends XipResponseHandler
{

    private final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/version/MinVersionCheckResponseHandler);
    private Integer minVersion;

    public MinVersionCheckResponseHandler()
    {
        minVersion = Integer.valueOf(0);
    }

    public Integer getMinVersion()
    {
        return minVersion;
    }

    public void handleResponseBody(InputStream inputstream)
    {
        try
        {
            inputstream = IOUtils.toString(inputstream, "UTF-8");
            if (!inputstream.equals("0.0"))
            {
                minVersion = Integer.valueOf(Integer.parseInt(inputstream));
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            LOG.warn("Failed to check Min Version", inputstream);
        }
        throw new CimIOException("Failed reading Min Version Response", inputstream);
    }
}
