// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.download;

import android.content.Context;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.DownloadStatusEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskEvictor;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.DownloadManagerRetryWatchdog;
import com.amazon.gallery.framework.network.RetryWatchdog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.io.FilenameUtils;

// Referenced classes of package com.amazon.gallery.framework.network.download:
//            AbstractDownloadManager, DownloadTransaction, DownloadType, CustomDownloadId, 
//            DownloadStatusNotifier, DownloadIconHelper, GalleryDownloadListener, FileDownloadCallback

public class GalleryDownloadManager
    implements AccountChangeListener
{
    private static interface CustomDownloadIdGenerator
    {

        public abstract CustomDownloadId generateId(MediaItem mediaitem);
    }

    private static interface ResultFileGenerator
    {

        public abstract File generateResultFile(MediaItem mediaitem);
    }

    private class TagDownloadCallback
        implements FileDownloadCallback
    {

        private final AtomicInteger count = new AtomicInteger();
        private final CustomDownloadId groupCustomId;
        final GalleryDownloadManager this$0;

        private boolean isInCacheDir(File file)
        {
            return file.getAbsolutePath().startsWith(cacheDir.getAbsolutePath());
        }

        private void onProgress(CustomDownloadId customdownloadid)
        {
            int i = count.incrementAndGet();
            if (customdownloadid != null && tagListeners.containsKey(customdownloadid.getTag()))
            {
                ((GalleryDownloadListener)tagListeners.get(customdownloadid.getTag())).onProgress(customdownloadid.getTag(), customdownloadid.getMediaItemObjectId(), i, groupCustomId.getTotal());
            }
            if (i == groupCustomId.getTotal())
            {
                downloadManager.finishDownload(groupCustomId);
            }
        }

        private void reportCacheUsage(File file)
        {
            Asset asset = Asset.createFromFilePath(file);
            if (asset != null && file.exists())
            {
                diskEvictor.onStoreAsset(asset, false);
                return;
            } else
            {
                GLogger.w(GalleryDownloadManager.TAG, "FileDownloadManager reported a success, but there is no asset stored.", new Object[0]);
                return;
            }
        }

        public void initListener(GalleryDownloadListener gallerydownloadlistener)
        {
            gallerydownloadlistener.onProgress(groupCustomId.getTag(), groupCustomId.getMediaItemObjectId(), count.get(), groupCustomId.getTotal());
        }

        public void onDownloadCompleted(CustomDownloadId customdownloadid, File file)
        {
            onProgress(customdownloadid);
            GLogger.v(GalleryDownloadManager.TAG, "MediaItem Downloaded customDownloadId=%s, file=%s", new Object[] {
                customdownloadid, file
            });
            if (isInCacheDir(file))
            {
                reportCacheUsage(file);
            }
        }

        public void onDownloadFail(CustomDownloadId customdownloadid, String s)
        {
            onProgress(customdownloadid);
            GLogger.w(GalleryDownloadManager.TAG, "Can't download customId=%s, message=%s", new Object[] {
                customdownloadid, s
            });
        }

        public TagDownloadCallback(CustomDownloadId customdownloadid)
        {
            this$0 = GalleryDownloadManager.this;
            super();
            groupCustomId = customdownloadid;
        }
    }


    public static final String TAG = com/amazon/gallery/framework/network/download/GalleryDownloadManager.getName();
    private boolean accountRegistered;
    private boolean busRegistered;
    private final File cacheDir;
    private ThreadLocal currentTransaction;
    private final DiskEvictor diskEvictor;
    private final DownloadIconHelper downloadIconHelper;
    private final AbstractDownloadManager downloadManager;
    private final DownloadStatusNotifier downloadStatusNotifier;
    private final RetryWatchdog retryWatchdog;
    private final Map tagListeners = new HashMap();

    public GalleryDownloadManager(Context context, AbstractDownloadManager abstractdownloadmanager, DownloadIconHelper downloadiconhelper, DiskEvictor diskevictor, DownloadManagerRetryWatchdog downloadmanagerretrywatchdog, DownloadStatusNotifier downloadstatusnotifier)
    {
        accountRegistered = true;
        busRegistered = false;
        currentTransaction = new ThreadLocal();
        cacheDir = context.getCacheDir();
        downloadManager = abstractdownloadmanager;
        downloadIconHelper = downloadiconhelper;
        diskEvictor = diskevictor;
        retryWatchdog = downloadmanagerretrywatchdog;
        downloadStatusNotifier = downloadstatusnotifier;
        if (!busRegistered)
        {
            GlobalMessagingBus.register(this);
            busRegistered = true;
        }
    }

    private boolean addCacheRequest(MediaItem mediaitem, File file, DownloadType downloadtype, CustomDownloadId customdownloadid)
    {
        if (mediaitem.hasProperty(CommonMediaProperty.LOCAL) || file.exists())
        {
            return false;
        }
        if (!retryWatchdog.mightContain(customdownloadid))
        {
            mediaitem = getTransaction(mediaitem, downloadtype);
            downloadManager.addWhisperCacheDownloadRequest(customdownloadid, "http://photos_app_placeholder_url_whispercache", file.getAbsolutePath(), downloadtype, mediaitem);
            return true;
        } else
        {
            GLogger.i(TAG, "Download id %s has failed earlier, abandon request with expected fpp %s", new Object[] {
                customdownloadid, Double.valueOf(retryWatchdog.expectedFalsePositiveProbability())
            });
            return false;
        }
    }

    private int cacheMediaItemGroup(List list, CustomDownloadIdGenerator customdownloadidgenerator, ResultFileGenerator resultfilegenerator, int i, DownloadType downloadtype)
        throws InterruptedException
    {
        Set set;
        set = downloadManager.getIncompleteDownloads();
        list = list.iterator();
_L7:
        if (!list.hasNext() || i >= 1000) goto _L2; else goto _L1
_L1:
        if (accountRegistered) goto _L4; else goto _L3
_L3:
        return i;
_L4:
        MediaItem mediaitem = (MediaItem)list.next();
        CustomDownloadId customdownloadid = customdownloadidgenerator.generateId(mediaitem);
        int j = i;
        if (!set.contains(customdownloadid))
        {
            j = i;
            if (addCacheRequest(mediaitem, resultfilegenerator.generateResultFile(mediaitem), downloadtype, customdownloadid))
            {
                j = i + 1;
            }
        }
        i = j;
        if (j > 0)
        {
            i = j;
            if (j % 1000 == 0)
            {
                i = j;
                if (currentTransaction.get() != null)
                {
                    downloadManager.commitDownloadRequest((DownloadTransaction)currentTransaction.get());
                    currentTransaction.set(null);
                    Thread.sleep(1000L);
                    i = j;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i <= 0 || i % 1000 == 0 || currentTransaction.get() == null) goto _L3; else goto _L5
_L5:
        downloadManager.commitDownloadRequest((DownloadTransaction)currentTransaction.get());
        currentTransaction.set(null);
        Thread.sleep(1000L);
        return i;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void cacheMediaItems(List list, CustomDownloadIdGenerator customdownloadidgenerator, ResultFileGenerator resultfilegenerator, int i, int j)
        throws InterruptedException
    {
        if (!list.isEmpty() && i != 0)
        {
            int k;
            if (j > list.size())
            {
                k = list.size();
            } else
            {
                k = j;
            }
            k = cacheMediaItemGroup(list.subList(0, k), customdownloadidgenerator, resultfilegenerator, 0, DownloadType.Normal);
            if (list.size() - j > 0)
            {
                if (i > list.size())
                {
                    i = list.size();
                }
                cacheMediaItemGroup(list.subList(j, i), customdownloadidgenerator, resultfilegenerator, k, DownloadType.Cache);
                return;
            }
        }
    }

    private static String getBaseName(String s)
    {
        int i = s.lastIndexOf(".");
        String s1 = s;
        if (i != -1)
        {
            s1 = s.substring(0, i);
        }
        return s1;
    }

    private static String getMediaItemName(MediaItem mediaitem)
    {
label0:
        {
            String s = mediaitem.getName();
            Object obj;
            String s1;
            if (mediaitem.getMIMEType().equals("image/gif"))
            {
                obj = com.amazon.gallery.framework.data.store.Asset.AssetType.GIF;
            } else
            {
                obj = com.amazon.gallery.framework.data.store.Asset.AssetType.getAssetType(mediaitem.getType());
            }
            s1 = ((com.amazon.gallery.framework.data.store.Asset.AssetType) (obj)).getFileExtension();
            if (s != null)
            {
                obj = s;
                if (!s.isEmpty())
                {
                    break label0;
                }
            }
            obj = (new StringBuilder()).append(mediaitem.getObjectId().toString().replaceAll("-", "").trim()).append(s1).toString();
        }
        return (new StringBuilder()).append(getBaseName(((String) (obj)))).append(s1).toString();
    }

    private DownloadTransaction getTransaction(MediaItem mediaitem, DownloadType downloadtype)
    {
        DownloadTransaction downloadtransaction1 = (DownloadTransaction)currentTransaction.get();
        DownloadTransaction downloadtransaction = downloadtransaction1;
        if (downloadtransaction1 == null)
        {
            mediaitem = new CustomDownloadId(mediaitem.getObjectId());
            mediaitem.setMediaType(MediaType.PHOTO);
            downloadtransaction = downloadManager.startWhisperCacheDownload(mediaitem, "WhisperCache", downloadtype);
            currentTransaction.set(downloadtransaction);
        }
        return downloadtransaction;
    }

    private void notifyDownloadStarted(CustomDownloadId customdownloadid)
    {
        downloadStatusNotifier.onDownloadQueueCreated(customdownloadid);
    }

    public void addListener(ObjectID objectid, GalleryDownloadListener gallerydownloadlistener)
    {
        tagListeners.put(objectid, gallerydownloadlistener);
        if (downloadManager.hasCallback(objectid))
        {
            ((TagDownloadCallback)downloadManager.getCallbackByKey(objectid)).initListener(gallerydownloadlistener);
        }
    }

    public void cacheMediaItemOriginals(List list, final DiskStore diskStore, int i, int j)
        throws InterruptedException
    {
        cacheMediaItems(list, new CustomDownloadIdGenerator() {

            final GalleryDownloadManager this$0;

            public CustomDownloadId generateId(MediaItem mediaitem)
            {
                mediaitem = new CustomDownloadId(mediaitem.getObjectId());
                mediaitem.setMediaType(MediaType.PHOTO);
                mediaitem.setRequestType(CustomDownloadId.RequestType.ORIGINAL);
                return mediaitem;
            }

            
            {
                this$0 = GalleryDownloadManager.this;
                super();
            }
        }, new ResultFileGenerator() {

            final GalleryDownloadManager this$0;
            final DiskStore val$diskStore;

            public File generateResultFile(MediaItem mediaitem)
            {
                return diskStore.getOriginal(mediaitem);
            }

            
            {
                this$0 = GalleryDownloadManager.this;
                diskStore = diskstore;
                super();
            }
        }, i, j);
    }

    public void cacheMediaItems(List list, final int width, final int height, final DiskStore diskStore, int i, int j)
        throws InterruptedException
    {
        cacheMediaItems(list, new CustomDownloadIdGenerator() {

            final GalleryDownloadManager this$0;
            final int val$height;
            final int val$width;

            public CustomDownloadId generateId(MediaItem mediaitem)
            {
                mediaitem = new CustomDownloadId(mediaitem.getObjectId());
                mediaitem.setMediaType(MediaType.PHOTO);
                mediaitem.setRequestType(CustomDownloadId.RequestType.ASSET);
                mediaitem.setDesiredWidth(width);
                mediaitem.setDesiredHeight(height);
                return mediaitem;
            }

            
            {
                this$0 = GalleryDownloadManager.this;
                width = i;
                height = j;
                super();
            }
        }, new ResultFileGenerator() {

            final GalleryDownloadManager this$0;
            final DiskStore val$diskStore;
            final int val$height;
            final int val$width;

            public File generateResultFile(MediaItem mediaitem)
            {
                return diskStore.getAsset(mediaitem, width, height, com.amazon.gallery.framework.data.store.Asset.AssetType.JPG).getAsset();
            }

            
            {
                this$0 = GalleryDownloadManager.this;
                diskStore = diskstore;
                width = i;
                height = j;
                super();
            }
        }, i, j);
    }

    protected CustomDownloadId createCustomDownloadId(ObjectID objectid, MediaItem mediaitem)
    {
        objectid = new CustomDownloadId(objectid, mediaitem.getObjectId());
        if (mediaitem.getGroupType() == GroupType.LENTICULAR || mediaitem.getMIMEType().equals("image/gif"))
        {
            objectid.setMediaType(mediaitem.getType());
            objectid.setRequestType(CustomDownloadId.RequestType.ORIGINAL);
            return objectid;
        } else
        {
            objectid.setMediaType(mediaitem.getType());
            objectid.setRequestType(CustomDownloadId.RequestType.ASSET);
            objectid.setDesiredWidth(2048);
            objectid.setDesiredHeight(2048);
            return objectid;
        }
    }

    public CustomDownloadId downloadMediaItem(MediaItem mediaitem, File file)
    {
        if (mediaitem.hasProperty(CommonMediaProperty.LOCAL))
        {
            GLogger.i(TAG, "Skipping local media item download", new Object[0]);
            return null;
        } else
        {
            CustomDownloadId customdownloadid = createCustomDownloadId(ObjectID.getRoot(), mediaitem);
            String s = getMediaItemName(mediaitem);
            mediaitem = downloadIconHelper.getIconForDownload(mediaitem);
            downloadManager.addSingleItemDownloadRequest(customdownloadid, "http://photos_app_placeholder_url_mediaItem", file.getAbsolutePath(), s, mediaitem);
            return customdownloadid;
        }
    }

    public void downloadMediaItems(Tag tag, Collection collection, File file)
    {
        int i = collection.size();
        CustomDownloadId customdownloadid = new CustomDownloadId(tag.getObjectId(), i);
        TagDownloadCallback tagdownloadcallback = new TagDownloadCallback(customdownloadid);
        android.net.Uri uri = downloadIconHelper.getIconForDownload(tag);
        DownloadTransaction downloadtransaction = downloadManager.startDownload(customdownloadid, tagdownloadcallback, tag.getLabel(), uri);
        if (tagListeners.containsKey(tag.getObjectId()))
        {
            ((GalleryDownloadListener)tagListeners.get(tag.getObjectId())).onRequested(tag.getObjectId());
        }
        notifyDownloadStarted(customdownloadid);
        i = 0;
        Iterator iterator = collection.iterator();
label0:
        do
        {
            File file2;
            CustomDownloadId customdownloadid1;
label1:
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                MediaItem mediaitem = (MediaItem)iterator.next();
                customdownloadid1 = createCustomDownloadId(tag.getObjectId(), mediaitem);
                File file1 = null;
                if (MediaItemUtil.isLocalMediaItem(mediaitem))
                {
                    file1 = new File(mediaitem.getLocalPath());
                }
                if (file1 != null)
                {
                    file2 = file1;
                    if (file1.exists())
                    {
                        break label1;
                    }
                }
                file2 = new File(file, getMediaItemName(mediaitem));
            }
            if (file2.exists())
            {
                tagdownloadcallback.onDownloadCompleted(customdownloadid1, file2);
                i++;
            } else
            {
                downloadManager.addDownloadRequest(customdownloadid1, "http://photos_app_placeholder_url_album", file2.getAbsolutePath(), downloadtransaction);
            }
        } while (true);
        if (i == collection.size())
        {
            downloadManager.cancelDownload(customdownloadid);
            return;
        } else
        {
            downloadManager.commitDownloadRequest(downloadtransaction);
            return;
        }
    }

    public void downloadMediaItems(Collection collection, File file)
    {
        Iterator iterator;
        int i = collection.size();
        notifyDownloadStarted(new CustomDownloadId(ObjectID.getRoot(), i));
        iterator = collection.iterator();
_L10:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj;
        MediaItem mediaitem;
        String s;
        mediaitem = (MediaItem)iterator.next();
        if (mediaitem.hasProperty(CommonMediaProperty.LOCAL))
        {
            GLogger.i(TAG, "Skipping local media item download", new Object[0]);
            continue; /* Loop/switch isn't completed */
        }
        s = getMediaItemName(mediaitem);
        collection = new File(file, s);
        obj = collection;
        if (!collection.exists()) goto _L4; else goto _L3
_L3:
        int j;
        obj = FilenameUtils.getBaseName(s);
        s = FilenameUtils.getExtension(s);
        j = 0;
_L8:
        if (j >= 100) goto _L6; else goto _L5
_L5:
        collection = new File(file, String.format("%s_%d.%s", new Object[] {
            obj, Integer.valueOf(j), s
        }));
        if (collection.exists()) goto _L7; else goto _L6
_L6:
        if (j >= 100)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = collection;
_L4:
        downloadMediaItem(mediaitem, ((File) (obj)));
        continue; /* Loop/switch isn't completed */
_L7:
        j++;
        if (true) goto _L8; else goto _L2
_L2:
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public boolean hasIncompleteDownloads()
    {
        return downloadManager.hasIncompleteDownloads();
    }

    public void init()
    {
        downloadManager.init();
    }

    public void onAccountDeregistered()
    {
        accountRegistered = false;
        downloadManager.clearDownloadQueue();
        downloadStatusNotifier.onDownloadQueuesCleared();
    }

    public void onAccountRegistered()
    {
        accountRegistered = true;
    }

    public DownloadStatusEvent produceDownloadQueueStatusEvent()
    {
        boolean flag;
        if (!hasIncompleteDownloads())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new DownloadStatusEvent(flag);
    }

    public void removeDownload(ObjectID objectid)
    {
        objectid = new CustomDownloadId(objectid, 0);
        downloadManager.cancelDownload(objectid);
        downloadStatusNotifier.onDownloadQueueRemoved(objectid);
    }

    public void removeListener(ObjectID objectid)
    {
        tagListeners.remove(objectid);
    }





}
