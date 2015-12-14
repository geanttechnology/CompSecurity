// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import com.amazon.clouddrive.extended.model.GetNodeExtendedResponse;
import com.amazon.clouddrive.handlers.AsyncHandler;
import com.amazon.clouddrive.model.CloudDriveRequest;
import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.CoverObject;
import com.amazon.clouddrive.model.GetNodeRequest;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            RefreshCoverPhotoTask

class this._cls0
    implements AsyncHandler
{

    final RefreshCoverPhotoTask this$0;

    public volatile void onCanceled(CloudDriveRequest clouddriverequest)
    {
        onCanceled((GetNodeRequest)clouddriverequest);
    }

    public void onCanceled(GetNodeRequest getnoderequest)
    {
    }

    public volatile void onError(CloudDriveRequest clouddriverequest, Exception exception)
    {
        onError((GetNodeRequest)clouddriverequest, exception);
    }

    public void onError(GetNodeRequest getnoderequest, Exception exception)
    {
    }

    public volatile void onSuccess(CloudDriveRequest clouddriverequest, Object obj)
    {
        onSuccess((GetNodeRequest)clouddriverequest, (GetNodeExtendedResponse)obj);
    }

    public void onSuccess(GetNodeRequest getnoderequest, GetNodeExtendedResponse getnodeextendedresponse)
    {
        getnoderequest = getnodeextendedresponse.getCollectionProperties().getCovers();
        if (getnoderequest != null && !getnoderequest.isEmpty())
        {
            Object obj = (CoverObject)getnoderequest.get(0);
            getnoderequest = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
            getnodeextendedresponse = getnoderequest.getTagById(CDSUtil.getObjectId(RefreshCoverPhotoTask.access$000(RefreshCoverPhotoTask.this)));
            obj = CDSUtil.getObjectId(((CoverObject) (obj)).getId());
            if (getnodeextendedresponse.getCoverId() == null || !getnodeextendedresponse.getCoverId().equals(obj))
            {
                if (RefreshCoverPhotoTask.access$100(RefreshCoverPhotoTask.this) > 0)
                {
                    RefreshCoverPhotoTask.access$200(RefreshCoverPhotoTask.this, ((ObjectID) (obj)));
                }
                getnodeextendedresponse.setCoverId(((ObjectID) (obj)));
                getnodeextendedresponse.setCustomCoverId(((ObjectID) (obj)));
                getnoderequest.save(getnodeextendedresponse, true);
            }
        }
    }

    ponse()
    {
        this$0 = RefreshCoverPhotoTask.this;
        super();
    }
}
