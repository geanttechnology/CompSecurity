// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.visual;

import android.os.Bundle;
import com.digimarc.dms.DMSManager;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.q.c;
import com.shazam.android.util.e;
import com.shazam.android.visual.q;
import com.shazam.i.b.s.a;
import com.shazam.model.configuration.visual.VisualShazamConfiguration;
import com.shazam.model.visual.VisualShazamProvider;

public class DigimarcInitializationAspect extends b
{

    private final com.shazam.android.q.b digimarcVisualShazamManager = com.shazam.i.b.aw.b.b();
    private final c dmsReaderConfigProvider = a.a();
    private final VisualShazamConfiguration visualShazamConfiguration = com.shazam.i.b.n.b.N();

    public DigimarcInitializationAspect()
    {
    }

    private boolean isEnabled()
    {
        return visualShazamConfiguration.a(VisualShazamProvider.DIGIMARC);
    }

    public void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle)
    {
        if (!e.a() || !isEnabled())
        {
            a1 = digimarcVisualShazamManager;
            a1.b = com.shazam.android.q.b.c.c;
            if (((com.shazam.android.q.b) (a1)).d)
            {
                ((com.shazam.android.q.b) (a1)).c.c(a1);
            }
        } else
        {
label0:
            {
                a1 = DMSManager.getInstance();
                bundle = dmsReaderConfigProvider.a();
                try
                {
                    if (!a1.loadReadersConfigFromJSONString(bundle))
                    {
                        break label0;
                    }
                    a1.setImageProfile(com.digimarc.dms.DMSIBase.DMS_PROFILES.HIGH);
                    bundle = digimarcVisualShazamManager;
                    bundle.a = a1;
                    bundle.c();
                    bundle.b = com.shazam.android.q.b.c.b;
                    if (((com.shazam.android.q.b) (bundle)).d)
                    {
                        ((com.shazam.android.q.b) (bundle)).c.a(bundle);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (com.shazam.android.aspects.c.a.a a1)
                {
                    digimarcVisualShazamManager.a();
                    return;
                }
            }
        }
        return;
        digimarcVisualShazamManager.a();
        return;
    }
}
