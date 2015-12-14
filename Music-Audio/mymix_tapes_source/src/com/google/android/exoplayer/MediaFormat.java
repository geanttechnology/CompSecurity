// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import com.google.android.exoplayer.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class MediaFormat
{

    private static final String KEY_PIXEL_WIDTH_HEIGHT_RATIO = "com.google.android.videos.pixelWidthHeightRatio";
    public static final int NO_VALUE = -1;
    public final int channelCount;
    public final long durationUs;
    private android.media.MediaFormat frameworkMediaFormat;
    private int hashCode;
    public final int height;
    public final List initializationData;
    private int maxHeight;
    public final int maxInputSize;
    private int maxWidth;
    public final String mimeType;
    public final float pixelWidthHeightRatio;
    public final int sampleRate;
    public final int width;

    private MediaFormat(android.media.MediaFormat mediaformat)
    {
        frameworkMediaFormat = mediaformat;
        mimeType = mediaformat.getString("mime");
        maxInputSize = getOptionalIntegerV16(mediaformat, "max-input-size");
        width = getOptionalIntegerV16(mediaformat, "width");
        height = getOptionalIntegerV16(mediaformat, "height");
        channelCount = getOptionalIntegerV16(mediaformat, "channel-count");
        sampleRate = getOptionalIntegerV16(mediaformat, "sample-rate");
        pixelWidthHeightRatio = getOptionalFloatV16(mediaformat, "com.google.android.videos.pixelWidthHeightRatio");
        initializationData = new ArrayList();
        for (int i = 0; mediaformat.containsKey((new StringBuilder()).append("csd-").append(i).toString()); i++)
        {
            ByteBuffer bytebuffer = mediaformat.getByteBuffer((new StringBuilder()).append("csd-").append(i).toString());
            byte abyte0[] = new byte[bytebuffer.limit()];
            bytebuffer.get(abyte0);
            initializationData.add(abyte0);
            bytebuffer.flip();
        }

        long l;
        if (mediaformat.containsKey("durationUs"))
        {
            l = mediaformat.getLong("durationUs");
        } else
        {
            l = -1L;
        }
        durationUs = l;
        maxWidth = -1;
        maxHeight = -1;
    }

    private MediaFormat(String s, int i, long l, int j, int k, float f, 
            int i1, int j1, List list)
    {
        mimeType = s;
        maxInputSize = i;
        durationUs = l;
        width = j;
        height = k;
        pixelWidthHeightRatio = f;
        channelCount = i1;
        sampleRate = j1;
        s = list;
        if (list == null)
        {
            s = Collections.emptyList();
        }
        initializationData = s;
        maxWidth = -1;
        maxHeight = -1;
    }

    public static MediaFormat createAudioFormat(String s, int i, int j, int k, List list)
    {
        return createAudioFormat(s, i, -1L, j, k, list);
    }

    public static MediaFormat createAudioFormat(String s, int i, long l, int j, int k, List list)
    {
        return new MediaFormat(s, i, l, -1, -1, -1F, j, k, list);
    }

    public static MediaFormat createFormatForMimeType(String s)
    {
        return createFormatForMimeType(s, -1L);
    }

    public static MediaFormat createFormatForMimeType(String s, long l)
    {
        return new MediaFormat(s, -1, l, -1, -1, -1F, -1, -1, null);
    }

    public static MediaFormat createFromFrameworkMediaFormatV16(android.media.MediaFormat mediaformat)
    {
        return new MediaFormat(mediaformat);
    }

    public static MediaFormat createTextFormat(String s)
    {
        return createTextFormat(s, -1L);
    }

    public static MediaFormat createTextFormat(String s, long l)
    {
        return createFormatForMimeType(s, l);
    }

    public static MediaFormat createVideoFormat(String s, int i, int j, int k, List list)
    {
        return createVideoFormat(s, i, -1L, j, k, list);
    }

    public static MediaFormat createVideoFormat(String s, int i, long l, int j, int k, float f, List list)
    {
        return new MediaFormat(s, i, l, j, k, f, -1, -1, list);
    }

    public static MediaFormat createVideoFormat(String s, int i, long l, int j, int k, List list)
    {
        return createVideoFormat(s, i, l, j, k, 1.0F, list);
    }

    private boolean equalsInternal(MediaFormat mediaformat, boolean flag)
    {
        if (maxInputSize != mediaformat.maxInputSize || width != mediaformat.width || height != mediaformat.height || pixelWidthHeightRatio != mediaformat.pixelWidthHeightRatio || !flag && (maxWidth != mediaformat.maxWidth || maxHeight != mediaformat.maxHeight) || channelCount != mediaformat.channelCount || sampleRate != mediaformat.sampleRate || !Util.areEqual(mimeType, mediaformat.mimeType) || initializationData.size() != mediaformat.initializationData.size())
        {
            return false;
        }
        for (int i = 0; i < initializationData.size(); i++)
        {
            if (!Arrays.equals((byte[])initializationData.get(i), (byte[])mediaformat.initializationData.get(i)))
            {
                return false;
            }
        }

        return true;
    }

    private static final float getOptionalFloatV16(android.media.MediaFormat mediaformat, String s)
    {
        if (mediaformat.containsKey(s))
        {
            return mediaformat.getFloat(s);
        } else
        {
            return -1F;
        }
    }

    private static final int getOptionalIntegerV16(android.media.MediaFormat mediaformat, String s)
    {
        if (mediaformat.containsKey(s))
        {
            return mediaformat.getInteger(s);
        } else
        {
            return -1;
        }
    }

    private static final void maybeSetFloatV16(android.media.MediaFormat mediaformat, String s, float f)
    {
        if (f != -1F)
        {
            mediaformat.setFloat(s, f);
        }
    }

    private static final void maybeSetIntegerV16(android.media.MediaFormat mediaformat, String s, int i)
    {
        if (i != -1)
        {
            mediaformat.setInteger(s, i);
        }
    }

    private final void maybeSetMaxDimensionsV16(android.media.MediaFormat mediaformat)
    {
        maybeSetIntegerV16(mediaformat, "max-width", maxWidth);
        maybeSetIntegerV16(mediaformat, "max-height", maxHeight);
    }

    public boolean equals(MediaFormat mediaformat, boolean flag)
    {
        if (this == mediaformat)
        {
            return true;
        }
        if (mediaformat == null)
        {
            return false;
        } else
        {
            return equalsInternal(mediaformat, flag);
        }
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag;
        if (this == obj)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (obj != null)
            {
                flag = flag1;
                if (getClass() == obj.getClass())
                {
                    return equalsInternal((MediaFormat)obj, false);
                }
            }
        }
        return flag;
    }

    public final android.media.MediaFormat getFrameworkMediaFormatV16()
    {
        if (frameworkMediaFormat == null)
        {
            android.media.MediaFormat mediaformat = new android.media.MediaFormat();
            mediaformat.setString("mime", mimeType);
            maybeSetIntegerV16(mediaformat, "max-input-size", maxInputSize);
            maybeSetIntegerV16(mediaformat, "width", width);
            maybeSetIntegerV16(mediaformat, "height", height);
            maybeSetIntegerV16(mediaformat, "channel-count", channelCount);
            maybeSetIntegerV16(mediaformat, "sample-rate", sampleRate);
            maybeSetFloatV16(mediaformat, "com.google.android.videos.pixelWidthHeightRatio", pixelWidthHeightRatio);
            for (int i = 0; i < initializationData.size(); i++)
            {
                mediaformat.setByteBuffer((new StringBuilder()).append("csd-").append(i).toString(), ByteBuffer.wrap((byte[])initializationData.get(i)));
            }

            if (durationUs != -1L)
            {
                mediaformat.setLong("durationUs", durationUs);
            }
            maybeSetMaxDimensionsV16(mediaformat);
            frameworkMediaFormat = mediaformat;
        }
        return frameworkMediaFormat;
    }

    public int getMaxVideoHeight()
    {
        return maxHeight;
    }

    public int getMaxVideoWidth()
    {
        return maxWidth;
    }

    public int hashCode()
    {
        if (hashCode == 0)
        {
            int i;
            int j;
            if (mimeType == null)
            {
                i = 0;
            } else
            {
                i = mimeType.hashCode();
            }
            j = (((((((((i + 527) * 31 + maxInputSize) * 31 + width) * 31 + height) * 31 + Float.floatToRawIntBits(pixelWidthHeightRatio)) * 31 + (int)durationUs) * 31 + maxWidth) * 31 + maxHeight) * 31 + channelCount) * 31 + sampleRate;
            for (i = 0; i < initializationData.size(); i++)
            {
                j = j * 31 + Arrays.hashCode((byte[])initializationData.get(i));
            }

            hashCode = j;
        }
        return hashCode;
    }

    public void setMaxVideoDimensions(int i, int j)
    {
        maxWidth = i;
        maxHeight = j;
        if (frameworkMediaFormat != null)
        {
            maybeSetMaxDimensionsV16(frameworkMediaFormat);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("MediaFormat(").append(mimeType).append(", ").append(maxInputSize).append(", ").append(width).append(", ").append(height).append(", ").append(pixelWidthHeightRatio).append(", ").append(channelCount).append(", ").append(sampleRate).append(", ").append(durationUs).append(", ").append(maxWidth).append(", ").append(maxHeight).append(")").toString();
    }
}
