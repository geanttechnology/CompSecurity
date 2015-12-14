// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.RemoteException;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.deduplicate.CloudFieldDeduplicater;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.VideoMediaItemDateParser;
import com.amazon.gallery.framework.data.dao.sqlite.mediastore.GalleryMetadataRetriever;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.thor.cds.CDSUtil;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy, UpdateTimestampMigrationPolicy

public class DeduplicateMigrationPolicy extends MigrationPolicy
{

    private static final String MEDIA_STORE_PROJECTION[] = {
        "_id", "width", "height"
    };
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/UpdateTimestampMigrationPolicy.getName();
    private final String accountId;
    private final Context context;
    private final MediaItemDao mediaItemDao;

    public DeduplicateMigrationPolicy(int i, Context context1, MediaItemDao mediaitemdao, String s)
    {
        super(i);
        mediaItemDao = mediaitemdao;
        accountId = s;
        context = context1;
    }

    private void migrateByMediaStore(Uri uri, String as[])
    {
label0:
        {
            as = context.getContentResolver().query(uri, as, null, null, null);
            if (as == null)
            {
                break MISSING_BLOCK_LABEL_79;
            }
            try
            {
                for (; as.moveToNext(); updateMediaItemAndSave(as, uri)) { }
                break label0;
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri) { }
            finally
            {
                as.close();
                throw uri;
            }
        }
        GLogger.ex(TAG, "Encountered an exception when migrating", uri);
        if (BuildFlavors.isDebug())
        {
            throw uri;
        }
        break MISSING_BLOCK_LABEL_72;
        as.close();
        return;
        as.close();
        return;
        GLogger.e(TAG, "Failed to open cursor for %s", new Object[] {
            uri
        });
        return;
    }

    private void updateCloudItemFields()
    {
        Object obj;
        Object obj1;
        Object obj2;
        ContentProviderClient contentproviderclient;
        obj2 = com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(context.getResources().getString(0x7f0e02fb), accountId);
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(((Uri) (obj2)));
        obj1 = null;
        obj = null;
        obj2 = contentproviderclient.query(((Uri) (obj2)), CloudFieldDeduplicater.DEDUPE_NODE_PROJECTION, "kind= 'FILE' and status= 'AVAILABLE' and (is_image= 1 or is_video= 1)", null, (new SortOrder("node_id")).getOrderByString());
        obj = obj2;
        obj1 = obj2;
        int k = ((Cursor) (obj2)).getColumnIndex("node_id");
        obj = obj2;
        obj1 = obj2;
        int l = ((Cursor) (obj2)).getColumnIndex("content_md5");
        obj = obj2;
        obj1 = obj2;
        int i1 = ((Cursor) (obj2)).getColumnIndex("content_size");
        if (k != -1 && l != -1 && i1 != -1) goto _L2; else goto _L1
_L1:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
_L7:
        return;
_L2:
        obj = obj2;
        obj1 = obj2;
        ChangeList changelist = new ChangeList();
        int i = 0;
_L4:
        obj = obj2;
        obj1 = obj2;
        if (!((Cursor) (obj2)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        obj1 = obj2;
        MediaItem mediaitem = mediaItemDao.getItemById(CDSUtil.getObjectId(((Cursor) (obj2)).getString(k)));
        if (mediaitem == null) goto _L4; else goto _L3
_L3:
        obj = obj2;
        obj1 = obj2;
        mediaitem.setFullMd5(((Cursor) (obj2)).getString(l));
        obj = obj2;
        obj1 = obj2;
        mediaitem.setSize(((Cursor) (obj2)).getLong(i1));
        obj = obj2;
        obj1 = obj2;
        changelist.add(mediaitem, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
        int j;
        j = i + 1;
        i = j;
        if (j <= 1000) goto _L4; else goto _L5
_L5:
        i = 0;
        obj = obj2;
        obj1 = obj2;
        mediaItemDao.applyChangeList(changelist, false);
        obj = obj2;
        obj1 = obj2;
        changelist.clear();
          goto _L4
        obj2;
        obj1 = obj;
        GLogger.ex(TAG, "Error while querying content provider client", ((Throwable) (obj2)));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
            return;
        }
        if (true) goto _L7; else goto _L6
_L6:
        obj = obj2;
        obj1 = obj2;
        if (changelist.isEmpty())
        {
            break MISSING_BLOCK_LABEL_367;
        }
        obj = obj2;
        obj1 = obj2;
        mediaItemDao.applyChangeList(changelist, false);
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (contentproviderclient == null) goto _L7; else goto _L8
_L8:
        contentproviderclient.release();
        return;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
        throw exception;
    }

    private void updateMediaItemAndSave(Cursor cursor, Uri uri)
    {
        int i;
        int j;
        int k;
        j = cursor.getColumnIndex("_id");
        k = cursor.getColumnIndex("width");
        i = cursor.getColumnIndex("height");
        if (j == -1) goto _L2; else goto _L1
_L1:
        MediaItem mediaitem;
        long l;
        l = cursor.getLong(j);
        mediaitem = mediaItemDao.getItemById(new ObjectID(0L, l));
        if (mediaitem == null) goto _L4; else goto _L3
_L3:
        if (mediaitem.getType() != MediaType.VIDEO) goto _L6; else goto _L5
_L5:
        Cursor cursor1;
        Object obj;
        Object obj1;
        Object obj2;
        obj2 = null;
        cursor1 = null;
        obj1 = null;
        j = cursor.getInt(k);
        i = cursor.getInt(i);
        cursor = null;
        obj = null;
        uri = new GalleryMetadataRetriever(mediaitem.getLocalPath());
        cursor1 = obj2;
        cursor = uri.extractMetadata(24);
        cursor1 = cursor;
        obj = uri.extractMetadata(5);
        if (uri != null)
        {
            uri.release();
        }
_L7:
        if (cursor != null)
        {
            mediaitem.setOrientation(Integer.parseInt(cursor));
        }
        if (j != 0 && i != 0)
        {
            mediaitem.setWidth(j);
            mediaitem.setHeight(i);
        }
        VideoMediaItemDateParser.setDateCreated(((String) (obj)), mediaitem);
_L6:
        mediaItemDao.saveLocalFields(mediaitem, false);
_L2:
        return;
        cursor;
        uri = ((Uri) (obj));
        obj = cursor;
_L10:
        cursor = uri;
        GLogger.wx(TAG, "extract local video information failed", ((Throwable) (obj)));
        obj = obj1;
        cursor = cursor1;
        if (uri != null)
        {
            uri.release();
            obj = obj1;
            cursor = cursor1;
        }
          goto _L7
        uri;
_L9:
        if (cursor != null)
        {
            cursor.release();
        }
        throw uri;
_L4:
        GLogger.e(TAG, "No MediaItem found while it is in MediaStore, id is %d", new Object[] {
            Long.valueOf(l)
        });
        return;
        Exception exception;
        exception;
        cursor = uri;
        uri = exception;
        if (true) goto _L9; else goto _L8
_L8:
        obj;
          goto _L10
    }

    public void doMigration()
    {
        (new AsyncTask() {

            final DeduplicateMigrationPolicy this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected Void doInBackground(Void avoid[])
            {
                updateCloudItemFields();
                migrateByMediaStore(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, DeduplicateMigrationPolicy.MEDIA_STORE_PROJECTION);
                migrateByMediaStore(android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI, DeduplicateMigrationPolicy.MEDIA_STORE_PROJECTION);
                return null;
            }

            
            {
                this$0 = DeduplicateMigrationPolicy.this;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public boolean needsMigration()
    {
        return getOldDbVersion() <= 56;
    }




}
