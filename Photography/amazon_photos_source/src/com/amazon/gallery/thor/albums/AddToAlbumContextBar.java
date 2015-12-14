// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.util.Pair;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.CabVisibilityNotification;
import com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent;
import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import com.amazon.gallery.thor.app.ui.cab.GalleryContextBar;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AddToAlbumAction, AddToAlbumMultiSelectTitleUpdater

public class AddToAlbumContextBar extends GalleryContextBar
{

    private static final Pair ADD_TO_CHOOSER[] = {
        new Pair(com/amazon/gallery/thor/albums/AddToAlbumAction, Integer.valueOf(0x7f0c0277))
    };

    public AddToAlbumContextBar(BeanAwareActivity beanawareactivity, int i)
    {
        super(beanawareactivity, 0x7f100011, new AddToAlbumMultiSelectTitleUpdater(beanawareactivity));
    }

    public void CabMediaItemEvent(CabMediaItemEvent cabmediaitemevent)
    {
        if (cabmediaitemevent.action == com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent.Action.ADD)
        {
            addSelectable(cabmediaitemevent.mediaItem);
            return;
        } else
        {
            removeSelectable(cabmediaitemevent.mediaItem);
            return;
        }
    }

    protected Pair[] getGalleryActions()
    {
        return ADD_TO_CHOOSER;
    }

    public void onActionCompleteEvent(ActionCompleteEvent actioncompleteevent)
    {
        clearSelectables();
        hide();
    }

    public void onCabVisibilityChangedEvent(CabVisibilityNotification cabvisibilitynotification)
    {
        if (!cabvisibilitynotification.show)
        {
            activity.finish();
        }
    }

    public void onResume()
    {
        super.onResume();
        show();
    }

    protected void syncSelectablesWithActionModeMenu()
    {
        activity.runOnUiThread(new Runnable() );
    }



}
