// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import com.cyberlink.beautycircle.i;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a extends DynamicDrawableSpan
{

    final int a;
    final g b;

    public Drawable getDrawable()
    {
        Drawable drawable = b.b.getResources().getDrawable(i.bc_issue_repost);
        if (drawable != null)
        {
            drawable.setBounds(0, 0, a, a);
        }
        return drawable;
    }

    ctivity(g g1, int j, int k)
    {
        b = g1;
        a = k;
        super(j);
    }
}
