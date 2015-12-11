// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bs, bv, ad, af

public class bc
{
    public static interface a
    {

        public abstract void a(int i);
    }


    bv a;
    String b;
    String c;
    String d;
    int e;

    public bc(bv bv1, String s, String s1, String s2)
    {
        a = bv1;
        b = s;
        c = s1;
        d = s2;
        e = -1;
    }

    public View a(Context context, a a1)
    {
        LinearLayout linearlayout = new LinearLayout(context);
        linearlayout.setBackgroundDrawable(new bs(a.a(bv.d.P), a.a(bv.d.Q)));
        linearlayout.setGravity(1);
        linearlayout.setPadding(5, 5, 5, 5);
        TextView textview = new TextView(context);
        textview.setText(b);
        textview.setTextSize(ad.H());
        textview.setTypeface(Typeface.create("helvetica", 1));
        textview.setEllipsize(android.text.TextUtils.TruncateAt.END);
        textview.setTextColor(a.a(bv.c.g));
        textview.setShadowLayer(1.2F, 1.0F, 1.0F, a.a(bv.c.h));
        textview.setMaxLines(2);
        textview.setPadding(0, 0, 5, 0);
        textview.setGravity(19);
        Object obj = new bs(a.a(bv.d.R), a.a(bv.d.S));
        Object obj1 = new bs(a.a(bv.d.T), a.a(bv.d.U));
        obj = new af(context, c, 100, a, ((android.graphics.drawable.Drawable) (obj)), ((android.graphics.drawable.Drawable) (obj1)));
        ((af) (obj)).setOnClickListener(new android.view.View.OnClickListener(a1) {

            final a a;
            final bc b;

            public void onClick(View view)
            {
                a.a(0);
            }

            
            {
                b = bc.this;
                a = a1;
                super();
            }
        });
        obj1 = new bs(a.a(bv.d.R), a.a(bv.d.S));
        bs bs1 = new bs(a.a(bv.d.T), a.a(bv.d.U));
        obj1 = new af(context, d, 100, a, ((android.graphics.drawable.Drawable) (obj1)), bs1);
        ((af) (obj1)).setOnClickListener(new android.view.View.OnClickListener(a1) {

            final a a;
            final bc b;

            public void onClick(View view)
            {
                a.a(1);
            }

            
            {
                b = bc.this;
                a = a1;
                super();
            }
        });
        a1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        a1.weight = 0.8F;
        linearlayout.addView(textview, a1);
        a1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        a1.gravity = 21;
        linearlayout.addView(((View) (obj)), a1);
        a1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
        a1.gravity = 21;
        a1.leftMargin = 2;
        linearlayout.addView(((View) (obj1)), a1);
        context = new LinearLayout(context);
        context.setPadding(10, 0, 10, 0);
        context.addView(linearlayout, -2, -2);
        return context;
    }
}
