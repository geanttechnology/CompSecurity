// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Post;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a

class a
    implements android.view..OnClickListener
{

    final Post a;
    final a b;

    public void onClick(View view)
    {
        c.a(b.c, a, true, b, 4, b.j);
        view = b;
        view.d = ((a) (view)).d + 1L;
    }

    (a a1, Post post)
    {
        b = a1;
        a = post;
        super();
    }
}
