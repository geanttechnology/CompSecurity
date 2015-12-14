// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import android.os.Environment;
import com.amazon.gallery.foundation.utils.file.FolderUtil;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.tag:
//            TagFactory, TagSqliteImpl

public class DefaultTagFactory
    implements TagFactory
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/tag/DefaultTagFactory.getName();
    private String cameraDirPath;
    private String removableCameraDirPath;
    protected final RemovableStorageManager removableStorageManager;
    protected final TagDao tagDao;

    public DefaultTagFactory(TagDao tagdao, RemovableStorageManager removablestoragemanager)
    {
        tagDao = tagdao;
        removableStorageManager = removablestoragemanager;
    }

    public Tag createLocalTag(ObjectID objectid, String s, File file, MediaItem mediaitem)
    {
        TagSqliteImpl tagsqliteimpl = (TagSqliteImpl)tagDao.create(TagType.LOCAL_FOLDER);
        tagsqliteimpl.setObjectId(objectid);
        tagsqliteimpl.setLabel(s);
        tagsqliteimpl.setProperties(getTagProperties(file));
        tagsqliteimpl.setDateCreatedMs(mediaitem.getDateModifiedMs());
        tagsqliteimpl.setCoverId(mediaitem.getObjectId());
        tagsqliteimpl.setLocalPath(file.getAbsolutePath());
        tagsqliteimpl.setValid(true);
        return tagsqliteimpl;
    }

    public String getCameraDirPath()
    {
        return cameraDirPath;
    }

    public String getRemovableCameraDirPath()
    {
        return removableCameraDirPath;
    }

    protected Set getTagProperties(File file)
    {
        HashSet hashset = new HashSet();
        hashset.add(TagProperty.LOCAL);
        if (isInCameraDirectory(file))
        {
            hashset.add(TagProperty.CAMERA);
        }
        if (removableStorageManager.isFileOnRemovableStorage(file))
        {
            hashset.add(TagProperty.REMOVABLE);
        }
        return hashset;
    }

    public boolean isInCameraDirectory(File file)
    {
        File file1 = null;
        Object obj = getRemovableCameraDirPath();
        Object obj1 = getCameraDirPath();
        if (obj != null)
        {
            obj = new File(((String) (obj)));
        } else
        {
            obj = null;
        }
        if (obj1 != null)
        {
            file1 = new File(((String) (obj1)));
        }
        obj1 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
        return FolderUtil.directoryEqualsOrContainsPath(((File) (obj)), file) || FolderUtil.directoryEqualsOrContainsPath(file1, file) || FolderUtil.directoryEqualsOrContainsPath(((File) (obj1)), file);
    }

    public void setCameraDirPath(String s)
    {
        cameraDirPath = s;
    }

    public void setRemovableCameraDirPath(String s)
    {
        removableCameraDirPath = s;
    }

}
