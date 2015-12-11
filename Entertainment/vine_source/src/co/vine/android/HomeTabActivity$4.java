// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import co.vine.android.util.ConversationMenuHelper;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

// Referenced classes of package co.vine.android:
//            HomeTabActivity

class this._cls0
    implements Runnable
{

    final HomeTabActivity this$0;

    public void run()
    {
        getConversationSlidingMenuHelper().showVmOnboarding();
        getSlidingMenu().toggle(true);
    }

    b.SlidingMenu()
    {
        this$0 = HomeTabActivity.this;
        super();
    }
}
