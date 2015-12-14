// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.widget.CompoundButton;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.utils.messaging.CabMediaItemEvent;
import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ItemMetadataViewFactory

class val.item
    implements android.widget.angeListener
{

    final ItemMetadataViewFactory this$0;
    final MediaItem val$item;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            GlobalMessagingBus.post(new CabMediaItemEvent(com.amazon.gallery.framework.gallery.utils.messaging.DD, val$item));
            return;
        } else
        {
            GlobalMessagingBus.post(new CabMediaItemEvent(com.amazon.gallery.framework.gallery.utils.messaging.EMOVE, val$item));
            return;
        }
    }

    .Action()
    {
        this$0 = final_itemmetadataviewfactory;
        val$item = MediaItem.this;
        super();
    }
}
