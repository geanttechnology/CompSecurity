// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PostPostingHelpActivity

final class fv
    implements android.view.View.OnClickListener
{

    private PostPostingHelpActivity a;

    fv(PostPostingHelpActivity postpostinghelpactivity)
    {
        a = postpostinghelpactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (a.a <= 0)
        {
            view = a.b;
            PostPostingHelpActivity postpostinghelpactivity = a;
            int i = postpostinghelpactivity.a + 1;
            postpostinghelpactivity.a = i;
            view.setCurrentItem(i);
        }
    }
}
