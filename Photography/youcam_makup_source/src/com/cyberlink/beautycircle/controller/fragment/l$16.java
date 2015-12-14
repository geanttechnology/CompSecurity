// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.i;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            l

class a
    implements android.view.OnClickListener
{

    final l a;

    public void onClick(View view)
    {
        view = a;
        view.t = ((l) (view)).t + 1L;
        c.a(a.getActivity(), com.cyberlink.beautycircle.model.network.rkUser.UserListType.g, null, null);
        b.a(new i("beautyist"));
    }

    .UserListType(l l1)
    {
        a = l1;
        super();
    }
}
