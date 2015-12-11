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
//            ap

final class aq
    implements android.view.View.OnClickListener
{

    private int a;
    private ap b;

    aq(ap ap1, int i)
    {
        b = ap1;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        TextView textview = (TextView)view.findViewById(0x7f1002b2);
        view = (RadioButton)view.findViewById(0x7f1002b1);
        ap.a(b).setChecked(false);
        ap.c(b).setTextColor(ap.b(b).getResources().getColor(0x7f0e00e9));
        ap.c(b).setTypeface(Typeface.DEFAULT);
        b.notifyDataSetChanged();
        view.setChecked(true);
        textview.setTextColor(ap.b(b).getResources().getColor(0x7f0e0114));
        textview.setTypeface(Typeface.DEFAULT_BOLD);
        ap.a(b, a);
        ap.a(b, view);
        ap.a(b, textview);
    }
}
