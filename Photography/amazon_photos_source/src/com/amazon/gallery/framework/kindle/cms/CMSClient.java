// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.cms;

import android.content.Context;
import android.net.Uri;
import com.amazon.gallery.framework.data.account.AccountChangeListener;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.kindle.cms:
//            CMSContainer, CMSDB, CMSRequestHandler, CMSImageStore, 
//            MLTItemTracker

public interface CMSClient
    extends AccountChangeListener
{

    public static final Uri GALLERY_TATE_CMS_LEGACY_URI_CLOUD = Uri.parse("com.amazon.photos.cloud");
    public static final Uri GALLERY_TATE_CMS_LEGACY_URI_LOCAL = Uri.parse("com.amazon.photos.local");
    public static final Uri GALLERY_TATE_CMS_URI = Uri.parse("com.amazon.photos");

    public transient abstract void addAlbumsAsync(boolean flag, boolean flag1, Tag atag[]);

    public abstract void addContainerCallBackQueueRequest(CMSContainer cmscontainer);

    public abstract void addToCarousel(ObjectID objectid, boolean flag);

    public abstract void addToFavourite(ObjectID objectid);

    public abstract boolean checkIfAlbumIsFavorite(ObjectID objectid);

    public abstract void initWithContextAndCMSDB(Context context, CMSDB cmsdb);

    public abstract void onAccountDeregistered();

    public abstract void onAccountRegistered();

    public transient abstract void removeAlbums(boolean flag, ObjectID aobjectid[]);

    public abstract void setCMSConnectionCallBack(CMSRequestHandler cmsrequesthandler);

    public abstract void setCMSImageStore(CMSImageStore cmsimagestore);

    public abstract void setMLTItemTracker(MLTItemTracker mltitemtracker);

    public abstract void setMediaItemDao(MediaItemDao mediaitemdao);

    public abstract void setTagDao(TagDao tagdao);

}
