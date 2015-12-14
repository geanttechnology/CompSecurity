// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.tag.DefaultTagFactory;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.io.File;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.amazon.gallery.thor.app:
//            FreeTime, FreeTimeCommon

public class FreeTimeTagFactory extends DefaultTagFactory
{

    private static final String TAG = com/amazon/gallery/thor/app/FreeTimeTagFactory.getName();
    private final FreeTime freeTime;

    public FreeTimeTagFactory(TagDao tagdao, FreeTime freetime, RemovableStorageManager removablestoragemanager)
    {
        super(tagdao, removablestoragemanager);
        freeTime = freetime;
    }

    private void addFreeTimeInformation(Tag tag)
    {
        String s;
label0:
        {
            if (freeTime.isFreeTimeFeatureEnabled() && !freeTime.isFreeTime() && isFreeTimeTag(tag.getLocalPath()))
            {
                tag.setProperty(TagProperty.FREETIME);
                s = tag.getLabel();
                if (!s.isEmpty() && StringUtils.isNumeric(s))
                {
                    break label0;
                }
                GLogger.e(TAG, "Child camera directory not valid user id, %s.", new Object[] {
                    s
                });
            }
            return;
        }
        int i = Integer.parseInt(s);
        s = freeTime.getOwnerName(i);
        if (s != null)
        {
            tag.setLabel(s);
            return;
        } else
        {
            GLogger.e(TAG, "Problem converting child camera directory to name, %d.", new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
    }

    private boolean isFreeTimeTag(String s)
    {
        boolean flag1 = false;
        boolean flag;
        if (StringUtils.startsWithIgnoreCase(s, FreeTimeCommon.getFreeTimeLocation()))
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (removableStorageManager.isRemovableStorageMounted())
            {
                File file = FreeTimeCommon.getFreeTimeRemovableStorageLocation(removableStorageManager);
                flag = flag1;
                if (file != null)
                {
                    return StringUtils.startsWithIgnoreCase(s, file.getPath());
                }
            }
        }
        return flag;
    }

    public Tag createLocalTag(ObjectID objectid, String s, File file, MediaItem mediaitem)
    {
        objectid = super.createLocalTag(objectid, s, file, mediaitem);
        addFreeTimeInformation(objectid);
        return objectid;
    }

}
