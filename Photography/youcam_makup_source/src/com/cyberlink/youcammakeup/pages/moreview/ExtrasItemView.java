// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cyberlink.youcammakeup.j;

public class ExtrasItemView extends RelativeLayout
{

    protected final Context a;
    protected TextView b;
    protected TextView c;
    protected ImageView d;
    protected ImageView e;
    protected String f;
    protected Drawable g;
    protected ColorStateList h;
    protected int i;

    public ExtrasItemView(Context context)
    {
        super(context);
        a = context;
        a();
    }

    public ExtrasItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        attributeset = context.obtainStyledAttributes(attributeset, j.ExtrasItemViewArgs);
        f = attributeset.getString(0);
        i = attributeset.getInteger(2, 1);
        g = attributeset.getDrawable(1);
        h = attributeset.getColorStateList(3);
        a = context;
        a();
        attributeset.recycle();
    }

    public ExtrasItemView(Context context, AttributeSet attributeset, int k)
    {
        super(context, attributeset, k);
        attributeset = context.obtainStyledAttributes(attributeset, j.ExtrasItemViewArgs);
        f = attributeset.getString(0);
        i = attributeset.getInteger(2, 1);
        g = attributeset.getDrawable(1);
        h = attributeset.getColorStateList(3);
        a = context;
        a();
        attributeset.recycle();
    }

    protected void a()
    {
        View view = ((LayoutInflater)a.getSystemService("layout_inflater")).inflate(0x7f0301e8, this);
        b = (TextView)view.findViewById(0x7f0c087d);
        c = (TextView)view.findViewById(0x7f0c087e);
        d = (ImageView)view.findViewById(0x7f0c087c);
        e = (ImageView)view.findViewById(0x7f0c087f);
        b.setText(f);
        b.setTextColor(h);
        d.setImageDrawable(g);
        c.setVisibility(8);
        c.setTextColor(h);
    }

    public void setNewIconVisibility(int k)
    {
        e.setVisibility(k);
    }

    public void setQuantity(int k)
    {
        c.setVisibility(0);
        c.setText((new StringBuilder()).append(" (").append(k).append(")").toString());
    }
}
