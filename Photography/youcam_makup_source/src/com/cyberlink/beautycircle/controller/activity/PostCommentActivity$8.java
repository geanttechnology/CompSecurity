// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import com.cyberlink.beautycircle.i;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostCommentActivity

class a extends DynamicDrawableSpan
{

    final int a;
    final PostCommentActivity b;

    public Drawable getDrawable()
    {
        Drawable drawable = b.getResources().getDrawable(i.bc_issue_comment_time);
        if (drawable != null)
        {
            drawable.setBounds(0, 0, a, a);
        }
        return drawable;
    }

    (PostCommentActivity postcommentactivity, int j, int k)
    {
        b = postcommentactivity;
        a = k;
        super(j);
    }
}
