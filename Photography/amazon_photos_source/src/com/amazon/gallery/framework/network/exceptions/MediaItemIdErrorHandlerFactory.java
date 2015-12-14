// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.exceptions;

import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.ObjectID;

// Referenced classes of package com.amazon.gallery.framework.network.exceptions:
//            MediaItemIdErrorHandler

public class MediaItemIdErrorHandlerFactory
{

    private MediaItemDao mediaItemDao;

    public MediaItemIdErrorHandlerFactory(MediaItemDao mediaitemdao)
    {
        mediaItemDao = mediaitemdao;
    }

    public MediaItemIdErrorHandler getMediaItemIdErrorHandler(ObjectID objectid)
    {
        return new MediaItemIdErrorHandler(mediaItemDao, objectid);
    }
}
