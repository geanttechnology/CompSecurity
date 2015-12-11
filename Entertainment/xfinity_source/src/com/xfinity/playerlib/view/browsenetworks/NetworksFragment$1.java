// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browsenetworks;

import android.content.res.Resources;
import android.widget.AbsListView;

// Referenced classes of package com.xfinity.playerlib.view.browsenetworks:
//            NetworksFragment

class this._cls0
    implements android.widget.lListener
{

    final NetworksFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (abslistview.getTag() != null)
        {
            abslistview.setContentDescription(getResources().getString(com.xfinity.playerlib.scription_networks_single_grid, new Object[] {
                abslistview.getTag().toString(), Integer.valueOf(i + 1), Integer.valueOf(i + j), Integer.valueOf(k)
            }));
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    ()
    {
        this$0 = NetworksFragment.this;
        super();
    }
}
