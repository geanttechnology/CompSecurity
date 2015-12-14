// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.util.Pair;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.actions.DeleteAction;
import com.amazon.gallery.framework.gallery.actions.DownloadAction;
import com.amazon.gallery.framework.gallery.actions.GenericShareAction;
import com.amazon.gallery.framework.gallery.actions.HideAction;
import com.amazon.gallery.framework.gallery.actions.ImageRewindAction;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.actions.RemoveAction;
import com.amazon.gallery.framework.gallery.actions.UnHideAction;
import com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent;
import com.amazon.gallery.framework.kindle.action.EditMediaItemAction;
import com.amazon.gallery.framework.kindle.action.InfoAction;
import com.amazon.gallery.framework.kindle.action.LockscreenAction;
import com.amazon.gallery.framework.kindle.action.ManualUploadAction;
import com.amazon.gallery.framework.kindle.action.PrintAction;
import com.amazon.gallery.thor.albums.AddToAlbumAction;
import com.amazon.gallery.thor.albums.SetCoverPhotoAction;
import com.amazon.gallery.thor.app.actions.ThorActionFactory;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            MediaItemContextBar, TitleUpdater

public class GalleryContextBar extends MediaItemContextBar
{

    private static final Pair GALLERY_ACTIONS[] = {
        new Pair(com/amazon/gallery/framework/gallery/actions/GenericShareAction, Integer.valueOf(0x7f0c027b)), new Pair(com/amazon/gallery/framework/gallery/actions/RemoveAction, Integer.valueOf(0x7f0c027d)), new Pair(com/amazon/gallery/framework/gallery/actions/DeleteAction, Integer.valueOf(0x7f0c0274)), new Pair(com/amazon/gallery/framework/kindle/action/EditMediaItemAction, Integer.valueOf(0x7f0c0287)), new Pair(com/amazon/gallery/framework/gallery/actions/DownloadAction, Integer.valueOf(0x7f0c0288)), new Pair(com/amazon/gallery/thor/albums/AddToAlbumAction, Integer.valueOf(0x7f0c0277)), new Pair(com/amazon/gallery/framework/kindle/action/ManualUploadAction, Integer.valueOf(0x7f0c0289)), new Pair(com/amazon/gallery/framework/gallery/actions/ImageRewindAction, Integer.valueOf(0x7f0c0280)), new Pair(com/amazon/gallery/framework/kindle/action/PrintAction, Integer.valueOf(0x7f0c028a)), new Pair(com/amazon/gallery/framework/kindle/action/InfoAction, Integer.valueOf(0x7f0c028b)), 
        new Pair(com/amazon/gallery/framework/kindle/action/LockscreenAction, Integer.valueOf(0x7f0c0285)), new Pair(com/amazon/gallery/thor/albums/SetCoverPhotoAction, Integer.valueOf(0x7f0c0286))
    };

    public GalleryContextBar(BeanAwareActivity beanawareactivity, int i, TitleUpdater titleupdater)
    {
        super(beanawareactivity, i, titleupdater);
        titleupdater = getGalleryActions();
        for (i = 0; i < titleupdater.length; i++)
        {
            MediaItemAction mediaitemaction = ThorActionFactory.createThorAction(beanawareactivity, (Class)((Pair) (titleupdater[i])).first);
            mediaitemaction.setActionSource(com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.MULTISELECT);
            addAction(((Integer)((Pair) (titleupdater[i])).second).intValue(), mediaitemaction);
        }

        if (FeatureManager.isFeatureEnabled(Features.HIDE))
        {
            titleupdater = ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/HideAction);
            titleupdater.setActionSource(com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.MULTISELECT);
            addAction(0x7f0c0281, titleupdater);
            beanawareactivity = ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/UnHideAction);
            beanawareactivity.setActionSource(com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.MULTISELECT);
            addAction(0x7f0c0282, beanawareactivity);
        }
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
        return GALLERY_ACTIONS;
    }

    public void onActionCompleteEvent(ActionCompleteEvent actioncompleteevent)
    {
        clearSelectables();
        hide();
    }

    public void onMultiSelectModeCommand(MultiSelectModeCommand multiselectmodecommand)
    {
        handleMultiSelectModeEvent(multiselectmodecommand);
    }

}
