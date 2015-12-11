// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.ProgressDialog;
import android.support.v4.e.a;
import android.view.View;
import com.offerup.android.dto.Item;
import com.offerup.android.dto.Person;
import com.offerup.android.g.d.d;

// Referenced classes of package com.offerup.android.activities:
//            RatingActivity, gq

final class gn
    implements android.view.View.OnClickListener
{

    private RatingActivity a;

    gn(RatingActivity ratingactivity)
    {
        a = ratingactivity;
        super();
    }

    public final void onClick(View view)
    {
        int i;
label0:
        {
            i = com.offerup.android.activities.RatingActivity.a(a).a();
            if (i != 0)
            {
                a.g = ProgressDialog.show(a, "", "Loading...");
                if (!RatingActivity.b(a))
                {
                    break label0;
                }
                android.support.v4.e.a.a(RatingActivity.c(a).getId(), com.offerup.android.activities.RatingActivity.d(a).getId(), i, new gq(a, false, i));
            }
            return;
        }
        android.support.v4.e.a.a(RatingActivity.c(a).getId(), RatingActivity.c(a).getOwner().getId(), i, new gq(a, false, i));
    }
}
