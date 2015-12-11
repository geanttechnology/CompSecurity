// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class BarcodeScanError extends Enum
{

    private static final BarcodeScanError $VALUES[];
    public static final BarcodeScanError CANNOT_OPEN_CAMERA;
    private static final String TAG = com/amazon/mobile/mash/error/BarcodeScanError.getSimpleName();
    private int mErrorCode;

    private BarcodeScanError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static BarcodeScanError valueOf(String s)
    {
        return (BarcodeScanError)Enum.valueOf(com/amazon/mobile/mash/error/BarcodeScanError, s);
    }

    public static BarcodeScanError[] values()
    {
        return (BarcodeScanError[])$VALUES.clone();
    }

    public int getCode()
    {
        return mErrorCode;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject;
        BarcodeScanError abarcodescanerror[];
        BarcodeScanError barcodescanerror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            abarcodescanerror = values();
            j = abarcodescanerror.length;
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
        barcodescanerror = abarcodescanerror[i];
        jsonobject.put(barcodescanerror.name(), barcodescanerror.getCode());
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
        CANNOT_OPEN_CAMERA = new BarcodeScanError("CANNOT_OPEN_CAMERA", 0, 1);
        $VALUES = (new BarcodeScanError[] {
            CANNOT_OPEN_CAMERA
        });
    }
}
