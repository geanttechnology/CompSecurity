// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.broadcast;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RemoteViews;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.utils.collections.LruLinkedHashMap;
import com.comcast.cim.container.PlayerContainer;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.client.IVirtuosoHLSFile;
import com.xfinity.playerlib.image.ProgramDetailArtImageLoader;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.downloads.DownloadableFileFactory;
import com.xfinity.playerlib.model.downloads.NotificationQueueManager;
import com.xfinity.playerlib.model.downloads.PlayerDownloadFile;
import com.xfinity.playerlib.model.user.PlayNowUser;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.downloads.DownloadsActivity;
import com.xfinity.playerlib.view.settings.PlayNowSettingsFragmentActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DownloadsNotificationReceiver extends BroadcastReceiver
{
    public static class NotificationBuilderService extends IntentService
    {

        private static String action;
        private static Map notificationBuilderMap = new HashMap();
        private final String deepLinkingScheme = PlayerContainer.getInstance().getDeepLinkingScheme();
        private final DownloadableFileFactory downloadableFileFactory = PlayerContainer.getInstance().getDownloadableFileFactory();
        private final InternetConnection internetConnection = PlayerContainer.getInstance().getInternetConnection();
        private final NotificationQueueManager notificationQueueManager = PlayerContainer.getInstance().getNotificationQueueManager();
        private final ProgramDetailArtImageLoader programDetailArtImageLoader = PlayerContainer.getInstance().createProgramDetailArtImageLoader();
        private final PlayNowUserManager userManager = PlayerContainer.getInstance().getUserManager();
        private final LruLinkedHashMap volatileFileCache = PlayerContainer.getInstance().getVolatileDownloadableFileCache();

        private Notification buildBigPictureNotification(PendingIntent pendingintent, Resources resources, Watchable watchable, Bitmap bitmap, android.support.v4.app.NotificationCompat.Builder builder, int i, String s)
        {
            return builder.setContentIntent(pendingintent).setSmallIcon(com.xfinity.playerlib.R.drawable.ic_stat).setTicker(resources.getString(com.xfinity.playerlib.R.string.download_complete_notification, new Object[] {
                watchable.getDisplayTitle()
            })).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(watchable.getDisplayTitle()).setContentText(resources.getString(com.xfinity.playerlib.R.string.download_complete_subtext)).setStyle((new android.support.v4.app.NotificationCompat.BigPictureStyle()).bigPicture(bitmap).setSummaryText(resources.getString(com.xfinity.playerlib.R.string.download_complete_subtext)).setBigContentTitle(watchable.getDisplayTitle())).addAction(0, "Watch", createPlaybackPendingIntent(watchable, i, s)).addAction(0, "Manage Downloads", createDownloadPendingIntent(i, s)).build();
        }

        private void cancelAllNotifications()
        {
            ((NotificationManager)getSystemService("notification")).cancelAll();
        }

        private Intent createDownloadIntent()
        {
            Intent intent = new Intent("com.xfinity.playerlib.DOWNLOADS_NOTIFICATION");
            intent.setComponent(new ComponentName(getPackageName(), com/xfinity/playerlib/view/downloads/DownloadsActivity.getName()));
            return intent;
        }

        private PendingIntent createDownloadPendingIntent(int i, String s)
        {
            Intent intent = new Intent("com.xfinity.playerlib.DOWNLOADS_NOTIFICATION.MANAGE_BUTTON");
            intent.setComponent(new ComponentName(getPackageName(), com/xfinity/playerlib/view/downloads/DownloadsActivity.getName()));
            intent.putExtra("EXTRA_NOTIFICATION_ID_TO_CANCEL", i);
            intent.putExtra("EXTRA_NOTIFICATION_TAG_TO_CANCEL", s);
            return PendingIntent.getActivity(this, 2, intent, 0x8000000);
        }

        private PendingIntent createEntityPendingIntent(Watchable watchable)
        {
            return PendingIntent.getActivity(this, 0, getIntentForDeeplinkUri(watchable.getEntityDeeplinkUri(deepLinkingScheme)), 0x8000000);
        }

        public static Intent createIntent(Context context, Intent intent)
        {
            context = new Intent(context, com/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService);
            context.putExtra("BROADCAST_INTENT", intent);
            return context;
        }

        private PendingIntent createPlaybackPendingIntent(Watchable watchable, int i, String s)
        {
            return PendingIntent.getActivity(this, 1, getIntentForDeeplinkUri(watchable.getPlaybackDeeplinkUri(deepLinkingScheme), i, s), 0x8000000);
        }

        private Intent createSettingsIntent()
        {
            Intent intent = new Intent(this, com/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity);
            intent.putExtra("resource", "use_cellular_prefs");
            intent.setFlags(0x10000000);
            intent.setFlags(0x20000000);
            intent.setFlags(0x4000000);
            intent.setFlags(4);
            return intent;
        }

        private PlayerDownloadFile getDownloadableFile(IVirtuosoAsset ivirtuosoasset)
        {
            String s;
            if (!(ivirtuosoasset instanceof IVirtuosoHLSFile))
            {
                break MISSING_BLOCK_LABEL_78;
            }
            s = ivirtuosoasset.uuid();
            LruLinkedHashMap lrulinkedhashmap = volatileFileCache;
            lrulinkedhashmap;
            JVM INSTR monitorenter ;
            PlayerDownloadFile playerdownloadfile = (PlayerDownloadFile)volatileFileCache.get(s);
            if (playerdownloadfile != null) goto _L2; else goto _L1
_L1:
            ivirtuosoasset = downloadableFileFactory.create(ivirtuosoasset);
            volatileFileCache.put(s, ivirtuosoasset);
_L3:
            lrulinkedhashmap;
            JVM INSTR monitorexit ;
            return ivirtuosoasset;
_L2:
            playerdownloadfile.setAsset(ivirtuosoasset);
            ivirtuosoasset = playerdownloadfile;
              goto _L3
            ivirtuosoasset;
            lrulinkedhashmap;
            JVM INSTR monitorexit ;
            throw ivirtuosoasset;
            return null;
        }

        private Intent getIntentForDeeplinkUri(Uri uri)
        {
            return new Intent("android.intent.action.VIEW", uri);
        }

        private Intent getIntentForDeeplinkUri(Uri uri, int i, String s)
        {
            uri = getIntentForDeeplinkUri(uri);
            uri.putExtra("EXTRA_NOTIFICATION_ID_TO_CANCEL", i);
            uri.putExtra("EXTRA_NOTIFICATION_TAG_TO_CANCEL", s);
            return uri;
        }

        private RemoteViews getProgressView(PlayerDownloadFile playerdownloadfile, int i)
        {
            Watchable watchable = playerdownloadfile.getWatchable();
            Resources resources = getResources();
            RemoteViews remoteviews = new RemoteViews(getPackageName(), com.xfinity.playerlib.R.layout.progress_notification);
            remoteviews.setTextViewText(com.xfinity.playerlib.R.id.downloadTitle, resources.getString(com.xfinity.playerlib.R.string.downloading_notification, new Object[] {
                watchable.getDisplayTitle()
            }));
            int j;
            boolean flag;
            if (playerdownloadfile.getPercentComplete() > 1)
            {
                j = playerdownloadfile.getPercentComplete();
            } else
            {
                j = 1;
            }
            remoteviews.setProgressBar(com.xfinity.playerlib.R.id.progressBar, 100, j, false);
            remoteviews.setTextViewText(com.xfinity.playerlib.R.id.downloadSizeInfo, resources.getString(com.xfinity.playerlib.R.string.download_size_notification, new Object[] {
                Integer.valueOf(playerdownloadfile.getExpectedFileSizeInMb())
            }));
            j = com.xfinity.playerlib.R.id.progressBar;
            if (playerdownloadfile.getAsset().downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            remoteviews.setBoolean(j, "setEnabled", flag);
            if (i > 1)
            {
                remoteviews.setViewVisibility(com.xfinity.playerlib.R.id.remainingDownloads, 0);
                i--;
                remoteviews.setTextViewText(com.xfinity.playerlib.R.id.remainingDownloads, resources.getQuantityString(com.xfinity.playerlib.R.plurals.downloads_in_queue_notification, i, new Object[] {
                    Integer.valueOf(i)
                }));
                return remoteviews;
            } else
            {
                remoteviews.setViewVisibility(com.xfinity.playerlib.R.id.remainingDownloads, 8);
                return remoteviews;
            }
        }

        private void showDownloadEventNotification(String s, String s1, PendingIntent pendingintent)
        {
            s = (new android.support.v4.app.NotificationCompat.Builder(getBaseContext())).setSmallIcon(com.xfinity.playerlib.R.drawable.ic_stat).setContentTitle(s).setContentText(s1).setContentIntent(pendingintent).build();
            s1 = (NotificationManager)getSystemService("notification");
            s1.cancel("ProgressView", 1);
            s1.notify("ProgressView", 1, s);
        }

        protected void onHandleIntent(Intent intent)
        {
            if (userManager.getUser() != null) goto _L2; else goto _L1
_L1:
            cancelAllNotifications();
_L4:
            return;
_L2:
            Object obj;
            Object obj1;
            Resources resources;
            NotificationManager notificationmanager;
            Object obj2;
            Object obj3;
            int i;
            intent = (Intent)intent.getParcelableExtra("BROADCAST_INTENT");
            if (action != null && !action.equals(intent.getAction()))
            {
                i = 1;
            } else
            {
                i = 0;
            }
            action = intent.getAction();
            notificationmanager = (NotificationManager)getSystemService("notification");
            resources = getResources();
            obj1 = PendingIntent.getActivity(this, 0, createDownloadIntent(), 0x8000000);
            obj = intent.getExtras();
            ((Bundle) (obj)).setClassLoader(getClassLoader());
            obj2 = (IVirtuosoAsset)((Bundle) (obj)).getParcelable("notification_file");
            obj3 = getDownloadableFile(((IVirtuosoAsset) (obj2)));
            intent = null;
            if (obj3 != null)
            {
                intent = ((PlayerDownloadFile) (obj3)).getWatchable();
            }
            if (!action.contains(".NOTIFICATION_DOWNLOAD_STOPPED"))
            {
                break; /* Loop/switch isn't completed */
            }
            obj2 = com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.values()[((Bundle) (obj)).getInt("notification_engine_status_ordinal")];
            obj3 = com.penthera.virtuososdk.Common.EngineStatusInfo.values()[((Bundle) (obj)).getInt("notification_engine_status_info_ordinal")];
            i = ((Bundle) (obj)).getInt("notification_num_queued_files");
            if (((com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus) (obj2)).equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Blocked))
            {
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EBlockedBattery))
                {
                    obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.low_battery)
                    });
                    intent = resources.getString(com.xfinity.playerlib.R.string.blocked_battery_notification);
                } else
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EBlockedCell))
                {
                    if ((PlayNowUser)userManager.getUser() != null)
                    {
                        obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                            resources.getString(com.xfinity.playerlib.R.string.data_not_enabled)
                        });
                        intent = resources.getString(com.xfinity.playerlib.R.string.blocked_no_wifi_or_cell_notification);
                        obj1 = PendingIntent.getActivity(this, 0, createSettingsIntent(), 0x8000000);
                    } else
                    {
                        obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                            resources.getString(com.xfinity.playerlib.R.string.no_wifi)
                        });
                        intent = resources.getString(com.xfinity.playerlib.R.string.blocked_no_wifi_notification);
                    }
                } else
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EBlockedStorage))
                {
                    obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.low_storage)
                    });
                    intent = resources.getString(com.xfinity.playerlib.R.string.blocked_storage_notification);
                } else
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorNetwork) || ((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorsMaxed))
                {
                    if (internetConnection.isConnected())
                    {
                        obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                            resources.getString(com.xfinity.playerlib.R.string.bad_network)
                        });
                        i = com.xfinity.playerlib.R.string.blocked_bad_network_notification;
                        if (intent != null)
                        {
                            intent = intent.getDisplayTitle();
                        } else
                        {
                            intent = "";
                        }
                        intent = resources.getString(i, new Object[] {
                            intent
                        });
                    } else
                    {
                        obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                            resources.getString(com.xfinity.playerlib.R.string.offline)
                        });
                        intent = resources.getString(com.xfinity.playerlib.R.string.blocked_offline_notification);
                    }
                } else
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorFile))
                {
                    obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.sdcard)
                    });
                    intent = resources.getString(com.xfinity.playerlib.R.string.blocked_sdcard_notification);
                } else
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EBlockedErrorHTTP) || ((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorFileExpectedSize) || ((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorFileMimeType))
                {
                    obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.http_error)
                    });
                    i = com.xfinity.playerlib.R.string.blocked_http_error_notification;
                    if (intent != null)
                    {
                        intent = intent.getDisplayTitle();
                    } else
                    {
                        intent = "";
                    }
                    intent = resources.getString(i, new Object[] {
                        intent
                    });
                } else
                {
                    obj = resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.unknown)
                    });
                    intent = resources.getString(com.xfinity.playerlib.R.string.blocked_unknown_notification);
                }
                showDownloadEventNotification(((String) (obj)), intent, ((PendingIntent) (obj1)));
                return;
            }
            if (((com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus) (obj2)).equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Errors))
            {
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorNetwork) || ((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorsMaxed))
                {
                    showDownloadEventNotification(resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.offline)
                    }), resources.getString(com.xfinity.playerlib.R.string.blocked_offline_notification), ((PendingIntent) (obj1)));
                    return;
                }
                if (((com.penthera.virtuososdk.Common.EngineStatusInfo) (obj3)).equals(com.penthera.virtuososdk.Common.EngineStatusInfo.EErrorFile))
                {
                    showDownloadEventNotification(resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.sdcard)
                    }), resources.getString(com.xfinity.playerlib.R.string.blocked_sdcard_notification), ((PendingIntent) (obj1)));
                    return;
                } else
                {
                    showDownloadEventNotification(resources.getString(com.xfinity.playerlib.R.string.error_notification_title, new Object[] {
                        resources.getString(com.xfinity.playerlib.R.string.unknown)
                    }), resources.getString(com.xfinity.playerlib.R.string.blocked_unknown_notification), ((PendingIntent) (obj1)));
                    return;
                }
            }
            if (((com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus) (obj2)).equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Paused))
            {
                showDownloadEventNotification(resources.getString(com.xfinity.playerlib.R.string.paused_notification_title), resources.getString(com.xfinity.playerlib.R.string.paused_notification), ((PendingIntent) (obj1)));
                return;
            }
            if (((com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus) (obj2)).equals(com.penthera.virtuososdk.Common.EVirtuosoDownloadEngineStatus.kVDE_Idle) && i == 0)
            {
                notificationmanager.cancel("ProgressView", 1);
                return;
            }
            if (true) goto _L4; else goto _L3
