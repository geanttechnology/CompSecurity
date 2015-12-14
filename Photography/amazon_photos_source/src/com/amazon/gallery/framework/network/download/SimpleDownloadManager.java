// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.SystemClock;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.math.MathUtils;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.thread.NamedThreadFactory;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.AbstractMediaStoreSyncProvider;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.data.model.PhotoBeanImpl;
import com.amazon.gallery.framework.data.model.VideoBeanImpl;
import com.amazon.gallery.framework.gallery.messaging.DownloadFinishedEvent;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            AbstractDownloadManager, CustomDownloadId, DownloadStatusNotifier, DownloadTransaction, 
//            DownloadType, FileDownloadCallback

public class SimpleDownloadManager extends AbstractDownloadManager
{
    private class DownloadRequest
    {

        CustomDownloadId customId;
        File resultFile;
        final SimpleDownloadManager this$0;

        public DownloadRequest(CustomDownloadId customdownloadid, File file)
        {
            this$0 = SimpleDownloadManager.this;
            super();
            customId = customdownloadid;
            resultFile = file;
        }
    }

    private static class DownloadablePhotoBeanImpl extends PhotoBeanImpl
    {

        public DownloadablePhotoBeanImpl(CustomDownloadId customdownloadid)
        {
            objectId = customdownloadid.getMediaItemObjectId();
        }
    }

    private static class DownloadableVideoBeanImpl extends VideoBeanImpl
    {

        public DownloadableVideoBeanImpl(CustomDownloadId customdownloadid)
        {
            objectId = customdownloadid.getMediaItemObjectId();
        }
    }

    private class PendingMediaScanQueue
    {

        private final List downloadedFilePaths = new ArrayList(5);
        final SimpleDownloadManager this$0;

        private void issueScanRequest()
        {
            if (!downloadedFilePaths.isEmpty())
            {
                String as[] = (String[])downloadedFilePaths.toArray(new String[downloadedFilePaths.size()]);
                startMediaScan(as);
            }
        }

        public void enqueue(String s)
        {
            downloadedFilePaths.add(s);
            if (downloadedFilePaths.size() == 5)
            {
                flush();
            }
        }

        public void flush()
        {
            issueScanRequest();
            downloadedFilePaths.clear();
        }

        public PendingMediaScanQueue()
        {
            this$0 = SimpleDownloadManager.this;
            super();
        }
    }

