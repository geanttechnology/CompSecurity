// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ai;

import com.shazam.android.aq.c;
import com.shazam.model.configuration.MoodstocksConfiguration;
import com.shazam.model.visual.moodstocks.MoodstocksApiInfo;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSettingImaging;
import com.shazam.server.response.config.AmpSettings;
import com.shazam.server.response.config.MoodstocksAmpSetting;

public final class a
    implements MoodstocksConfiguration
{

    private final c a;

    public a(c c1)
    {
        a = c1;
    }

    public final MoodstocksApiInfo a()
    {
        MoodstocksAmpSetting moodstocksampsetting = a.a().getSettings().getImaging().getMoodstocks();
        com.shazam.model.visual.moodstocks.MoodstocksApiInfo.Builder builder = com.shazam.model.visual.moodstocks.MoodstocksApiInfo.Builder.a();
        builder.apiKey = moodstocksampsetting.getApiKey();
        builder.bundle = moodstocksampsetting.getBundle();
        builder.syncProxy = moodstocksampsetting.getSyncProxy();
        long l;
        if (moodstocksampsetting.getExpiry() != null)
        {
            l = moodstocksampsetting.getExpiry().longValue();
        } else
        {
            l = 0x2932e00L;
        }
        builder.expiry = l;
        return new MoodstocksApiInfo(builder, null);
    }
}
