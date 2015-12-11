// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import android.app.Application;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.container.PlayerContainer;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.xfinity.playerlib.model.consumable.WatchableClient;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;
import com.xfinity.playerlib.model.videoplay.adobeplayer.CimAssetFactory;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            MediaLicenseRenewalTask, MediaLicenseClient, MediaLicenseRenewalScheduler, TitaniumTicketClient

public class MediaLicenseRenewalService extends IntentService
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/MediaLicenseRenewalService);
    public static final String NAME = com/xfinity/playerlib/downloads/MediaLicenseRenewalService.getSimpleName();
    private final Application applicationContext = PlayerContainer.getInstance().getApplication();
    private final CimAssetFactory cimAssetFactory = PlayerContainer.getInstance().getCimAssetFactory();
    private final PlayerDownloadServiceManager downloadsManager = PlayerContainer.getInstance().getDownloadServiceManager();
    private final Task entitlementCache = PlayerContainer.getInstance().getNonDegradingVideoEntitlementCache();
    private final HttpClient httpClient = PlayerContainer.getInstance().getHttpClient();
    private final InternetConnection internetConnection = PlayerContainer.getInstance().getInternetConnection();
    private final MediaLicenseClient mediaLicenseClient = PlayerContainer.getInstance().getMediaLicenseClient();
    private final PlayerConfigUtil playerConfigUtil = PlayerContainer.getInstance().getPlayerConfigUtil();
    private final MediaLicenseRenewalScheduler scheduler = PlayerContainer.getInstance().getMediaLicenseRenewalScheduler();
    private final TitaniumTicketClient titaniumTicketClient = PlayerContainer.getInstance().getTitaniumTicketClient();
    private final Executor uiThreadExecutor = PlayerContainer.getInstance().getUiThreadExecutor();
    private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();
    private final WatchableClient watchableClient = PlayerContainer.getInstance().getWatchableClient();

    public MediaLicenseRenewalService()
    {
        super(NAME);
    }

    public static Intent createIntent(Context context)
    {
        return new Intent(context, com/xfinity/playerlib/downloads/MediaLicenseRenewalService);
    }

    protected void onHandleIntent(Intent intent)
    {
        try
        {
            (new MediaLicenseRenewalTask(internetConnection, downloadsManager, userManager, entitlementCache, titaniumTicketClient, mediaLicenseClient, watchableClient, scheduler, applicationContext, httpClient, cimAssetFactory, playerConfigUtil, uiThreadExecutor)).run();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            LOG.error("Caught exception trying to renew licenses", intent);
        }
    }

}
