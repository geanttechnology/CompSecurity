// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            w, v, u

class a
    implements android.view..OnClickListener
{

    final w a;

    public void onClick(View view)
    {
        if (a.a != null && a.a.a != null)
        {
            c.a(a.c.getActivity(), a.a.a.id, com.cyberlink.beautycircle.model.bItem.MeListMode.a);
        }
    }

    de(w w1)
    {
        a = w1;
        super();
    }
}
