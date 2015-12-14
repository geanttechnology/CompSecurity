// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            i, PostCommentActivity

class a extends i
{

    final PostCommentActivity a;

    public void onClick(View view)
    {
        a.a((TextView)view);
    }

    (PostCommentActivity postcommentactivity, String s)
    {
        a = postcommentactivity;
        super(postcommentactivity, s);
    }
}
