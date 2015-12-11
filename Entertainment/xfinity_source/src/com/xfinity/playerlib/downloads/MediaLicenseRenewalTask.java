// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.downloads;

import android.app.Application;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.http.exceptions.CimIOException;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.cim.cmasl.xip.ams.AmsHttpErrorException;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.primetime.android.enums.DrmWorkflow;
import com.comcast.playerplatform.primetime.android.player.PlayerPlatformAPI;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.google.common.util.concurrent.SettableFuture;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.WatchableClient;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;
import com.xfinity.playerlib.model.videoplay.adobeplayer.CimAssetFactory;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.downloads:
//            MediaLicenseRenewalScheduler, TitaniumTicketClient, MediaLicenseClient

public class MediaLicenseRenewalTask
    implements Runnable
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/downloads/MediaLicenseRenewalTask);
    private final Application applicationContext;
    private final CimAssetFactory cimAssetFactory;
    private final PlayerDownloadServiceManager downloadsManager;
    private final Task entitlementCache;
    private final HttpClient httpClient;
    private final InternetConnection internetConnection;
    private final MediaLicenseClient mediaLicenseClient;
    private final PlayerConfigUtil playerConfigUtil;
    private final MediaLicenseRenewalScheduler scheduler;
    private final TitaniumTicketClient titaniumTicketClient;
    private final Executor uiThreadExecutor;
    private final PlayNowUserManager userManager;
    private final WatchableClient watchableClient;

    public MediaLicenseRenewalTask(InternetConnection internetconnection, PlayerDownloadServiceManager playerdownloadservicemanager, PlayNowUserManager playnowusermanager, Task task, TitaniumTicketClient titaniumticketclient, MediaLicenseClient medialicenseclient, WatchableClient watchableclient, 
            MediaLicenseRenewalScheduler medialicenserenewalscheduler, Application application, HttpClient httpclient, CimAssetFactory cimassetfactory, PlayerConfigUtil playerconfigutil, Executor executor)
    {
        internetConnection = internetconnection;
        downloadsManager = playerdownloadservicemanager;
        userManager = playnowusermanager;
        entitlementCache = task;
        titaniumTicketClient = titaniumticketclient;
        mediaLicenseClient = medialicenseclient;
        watchableClient = watchableclient;
        scheduler = medialicenserenewalscheduler;
        applicationContext = application;
        httpClient = httpclient;
        cimAssetFactory = cimassetfactory;
        playerConfigUtil = playerconfigutil;
        uiThreadExecutor = executor;
    }

    private void handleDeviceNotRegistered(PlayNowUser playnowuser, AmsHttpErrorException amshttperrorexception)
    {
        LOG.error("Device is not registered, wiping all content", amshttperrorexception);
        try
        {
            waitForPendingDeletes(downloadsManager.deleteAllContent());
        }
        // Misplaced declaration of an exception variable
        catch (AmsHttpErrorException amshttperrorexception)
        {
            LOG.error("Caught exception trying to delete all content", amshttperrorexception);
        }
        amshttperrorexception = (PlayerUserSettings)userManager.getUserSettings();
        amshttperrorexception.setDeviceRegistration(null);
        try
        {
            userManager.saveUser(playnowuser, amshttperrorexception);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PlayNowUser playnowuser)
        {
            LOG.error("Caught exception trying to clear saved device registration", playnowuser);
        }
    }

    private void handleNotEntitled(PlayerDownloadFile playerdownloadfile, AmsHttpErrorException amshttperrorexception)
    {
        LOG.error("Caught entitlement exception trying to renew license, attempting to delete file", amshttperrorexception);
        try
        {
            waitForPendingDeletes(downloadsManager.deleteFile(playerdownloadfile));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PlayerDownloadFile playerdownloadfile)
        {
            LOG.error("Caught exception trying to delete file", playerdownloadfile);
        }
    }

    private void waitForPendingDeletes(Map map)
    {
        map = map.entrySet().iterator();
_L2:
        PlayerDownloadFile playerdownloadfile;
        Object obj;
        boolean flag;
        if (!map.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (java.util.Map.Entry)map.next();
        playerdownloadfile = (PlayerDownloadFile)((java.util.Map.Entry) (obj)).getKey();
        obj = (CountDownLatch)((java.util.Map.Entry) (obj)).getValue();
        flag = false;
        boolean flag1 = ((CountDownLatch) (obj)).await(20000L, TimeUnit.MILLISECONDS);
        flag = flag1;
_L3:
        if (flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        LOG.error("Timeout waiting for {} to be deleted", playerdownloadfile);
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L1
_L1:
        return;
        InterruptedException interruptedexception;
        interruptedexception;
          goto _L3
    }

    public void run()
    {
        long l;
        long l1;
        if (!internetConnection.isConnected())
        {
            LOG.warn("No internet connection");
            scheduler.runWhenConnectionIsAvailable();
            return;
        }
        l1 = 0x5265c00L;
        l = l1;
        LOG.debug("Starting license renewal task");
        l = l1;
        Date date = new Date();
        l = l1;
        LOG.debug("Waiting for download manager initialization");
        l = l1;
        downloadsManager.waitForInitialization(5000L);
        l = l1;
        Object obj4 = downloadsManager.getFilesList();
        l = l1;
        boolean flag = ((List) (obj4)).isEmpty();
        if (flag)
        {
            scheduler.runAtInterval(0x5265c00L);
            return;
        }
        break MISSING_BLOCK_LABEL_157;
        Object obj;
        obj;
        l = l1;
        LOG.error("Wait for download manager initialization failed, aborting renewal", ((Throwable) (obj)));
        scheduler.runAtInterval(0x1b7740L);
        return;
        l = l1;
        PlayNowUser playnowuser = (PlayNowUser)userManager.getUser();
        if (playnowuser != null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        l = l1;
        LOG.warn("No user currently signed in, skipping license renewal");
        scheduler.runAtInterval(0x5265c00L);
        return;
        l = l1;
        LOG.debug("Renewing licenses for user {}", playnowuser.getUserName());
        l = l1;
        com.comcast.cim.model.user.AuthKeys authkeys = playnowuser.getAuthKeys();
        Object obj1;
        obj1 = null;
        l = l1;
        Object obj2 = (VideoEntitlement)entitlementCache.execute();
        obj1 = obj2;
_L4:
        obj2 = null;
        l = l1;
        flag = ConfigurationManager.getInstance().isReady();
        long l2;
        l2 = l1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        l = l1;
        playerConfigUtil.configureSynchronous(5L);
        l2 = l1;
_L5:
        l = l2;
        final SettableFuture platformAPIFuture = SettableFuture.create();
        l = l2;
        uiThreadExecutor.execute(new Runnable() {

            final MediaLicenseRenewalTask this$0;
            final SettableFuture val$platformAPIFuture;

            public void run()
            {
                platformAPIFuture.set(new PlayerPlatformAPI(applicationContext, httpClient));
            }

            
            {
                this$0 = MediaLicenseRenewalTask.this;
                platformAPIFuture = settablefuture;
                super();
            }
        });
        l = l2;
        platformAPIFuture = (PlayerPlatformAPI)platformAPIFuture.get(5L, TimeUnit.SECONDS);
        obj2 = platformAPIFuture;
        l1 = l2;
_L6:
        l = l1;
        platformAPIFuture = ((List) (obj4)).iterator();
_L3:
        l = l1;
        l2 = l1;
        if (!platformAPIFuture.hasNext()) goto _L2; else goto _L1
_L1:
        l = l1;
        obj4 = (PlayerDownloadFile)platformAPIFuture.next();
        l = l1;
        if (((PlayerDownloadFile) (obj4)).getAsset().downloadStatus() != com.penthera.virtuososdk.Common.EFileDownloadStatus.kvDE_Expired)
        {
            break MISSING_BLOCK_LABEL_522;
        }
        l = l1;
        LOG.debug("{} is expired, skipping", obj4);
          goto _L3
        obj1;
        scheduler.runAtInterval(l);
        throw obj1;
        obj2;
        l = l1;
        LOG.error("Caught exception trying to fetch user entitlement", ((Throwable) (obj2)));
        l1 = 0x1b7740L;
          goto _L4
        Object obj3;
        obj3;
        l = l1;
        LOG.debug("Failed to Instantiate Media Player for License Renewal", ((Throwable) (obj3)));
        l2 = 0x1b7740L;
          goto _L5
        obj3;
        l = l2;
        LOG.error("Caught Exception trying to create PlayerPlatformAPI", ((Throwable) (obj3)));
        l1 = 0x1b7740L;
          goto _L6
        l2 = l1;
        if (!((PlayerDownloadFile) (obj4)).getExpirationStatus().equals(com.xfinity.playerlib.model.downloads.PlayerDownloadFile.ExpirationStatus.AAW_EXPIRED))
        {
            break MISSING_BLOCK_LABEL_638;
        }
        l2 = l1;
        LOG.info("File is AAW expired, expiring content");
        l2 = l1;
        downloadsManager.expireFile(((com.comcast.cim.downloads.DownloadFile) (obj4)));
_L7:
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        obj4;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj4)));
          goto _L3
        Object obj5;
        obj5;
        l2 = l1;
        LOG.error("Caught exception trying to expire file", ((Throwable) (obj5)));
        l1 = 0x1b7740L;
          goto _L7
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_700;
        }
        l2 = l1;
        LOG.debug("Skipping license renewal because we failed to get user entitlements");
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        obj4;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj4)));
          goto _L3
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_762;
        }
        l2 = l1;
        LOG.debug("Skipping license renewal because we failed to get platform API");
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        obj4;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj4)));
          goto _L3
        l2 = l1;
        l = date.getTime();
        l2 = l1;
        long l3 = ((PlayerDownloadFile) (obj4)).getLastLicenseRenewalDate().getTime();
        l2 = l1;
        long l4 = ((PlayerDownloadFile) (obj4)).getLicenseExpirationDate().getTime();
        l2 = l1;
        long l5 = date.getTime();
        if (l - l3 >= 0x5265c00L || l4 - l5 <= 0x5265c00L)
        {
            break MISSING_BLOCK_LABEL_901;
        }
        l2 = l1;
        LOG.debug("{} has been renewed recently ({}), skipping", obj4, ((PlayerDownloadFile) (obj4)).getLastLicenseRenewalDate());
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        obj4;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj4)));
          goto _L3
        l2 = l1;
        LOG.debug("Starting renewal for {}", obj4);
        l2 = l1;
        LOG.debug("Refreshing consumable data");
        l2 = l1;
        Object obj6 = watchableClient.fetchWatchable(((PlayerDownloadFile) (obj4)).getWatchableKey());
        l2 = l1;
        if (!((PlayerDownloadFile) (obj4)).downloadVideoExistsInWatchable(((com.xfinity.playerlib.model.consumable.Watchable) (obj6)))) goto _L9; else goto _L8
