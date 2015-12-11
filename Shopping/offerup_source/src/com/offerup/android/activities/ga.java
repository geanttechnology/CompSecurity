// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v4.view.ViewPager;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PrePostingHelpActivity

final class ga
    implements android.view.View.OnClickListener
{

    private PrePostingHelpActivity a;

    ga(PrePostingHelpActivity prepostinghelpactivity)
    {
        a = prepostinghelpactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (a.a < 2)
        {
            view = a.b;
            PrePostingHelpActivity prepostinghelpactivity = a;
            int i = prepostinghelpactivity.a + 1;
            prepostinghelpactivity.a = i;
            view.setCurrentItem(i);
        }
    }
}