_L3:
            if (action.contains(".NOTIFICATION_DOWNLOADS_PAUSED"))
            {
                showDownloadEventNotification(resources.getString(com.xfinity.playerlib.R.string.paused_notification_title), resources.getString(com.xfinity.playerlib.R.string.paused_notification), ((PendingIntent) (obj1)));
                return;
            }
            if (intent == null) goto _L4; else goto _L5
_L5:
            if (!action.contains(".NOTIFICATION_DOWNLOAD_COMPLETE"))
            {
                continue; /* Loop/switch isn't completed */
            }
            notificationmanager.cancel("ProgressView", 1);
            boolean flag = false;
            obj = intent.getVideos().iterator();
            do
            {
                i = ((flag) ? 1 : 0);
                if (!((Iterator) (obj)).hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
            } while (!((VideoFacade)((Iterator) (obj)).next()).isAdult());
            i = 1;
            if (i != 0 && !((PlayerUserSettings)userManager.getUserSettings()).getWantsAdultContent()) goto _L4; else goto _L6
_L6:
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                obj = PendingIntent.getActivity(this, 0, createDownloadIntent(), 0x8000000);
            } else
            {
                obj = createEntityPendingIntent(intent);
            }
            obj1 = programDetailArtImageLoader.getBitmapFromCache(intent.getParentMerlinIdIfApplicable());
            obj3 = new android.support.v4.app.NotificationCompat.Builder(getBaseContext());
            if (obj1 != null)
            {
                intent = buildBigPictureNotification(((PendingIntent) (obj)), resources, intent, ((Bitmap) (obj1)), ((android.support.v4.app.NotificationCompat.Builder) (obj3)), ((IVirtuosoAsset) (obj2)).id(), ((IVirtuosoAsset) (obj2)).uuid());
            } else
            {
                intent = ((android.support.v4.app.NotificationCompat.Builder) (obj3)).setContentIntent(((PendingIntent) (obj))).setSmallIcon(com.xfinity.playerlib.R.drawable.ic_stat).setTicker(resources.getString(com.xfinity.playerlib.R.string.download_complete_notification, new Object[] {
                    intent.getDisplayTitle()
                })).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(intent.getDisplayTitle()).setContentText(resources.getString(com.xfinity.playerlib.R.string.download_complete_subtext)).build();
            }
            notificationmanager.notify(((IVirtuosoAsset) (obj2)).uuid(), ((IVirtuosoAsset) (obj2)).id(), intent);
            if (i == 0) goto _L4; else goto _L7
