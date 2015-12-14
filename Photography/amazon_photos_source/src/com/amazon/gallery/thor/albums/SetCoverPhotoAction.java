// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.MediaContentUtil;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.mixtape.utils.IdUtils;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumMediaItemAction, SetCoverPhotoTask

public class SetCoverPhotoAction extends AlbumMediaItemAction
{

    private static final String TAG = com/amazon/gallery/thor/albums/SetCoverPhotoAction.getName();
    private final BeanAwareActivity activity;

    public SetCoverPhotoAction(BeanAwareActivity beanawareactivity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager)
    {
        super(beanawareactivity, networkconnectivity, photosdemomanager, 0x7f0e01df);
        activity = beanawareactivity;
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        viewdescriptor = getTagFromViewDescriptor(viewdescriptor);
        return viewdescriptor != null && mediaitem != null && viewdescriptor.getType() != TagType.LOCAL_FOLDER && MediaItemUtil.isCloudMediaItem(mediaitem) && mediaitem.getType() == MediaType.PHOTO;
    }

    public boolean canExecute(List list)
    {
        return super.canExecute(list) && list.size() == 1 && isValid((MediaItem)list.get(0));
    }

    public void execute(List list)
    {
        super.execute(list);
        if (!networkConnectivity.promptIfOffline(context))
        {
            Object obj = MediaContentUtil.getTagFromContentConfiguration();
            list = (MediaItem)list.get(0);
            if (obj != null && list != null)
            {
                list = IdUtils.objectIdToNodeId(list.getObjectId().getMostSignificantBits(), list.getObjectId().getLeastSignificantBits());
                obj = IdUtils.objectIdToNodeId(((Tag) (obj)).getObjectId().getMostSignificantBits(), ((Tag) (obj)).getObjectId().getLeastSignificantBits());
                (new SetCoverPhotoTask(activity, list, ((String) (obj)), profiler)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                return;
            }
        }
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        viewdescriptor = new ArrayList();
        viewdescriptor.add(mediaitem);
        execute(viewdescriptor);
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        Tag tag = MediaContentUtil.getTagFromContentConfiguration();
        return super.isValid(mediaitem) && tag != null && tag.getType() == TagType.ALBUM && mediaitem.getType() == MediaType.PHOTO && MediaItemUtil.isCloudMediaItem(mediaitem);
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
    }

}
