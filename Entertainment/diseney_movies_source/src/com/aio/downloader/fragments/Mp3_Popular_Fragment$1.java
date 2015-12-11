// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.aio.downloader.utils.ProgressWheel;

// Referenced classes of package com.aio.downloader.fragments:
//            Mp3_Popular_Fragment

class this._cls0 extends BroadcastReceiver
{

    final Mp3_Popular_Fragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        Mp3_Popular_Fragment.access$0(Mp3_Popular_Fragment.this).setVisibility(0);
    }

    _cls9()
    {
        this$0 = Mp3_Popular_Fragment.this;
        super();
    }
}
