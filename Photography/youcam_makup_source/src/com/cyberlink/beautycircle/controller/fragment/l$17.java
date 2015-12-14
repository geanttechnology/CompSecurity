// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.n;
import com.cyberlink.beautycircle.utility.e;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            l

class a
    implements android.view.OnClickListener
{

    final l a;

    public void onClick(View view)
    {
        l l1 = a;
        l1.s = l1.s + 1L;
        view = (e)view;
        c.a(a.getActivity(), view.getCategoryDefautlType(), view.getCategoryId(), view.getCategoryType(), l.d(a), false, false);
        b.a(new n(Long.toString(view.getCategoryId().longValue())));
        if (view.getCategoryDefautlType().equals("HOW-TO"))
        {
            view.a();
            Globals.b();
        }
    }

    _cls9(l l1)
    {
        a = l1;
        super();
    }
}
