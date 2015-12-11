// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package co.vine.android:
//            HomeTabActivity

class <init> extends BroadcastReceiver
{

    final HomeTabActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        int i = intent.getIntExtra("messages_count", 0);
        int j = intent.getIntExtra("notifications_count", 0);
        HomeTabActivity.access$002(HomeTabActivity.this, j);
        HomeTabActivity.access$102(HomeTabActivity.this, i);
        HomeTabActivity.access$200(HomeTabActivity.this);
        invalidateActivityBadge();
    }

    ()
    {
        this$0 = HomeTabActivity.this;
        super();
    }
}
