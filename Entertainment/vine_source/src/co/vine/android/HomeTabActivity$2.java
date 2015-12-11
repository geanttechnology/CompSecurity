// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.widget.tabs.TabInfo;
import co.vine.android.widget.tabs.TabsAdapter;

// Referenced classes of package co.vine.android:
//            HomeTabActivity, ExploreFragment

class <init> extends BroadcastReceiver
{

    final HomeTabActivity this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = HomeTabActivity.access$300(HomeTabActivity.this).getTab(2);
        if (context != null)
        {
            context = context.fragment();
            if (context instanceof ExploreFragment)
            {
                ((ExploreFragment)context).reloadWebView();
            }
        }
    }

    o()
    {
        this$0 = HomeTabActivity.this;
        super();
    }
}
