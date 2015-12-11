// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ah;

import android.app.ActivityManager;
import com.shazam.android.aq.c;
import com.shazam.android.j.af.f;
import com.shazam.server.response.config.AmpConfig;
import com.shazam.server.response.config.AmpSetting;
import com.shazam.server.response.config.AmpSettings;

// Referenced classes of package com.shazam.android.ah:
//            d

public final class e
{

    public static d a(c c1, f f1, ActivityManager activitymanager, d d1)
    {
        int i;
        if (!c1.a().getSettings().getWatermarking().isEnabled() || f1.a() != 44100)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        i = activitymanager.getMemoryClass();
        if (i >= 60)
        {
            return d1;
        }
        break MISSING_BLOCK_LABEL_45;
        c1;
        return d.a;
    }
}