    private class SimpleDownloadRunnable
        implements Runnable
    {

        private final DownloadRequest downloadRequest;
        final SimpleDownloadManager this$0;

        private void consume(DownloadRequest downloadrequest)
        {
            CustomDownloadId customdownloadid;
            FileDownloadCallback filedownloadcallback;
            File file;
            downloadsActive.incrementAndGet();
            customdownloadid = downloadrequest.customId;
            file = downloadrequest.resultFile;
            GLogger.d(SimpleDownloadManager.TAG, "Downloading %s", new Object[] {
                customdownloadid
            });
            downloadStatusNotifier.onItemDownloadStarted(customdownloadid, file.getName());
            filedownloadcallback = getCallback(customdownloadid);
            if (customdownloadid.getMediaType() != MediaType.VIDEO) goto _L2; else goto _L1
_L1:
            downloadrequest = new DownloadableVideoBeanImpl(customdownloadid);
_L3:
            if (customdownloadid.getRequestType() != CustomDownloadId.RequestType.ORIGINAL)
            {
                break MISSING_BLOCK_LABEL_265;
            }
            restClient.getDownloadMediaItemOperation(file, downloadrequest).get();
_L4:
            downloadrequest = (PendingMediaScanQueue)pendingMediaScanQueueMap.get(customdownloadid.getTag());
            if (downloadrequest != null && file.exists() && customdownloadid.getCategory() != 2)
            {
                downloadrequest.enqueue(file.getAbsolutePath());
            }
            int i;
            if (file.exists())
            {
                downloadStatusNotifier.onItemDownloadCompleted(customdownloadid);
                GlobalMessagingBus.post(new DownloadFinishedEvent(customdownloadid, true));
                if (filedownloadcallback != null)
                {
                    filedownloadcallback.onDownloadCompleted(customdownloadid, file);
                }
                if (downloadQueue.isEmpty() && customdownloadid.getCategory() != 2)
                {
                    ((PendingMediaScanQueue)pendingMediaScanQueueMap.get(ObjectID.getRoot())).flush();
                }
                return;
            } else
            {
                reportFailure(customdownloadid, filedownloadcallback);
                return;
            }
_L2:
            try
            {
                downloadrequest = new DownloadablePhotoBeanImpl(customdownloadid);
            }
            // Misplaced declaration of an exception variable
            catch (DownloadRequest downloadrequest)
            {
                GLogger.ex(SimpleDownloadManager.TAG, downloadrequest.getMessage(), downloadrequest);
                reportFailure(customdownloadid, filedownloadcallback);
                return;
            }
              goto _L3
            i = MathUtils.roundPower2(Math.max(customdownloadid.getDesiredWidth(), customdownloadid.getDesiredHeight()));
            restClient.getDownloadMediaItemOperation(file, downloadrequest, i, customdownloadid.getMediaType()).get();
              goto _L4
        }

        public DownloadRequest getDownloadRequest()
        {
            return downloadRequest;
        }

        public void reportFailure(CustomDownloadId customdownloadid, FileDownloadCallback filedownloadcallback)
        {
            if (customdownloadid.getCategory() != 2)
            {
                downloadStatusNotifier.onItemDownloadFailed(customdownloadid);
                GlobalMessagingBus.post(new DownloadFinishedEvent(customdownloadid, false));
                if (filedownloadcallback != null)
                {
                    filedownloadcallback.onDownloadFail(customdownloadid, "unknown");
                    return;
                }
            }
        }

        public void run()
        {
            GLogger.d(SimpleDownloadManager.TAG, "Started DownloadConsumer thread", new Object[0]);
            consume(downloadRequest);
        }

        public SimpleDownloadRunnable(DownloadRequest downloadrequest)
        {
            this$0 = SimpleDownloadManager.this;
            super();
            downloadRequest = downloadrequest;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/network/download/SimpleDownloadManager.getName();
    private final Context context;
    private ExecutorService downloadExecutor;
    private final BlockingQueue downloadQueue = new LinkedBlockingQueue();
    private final DownloadStatusNotifier downloadStatusNotifier;
    private final AtomicInteger downloadsActive = new AtomicInteger(0);
    private final MediaScannerConnection mediaScannerConnection;
    protected final AbstractMediaStoreSyncProvider mediaStoreSyncProvider;
    private final NetworkConnectivity networkConnectivity;
    private final Map pendingMediaScanQueueMap = new HashMap();
    private final RestClient restClient;

    public SimpleDownloadManager(Context context1, RestClient restclient, NetworkConnectivity networkconnectivity, MediaStoreSyncProvider mediastoresyncprovider, DownloadStatusNotifier downloadstatusnotifier)
    {
        context = context1;
        restClient = restclient;
        networkConnectivity = networkconnectivity;
        mediaStoreSyncProvider = (AbstractMediaStoreSyncProvider)mediastoresyncprovider;
        mediaScannerConnection = (MediaScannerConnection)ThorGalleryApplication.getBean(Keys.MEDIA_SCANNER_CONNECTION);
        pendingMediaScanQueueMap.put(ObjectID.getRoot(), new PendingMediaScanQueue());
        downloadStatusNotifier = downloadstatusnotifier;
    }

    public void addDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, DownloadTransaction downloadtransaction)
    {
        customdownloadid = new SimpleDownloadRunnable(new DownloadRequest(customdownloadid, new File(s1)));
        downloadExecutor.execute(customdownloadid);
    }

    public void addSingleItemDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, String s2, Uri uri)
    {
        addDownloadRequest(customdownloadid, s, s1, null);
    }

