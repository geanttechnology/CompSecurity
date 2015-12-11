// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.explore;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.shazam.android.analytics.session.SessionConfigurable;
import com.shazam.android.analytics.session.page.ExplorePage;
import com.shazam.android.analytics.session.page.Page;

// Referenced classes of package com.shazam.android.fragment.explore:
//            b

public class ExploreChartFragment extends b
    implements SessionConfigurable
{

    public ExploreChartFragment()
    {
        super((byte)0);
    }

    private ExploreChartFragment(byte byte0)
    {
    }

    public static Fragment a(String s)
    {
        ExploreChartFragment explorechartfragment = new ExploreChartFragment((byte)0);
        explorechartfragment.setArguments(new Bundle());
        explorechartfragment.getArguments().putString("param_screen_origin", s);
        return explorechartfragment;
    }

    public void configureWith(Page page)
    {
        ((ExplorePage)page).setScreenOrigin(getArguments().getString("param_screen_origin"));
    }
}
