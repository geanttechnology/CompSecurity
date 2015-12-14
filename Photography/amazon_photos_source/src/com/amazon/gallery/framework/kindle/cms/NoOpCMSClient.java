// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSClient, CMSContainer, CMSDB, CMSRequestHandler, 
//            CMSImageStore, MLTItemTracker

public class NoOpCMSClient
    implements CMSClient
{

    public NoOpCMSClient()
    {
    }

    public transient void addAlbumsAsync(boolean flag, boolean flag1, Tag atag[])
    {
    }

    public void addContainerCallBackQueueRequest(CMSContainer cmscontainer)
    {
    }

    public void addToCarousel(ObjectID objectid, boolean flag)
    {
    }

    public void addToFavourite(ObjectID objectid)
    {
    }

    public boolean checkIfAlbumIsFavorite(ObjectID objectid)
    {
        return false;
    }

    public void initWithContextAndCMSDB(Context context, CMSDB cmsdb)
    {
    }

    public void onAccountDeregistered()
    {
    }

    public void onAccountRegistered()
    {
    }

    public transient void removeAlbums(boolean flag, ObjectID aobjectid[])
    {
    }

    public void setCMSConnectionCallBack(CMSRequestHandler cmsrequesthandler)
    {
    }

    public void setCMSImageStore(CMSImageStore cmsimagestore)
    {
    }

    public void setMLTItemTracker(MLTItemTracker mltitemtracker)
    {
    }

    public void setMediaItemDao(MediaItemDao mediaitemdao)
    {
    }

    public void setTagDao(TagDao tagdao)
    {
    }
}
