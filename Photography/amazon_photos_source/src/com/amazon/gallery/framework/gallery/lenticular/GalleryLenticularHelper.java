// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.lenticular;

import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.data.store.LenticularHelper;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.OrderedGroupPhoto;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import java.io.File;
import java.util.List;

public class GalleryLenticularHelper extends LenticularHelper
{

    private final DiskStore diskStore;
    private final MediaItemDao mediaItemDao;
    private final NetworkStore networkStore;

    public GalleryLenticularHelper(File file, MediaItemDao mediaitemdao, DiskStore diskstore, NetworkStore networkstore)
    {
        super(file);
        mediaItemDao = mediaitemdao;
        diskStore = diskstore;
        networkStore = networkstore;
    }

    public List loadFrames(OrderedGroupPhoto orderedgroupphoto)
    {
        Object obj1 = orderedgroupphoto.getFrames();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        Object obj = obj1;
        if (((List) (obj1)).size() != 0) goto _L3; else goto _L2
_L2:
        if (orderedgroupphoto.getLocalPath() == null) goto _L5; else goto _L4
_L4:
        obj1 = new File(orderedgroupphoto.getLocalPath());
_L7:
        obj = splitFrames(((File) (obj1)), orderedgroupphoto.getObjectId());
        if (obj != null && !((List) (obj)).isEmpty())
        {
            orderedgroupphoto.setFrames(((List) (obj)));
        } else
        {
            orderedgroupphoto.setGroupType(GroupType.NONE);
        }
        mediaItemDao.saveMergedFields(orderedgroupphoto, false);
_L3:
        return ((List) (obj));
_L5:
label0:
        {
            obj1 = diskStore.getOriginal(orderedgroupphoto);
            if (obj1 != null)
            {
                obj = obj1;
                if (((File) (obj1)).exists())
                {
                    break label0;
                }
            }
            networkStore.loadContentSynchronously(orderedgroupphoto, true);
            obj = diskStore.getOriginal(orderedgroupphoto);
        }
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = obj;
        if (((File) (obj)).exists()) goto _L7; else goto _L6
_L6:
        return null;
    }
}
