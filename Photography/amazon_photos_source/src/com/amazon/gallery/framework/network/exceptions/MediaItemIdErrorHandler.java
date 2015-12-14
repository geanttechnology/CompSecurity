// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.exceptions;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.ObjectID;

public class MediaItemIdErrorHandler
{

    private static final String TAG = com/amazon/gallery/framework/network/exceptions/MediaItemIdErrorHandler.getName();
    private MediaItemDao mediaItemDao;
    private ObjectID mediaItemId;

    public MediaItemIdErrorHandler(MediaItemDao mediaitemdao, ObjectID objectid)
    {
        mediaItemDao = mediaitemdao;
        mediaItemId = objectid;
    }

    public void handleMediaItemIdError()
    {
        com.amazon.gallery.framework.model.media.MediaItem mediaitem = mediaItemDao.getItemById(mediaItemId);
        if (mediaitem != null)
        {
            GLogger.i(TAG, "Deleting photo %s because of PhotoIdError", new Object[] {
                mediaItemId
            });
            mediaItemDao.deleteCloudFields(mediaitem, true);
        }
    }

}
