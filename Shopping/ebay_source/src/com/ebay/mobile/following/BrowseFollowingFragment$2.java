// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.following;

import android.view.View;
import android.widget.ListView;

// Referenced classes of package com.ebay.mobile.following:
//            BrowseFollowingFragment

class val.headerLayout
    implements Runnable
{

    final BrowseFollowingFragment this$0;
    final View val$headerLayout;

    public void run()
    {
        list.smoothScrollToPositionFromTop(0, -val$headerLayout.getTop());
    }

    _cls9()
    {
        this$0 = final_browsefollowingfragment;
        val$headerLayout = View.this;
        super();
    }
}
