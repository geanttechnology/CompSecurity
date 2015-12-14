// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle;

import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadActionEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadControlAction;

// Referenced classes of package com.amazon.gallery.framework.kindle:
//            AutoSaveManagerImpl

class this._cls0
    implements Runnable
{

    final AutoSaveManagerImpl this$0;

    public void run()
    {
        GlobalMessagingBus.post(new UploadActionEvent(QueueType.AUTO_SAVE, UploadControlAction.START, AutoSaveManagerImpl.TAG));
    }

    ingBus()
    {
        this$0 = AutoSaveManagerImpl.this;
        super();
    }
}
