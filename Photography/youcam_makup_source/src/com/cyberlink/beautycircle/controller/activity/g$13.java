// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class a
    implements android.view.OnClickListener
{

    final g a;

    public void onClick(View view)
    {
        if (g.a(a) != null && g.a(a).creator != null)
        {
            c.a(a.b, g.a(a).creator.userId, com.cyberlink.beautycircle.model.Item.MeListMode.a);
        }
    }

    e(g g1)
    {
        a = g1;
        super();
    }
}
