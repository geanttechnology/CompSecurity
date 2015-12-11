// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import com.smule.android.c.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity

class a
    implements android.view.dListener
{

    final ProductListActivity a;

    public boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        ProductListActivity.h(a);
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        ((DrawerLayout)a.findViewById(0x7f0a016b)).closeDrawer(0x800003);
        com.smule.pianoandroid.magicpiano.ProductListActivity.a(a, true);
        com.smule.android.c.a.a();
        a.findViewById(0x7f0a00a9).setVisibility(0);
        return true;
    }

    (ProductListActivity productlistactivity)
    {
        a = productlistactivity;
        super();
    }
}
