// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities.visual;

import android.app.Activity;
import android.os.Bundle;
import com.moodstocks.android.MoodstocksError;
import com.moodstocks.android.Scanner;
import com.shazam.android.ae.m;
import com.shazam.android.ai.a;
import com.shazam.android.ai.e;
import com.shazam.android.aspects.b.a.b;
import com.shazam.android.visual.q;
import com.shazam.i.b.ah.f;
import com.shazam.i.b.c;
import com.shazam.model.configuration.MoodstocksConfiguration;
import com.shazam.model.configuration.visual.VisualShazamConfiguration;
import com.shazam.model.visual.VisualShazamProvider;
import com.shazam.model.visual.moodstocks.MoodstocksApiInfo;

public class MoodStocksInitializationAspect extends b
{

    private static final String API_SECRET = "0123456789abcdef";
    private boolean compatible;
    private final com.shazam.android.ai.b moodStocksBundleLoader = new a(c.a(), f.a());
    private final e moodStocksManager = com.shazam.i.b.aw.b.c();
    private final MoodstocksConfiguration moodstocksConfiguration = com.shazam.i.b.n.b.O();
    private Scanner scanner;
    private final VisualShazamConfiguration visualShazamConfiguration = com.shazam.i.b.n.b.N();

    public MoodStocksInitializationAspect()
    {
    }

    private boolean isEnabled()
    {
        return visualShazamConfiguration.a(VisualShazamProvider.MOODSTOCKS);
    }

    private boolean loadOfflineBundle(MoodstocksApiInfo moodstocksapiinfo)
    {
        if (moodStocksBundleLoader.a(scanner, moodstocksapiinfo))
        {
            moodStocksManager.d = true;
            return true;
        } else
        {
            return false;
        }
    }

    private void openScanner(Activity activity, MoodstocksApiInfo moodstocksapiinfo)
    {
        activity = Scanner.pathFromFilesDir(activity, "scanner.db");
        scanner.open(activity, moodstocksapiinfo.apiKey, "0123456789abcdef");
    }

    private boolean setSyncProxy(MoodstocksApiInfo moodstocksapiinfo)
    {
        moodstocksapiinfo = moodstocksapiinfo.syncProxy;
        if (com.shazam.b.e.a.c(moodstocksapiinfo))
        {
            scanner.setSyncProxy(moodstocksapiinfo);
            return true;
        } else
        {
            return false;
        }
    }

    public void onCreate(com.shazam.android.aspects.c.a.a a1, Bundle bundle)
    {
        boolean flag;
        if (com.shazam.android.util.e.a() && isEnabled() && Scanner.isCompatible())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            compatible = flag;
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            m.a(this, "Could not ascertain if Moodstocks is compatible with device", bundle);
        }
        if (compatible) goto _L2; else goto _L1
_L1:
        moodStocksManager.a();
_L4:
        return;
_L2:
        boolean flag1;
        boolean flag2;
        bundle = moodstocksConfiguration.a();
        scanner = Scanner.get();
        flag1 = setSyncProxy(bundle);
        openScanner(a1, bundle);
        flag2 = loadOfflineBundle(bundle);
        if (flag1 || flag2)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        try
        {
            scanner.close();
            scanner.destroy();
            scanner = null;
            moodStocksManager.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (com.shazam.android.aspects.c.a.a a1)
        {
            a1 = moodStocksManager;
        }
        a1.c = com.shazam.android.ai.e.b.c;
        if (!((e) (a1)).e) goto _L4; else goto _L3
_L3:
        ((e) (a1)).b.b(a1);
        return;
        a1 = moodStocksManager;
        a1.c = com.shazam.android.ai.e.b.b;
        if (!((e) (a1)).d && ((e) (a1)).e)
        {
            ((e) (a1)).b.a(a1);
            return;
        }
          goto _L4
    }

    public void onDestroy(com.shazam.android.aspects.c.a.a a1)
    {
        if (!compatible || scanner == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        scanner.close();
        scanner.destroy();
        scanner = null;
        return;
        a1;
    }
}
