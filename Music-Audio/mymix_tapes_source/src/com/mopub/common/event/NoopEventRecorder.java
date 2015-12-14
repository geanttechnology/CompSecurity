// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;


// Referenced classes of package com.mopub.common.event:
//            EventRecorder, BaseEvent

class NoopEventRecorder
    implements EventRecorder
{

    NoopEventRecorder()
    {
    }

    public void record(BaseEvent baseevent)
    {
    }
}
