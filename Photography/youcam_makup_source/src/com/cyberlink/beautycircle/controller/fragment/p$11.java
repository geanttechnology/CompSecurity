// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.UserInfo;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            p

class a
    implements android.view.OnClickListener
{

    final p a;

    public void onClick(View view)
    {
        view = a.getActivity();
        if (view == null)
        {
            return;
        } else
        {
            c.a(view, p.e(a).avatarUrl, p.e(a).displayName, p.e(a).description, p.h(a), p.e(a).websiteUrl, Long.valueOf(p.e(a).id));
            return;
        }
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
