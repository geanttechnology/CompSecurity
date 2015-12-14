// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import com.amazon.gallery.foundation.utils.date.DateUtils;
import com.amazon.gallery.framework.data.dao.filter.MediaFilter;
import com.amazon.gallery.framework.data.dao.filter.MediaTypeFilter;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.tag.TagDaoChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.cds.CDSUtil;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class VideoDateCreatedMigrationPolicy extends MigrationPolicy
{

    private final Context context;
    private final MediaItemDao mediaItemDao;
    private final TagDao tagDao;

    public VideoDateCreatedMigrationPolicy(int i, Context context1, MediaItemDao mediaitemdao, TagDao tagdao)
    {
        super(i);
        context = context1;
        mediaItemDao = mediaitemdao;
        tagDao = tagdao;
    }

    private void updateTagSortDates(Collection collection)
    {
        TagDaoChangeList tagdaochangelist = new TagDaoChangeList();
        Iterator iterator = collection.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Tag tag = (Tag)iterator.next();
            List list = mediaItemDao.getItemsByTag(tag).getMediaItems();
            if (tagDao.updateSortDateForTag(tag, list, false, true))
            {
                tagdaochangelist.addContentsOf(tag, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
            }
        } while (true);
        if (collection.size() != 0)
        {
            tagDao.notify(tagdaochangelist);
        }
    }

    public void doMigration()
    {
        MediaFilter mediafilter = new MediaFilter();
        mediafilter.setMediaTypeFilter(new MediaTypeFilter(MediaType.VIDEO));
        Object obj = tagDao.getTags();
        HashSet hashset = new HashSet();
        HashSet hashset1;
label0:
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); mediaItemDao.saveMergedFields(hashset1, true))
        {
            Tag tag = (Tag)((Iterator) (obj)).next();
            Object obj1 = mediaItemDao.getItemsByTag(tag, mediafilter);
            hashset1 = new HashSet();
            obj1 = ((MediaItemCollection) (obj1)).getMediaItems().iterator();
            do
            {
                if (!((Iterator) (obj1)).hasNext())
                {
                    continue label0;
                }
                MediaItem mediaitem = (MediaItem)((Iterator) (obj1)).next();
                long l = mediaitem.getDateCreatedUTCMs();
                if (l == mediaitem.getDateCreatedMs() && l != 0L)
                {
                    mediaitem.setDateCreatedMs(DateUtils.applyCurrentTimeZone(l));
                    hashset1.add(mediaitem);
                    hashset.add(tag);
                }
            } while (true);
        }

        updateTagSortDates(hashset);
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
        android.net.Uri uri = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI;
        cursor = cursor1;
        int i = MediaType.VIDEO.ordinal();
        cursor = cursor1;
        cursor1 = contentresolver.query(uri, new String[] {
            "COUNT(*) AS count"
        }, "type = ?  AND date_created_utc != 0  AND date_created = date_created_utc", new String[] {
            String.valueOf(i)
        }, null);
        long l;
        l = l1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        l = l1;
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break MISSING_BLOCK_LABEL_99;
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
