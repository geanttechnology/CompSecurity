// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.mediaitem.LocalMediaItemDaoSqliteImpl;
import com.amazon.gallery.framework.model.media.RewindPhoto;

// Referenced classes of package com.amazon.gallery.framework.data.dao.mediaitem:
//            AbstractOrderedGroupPhotoSqlite

public class RewindPhotoSqliteImpl extends AbstractOrderedGroupPhotoSqlite
    implements RewindPhoto
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/mediaitem/RewindPhotoSqliteImpl.getName();
    private boolean loaded;
    private int preferredFrame;

    public RewindPhotoSqliteImpl(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        super(localmediaitemdaosqliteimpl);
        loaded = false;
        preferredFrame = 0;
    }

}
