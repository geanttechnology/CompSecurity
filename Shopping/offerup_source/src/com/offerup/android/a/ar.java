// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

// Referenced classes of package com.offerup.android.a:
//            ap, as

final class ar
    implements android.view.View.OnClickListener
{

    private final as a;
    private final int b;
    private ap c;

    public ar(ap ap1, as as1, int i)
    {
        c = ap1;
        super();
        a = as1;
        b = i;
    }

    public final void onClick(View view)
    {
        if (b != ap.d(c) && ap.a(c) != null && ap.c(c) != null)
        {
            ap.a(c).setChecked(false);
            ap.c(c).setTextColor(ap.b(c).getResources().getColor(0x7f0e00e9));
            ap.c(c).setTypeface(Typeface.DEFAULT);
        }
        ap.a(c, b);
        ap.a(c, (RadioButton)view);
        ap.a(c, a.a);
        ap.c(c).setTextColor(ap.b(c).getResources().getColor(0x7f0e0114));
        ap.c(c).setTypeface(Typeface.DEFAULT_BOLD);
        c.notifyDataSetChanged();
    }
}
