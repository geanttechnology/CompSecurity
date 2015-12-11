// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import android.content.Context;
import android.content.SharedPreferences;
import com.comcast.cim.cmasl.hls.HlsSimplePlaylist;
import com.comcast.cim.cmasl.hls.HlsVariantPlaylist;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.downloads.DownloadFile;
import com.comcast.cim.downloads.DownloadMetaData;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.cim.downloads.DownloadServiceManager;
import com.comcast.cim.downloads.MaxDownloadsReachedException;
import com.comcast.cim.model.user.User;
import com.comcast.cim.model.user.service.UserSettings;
import com.comcast.cim.utils.JsonSerializer;
import com.google.common.util.concurrent.FutureCallback;
import com.penthera.virtuososdk.client.IVirtuosoDownloadEngineStatus;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.downloads.MediaLicenseRenewalService;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.EncodedWatchable;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.WatchableCodec;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import com.xfinity.playerlib.model.consumable.hal.HalVideoProfile;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.tracking.PlayNowTrackingService;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.downloads:
//            PlayerDownloadFile, PlayerDownloadMetaData, PersistentEntityCache, DownloadableFileFactory

public class PlayerDownloadServiceManager extends DownloadServiceManager
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager);
    private final PersistentEntityCache entityCache;
    private final PlayNowTrackingService trackingService;
    private final WatchableCodec watchableCodec;

    public PlayerDownloadServiceManager(PlayerApplication playerapplication, JsonSerializer jsonserializer, DownloadableFileFactory downloadablefilefactory, PlayNowUserManager playnowusermanager, WatchableCodec watchablecodec, PersistentEntityCache persistententitycache, Executor executor, 
            Executor executor1, PlayNowTrackingService playnowtrackingservice, SharedPreferences sharedpreferences)
    {
        super(playerapplication, jsonserializer, downloadablefilefactory, playnowusermanager, executor, executor1, sharedpreferences);
        watchableCodec = watchablecodec;
        entityCache = persistententitycache;
        trackingService = playnowtrackingservice;
    }

    private void setCellularDataQuotaForCurrentUser(PlayerUserSettings playerusersettings)
    {
        this;
        JVM INSTR monitorenter ;
        if (!playerusersettings.getUseCellularWhenAvailable()) goto _L2; else goto _L1
_L1:
        setCellularDataThreshold(-1D);
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        setCellularDataThreshold(0.0D);
        if (true) goto _L4; else goto _L3
_L3:
        playerusersettings;
        throw new RuntimeException(playerusersettings);
        playerusersettings;
        this;
        JVM INSTR monitorexit ;
        throw playerusersettings;
    }

    public void downloadHlsFileWithWatchable(final Watchable backingEntity, final VideoFacade video, final Date metaData, final HlsSimplePlaylist simplePlaylist, final HlsVariantPlaylist variantPlaylist, final HlsSimplePlaylist alternateAudioPlaylist, HalVideoProfile halvideoprofile, 
            final FutureCallback resultCallback)
    {
        LOG.debug("Attempting to download a file");
        Validate.notNull(backingEntity);
        Validate.notNull(video);
        Validate.notNull(resultCallback);
        Validate.isTrue(isFileListReady());
        Object obj = getFilesList();
        int i = 0;
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            if (((PlayerDownloadFile)(DownloadFile)((Iterator) (obj)).next()).getExpirationStatus() != PlayerDownloadFile.ExpirationStatus.AAW_EXPIRED)
            {
                i++;
            }
        } while (true);
        if (i >= 10)
        {
            resultCallback.onFailure(new MaxDownloadsReachedException("Max Downloads Reached!"));
            return;
        } else
        {
            final long videoId = video.getVideoId();
            EncodedWatchable encodedwatchable = watchableCodec.encode(backingEntity, video);
            backingEntity = encodedwatchable.getBackingEntity();
            Date date = new Date();
            final UUID uuid = UUID.randomUUID();
            metaData = new PlayerDownloadMetaData(uuid, encodedwatchable.getWatchableKey(), videoId, date, halvideoprofile.getContentSizeInBytes(), date, metaData);
            video = new Runnable() {

                final PlayerDownloadServiceManager this$0;
                final VideoFacade val$video;

                public void run()
                {
                    trackingService.trackDownloadRequest(video);
                }

            
            {
                this$0 = PlayerDownloadServiceManager.this;
                video = videofacade;
                super();
            }
            };
            backgroundExecutor.execute(new Runnable() {

                final PlayerDownloadServiceManager this$0;
                final HlsSimplePlaylist val$alternateAudioPlaylist;
                final Either val$backingEntity;
                final Runnable val$extraTask;
                final PlayerDownloadMetaData val$metaData;
                final FutureCallback val$resultCallback;
                final HlsSimplePlaylist val$simplePlaylist;
                final UUID val$uuid;
                final HlsVariantPlaylist val$variantPlaylist;
                final long val$videoId;

                public void run()
                {
                    entityCache.store(uuid, backingEntity);
                    try
                    {
                        downloadHlsFileWithMetadata((new StringBuilder()).append("").append(videoId).toString(), simplePlaylist, variantPlaylist, alternateAudioPlaylist, metaData, extraTask, resultCallback);
                        return;
                    }
                    catch (DownloadServiceException downloadserviceexception)
                    {
                        resultCallback.onFailure(downloadserviceexception);
                    }
                }

            
            {
                this$0 = PlayerDownloadServiceManager.this;
                uuid = uuid1;
                backingEntity = either;
                videoId = l;
                simplePlaylist = hlssimpleplaylist;
                variantPlaylist = hlsvariantplaylist;
                alternateAudioPlaylist = hlssimpleplaylist1;
                metaData = playerdownloadmetadata;
                extraTask = runnable;
                resultCallback = futurecallback;
                super();
            }
            });
            return;
        }
    }

    public PlayerDownloadFile findFileWithMerlinData(MerlinId merlinid, MerlinId merlinid1, Long long1)
    {
        Iterator iterator = getFilesList().iterator();
        PlayerDownloadFile playerdownloadfile;
label0:
        do
        {
            if (iterator.hasNext())
            {
                playerdownloadfile = (PlayerDownloadFile)(DownloadFile)iterator.next();
                Object obj = playerdownloadfile.getWatchable();
                if (!((Watchable) (obj)).getMerlinId().equals(merlinid) || !((Watchable) (obj)).getParentMerlinIdIfApplicable().equals(merlinid1))
                {
                    continue;
                }
                obj = ((Watchable) (obj)).getVideos().iterator();
                VideoFacade videofacade;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue label0;
                    }
                    videofacade = (VideoFacade)((Iterator) (obj)).next();
                } while (long1 != null && long1.longValue() > 0L && videofacade.getNetworkInfo().getCompanyId() != long1.longValue());
                break;
            } else
            {
                return null;
            }
        } while (true);
        return playerdownloadfile;
    }

    public PlayerDownloadFile findFileWithVideoId(long l)
    {
        for (Iterator iterator = getFilesList().iterator(); iterator.hasNext();)
        {
            PlayerDownloadFile playerdownloadfile = (PlayerDownloadFile)(DownloadFile)iterator.next();
            if (playerdownloadfile.getVideoId() == l)
            {
                return playerdownloadfile;
            }
        }

        return null;
    }

    public Either getStoredEntity(UUID uuid)
    {
        return entityCache.retrieve(uuid);
    }

    public void initiateTemporaryPause()
        throws DownloadServiceException
    {
        if (getDownloadEngineStatus().status() != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused && getDownloadEngineStatus().status() != com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle)
        {
            pauseDownloading();
            android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean("DownloadsTemporarilyPaused", true);
            editor.commit();
        }
    }

    public boolean isTemporarilyPaused()
    {
        return sharedPreferences.getBoolean("DownloadsTemporarilyPaused", false);
    }

    protected volatile void onFileDeleted(DownloadFile downloadfile)
    {
        onFileDeleted((PlayerDownloadFile)downloadfile);
    }

    protected void onFileDeleted(PlayerDownloadFile playerdownloadfile)
    {
        entityCache.remove(playerdownloadfile.getUuid());
        super.onFileDeleted(playerdownloadfile);
    }

    protected volatile void onFileDownloadFinished(DownloadFile downloadfile)
    {
        onFileDownloadFinished((PlayerDownloadFile)downloadfile);
    }

    protected void onFileDownloadFinished(PlayerDownloadFile playerdownloadfile)
    {
        super.onFileDownloadFinished(playerdownloadfile);
        trackingService.trackDownloadSuccess(playerdownloadfile.getVideo());
    }

    public volatile void onUserChanged(User user, UserSettings usersettings)
    {
        onUserChanged((PlayNowUser)user, (PlayerUserSettings)usersettings);
    }

    public void onUserChanged(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
    {
        LOG.warn("New user {} logged in, deleting previous user's content", playnowuser.getUserName());
        try
        {
            deleteAllContent();
        }
        catch (DownloadServiceException downloadserviceexception)
        {
            LOG.error("Caught exception attempting to delete content on user change", downloadserviceexception);
        }
        super.onUserChanged(playnowuser, playerusersettings);
    }

    public volatile void onUserLoaded(User user, UserSettings usersettings)
    {
        onUserLoaded((PlayNowUser)user, (PlayerUserSettings)usersettings);
    }

    public void onUserLoaded(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
    {
        LOG.debug("onUserLoaded {}", playnowuser.getUserName());
        super.onUserLoaded(playnowuser, playerusersettings);
    }

    public volatile void onUserLoggedIn(User user, UserSettings usersettings)
    {
        onUserLoggedIn((PlayNowUser)user, (PlayerUserSettings)usersettings);
    }

    public void onUserLoggedIn(PlayNowUser playnowuser, PlayerUserSettings playerusersettings)
    {
        LOG.debug("onUserLoggedIn {}", playnowuser.getUserName());
        setCellularDataQuotaForCurrentUser(playerusersettings);
        triggerMediaLicenseRenewal();
        if (sharedPreferences.getBoolean("DownloadsTemporarilyPaused", false))
        {
            try
            {
                resumeDownloading();
            }
            catch (DownloadServiceException downloadserviceexception)
            {
                LOG.error("Caught exception attempting to un-pause downloads", downloadserviceexception);
            }
        }
        super.onUserLoggedIn(playnowuser, playerusersettings);
    }

    public void onUserLoggedOut()
    {
        super.onUserLoggedOut();
    }

    public void resumeDownloading()
        throws DownloadServiceException
    {
        super.resumeDownloading();
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("DownloadsTemporarilyPaused", false);
        editor.commit();
    }

    public void triggerMediaLicenseRenewal()
    {
        context.startService(MediaLicenseRenewalService.createIntent(context));
    }

    public void updateFile(PlayerDownloadFile playerdownloadfile)
        throws DownloadServiceException
    {
        Either either = watchableCodec.encode(playerdownloadfile.getWatchable(), playerdownloadfile.getVideo()).getBackingEntity();
        entityCache.store(playerdownloadfile.getUuid(), either);
        updateFileMetadata(playerdownloadfile);
    }




}
