// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.Settings;
import com.amazon.clouddrive.model.UpdateNodeRequest;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            HideAction

class val.mediaItemList
    implements Runnable
{

    final HideAction this$0;
    final List val$mediaItemList;

    public void run()
    {
        Iterator iterator = val$mediaItemList.iterator();
_L2:
        MediaItem mediaitem;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_199;
        }
        mediaitem = (MediaItem)iterator.next();
        GLogger.d(HideAction.access$000(), "media item is %s and hidden is %s and should hide is %s", new Object[] {
            mediaitem.getName(), Boolean.valueOf(mediaitem.isHidden()), Boolean.valueOf(shouldHide())
        });
        if (MediaItemUtil.isCloudMediaItem(mediaitem))
        {
            UpdateNodeRequest updatenoderequest = new UpdateNodeRequest(IdUtils.objectIdToNodeId(mediaitem.getObjectId().getMostSignificantBits(), mediaitem.getObjectId().getLeastSignificantBits()));
            Settings settings = new Settings();
            settings.setHidden(Boolean.valueOf(shouldHide()));
            updatenoderequest.setSettings(settings);
            cloudDriveServiceClientManager.getForegroundCdsClient().updateNode(updatenoderequest);
        }
        HideAction.access$100(HideAction.this, mediaitem);
        continue; /* Loop/switch isn't completed */
        CloudDriveException clouddriveexception;
        clouddriveexception;
        GLogger.ex(HideAction.access$000(), "Unable to update hidden property for cloud item", clouddriveexception);
        continue; /* Loop/switch isn't completed */
        InterruptedException interruptedexception;
        interruptedexception;
        GLogger.d(HideAction.access$000(), "Unable to update hidden property for cloud item - interrupted", new Object[0]);
        Thread.currentThread().interrupt();
        return;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$0 = final_hideaction;
        val$mediaItemList = List.this;
        super();
    }
}
