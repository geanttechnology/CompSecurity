// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import com.amazon.gallery.foundation.utils.thread.NamedThreadPoolFactory;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.network.cds.CloudDriveServiceClientFactory;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.concurrent.ExecutorService;
import org.apache.commons.lang3.StringUtils;

public class CloudDriveServiceClientManager
    implements AccountChangeListener
{

    private static final String BACKGROUND_EXECUTOR_THREAD_PREFIX = (new StringBuilder()).append(com/amazon/gallery/thor/cds/CloudDriveServiceClientManager.getSimpleName()).append(" BGThread").toString();
    private static final String FOREGROUND_EXECUTOR_THREAD_PREFIX = (new StringBuilder()).append(com/amazon/gallery/thor/cds/CloudDriveServiceClientManager.getSimpleName()).append(" FGThread").toString();
    private final AuthenticationManager authenticationManager;
    private MixtapeCloudDriveServiceClient backgroundClient;
    private ExecutorService backgroundExecutor;
    private final CloudDriveServiceClientFactory cdsClientFactory;
    private MixtapeCloudDriveServiceClient foregroundClient;
    private ExecutorService foregroundExecutor;

    public CloudDriveServiceClientManager(CloudDriveServiceClientFactory clouddriveserviceclientfactory, AuthenticationManager authenticationmanager)
    {
        cdsClientFactory = clouddriveserviceclientfactory;
        authenticationManager = authenticationmanager;
    }

    public MixtapeCloudDriveServiceClient getBackgroundCdsClient()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = authenticationManager.getAccountId();
        if (StringUtils.isEmpty(((CharSequence) (obj))))
        {
            throw new IllegalStateException("No user account found.");
        }
        break MISSING_BLOCK_LABEL_34;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (backgroundExecutor == null || backgroundExecutor.isShutdown())
        {
            backgroundExecutor = NamedThreadPoolFactory.newFixedThreadPoolExecutor(3, 2, BACKGROUND_EXECUTOR_THREAD_PREFIX, null);
        }
        if (backgroundClient == null)
        {
            backgroundClient = cdsClientFactory.getCloudDriveExtendedClient(((String) (obj)), backgroundExecutor);
        }
        obj = backgroundClient;
        this;
        JVM INSTR monitorexit ;
        return ((MixtapeCloudDriveServiceClient) (obj));
    }

    public MixtapeCloudDriveServiceClient getBackgroundCdsClient(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (!StringUtils.isNotEmpty(authenticationManager.getAccountId()) || !authenticationManager.getAccountId().equals(s)) goto _L2; else goto _L1
_L1:
        s = getBackgroundCdsClient();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = cdsClientFactory.getCloudDriveExtendedClient(s, backgroundExecutor);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public MixtapeCloudDriveServiceClient getForegroundCdsClient()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = authenticationManager.getAccountId();
        if (StringUtils.isEmpty(((CharSequence) (obj))))
        {
            throw new IllegalStateException("No user account found.");
        }
        break MISSING_BLOCK_LABEL_34;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (foregroundExecutor == null || foregroundExecutor.isShutdown())
        {
            foregroundExecutor = NamedThreadPoolFactory.newFixedThreadPoolExecutor(5, 4, FOREGROUND_EXECUTOR_THREAD_PREFIX, null);
        }
        if (foregroundClient == null)
        {
            foregroundClient = cdsClientFactory.getCloudDriveExtendedClient(((String) (obj)), foregroundExecutor);
        }
        obj = foregroundClient;
        this;
        JVM INSTR monitorexit ;
        return ((MixtapeCloudDriveServiceClient) (obj));
    }

    public void onAccountDeregistered()
    {
        if (foregroundExecutor != null)
        {
            foregroundExecutor.shutdown();
        }
        if (backgroundExecutor != null)
        {
            backgroundExecutor.shutdown();
        }
        foregroundClient = null;
        backgroundClient = null;
    }

    public void onAccountRegistered()
    {
    }

}
