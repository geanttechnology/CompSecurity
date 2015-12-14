// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.os.AsyncTask;
import android.support.v7.widget.SearchView;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity

final class a
    implements android.support.v7.widget.ueryTextListener
{

    private MapActivity a;

    public final boolean onQueryTextChange(String s)
    {
        boolean flag = false;
        if (!s.isEmpty())
        {
            if (MapActivity.l(a) != null && MapActivity.l(a).getStatus() != android.os.us.FINISHED)
            {
                MapActivity.l(a).cancel(true);
            }
            MapActivity.a(a, MapActivity.j(a), MapActivity.k(a), s, false);
            flag = true;
        }
        return flag;
    }

    public final boolean onQueryTextSubmit(String s)
    {
        MapActivity.i(a).clearFocus();
        MapActivity.a(a, MapActivity.j(a), MapActivity.k(a), s, true);
        return false;
    }

    ryTextListener(MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
