// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import aag;
import aau;
import aaz;
import acy;
import adf;
import adm;
import android.content.Context;
import android.content.SharedPreferences;
import io.fabric.sdk.android.services.common.IdManager;
import java.util.concurrent.atomic.AtomicBoolean;
import zw;

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
    private adm betaSettings;
    private BuildProperties buildProps;
    private Context context;
    private aaz currentTimeProvider;
    private final AtomicBoolean externallyReady;
    private acy httpRequestFactory;
    private IdManager idManager;
    private final AtomicBoolean initialized;
    private long lastCheckTimeMillis;
    private adf preferenceStore;

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
        zw.h().a("Beta", "Performing update check");
        String s = (new aau()).a(context);
        String s1 = idManager.a(s, buildProps.packageName);
        (new CheckForUpdatesRequest(beta, beta.getOverridenSpiEndpoint(), betaSettings.a, httpRequestFactory, new CheckForUpdatesResponseTransform())).invoke(s, s1, buildProps);
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
        zw.h().a("Beta", (new StringBuilder()).append("Check for updates delay: ").append(l1).toString());
        zw.h().a("Beta", (new StringBuilder()).append("Check for updates last check time: ").append(getLastCheckTimeMillis()).toString());
        l1 += getLastCheckTimeMillis();
        zw.h().a("Beta", (new StringBuilder()).append("Check for updates current time: ").append(l).append(", next check time: ").append(l1).toString());
        if (l < l1)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        performUpdateCheck();
        setLastCheckTimeMillis(l);
        return;
        exception1;
        adf1;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        setLastCheckTimeMillis(l);
        throw exception;
        zw.h().a("Beta", "Check for updates next check time was not passed");
        return;
    }

    long getLastCheckTimeMillis()
    {
        return lastCheckTimeMillis;
    }

    public void initialize(Context context1, Beta beta1, IdManager idmanager, adm adm1, BuildProperties buildproperties, adf adf1, aaz aaz1, 
            acy acy)
    {
        context = context1;
        beta = beta1;
        idManager = idmanager;
        betaSettings = adm1;
        buildProps = buildproperties;
        preferenceStore = adf1;
        currentTimeProvider = aaz1;
        httpRequestFactory = acy;
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
