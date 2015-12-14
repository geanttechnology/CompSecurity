// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand;
import com.amazon.gallery.framework.gallery.actions.ViewDescriptorAction;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.model.media.MediaItem;

public class MultiselectModeAction
    implements ViewDescriptorAction
{

    public MultiselectModeAction()
    {
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        if (viewdescriptor != null) goto _L2; else goto _L1
_L1:
        if (mediaitem != null) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (viewdescriptor.getMediaItem() != null || viewdescriptor.getCollectionSize() == 0)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void executeViewDescriptor(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        GlobalMessagingBus.post(new MultiSelectModeCommand(true, com.amazon.gallery.foundation.utils.messaging.MultiSelectModeCommand.EntranceType.BUTTON));
    }
}
