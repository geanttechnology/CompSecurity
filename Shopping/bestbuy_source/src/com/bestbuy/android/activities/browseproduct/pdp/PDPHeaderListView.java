// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bx;
import by;

public class PDPHeaderListView extends RelativeLayout
{

    private InternalListView a;
    private by b;
    private RelativeLayout c;
    private FrameLayout d;

    public PDPHeaderListView(Context context)
    {
        super(context);
        a(context, null);
    }

    public PDPHeaderListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    private float a(float f)
    {
        return TypedValue.applyDimension(1, f, getContext().getResources().getDisplayMetrics());
    }

    public static by a(PDPHeaderListView pdpheaderlistview)
    {
        return pdpheaderlistview.b;
    }

    private void a(Context context, AttributeSet attributeset)
    {
        a = new InternalListView(getContext(), attributeset);
        attributeset = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        attributeset.addRule(10);
        a.setLayoutParams(attributeset);
        a.setOnScrollListener(new bx(this));
        a.setVerticalScrollBarEnabled(false);
        a.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PDPHeaderListView a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (PDPHeaderListView.a(a) != null)
                {
                    PDPHeaderListView.a(a).onItemClick(adapterview, view, i, l);
                }
            }

            
            {
                a = PDPHeaderListView.this;
                super();
            }
        });
        addView(a);
        c = new RelativeLayout(getContext());
        attributeset = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        attributeset.addRule(10);
        c.setLayoutParams(attributeset);
        c.setGravity(80);
        addView(c);
        attributeset = getResources().getDrawable(0x7f020178);
        d = new FrameLayout(getContext());
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(attributeset.getIntrinsicWidth(), -1);
        layoutparams.addRule(11);
        layoutparams.rightMargin = (int)a(2.0F);
        d.setLayoutParams(layoutparams);
        context = new ImageView(context);
        context.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        context.setImageDrawable(attributeset);
        context.setScaleType(android.widget.ImageView.ScaleType.FIT_XY);
        d.addView(context);
        addView(d);
    }

    public static InternalListView b(PDPHeaderListView pdpheaderlistview)
    {
        return pdpheaderlistview.a;
    }

    public static RelativeLayout c(PDPHeaderListView pdpheaderlistview)
    {
        return pdpheaderlistview.c;
    }

    public static FrameLayout d(PDPHeaderListView pdpheaderlistview)
    {
        return pdpheaderlistview.d;
    }

    public void setAdapter(by by)
    {
        b = by;
        a.setAdapter(by);
    }

    private class InternalListView extends ListView
    {

        final PDPHeaderListView a;

        public int computeVerticalScrollExtent()
        {
            return super.computeVerticalScrollExtent();
        }

        public int computeVerticalScrollOffset()
        {
            return super.computeVerticalScrollOffset();
        }

        public int computeVerticalScrollRange()
        {
            return super.computeVerticalScrollRange();
        }

        public InternalListView(Context context, AttributeSet attributeset)
        {
            a = PDPHeaderListView.this;
            super(context, attributeset);
        }
    }

}
