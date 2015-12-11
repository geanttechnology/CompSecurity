// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mobile.mash.error;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class VideoError extends Enum
{

    private static final VideoError $VALUES[];
    public static final VideoError NO_VIDEO_PLAYER_FOUND;
    private static final String TAG = com/amazon/mobile/mash/error/VideoError.getSimpleName();
    private int mErrorCode;

    private VideoError(String s, int i, int j)
    {
        super(s, i);
        mErrorCode = j;
    }

    public static VideoError valueOf(String s)
    {
        return (VideoError)Enum.valueOf(com/amazon/mobile/mash/error/VideoError, s);
    }

    public static VideoError[] values()
    {
        return (VideoError[])$VALUES.clone();
    }

    public int getCode()
    {
        return mErrorCode;
    }

    public JSONObject toJSONObject()
    {
        JSONObject jsonobject;
        VideoError avideoerror[];
        VideoError videoerror;
        int i;
        int j;
        try
        {
            jsonobject = new JSONObject();
            avideoerror = values();
            j = avideoerror.length;
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
        videoerror = avideoerror[i];
        jsonobject.put(videoerror.name(), videoerror.getCode());
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
        NO_VIDEO_PLAYER_FOUND = new VideoError("NO_VIDEO_PLAYER_FOUND", 0, 1);
        $VALUES = (new VideoError[] {
            NO_VIDEO_PLAYER_FOUND
        });
    }
}
