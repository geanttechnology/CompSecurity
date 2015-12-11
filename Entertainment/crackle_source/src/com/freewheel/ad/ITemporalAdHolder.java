// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import tv.freewheel.ad.interfaces.IEvent;

// Referenced classes of package com.freewheel.ad:
//            IAdHolder

public interface ITemporalAdHolder
    extends IAdHolder
{

    public abstract void onAdStarted(IEvent ievent);

    public abstract void onRequestContentVideoPause(IEvent ievent);

    public abstract void onRequestContentVideoResume(IEvent ievent);

    public abstract void onSlotEnded(IEvent ievent);
}