_L8:
        l2 = l1;
        ((PlayerDownloadFile) (obj4)).setWatchable(((com.xfinity.playerlib.model.consumable.Watchable) (obj6)));
_L10:
        l2 = l1;
        LOG.debug("Consumable refresh complete");
_L11:
        l2 = l1;
        LOG.debug("Fetching titanium ticket");
        l2 = l1;
        obj6 = ((PlayerDownloadFile) (obj4)).getVideo();
        l2 = l1;
        TitaniumTicket titaniumticket = titaniumTicketClient.getTitaniumTicket(authkeys, ((VideoEntitlement) (obj1)), ((VideoFacade) (obj6)).getDefaultDownloadProfile());
        l2 = l1;
        LOG.debug("Titanium ticket fetched");
        l2 = l1;
        LOG.debug("Renewing media license");
        l2 = l1;
        String s = ((PlayerDownloadFile) (obj4)).getPlaylistUri();
        l2 = l1;
        obj6 = cimAssetFactory.create(s, titaniumticket, ((VideoFacade) (obj6)), DrmWorkflow.STREAMING);
        l2 = l1;
        obj6 = mediaLicenseClient.getOrRefreshMediaLicense(((PlayerPlatformAPI) (obj2)), ((com.comcast.playerplatform.primetime.android.asset.Asset) (obj6)));
        l2 = l1;
        LOG.debug("Media license renewed");
        l2 = l1;
        ((PlayerDownloadFile) (obj4)).setLicenseExpirationDate(((Date) (obj6)));
        l2 = l1;
        ((PlayerDownloadFile) (obj4)).setLastLicenseRenewalDate(date);
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        obj4;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj4)));
          goto _L3
