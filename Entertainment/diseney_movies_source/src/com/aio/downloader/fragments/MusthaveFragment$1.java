// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aio.downloader.utils.ProgressWheel;

// Referenced classes of package com.aio.downloader.fragments:
//            MusthaveFragment

class this._cls0 extends BroadcastReceiver
{

    final MusthaveFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        MusthaveFragment.access$0(MusthaveFragment.this).setVisibility(0);
    }

    ()
    {
        this$0 = MusthaveFragment.this;
        super();
    }
}
