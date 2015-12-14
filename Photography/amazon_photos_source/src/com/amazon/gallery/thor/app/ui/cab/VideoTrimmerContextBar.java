// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.app.Activity;
import android.content.res.Resources;
import android.util.Pair;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.CabVisibilityNotification;
import com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            GalleryContextBar, TitleUpdater

public class VideoTrimmerContextBar extends GalleryContextBar
{
    private static class VideoTrimmerTitleUpdater
        implements TitleUpdater
    {

        private final Activity activity;

        public String getSubTitle(int i)
        {
            return "";
        }

        public String getTitle()
        {
            return activity.getResources().getString(0x7f0e0224);
        }

        public VideoTrimmerTitleUpdater(Activity activity1)
        {
            activity = activity1;
        }
    }


    public VideoTrimmerContextBar(BeanAwareActivity beanawareactivity, int i)
    {
        super(beanawareactivity, i, new VideoTrimmerTitleUpdater(beanawareactivity));
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
        return new Pair[0];
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
}
