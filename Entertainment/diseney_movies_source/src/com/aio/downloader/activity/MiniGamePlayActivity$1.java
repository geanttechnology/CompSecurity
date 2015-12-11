// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.os.Looper;
import com.aio.downloader.utils.Player;

// Referenced classes of package com.aio.downloader.activity:
//            MiniGamePlayActivity

class this._cls0
    implements Runnable
{

    final MiniGamePlayActivity this$0;

    public void run()
    {
        Looper.prepare();
        if (!MiniGamePlayActivity.access$3(MiniGamePlayActivity.this).equals(""))
        {
            MiniGamePlayActivity.access$4(MiniGamePlayActivity.this).playUrl(MiniGamePlayActivity.access$3(MiniGamePlayActivity.this));
        }
    }

    ()
    {
        this$0 = MiniGamePlayActivity.this;
        super();
    }
}
