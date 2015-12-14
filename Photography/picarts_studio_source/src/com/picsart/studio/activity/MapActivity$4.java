// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.view.MenuItem;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity, a

final class a
    implements android.support.v4.view..OnActionExpandListener
{

    private MapActivity a;

    public final boolean onMenuItemActionCollapse(MenuItem menuitem)
    {
        if (MapActivity.a(a) != null && MapActivity.a(a).isEmpty())
        {
            MapActivity.a(a, MapActivity.j(a), MapActivity.k(a));
        }
        return true;
    }

    public final boolean onMenuItemActionExpand(MenuItem menuitem)
    {
        return true;
    }

    ctionExpandListener(MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
