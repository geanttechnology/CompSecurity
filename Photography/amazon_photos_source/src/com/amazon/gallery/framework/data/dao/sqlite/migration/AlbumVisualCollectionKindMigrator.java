// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.albums.AlbumCoverPhotoRetriever;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.TagCursorConverter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class AlbumVisualCollectionKindMigrator extends MigrationPolicy
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/AlbumVisualCollectionKindMigrator.getName();
    private static final String VC_OR_FOLDER_PROJECTION[] = {
        "kind", "node_id", "name", "created_date", "has_share_parent", "is_root"
    };
    private final AuthenticationManager authenticationManager;
    private final Context context;

    public AlbumVisualCollectionKindMigrator(int i, Context context1, AuthenticationManager authenticationmanager)
    {
        super(i);
        context = context1;
        authenticationManager = authenticationmanager;
    }

    private boolean isAlphaCustomer()
    {
        Object obj;
        Object obj1;
        Object obj3;
        obj1 = null;
        obj3 = null;
        obj = obj1;
        Object obj2 = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI.buildUpon();
        obj = obj1;
        ((android.net.Uri.Builder) (obj2)).appendQueryParameter("limit", "1");
        obj = obj1;
        obj2 = ((android.net.Uri.Builder) (obj2)).build();
        obj = obj1;
        ContentResolver contentresolver = context.getContentResolver();
        obj = obj1;
        int i = TagType.FOLDER.ordinal();
        obj = obj1;
        obj1 = contentresolver.query(((Uri) (obj2)), new String[] {
            "object_id_hi", "object_id_low"
        }, "type = ?", new String[] {
            String.valueOf(i)
        }, null);
        obj2 = obj3;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        obj2 = obj3;
        obj = obj1;
        if (!((Cursor) (obj1)).moveToNext())
        {
            break MISSING_BLOCK_LABEL_132;
        }
        obj = obj1;
        obj2 = IdUtils.objectIdToNodeId(((Cursor) (obj1)).getLong(0), ((Cursor) (obj1)).getLong(1));
        CDSUtil.closeCursorQuietly(((Cursor) (obj1)));
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        obj = com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(context.getResources().getString(0x7f0e02fb), authenticationManager.getAccountId());
        obj = context.getContentResolver().query(((Uri) (obj)), new String[] {
            "kind"
        }, "node_id = ?", new String[] {
            obj2
        }, null);
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        if (!((Cursor) (obj)).moveToNext()) goto _L2; else goto _L3
_L3:
        obj1 = obj;
        obj2 = ((Cursor) (obj)).getString(0);
        if (obj2 == null) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        boolean flag = ((String) (obj2)).equals("VISUAL_COLLECTION");
        if (!flag) goto _L5; else goto _L6
_L6:
        flag = true;
_L7:
        CDSUtil.closeCursorQuietly(((Cursor) (obj)));
        return flag;
        obj1;
        CDSUtil.closeCursorQuietly(((Cursor) (obj)));
        throw obj1;
_L5:
        flag = false;
        if (true) goto _L7; else goto _L2
_L2:
        CDSUtil.closeCursorQuietly(((Cursor) (obj)));
        return false;
        Exception exception;
        exception;
        CDSUtil.closeCursorQuietly(((Cursor) (obj1)));
        throw exception;
    }

    private void migrateFoldersAndVisualCollections()
    {
        Object obj;
        Object obj1;
        Object obj2;
        ContentProviderClient contentproviderclient;
        TagDao tagdao;
        TagCursorConverter tagcursorconverter;
        ArrayList arraylist;
        Uri uri;
        tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        tagcursorconverter = new TagCursorConverter(tagdao, context.getString(0x7f0e009a));
        uri = com.amazon.mixtape.provider.CloudNodesContract.Nodes.getContentUri(context.getResources().getString(0x7f0e02fb), authenticationManager.getAccountId());
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(uri);
        obj1 = null;
        obj2 = null;
        obj = null;
        arraylist = new ArrayList();
        if (contentproviderclient == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        obj = contentproviderclient.query(uri, VC_OR_FOLDER_PROJECTION, "(kind= 'FOLDER' OR kind= 'VISUAL_COLLECTION') AND status= 'AVAILABLE'", null, (new SortOrder("node_id")).getOrderByString());
        if (obj != null) goto _L2; else goto _L1
_L1:
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
_L5:
        return;
_L2:
        obj1 = obj;
        obj2 = obj;
        if (!((Cursor) (obj)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        obj2 = obj;
        arraylist.add(tagcursorconverter.convert(((Cursor) (obj))));
        if (true) goto _L2; else goto _L3
_L3:
        break; /* Loop/switch isn't completed */
        obj;
        obj2 = obj1;
        GLogger.ex(TAG, "Error while querying content provider client", ((Throwable) (obj)));
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        obj1 = obj;
        obj2 = obj;
        tagdao.save(arraylist, true);
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (contentproviderclient == null) goto _L5; else goto _L6
_L6:
        contentproviderclient.release();
        return;
        Exception exception;
        exception;
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
        throw exception;
    }

    public void doMigration()
    {
        if (isAlphaCustomer())
        {
            context.getContentResolver().delete(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, "local_path IS NULL", null);
        }
        migrateFoldersAndVisualCollections();
        (new AlbumCoverPhotoRetriever(context)).fetchAllFromCDSAndPersist();
        createAuditLog(context.getContentResolver(), "visual_collections_migrated");
    }

    protected boolean needsMigration()
    {
        Cursor cursor;
        if (!authenticationManager.hasActiveAccount())
        {
            return false;
        }
        cursor = null;
        Cursor cursor1 = context.getContentResolver().query(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Audit.CONTENT_URI, new String[] {
            "value"
        }, "key = ?", new String[] {
            "visual_collections_migrated"
        }, null);
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break MISSING_BLOCK_LABEL_101;
        }
        cursor = cursor1;
        boolean flag = Boolean.valueOf(cursor1.getString(0)).booleanValue();
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CDSUtil.closeCursorQuietly(cursor1);
        return flag;
        CDSUtil.closeCursorQuietly(cursor1);
        return true;
        Exception exception;
        exception;
        CDSUtil.closeCursorQuietly(cursor);
        throw exception;
    }

}
