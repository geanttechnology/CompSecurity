// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import android.view.View;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.view.widgetpool.common.UICImageView;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a, n

class b
    implements android.view..OnLongClickListener
{

    final Post a;
    final UICImageView b;
    final a c;

    public boolean onLongClick(View view)
    {
        if (c.h != null)
        {
            c.h.a(a);
            b.setOnClickListener(null);
        }
        return false;
    }

    UICImageView(a a1, Post post, UICImageView uicimageview)
    {
        c = a1;
        a = post;
        b = uicimageview;
        super();
    }
}
