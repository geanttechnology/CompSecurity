// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.model.DiscoverTabItem;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            l

class a
    implements android.view..OnClickListener
{

    final l a;

    public void onClick(View view)
    {
        DiscoverTabItem discovertabitem = (DiscoverTabItem)view.getTag();
        if (discovertabitem != null && discovertabitem.type != null)
        {
            if (discovertabitem.type.equals("BEAUTYIST"))
            {
                l.g(a).onClick(view);
            } else
            {
                if (discovertabitem.type.equals("BRAND"))
                {
                    l.h(a).onClick(view);
                    return;
                }
                if (discovertabitem.type.equals("BEAUTY_TIP"))
                {
                    l.i(a).onClick(view);
                    return;
                }
                if (discovertabitem.type.equals("EDITORIAL"))
                {
                    l.j(a).onClick(view);
                    return;
                }
                if (discovertabitem.type.equals("FREE_SAMPLE"))
                {
                    l.k(a).onClick(view);
                    return;
                }
                if (discovertabitem.type.equals("CONTEST"))
                {
                    l.l(a).onClick(view);
                    return;
                }
            }
        }
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
