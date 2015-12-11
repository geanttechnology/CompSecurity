// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class LogoutError extends Enum
{

    private static final LogoutError $VALUES[];
    public static final LogoutError NOT_LOGGED_IN;
    private static final String TAG = com/amazon/mobile/mash/error/LogoutError.getSimpleName();
    private int mErrorCode;

    private LogoutError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static LogoutError valueOf(String s)
    {
        return (LogoutError)Enum.valueOf(com/amazon/mobile/mash/error/LogoutError, s);
    }

    public static LogoutError[] values()
    {
        return (LogoutError[])$VALUES.clone();
    }

    public int getCode()
    {
        return mErrorCode;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject;
        LogoutError alogouterror[];
        LogoutError logouterror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            alogouterror = values();
            j = alogouterror.length;
        }
        catch (JSONException jsonexception)
        {
            Log.e(TAG, (new StringBuilder()).append("bad JSON: ").append(jsonexception.getMessage()).toString());
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        logouterror = alogouterror[i];
        jsonobject.put(logouterror.name(), logouterror.getCode());
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_19;
_L1:
        jsonobject.put("code", getCode());
        return jsonobject;
    }

    static 
    {
        NOT_LOGGED_IN = new LogoutError("NOT_LOGGED_IN", 0, 1);
        $VALUES = (new LogoutError[] {
            NOT_LOGGED_IN
        });
    }
}
