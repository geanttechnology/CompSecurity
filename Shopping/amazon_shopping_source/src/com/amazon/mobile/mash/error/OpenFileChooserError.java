// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class OpenFileChooserError extends Enum
{

    private static final OpenFileChooserError $VALUES[];
    public static final OpenFileChooserError CANNOT_OPEN_CAPTURE_MECHANISM;
    public static final OpenFileChooserError FILE_NOT_FOUND;
    public static final OpenFileChooserError FILE_SIZE_EXCEEDED;
    public static final OpenFileChooserError MIME_TYPE_NOT_SUPPORTED;
    private static final String TAG = com/amazon/mobile/mash/error/OpenFileChooserError.getSimpleName();
    private int mErrorCode;

    private OpenFileChooserError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static OpenFileChooserError valueOf(String s)
    {
        return (OpenFileChooserError)Enum.valueOf(com/amazon/mobile/mash/error/OpenFileChooserError, s);
    }

    public static OpenFileChooserError[] values()
    {
        return (OpenFileChooserError[])$VALUES.clone();
    }

    public int getCode()
    {
        return mErrorCode;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject;
        OpenFileChooserError aopenfilechoosererror[];
        OpenFileChooserError openfilechoosererror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            aopenfilechoosererror = values();
            j = aopenfilechoosererror.length;
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
        openfilechoosererror = aopenfilechoosererror[i];
        jsonobject.put(openfilechoosererror.name(), openfilechoosererror.getCode());
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
        CANNOT_OPEN_CAPTURE_MECHANISM = new OpenFileChooserError("CANNOT_OPEN_CAPTURE_MECHANISM", 0, 1);
        FILE_SIZE_EXCEEDED = new OpenFileChooserError("FILE_SIZE_EXCEEDED", 1, 2);
        FILE_NOT_FOUND = new OpenFileChooserError("FILE_NOT_FOUND", 2, 3);
        MIME_TYPE_NOT_SUPPORTED = new OpenFileChooserError("MIME_TYPE_NOT_SUPPORTED", 3, 4);
        $VALUES = (new OpenFileChooserError[] {
            CANNOT_OPEN_CAPTURE_MECHANISM, FILE_SIZE_EXCEEDED, FILE_NOT_FOUND, MIME_TYPE_NOT_SUPPORTED
        });
    }
}
