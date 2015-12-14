// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.c;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            i, PostCommentActivity

class a extends i
{

    final long a;
    final PostCommentActivity b;

    public void onClick(View view)
    {
        c.a(b, "Comment", a);
    }

    (PostCommentActivity postcommentactivity, String s, long l)
    {
        b = postcommentactivity;
        a = l;
        super(postcommentactivity, s);
    }
}