    public void addWhisperCacheDownloadRequest(CustomDownloadId customdownloadid, String s, String s1, DownloadType downloadtype, DownloadTransaction downloadtransaction)
    {
        if (networkConnectivity.isNetworkAccessAllowed(com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.NetworkOperationType.PREFETCH_BACKGROUND))
        {
            long l = SystemClock.elapsedRealtime();
            addDownloadRequest(customdownloadid, s, s1, null);
            l = 20L - (System.currentTimeMillis() - l);
            if (l > 0L)
            {
                SystemClock.sleep(l);
                return;
            }
        }
    }

    public void cancelDownload(CustomDownloadId customdownloadid)
    {
        GLogger.d(TAG, "Canceling all downloads for tag %s", new Object[] {
            customdownloadid.getTag()
        });
        Iterator iterator = downloadQueue.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CustomDownloadId customdownloadid1 = ((SimpleDownloadRunnable)iterator.next()).getDownloadRequest().customId;
            if (customdownloadid.getTag().equals(customdownloadid1.getTag()))
            {
                GLogger.d(TAG, "Removing matching download %s", new Object[] {
                    customdownloadid1
                });
                iterator.remove();
            }
        } while (true);
    }

    public void commitDownloadRequest(DownloadTransaction downloadtransaction)
    {
    }

    public void finishDownload(CustomDownloadId customdownloadid)
    {
        PendingMediaScanQueue pendingmediascanqueue = (PendingMediaScanQueue)pendingMediaScanQueueMap.get(customdownloadid.getTag());
        if (pendingmediascanqueue != null)
        {
            pendingmediascanqueue.flush();
        }
        pendingMediaScanQueueMap.remove(customdownloadid.getTag());
        super.finishDownload(customdownloadid);
    }

    public Set getIncompleteDownloads()
    {
        HashSet hashset = new HashSet(downloadQueue.size());
        for (Iterator iterator = downloadQueue.iterator(); iterator.hasNext(); hashset.add(((SimpleDownloadRunnable)iterator.next()).getDownloadRequest().customId)) { }
        return hashset;
    }

    public boolean hasIncompleteDownloads()
    {
        return downloadsActive.get() > 0;
    }

    public void init()
    {
        NamedThreadFactory namedthreadfactory = new NamedThreadFactory("SimpleDownloader", 2);
        downloadExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, downloadQueue, namedthreadfactory);
    }

    public DownloadTransaction startDownload(CustomDownloadId customdownloadid, FileDownloadCallback filedownloadcallback, String s, Uri uri)
    {
        PendingMediaScanQueue pendingmediascanqueue = (PendingMediaScanQueue)pendingMediaScanQueueMap.get(customdownloadid.getTag());
        if (pendingmediascanqueue != null)
        {
            pendingmediascanqueue.flush();
        } else
        {
            pendingMediaScanQueueMap.put(customdownloadid.getTag(), new PendingMediaScanQueue());
        }
        return super.startDownload(customdownloadid, filedownloadcallback, s, uri);
    }

    protected transient void startMediaScan(final String filesToScan[])
    {
        if (!mediaScannerConnection.isConnected())
        {
            mediaStoreSyncProvider.attachOneOffOnConnectListener(new Runnable() {

                final SimpleDownloadManager this$0;
                final String val$filesToScan[];

                public void run()
                {
                    startMediaScan(filesToScan);
                }

            
            {
                this$0 = SimpleDownloadManager.this;
                filesToScan = as;
                super();
            }
            });
            mediaScannerConnection.connect();
            return;
        } else
        {
            MediaScannerConnection mediascannerconnection = mediaScannerConnection;
            MediaScannerConnection.scanFile(context, filesToScan, null, new android.media.MediaScannerConnection.OnScanCompletedListener() {

                final SimpleDownloadManager this$0;

                public void onScanCompleted(String s, Uri uri)
                {
                    if (downloadsActive.decrementAndGet() == 0)
                    {
                        mediaStoreSyncProvider.syncMediaStore(false);
                    }
                }

            
            {
                this$0 = SimpleDownloadManager.this;
                super();
            }
            });
            return;
        }
    }

    public DownloadTransaction startWhisperCacheDownload(CustomDownloadId customdownloadid, String s, DownloadType downloadtype)
    {
        return null;
    }







}
