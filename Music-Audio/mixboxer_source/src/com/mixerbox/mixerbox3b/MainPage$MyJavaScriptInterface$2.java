// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import com.mixerbox.mixerbox3b.utils.MixerBoxClient;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls1
    implements Runnable
{

    final is._cls0 this$1;

    public void run()
    {
        if (!MixerBoxClient.isConnectingToInternet(_fld0))
        {
            stopPlayer();
            return;
        } else
        {
            playNextSong();
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
