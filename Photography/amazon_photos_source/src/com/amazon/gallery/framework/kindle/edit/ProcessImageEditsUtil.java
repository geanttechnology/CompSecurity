// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.edit;

import android.content.Context;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import com.amazon.gallery.foundation.image.BitmapDecoder;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.MediaStoreSyncProvider;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.gallery.actions.DeleteAction;
import com.amazon.gallery.framework.kindle.action.ActionFactory;
import com.amazon.gallery.framework.kindle.action.EditMediaItemAction;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.mutable.MutableBoolean;

// Referenced classes of package com.amazon.gallery.framework.kindle.edit:
//            PreScanEditsListener

public class ProcessImageEditsUtil
{

    private static final String TAG = com/amazon/gallery/framework/kindle/edit/ProcessImageEditsUtil.getName();
    protected final Context appContext;
    protected MediaScannerConnection connection;
    protected final DiskStore diskStore;
    protected final DynamicAlbumDao dynamicAlbumDao;
    protected final MediaItemDao mediaItemDao;
    protected final MediaStoreSyncProvider mediaStoreSyncProvider;
    protected final NetworkStore networkStore;
    protected List preScanEditsListeners;
    protected final ExecutorService threadPoolExecutor = Executors.newSingleThreadExecutor();

    public ProcessImageEditsUtil(MediaItemDao mediaitemdao, DynamicAlbumDao dynamicalbumdao, DiskStore diskstore, MediaScannerConnection mediascannerconnection, MediaStoreSyncProvider mediastoresyncprovider, Context context, NetworkStore networkstore)
    {
        preScanEditsListeners = new ArrayList();
        mediaItemDao = mediaitemdao;
        dynamicAlbumDao = dynamicalbumdao;
        diskStore = diskstore;
        connection = mediascannerconnection;
        appContext = context;
        mediaStoreSyncProvider = mediastoresyncprovider;
        networkStore = networkstore;
    }

