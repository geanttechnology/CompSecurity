// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.disk;

import android.os.SystemClock;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.image.Dimension;
import com.amazon.gallery.foundation.image.ImageUtils;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

// Referenced classes of package com.amazon.gallery.framework.network.disk:
//            NetworkStore, ContentLoadCallback

public class CloudDriveNetworkStore
    implements NetworkStore
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent LoadContent;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/network/disk/CloudDriveNetworkStore$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            LoadContent = new MetricsEvent("LoadContent", 0);
            $VALUES = (new MetricsEvent[] {
                LoadContent
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/disk/CloudDriveNetworkStore.getName();
    private final DiskStore diskStore;
    private final MediaItemDao mediaItemDao;
    private NetworkExecutor networkExecutor;
    private ComponentProfiler profiler;
    private final RestClient restClient;

    public CloudDriveNetworkStore(RestClient restclient, DiskStore diskstore, MediaItemDao mediaitemdao)
    {
        restClient = restclient;
        diskStore = diskstore;
        mediaItemDao = mediaitemdao;
        networkExecutor = NetworkExecutor.getInstance();
    }

    public Future loadContent(final MediaItem item, final int width, final int height, final ScaleMode scaleMode, final com.amazon.gallery.framework.data.store.Asset.AssetType assetType, final ContentLoadCallback callback, boolean flag)
    {
        final Timer timer = profiler.newTimer(MetricsEvent.LoadContent);
        final long startTime = SystemClock.uptimeMillis();
        Object obj = ImageUtils.scaleDimension(new Dimension(item.getWidth(), item.getHeight()), new Dimension(width, height), scaleMode);
        int i = MathUtils.roundPower2(Math.max(((Dimension) (obj)).getWidth(), ((Dimension) (obj)).getHeight()));
        final long threadId = Thread.currentThread().getId();
        obj = diskStore.getTempFileForAsset(threadId, item, width, height, assetType, scaleMode);
        scaleMode = new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final CloudDriveNetworkStore this$0;
            final com.amazon.gallery.framework.data.store.Asset.AssetType val$assetType;
            final ContentLoadCallback val$callback;
            final int val$height;
            final MediaItem val$item;
            final ScaleMode val$scaleMode;
            final long val$startTime;
            final long val$threadId;
            final Timer val$timer;
            final int val$width;

            public void onFailure(TerminalException terminalexception)
            {
                timer.remove();
                callback.onContentLoadFailure();
            }

            public volatile void onSuccess(Object obj1)
            {
                onSuccess((Void)obj1);
            }

            public void onSuccess(Void void1)
            {
                void1 = diskStore.storeAsset(threadId, item, width, height, assetType, scaleMode);
                if (void1 != null && void1.exists())
                {
                    timer.stop();
                    GLogger.t(CloudDriveNetworkStore.TAG, startTime, "loadContent network request for %s", new Object[] {
                        item.getObjectId()
                    });
                    callback.onContentLoadSuccess();
                    return;
                } else
                {
                    timer.remove();
                    callback.onContentLoadFailure();
                    return;
                }
            }

            
            {
                this$0 = CloudDriveNetworkStore.this;
                threadId = l;
                item = mediaitem;
                width = i;
                height = j;
                assetType = assettype;
                scaleMode = scalemode;
                timer = timer1;
                startTime = l1;
                callback = contentloadcallback;
                super();
            }
        };
        try
        {
            item = restClient.getDownloadMediaItemOperation(((File) (obj)), item, i);
            timer.start();
        }
        // Misplaced declaration of an exception variable
        catch (final MediaItem item)
        {
            callback.onContentLoadFailure();
            GLogger.e(TAG, "InvalidParameterException!", new Object[0]);
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        return networkExecutor.executeForeground(item, scaleMode);
        item = networkExecutor.executeBackground(item, scaleMode);
        return item;
    }

    public Future loadContent(final MediaItem item, ContentLoadCallback contentloadcallback, boolean flag)
    {
        final File assetFile = diskStore.getTempFileForOriginal(item);
        com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler resulthandler = new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final CloudDriveNetworkStore this$0;
            final File val$assetFile;
            final ContentLoadCallback val$callback;
            final MediaItem val$item;
            final Timer val$timer;

            public void onFailure(TerminalException terminalexception)
            {
                timer.remove();
                callback.onContentLoadFailure();
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((Void)obj);
            }

            public void onSuccess(Void void1)
            {
                if (assetFile != null)
                {
                    void1 = diskStore.storeOriginal(item);
                    if (void1 != null && void1.exists())
                    {
                        timer.stop();
                        callback.onContentLoadSuccess();
                        return;
                    } else
                    {
                        timer.remove();
                        callback.onContentLoadFailure();
                        return;
                    }
                } else
                {
                    timer.remove();
                    callback.onContentLoadFailure();
                    return;
                }
            }

            
            {
                this$0 = CloudDriveNetworkStore.this;
                assetFile = file;
                item = mediaitem;
                timer = timer1;
                callback = contentloadcallback;
                super();
            }
        };
        try
        {
            item = restClient.getDownloadMediaItemOperation(assetFile, item);
        }
        // Misplaced declaration of an exception variable
        catch (final MediaItem item)
        {
            contentloadcallback.onContentLoadFailure();
            GLogger.ex(TAG, "Exception while loading original asset", item);
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        return networkExecutor.executeForeground(item, resulthandler);
        item = networkExecutor.executeBackground(item, resulthandler);
        return item;
    }

    public boolean loadContentSynchronously(MediaItem mediaitem, int i, int j, ScaleMode scalemode, com.amazon.gallery.framework.data.store.Asset.AssetType assettype, boolean flag)
    {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Future future = loadContent(mediaitem, i, j, scalemode, assettype, new ContentLoadCallback() {

            final CloudDriveNetworkStore this$0;
            final CountDownLatch val$countDownLatch;

            public void onContentLoadFailure()
            {
                countDownLatch.countDown();
            }

            public void onContentLoadSuccess()
            {
                countDownLatch.countDown();
            }

            
            {
                this$0 = CloudDriveNetworkStore.this;
                countDownLatch = countdownlatch;
                super();
            }
        }, flag);
        try
        {
            countDownLatch.await();
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem)
        {
            if (future != null)
            {
                future.cancel(true);
            }
            Thread.currentThread().interrupt();
            GLogger.v(TAG, "InterruptedException Waiting for CountDownLatch in CloudDriveNetworkStore", new Object[0]);
            return false;
        }
        mediaitem = diskStore.getAsset(mediaitem, i, j, assettype, scalemode);
        return mediaitem != null && mediaitem.getAsset().exists();
    }

    public boolean loadContentSynchronously(MediaItem mediaitem, boolean flag)
    {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        loadContent(mediaitem, new ContentLoadCallback() {

            final CloudDriveNetworkStore this$0;
            final CountDownLatch val$countDownLatch;

            public void onContentLoadFailure()
            {
                countDownLatch.countDown();
            }

            public void onContentLoadSuccess()
            {
                countDownLatch.countDown();
            }

            
            {
                this$0 = CloudDriveNetworkStore.this;
                countDownLatch = countdownlatch;
                super();
            }
        }, flag);
        try
        {
            countDownLatch.await();
        }
        // Misplaced declaration of an exception variable
        catch (MediaItem mediaitem)
        {
            Thread.currentThread().interrupt();
            GLogger.v(TAG, "InterruptedException Waiting for CountDownLatch in CloudDriveNetworkStore", new Object[0]);
            return false;
        }
        mediaitem = diskStore.getOriginal(mediaitem);
        return mediaitem != null && mediaitem.exists();
    }

    public void setProfiler(Profiler profiler1)
    {
        profiler = new ComponentProfiler(profiler1, com/amazon/gallery/framework/network/disk/CloudDriveNetworkStore);
    }



}
