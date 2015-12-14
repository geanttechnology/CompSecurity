// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.print.GalleryPrintContext;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.RewindPhoto;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.activity.ImageRewindChooserActivity;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            MediaItemAction

public class ImageRewindAction extends MediaItemAction
{

    public ImageRewindAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, GalleryPrintContext galleryprintcontext, ShareStore sharestore)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e01c2);
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        return super.canExecute(viewdescriptor, mediaitem) && mediaitem.getGroupType() == GroupType.REWIND;
    }

    public boolean canExecute(List list)
    {
        return super.canExecute(list) && list.size() == 1;
    }

    public void execute(List list)
    {
        if (list.size() == 1)
        {
            list = (MediaItem)list.get(0);
            if (isValid(list) && MediaItemUtil.isRewindPhoto(list))
            {
                list = (RewindPhoto)list;
                context.startActivityForResult((new Intent(context, com/amazon/gallery/thor/app/activity/ImageRewindChooserActivity)).putExtra("object_id", list.getObjectId().toString()), 65432);
                GlobalMessagingBus.post(new ActionCompleteEvent());
            }
        }
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        return super.isValid(mediaitem) && mediaitem.getGroupType() == GroupType.REWIND;
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
    }
}
