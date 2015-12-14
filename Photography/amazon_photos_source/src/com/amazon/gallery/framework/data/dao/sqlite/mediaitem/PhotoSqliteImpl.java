// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Photo;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            MediaItemSqliteImpl, LocalMediaItemDaoSqliteImpl

public class PhotoSqliteImpl extends MediaItemSqliteImpl
    implements Photo
{

    public PhotoSqliteImpl(LocalMediaItemDaoSqliteImpl localmediaitemdaosqliteimpl)
    {
        super(localmediaitemdaosqliteimpl);
    }

    public MediaType getType()
    {
        return MediaType.PHOTO;
    }
}
