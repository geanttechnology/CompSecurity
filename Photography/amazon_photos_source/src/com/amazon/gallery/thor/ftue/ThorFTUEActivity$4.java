// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.ftue;

import android.support.v4.view.PagerAdapter;
import com.amazon.gallery.foundation.utils.apilevel.BuildFlavors;
import com.amazon.gallery.framework.gallery.ftue.FixedViewPager;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.ftue:
//            ThorFTUEActivity

class this._cls0
    implements Runnable
{

    final ThorFTUEActivity this$0;

    public void run()
    {
        if (BuildFlavors.isAosp() || ThorFTUEActivity.access$1000(ThorFTUEActivity.this).getMarketplace() == com.amazon.gallery.framework.network.http.rest.account.e.CHINA)
        {
            if (ThorFTUEActivity.access$1100(ThorFTUEActivity.this).contains(com.amazon.gallery.framework.kindle.ftue.nt.OrderedFragments.FACEBOOK))
            {
                ThorFTUEActivity.access$1200(ThorFTUEActivity.this).remove(com.amazon.gallery.framework.kindle.ftue.nt.OrderedFragments.FACEBOOK);
                ThorFTUEActivity.access$1300(ThorFTUEActivity.this).remove(ThorFTUEActivity.access$400(ThorFTUEActivity.this));
                ThorFTUEActivity.access$1400(ThorFTUEActivity.this).getAdapter().notifyDataSetChanged();
            }
        } else
        if (!ThorFTUEActivity.access$1500(ThorFTUEActivity.this).contains(com.amazon.gallery.framework.kindle.ftue.nt.OrderedFragments.FACEBOOK))
        {
            ThorFTUEActivity.access$1600(ThorFTUEActivity.this).add(com.amazon.gallery.framework.kindle.ftue.nt.OrderedFragments.FACEBOOK);
            ThorFTUEActivity.access$1700(ThorFTUEActivity.this).add(ThorFTUEActivity.access$400(ThorFTUEActivity.this));
            ThorFTUEActivity.access$1800(ThorFTUEActivity.this).getAdapter().notifyDataSetChanged();
            return;
        }
    }

    iewPager()
    {
        this$0 = ThorFTUEActivity.this;
        super();
    }
}
