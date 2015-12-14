// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.mixtape.utils.MixtapeCursorUtils;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            CDSUtil

public class TagCursorConverter
{

    private final TagDao tagDao;
    private String yourCloudDrive;

    public TagCursorConverter(TagDao tagdao, String s)
    {
        tagDao = tagdao;
        yourCloudDrive = s;
    }

    public Tag convert(Cursor cursor)
    {
        boolean flag = true;
        String s;
        Tag tag;
        String s1;
        if ("VISUAL_COLLECTION".equals(MixtapeCursorUtils.getStringFromCursor(cursor, "kind")))
        {
            tag = tagDao.create(TagType.ALBUM);
            s = "";
        } else
        {
            tag = tagDao.create(TagType.FOLDER);
            s = yourCloudDrive;
        }
        tag.setProperty(TagProperty.CLOUD);
        tag.setObjectId(CDSUtil.getObjectId(MixtapeCursorUtils.getStringFromCursor(cursor, "node_id")));
        s1 = MixtapeCursorUtils.getStringFromCursor(cursor, "name");
        if (s1 != null)
        {
            s = s1;
        }
        tag.setLabel(s);
        s = null;
        if (!cursor.isNull(cursor.getColumnIndex("created_date")))
        {
            s = MixtapeCursorUtils.getStringFromCursor(cursor, "created_date");
        }
        tag.setDateCreatedMs(CDSUtil.getUnixTimestamp(s));
        tag.setSortDateMs(0L);
        tag.setHasSortDate(false);
        tag.setValid(true);
        if (cursor.getInt(cursor.getColumnIndex("has_share_parent")) != 1)
        {
            flag = false;
        }
        tag.setShared(flag);
        if (MixtapeCursorUtils.getBooleanFromCursor(cursor, "is_root"))
        {
            tag.setProperty(com.amazon.gallery.framework.model.tags.CommonTagProperty.Misc.YOUR_CLOUD_DRIVE);
        }
        return tag;
    }
}
