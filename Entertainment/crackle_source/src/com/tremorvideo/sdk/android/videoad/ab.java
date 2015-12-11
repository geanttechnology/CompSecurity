// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            al, bv, ad, af

public class ab extends Dialog
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/tremorvideo/sdk/android/videoad/ab$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("Confirm", 0);
            b = new a("ConfirmCancel", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int j)
        {
            super(s, j);
        }
    }

    public static interface b
    {

        public abstract void a(boolean flag);
    }


    BroadcastReceiver a;
    private Bitmap b[];
    private Bitmap c[];
    private bv d;
    private TextView e;
    private TextView f;
    private af g;
    private af h;
    private b i;

    public ab(Context context, bv bv1, a a1, b b1)
    {
        super(context);
        b = null;
        c = null;
        a = new BroadcastReceiver() {

            final ab a;

            public void onReceive(Context context1, Intent intent)
            {
                ab.a(a);
            }

            
            {
                a = ab.this;
                super();
            }
        };
        getContext().registerReceiver(a, new IntentFilter("android.intent.action.SCREEN_OFF"));
        d = bv1;
        i = b1;
        a(bv1);
        requestWindowFeature(1);
        context = new al(b, d.a(bv.c.f));
        getWindow().setBackgroundDrawable(context);
        setContentView(a(a1), new android.widget.LinearLayout.LayoutParams(-2, -2));
    }

    private View a(View view, View view1, Context context)
    {
        context = new LinearLayout(context);
        context.setGravity(5);
        if (view1 != null)
        {
            android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-2, -2);
            layoutparams.setMargins(10, 10, 10, 10);
            context.addView(view1, layoutparams);
        }
        if (view != null)
        {
            view1 = new android.widget.LinearLayout.LayoutParams(-2, -2);
            view1.setMargins(0, 10, 10, 10);
            context.addView(view, view1);
        }
        return context;
    }

    private View a(a a1)
    {
        LinearLayout linearlayout = new LinearLayout(getContext());
        linearlayout.setOrientation(1);
        e = new TextView(getContext());
        e.setText("");
        e.setPadding(10, 5, 10, 5);
        e.setTextColor(d.a(bv.c.i));
        e.setTextSize(2, ad.G());
        g = new af(getContext(), "", d, bv.d.N, bv.d.O);
        g.setId(45);
        g.setFocusable(true);
        g.setOnClickListener(new android.view.View.OnClickListener() {

            final ab a;

            public void onClick(View view)
            {
                a.dismiss();
                ab.b(a).a(false);
            }

            
            {
                a = ab.this;
                super();
            }
        });
        if (a1 == a.b)
        {
            h = new af(getContext(), "", d, bv.d.N, bv.d.O);
            h.setId(46);
            h.setFocusable(true);
            h.setOnClickListener(new android.view.View.OnClickListener() {

                final ab a;

                public void onClick(View view)
                {
                    a.dismiss();
                    ab.b(a).a(true);
                }

            
            {
                a = ab.this;
                super();
            }
            });
        }
        f = a("", getContext());
        linearlayout.addView(f);
        linearlayout.addView(e);
        linearlayout.addView(a(((View) (g)), ((View) (h)), getContext()));
        return linearlayout;
    }

    private TextView a(String s, Context context)
    {
        context = new TextView(context);
        context.setText(s);
        context.setTextSize(2, ad.F());
        context.setTextColor(d.a(bv.c.g));
        context.setTypeface(Typeface.create("helvetica", 1));
        context.setShadowLayer(5F, 0.0F, 0.0F, d.a(bv.c.h));
        context.setPadding(10, 5, 10, 0);
        return context;
    }

    private void a()
    {
        if (g != null)
        {
            g.a(false);
        }
        if (h != null)
        {
            h.a(false);
        }
    }

    static void a(ab ab1)
    {
        ab1.a();
    }

    private void a(bv bv1)
    {
        b = new Bitmap[al.a.values().length];
        b[al.a.a.ordinal()] = bv1.a(bv.d.y);
        b[al.a.b.ordinal()] = bv1.a(bv.d.z);
        b[al.a.c.ordinal()] = bv1.a(bv.d.A);
        b[al.a.d.ordinal()] = bv1.a(bv.d.B);
        b[al.a.e.ordinal()] = bv1.a(bv.d.C);
        b[al.a.f.ordinal()] = bv1.a(bv.d.D);
        b[al.a.g.ordinal()] = bv1.a(bv.d.E);
        b[al.a.h.ordinal()] = bv1.a(bv.d.F);
        c = new Bitmap[3];
        c[0] = bv1.a(bv.d.K);
        c[1] = bv1.a(bv.d.L);
        c[2] = bv1.a(bv.d.M);
    }

    static b b(ab ab1)
    {
        return ab1.i;
    }

    public void a(String s)
    {
        e.setText(s);
    }

    public void a(String s, String s1)
    {
        if (g != null)
        {
            g.a(s);
        }
        if (h != null)
        {
            h.a(s1);
        }
    }

    public boolean onKeyDown(int j, KeyEvent keyevent)
    {
        if (j == 84)
        {
            return true;
        }
        if (j == 4)
        {
            dismiss();
            keyevent = i;
            boolean flag;
            if (h != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            keyevent.a(flag);
            return true;
        } else
        {
            return super.onKeyDown(j, keyevent);
        }
    }

    protected void onStop()
    {
        super.onStop();
        getContext().unregisterReceiver(a);
    }

    public void setTitle(CharSequence charsequence)
    {
        f.setText(charsequence);
    }
}
