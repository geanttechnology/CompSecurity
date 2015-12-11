// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class MASHError extends Enum
{

    private static final MASHError $VALUES[];
    public static final MASHError INVALID_ARGUMENTS;
    public static final MASHError NOT_SUPPORTED;
    public static final MASHError OPERATION_IN_PROGRESS;
    public static final MASHError OUT_OF_MEM;
    public static final MASHError PERMISSION_DENIED;
    private static final String TAG = com/amazon/mobile/mash/error/MASHError.getSimpleName();
    public static final MASHError TIMEOUT;
    public static final MASHError UNKNOWN;
    public static final MASHError USER_CANCELLED;
    private int mErrorCode;

    private MASHError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static MASHError valueOf(String s)
    {
        return (MASHError)Enum.valueOf(com/amazon/mobile/mash/error/MASHError, s);
    }

    public static MASHError[] values()
    {
        return (MASHError[])$VALUES.clone();
    }

    public int getCode()
    {
        return mErrorCode;
    }

    public JSONObject toJSONObejct()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = new JSONObject();
            jsonobject.put("code", getCode());
        }
        catch (JSONException jsonexception)
        {
            Log.e(TAG, (new StringBuilder()).append("Created a bad JSON object for MASH error. ").append(jsonexception.getMessage()).toString());
            return null;
        }
        return jsonobject;
    }

    static 
    {
        PERMISSION_DENIED = new MASHError("PERMISSION_DENIED", 0, 1001);
        TIMEOUT = new MASHError("TIMEOUT", 1, 1002);
        NOT_SUPPORTED = new MASHError("NOT_SUPPORTED", 2, 1003);
        OUT_OF_MEM = new MASHError("OUT_OF_MEM", 3, 1004);
        UNKNOWN = new MASHError("UNKNOWN", 4, 1005);
        USER_CANCELLED = new MASHError("USER_CANCELLED", 5, 1006);
        INVALID_ARGUMENTS = new MASHError("INVALID_ARGUMENTS", 6, 1007);
        OPERATION_IN_PROGRESS = new MASHError("OPERATION_IN_PROGRESS", 7, 1008);
        $VALUES = (new MASHError[] {
            PERMISSION_DENIED, TIMEOUT, NOT_SUPPORTED, OUT_OF_MEM, UNKNOWN, USER_CANCELLED, INVALID_ARGUMENTS, OPERATION_IN_PROGRESS
        });
    }
}
