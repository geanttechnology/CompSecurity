// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.MediaItemDaoChangeList;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class UpdateTimestampMigrationPolicy extends MigrationPolicy
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/UpdateTimestampMigrationPolicy.getName();
    private final MediaItemDao mediaItemDao;
    private final SortTypeDao sortDao;
    private final TagDao tagDao;

    public UpdateTimestampMigrationPolicy(int i, MediaItemDao mediaitemdao, TagDao tagdao, SortTypeDao sorttypedao)
    {
        super(i);
        mediaItemDao = mediaitemdao;
        tagDao = tagdao;
        sortDao = sorttypedao;
    }

    public void doMigration()
    {
        Object obj;
        Object obj1 = mediaItemDao.getAllItems().getMediaItems();
        obj = new MediaItemDaoChangeList();
        int i = 0;
        obj1 = ((List) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)((Iterator) (obj1)).next();
            int j = i + 1;
            mediaitem.setTimestampMs(MediaItemUtil.createTimestamp(mediaitem));
            ((MediaItemDaoChangeList) (obj)).addContentsOf(mediaitem, com.amazon.gallery.framework.data.dao.ChangeList.ChangeType.MODIFIED);
            i = j;
            if (j > 1000)
            {
                i = 0;
                mediaItemDao.applyChangeList(((MediaItemDaoChangeList) (obj)).getAllChangeList(), true);
                ((MediaItemDaoChangeList) (obj)).clear();
            }
        } while (true);
        mediaItemDao.applyChangeList(((MediaItemDaoChangeList) (obj)).getAllChangeList(), true);
        obj = tagDao.getTags().iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        Tag tag;
        Object obj2;
        MediaItemSortType mediaitemsorttype;
        tag = (Tag)((Iterator) (obj)).next();
        obj2 = tag.getObjectId().toString();
        mediaitemsorttype = sortDao.getSortTypeById(((String) (obj2)));
        if (mediaitemsorttype != MediaItemSortType.DATE_TAKEN_ASC) goto _L4; else goto _L3
_L3:
        sortDao.saveSortTypeById(((String) (obj2)), MediaItemSortType.TIME_STAMP_ASC);
_L5:
        obj2 = mediaItemDao.getItemsByTag(tag);
        if (obj2 != null)
        {
            tagDao.updateSortDateForTag(tag, ((MediaItemCollection) (obj2)).getMediaItems(), false, true);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mediaitemsorttype == MediaItemSortType.DATE_TAKEN_DESC)
        {
            sortDao.saveSortTypeById(((String) (obj2)), MediaItemSortType.TIME_STAMP_DESC);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean needsMigration()
    {
        return getOldDbVersion() <= 42;
    }

}
