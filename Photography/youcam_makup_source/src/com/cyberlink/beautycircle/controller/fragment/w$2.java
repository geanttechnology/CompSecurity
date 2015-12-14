// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Post;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            w, v, u

class a
    implements android.view..OnClickListener
{

    final w a;

    public void onClick(View view)
    {
        if (a.a != null && a.a.b != null)
        {
            c.a(a.c.getActivity(), a.a.b.postId.longValue(), true, 0, null, null);
        }
    }

    (w w1)
    {
        a = w1;
        super();
    }
}
