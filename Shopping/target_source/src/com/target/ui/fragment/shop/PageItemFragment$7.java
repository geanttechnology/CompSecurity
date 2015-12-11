// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.model.weeklyad.interfaces.a.b;
import com.target.ui.util.q;
import com.target.ui.view.shop.PageItemLayout;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

class this._cls0
    implements com.target.ui.helper.q.nt._cls7
{

    final PageItemFragment this$0;

    public void a(b b)
    {
        if (PageItemFragment.a(PageItemFragment.this) == null)
        {
            return;
        } else
        {
            q.a(PageItemFragment.TAG, "Error retrieving multi-weekly store slug.");
            return;
        }
    }

    public void a(com.target.ui.helper.q.nt._cls7 _pcls7, List list)
    {
        if (PageItemFragment.a(PageItemFragment.this) != null)
        {
            q.a(PageItemFragment.TAG, "Error retrieving multi-weekly ad page information.");
            if (list.size() > 0)
            {
                PageItemFragment.a(PageItemFragment.this).pageItemLayout.setWeeklyAdData(list);
                return;
            }
        }
    }

    public void a(List list)
    {
        if (PageItemFragment.a(PageItemFragment.this) == null)
        {
            return;
        } else
        {
            PageItemFragment.a(PageItemFragment.this, list);
            PageItemFragment.a(PageItemFragment.this).pageItemLayout.setWeeklyAdData(list);
            return;
        }
    }

    .a.b()
    {
        this$0 = PageItemFragment.this;
        super();
    }
}
