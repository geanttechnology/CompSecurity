// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            HideAction

public class UnHideAction extends HideAction
{

    private static final String TAG = com/amazon/gallery/framework/gallery/actions/UnHideAction.getName();

    public UnHideAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, TagDao tagdao, MediaItemDao mediaitemdao)
    {
        super(activity, networkconnectivity, photosdemomanager, tagdao, mediaitemdao);
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        return mediaitem != null && mediaitem.isHidden();
    }

    protected boolean shouldHide()
    {
        return false;
    }

}
