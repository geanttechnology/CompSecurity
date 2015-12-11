// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

class this._cls0
    implements IEventListener
{

    final VideoPlayerActivity this$0;

    public void run(IEvent ievent)
    {
        onRequestContentVideoResume(ievent);
    }

    r()
    {
        this$0 = VideoPlayerActivity.this;
        super();
    }
}
