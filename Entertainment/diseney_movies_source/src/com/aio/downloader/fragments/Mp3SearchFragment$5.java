// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import com.aio.downloader.refresh.PullableListView;
import java.util.ArrayList;

// Referenced classes of package com.aio.downloader.fragments:
//            Mp3SearchFragment

class this._cls0 extends BroadcastReceiver
{

    final Mp3SearchFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        Mp3SearchFragment.access$5(Mp3SearchFragment.this).clear();
        ((RelativeLayout)Mp3SearchFragment.access$6(Mp3SearchFragment.this).findViewById(0x7f0701db)).setVisibility(8);
        Mp3SearchFragment.access$6(Mp3SearchFragment.this).setVisibility(8);
        (new a1(Mp3SearchFragment.this)).execute(new Void[0]);
    }

    a1()
    {
        this$0 = Mp3SearchFragment.this;
        super();
    }
}
