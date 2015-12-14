// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.perfectcorp.utility.h;

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
            p.a(a, h.a(view));
            DialogUtils.a(view, 48130, 48131, p.p(a));
            return;
        }
    }

    _cls9(p p1)
    {
        a = p1;
        super();
    }
}