_L9:
        l2 = l1;
        LOG.warn("Our consumable isn't in the most up to date watchable, keeping our cached version");
          goto _L10
        obj6;
        l2 = l1;
        LOG.error("Caught exception while trying to refresh consumable, continuing with cached version", ((Throwable) (obj6)));
        l1 = 0x1b7740L;
          goto _L11
        obj6;
        l2 = l1;
        ((AmsHttpErrorException) (obj6)).getDetailedStatusCode();
        JVM INSTR lookupswitch 6: default 1647
    //                   405: 1339
    //                   407: 1339
    //                   415: 1339
    //                   420: 1339
    //                   1901: 1339
    //                   2001: 1394;
           goto _L12 _L13 _L13 _L13 _L13 _L13 _L14
_L12:
        l2 = l1;
        throw obj6;
        obj1;
        l = l2;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
        l = l2;
_L16:
        throw obj1;
_L13:
        l2 = l1;
        handleNotEntitled(((PlayerDownloadFile) (obj4)), ((AmsHttpErrorException) (obj6)));
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        obj4;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj4)));
          goto _L3
_L14:
        l2 = l1;
        handleDeviceNotRegistered(playnowuser, ((AmsHttpErrorException) (obj6)));
        l2 = l1;
        LOG.error("Aborting remaining renewals");
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
        l2 = l1;
_L2:
        scheduler.runAtInterval(l2);
        LOG.debug("License renewal task complete");
        return;
        obj1;
        l2 = 0x1b7740L;
        l = l2;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj1)));
        if (true) goto _L2; else goto _L15
_L15:
        obj6;
        l2 = l1;
        LOG.error("Caught IO exception fetching titanium ticket", ((Throwable) (obj6)));
        l1 = 0x1b7740L;
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        obj4;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", ((Throwable) (obj4)));
          goto _L3
        obj6;
        l2 = l1;
        LOG.error("Caught exception refreshing media license, skipping file", ((Throwable) (obj6)));
        l1 = 0x1b7740L;
        l = l1;
        downloadsManager.updateFile(((PlayerDownloadFile) (obj4)));
          goto _L3
        DownloadServiceException downloadserviceexception1;
        downloadserviceexception1;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", downloadserviceexception1);
          goto _L3
        DownloadServiceException downloadserviceexception;
        downloadserviceexception;
        l1 = 0x1b7740L;
        l = l1;
        LOG.error("Caught exception while trying to update file, ignoring", downloadserviceexception);
        l = l1;
          goto _L16
    }



}
