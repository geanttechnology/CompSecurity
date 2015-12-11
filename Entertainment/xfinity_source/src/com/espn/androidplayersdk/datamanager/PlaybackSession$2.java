// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import android.os.Looper;

// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            PlaybackSession

class this._cls0
    implements Runnable
{

    final PlaybackSession this$0;

    public void run()
    {
        Looper.myLooper().quit();
    }

    ()
    {
        this$0 = PlaybackSession.this;
        super();
    }
}
