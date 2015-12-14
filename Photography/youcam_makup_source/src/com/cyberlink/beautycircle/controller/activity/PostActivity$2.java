// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            f, PostActivity

class a extends f
{

    final long a;
    final PostActivity b;

    public void onClick(View view)
    {
        c.a(b, "Comment", a);
    }

    (PostActivity postactivity, String s, long l)
    {
        b = postactivity;
        a = l;
        super(postactivity, s);
    }
}
