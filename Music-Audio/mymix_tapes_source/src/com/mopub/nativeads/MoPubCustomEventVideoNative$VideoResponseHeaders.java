// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import java.util.Map;

// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

static class mHeadersAreValid
{

    private boolean mHeadersAreValid;
    private int mImpressionMinVisiblePercent;
    private int mImpressionVisibleMs;
    private int mMaxBufferMs;
    private int mPauseVisiblePercent;
    private int mPlayVisiblePercent;

    int getImpressionMinVisiblePercent()
    {
        return mImpressionMinVisiblePercent;
    }

    int getImpressionVisibleMs()
    {
        return mImpressionVisibleMs;
    }

    int getMaxBufferMs()
    {
        return mMaxBufferMs;
    }

    int getPauseVisiblePercent()
    {
        return mPauseVisiblePercent;
    }

    int getPlayVisiblePercent()
    {
        return mPlayVisiblePercent;
    }

    boolean hasValidHeaders()
    {
        return mHeadersAreValid;
    }

    (Map map)
    {
        try
        {
            mPlayVisiblePercent = Integer.parseInt((String)map.get("Play-Visible-Percent"));
            mPauseVisiblePercent = Integer.parseInt((String)map.get("Pause-Visible-Percent"));
            mImpressionMinVisiblePercent = Integer.parseInt((String)map.get("Impression-Min-Visible-Percent"));
            mImpressionVisibleMs = Integer.parseInt((String)map.get("Impression-Visible-Ms"));
            mMaxBufferMs = Integer.parseInt((String)map.get("Max-Buffer-Ms"));
            mHeadersAreValid = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            mHeadersAreValid = false;
        }
    }
}
