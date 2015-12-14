// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.common.event:
//            EventRecorder, BaseEvent

class LogCatEventRecorder
    implements EventRecorder
{

    LogCatEventRecorder()
    {
    }

    public void record(BaseEvent baseevent)
    {
        MoPubLog.d(baseevent.toString());
    }
}
