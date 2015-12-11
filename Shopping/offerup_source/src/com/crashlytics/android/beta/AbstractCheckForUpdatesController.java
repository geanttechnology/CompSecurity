// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import android.content.Context;
import android.content.SharedPreferences;
import c.a.a.a.a.b.j;
import c.a.a.a.a.b.r;
import c.a.a.a.a.b.x;
import c.a.a.a.a.e.a;
import c.a.a.a.a.f.c;
import c.a.a.a.a.g.f;
import c.a.a.a.e;
import c.a.a.a.q;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.crashlytics.android.beta:
//            UpdatesController, BuildProperties, CheckForUpdatesRequest, Beta, 
//            CheckForUpdatesResponseTransform

abstract class AbstractCheckForUpdatesController
    implements UpdatesController
{

    static final long LAST_UPDATE_CHECK_DEFAULT = 0L;
    static final String LAST_UPDATE_CHECK_KEY = "last_update_check";
    private static final long MILLIS_PER_SECOND = 1000L;
    private Beta beta;
    private f betaSettings;
    private BuildProperties buildProps;
    private Context context;
    private r currentTimeProvider;
    private final AtomicBoolean externallyReady;
    private a httpRequestFactory$6bbea658;
    private x idManager;
    private final AtomicBoolean initialized;
    private long lastCheckTimeMillis;
    private c preferenceStore;

    public AbstractCheckForUpdatesController()
    {
        this(false);
    }

    public AbstractCheckForUpdatesController(boolean flag)
    {
        initialized = new AtomicBoolean();
        lastCheckTimeMillis = 0L;
        externallyReady = new AtomicBoolean(flag);
    }

    private void performUpdateCheck()
    {
        e.d().a("Beta", "Performing update check");
        String s = (new j()).a(context);
        String s1 = idManager.a(s, buildProps.packageName);
        (new CheckForUpdatesRequest(beta, beta.getOverridenSpiEndpoint(), betaSettings.a, httpRequestFactory$6bbea658, new CheckForUpdatesResponseTransform())).invoke(s, s1, buildProps);
    }

    protected void checkForUpdates()
    {
        long l;
        synchronized (preferenceStore)
        {
            if (preferenceStore.a().contains("last_update_check"))
            {
                preferenceStore.a(preferenceStore.b().remove("last_update_check"));
            }
        }
        l = currentTimeProvider.a();
        long l1 = (long)betaSettings.b * 1000L;
        e.d().a("Beta", (new StringBuilder("Check for updates delay: ")).append(l1).toString());
        e.d().a("Beta", (new StringBuilder("Check for updates last check time: ")).append(getLastCheckTimeMillis()).toString());
        l1 += getLastCheckTimeMillis();
        e.d().a("Beta", (new StringBuilder("Check for updates current time: ")).append(l).append(", next check time: ").append(l1).toString());
        if (l < l1)
        {
            break MISSING_BLOCK_LABEL_195;
        }
        performUpdateCheck();
        setLastCheckTimeMillis(l);
        return;
        exception1;
        c1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        setLastCheckTimeMillis(l);
        throw exception;
        e.d().a("Beta", "Check for updates next check time was not passed");
        return;
    }

    long getLastCheckTimeMillis()
    {
        return lastCheckTimeMillis;
    }

    public void initialize$c689b02(Context context1, Beta beta1, x x1, f f1, BuildProperties buildproperties, c c1, r r1, 
            a a)
    {
        context = context1;
        beta = beta1;
        idManager = x1;
        betaSettings = f1;
        buildProps = buildproperties;
        preferenceStore = c1;
        currentTimeProvider = r1;
        httpRequestFactory$6bbea658 = a;
        if (signalInitialized())
        {
            checkForUpdates();
        }
    }

    void setLastCheckTimeMillis(long l)
    {
        lastCheckTimeMillis = l;
    }

    protected boolean signalExternallyReady()
    {
        externallyReady.set(true);
        return initialized.get();
    }

    boolean signalInitialized()
    {
        initialized.set(true);
        return externallyReady.get();
    }
}
