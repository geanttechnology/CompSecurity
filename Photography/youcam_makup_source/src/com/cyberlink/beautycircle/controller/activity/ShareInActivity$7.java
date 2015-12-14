// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.view.PagerAdapter;
import com.cyberlink.beautycircle.utility.x;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements Runnable
{

    final x a;
    final ShareInActivity b;

    public void run()
    {
        ShareInActivity.o(b).add(a);
        com.cyberlink.beautycircle.controller.activity.ShareInActivity.x(b).notifyDataSetChanged();
        ShareInActivity.i(b);
    }

    (ShareInActivity shareinactivity, x x)
    {
        b = shareinactivity;
        a = x;
        super();
    }
}
