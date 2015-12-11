// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.j.ai;

import com.shazam.android.aq.c;
import com.shazam.b.e.a;
import com.shazam.model.configuration.visual.VisualShazamConfiguration;
import com.shazam.model.visual.VisualShazamProvider;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpHome;
import com.shazam.server.response.config.AmpSetting;
import com.shazam.server.response.config.AmpSettingImaging;
import com.shazam.server.response.config.AmpSettings;
import com.shazam.server.response.config.AmpStyles;
import com.shazam.server.response.config.AmpVisual;
import com.shazam.server.response.config.MoodstocksAmpSetting;
import java.util.List;

public final class b
    implements VisualShazamConfiguration
{

    private final c a;
    private final List b;

    public b(c c1, List list)
    {
        a = c1;
        b = list;
    }

    private AmpConfig c()
    {
        return a.a();
    }

    public final float a()
    {
        Float float1 = c().getAmpStyles().getAmpHome().getTooltippingPoint();
        if (float1 != null)
        {
            return float1.floatValue();
        } else
        {
            return 0.2F;
        }
    }

    public final boolean a(VisualShazamProvider visualshazamprovider)
    {
        AmpSettingImaging ampsettingimaging = c().getSettings().getImaging();
        com.shazam.android.j.ai._cls1.a[visualshazamprovider.ordinal()];
        JVM INSTR tableswitch 1 2: default 40
    //                   1 42
    //                   2 50;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        return ampsettingimaging.getDigimarc().isEnabled();
_L3:
        visualshazamprovider = ampsettingimaging.getMoodstocks();
        if (visualshazamprovider.isEnabled() && com.shazam.b.e.a.c(visualshazamprovider.getApiKey()))
        {
            return true;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final List b()
    {
        List list = c().getAmpStyles().getAmpVisual().getBarText();
        if (!list.isEmpty())
        {
            return list;
        } else
        {
            return b;
        }
    }

    /* member class not found */
    class _cls1 {}

}
