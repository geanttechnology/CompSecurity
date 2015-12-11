// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.support.v4.view.ViewPager;
import java.util.HashMap;

// Referenced classes of package com.bitstrips.imoji.ui:
//            ImojiBrowserTabLayout

class this._cls0
    implements android.support.design.widget.istener
{

    final ImojiBrowserTabLayout this$0;

    public void onTabReselected(android.support.design.widget.istener istener)
    {
        if (istener.n() == -1)
        {
            return;
        } else
        {
            istener.n(((Integer)selectedTabIcons.get(Integer.valueOf(istener.n()))).intValue());
            return;
        }
    }

    public void onTabSelected(android.support.design.widget.n n)
    {
        if (n.n() == -1)
        {
            return;
        } else
        {
            n.n(((Integer)selectedTabIcons.get(Integer.valueOf(n.n()))).intValue());
            viewPager.setCurrentItem(n.n());
            return;
        }
    }

    public void onTabUnselected(android.support.design.widget.n n)
    {
        if (n.n() == -1)
        {
            return;
        } else
        {
            n.n(((Integer)unselectedTabIcons.get(Integer.valueOf(n.n()))).intValue());
            return;
        }
    }

    lectedListener()
    {
        this$0 = ImojiBrowserTabLayout.this;
        super();
    }
}
