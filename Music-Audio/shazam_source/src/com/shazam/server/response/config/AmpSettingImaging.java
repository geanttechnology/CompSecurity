// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;

// Referenced classes of package com.shazam.server.response.config:
//            AmpSetting, MoodstocksAmpSetting

public class AmpSettingImaging
    implements Serializable
{

    private AmpSetting digimarc;
    private MoodstocksAmpSetting moodstocks;

    private AmpSettingImaging()
    {
    }

    private AmpSettingImaging(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        digimarc = Builder.access._mth000(builder);
        moodstocks = Builder.access._mth100(builder);
    }

    AmpSettingImaging(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public AmpSetting getDigimarc()
    {
        if (digimarc != null)
        {
            return digimarc;
        } else
        {
            return AmpSetting.Builder.ampSetting().build();
        }
    }

    public MoodstocksAmpSetting getMoodstocks()
    {
        if (moodstocks != null)
        {
            return moodstocks;
        } else
        {
            return MoodstocksAmpSetting.Builder.moodstocksAmpSetting().build();
        }
    }
}
