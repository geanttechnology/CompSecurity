// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.model.Comment;
import com.cyberlink.beautycircle.model.Creator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            j

class a
    implements android.view..OnClickListener
{

    final Comment a;
    final j b;

    public void onClick(View view)
    {
        c.a(b.a, a.creator.userId, com.cyberlink.beautycircle.model.bItem.MeListMode.a);
    }

    de(j j1, Comment comment)
    {
        b = j1;
        a = comment;
        super();
    }
}
