// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.multiqueueuploader.ImmediateTriggerListener;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            WhisperUploadService

class this._cls0
    implements ImmediateTriggerListener
{

    final WhisperUploadService this$0;

    public void onTrigger(QueueType queuetype, boolean flag)
    {
        .SwitchMap.com.amazon.gallery.framework.network.multiqueueuploader.QueueType[queuetype.ordinal()];
        JVM INSTR tableswitch 1 3: default 36
    //                   1 66
    //                   2 90
    //                   3 90;
           goto _L1 _L2 _L3 _L3
_L1:
        throw new IllegalArgumentException((new StringBuilder()).append(queuetype.name()).append(" is not a recognized QueueType.").toString());
_L2:
        WhisperUploadService.access$2000(WhisperUploadService.this);
_L5:
        GLogger.d(WhisperUploadService.access$1000(), "onTrigger invoked for queue: %s.", new Object[] {
            queuetype
        });
        return;
_L3:
        WhisperUploadService.access$400(WhisperUploadService.this, flag);
        if (true) goto _L5; else goto _L4
_L4:
    }

    gerListener()
    {
        this$0 = WhisperUploadService.this;
        super();
    }
}
