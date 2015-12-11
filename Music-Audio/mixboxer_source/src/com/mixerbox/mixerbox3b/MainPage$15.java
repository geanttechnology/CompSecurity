// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.mixerbox.mixerbox3b:
//            MainPage

class this._cls0 extends Handler
{

    final MainPage this$0;

    public void handleMessage(Message message)
    {
        playNextSong();
    }

    ()
    {
        this$0 = MainPage.this;
        super();
    }
}
