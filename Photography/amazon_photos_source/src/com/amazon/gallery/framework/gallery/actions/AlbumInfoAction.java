// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.activity.AlbumInfoActivity;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            TagAction, ViewDescriptorAction

public class AlbumInfoAction extends TagAction
    implements ViewDescriptorAction
{

    private final Context context;
    private final NetworkConnectivity networkConnectivity;

    public AlbumInfoAction(Activity activity, NetworkConnectivity networkconnectivity, Profiler profiler)
    {
        super(activity, 0x7f0e0026, profiler);
        context = activity;
        networkConnectivity = networkconnectivity;
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        return mediaitem == null && viewdescriptor != null && viewdescriptor.getTag() != null && viewdescriptor.getTag().getType() == TagType.ALBUM;
    }

    public boolean canExecuteTags(List list)
    {
        return list.size() == 1 && ((Tag)list.get(0)).getType() == TagType.ALBUM;
    }

    public void executeTags(List list)
    {
        if (networkConnectivity.promptIfOffline(context))
        {
            return;
        } else
        {
            list = (Tag)list.get(0);
            Intent intent = new Intent(context, com/amazon/gallery/thor/app/activity/AlbumInfoActivity);
            intent.putExtra("mediaTagId", list.getObjectId().toString());
            context.startActivity(intent);
            return;
        }
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        executeTags(Collections.singletonList(viewdescriptor.getTag()));
    }
}
