// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.utility.q;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class a extends q
{

    final g a;

    public void onClick(View view)
    {
        if (g.a(a) != null && g.a(a).sourcePostCreator != null)
        {
            c.a(a.b, g.a(a).sourcePostCreator.userId, com.cyberlink.beautycircle.model.Item.MeListMode.a);
        }
    }

    e(g g1)
    {
        a = g1;
        super();
    }
}
