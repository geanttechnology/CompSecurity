// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import java.io.InputStream;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads.identity:
//            JSONUtils, StringUtils, Log

class ResponseReader
{

    private static final String LOGTAG = com/amazon/device/ads/identity/ResponseReader.getSimpleName();
    private boolean enableLog;
    private String logTag;
    private final InputStream stream;

    ResponseReader(InputStream inputstream)
    {
        enableLog = false;
        logTag = LOGTAG;
        stream = inputstream;
    }

    public void enableLog(boolean flag)
    {
        enableLog = flag;
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
            Log.d(logTag, "Response Body: %s", new Object[] {
                s
            });
        }
        return s;
    }

    public void setExternalLogTag(String s)
    {
        if (s == null)
        {
            logTag = LOGTAG;
            return;
        } else
        {
            logTag = (new StringBuilder()).append(LOGTAG).append(" ").append(s).toString();
            return;
        }
    }

}
