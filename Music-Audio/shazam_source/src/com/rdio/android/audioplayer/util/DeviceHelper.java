// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.util;

import android.content.Context;
import android.media.AudioManager;

public class DeviceHelper
{

    private static int bufferSize;
    private static boolean hasNativePlaybackParams;
    private static int sampleRate;

    public DeviceHelper()
    {
    }

    public static int getNativeBufferSizeFrames(Context context)
    {
        getNativePlaybackParams(context);
        return bufferSize;
    }

    private static boolean getNativePlaybackParams(Context context)
    {
        if (!hasNativePlaybackParams)
        {
            boolean flag;
            if (android.os.Build.VERSION.SDK_INT >= 17)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            hasNativePlaybackParams = flag;
            sampleRate = 0;
            bufferSize = 0;
            if (hasNativePlaybackParams)
            {
                context = (AudioManager)context.getSystemService("audio");
                if (context != null)
                {
                    sampleRate = Integer.parseInt(context.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
                    bufferSize = Integer.parseInt(context.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER"));
                }
            }
        }
        return hasNativePlaybackParams;
    }

    public static int getPlaybackNumFramesFactor()
    {
        return 4;
    }

    public static boolean hasJellyBeanMr2()
    {
        return android.os.Build.VERSION.SDK_INT >= 18;
    }

    public static boolean isMediaDecoderReconfigurable()
    {
        return hasJellyBeanMr2();
    }
}
