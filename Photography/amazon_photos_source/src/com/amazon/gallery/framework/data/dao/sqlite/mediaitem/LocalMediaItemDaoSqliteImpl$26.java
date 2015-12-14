// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.SyncState;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl, MediaItemDaoChangeList

class val.localItem extends DBWriteExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final ObjectID val$cloudId;
    final MediaItem val$localItem;

    protected MediaItemDaoChangeList execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        MediaItemDaoChangeList mediaitemdaochangelist = new MediaItemDaoChangeList();
        MediaItem mediaitem = LocalMediaItemDaoSqliteImpl.access$600(LocalMediaItemDaoSqliteImpl.this, readwritesqlitedatabase, val$cloudId);
        if (mediaitem != null && mediaitem.getId() != val$localItem.getId())
        {
            mediaitem.setLocalPath(val$localItem.getLocalPath());
            mediaitem.getProperties().addAll(val$localItem.getProperties());
            long l = mediaitem.getTimestampMs();
            mediaitem.getMetadata().putAll(val$localItem.getMetadata());
            mediaitem.getTags().addAll(val$localItem.getTags());
            boolean flag;
            if (val$localItem.isHidden() || mediaitem.isHidden())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mediaitem.setHidden(flag);
            mediaitem.setSyncState(SyncState.SYNCED);
            LocalMediaItemDaoSqliteImpl.access$1200(LocalMediaItemDaoSqliteImpl.this, readwritesqlitedatabase, Collections.singletonList(val$localItem), mediaitemdaochangelist, true);
            mediaitem.setTimestampMs(l);
            LocalMediaItemDaoSqliteImpl.access$900(LocalMediaItemDaoSqliteImpl.this, readwritesqlitedatabase, Collections.singletonList(mediaitem), mediaitemdaochangelist);
            return mediaitemdaochangelist;
        } else
        {
            val$localItem.setObjectId(val$cloudId);
            val$localItem.setSyncState(SyncState.SYNCED);
            LocalMediaItemDaoSqliteImpl.access$900(LocalMediaItemDaoSqliteImpl.this, readwritesqlitedatabase, Collections.singletonList(val$localItem), mediaitemdaochangelist);
            return mediaitemdaochangelist;
        }
    }

    protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$cloudId = objectid;
        val$localItem = MediaItem.this;
        super();
    }
}
