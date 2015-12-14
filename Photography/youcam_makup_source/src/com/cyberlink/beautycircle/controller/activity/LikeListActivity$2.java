// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Creator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            LikeListActivity

class a
    implements android.view.r
{

    final Creator a;
    final LikeListActivity b;

    public void onClick(View view)
    {
        c.a(b, a.userId, com.cyberlink.beautycircle.model.e.a);
    }

    (LikeListActivity likelistactivity, Creator creator)
    {
        b = likelistactivity;
        a = creator;
        super();
    }
}
