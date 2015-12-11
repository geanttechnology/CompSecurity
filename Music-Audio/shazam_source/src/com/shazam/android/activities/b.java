// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.shazam.android.aspects.c.a.a;

public abstract class b extends com.shazam.android.aspects.c.a.a
{
    protected static interface a
    {

        public static final a a = (a)com.shazam.b.b.a(com/shazam/android/activities/b$a);

        public abstract void a();

    }


    private static final android.view.View.OnClickListener g = new android.view.View.OnClickListener() {

        public final void onClick(View view)
        {
        }

    };
    public TextView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public boolean e;
    public a f;
    private FrameLayout h;
    private final android.view.View.OnClickListener i = new android.view.View.OnClickListener() {

        final b a;

        public final void onClick(View view)
        {
            if (com.shazam.android.activities.b.a(a))
            {
                a.finish();
            }
        }

            
            {
                a = b.this;
                super();
            }
    };
    private final android.view.View.OnClickListener j = new android.view.View.OnClickListener() {

        final b a;

        public final void onClick(View view)
        {
            a.finish();
        }

            
            {
                a = b.this;
                super();
            }
    };
    private final android.view.View.OnClickListener k = new android.view.View.OnClickListener() {

        final b a;

        public final void onClick(View view)
        {
            a.finish();
        }

            
            {
                a = b.this;
                super();
            }
    };

    public b()
    {
        e = true;
    }

    static boolean a(b b1)
    {
        return b1.e;
    }

    public final void a(int l)
    {
        d.setText(l);
    }

    public final void a(android.view.View.OnClickListener onclicklistener)
    {
        b.setOnClickListener(new com.shazam.android.ad.d.a(new android.view.View.OnClickListener[] {
            onclicklistener, i
        }));
    }

    public final void b(int l)
    {
        h.removeAllViews();
        getLayoutInflater().inflate(l, h);
    }

    public final void b(android.view.View.OnClickListener onclicklistener)
    {
        a.setOnClickListener(new com.shazam.android.ad.d.a(new android.view.View.OnClickListener[] {
            onclicklistener, j
        }));
    }

    public final void c(int l)
    {
        a.setText(l);
    }

    public final void c(android.view.View.OnClickListener onclicklistener)
    {
        c.setOnClickListener(new com.shazam.android.ad.d.a(new android.view.View.OnClickListener[] {
            onclicklistener, k
        }));
    }

    public final void d(int l)
    {
        b.setText(l);
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        f.a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(0x7f020011);
        setFinishOnTouchOutside(false);
        com.shazam.android.activities.c.a.a(this);
        setContentView(0x7f03001b);
        h = (FrameLayout)findViewById(0x7f1100bf);
        a = (TextView)findViewById(0x7f1100c1);
        b = (TextView)findViewById(0x7f1100c0);
        c = (TextView)findViewById(0x7f1100c2);
        d = (TextView)findViewById(0x7f1100be);
        b(g);
        a(g);
        c(g);
        f = com.shazam.android.activities.a.a;
    }

}
