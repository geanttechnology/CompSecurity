// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            f, PostActivity

class a extends f
{

    final PostActivity a;

    public void onClick(View view)
    {
        a.a((TextView)view);
    }

    (PostActivity postactivity, String s)
    {
        a = postactivity;
        super(postactivity, s);
    }
}
