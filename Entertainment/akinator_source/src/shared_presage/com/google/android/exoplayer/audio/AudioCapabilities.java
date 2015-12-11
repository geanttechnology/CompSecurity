// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.android.exoplayer.audio;

import java.util.Arrays;

public final class AudioCapabilities
{

    private final int maxChannelCount;
    private final int supportedEncodings[];

    public AudioCapabilities(int ai[], int i)
    {
        if (ai != null)
        {
            supportedEncodings = Arrays.copyOf(ai, ai.length);
            Arrays.sort(supportedEncodings);
        } else
        {
            supportedEncodings = new int[0];
        }
        maxChannelCount = i;
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (!(obj instanceof AudioCapabilities))
            {
                return false;
            }
            obj = (AudioCapabilities)obj;
            if (!Arrays.equals(supportedEncodings, ((AudioCapabilities) (obj)).supportedEncodings) || maxChannelCount != ((AudioCapabilities) (obj)).maxChannelCount)
            {
                return false;
            }
        }
        return true;
    }

    public final int getMaxChannelCount()
    {
        return maxChannelCount;
    }

    public final int hashCode()
    {
        return maxChannelCount + Arrays.hashCode(supportedEncodings) * 31;
    }

    public final boolean supportsEncoding(int i)
    {
        return Arrays.binarySearch(supportedEncodings, i) >= 0;
    }

    public final String toString()
    {
        return (new StringBuilder("AudioCapabilities[maxChannelCount=")).append(maxChannelCount).append(", supportedEncodings=").append(Arrays.toString(supportedEncodings)).append("]").toString();
    }
}
