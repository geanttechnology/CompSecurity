// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.InputStream;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, JSONUtils, StringUtils, MobileAdsLogger

class ResponseReader
{

    private static final String LOGTAG = com/amazon/device/ads/ResponseReader.getSimpleName();
    private boolean enableLog;
    private final MobileAdsLogger logger;
    private final InputStream stream;

    ResponseReader(InputStream inputstream)
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        enableLog = false;
        stream = inputstream;
    }

    public void enableLog(boolean flag)
    {
        enableLog = flag;
    }

    public InputStream getInputStream()
    {
        return stream;
    }

    public JSONObject readAsJSON()
    {
        return JSONUtils.getJSONObjectFromString(readAsString());
    }

    public String readAsString()
    {
        String s = StringUtils.readStringFromInputStream(stream);
        if (enableLog)
        {
            logger.d("Response Body: %s", new Object[] {
                s
            });
        }
        return s;
    }

    public void setExternalLogTag(String s)
    {
        if (s == null)
        {
            logger.withLogTag(LOGTAG);
            return;
        } else
        {
            logger.withLogTag((new StringBuilder()).append(LOGTAG).append(" ").append(s).toString());
            return;
        }
    }

}
