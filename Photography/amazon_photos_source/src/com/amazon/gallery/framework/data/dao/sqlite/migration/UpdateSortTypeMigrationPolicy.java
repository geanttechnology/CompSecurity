// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.thor.cds.CDSUtil;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class UpdateSortTypeMigrationPolicy extends MigrationPolicy
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/UpdateSortTypeMigrationPolicy.getName();
    private final Context context;
    private final SortTypeDao sortDao;

    public UpdateSortTypeMigrationPolicy(int i, Context context1, SortTypeDao sorttypedao)
    {
        super(i);
        context = context1;
        sortDao = sorttypedao;
    }

    private void migrateSortType(String s)
    {
        MediaItemSortType mediaitemsorttype = sortDao.getSortTypeById(s);
        if (mediaitemsorttype == MediaItemSortType.DATE_TAKEN_ASC)
        {
            sortDao.saveSortTypeById(s, MediaItemSortType.TIME_STAMP_ASC);
        } else
        if (mediaitemsorttype == MediaItemSortType.DATE_TAKEN_DESC)
        {
            sortDao.saveSortTypeById(s, MediaItemSortType.TIME_STAMP_DESC);
            return;
        }
    }

    public void doMigration()
    {
        migrateSortType("all");
        migrateSortType("camera_roll");
        migrateSortType("video");
    }

    public boolean needsMigration()
    {
        Cursor cursor;
        Cursor cursor1;
        long l1;
        cursor1 = null;
        l1 = 0L;
        cursor = cursor1;
        ContentResolver contentresolver = context.getContentResolver();
        cursor = cursor1;
        android.net.Uri uri = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.SortType.CONTENT_URI;
        cursor = cursor1;
        String s = MediaItemSortType.DATE_TAKEN_ASC.name();
        cursor = cursor1;
        String s1 = MediaItemSortType.DATE_TAKEN_DESC.name();
        cursor = cursor1;
        cursor1 = contentresolver.query(uri, new String[] {
            "COUNT(*) AS count"
        }, "sort_order IN (?, ?)", new String[] {
            s, s1
        }, null);
        long l;
        l = l1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        l = l1;
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break MISSING_BLOCK_LABEL_111;
        }
        cursor = cursor1;
        l = cursor1.getLong(0);
        CDSUtil.closeCursorQuietly(cursor1);
        Exception exception;
        return l > 0L;
        exception;
        CDSUtil.closeCursorQuietly(cursor);
        throw exception;
    }

}
