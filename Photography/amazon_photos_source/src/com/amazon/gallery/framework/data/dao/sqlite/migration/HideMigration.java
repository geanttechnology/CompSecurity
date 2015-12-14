// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.RemoteException;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.ChangeList;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.cds.CDSUtil;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class HideMigration extends MigrationPolicy
{

    private static final String COUNT_PROJECTION[] = {
        "COUNT(*) AS count"
    };
    public static final String HIDE_NODE_PROJECTION[] = {
        "node_id", "hidden"
    };
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/HideMigration.getSimpleName();
    private final String accountId;
    private final Context context;
    private final MediaItemDao mediaItemDao;

    public HideMigration(int i, Context context1, MediaItemDao mediaitemdao, String s)
    {
        super(i);
        context = context1;
        mediaItemDao = mediaitemdao;
        accountId = s;
    }

    public void doMigration()
    {
        Object obj;
        Object obj1;
        Object obj2;
        ContentProviderClient contentproviderclient;
        obj2 = com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(context.getResources().getString(0x7f0e02fb), accountId);
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(((android.net.Uri) (obj2)));
        obj1 = null;
        obj = obj1;
        obj2 = contentproviderclient.query(((android.net.Uri) (obj2)), HIDE_NODE_PROJECTION, "kind= 'FILE' and status= 'AVAILABLE' and (is_image= 1 or is_video= 1) and hidden= 1", null, (new SortOrder("node_id")).getOrderByString());
        obj1 = obj2;
        obj = obj1;
        int k = ((Cursor) (obj1)).getColumnIndex("node_id");
        obj = obj1;
        int l = ((Cursor) (obj1)).getColumnIndex("hidden");
        if (k == -1)
        {
            if (obj1 != null)
            {
                ((Cursor) (obj1)).close();
            }
            contentproviderclient.release();
            return;
        }
        break MISSING_BLOCK_LABEL_142;
        RemoteException remoteexception;
        remoteexception;
        obj = obj1;
        GLogger.ex(TAG, "Error while querying content provider client", remoteexception);
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            contentproviderclient.release();
            return;
        }
        obj = obj1;
        ChangeList changelist = new ChangeList();
        int i = 0;
_L2:
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_302;
        }
        obj = obj1;
        remoteexception = mediaItemDao.getItemById(CDSUtil.getObjectId(((Cursor) (obj1)).getString(k)));
        if (remoteexception == null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        int j;
        boolean flag;
        if (((Cursor) (obj1)).getInt(l) == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = obj1;
        remoteexception.setHidden(flag);
        obj = obj1;
        changelist.add(remoteexception, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
        j = i + 1;
        i = j;
        if (j <= 1000) goto _L2; else goto _L3
_L3:
        i = 0;
        obj = obj1;
        mediaItemDao.applyChangeList(changelist, false);
        obj = obj1;
        changelist.clear();
          goto _L2
        obj1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        contentproviderclient.release();
        throw obj1;
        obj = obj1;
        if (changelist.isEmpty())
        {
            break MISSING_BLOCK_LABEL_326;
        }
        obj = obj1;
        mediaItemDao.applyChangeList(changelist, false);
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        contentproviderclient.release();
        return;
    }

    public boolean needsMigration()
    {
        Object obj;
        Object obj1;
        Object obj2;
        ContentProviderClient contentproviderclient;
        long l1;
        long l2;
        obj2 = com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(context.getResources().getString(0x7f0e02fb), accountId);
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(((android.net.Uri) (obj2)));
        obj = null;
        l1 = 0L;
        l2 = 0L;
        obj1 = obj;
        obj2 = contentproviderclient.query(((android.net.Uri) (obj2)), COUNT_PROJECTION, "kind= 'FILE' and status= 'AVAILABLE' and (is_image= 1 or is_video= 1) and hidden= 1", null, null);
        long l;
        obj = obj2;
        l = l1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        l = l1;
        obj1 = obj;
        if (!((Cursor) (obj)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_93;
        }
        obj1 = obj;
        l = ((Cursor) (obj)).getLong(0);
        CDSUtil.closeCursorQuietly(((Cursor) (obj)));
        contentproviderclient.release();
        obj1 = context.getContentResolver().query(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI, COUNT_PROJECTION, "hidden = 1", null, null);
        l1 = l2;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        l1 = l2;
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_158;
        }
        obj = obj1;
        l1 = ((Cursor) (obj1)).getLong(0);
        CDSUtil.closeCursorQuietly(((Cursor) (obj1)));
        Exception exception;
        RemoteException remoteexception;
        return l != l1;
        remoteexception;
        obj1 = obj;
        GLogger.ex(TAG, "Error while querying content provider client", remoteexception);
        CDSUtil.closeCursorQuietly(null);
        contentproviderclient.release();
        return false;
        obj;
        CDSUtil.closeCursorQuietly(((Cursor) (obj1)));
        contentproviderclient.release();
        throw obj;
        exception;
        CDSUtil.closeCursorQuietly(((Cursor) (obj)));
        throw exception;
    }

}
