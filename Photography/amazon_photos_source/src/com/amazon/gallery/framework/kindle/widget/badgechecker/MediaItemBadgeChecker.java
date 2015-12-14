// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget.badgechecker;

import android.view.View;
import com.amazon.gallery.foundation.utils.featuremanager.FeatureManager;
import com.amazon.gallery.foundation.utils.featuremanager.Features;
import com.amazon.gallery.framework.data.store.LenticularHelper;
import com.amazon.gallery.framework.model.media.GroupType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.SyncState;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget.badgechecker:
//            BadgeChecker

public class MediaItemBadgeChecker extends BadgeChecker
{

    private boolean isSyncStateBadgingEnabled;

    public MediaItemBadgeChecker()
    {
        isSyncStateBadgingEnabled = true;
    }

    public Set getBadgesForView(MediaItem mediaitem, View view)
    {
        view = super.getBadgesForView(mediaitem, view);
        if (!isSyncStateBadgingEnabled) goto _L2; else goto _L1
_L1:
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$SyncState = new int[SyncState.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_AUTO.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_MANUAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNCING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNC_ERROR_TERMINAL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNC_ERROR_TRANSIENT_AUTO.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SKIPPED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.NOT_SYNCED.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNC_ERROR_TRANSIENT_MANUAL.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.model.media.SyncState[mediaitem.getSyncState().ordinal()];
        JVM INSTR tableswitch 1 8: default 72
    //                   1 124
    //                   2 124
    //                   3 124
    //                   4 137
    //                   5 137
    //                   6 150
    //                   7 150
    //                   8 150;
           goto _L3 _L4 _L4 _L4 _L5 _L5 _L6 _L6 _L6
_L3:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_150;
_L2:
        if (LenticularHelper.isLenticular(mediaitem.getName()))
        {
            view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.LENTICULAR);
        } else
        if (GroupType.REWIND == mediaitem.getGroupType())
        {
            view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.REWIND);
        }
        if (FeatureManager.isFeatureEnabled(Features.HIDE) && mediaitem.isHidden())
        {
            view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.HIDDEN);
        }
        return view;
_L4:
        view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.UPLOADING_NO_PROGRESS);
          goto _L2
_L5:
        view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.NOT_UPLOADED);
          goto _L2
        view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.DEVICE);
          goto _L2
    }

    public volatile Set getBadgesForView(Object obj, View view)
    {
        return getBadgesForView((MediaItem)obj, view);
    }

    public void setSyncStateBadgingEnabled(boolean flag)
    {
        isSyncStateBadgingEnabled = flag;
    }
}
