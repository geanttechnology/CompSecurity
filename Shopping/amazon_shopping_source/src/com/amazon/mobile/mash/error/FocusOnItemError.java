// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class FocusOnItemError extends Enum
{

    private static final FocusOnItemError $VALUES[];
    public static final FocusOnItemError ITEM_CAN_NOT_BE_IN_FOCUS;
    public static final FocusOnItemError NOT_FOUND;
    private int mErrorCode;

    private FocusOnItemError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static FocusOnItemError valueOf(String s)
    {
        return (FocusOnItemError)Enum.valueOf(com/amazon/mobile/mash/error/FocusOnItemError, s);
    }

    public static FocusOnItemError[] values()
    {
        return (FocusOnItemError[])$VALUES.clone();
    }

    public JSONObject toJSONObejct()
    {
        JSONObject jsonobject;
        FocusOnItemError afocusonitemerror[];
        FocusOnItemError focusonitemerror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            afocusonitemerror = values();
            j = afocusonitemerror.length;
        }
        catch (JSONException jsonexception)
        {
            Log.e("FocusOnItemError", (new StringBuilder()).append("Bad JSON: ").append(jsonexception.getMessage()).toString());
            return null;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        focusonitemerror = afocusonitemerror[i];
        jsonobject.put(focusonitemerror.name(), focusonitemerror.mErrorCode);
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
        NOT_FOUND = new FocusOnItemError("NOT_FOUND", 0, 1);
        ITEM_CAN_NOT_BE_IN_FOCUS = new FocusOnItemError("ITEM_CAN_NOT_BE_IN_FOCUS", 1, 2);
        $VALUES = (new FocusOnItemError[] {
            NOT_FOUND, ITEM_CAN_NOT_BE_IN_FOCUS
        });
    }
}
