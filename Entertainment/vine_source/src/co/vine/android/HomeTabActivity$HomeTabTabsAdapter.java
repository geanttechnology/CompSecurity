// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.content.SharedPreferences;
import android.widget.TabHost;
import co.vine.android.util.Util;
import co.vine.android.widget.tabs.TabsAdapter;

// Referenced classes of package co.vine.android:
//            HomeTabActivity

private class this._cls0 extends TabsAdapter
{

    final HomeTabActivity this$0;

    public void onPageSelected(int i)
    {
        super.onPageSelected(i);
        resetNav();
        if (i == 1)
        {
            Util.getDefaultSharedPrefs(getApplicationContext()).edit().xt("unread_notification_count", 0).xt();
            HomeTabActivity.access$002(HomeTabActivity.this, 0);
            invalidateActivityBadge();
        }
    }

    public (TabHost tabhost)
    {
        this$0 = HomeTabActivity.this;
        super(HomeTabActivity.this, tabhost, HomeTabActivity.access$400(HomeTabActivity.this), null);
    }
}
