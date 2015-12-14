// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import com.amazon.gallery.foundation.utils.MediaContentUtil;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteAction

public class RemoveAction extends DeleteAction
{

    public RemoveAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e002b);
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        viewdescriptor = getTagFromViewDescriptor(viewdescriptor);
        return mediaitem != null && viewdescriptor != null && viewdescriptor.getType() == TagType.ALBUM;
    }

    protected void getItemSelection(boolean flag, ViewDescriptor viewdescriptor)
    {
        itemSelection = DeleteAction.Selection.REMOVE_FROM_ALBUM;
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        Tag tag = MediaContentUtil.getTagFromContentConfiguration();
        return super.isValid(mediaitem) && tag != null && tag.getType() == TagType.ALBUM;
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }
}
