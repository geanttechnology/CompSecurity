// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            SubmissionState, Logger

public static class 
{

    private long attempts;
    private long numMeasurements;
    private boolean succeeded;
    private long timestamp;

    public JSONObject toJson()
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("numMeasurements", numMeasurements);
        jsonobject.put("timestamp", timestamp);
        jsonobject.put("attempts", attempts);
        if (!succeeded)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        jsonobject.put("status", "Succeeded");
        return jsonobject;
        try
        {
            jsonobject.put("status", "Failed");
        }
        catch (JSONException jsonexception)
        {
            Logger.e("failed to serialize object", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public String toString()
    {
        return toJson().toString();
    }

    public ()
    {
    }
}
