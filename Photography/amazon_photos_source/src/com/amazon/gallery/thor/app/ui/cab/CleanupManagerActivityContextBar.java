// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.ui.cab;

import android.app.Activity;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.actions.DeleteAction;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.actions.SelectionAction;
import com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.thor.app.actions.ThorActionFactory;
import com.amazon.gallery.thor.app.activity.GalleryActionMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;

// Referenced classes of package com.amazon.gallery.thor.app.ui.cab:
//            MediaItemContextBar, CleanupTitleUpdater

public class CleanupManagerActivityContextBar extends MediaItemContextBar
{

    private final Activity activity;
    private long selectablesFileSize;
    private final CleanupTitleUpdater titleUpdater;

    public CleanupManagerActivityContextBar(BeanAwareActivity beanawareactivity, int i, CleanupTitleUpdater cleanuptitleupdater)
    {
        super(beanawareactivity, i, cleanuptitleupdater);
        selectablesFileSize = 0L;
        titleUpdater = cleanuptitleupdater;
        activity = beanawareactivity;
        beanawareactivity = ThorActionFactory.createThorAction(beanawareactivity, com/amazon/gallery/framework/gallery/actions/DeleteAction);
        beanawareactivity.setActionSource(com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.MULTISELECT);
        addAction(0x7f0c0240, beanawareactivity);
    }

    public void CabMediaItemEvent(CabMediaItemEvent cabmediaitemevent)
    {
        if (cabmediaitemevent.action == com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent.Action.ADD)
        {
            addSelectable(cabmediaitemevent.mediaItem);
            if (!isContextBarActive())
            {
                GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.TAP));
            }
            return;
        } else
        {
            removeSelectable(cabmediaitemevent.mediaItem);
            return;
        }
    }

    protected void executeAction(SelectionAction selectionaction)
    {
        if (selectionaction.getClass() == com/amazon/gallery/framework/gallery/actions/DeleteAction)
        {
            ((DeleteAction)selectionaction).execute(new ArrayList(getSelectables()), false, true, false);
            return;
        } else
        {
            selectionaction.execute(new ArrayList(getSelectables()));
            return;
        }
    }

    public long getSelectablesFileSize()
    {
        return selectablesFileSize;
    }

    public void onMultiSelectModeCommand(MultiSelectModeCommand multiselectmodecommand)
    {
        handleMultiSelectModeEvent(multiselectmodecommand);
    }

    public void setSubtitle()
    {
        selectablesFileSize = 0L;
        for (Iterator iterator = getSelectables().iterator(); iterator.hasNext();)
        {
            MediaItem mediaitem = (MediaItem)iterator.next();
            selectablesFileSize = selectablesFileSize + mediaitem.getSize();
        }

        activity.runOnUiThread(new Runnable() {

            final CleanupManagerActivityContextBar this$0;

            public void run()
            {
                galleryActionMode.setTitle(titleUpdater.getSubTitle(getSelectables().size()));
                galleryActionMode.setSubtitle(FileUtils.byteCountToDisplaySize(selectablesFileSize));
            }

            
            {
                this$0 = CleanupManagerActivityContextBar.this;
                super();
            }
        });
    }


}
