// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.androidviewcontrollers;

import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.amazon.gallery.foundation.ui.controller.androidviewcontroller.AndroidViewController;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.ItemChangeEvent;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.kindle.fragment.AdapterFragment;
import com.amazon.gallery.framework.kindle.fragment.FragmentController;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.ui.cab.GalleryContextBar;

public class SelectionController
    implements AndroidViewController
{

    private GalleryContextBar contextBar;
    private final FragmentController fragmentController;

    public SelectionController(GalleryContextBar gallerycontextbar, FragmentController fragmentcontroller)
    {
        contextBar = gallerycontextbar;
        fragmentController = fragmentcontroller;
    }

    private void updateContextBarData(MediaItem mediaitem, int i)
    {
        if (!contextBar.isSelected(mediaitem))
        {
            contextBar.addSelectable(mediaitem);
        } else
        {
            contextBar.removeSelectable(mediaitem);
        }
        GlobalMessagingBus.post(new ItemChangeEvent(i));
    }

    public boolean onClick(View view, int i)
    {
        if (!FeatureManager.isFeatureEnabled(Features.CONTEXT_BAR))
        {
            return false;
        }
        if (!contextBar.isContextBarActive())
        {
            return false;
        }
        if (!(fragmentController.getFragment() instanceof AdapterFragment))
        {
            return false;
        }
        Object obj = ((AdapterFragment)fragmentController.getFragment()).getAdapter().getItem(i);
        if (obj instanceof MediaItem)
        {
            view = (ItemViewHolder)(ItemViewHolder)view.getTag();
            if (((ItemViewHolder) (view)).badges != null)
            {
                ((ItemViewHolder) (view)).badges.setBadgeToggleTime(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.SELECTED, SystemClock.uptimeMillis());
            }
            updateContextBarData((MediaItem)obj, i);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onLongClick(View view, int i)
    {
        if (!FeatureManager.isFeatureEnabled(Features.CONTEXT_BAR) || !contextBar.isContextBarActive())
        {
            if (!(fragmentController.getFragment() instanceof AdapterFragment))
            {
                return false;
            }
            Object obj = ((AdapterFragment)fragmentController.getFragment()).getAdapter().getItem(i);
            if (obj instanceof MediaItem)
            {
                GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.TAP));
                view = (ItemViewHolder)(ItemViewHolder)view.getTag();
                if (((ItemViewHolder) (view)).badges != null)
                {
                    ((ItemViewHolder) (view)).badges.setBadgeToggleTime(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.SELECTED, SystemClock.uptimeMillis());
                }
                updateContextBarData((MediaItem)obj, i);
                return true;
            }
        }
        return false;
    }
}
