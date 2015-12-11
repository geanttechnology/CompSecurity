// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.d;

import android.widget.RatingBar;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.g.d:
//            d

final class e
    implements android.widget.RatingBar.OnRatingBarChangeListener
{

    private String a[];
    private d b;

    e(d d1, String as[])
    {
        b = d1;
        a = as;
        super();
    }

    public final void onRatingChanged(RatingBar ratingbar, float f, boolean flag)
    {
        d.a(b);
        int i = (int)f;
        if (i > 0 && i <= 5)
        {
            d.b(b).setText(a[i - 1]);
        }
    }
}