_L7:
            notificationQueueManager.registerAdultDownloadNotification(((IVirtuosoAsset) (obj2)).uuid(), ((IVirtuosoAsset) (obj2)).id());
            return;
            if (!action.contains(".NOTIFICATION_DOWNLOAD_START") && !action.contains(".NOTIFICATION_DOWNLOAD_UPDATE")) goto _L4; else goto _L8
_L8:
            RemoteViews remoteviews = getProgressView(((PlayerDownloadFile) (obj3)), ((Bundle) (obj)).getInt("notification_num_queued_files"));
            obj3 = intent.getMerlinId();
            if (action.contains(".NOTIFICATION_DOWNLOAD_START"))
            {
                programDetailArtImageLoader.preCacheDrawable(intent.getParentMerlinIdIfApplicable());
            } else
            if (DownloadsNotificationReceiver.prevId != null && !DownloadsNotificationReceiver.prevId.equals(obj3))
            {
                return;
            }
            DownloadsNotificationReceiver.prevId = ((MerlinId) (obj3));
            if (notificationBuilderMap.get(obj3) != null)
            {
                intent = (android.support.v4.app.NotificationCompat.Builder)notificationBuilderMap.get(obj3);
            } else
            {
                android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(getBaseContext());
                notificationBuilderMap.put(obj3, builder);
                builder.setOngoing(true).setContentIntent(((PendingIntent) (obj1))).setWhen(System.currentTimeMillis()).setSmallIcon(com.xfinity.playerlib.R.drawable.ic_stat).setTicker(resources.getString(com.xfinity.playerlib.R.string.downloading_notification, new Object[] {
                    intent.getDisplayTitle()
                })).setOnlyAlertOnce(true);
                intent = builder;
            }
            intent.setContent(remoteviews);
            intent.setContentIntent(((PendingIntent) (obj1)));
            intent = intent.build();
            intent.contentView = remoteviews;
            if (i != 0)
            {
                notificationmanager.cancel("ProgressView", 1);
            }
            notificationmanager.notify("ProgressView", 1, intent);
            return;
        }


        public NotificationBuilderService()
        {
            super(com/xfinity/playerlib/broadcast/DownloadsNotificationReceiver$NotificationBuilderService.getSimpleName());
        }
    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/broadcast/DownloadsNotificationReceiver);
    private static MerlinId prevId;

    public DownloadsNotificationReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (context != null && intent != null)
        {
            context.startService(NotificationBuilderService.createIntent(context, intent));
        }
    }




/*
    static MerlinId access$002(MerlinId merlinid)
    {
        prevId = merlinid;
        return merlinid;
    }

*/
}
