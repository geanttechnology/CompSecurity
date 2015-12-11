// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.helpshift.i.f;

// Referenced classes of package com.helpshift.widget:
//            a

public class CSATView extends RelativeLayout
    implements android.widget.RatingBar.OnRatingBarChangeListener
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(int i, String s);
    }


    private com.helpshift.widget.a a;
    private RatingBar b;
    private a c;
    private RelativeLayout d;

    public CSATView(Context context)
    {
        super(context);
        c = null;
        a(context);
    }

    public CSATView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = null;
        a(context);
    }

    public CSATView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = null;
        a(context);
    }

    private void a(Context context)
    {
        View.inflate(context, com.helpshift.b.d.C, this);
        a = new com.helpshift.widget.a(context);
    }

    protected void a()
    {
        setVisibility(8);
        a = null;
        if (c != null)
        {
            c.a();
        }
    }

    protected void a(float f1, String s)
    {
        if (c != null)
        {
            c.a(Math.round(f1), s);
        }
    }

    public void a(int i, int j, int k, int l)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)d.getLayoutParams();
        layoutparams.setMargins(i, j, k, l);
        d.setLayoutParams(layoutparams);
    }

    protected RatingBar getRatingBar()
    {
        return b;
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        b = (RatingBar)findViewById(com.helpshift.b.c.U);
        b.setOnRatingBarChangeListener(this);
        TextView textview = (TextView)findViewById(com.helpshift.b.c.V);
        TextView textview1 = (TextView)findViewById(com.helpshift.b.c.W);
        TextView textview2 = (TextView)findViewById(com.helpshift.b.c.X);
        f.a(textview, 0.5F);
        f.a(textview1, 0.5F);
        f.a(textview2, 0.5F);
        d = (RelativeLayout)findViewById(com.helpshift.b.c.Y);
    }

    public void onRatingChanged(RatingBar ratingbar, float f1, boolean flag)
    {
        if (flag)
        {
            a.a(this);
        }
    }

    public void setCSATListener(a a1)
    {
        c = a1;
    }
}
