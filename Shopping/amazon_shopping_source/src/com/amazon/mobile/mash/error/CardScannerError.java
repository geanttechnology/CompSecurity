// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class CardScannerError extends Enum
{

    private static final CardScannerError $VALUES[];
    public static final CardScannerError CANNOT_OPEN_CAMERA;
    public static final CardScannerError INVALID_CARD_TYPE;
    public static final CardScannerError NO_SUPPORTED_CARD_TYPES;
    private static final String TAG = com/amazon/mobile/mash/error/CardScannerError.getSimpleName();
    private int mErrorCode;

    private CardScannerError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static CardScannerError valueOf(String s)
    {
        return (CardScannerError)Enum.valueOf(com/amazon/mobile/mash/error/CardScannerError, s);
    }

    public static CardScannerError[] values()
    {
        return (CardScannerError[])$VALUES.clone();
    }

    public int getCode()
    {
        return mErrorCode;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject;
        CardScannerError acardscannererror[];
        CardScannerError cardscannererror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            acardscannererror = values();
            j = acardscannererror.length;
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
        cardscannererror = acardscannererror[i];
        jsonobject.put(cardscannererror.name(), cardscannererror.getCode());
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
        CANNOT_OPEN_CAMERA = new CardScannerError("CANNOT_OPEN_CAMERA", 0, 1);
        INVALID_CARD_TYPE = new CardScannerError("INVALID_CARD_TYPE", 1, 2);
        NO_SUPPORTED_CARD_TYPES = new CardScannerError("NO_SUPPORTED_CARD_TYPES", 2, 3);
        $VALUES = (new CardScannerError[] {
            CANNOT_OPEN_CAMERA, INVALID_CARD_TYPE, NO_SUPPORTED_CARD_TYPES
        });
    }
}
