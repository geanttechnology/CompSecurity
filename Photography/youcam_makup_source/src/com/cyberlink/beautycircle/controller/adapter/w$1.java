// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.model.UserInfo;
import com.cyberlink.beautycircle.utility.q;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            w

class a
    implements q
{

    final View a;
    final w b;

    public void a()
    {
        a.performClick();
    }

    public void a(UserInfo userinfo, boolean flag)
    {
        b.notifyDataSetChanged();
    }

    (w w1, View view)
    {
        b = w1;
        a = view;
        super();
    }
}
