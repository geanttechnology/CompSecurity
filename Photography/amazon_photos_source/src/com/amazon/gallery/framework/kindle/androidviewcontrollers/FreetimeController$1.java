// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.androidviewcontrollers;

import com.amazon.gallery.framework.kindle.action.EditMediaItemAction;
import com.amazon.gallery.framework.model.media.MediaItem;
import java.util.Collections;

// Referenced classes of package com.amazon.gallery.framework.kindle.androidviewcontrollers:
//            FreetimeController

class val.mediaItem
    implements Runnable
{

    final FreetimeController this$0;
    final MediaItem val$mediaItem;

    public void run()
    {
        FreetimeController.access$000(FreetimeController.this).execute(Collections.singletonList(val$mediaItem));
    }

    ()
    {
        this$0 = final_freetimecontroller;
        val$mediaItem = MediaItem.this;
        super();
    }
}
