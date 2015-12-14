// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.support.v7.widget.SearchView;
import android.view.View;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity

final class a
    implements android.view.stener
{

    private MapActivity a;

    public final void onClick(View view)
    {
        MapActivity.h(a);
        MapActivity.i(a).setQuery("", false);
    }

    (MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
