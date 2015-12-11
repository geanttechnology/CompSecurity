// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.view.MenuItem;
import com.comcast.cim.android.view.flow.FilterRequestObserver;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            PlayNowBrowseProgramsFragment

class this._cls0
    implements android.view.
{

    final PlayNowBrowseProgramsFragment this$0;

    public boolean onMenuItemClick(MenuItem menuitem)
    {
        PlayNowBrowseProgramsFragment.access$200(PlayNowBrowseProgramsFragment.this).showFilter(getFilterBundle());
        return false;
    }

    ()
    {
        this$0 = PlayNowBrowseProgramsFragment.this;
        super();
    }
}
