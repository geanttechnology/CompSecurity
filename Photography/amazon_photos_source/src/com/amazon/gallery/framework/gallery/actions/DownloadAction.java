// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.os.Environment;
import android.widget.Toast;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.DebugAssert;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.thread.NamedThreadPoolFactory;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import com.amazon.gallery.thor.removablestorage.StorageLocationPreference;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            MediaItemAction

public class DownloadAction extends MediaItemAction
{
    public static final class Builder
    {

        private Activity context;
        private GalleryDownloadManager downloadManager;
        private MediaItemDao mediaItemDao;
        private NetworkConnectivity networkConnectivity;
        private PhotosDemoManager photosDemoManager;
        private RemovableStorageManager removableStorageManager;
        private RestClient restClient;

        public DownloadAction build()
        {
            return new DownloadAction(context, networkConnectivity, photosDemoManager, mediaItemDao, restClient, downloadManager, removableStorageManager);
        }

        public Builder withContext(Activity activity)
        {
            context = activity;
            return this;
        }

        public Builder withGalleryDownloadManager(GalleryDownloadManager gallerydownloadmanager)
        {
            downloadManager = gallerydownloadmanager;
            return this;
        }

        public Builder withMediaItemDao(MediaItemDao mediaitemdao)
        {
            mediaItemDao = mediaitemdao;
            return this;
        }

        public Builder withNetworkConnectivity(NetworkConnectivity networkconnectivity)
        {
            networkConnectivity = networkconnectivity;
            return this;
        }

        public Builder withPhotosDemoManager(PhotosDemoManager photosdemomanager)
        {
            photosDemoManager = photosdemomanager;
            return this;
        }

        public Builder withRemovableStorageManager(RemovableStorageManager removablestoragemanager)
        {
            removableStorageManager = removablestoragemanager;
            return this;
        }

        public Builder withRestClient(RestClient restclient)
        {
            restClient = restclient;
            return this;
        }

        public Builder()
        {
        }
    }

    private class DownloadRunnable
        implements Runnable
    {

        private List mediaItems;
        private final Tag tag;
        final DownloadAction this$0;

        private void displayDownloadMessage(int i)
        {
            Runnable runnable = i. new Runnable() ;
            isEmpty.runOnUiThread(runnable);
        }

        private File getDirForTag(Tag tag1)
        {
            if (tag1 == null)
            {
                tag1 = "";
            } else
            {
                tag1 = ViewNameFactory.getTitle(tag1, isEmpty);
            }
            return new File(getDownloadRootDir(), tag1);
        }

        protected void downloadMediaItems(List list)
        {
            if (list.isEmpty())
            {
                displayDownloadMessage(0x7f0e0042);
                return;
            }
            File file = getDirForTag(tag);
            if (!file.exists() && !file.mkdirs())
            {
                GLogger.e(DownloadAction.TAG, "Couldn't create folder %s", new Object[] {
                    file.getPath()
                });
                return;
            }
            GLogger.v(DownloadAction.TAG, "Begin Download of %d for album %s", new Object[] {
                Integer.valueOf(list.size()), file
            });
            if (networkConnectivity.isNetworkConnected())
            {
                displayDownloadMessage(0x7f0e0041);
            }
            if (tag == null)
            {
                downloadManager.downloadMediaItems(list, file);
                return;
            } else
            {
                downloadManager.downloadMediaItems(tag, list, file);
                return;
            }
        }

        public void run()
        {
            if (removableStorageManager.promptForStoragePreferenceIfNeeded(isEmpty))
            {
                return;
            }
            GlobalMessagingBus.post(new ActionCompleteEvent());
            if (mediaItems == null)
            {
                mediaItems = mediaItemDao.getItemsByTag(tag).getMediaItems();
            }
            for (Iterator iterator = mediaItems.iterator(); iterator.hasNext(); ((MediaItem)iterator.next()).getSyncState()) { }
            downloadMediaItems(mediaItems);
        }

        public DownloadRunnable(Tag tag1)
        {
            this(tag1, null);
        }

        public DownloadRunnable(Tag tag1, List list)
        {
            this$0 = DownloadAction.this;
            super();
            tag = tag1;
            mediaItems = list;
        }
    }


    protected static final Executor EXECUTOR = NamedThreadPoolFactory.newFixedThreadPoolExecutor(3, 4, "DownloadActionThread");
    private static final File LOCAL_DOWNLOAD_ROOT_DIR;
    private static final String TAG = com/amazon/gallery/framework/gallery/actions/DownloadAction.getName();
    private final GalleryDownloadManager downloadManager;
    private final MediaItemDao mediaItemDao;
    private final RemovableStorageManager removableStorageManager;
    private final RestClient restClient;

    protected DownloadAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, MediaItemDao mediaitemdao, RestClient restclient, GalleryDownloadManager gallerydownloadmanager, RemovableStorageManager removablestoragemanager)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0048);
        mediaItemDao = mediaitemdao;
        restClient = restclient;
        downloadManager = gallerydownloadmanager;
        removableStorageManager = removablestoragemanager;
    }

    private File getDownloadRootDir()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[];

            static 
            {
                $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference = new int[StorageLocationPreference.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[StorageLocationPreference.USE_REMOVABLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[StorageLocationPreference.USE_INTERNAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$thor$removablestorage$StorageLocationPreference[StorageLocationPreference.UNSPECIFIED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.thor.removablestorage.StorageLocationPreference[removableStorageManager.getStorageLocationPreference().ordinal()])
        {
        default:
            throw new IllegalStateException("Trying to download to unknown storageLocationPreference.");

        case 1: // '\001'
            if (removableStorageManager.isRemovableStorageMounted())
            {
                File file = removableStorageManager.getRemovableStorageDownloadDirectory();
                if (file != null)
                {
                    return file;
                }
            }
            return LOCAL_DOWNLOAD_ROOT_DIR;

        case 2: // '\002'
            return LOCAL_DOWNLOAD_ROOT_DIR;

        case 3: // '\003'
            DebugAssert.assertFalse(removableStorageManager.isRemovableStorageMounted(), "Trying to get download root dir without knowing user preference.");
            return LOCAL_DOWNLOAD_ROOT_DIR;
        }
    }

    private boolean promptIfNoNetwork()
    {
        return networkConnectivity.promptIfOffline(context);
    }

    public void execute(List list)
    {
        if (promptIfNoNetwork())
        {
            return;
        } else
        {
            super.execute(list);
            EXECUTOR.execute(new DownloadRunnable(null, list));
            return;
        }
    }

    public void executeTagOperation(Tag tag)
    {
        EXECUTOR.execute(new DownloadRunnable(tag));
    }

    public void executeTags(List list)
    {
        if (!promptIfNoNetwork())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                executeTagOperation((Tag)list.next());
            }
        }
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        return super.isValid(mediaitem) && !mediaitem.hasProperty(CommonMediaProperty.LOCAL) && (mediaitem.getType() != MediaType.VIDEO || ((Video)mediaitem).getDuration() < TimeUnit.MINUTES.toMillis(20L));
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
        if (isWhisperPlayMode())
        {
            list = com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPDownloadAction;
            profiler.trackEvent(list, CustomerMetricsHelper.getExtraEventTag(list.toString()));
        }
    }

    static 
    {
        LOCAL_DOWNLOAD_ROOT_DIR = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    }









}
