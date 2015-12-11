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
//            RingtoneSearchFragment

class this._cls0 extends BroadcastReceiver
{

    final RingtoneSearchFragment this$0;

    public void onReceive(Context context, Intent intent)
    {
        RingtoneSearchFragment.access$5(RingtoneSearchFragment.this).clear();
        ((RelativeLayout)RingtoneSearchFragment.access$6(RingtoneSearchFragment.this).findViewById(0x7f0701db)).setVisibility(8);
        RingtoneSearchFragment.access$6(RingtoneSearchFragment.this).setVisibility(8);
        (new a1(RingtoneSearchFragment.this)).execute(new Void[0]);
    }

    a1()
    {
        this$0 = RingtoneSearchFragment.this;
        super();
    }
}
