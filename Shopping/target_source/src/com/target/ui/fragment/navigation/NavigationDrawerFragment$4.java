// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.navigation;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.b;
import android.view.View;
import com.target.ui.analytics.a.ai;
import com.target.ui.analytics.a.ba;

// Referenced classes of package com.target.ui.fragment.navigation:
//            NavigationDrawerFragment

class this._cls0 extends b
{

    final NavigationDrawerFragment this$0;

    public void a(int i)
    {
        super.a(i);
    }

    public void a(View view)
    {
        super.a(view);
        ba.a(NavigationDrawerFragment.this).e();
        ai.a(com.target.ui.analytics.a.gment).e();
    }

    public void b(View view)
    {
        super.b(view);
    }

    (Activity activity, DrawerLayout drawerlayout, int i, int j)
    {
        this$0 = NavigationDrawerFragment.this;
        super(activity, drawerlayout, i, j);
    }
}
