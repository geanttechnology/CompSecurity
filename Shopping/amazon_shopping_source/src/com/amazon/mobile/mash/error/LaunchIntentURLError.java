// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class LaunchIntentURLError extends Enum
{

    private static final LaunchIntentURLError $VALUES[];
    public static final LaunchIntentURLError INTENT_NOT_FOUND;
    private int mErrorCode;

    private LaunchIntentURLError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static LaunchIntentURLError valueOf(String s)
    {
        return (LaunchIntentURLError)Enum.valueOf(com/amazon/mobile/mash/error/LaunchIntentURLError, s);
    }

    public static LaunchIntentURLError[] values()
    {
        return (LaunchIntentURLError[])$VALUES.clone();
    }

    public JSONObject toJSONObejct()
    {
        JSONObject jsonobject;
        LaunchIntentURLError alaunchintenturlerror[];
        LaunchIntentURLError launchintenturlerror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            alaunchintenturlerror = values();
            j = alaunchintenturlerror.length;
        }
        catch (JSONException jsonexception)
        {
            Log.e("LaunchIntentURLError", (new StringBuilder()).append("Bad JSON: ").append(jsonexception.getMessage()).toString());
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        launchintenturlerror = alaunchintenturlerror[i];
        jsonobject.put(launchintenturlerror.name(), launchintenturlerror.mErrorCode);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_19;
_L1:
        jsonobject.put("code", mErrorCode);
        return jsonobject;
    }

    static 
    {
        INTENT_NOT_FOUND = new LaunchIntentURLError("INTENT_NOT_FOUND", 0, 1);
        $VALUES = (new LaunchIntentURLError[] {
            INTENT_NOT_FOUND
        });
    }
}
