// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class AutoSaveCameraMigrationPolicy extends MigrationPolicy
{

    public static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/AutoSaveCameraMigrationPolicy.getName();
    private final TagDao tagDao;

    public AutoSaveCameraMigrationPolicy(int i, TagDao tagdao)
    {
        super(i);
        tagDao = tagdao;
    }

    public void doMigration()
    {
        GLogger.v(TAG, "Executing AutoSaveCameraMigrationPolicy", new Object[0]);
        Object obj = tagDao.getTagsByProperty(TagType.LOCAL_FOLDER, TagProperty.CAMERA);
        GLogger.i(TAG, "Found camera roll tag; applying auto save property", new Object[0]);
        obj = (Tag)((List) (obj)).get(0);
        ((Tag) (obj)).setProperty(TagProperty.AUTO_SAVE);
        tagDao.save(((Tag) (obj)), true);
    }

    public boolean needsMigration()
    {
        return !tagDao.getTagsByProperty(TagType.LOCAL_FOLDER, TagProperty.CAMERA).isEmpty();
    }

}
