// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import com.xfinity.playerlib.model.EditorialTVSeries;
import it.sephiroth.android.library.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class this._cls0
    implements it.sephiroth.android.library.widget.stener
{

    final TabletFeaturedFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (EditorialTVSeries)adapterview.getItemAtPosition(i);
        showDetail(adapterview.getMerlinId());
    }

    stener()
    {
        this$0 = TabletFeaturedFragment.this;
        super();
    }
}
