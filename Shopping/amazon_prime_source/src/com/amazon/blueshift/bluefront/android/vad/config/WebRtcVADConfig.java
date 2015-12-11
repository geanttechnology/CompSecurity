// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.vad.config;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

// Referenced classes of package com.amazon.blueshift.bluefront.android.vad.config:
//            VADConfig

public final class WebRtcVADConfig extends VADConfig
{
    public static class Aggression
    {

        private final int mGlobalThreshold;
        private final int mLocalThreshold;
        private final int mOverHangMax1;
        private final int mOverHangMax2;

        public int getGlobalThreshold()
        {
            return mGlobalThreshold;
        }

        public int getLocalThreshold()
        {
            return mLocalThreshold;
        }

        public int getOverHangMax1()
        {
            return mOverHangMax1;
        }

        public int getOverHangMax2()
        {
            return mOverHangMax2;
        }

        public Aggression(int i, int j, int k, int l)
        {
            boolean flag1 = true;
            super();
            boolean flag;
            if (i > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "OverHangMax1 must be positive.");
            if (j > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "OverHangMax2 must be positive.");
            if (k > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "LocalThreshold must be positive.");
            if (l > 0)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            Preconditions.checkArgument(flag, "GlobalThreshold must be positive.");
            mOverHangMax1 = i;
            mOverHangMax2 = j;
            mLocalThreshold = k;
            mGlobalThreshold = l;
        }
    }

    public static final class AggressionMode extends Enum
    {

        private static final AggressionMode $VALUES[];
        public static final AggressionMode AGGRESSIVE;
        public static final AggressionMode LOW_BITRATE;
        public static final AggressionMode QUALITY;
        public static final AggressionMode VERY_AGGRESSIVE;

        public static AggressionMode valueOf(String s)
        {
            return (AggressionMode)Enum.valueOf(com/amazon/blueshift/bluefront/android/vad/config/WebRtcVADConfig$AggressionMode, s);
        }

        public static AggressionMode[] values()
        {
            return (AggressionMode[])$VALUES.clone();
        }

        static 
        {
            QUALITY = new AggressionMode("QUALITY", 0);
            LOW_BITRATE = new AggressionMode("LOW_BITRATE", 1);
            AGGRESSIVE = new AggressionMode("AGGRESSIVE", 2);
            VERY_AGGRESSIVE = new AggressionMode("VERY_AGGRESSIVE", 3);
            $VALUES = (new AggressionMode[] {
                QUALITY, LOW_BITRATE, AGGRESSIVE, VERY_AGGRESSIVE
            });
        }

        private AggressionMode(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int DEFAULT_ENDPOINTING_THRESHOLD = 50;
    public static final int DEFAULT_STARTPOINTING_THRESHOLD = 26;
    private AggressionMode mAggressionMode;
    private Optional mCustomizedAggresion;

    public WebRtcVADConfig()
    {
        super(26, 50);
        mAggressionMode = AggressionMode.VERY_AGGRESSIVE;
        mCustomizedAggresion = Optional.absent();
    }

    public WebRtcVADConfig(Aggression aggression, int i, int j)
    {
        super(i, j);
        mAggressionMode = AggressionMode.VERY_AGGRESSIVE;
        mCustomizedAggresion = Optional.absent();
        mCustomizedAggresion = Optional.fromNullable(aggression);
    }

    public WebRtcVADConfig(AggressionMode aggressionmode, int i, int j)
    {
        super(i, j);
        mAggressionMode = AggressionMode.VERY_AGGRESSIVE;
        mCustomizedAggresion = Optional.absent();
        Preconditions.checkNotNull(aggressionmode, "Aggression mode cannot be null.");
        mAggressionMode = aggressionmode;
    }

    public AggressionMode getAggressionMode()
    {
        return mAggressionMode;
    }

    public Optional getCustomizedAggression()
    {
        return mCustomizedAggresion;
    }
}
