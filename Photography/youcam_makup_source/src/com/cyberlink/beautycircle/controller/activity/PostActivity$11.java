// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, g

class a
    implements android.view.ener
{

    final PostActivity a;

    public void onClick(View view)
    {
        view = (g)PostActivity.e(a).get(Integer.valueOf(PostActivity.d(a)));
        if (view != null)
        {
            g.c(view);
        }
    }

    (PostActivity postactivity)
    {
        a = postactivity;
        super();
    }
}
