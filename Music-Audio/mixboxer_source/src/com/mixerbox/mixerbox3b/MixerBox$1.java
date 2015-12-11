// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import com.facebook.Session;
import com.facebook.SessionState;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MixerBox

class this._cls0
    implements com.facebook.tusCallback
{

    final MixerBox this$0;

    public void call(Session session, SessionState sessionstate, Exception exception)
    {
        MixerBox.access$000(MixerBox.this, session, sessionstate, exception);
    }

    ()
    {
        this$0 = MixerBox.this;
        super();
    }
}
