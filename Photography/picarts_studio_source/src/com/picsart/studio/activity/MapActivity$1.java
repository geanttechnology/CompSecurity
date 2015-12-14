// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.activity;

import android.view.View;
import android.widget.AdapterView;
import com.picsart.studio.utils.d;
import com.picsart.studio.utils.e;

// Referenced classes of package com.picsart.studio.activity:
//            MapActivity, a

final class a
    implements android.widget.ItemClickListener
{

    private MapActivity a;

    public final void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (d)MapActivity.a(a).getItem(i);
        MapActivity.a(a, ((d) (adapterview)).b, ((d) (adapterview)).d.a, ((d) (adapterview)).d.b, ((d) (adapterview)).h);
        a.finish();
    }

    ener(MapActivity mapactivity)
    {
        a = mapactivity;
        super();
    }
}