    private void addToDynamicAlbumCache(MediaItem mediaitem)
    {
        Iterator iterator = mediaitem.getTags().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Tag tag = (Tag)iterator.next();
            if (TagType.ALBUM == tag.getType())
            {
                ArrayList arraylist = new ArrayList(1);
                arraylist.add(Long.valueOf(mediaitem.getId()));
                dynamicAlbumDao.addToDynamicAlbum(tag.getId(), arraylist);
            }
        } while (true);
    }

    private void setDateMetadata(MediaItem mediaitem, Uri uri)
    {
        MediaItem mediaitem1 = null;
        if (mediaitem.getParentObjectID() != null)
        {
            mediaitem1 = mediaItemDao.getItemById(mediaitem.getParentObjectID());
        }
        long l = EditMediaItemAction.parseDate((new File(uri.getPath())).getName());
        uri = Calendar.getInstance();
        if (mediaitem1 != null)
        {
            mediaitem.setDateCreatedMs(mediaitem1.getDateCreatedMs());
            mediaitem.setDateCreatedUTCMs(mediaitem1.getDateCreatedUTCMs());
            mediaitem.setTimestampMs(mediaitem1.getTimestampMs());
        } else
        {
            GLogger.e(TAG, "Could not get original media item, falling back to parsed file name date", new Object[0]);
            mediaitem.setDateCreatedMs(l);
            mediaitem.setDateCreatedUTCMs(l);
            mediaitem.setTimestampMs(l);
        }
        mediaitem.setDateModifiedMs(uri.getTimeInMillis());
        mediaitem.setDateAddedMs(uri.getTimeInMillis());
    }

    public void addPreScanEditsListener(PreScanEditsListener prescaneditslistener)
    {
        preScanEditsListeners.add(prescaneditslistener);
    }

    public void delete(BeanAwareActivity beanawareactivity, Uri uri)
    {
label0:
        {
            uri = mediaItemDao.getItemsByLocalPath(uri.getPath()).getMediaItems();
            if (uri.size() > 1)
            {
                GLogger.e(TAG, "Found more than 1 item with the same local path when deleting from uri", new Object[0]);
                if (BuildFlavors.isDebug())
                {
                    throw new IllegalStateException(String.format("Expected 1 media item, found %d", new Object[] {
                        Integer.valueOf(uri.size())
                    }));
                }
            } else
            {
                if (!uri.isEmpty())
                {
                    break label0;
                }
                GLogger.w(TAG, "Found 0 items when trying to delete edited photo", new Object[0]);
            }
            return;
        }
        ((DeleteAction)ActionFactory.createAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/DeleteAction)).executeWithoutDialog(uri);
    }

    public MediaItem processCloudEdit(Uri uri, Tag tag)
    {
        final MediaItem newMediaItem = mediaItemDao.create(MediaType.PHOTO);
        File file = new File(uri.getPath());
        Object obj = EditMediaItemAction.parseParentId(file.getName());
        if (obj != null)
        {
            newMediaItem.setParentObjectID(((ObjectID) (obj)));
        }
        File file1;
        try
        {
            obj = BitmapDecoder.getBitmapDimensions(appContext, uri);
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            GLogger.ex(TAG, "File not found while loading bitmap dimensions.", uri);
            return null;
        }
        file1 = new File(file.getParent(), EditMediaItemAction.removeArgumentsFromName(file.getName()));
        file.renameTo(file1);
        setMediaItemData(newMediaItem, uri, file1, ((android.graphics.BitmapFactory.Options) (obj)), tag);
        mediaItemDao.saveMergedFields(newMediaItem, true);
        addToDynamicAlbumCache(newMediaItem);
        threadPoolExecutor.execute(new Runnable() {

            final ProcessImageEditsUtil this$0;
            final MediaItem val$newMediaItem;

            public void run()
            {
                try
                {
                    ExifInterface exifinterface = new ExifInterface(newMediaItem.getLocalPath());
                    exifinterface.setAttribute("DateTime", DateUtils.getDateFormatWithoutTimeZone(newMediaItem.getDateCreatedMs()));
                    exifinterface.saveAttributes();
                    return;
                }
                catch (IOException ioexception)
                {
                    Log.w(ProcessImageEditsUtil.TAG, "Failed to write EXIF Data");
                }
            }

            
            {
                this$0 = ProcessImageEditsUtil.this;
                newMediaItem = mediaitem;
                super();
            }
        });
        return newMediaItem;
    }

    public MediaItem processEdit(Uri uri, boolean flag, Tag tag)
    {
        File file = new File(uri.getPath());
        File file1 = new File(file.getParent(), EditMediaItemAction.removeArgumentsFromName(file.getName()));
        file.renameTo(file1);
        if (EditMediaItemAction.isInTempEditDir(appContext, file1.getAbsolutePath()))
        {
            return null;
        } else
        {
            return scanMediaItem(uri, file1, flag, tag);
        }
    }

    public MediaItem processLocalEdit(Uri uri)
    {
        return processEdit(uri, false, null);
    }

    public MediaItem processUnifiedEdit(Uri uri, Tag tag)
    {
        return processEdit(uri, true, tag);
    }

    protected MediaItem scanMediaItem(final Uri editedImageUri, final File file, final boolean isUnified, final Tag currentTag)
    {
        final MutableBoolean syncIsDone;
        final ArrayList mediaItems;
        GLogger.i(TAG, "ScanMediaItem called()", new Object[0]);
        syncIsDone = new MutableBoolean(false);
        mediaItems = new ArrayList();
        connection = new MediaScannerConnection(appContext, new android.media.MediaScannerConnection.MediaScannerConnectionClient() {

            final ProcessImageEditsUtil this$0;
            final Tag val$currentTag;
            final Uri val$editedImageUri;
            final File val$file;
            final boolean val$isUnified;
            final List val$mediaItems;
            final MutableBoolean val$syncIsDone;

            public void onMediaScannerConnected()
            {
                for (Iterator iterator = preScanEditsListeners.iterator(); iterator.hasNext(); ((PreScanEditsListener)iterator.next()).preScan(file)) { }
                connection.scanFile(file.getAbsolutePath(), "image/jpeg");
            }

            public void onScanCompleted(String s, Uri uri)
            {
                SystemClock.sleep(TimeUnit.SECONDS.toMillis(1L));
                mediaStoreSyncProvider.syncMediaStore(false, false);
                if (connection.isConnected())
                {
                    connection.disconnect();
                }
                s = syncIsDone;
                s;
                JVM INSTR monitorenter ;
                Iterator iterator;
                syncIsDone.setValue(true);
                iterator = mediaItemDao.getItemsByLocalPath(file.getAbsolutePath()).getMediaItems().iterator();
_L5:
                if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
                Object obj;
                Object obj1;
                obj = (MediaItem)iterator.next();
                ((MediaItem) (obj)).getMetadata().put("media-store.uri", uri.toString());
                ((MediaItem) (obj)).setGroupType(GroupType.EDIT);
                obj1 = EditMediaItemAction.parseParentId(FilenameUtils.getName(editedImageUri.getPath()));
                if (obj1 == null)
                {
                    break MISSING_BLOCK_LABEL_170;
                }
                ((MediaItem) (obj)).setParentObjectID(((ObjectID) (obj1)));
                boolean flag = isUnified;
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_285;
                }
                obj1 = BitmapDecoder.getBitmapDimensions(file.getAbsolutePath());
                setMediaItemData(((MediaItem) (obj)), editedImageUri, file, ((android.graphics.BitmapFactory.Options) (obj1)), currentTag);
_L3:
                mediaItemDao.saveMergedFields(((MediaItem) (obj)), true);
                addToDynamicAlbumCache(((MediaItem) (obj)));
                mediaItems.add(obj);
                continue; /* Loop/switch isn't completed */
                uri;
                syncIsDone.notifyAll();
                throw uri;
                uri;
                s;
                JVM INSTR monitorexit ;
                throw uri;
                obj;
                GLogger.ex(ProcessImageEditsUtil.TAG, "File not found while loading bitmap dimensions.", ((Throwable) (obj)));
                continue; /* Loop/switch isn't completed */
                setDateMetadata(((MediaItem) (obj)), editedImageUri);
                  goto _L3
_L2:
                syncIsDone.notifyAll();
                s;
                JVM INSTR monitorexit ;
                return;
                if (true) goto _L5; else goto _L4
_L4:
            }

            
            {
                this$0 = ProcessImageEditsUtil.this;
                file = file1;
                syncIsDone = mutableboolean;
                editedImageUri = uri;
                isUnified = flag;
                currentTag = tag;
                mediaItems = list;
                super();
            }
        });
        connection.connect();
        syncIsDone;
        JVM INSTR monitorenter ;
        try
        {
            for (; !syncIsDone.getValue().booleanValue(); syncIsDone.wait()) { }
            break MISSING_BLOCK_LABEL_107;
        }
        // Misplaced declaration of an exception variable
        catch (final Uri editedImageUri) { }
        finally { }
        GLogger.e(TAG, "thread wait interrupt in #processLocalEdit.", new Object[0]);
        syncIsDone;
        JVM INSTR monitorexit ;
        GLogger.i(TAG, "Scan complete...", new Object[0]);
        if (!mediaItems.isEmpty())
        {
            return (MediaItem)mediaItems.get(0);
        } else
        {
            return null;
        }
        syncIsDone;
        JVM INSTR monitorexit ;
        throw editedImageUri;
    }

    public void setMediaItemData(MediaItem mediaitem, Uri uri, File file, android.graphics.BitmapFactory.Options options, Tag tag)
    {
        Set set = mediaItemDao.getItemById(mediaitem.getParentObjectID()).getTags();
        if (set != null)
        {
            ObjectID objectid = null;
            if (tag != null)
            {
                objectid = tag.getObjectId();
            }
            tag = set.iterator();
            do
            {
                if (!tag.hasNext())
                {
                    break;
                }
                Tag tag1 = (Tag)tag.next();
                if (TagType.ALBUM == tag1.getType() && (objectid == null || !tag1.getObjectId().equals(objectid)))
                {
                    tag.remove();
                }
            } while (true);
        }
        mediaitem.setTags(set);
        mediaitem.setObjectId(new ObjectID(file.getAbsolutePath().hashCode(), 0L));
        mediaitem.setHeight(options.outHeight);
        mediaitem.setWidth(options.outWidth);
        mediaitem.setName(file.getName());
        mediaitem.setLocalPath(file.getAbsolutePath());
        mediaitem.setGroupType(GroupType.EDIT);
        mediaitem.setSyncState(SyncState.PENDING_EDITED);
        setDateMetadata(mediaitem, uri);
        mediaitem.setMIMEType("image/jpeg");
    }




}
